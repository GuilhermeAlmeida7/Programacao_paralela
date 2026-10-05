import java.lang.reflect.Method;
import java.util.Arrays;

public class TestesOrdenacao
{
    private static byte[] chamarSortSequencial (byte[] v) throws Exception
    {
        Class<?> classe = Class.forName ("MergeSort");
        Method metodo  = classe.getMethod ("sort", byte[].class);

        return (byte[])metodo.invoke (null, new Object[] {v});
    }

    private static byte[] chamarSortParalelo (byte[] v) throws Exception
    {
        Class<?> classe = Class.forName ("OrdenadorParalelo");
        Method metodo  = classe.getMethod ("ordenar", byte[].class);

        return (byte[])metodo.invoke (null, new Object[] {v});
    }

    private static boolean estaOrdenado (byte[] v)
    {
        if (v==null)
            return false;

        for (int i=1; i<v.length; i++)
            if (v[i-1]>v[i])
                return false;

        return true;
    }

    private static void testar (int tamanho)
    {
        try
        {
            byte[] original = Util.gerarAleatorio (tamanho);
            byte[] copiaSeq = original.clone ();
            byte[] copiaPar = original.clone ();

            long inicioSeq = System.nanoTime ();
            byte[] seq = chamarSortSequencial (copiaSeq);
            long fimSeq = System.nanoTime ();

            long inicioPar = System.nanoTime ();
            byte[] par = chamarSortParalelo (copiaPar);
            long fimPar = System.nanoTime ();

            System.out.println ("Tamanho: " + tamanho);
            System.out.println ("Sequencial: " + ((fimSeq-inicioSeq)/1000000.0) + " ms");
            System.out.println ("Paralelo: " + ((fimPar-inicioPar)/1000000.0) + " ms");
            System.out.println ("Sequencial ordenado: " + estaOrdenado (seq));
            System.out.println ("Paralelo ordenado: " + estaOrdenado (par));
            System.out.println ("Resultados iguais: " + Arrays.equals (seq, par));
            System.out.println ();
        }
        catch (ClassNotFoundException erro)
        {
            System.err.println ("Classes de ordenacao ainda nao encontradas.");
            System.err.println ("Compile tambem MergeSort.java e OrdenadorParalelo.java.");
        }
        catch (Exception erro)
        {
            System.err.println ("Erro ao testar tamanho " + tamanho + ": " + erro.getMessage ());
        }
    }

    public static void main (String[] args)
    {
        if (args.length>0)
        {
            for (int i=0; i<args.length; i++)
                testar (Integer.parseInt (args[i]));

            return;
        }

        testar (1000);
        testar (10000);
        testar (100000);
        testar (1000000);
    }
}
