import java.util.Scanner;
public class Main {
    public static void main(String [] args) throws Exception {
        Fila<Integer> filaPar = new Fila<Integer>(30);
        Fila<Integer> filaImpar = new Fila<Integer>(30);
        Pilha<Integer> pilha = new Pilha<Integer>(30);

        int numero;
        do {
            System.out.print("Número: ");
            Scanner entrada = new Scanner(System.in);
            numero = entrada.nextInt();
            if (numero != 0) {
                if (numero % 2 == 0) {
                    filaPar.enqueue(numero);
                } else {
                    filaImpar.enqueue(numero);
                }
            }
            entrada.close();
        } while (numero != 0);

        boolean vezImpar = true;
        Integer valor;
        while(!filaImpar.qIsEmpty() && !filaPar.qIsEmpty()) {
            if (vezImpar)
                valor = filaImpar.dequeue();
            else
                valor = filaPar.dequeue();

            if (valor >= 0) {
                pilha.push(valor);
            } else {
                if (!pilha.isEmpty())
                    pilha.pop();
            }
            if (vezImpar && !filaPar.qIsEmpty()) {
                vezImpar = !vezImpar;
            }
            vezImpar = !vezImpar;
        }

        while(!filaImpar.qIsEmpty()) {
            valor = filaPar.dequeue();
            if (valor > 0){
                pilha.push(valor);
            }
            else {
                if(!pilha.isEmpty()) {
                    valor = pilha.pop();
                    System.out.print(pilha.pop());
                }
            }
            pilha.push(filaImpar.dequeue());
        }
    }
}