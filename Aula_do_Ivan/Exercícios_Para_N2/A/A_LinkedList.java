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

        public NodeA<T> get(T data) {
        if (isEmpty()) { return null; }
        if (data == null) { return null; }
        NodeA<T> pAnda = head;
        while(data != pAnda.getData()) {
            if (pAnda == tail) return null;
            pAnda = pAnda.getNext();
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
        if(!isFull()) {
            if (isEmpty()) {
                head = tail = new NodeA<T>(data, null);
            } else if (pos == 1) { 
                insertFirst(data);
                return true;
            } else if (pos == size + 1) {
                insertLast(data);
                return true;
            } else {
                NodeA<T> aux = new NodeA<T>(data, null);
                NodeA<T> antes = get(pos - 1);
                int cont = 1;
                NodeA<T> pAnda = new NodeA<T>();
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
            if(pos == 1) {
                removeFirst();
                return true;
            } else if (pos == size) {
                removeLast();
                return true;
            }
            NodeA<T> aux = get(pos);
            NodeA<T> antes = get(pos - 1);
            antes.setNext(aux.getNext());
            aux.setNext(null);
            size--;
            return true;
        } else return false;
    }

    public void print() {
        System.out.print("Lista: [");
        if (!isEmpty()) {
            NodeA<T> pAnda;
            pAnda = head;
            while(pAnda.getNext() != null) {
                System.out.print(pAnda.getData());
                System.out.print(", ");
                pAnda = pAnda.getNext();
            }
            System.out.print(tail.getData());
        }
        System.out.println("], tamanho =" + size);
    }

    public void clear() {
        if (!isEmpty()) {
            head = null;
            tail = null;
            size = 0;
        }
    }

    public NodeA<T> pullFirst() {
        if (isEmpty()) return null;
        else {
            NodeA<T> cabeca = head;
            NodeA<T> aux = head.getNext();
            head.setNext(null);
            head = aux;
            size--;
            return cabeca;
        }
    }
    public NodeA<T> pullLast() {
        if (isEmpty()) return null;
        else if (size == 1) return pullFirst();
        else {
            NodeA<T> rabo = tail;
            NodeA<T> aux = get(size - 1);
            tail = aux;
            aux.setNext(null);
            size--;
            return rabo;
        }
    }
    public NodeA<T> pull(NodeA<T> remove) {
        NodeA<T> pAnda = head;
        NodeA<T> aux = null;
        if (isEmpty()) return null;
        else if (remove == null) return null;
        else {
            while(remove != pAnda) {
                if (pAnda == tail) return null;
                aux = pAnda;
                pAnda = pAnda.getNext();
            }
            if (pAnda == head) return pullFirst();
            else if (pAnda == tail) return pullLast();
            aux.setNext(pAnda.getNext());
            return pAnda;
        }
    }

    public boolean inverte() {
        if (isEmpty()) return false;
        else if (size == 1) return true; // head ja é = tail
        else {
            NodeA<T> antes = head;
            NodeA<T> agora = antes.getNext();
            NodeA<T> depois = agora.getNext();
            head.setNext(null);
            for (int i = 1; i < size; i++) {
                agora.setNext(antes);
                antes = agora;
                agora = depois;
                if (depois != null) depois = depois.getNext();
            }
            agora = head;
            this.head = tail;
            this.tail = agora;
            return true;
        }
    }

    public void concatena(A_LinkedList<T> lista) {
        if(!isFull()) {
            if(!isEmpty()) tail.setNext(lista.getHead());
            if(isEmpty()) head = lista.getHead();
            if(!lista.isEmpty()) tail = lista.getTail();
            size = size + lista.getSize();
        }
    }





}