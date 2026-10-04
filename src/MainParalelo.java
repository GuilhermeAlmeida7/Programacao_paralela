import java.util.Scanner;

public class MainParalelo {

    public static void main(String[] args) {
        // O try-with-resources fecha o Scanner automaticamente no final
        try (Scanner scanner = new Scanner(System.in)) {
            
            System.out.print("Quantos elementos terá o vetor? ");
            int tamanho = Integer.parseInt(scanner.nextLine().trim());
            if (tamanho <= 0) throw new IllegalArgumentException("O tamanho deve ser maior que zero.");

            System.out.print("Preencher (1) à mão ou (2) automaticamente? ");
            int opcao = Integer.parseInt(scanner.nextLine().trim());
            
            byte[] vetor = (opcao == 1) ? Util.lerManual(tamanho) : Util.gerarAleatorio(tamanho);
            System.out.println("[LOG] Vetor criado com " + tamanho + " elementos.");

            long inicio = System.currentTimeMillis();
            byte[] ordenado = OrdenadorParalelo.ordenar(vetor);
            long tempoExecucao = System.currentTimeMillis() - inicio;
            
            System.out.println("[LOG] Ordenação paralela concluída em " + tempoExecucao + " ms.");

            perguntarImpressao(scanner, ordenado);
            
        } catch (NumberFormatException e) {
            System.err.println("[ERRO] Por favor, digite apenas números inteiros.");
        } catch (OutOfMemoryError e) {
            System.err.println("[ERRO] Memória insuficiente. Rode no terminal com: java -Xmx8G MainParalelo");
        } catch (Exception e) {
            System.err.println("[ERRO] " + e.getMessage());
        }
    }

    private static void perguntarImpressao(Scanner scanner, byte[] vetor) {
        System.out.print("Imprimir (1) o vetor todo, (2) um trecho ou (0) nada? ");
        int opcao = Integer.parseInt(scanner.nextLine().trim());

        if (opcao == 1) {
            Util.imprimir(vetor, 0, vetor.length);
        } else if (opcao == 2) {
            System.out.print("Posição inicial: ");
            int de = Integer.parseInt(scanner.nextLine().trim());
            System.out.print("Posição final (exclusiva): ");
            int ate = Integer.parseInt(scanner.nextLine().trim());
            Util.imprimir(vetor, de, ate);
        }
    }
}