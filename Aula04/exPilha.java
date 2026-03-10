public class Pilha <T> {
    // atributos
    private static final int TAM_DEFAULT = 100;
    private int topoPilha;
    private T elementos[];
    // construtores
    public Pilha(int tamanho) {
        this.elementos = (T[]) new Object[tamanho];
        this.topoPilha = -1;
    }

    public Pilha() {
        this(TAM_DEFAULT);
    }
    // métodos
    public boolean isEmpty() {
        return this.topoPilha == -1;
    }

    public boolean isFull() {
        return topoPilha == elementos.length - 1;
    }

    public void push(T e) throws Exception {
        if (!this.isFull()) {
            topoPilha++;
            this.elementos[topoPilha] = e;
        }
        else {
            throw new Exception("Overflow - Estouro de pilha.");
        }
    }

    public T pop() throws Exception {
        if (!this.isEmpty()) {
            T temp = this.elementos[topoPilha];
            topoPilha--;
            return temp;
        }
        else {
            throw new Exception("Underflow - Esvaziamento de Pilha.");
        }
    }

    public T topo() throws Exception {
        if (!this.isEmpty()) {
            return this.elementos[topoPilha];
        }
        else {
            throw new Exception("Underflow - Esvaziamento de Pilha.");
        }
    }
    
    public int sizeElements() {
        return topoPilha + 1;
    }




    
}