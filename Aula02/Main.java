public class Main {
	public static void main(String[] args) {
		Contador c1 = new Contador();
		Contador c2 = new Contador();
		
		c1.incrementa();
		c1.incrementa();
		c2.incrementa();
		
		System.out.printf("C1: %d\n", c1.getValor());
		System.out.printf("C2: %d\n", c2.getValor());
	}
}