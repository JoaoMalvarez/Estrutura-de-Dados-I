package Lista_Duplamente_Encadeada_Cricular;

public class DLL<T extends Comparable<T>> {
    private Node<T> head; // Ponteiro cabeça da lista
    private int size; // Tamanho da lista
    // DLL(): Construtor vazio
    // inicia o cabeça da lista como null e tamanho = 0
    public DLL(){
        this.head = null; // Primeiro ponteiro está vazio
        this.size = 0; // Tamanho da lista é zero
    }

    public boolean isEmpty() { // Verifica se DLL está vazia
        return head == null; // Se o cabeça é null, a lista está vazia
    }

    public int getSize() { // Retorna o tamanho da lista
        return size;  // Retorna o valor do atributo size
    }

    public boolean isFull() { // Verifica se a lista está cheia
        Node<T> aux = new Node<T>(); // Tenta criar um novo nó
        if (aux == null) return aux == null;// Se o nó criado é null, a lista está cheia
        aux = null; // Apaga o novo nó se ele conseguir ser criado
        return aux == null; // Se chegou aqui ele é falso, e a lista não está cheia
    }

    public void showAscending(){ // Imprime os elementos da lista em ordem crescente
        // Percorre a lista e imprime os valores
        // em ordem Crescente
        if (isEmpty()) System.out.print( "Lista vazia!\n"); // Se a lista está vazia, imprime mensagem
        else{ // Se não
            System.out.print( "Lista: [ "); // Imprime Lista: [
            Node<T> pAnda = this.head; // Cria um ponteiro para percorrer a lista
            while (pAnda.getRight() != this.head){ // Enquanto o ponteiro não chegar no cabeça
                System.out.print( pAnda.getData() + " "); // Imprime o valor do nó
                pAnda= pAnda.getRight(); // Move o ponteiro para o nó da direita
            }
            System.out.print( pAnda.getData() +"]"); // Imprime o último valor do nó e fecha a lista com ]
        }
    }

    public void showDescending(){ // Imprime os elementos da lista em ordem decrescente
        // Percorre a lista e imprime os valores
        // em ordem decrescente
        if (isEmpty()) System.out.print( "Lista vazia!\n" ); // Se a lista está vazia, imprime mensagem
        else{ // Se não
            System.out.print( "Lista: [ " ); // Imprime Lista: [
            Node<T> pAnda = this.head; // Cria um ponteiro para percorrer a lista
            while (pAnda.getLeft() != this.head){ // Enquanto o ponteiro não chegar no cabeça
                pAnda= pAnda.getLeft(); // Move o ponteiro para o nó da esquerda
                System.out.print( pAnda.getData() + " " ); // Imprime o valor do nó
            }
            System.out.print( pAnda.getLeft().getData() + "]"); // Imprime o último valor do nó e fecha a lista com ]
        }
    }

    public int searchAscending(T data){ // Procura um elemento (data) na lista e retorna sua posição
        if (isEmpty()) return -1; // Se a lista está vazia, retorna -1
        // Procura o elemento
        Node<T> pAnda = this.head; // Cria um ponteiro para percorrer a lista
        int pos = 1; // Inicia na posição 1
        while (pAnda.getRight() != this.head && pAnda.getData().compareTo(data) != 0){ // Enquanto o ponteiro não chegar no cabeça e o valor do nó for diferente do valor procurado 
            pAnda = pAnda.getRight(); // Move o ponteiro para o nó da direita
            pos++; // Incrementa a posição
        }
        if (pAnda.getRight() == this.head && pAnda.getData().compareTo(data) != 0){// Se o ponteiro chegou no cabeça e o valor do nó for diferente do valor procurado, elemento não encontrado
            return -1; // Elemento não encontrado, retorna -1
        } else { // Elemento encontrado
            return pos; // Retorna a posição do elemento encontrado
        } 
    }

    public boolean insertAscending(T data){ // Insere um elemento (data) na lista em ordem crescente
        if (isFull()) return false; // Se a lista está cheia, retorna false
        // Cria um novo no
        Node<T> novoNo = new Node<T>(data, null, null); // Cria um novo nó com o valor data e ponteiros null
        // se lista vazia, insere o nó no ponteiro cabeça
        // e faz o nó apontar para ele mesmo
        if (isEmpty()) { // Se a lista está vazia
            this.head = novoNo; // O cabeça da lista aponta para o novo nó
            novoNo.setRight(novoNo); // O nó aponta para ele mesmo pela direita
            novoNo.setLeft(novoNo); // O nó aponta para ele mesmo pela esquerda
        } else { // Se a lista não está vazia
            Node<T> pAnda = this.head, pAnt = null; // Cria dois ponteiros para percorrer a lista, um para o nó atual e outro para o nó anterior
            while (pAnda.getRight() != head && pAnda.getData().compareTo(data) < 0){ // Enquanto o ponteiro não chegar no cabeça e o valor do nó for menor que o valor a ser inserido
                pAnt = pAnda; // O ponteiro anterior aponta para o nó atual
                pAnda = pAnda.getRight(); // Move o ponteiro para o nó da direita
            } 
            // Inserção antes do cabeça
            if (pAnt == null && pAnda.getData().compareTo(data) > 0){ // Se o ponteiro anterior é null e o valor do nó é maior que o valor a ser inserido
                novoNo.setLeft(this.head.getLeft()); // O nó a ser inserido aponta para o nó da esquerda do cabeça 
                this.head.getLeft().setRight(novoNo);// O nó da esquerda do cabeça aponta para o nó a ser inserido pela direita
                this.head.setLeft(novoNo); // O cabeça da lista aponta para o nó a ser inserido pela esquerda
                novoNo.setRight(this.head); // O nó a ser inserido aponta para o cabeça da lista pela direita
                this.head = novoNo; // O cabeça da lista aponta para o nó a ser inserido
            // Inserção no meio da lista
            } else { // Se o ponteiro anterior não é null e o valor do nó é maior que o valor a ser inserido    
                if (pAnda.getData().compareTo(data) > 0 && pAnt != null) { // Se o valor do nó é maior que o valor a ser inserido e o ponteiro anterior não é null
                pAnt.getRight().setLeft(novoNo); // O nó da direita do ponteiro anterior aponta para o nó a ser inserido pela esquerda
                novoNo.setRight(pAnda); // O nó a ser inserido aponta para o nó atual pela direita
                pAnt.setRight(novoNo); // O ponteiro anterior aponta para o nó a ser inserido pela direita
                novoNo.setLeft(pAnt); // O nó a ser inserido aponta para o ponteiro anterior pela esquerda
                } else {// Senão, insere a Key depois do pAnda
                    pAnda.getRight().setLeft(novoNo); // O nó da direita do nó atual aponta para o nó a ser inserido pela esquerda
                    novoNo.setRight(pAnda.getRight()); // O nó a ser inserido aponta para o nó da direita do nó atual pela direita
                    pAnda.setRight(novoNo); // O nó atual aponta para o nó a ser inserido pela direita
                    novoNo.setLeft(pAnda); // O nó a ser inserido aponta para o nó atual pela esquerda
                } 
            } 
        }
        this.size++; // Incrementa o tamanho da lista
        return true; // Retorna true para indicar que a inserção foi bem sucedida
    }

    public boolean insert (T data) { // Insere um elemento (data) na lista
        if (isFull()) return false;  // Se a lista está cheia, retorna false
        // Cria um novo no
        Node<T> aux = new Node<T>(data, null, null); // Cria um novo nó com o valor data e ponteiros aux
        if (isEmpty()) { // Se a lista está vazia
            head = aux; // O cabeça da lista aponta para o nó auxiliar
            size++; // Incrementa o tamanho da lista
            return true; // Retorna true para indicar que a inserção foi bem sucedida
        }
        // Procura a posição de inserção
        Node<T> pAnda = head; // Cria um ponteiro para percorrer a lista
        while ((data.compareTo(pAnda.getData()) > 0 ) && (pAnda.getRight() != head)) { // Enquanto o valor do nó for menor que o valor a ser inserido e o ponteiro não chegar no cabeça
            pAnda = pAnda.getRight(); // Move o ponteiro para o nó da direita
        }
        // Inserção antes do cabeça
        if (pAnda == head) { // Se o ponteiro chegou no cabeça
            aux.setLeft(head.getLeft()); // O nó a ser inserido aponta para o nó da esquerda do cabeça pela esquerda
            aux.setRight(head); // O nó a ser inserido aponta para o cabeça da lista pela direita 
            pAnda.setLeft(aux); // O cabeça da lista aponta para o nó a ser inserido pela esquerda
            head = aux; // O cabeça da lista aponta para o nó a ser inserido
            head.getLeft().setRight(aux); // O nó da esquerda do cabeça aponta para o nó a ser inserido pela direita
        } else if (data.compareTo(pAnda.getData()) < 0){ // Inserção no meio da lista
            aux.setRight(pAnda); // O nó a ser inserido aponta para o nó atual pela direita
            aux.setLeft(pAnda.getLeft()); // O nó a ser inserido aponta para o nó da esquerda do nó atual pela esquerda
            pAnda.setLeft(aux); // O nó atual aponta para o nó a ser inserido pela esquerda
            aux.getLeft().setRight(aux); // O nó da esquerda do nó atual aponta para o nó a ser inserido pela direita
        // Inserção no final da lista
        } else { // Se o valor do nó é menor que o valor a ser inserido
            aux.setLeft(pAnda); // O nó a ser inserido aponta para o nó atual pela esquerda
            aux.setRight(head); // O nó a ser inserido aponta para o cabeça da lista pela direita
            pAnda.setRight(aux); // O nó atual aponta para o nó a ser inserido pela direita
            head.setLeft(aux); // O cabeça da lista aponta para o nó a ser inserido pela esquerda
        }
        size++; // Incrementa o tamanho da lista
        return true; // Retorna true para indicar que a inserção foi bem sucedida
    }
    
    public Node<T> get(int pos){ // Retorna o nó da posição pos
        if (isEmpty()) return null; // Se a lista está vazia, retorna null
        if (pos <= 0 || pos > size) return null; // Se a posição é inválida, retorna null
        int cont = 1; // Inicia contador na posição 1
        Node<T> pAnda = head; // Cria um ponteiro para percorrer a lista
        while (cont != pos){ // Enquanto o contador não chegar na posição desejada
            pAnda = pAnda.getRight(); // Move o ponteiro para o nó da direita
            cont++; // Incrementa o contador
        }
        return pAnda; // Retorna o nó da posição pos
    }

    public void clear(){ // Limpa a lista, removendo todos os elementos
        Node<T> pAnt, pAnda = head; // Cria dois ponteiros para percorrer a lista, um para o nó atual e outro para o nó anterior
        int total = size; // Armazena o tamanho da lista para controlar o loop
        int cont = 0; // Inicia contador na posição 0
        while(cont != total){ // Enquanto o contador não chegar no total de elementos da lista
        // Libera o nó atual
            pAnt = pAnda; // O ponteiro anterior aponta para o nó atual
            pAnda = pAnda.getRight(); // Move o ponteiro para o nó da direita
            pAnt.setRight(null); // O nó anterior aponta para null pela direita
            pAnt.setLeft(null); // O nó anterior aponta para null pela esquerda
            pAnt = null; // Libera o nó anterior
            cont++; // Incrementa o contador
        }
        size = 0; // Reseta o tamanho da lista para zero
        head = null; // Reseta o cabeça da lista para null
    }

    public boolean remove(T data) { // Remove um elemento (data) da lista e retorna true se a remoção foi bem sucedida, ou false caso contrário
        // Lista vazia
        if (isEmpty()) return false; // Se a lista está vazia, retorna false
        // Procura o elemento a ser removido
        Node<T> pAnda = this.head, pAnt = null; // Cria dois ponteiros para percorrer a lista, um para o nó atual e outro para o nó anterior
        while (pAnda.getRight() != this.head && pAnda.getData().compareTo(data) != 0){ // Enquanto o ponteiro não chegar no cabeça e o valor do nó for diferente do valor a ser removido
            pAnt = pAnda; // O ponteiro anterior aponta para o nó atual
            pAnda = pAnda.getRight(); // Move o ponteiro para o nó da direita
        }
        // Elemento não encontrado
        if (pAnda.getRight() == this.head && pAnda.getData().compareTo(data) != 0){ // Se o ponteiro chegou no cabeça e o valor do nó for diferente do valor a ser removido
            return false; // Elemento não encontrado, retorna false
        } else {
            // Elemento encontrado no cabeça
            if (pAnt == null && pAnda.getData().compareTo(data) == 0){ // Se o ponteiro anterior é null e o valor do nó é igual ao valor a ser removido
                pAnda.getLeft().setRight(pAnda.getRight()); // O nó da esquerda do cabeça aponta para o nó da direita do cabeça pela direita
                this.head = this.head.getRight(); // O cabeça da lista aponta para o nó da direita do cabeça
                this.head.setLeft(pAnda.getLeft()); // O cabeça da lista aponta para o nó da esquerda do cabeça pela esquerda
                pAnda.setLeft(null); // O nó a ser removido aponta para null pela esquerda
                pAnda.setRight(null); // O nó a ser removido aponta para null pela direita
            // Elemento encontra-se no meio da lista
            } else { // Se o ponteiro anterior não é null e o valor do nó é igual ao valor a ser removido
                pAnt.setRight(pAnda.getRight()); // O ponteiro anterior aponta para o nó da direita do nó atual pela direita
                pAnda.getRight().setLeft(pAnt); // O nó da direita do nó atual aponta para o ponteiro anterior pela esquerda
                pAnda.setLeft(null); // O nó a ser removido aponta para null pela esquerda
                pAnda.setRight(null); // O nó a ser removido aponta para null pela direita
            }
            pAnda = null; // Libera o nó a ser removido
            this.size--; // Decrementa o tamanho da lista
            return true; // Retorna true para indicar que a remoção foi bem sucedida
        }
    }

    public Node<T> remove(int pos) { // Remove um elemento da posição pos da lista e retorna o nó removido, ou null caso a posição seja inválida ou a lista esteja vazia
        // Lista vazia
        if (isEmpty()) return null; // Se a lista está vazia, retorna null
        if (pos <= 0 || pos > size) return null; // Se a posição é inválida, retorna null
        // Procura o elemento a ser removido
        Node<T> pAnda = this.head, pAnt = null; // Cria dois ponteiros para percorrer a lista, um para o nó atual e outro para o nó anterior
        int cont = 1; // Inicia contador na posição 1
        while (pAnda.getRight() != this.head && cont != pos){ // Enquanto o ponteiro não chegar no cabeça e o contador não chegar na posição desejada
            pAnt = pAnda; // O ponteiro anterior aponta para o nó atual 
            pAnda = pAnda.getRight(); // Move o ponteiro para o nó da direita
            cont++; // Incrementa o contador
        }
        // Elemento não encontrado
        if (pAnda.getRight() == this.head && cont != pos){ // Se o ponteiro chegou no cabeça e o contador não chegou na posição desejada
            return null; // Elemento não encontrado, retorna null
        // Elemento encontrado no cabeça
        } else { // Se o ponteiro chegou no cabeça e o contador chegou na posição desejada
            if (cont == 1){ // Se o contador é igual a 1, o elemento a ser removido é o cabeça da lista
                pAnda.getLeft().setRight(pAnda.getRight()); // O nó da esquerda do cabeça aponta para o nó da direita do cabeça pela direita
                this.head = this.head.getRight(); // O cabeça da lista aponta para o nó da direita do cabeça
                this.head.setLeft(pAnda.getLeft()); // O cabeça da lista aponta para o nó da esquerda do cabeça pela esquerda
                pAnda.setLeft(null); // O nó a ser removido aponta para null pela esquerda
                pAnda.setRight(null); // O nó a ser removido aponta para null pela direita
            // Elemento encontra-se no meio da lista
            } else { // Se o contador é diferente de 1, o elemento a ser removido não é o cabeça da lista 
                pAnt.setRight(pAnda.getRight()); // O ponteiro anterior aponta para o nó da direita do nó atual pela direita
                pAnda.getRight().setLeft(pAnt); // O nó da direita do nó atual aponta para o ponteiro anterior pela esquerda
                pAnda.setLeft(null); // O nó a ser removido aponta para null pela esquerda
                pAnda.setRight(null); // O nó a ser removido aponta para null pela direita
            }
            this.size--; // Decrementa o tamanho da lista
            return pAnda; // Retorna o nó removido
        }
    }

    @Override
    // O toString imprime os elementos da lista e a quantidade de elementos
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
