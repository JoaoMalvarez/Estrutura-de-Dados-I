package Listas_Node.Fila;

public class Fila <T> {
    private Node<T> inicio, fim;
    private int size;

    public Fila() {
        inicio = fim = null;
        size = 0;
    }

    public boolean isEmpty() {    return size == 0;    }
    public boolean isFull() {
        Node<T> aux = new Node<T>();
        if (aux == null) { return true; }
        aux = null;
        return false;
    }

    public void enqueue(T data) throws Exception {
        if (isFull()) throw new Exception ("Queue overload");
        Node<T> newNode = new Node<T>(data, null);
        if (isEmpty()) {
            inicio = fim = newNode;
        } else {
            fim.setProx(newNode);
            fim = newNode;
        }   
    }
}
