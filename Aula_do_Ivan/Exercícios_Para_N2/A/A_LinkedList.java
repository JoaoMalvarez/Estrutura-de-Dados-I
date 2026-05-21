package Exercícios_Para_N2.A;

public class A_LinkedList <T> {
    private NodeA<T> head;
    private NodeA<T> tail;
    private int size;
    public A_LinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public boolean isFull() {
        NodeA<T> aux = new NodeA<T>();
        return aux == null;
    }

    public boolean isEmpty() {
        return (size == 0) && (head == null) && (tail == null); // testar
    }

    public int getSize() {
        return size;
    }

    public NodeA<T> getHead() {
        return head;
    }

    public NodeA<T> getTail() {
        return tail;
    }

    public NodeA<T> get(int pos) {
        if (isEmpty()) { return null; }
        if (pos <= 0 || pos > size) { return null; }
        NodeA<T> pAnda = head;
        int contador = 1;
        while(contador != pos) {
            pAnda = pAnda.getNext();
            contador++;
        }
        return pAnda;
    }

    public boolean insertFirst(T data) {
        if (isFull()) { return false; }
        NodeA<T> aux = new NodeA<T>(data, null);
        if (isEmpty()) {
            head = tail = aux; // a cabeça se torna o auxiliar
        }
        else { 
            aux.setNext(head); // o prox é o valor do head
            head = aux; // o aux vira o head
        }
        size++;
        return true;
    }

    public boolean insertLast(T data) {
        NodeA<T> aux;
        if (!isFull()) {
            aux = new NodeA<T>(data, null);
            if (isEmpty()) {
                tail = head = aux;
            }
            else {
                tail.setNext(aux);
                tail = aux;
            }
            size++;
            return true;
        } else return false;
    }

    public boolean insert(T data, int pos) {
        NodeA<T> aux = new NodeA<T>(data, null);
        int cont = 1;
        NodeA<T> pAnda = new NodeA<T>();
        NodeA<T> pAndinha = new NodeA<T>(null, pAnda);
        if(!isFull()) {
            if (isEmpty()) {
                head = tail = aux;
            } else {
                pAnda = head;
                while (pos != cont) {
                    pAnda = pAnda.getNext();
                    cont++;
                }
                pAnda = aux;
            }
            size++;
            return true;
        } else return false;
    }
}