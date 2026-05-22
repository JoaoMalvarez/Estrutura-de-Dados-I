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
        NodeA<T> antes = get(pos - 1);
        int cont = 1;
        NodeA<T> pAnda = new NodeA<T>();
        if(!isFull()) {
            if (isEmpty()) {
                head = tail = aux;
            } else {
                pAnda = head;
                while (pos != cont) {
                    pAnda = pAnda.getNext();
                    cont++;
                }
                aux.setNext(pAnda.getNext());
                // atualizar o anterior para apontar para o setNext
                antes.setNext(aux);
            }
            size++;
            return true;
        } else return false;
    }

    public boolean removeFirst() {
        if(!isEmpty()) {
            NodeA<T> aux = head.getNext();
            head.setNext(null);
            head = aux;
            size--;
            return true;
        } else return false;
    }

    public boolean removeLast() {
        if (!isEmpty()) {
            NodeA<T> aux = get(size - 1);
            tail = aux;
            aux.setNext(null);
            size--;
            return true;
        } else return false;
    } 

    public boolean remove(int pos) {
        if (!isEmpty()) {
            NodeA<T> aux = get(pos);
            NodeA<T> antes = get(pos - 1);
            antes.setNext(aux.getNext());
            aux.setNext(null);
            size--;
            return true;
        } else return false;
    }

    public void print() {
        System.out.println("Lista: [");
        if (!isEmpty()) {
            NodeA<T> pAnda;
            pAnda = head;
            while(pAnda.getNext() != null) {
                System.out.println(pAnda.getData());
                pAnda = pAnda.getNext();
            }
        }
        System.out.println("], tamanho =" + size);
    }

    public void clear() {
        if (!isEmpty()) {
            NodeA<T> pAnda;
            pAnda = head;
            NodeA<T> aux = null;
            while(size != 0) {
                aux = pAnda;
                pAnda = pAnda.getNext();
                aux.setNext(null);
                size--;
            }
        }
    }

//    public T pullFirst()
//    public T pullLast()
//    public T pull()
}