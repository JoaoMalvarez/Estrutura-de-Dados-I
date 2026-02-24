public class Main {
    public static void main(String[] args) {
        Contador c1 = new Contador();
        Contador c2 = new Contador();

        c1.incrementa();
        c1.incrementa();
        c2.incrementa();

        System.out.println("Contador 1: " + c1.getValor());
        System.out.println("Contador 2: " + c2.getValor());
    }
}