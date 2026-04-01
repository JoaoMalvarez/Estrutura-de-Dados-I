package Exercícios_Para_N1.Ex1;

/*
Crie e compile a classe Carro que possui ano, marca, modelo e categoria com atributos
privados (conforme diagrama UML abaixo: - significa private).
Crie os devidos métodos de acesso (sets e gets) e construtores (padrão e com parâmetros)
Crie um programa principal (com a função main) em que sejam criados dois Carros a partir
de dados fornecidos no código.
*/
public class Carro {
    private int ano;
    private String marca;
    private String modelo;
    private String categoria;
    
    // Construtor Padrão
    public Carro() {
    }

    // Construtor com parâmetros
    public Carro (int ano, String modelo, String marca, String categoria) {
        this.ano = ano;
        this.marca = marca;
        this.modelo = modelo;
        this.categoria = categoria;
    }

    // Métodos de acesso (sets e gets)
    public int getAno() {
        return ano;
    }
    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}