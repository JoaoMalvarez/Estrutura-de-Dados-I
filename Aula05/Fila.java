@SuppressWarnings("unchecked")

public class Fila <T> {
    // atributos
    private static final int TAM = 10;
    private int inicio, fim, qtde;
    private T e[];
    //construtores
    public Fila     (int tamanho) {
        this.qtde = 0;
        this.inicio = 0;
        this.fim = 0;
        this.e = (T[]) new Object[tamanho];
    }

    public Fila() {
        this(TAM);
    }
    //métodos

    public boolean qIsEmpty() {
        return this.qtde == 0;
    }

    public boolean qIsFull() {
        return this.qtde == e.length;
    }

    public void enqueue(T elem) {
        if (!qIsFull()) {
            e[fim++] = elem;
            fim = fim % e.length;
            qtde++;
        }
        else {
            System.out.println("Overflow - Estouro de Fila");
        }
    }

    public T dequeue() {
        if(!qIsEmpty()) {
            T aux; 
            aux = e[inicio];
            inicio = ++inicio % e.length;
            qtde--;
            return aux;
        }
        else {
            System.out.println("Underflow - Esvaziamento de Fila");
            return null;
        }
    }

    public int size() {
        return qtde;
    }

    public T front() {
        return e[inicio];
    }

    public T rear() {
        return e[fim];
    }

}