package Aula06;

public class Paciente {
    private String nome;
    private int gravidade;

    public Paciente(String nome, int gravidade) {
        this.nome = nome;
        this.gravidade = gravidade;
    }

    public String getNome() {
        return nome;
    }

    public int getGravidade() {
        return gravidade;
    }

    @Override
    public String toString() {
        return nome + " - prioridade " + gravidade;
    }
}
