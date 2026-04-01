package Exercícios_Para_N1.Ex3;
/*i. Os quatro últimos atributos representam as notas do aluno em quatro disciplinas.
ii. Programe os três métodos construtores, conforme modelo UML.
iii. Defina um método que permita calcular e retornar a média das notas de um aluno.
iv. Define um método que avalia a situação do aluno no curso e verifica se média >=6,
verdadeiro = “aluno aprovado”, e falso, caso contrário.
v. Defina outro método que mostre na tela todos os dados de um aluno, inclusive sua
média e sua situação (Utilize os métodos dos itens iii e iv).
*/

public class Aluno {
    private String rgm;
    private String nome;
    private char sexo;
    private float notaA;
    private float notaB;
    private float notaC;
    private float notaD;

    // Construtor Padrão
    public Aluno() {
    }

    // Construtor Parcial
    public Aluno(String rgm, String nome){
    }

    // Construtor Completo  
    public Aluno(String rgm, String nome, char sexo, float notaA, float notaB, float notaC, float notaD) {
        this.rgm = rgm;
        this.nome = nome;
        this.sexo = sexo;
        this.notaA = notaA;
        this.notaB = notaB;
        this.notaC = notaC;
        this.notaD = notaD;
    }

    // métodos padrão
    public String getRgm() { return rgm; }
    public void setRgm(String rgm) { this.rgm = rgm; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public char getSexo() { return sexo; }
    public void setSexo(char sexo) { this.sexo = sexo; }

    public float getNotaA() { return notaA; }
    public void setNotaA(float notaA) { this.notaA = notaA; }

    public float getNotaB() { return notaB; }
    public void setNotaB(float notaB) { this.notaB = notaB; }

    public float getNotaC() { return notaC; }
    public void setNotaC(float notaC) { this.notaC = notaC; }

    public float getNotaD() { return notaD; }
    public void setNotaD(float notaD) { this.notaD = notaD; }

    public float media() {
        float conta = 0;
        conta = this.notaA + this.notaB + this.notaC + this.notaD;
        conta = conta / 4;
        return conta;
    }

    public Boolean avalia(float conta) {
        if (conta >= 6) {
            return true;
        } else {
            return false;
        }
    }

    public void mostra() {
        System.out.println("RA: " + this.rgm + "Nome: " + this.nome + "Sexo: " + this.sexo);
        System.out.println("Nota A: " + this.notaA + ", Nota B: " +this.notaB + ", Nota C: " + this.notaC + ", Nota D: " + this.notaD);
        System.out.println("Média: " + media());
        if (avalia(media()) == true ) { System.out.println("Aluno Aprovado"); } else { System.out.println("Aluno Reprovado"); }
    }
}
