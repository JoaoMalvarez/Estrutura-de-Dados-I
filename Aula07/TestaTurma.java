package Aula07;

public class TestaTurma {
    public static void main(String[] args) {
        Turma turma = new Turma();
        turma.adicionaAluno(new Aluno("A", 6.0, 7.0));
        turma.adicionaAluno(new Aluno("B", 4.5, 5.0));
        turma.adicionaAluno(new Aluno("C", 8.5, 9.5));
        turma.imprimeAlunos();

        double media = turma.calculaMedia();
        System.out.printf("Média da Turma = %.2f\n", media);
    }
}
