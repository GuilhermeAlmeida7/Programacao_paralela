public class MaiorVetorAproximado
{
    public static void main (String[] args)
    {
        int tamanho=1024;
        int maior=0;
        byte[] vetor=null;

        try
        {
            while (true)
            {
                vetor = Util.gerarAleatorio (tamanho);
                maior = tamanho;
                System.out.println ("Conseguiu criar vetor com " + tamanho + " posicoes.");

                if (tamanho>Integer.MAX_VALUE/2)
                {
                    System.out.println ("Limite aproximado atingido antes de estourar o int.");
                    System.out.println ("Maior vetor aproximado: " + maior + " posicoes.");
                    System.out.println ("Sugestao de execucao: java -Xmx8G MaiorVetorAproximado");
                    break;
                }

                tamanho *= 2;
            }
        }
        catch (OutOfMemoryError erro)
        {
            System.out.println ("Memoria insuficiente para " + tamanho + " posicoes.");

            if (vetor!=null)
                vetor = null;

            Runtime.getRuntime().gc ();

            int ini=maior+1;
            int fim=tamanho-1;

            while (ini<=fim)
            {
                int meio = ini + (fim-ini)/2;

                try
                {
                    vetor = Util.gerarAleatorio (meio);
                    maior = meio;
                    ini = meio+1;
                    vetor = null;
                }
                catch (OutOfMemoryError outroErro)
                {
                    fim = meio-1;
                    vetor = null;
                    Runtime.getRuntime().gc ();
                }
            }

            System.out.println ("Maior vetor aproximado: " + maior + " posicoes.");

            System.out.println ("Sugestao de execucao: java -Xmx8G MaiorVetorAproximado");
        }
    }
}
