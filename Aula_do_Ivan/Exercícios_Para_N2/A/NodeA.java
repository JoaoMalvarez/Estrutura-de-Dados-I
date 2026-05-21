package Exercícios_Para_N2.A;

public class NodeA <T> {
    private T data;
    private NodeA<T> next;
    
    public NodeA() {
        this(null, null);
    }

    public NodeA(T data, NodeA<T> next) {
        this.data = data;
        this.next = next;
    }

    public T getData() {
        return data;
    }
    public void setData(T data) {
        this.data = data;
    }

    public NodeA<T> getNext() {
        return next;
    }
    public void setNext(NodeA<T> next) {
        this.next = next;
    }
}