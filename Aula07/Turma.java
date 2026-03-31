package Aula07;

public class Turma {
    // atributos
    LinkedList<Aluno> alunos;

    // construtor
    public Turma() {
        this.alunos = new LinkedList<Aluno>();
    }

    // métodos
    public void adicionaAluno(Aluno a) {
        alunos.addLast(a);
    }

    public void imprimeAlunos() {
        Aluno aux;
        int tamanho = alunos.getSize();
        for (int i = 1; i <= tamanho; i++) {
            aux = alunos.get(i).getDado();
            System.out.println(aux);
        }
    }

    public double calculaMedia() {
        double soma = 0;
        double quantidade = 0;
        if (!alunos.isEmpty()) {
            Node<Aluno> pAnda = alunos.getHead();
            while (pAnda != null) {
                soma +=  pAnda.getDado().calculaMedia();
                quantidade++;
                pAnda = pAnda.getProx();
            }
            return soma / quantidade;
        }
        return 0.0;
    }
}
