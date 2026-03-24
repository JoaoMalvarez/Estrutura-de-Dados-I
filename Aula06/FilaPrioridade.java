package Aula06;
import java.util.Comparator;

public class FilaPrioridade<T> {
    private Deque<T> fila;
    private Comparator<T> comparator;

    public FilaPrioridade(Comparator<T> comparator) {
        this.fila = new Deque<>();
        this.comparator = comparator;
    }

    public void enqueue(T elemento) throws Exception {
        // Adicione seu código aqui:

        if (fila.isEmpty()) {
            fila.enqueueLeft(elemento);
            return;
        }
        int tamanho = fila.size();
        int movidos = 0;
        while(movidos < tamanho && comparator.compare(elemento, fila.getLeft()) <= 0) {
        // e1 = elemento adicionado, e2 = elemento na fila
        // O comparador funciona da seguinte forma:
        // - Retorna um valor negativo se e1 tem maior prioridade que e2
        // - Retorna um valor positivo se e2 tem maior prioridade que e1
        // - Retorna zero se e1 e e2 têm a mesma prioridade
            fila.enqueueRight(fila.dequeueLeft());
            movidos++;
        }
        fila.enqueueRight(elemento);
        for (int i = 0; i < tamanho - movidos; i++) {
            fila.enqueueRight(fila.dequeueLeft());
        }
    }

    public T dequeue() throws Exception {
        if (fila.isEmpty()) {
            throw new Exception("Fila vazia.");
        }
        return fila.dequeueLeft();
    }

    public boolean isEmpty() {
        return fila.isEmpty();
    }

    public int size() {
        return fila.size();
    }
}