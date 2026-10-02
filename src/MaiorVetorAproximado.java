public class MaiorVetorAproximado
{
    public static void main (String[] args)
    {
        int tamanho=1024;
        byte[] vetor=null;

        try
        {
            while (true)
            {
                vetor = Util.gerarAleatorio (tamanho);
                System.out.println ("Conseguiu criar vetor com " + tamanho + " posicoes.");

                if (tamanho>Integer.MAX_VALUE/2)
                {
                    System.out.println ("Limite aproximado atingido antes de estourar o int.");
                    break;
                }

                tamanho *= 2;
            }
        }
        catch (OutOfMemoryError erro)
        {
            System.out.println ("Memoria insuficiente para " + tamanho + " posicoes.");

            if (vetor!=null)
                System.out.println ("Maior vetor aproximado: " + vetor.length + " posicoes.");

            System.out.println ("Sugestao de execucao: java -Xmx8G MaiorVetorAproximado");
        }
    }
}
