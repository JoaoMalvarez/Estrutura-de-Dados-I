package Deque;
@SuppressWarnings("unchecked")

public class Deque <T> {
    private static final int TAM_DEQUE = 100;
    private int inicio, fim, qntd, tamanho;
    private T e[];

    // Construtor que Inicia o Deque como vazio e tamanho padrão

    public Deque() {
        this(TAM_DEQUE);
    }

    // Construtor que Inicia o Deque como vazio e tamanho informado
    // pelo usuário da classe

    public Deque(int tamanho) {
        this.inicio = 0;
        this.fim = 0;
        this. qntd = 0;
        this.tamanho  = tamanho;
        this.e = (T[]) new Object[tamanho];    
    }

    // Verifica se o Deque está vazio retornando true (se vazio)
    // e false (caso contrário)
    public boolean isEmpty() {
        return qntd == 0;
    }

    // Verifica se o Deque está cheio retornando true (se cheio)
    // e false (caso contrário)
    public boolean isFull() {
        return qntd == this.tamanho;
    }

    // Obtém o elemento do início do Deque
    public T getLeft() throws Exception {
        if(!isEmpty()) {
            return e[inicio];
        } else {
            throw new Exception("deque empty");
        }
    }

    // Obtém o elemento do fim do deque
    public T getRight() throws Exception {
        if(!isEmpty()) {
            if (fim == 0) {
                return e[tamanho - 1];
            } else return e[fim - 1];
        } else {
            throw new Exception("deque empty");
        }
    }

    // Insere no “início-1” do Deque
    public void enqueueLeft(T e) throws Exception {
        if(!isFull()) {
            if(inicio == 0) {
                this.e[this.tamanho-1] = e;
                inicio = this.tamanho-1;
                qntd++;
            } else {
                this.e[--inicio] = e;
                qntd++;
            }   
        } else {
            throw new Exception("deque overflow");
        }
    }

    // Insere no “fim” do Deque
    public void enqueueRight(T e) throws Exception {
        if(!isFull()) {
            this.e[fim++] = e;
            fim = fim % this.tamanho;
            qntd++;
        } else {
            throw new Exception("deque overflow");
        }
    }

    // Remove e retorna um elemento do início do Deque
    public T dequeueLeft() throws Exception {
        T aux;
        if(!isEmpty()) {
            aux = e[inicio];
            inicio = ++inicio % this.tamanho;
            qntd--;
            return aux;
        } else {
            throw new Exception("deque underflow");
        }
    }

    // Remove e retorna um elemento do final do Deque
    public T dequeueRight( ) throws Exception {
        T aux;
        if (! isEmpty( )){
            if (fim == 0) {
                aux = e[this.tamanho-1];
                fim = this.tamanho-1;
            } else {
                aux = e[fim-1];
                fim--;
            }
            qntd--;
            return aux;
        } else {
            throw new Exception("deque underflow");
        } 
    }

    // Retorna o total de elementos
    // armazenados no deque
    public int size() {
        return qntd;
    }
}