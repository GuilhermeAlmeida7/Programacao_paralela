public class ThreadJuntadora extends Thread {
    private final byte[] vetorA;
    private final byte[] vetorB;
    private byte[] resultado;

    public ThreadJuntadora(byte[] vetorA, byte[] vetorB, String nome) {
        super(nome);
        this.vetorA = vetorA;
        this.vetorB = vetorB;
    }

    @Override
    public void run() {
        System.out.println("[LOG] " + getName() + " mesclando vetores (" + vetorA.length + " e " + vetorB.length + " elementos).");
        
        
        this.resultado = MergeSort.merge(vetorA, vetorB);
    }

    public byte[] getResultado() {
        return this.resultado;
    }
}