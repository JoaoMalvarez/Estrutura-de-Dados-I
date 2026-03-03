//o main da aula 3, chama o Pilha.java, então aqui é
//meio que chamado para a fução main
//que seria o main numa função normal, tipo C ou python


public class Pilha{
    //atributos
    private static final int TAM_DEFAULT = 100;
    private int topoPilha;
    private int elementos[];
    //contrutores
    public Pilha(int tamanho) {
        this.elementos = new int[tamanho];
        //this.elementos = elementos (opcional)
        this.topoPilha = -1;
    }

    public Pilha() {
        this(TAM_DEFAULT);
        //o "this" chama o construtor de cima (o anterior)
    }

    //métodos
    public boolean isEmpty() {
        return this.topoPilha == -1;
        /* é a mesma coisa acima com o "if else"
        if (topoPilha == -1)
            return true;
        else ()
            return false;
        */
    }
    public boolean isFull() {
        return topoPilha == elementos.length - 1;
    }

    public void push(int e) throws Exception {
        if (!this.isFull()) {
        //acessa a funcao isFull, e ve se ta cheia com "!"
            topoPilha++;
            //incrementa mais um caso não esteja cheio
            this.elementos[topoPilha] = e;
            /*Para ser melhor:
            ** this.elementos[++topoPilha] = e; **
            > com o ++ sendo adicionado antes
            */
        }
        else {
            throw new Exception("Overflow - Estouro de Pilha");
        }
    }

    public int pop() throws Exception {
        if (!this.isEmpty()) {
            int temp = this.elementos[topoPilha];
            topoPilha--;
            return temp;

            /* tmb pode:
            return this.elementos[this.topoPilha--];
            */
        }
        else {
            throw new Exception("Underflow - Esvaziamento de Pilha");
        }
    }

    public int topo() throws Exception {
        if (!isEmpty()) {
            return this.elementos[this.topoPilha];
        } else {
            throw new Exception("Underflow - Esvaziamento de Pilha");
        }
    }

    public int sizeElements() {
        return topoPilha + 1;
    }
}