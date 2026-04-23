package Lista_Encadeada_Circular;

public class CircleLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;
    public CircleLinkedList() {
        head = tail = null; // começa com a cabeça e o rabo sendo nulos
        size = 0; // e com o tamanho igual a 0
    }
    
    public boolean isEmpty() { // ESTÁ VAZIA?
        return head == null; // verifica se a cabeça é nula
    } 

    public boolean isFull() { // ESTÁ CHEIA?
        Node<T> aux = new Node<T>();
        return aux == null; // verifica se o nó auxiliar é nulo, indicando que não há mais memória disponível
    }

    public int getSize() { // PEGUE O TAMANHO
        return size; // retorna tamanho
    }

    public Node<T> getHead() { // PEGUE A CABEÇA
        return head; // retorna a cabeça 
    }

    public Node<T> getTail() { // PEGUE O RABO
        return tail; // retorna o rabo
    } 

    public Node<T> get(int pos) { // PEGUE O NÓ NA POSIÇÃO DADA
        if (isEmpty()) 
            return null; // se vazia, retorna nada
        if (pos <= 0 || pos > size)     
            return null; // se posição inválida, retorna nada
        int cont = 1; // contador
        Node<T> pAnda = head; // ponteiro que anda
        while (cont != pos) {
            pAnda = pAnda.getProx(); // anda para o próximo nó
            cont++; // incrementa o contador
        }
        return pAnda; // retorna o valor do nó na posição desejada
    }

    public boolean insertHead(T data) { // INSERE O VALOR DADO NA CABEÇA DA LISTA
        Node<T> aux; // Ponteiro auxiliar para o novo nó a ser inserido
        if (!isFull()) {
            aux = new Node<T>(data, null); // Cria um novo nó com o dado a ser inserido
            if (isEmpty()) { // se estiver vazia
                head = tail = aux; // o novo nó se torna a cabeça e o rabo
                aux.setProx(head); // o próximo do novo nó aponta para ele mesmo, formando a circularidade
            } else { // se não
                aux.setProx(head); // o próximo do novo nó aponta para a cabeça atual
                head = aux; // o novo nó se torna a nova cabeça
                tail.setProx(head); // o próximo do rabo aponta para a nova cabeça, mantendo a circularidade
            }
            size++; // aumenta o tamanho
            return true; // inserção realizada com sucesso
        }

        else return false; // se não há memória disponível, retorna false
    }

    public boolean addFirst(T data) { // INSERE O VALOR DADO NO COMEÇO DA LISTA (msm coisa que o insertHead)
        Node<T> aux;
        if (!isFull()){
            aux = new Node<T>(data, null);
            if (isEmpty()){ // Lista está vazia
                head = tail = aux;
                aux.setProx(head);
            }else { // Insere no começo e atualiza os ponteiros
                aux.setProx(head);
                head = aux;
                tail.setProx(head);
            }
            size++;
            return true;
        }
        else return false; 
    }

    public boolean insertTail(T data){ // INSERE O VALOR DADO NO RABO DA LISTA
        Node<T> aux;
        if (!isFull()){ // se estiver cheio
            aux = new Node<T>(data, null); // cria um novo nó
            if (isEmpty()){ // se a lista está vazia
                aux.setProx(head); // o próximo do novo nó aponta para a cabeça (que é nula)
                head = tail = aux; // o novo nó se torna a cabeça e o rabo
            }else { // se não
                tail.setProx(aux); // o próximo do rabo atual aponta para o novo nó
                aux.setProx(head); // o próximo do novo nó aponta para a cabeça, mantendo a circularidade
                tail = aux; // o novo nó se torna o novo rabo
            }
            size++; // aumenta o tamanho
            return true; // inserção realizada com sucesso
        }
        else return false; // se não há memória disponível, retorna false
    }

    public boolean addLast(T data){ // INSERE O VALOR DADO NO FIM DA LISTA (msm coisa que o insertTail)
        Node<T> aux;
        if (!isFull()){ // Não há espaço de memória
            aux = new Node<T>(data, null);
            if (isEmpty()){ // Lista está vazia insere no cabeça
                aux.setProx(head);
                head = tail = aux;
            }else { // Insere no final e atualiza os ponteiros
                tail.setProx(aux);
                aux.setProx(head);
                tail = aux;
            }
            size++;
            return true;
        }
        else return false;
    }

    public boolean insert(T data, int pos) { // INSERE O VALOR DADO NA POSIÇÃO DADA
        Node<T> aux; // ponteiro auxiliar para o novo nó a ser inserido
        Node<T> pAnda; // ponteiro que anda na lista ligada
        Node<T> pAnt = null; // ponteiro anterior ao que anda
        if (pos <= 0) return false; // Se posição inválida, não insere e retorna
        if (!isFull()){ // se não está cheio (tem memória)
            aux = new Node<T>(data, null); 
            if (isEmpty()){ // se está vazio
                head = tail = aux; // insere no começo da lista
            } else if (pos >= size+1) { // se a posição for maior ou igual ao tamanho + 1
                insertTail(data); // insere no final da lista
            } else {// se a posição a inserir está no meio da lista
                int cont = 1; // contador = 1
                pAnda = head; // Ponteiro que anda até a posição de inserção
                // Procura a posição de inserção
                while (cont != pos){ // enquanto o contador não for a posição
                    pAnt = pAnda; // ponteiro anterior recebe o valor do ponteiro que anda
                    pAnda = pAnda.getProx(); // ponteiro que anda recebe o próximo nó
                    cont++; // incrementa o contador
                }
                aux.setProx(pAnda); // o próximo do novo nó aponta para o nó atual na posição de inserção
                if (cont == 1) { // se o contador for 1 (ou seja a posição é a cabeça da lista), insere no começo
                    head = aux; // o novo nó se torna a nova cabeça
                    tail.setProx(head); // o próximo do rabo aponta para a nova cabeça, mantendo a circularidade
                } else { // se não for a cabeça da lista, insere no meio
                    pAnt.setProx(aux); // o próximo do nó anterior aponta para o novo nó, inserindo-o no meio da lista
                }
            }
            size++; // aumenta o tamanho
            return true; // inserção realizada com sucesso
        }
        else return false; // se não há memória disponível, retorna false
    }

    public Node<T> search(T data){ // PROCURA O NÓ COM O VALOR DADO E RETORNA A REFERÊNCIA PARA ELE
        Node<T> pAnda;
        if (isEmpty()) {
            return null; // Lista vazia, retorna null
        }else{
            pAnda = head; // Ponteiro que anda na lista ligada começa na cabeça
            // enquanto o próximo do ponteiro que anda não for a cabeça e o dado do nó atual não for igual ao dado procurado
            while ((pAnda.getProx() != head) && (pAnda.getData().equals(data) != true)) 
                pAnda = pAnda.getProx(); // anda para o próximo nó
            if (pAnda.getData().equals(data)) // se o dado do nó atual for igual ao dado procurado
                return pAnda; // Retorna a referência para o No
            return null; // elemento não encontrado
        }
    }

    public void print(){ // IMPRIME O CONTEÚDO DA LISTA
        Node<T> pAnda;
        System.out.print("L: [ "); // Imprime L: [ (para indicar o início da lista)
        if (!isEmpty()) { // se a lista não estiver vazia
            pAnda = head; // Ponteiro que anda na lista ligada começa na cabeça
            while (pAnda.getProx() != head) { // enquanto o próximo do ponteiro que anda não for a cabeça (ou seja, enquanto não tiver percorrido toda a lista)
                System.out.print(pAnda.getData()+" "); // Imprime o dado do nó atual seguido de um espaço
                pAnda = pAnda.getProx(); // anda para o próximo nó
            }
            System.out.print(pAnda.getData()+" "); // Imprime o dado do último nó (que é o rabo da lista)
        }
        System.out.print("], Quantidade: " + size + ".\n"); // Imprime ], Quantidade: (para indicar o fim da lista e a qntd de elem)
    }

    public void clear(){ // LIMPA A LISTA
        Node<T> pAnt, pAnda = head; // Ponteiro que anda na lista ligada começa na cabeça
        while(pAnda.getProx() != head){ // enquanto o próximo do ponteiro que anda não for a cabeça
            pAnt = pAnda; // ponteiro anterior recebe o valor do ponteiro que anda
            pAnda = pAnda.getProx(); // ponteiro que anda recebe o próximo nó
            pAnt.setProx(null); // o próximo do nó anterior é setado para null, desconectando-o da lista
            pAnt = null; // o nó anterior é setado para null, permitindo que seja coletado pelo garbage collector
        }
        size = 0; // o tamanho é resetado para 0
        tail = head = null; // a cabeça e o rabo são setados para null, indicando que a lista está vazia
    }

    public boolean remove(T data){ // REMOVE O NÓ COM O VALOR DADO
        Node<T> pAnda; // Ponteiro que anda na lista ligada
        Node<T> pAnt = null; // Ponteiro anterior ao que anda, inicialmente setado para null
        if (isEmpty()) return false; // Se lista vazia, não é possível remover
        else{ // caso haja elementos na lista
            pAnda = head; // Ponteiro que anda na lista ligada começa na cabeça
            int contador = 1; // contador = 1
            while ((contador != size) && (pAnda.getData().equals(data) != true)){ 
            // enquanto o contador não for igual ao tamanho da lista e o dado do nó atual não for igual ao dado a ser removido
                pAnt = pAnda; // ponteiro anterior recebe o valor do ponteiro que anda
                pAnda = pAnda.getProx(); // ponteiro que anda recebe o próximo nó
                contador++; // incrementa o contador
            }
            if ((contador == size) && (pAnda.getData().equals(data) != true))
            // se o contador for igual ao tamanho da lista e o dado do nó atual não for igual ao dado a ser removido, significa que o elemento não foi encontrado na lista
                return false; // retorna falso, se não encontrado
            else { // Se elemento foi encontrado
                if (size == 1) { // se tem somente um elemento na lista
                    head = tail = null; // a cabeça e o rabo são setados para null, resetando
                } else if ((head == pAnda)) { // se o elemento a ser removido for a cabeça da lista
                    head = pAnda.getProx(); // a cabeça é atualizada para o próximo nó da cabeça atual
                    tail.setProx(head); // o próximo do rabo é atualizado para a nova cabeça, mantendo a circularidade
                } else { // se o elemento estiver no meio
                    if (pAnda == tail) // se o elemento a ser removido for o rabo da lista
                        tail = pAnt; // o rabo é atualizado para o nó anterior ao rabo atual
                    pAnt.setProx(pAnda.getProx()); // o próximo do nó anterior é atualizado para o próximo nó do nó atual, desconectando o nó atual da lista
                }
                pAnda.setProx(null); // o próximo do nó atual é setado para null, desconectando-o da lista
                pAnda = pAnt = null; // o nó atual e o nó anterior são setados para null, permitindo que sejam coletados pelo garbage collector
                size--; // o tamanho é decrementado
                return true; // remoção realizado como sucesso
            }
        }
    }

    public T pollFirst(){ // REMOVE O PRIMEIRO NÓ DA LISTA E RETORNA O DADO
        if (isEmpty()) return null; // Se lista vazia, não é possível remover
        else{ // se a lista não estiver vazia
            Node<T> pAux = head; // ponteiro auxiliar recebe a cabeça da lista, que é o nó a ser removido
            if (size == 1) { // se o tamanho é 1
                head = tail = null; // a cabeça e o rabo são setados para null
            } else { // se há mais de um elemento na lista
                head = head.getProx(); // a cabeça é atualizada para o próximo nó da cabeça atual
                tail.setProx(head); // o próximo do rabo é atualizado para a nova cabeça, mantendo a circularidade
            }
            size--; // o tamanho é decrementado
            return pAux.getData(); // retorna o dado do nó removido
        }
    }

    public T pollLast(){ // REMOVE O ÚLTIMO NÓ DA LISTA E RETORNA O DADO
        if (isEmpty()) return null; // Se lista vazia, não é possível remover
        else{ // se a lista não estiver vazia
            Node<T> pAnda = head, pAnt = null; // ponteiro que anda
            int contador = 1; // contador = 1
            while ((contador != size)){ // enquanto o cantador não for igual ao tamanho
                pAnt = pAnda; // ponteiro anterior recebe o valor do ponteiro que anda
                pAnda = pAnda.getProx(); // ponteiro que anda recebe o próximo nó
                contador++; // incrementa o contador
            } // Remove o elemento e retorna o dado
            if (size == 1) { // se o tamanho é 1
                head = tail = null; // a cabeça e o rabo são setados para null
            } else { // se há mais de um elemento na lista
                tail = pAnt; // o rabo é atualizado para o nó anterior ao rabo atual
                pAnt.setProx(pAnda.getProx()); // o próximo do nó anterior é atualizado para o próximo nó do nó atual, desconectando o nó atual da lista
            }
            size--; // o tamanho é decrementado
            return pAnda.getData(); // retorna o dado do nó removido
        } 
    }
    
    @Override
    public String toString() { // RETORNA UMA STRING COM O CONTEÚDO DA LISTA
        StringBuilder sb = new StringBuilder(); // StringBuilder para construir a string de saída
        int qtde = 0; // contador para percorrer a lista
        sb.append("\n[Lista]\n"); // imprime [Lista]
        sb.append("L: [ "); // Imprime L: [ (para indicar o início da lista)
        Node<T> pAnda = head; // Ponteiro que anda na lista ligada começa na cabeça
        while (qtde != size) { // enquanto o contador não for igual ao tamanho da lista
            sb.append(pAnda.getData()+" "); // Imprime o dado do nó atual seguido de um espaço
            qtde++; // incrementa o contador
            pAnda = pAnda.getProx(); // anda para o próximo nó
        }
        sb.append("]\n"); // Imprime ] (para indicar o fim da lista)
        sb.append("Quantidade: " + size); // Imprime Quantidade, imprimindo dps a qntd de elementos na lista
        if (size != 0) { // se a lista não estiver vazia
            sb.append("\nPrimeiro: " + head.getData() + ", Ultimo: " + tail.getData()); // imprime o dado do primeiro e do último elemento da lista
        }
        sb.append("\n"); // quebra de linha
        return sb.toString(); // retorna a string construída
    }

}