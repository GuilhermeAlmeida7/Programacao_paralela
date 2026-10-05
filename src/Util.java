import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Util
{
    private static BufferedReader teclado =
                   new BufferedReader (
                   new InputStreamReader (
                   System.in));

    public static int lerTamanho () throws Exception
    {
        int tamanho=0;

        try
        {
            tamanho = Integer.parseInt (teclado.readLine ());
        }
        catch (IOException erro)
        {} // sei que nao vai dar erro
        catch (NumberFormatException erro)
        {
            throw new Exception ("Tamanho invalido!");
        }

        if (tamanho<0)
            throw new Exception ("Tamanho invalido!");

        return tamanho;
    }

    public static byte[] gerarAleatorio (int n)
    {
        if (n<0)
            throw new IllegalArgumentException ("Tamanho invalido!");

        byte[] ret = new byte[n];
        Random gerador = new Random ();

        for (int i=0; i<n; i++)
            ret[i] = (byte)gerador.nextInt (101);

        return ret;
    }

    public static byte[] lerManual (int n)
    {
        if (n<0)
            throw new IllegalArgumentException ("Tamanho invalido!");

        byte[] ret = new byte[n];

        for (int i=0; i<n; i++)
        {
            boolean leu=false;

            while (!leu)
            {
                try
                {
                    System.out.print ("v[" + i + "] = ");
                    ret[i] = Byte.parseByte (teclado.readLine ());
                    leu = true;
                }
                catch (IOException erro)
                {} // sei que nao vai dar erro
                catch (NumberFormatException erro)
                {
                    System.err.println ("Byte invalido!");
                }
            }
        }

        return ret;
    }

    public static void imprimir (byte[] v, int ini, int fim)
    {
        if (v==null)
            throw new IllegalArgumentException ("Vetor ausente!");

        if (v.length==0)
        {
            System.out.println ("[]");
            return;
        }

        if (ini<0)
            ini = 0;

        if (fim>=v.length)
            fim = v.length-1;

        if (ini>fim)
        {
            System.out.println ("[]");
            return;
        }

        System.out.print ("[");

        for (int i=ini; i<=fim; i++)
        {
            if (i>ini)
                System.out.print (", ");

            System.out.print (v[i]);
        }

        System.out.println ("]");
    }

    public static void imprimir (byte[] v)
    {
        if (v==null)
            throw new IllegalArgumentException ("Vetor ausente!");

        imprimir (v, 0, v.length-1);
    }
}
