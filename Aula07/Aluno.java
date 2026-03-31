package Aula07;

public class Aluno {
    // atributos
    private String nome;
    private double nota1;
    private double nota2;

    // construtor
    public Aluno(String nome, double nota1, double nota2) {
        this.nome = nome;
        this.nota1 = nota1;
        this.nota2 = nota2;
    }

    // métodos
    public double calculaMedia() {
        return (nota1 + nota2) / 2;
    }

    @Override
    public String toString() {
        return String.format("%-15s|%5.2f|%5.2f", nome, nota1, nota2);
    }
}