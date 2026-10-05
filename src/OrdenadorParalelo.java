import java.util.ArrayList;
import java.util.List;

public class OrdenadorParalelo {

    public static byte[] ordenar(byte[] vetor) {
        if (vetor == null) throw new IllegalArgumentException("O vetor não pode ser nulo.");
        if (vetor.length <= 1) return vetor;

        int nThreads = calcularNumeroDeThreads(vetor.length);
        System.out.println("[LOG] Threads ordenadoras: " + nThreads);

        List<byte[]> partesOrdenadas = iniciarFaseDeOrdenacao(vetor, nThreads);
        return iniciarFaseDeMerge(partesOrdenadas);
    }

    private static int calcularNumeroDeThreads(int tamanhoVetor) {
        int processadores = Runtime.getRuntime().availableProcessors();
        int threadsDisponiveis = Math.max(1, processadores - 1);
        return Math.min(threadsDisponiveis, tamanhoVetor);
    }

    private static List<byte[]> iniciarFaseDeOrdenacao(byte[] vetor, int nThreads) {
        ThreadOrdenadora[] ordenadoras = new ThreadOrdenadora[nThreads];
        int tamanhoBase = vetor.length / nThreads;
        int resto = vetor.length % nThreads;
        int inicio = 0;

        for (int i = 0; i < nThreads; i++) {
            int tamanho = tamanhoBase + (i < resto ? 1 : 0);
            byte[] parte = new byte[tamanho];
            System.arraycopy(vetor, inicio, parte, 0, tamanho);
            inicio += tamanho;
            
            ordenadoras[i] = new ThreadOrdenadora(parte, i);
            ordenadoras[i].start();
        }

        List<byte[]> partes = new ArrayList<>();
        for (ThreadOrdenadora thread : ordenadoras) {
            aguardar(thread);
            partes.add(thread.getResultado());
        }
        return partes;
    }

    private static byte[] iniciarFaseDeMerge(List<byte[]> partes) {
        int rodada = 1;
        
        while (partes.size() > 1) {
            System.out.println("[LOG] Rodada " + rodada + " de merge: " + partes.size() + " vetores.");
            int pares = partes.size() / 2;
            ThreadJuntadora[] juntadoras = new ThreadJuntadora[pares];

            for (int i = 0; i < pares; i++) {
                juntadoras[i] = new ThreadJuntadora(
                    partes.get(2 * i), 
                    partes.get(2 * i + 1), 
                    "Juntadora-R" + rodada + "-" + i
                );
                juntadoras[i].start();
            }

            List<byte[]> proximaRodada = new ArrayList<>();
            for (ThreadJuntadora thread : juntadoras) {
                aguardar(thread);
                proximaRodada.add(thread.getResultado());
            }

            // Se sobrou um vetor ímpar, ele passa direto para a próxima rodada
            if (partes.size() % 2 != 0) {
                proximaRodada.add(partes.get(partes.size() - 1));
            }
            
            partes = proximaRodada;
            rodada++;
        }
        
        return partes.get(0);
    }

    private static void aguardar(Thread thread) {
        try {
            thread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Erro ao aguardar a thread " + thread.getName(), e);
        }
    }
}