package Exercícios_Para_N1.Ex3;
/*vi. Defina uma classe principal em outro arquivo que criará dois objetos da classe Aluno
(por exemplo, com seus dados e os de um colega da turma). Mostre na tela os dados
destes dois alunos, utilizando o método solicitado no item anterior. */

public class Ex3 {
    public static void main(String[] args) {
        Aluno aluno1 = new Aluno("100", "Joao", 'M', 10, 6, 8, 9);
        Aluno aluno2 = new Aluno("101,", "Fernanda", 'F', 5, 9, 4, 2);

        aluno1.mostra();
        aluno2.mostra();
    }

}