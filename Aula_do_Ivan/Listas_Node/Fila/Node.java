package Listas_Node.Fila;

public class Node <T> {
    private T data;
    private Node<T> prox;
    public Node() {
        this(null, null);
    }
    public Node(T data, Node<T> prox) {
        this.data = data;
        this.prox = prox;
    }
    public T getData() { return data;};
    public Node<T> getProx(){ return prox;};
    public void setData(T data) { this.data = data;};
    public void setProx (Node<T> prox){ this.prox = prox; };
}
