package Lista_Duplamente_Encadeada_Cricular;

public class DLL<T extends Comparable<T>> {
    private Node<T> head;
    private int size;
    // DLL(): Construtor vazio
    // inicia o cabeça da lista como null e tamanho = 0
    public DLL(){
        this.head = null;
        this.size = 0;
    }

    public boolean isEmpty() { // Verifica se DLL está vazia
        return head == null;
    }

    public int getSize() { 
        return size; 
    }

    public boolean isFull() {
        Node<T> aux = new Node<T>();
        return aux == null;
    }

    public void showAscending(){
        // Percorre a lista e imprime os valores
        // em ordem Crescente
        if (isEmpty()) System.out.print( "Lista vazia!\n");
        else{
            System.out.print( "Lista: [ ");
            Node<T> pAnda = this.head;
            while (pAnda.getRight() != this.head){
                System.out.print( pAnda.getData() + " ");
                pAnda= pAnda.getRight();
            }
            System.out.print( pAnda.getData() +"]");
        }
    }

    public void showDescending(){
        // Percorre a lista e imprime os valores
        // em ordem decrescente
        if (isEmpty()) System.out.print( "Lista vazia!\n" );
        else{
            System.out.print( "Lista: [ " );
            Node<T> pAnda = this.head;
            while (pAnda.getLeft() != this.head){
                pAnda= pAnda.getLeft();
                System.out.print( pAnda.getData() + " " );
            }
            System.out.print( pAnda.getLeft().getData() + "]");
        }
    }

    public int searchAscending(T data){
        if (isEmpty()) return -1;
        // Procura o elemento
        Node<T> pAnda = this.head;
        int pos = 1;
        while (pAnda.getRight() != this.head && pAnda.getData().compareTo(data) != 0){
            pAnda = pAnda.getRight();
            pos++;
        }
        if (pAnda.getRight() == this.head && pAnda.getData().compareTo(data) != 0){// elemento não encontrado
            return -1;
        } else { // elemento encontrado
            return pos;
        } 
    }

    public boolean insertAscending(T data){
        if (isFull()) return false;
        // Cria um novo no
        Node<T> novoNo = new Node<T>(data, null, null);
        // se lista vazia, insere o nó no ponteiro cabeça
        // e faz o nó apontar para ele mesmo
        if (isEmpty()) {
            this.head = novoNo;
            novoNo.setRight(novoNo);
            novoNo.setLeft(novoNo);
        } else { 
            Node<T> pAnda = this.head, pAnt = null;
            while (pAnda.getRight() != head && pAnda.getData().compareTo(data) < 0){
                pAnt = pAnda;
                pAnda = pAnda.getRight();
            } 
            if (pAnt == null && pAnda.getData().compareTo(data) > 0){
                novoNo.setLeft(this.head.getLeft());
                this.head.getLeft().setRight(novoNo);
                this.head.setLeft(novoNo);
                novoNo.setRight(this.head);
                this.head = novoNo;
            } else {
                if (pAnda.getData().compareTo(data) > 0 && pAnt != null) {
                pAnt.getRight().setLeft(novoNo);
                novoNo.setRight(pAnda);
                pAnt.setRight(novoNo);
                novoNo.setLeft(pAnt);
                } else {// Senão, insere a Key depois do pAnda
                    pAnda.getRight().setLeft(novoNo);
                    novoNo.setRight(pAnda.getRight());
                    pAnda.setRight(novoNo);
                    novoNo.setLeft(pAnda);
                } 
            } 
        }
        this.size++;
        return true; 
    }

    public Node<T> get(int pos){
        if (isEmpty()) return null;
        if (pos <= 0 || pos > size) return null;
        int cont = 1;
        Node<T> pAnda = head;
        while (cont != pos){
            pAnda = pAnda.getRight();
            cont++;
        }
        return pAnda;
    }


    public void clear(){
        Node<T> pAnt, pAnda = head;
        int total = size;
        int cont = 0;
        while(cont != total){
            pAnt = pAnda; // Libera o nó
            pAnda = pAnda.getRight();
            pAnt.setRight(null);
            pAnt.setLeft(null);
            pAnt = null;
        }
        size = 0;
        head = null;
    }

    public boolean remove(T data) {
        // Lista vazia
        if (isEmpty()) return false;
        // Procura o elemento a ser removido
        Node<T> pAnda = this.head, pAnt = null;
        while (pAnda.getRight() != this.head && pAnda.getData().compareTo(data) != 0){
            pAnt = pAnda;
            pAnda = pAnda.getRight();
        }
        if (pAnda.getRight() == this.head && pAnda.getData().compareTo(data) != 0){// elemento não encontrado
            return false;
        } else {
            // elemento encontrado no cabeça
            if (pAnt == null && pAnda.getData().compareTo(data) == 0){
                pAnda.getLeft().setRight(pAnda.getRight());
                this.head = this.head.getRight();
                this.head.setLeft(pAnda.getLeft());
                pAnda.setLeft(null);
                pAnda.setRight(null);
            } else { // elemento encontra-se no meio da lista
                pAnt.setRight(pAnda.getRight());
                pAnda.getRight().setLeft(pAnt);
                pAnda.setLeft(null);
                pAnda.setRight(null);
            }
            pAnda = null;
            this.size--;
            return true;
        }
    }

    public Node<T> remove(int pos) {
        // Lista vazia
        if (isEmpty()) return null;
        if (pos <= 0 || pos > size) return null;
        // Procura o elemento a ser removido
        Node<T> pAnda = this.head, pAnt = null;
        int cont = 1;
        while (pAnda.getRight() != this.head && cont != pos){
            pAnt = pAnda;
            pAnda = pAnda.getRight();
            cont++;
        }
        if (pAnda.getRight() == this.head && cont != pos){// elemento não encontrado
            return null;
        } else {
            // elemento encontrado no cabeça
            if (cont == 1){
                pAnda.getLeft().setRight(pAnda.getRight());
                this.head = this.head.getRight();
                this.head.setLeft(pAnda.getLeft());
                pAnda.setLeft(null);
                pAnda.setRight(null);
            } else { // elemento encontra-se no meio da lista
                pAnt.setRight(pAnda.getRight());
                pAnda.getRight().setLeft(pAnt);
                pAnda.setLeft(null);
                pAnda.setRight(null);
            }
            this.size--;
            return pAnda;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int qtde = 0;
        sb.append("\n[Lista]\n");
        sb.append("L: [ ");
        Node<T> pAnda = head;
        while (qtde != size) {
            sb.append(pAnda.getData());
            qtde++;
            pAnda = pAnda.getRight();
        }
        sb.append("]\n");
        sb.append("Qtde.: " + size);
        return sb.toString();
    }

}