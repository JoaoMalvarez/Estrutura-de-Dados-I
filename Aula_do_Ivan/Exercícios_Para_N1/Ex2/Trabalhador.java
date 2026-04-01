package Exercícios_Para_N1.Ex2;

/*
Modifique o exemplo da classe Trabalhador considerando agora os atributos: cpf, nome,
idade, sexo, endereco, salario. Não se esqueça dos métodos get/set. 
*/

public class Trabalhador {
    private String nome;
    private Float salario;
    private String cpf;
    private int idade;
    private char sexo;
    private String endereco;

    // Construtor Padrão
    public Trabalhador () {
    }

    // Construtor com Parâmetros
    public Trabalhador (String nome, float salario, String cpf, int idade, char sexo, String endereco) {
        this.nome = nome;
        this.salario = salario;
        this.cpf = cpf;
        this.idade = idade;
        this.sexo = sexo;
        this.endereco = endereco;
    }

    // Métodos get/set
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public float getSalario() { return salario; }
    public void setSalario(float salario) { this.salario = salario; }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    public int getIdade() { return idade; }
    public void setIdade(int idade) { this.idade = idade; }

    public char getSexo() { return sexo; }
    public void setSexo(char sexo) { this.sexo = sexo; }

    public String getEndereco() { return endereco; }
    public void setEndereco(String endereco) { this.endereco = endereco; }

    private Float salarioAnual;

    public void calculaSalarioAnual(float salario, float salarioAnual) {
        salarioAnual = this.salario * 12;
        this.salarioAnual = salarioAnual;
    }

    // Métodos mostra/salario Anual
    public void mostra() {
        System.out.println("Nome: " + this.nome + "\nCPF: " + this.cpf + "\nIdade: " + this.idade + "\nSexo: " + this.sexo + "\nEndereço: " + this.endereco);
        System.out.print("Salário: " + this.salario + "Salário Anual: " + this.salarioAnual);
    }
}