package Exercícios_Para_N2.B;

public class NodeB <T> {
    private T data;
    private NodeB<T> next;
    private NodeB<T> prev;

    public NodeB() {
        this(null, null, null);
    }

    public NodeB(T data, NodeB<T> next, NodeB<T> prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public NodeB<T> getNext() {
        return next;
    }

    public void setNext(NodeB<T> next) {
        this.next = next;
    }

    public NodeB<T> getPrev() {
        return prev;
    }

    public void setPrev(NodeB<T> prev) {
        this.prev = prev;
    }
}