package Exercícios_Para_N2.B;

public class B_DLinkedList <T> {
    private NodeB<T> head;
    private NodeB<T> tail;
    private int size;

    public B_DLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return (size == 0) && (head == null) && (tail == null);
    }

    public boolean isFull() {
        NodeB<T> aux = new NodeB<T>();
        return aux == null;
    }

    public int getSize() {
        return size;
    }

    public NodeB<T> getHead() {
        return head;
    }

    public NodeB<T> getTail() {
        return tail;
    }

    public NodeB<T> get(int pos) {
        if(isEmpty()) { return null; }
        else if(pos <= 0 || pos > size) { return null; }
        else {
            NodeB<T> pAnda = head;
            int cont = 1;
            while (cont != pos) {
                pAnda = pAnda.getNext();
                cont++;
            }
            return pAnda;
        }
    }

    public NodeB<T> get(T data) {
        if(isEmpty()) { return null; }
        else if (data == null) { return null; }
        else {
            NodeB<T> pAnda = head;
            while (data != pAnda.getData()) {
                if (pAnda == tail) return null;
                pAnda = pAnda.getNext();
            }
            return pAnda;
        }
    }

    public boolean insertFirst(T data) {
        if (isFull()) { return false; }
        else if (isEmpty()) {
            NodeB<T> cabeca = new NodeB<T>();
            cabeca.setData(data);
            head = tail = cabeca;
        }
        else {
            NodeB<T> aux = new NodeB<T>(data, head, null);
            head.setPrev(aux);
            head = aux;
        }
        size++;
        return true;
    }

    public boolean insertLast(T data) {
        if(isFull()) { return false; }
        else if (isEmpty()) { 
            insertFirst(data);
            return true;
        }
        else {
            NodeB<T> aux = new NodeB<T>(data, null, tail);
            tail.setNext(aux);
            tail = aux;
        }
        size++;
        return true;
    }

    public boolean insert(T data, int pos) {
        if (pos <= 0 || pos > size + 1) { return false; }
        if (isFull()) { return false; }
        else if (isEmpty()) { return insertFirst(data); }
        else if (pos == 1) { return insertFirst(data); }
        else if (pos == size + 1) { return insertLast(data); }
        else {
            NodeB<T> ins = new NodeB<>(data, null, null);
            NodeB<T> aux = get(pos);
            ins.setNext(aux);
            ins.setPrev(aux.getPrev());
            ins.getPrev().setNext(ins);
            aux.setPrev(ins);
        }
        size++;
        return true;
    }

    // public boolean insertCrescente(int data) {
    //     if(isEmpty()) { return insertFirst(data); }
    //     if (isFull()) { return false; }
    //     else { 
    //         NodeB<T> pAnda = head;
    //         int contador = 1;
    //         while (pAnda.getData() < data) {
    //             if (pAnda == tail) {
    //                 insertLast(data);
    //                 return true;
    //             }
    //             pAnda = pAnda.getNext();
    //             contador++;
    //         }
    //         insert(data, contador);
    //         return true;
    //     }
    // }

    // public boolean insertDecrescente(int data) {
    //     if(isEmpty()) { return insertFirst(data); }
    //     if (isFull()) { return false; }
    //     else { 
    //         NodeB<T> pAnda = head;
    //         int contador = 1;
    //         while (pAnda.getData() > data) {
    //             if (pAnda == tail) {
    //                 insertLast(data);
    //                 return true;
    //             }
    //             pAnda = pAnda.getNext();
    //             contador++;
    //         }
    //         insert(data, contador);
    //         return true;
    //     }
    // }

    public boolean removeFirst() {
        if(isEmpty()) { return false; }
        else if (size == 1) { head = tail = null; }
        else {
            NodeB<T> aux = head;
            aux.getNext().setPrev(null);
            head = aux.getNext();
            aux.setNext(null); 
        }
        size--;
        return true;
    }

    public boolean removeLast() {
        if (isEmpty()) { return false; }
        else if (size == 1) { return removeFirst(); }
        else {
            NodeB<T> aux = tail;
            aux.getPrev().setNext(null);
            tail = aux.getPrev();
            aux.setPrev(null);
        }
        size--;
        return true;
    }

    public boolean remove(int pos) {
        if (pos <= 0 || pos > size) { return false; }
        if (isEmpty()) { return false; }
        else if (size == 1) { return removeFirst(); }
        else if (pos == 1) { return removeFirst(); }
        else if (pos == size) { return removeLast(); }
        else {
            NodeB<T> aux = get(pos);
            aux.getPrev().setNext(aux.getNext());
            aux.getNext().setPrev(aux.getPrev());
            aux = null;
        }
        size--;
        return true;
    }

    public void print() {
        System.out.print("Lista Duplamente Encadeada: [");
        NodeB<T> pAnda = head;
        while (pAnda != tail) {
            System.out.print(pAnda.getData());
            System.out.print(", ");
            pAnda = pAnda.getNext();
        }
        if (tail != null) System.out.print(tail.getData());
        System.out.print("], tamanho: " + size);
    }

    public void clear() {
        if (!isEmpty()) {
            head = tail = null;
            size = 0;
        }
    }

    public T pullFirst() {
        if (isEmpty()) { return null; }
        NodeB<T> aux = head;
        if (size == 1) { 
            head = null;
            tail = null;
            size--;
            return aux.getData();
        }
        else {
            aux.getNext().setPrev(null);
            head = aux.getNext();
            size--;
            return aux.getData();
        }
    }

    public T pullLast() {
        if (isEmpty()) { return null; }
        NodeB<T> aux = tail;
        if (size == 1) { return pullFirst(); }
        else {
            aux.getPrev().setNext(null);
            tail = aux.getPrev();
            size--;
            return aux.getData();
        }
    }

    public T pull(int pos) {
        if (pos <= 0 || pos > size) { return null; }
        if (isEmpty()) { return null; }
        else if (size == 1) { return pullFirst(); }
        else if (pos == 1) { return pullFirst(); }
        else if (pos == size) { return pullLast(); }
        else {
            NodeB<T> aux = get(pos);
            aux.getPrev().setNext(aux.getNext());
            aux.getNext().setPrev(aux.getPrev());
            aux.setNext(null);
            aux.setPrev(null);
            size--;
            return aux.getData();
        }
    }

    public void inverte() {
        if (!isEmpty() && size != 1) {
            NodeB<T> pAntes;
            NodeB<T> pAtual = head;
            NodeB<T> pApos = head.getNext();
            head.setPrev(pApos);
            head.setNext(null);
            pAntes = pAtual;
            pAtual = pApos;
            pApos = pApos.getNext();
            while (pAtual != tail) {
                pAtual.setPrev(pApos);
                pAtual.setNext(pAntes);
                pAntes = pAtual;
                pAtual = pApos;
                if (pApos.getNext() != null) pApos = pApos.getNext();
            }
            tail.setNext(pAntes);
            tail.setPrev(null);
            
            pApos = head;
            head = tail;
            tail = pApos;
        }
    }

    public void concatena(B_DLinkedList<T> lista) {
        if(!isFull()) {
            if(!isEmpty()) tail.setNext(lista.getHead());
            if(isEmpty()) head = lista.getHead();
            if(!lista.isEmpty()) {
                lista.getHead().setPrev(tail);
                tail = lista.getTail();
            }
            size = size + lista.getSize();
        }
    }




}