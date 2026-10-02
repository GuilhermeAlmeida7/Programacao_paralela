public class MergeSort
{
    public static byte[] sort (byte[] v)
    {
        if (v==null)
            throw new IllegalArgumentException ("Vetor ausente");

        if (v.length<=1)
            return v.clone ();

        int meio = v.length/2;
        byte[] esquerda = new byte[meio];
        byte[] direita  = new byte[v.length-meio];

        System.arraycopy (v, 0, esquerda, 0, esquerda.length);
        System.arraycopy (v, meio, direita, 0, direita.length);

        return merge (sort (esquerda), sort (direita));
    }

    public static byte[] merge (byte[] a, byte[] b)
    {
        if (a==null)
            throw new IllegalArgumentException ("Primeiro vetor ausente");

        if (b==null)
            throw new IllegalArgumentException ("Segundo vetor ausente");

        if (a.length>Integer.MAX_VALUE-b.length)
            throw new IllegalArgumentException ("Vetor resultante muito grande");

        byte[] resultado = new byte[a.length+b.length];
        int i=0, j=0, k=0;

        while (i<a.length && j<b.length)
        {
            if (a[i]<=b[j])
                resultado[k++] = a[i++];
            else
                resultado[k++] = b[j++];
        }

        while (i<a.length)
            resultado[k++] = a[i++];

        while (j<b.length)
            resultado[k++] = b[j++];

        return resultado;
    }
}
