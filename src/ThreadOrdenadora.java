public class ThreadOrdenadora extends Thread {
    private final byte[] parte;
    private byte[] resultado;

    public ThreadOrdenadora(byte[] parte, int id) {
        super("Ordenadora-" + id);
        this.parte = parte;
    }

    @Override
    public void run() {
        System.out.println("[LOG] " + getName() + " iniciou a ordenacao de " + parte.length + " elementos.");

        this.resultado = MergeSort.sort(parte);
    }

    public byte[] getResultado() {
        return this.resultado;
    }
}
