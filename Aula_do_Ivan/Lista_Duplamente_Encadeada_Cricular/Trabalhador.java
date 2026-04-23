package Lista_Duplamente_Encadeada_Cricular;

public class Trabalhador implements Comparable<Trabalhador> {
    private int id, idade;
    private String regFunc;
    private char sexo;
    private float salario;
    private String cargo;
// Construtor, getters, setters e toString
    public Trabalhador(int id, int idade, String regFunc, char sexo, float salario, String cargo) {
        this.id = id;
        this.idade = idade;
        this.regFunc = regFunc;
        this.sexo = sexo;
        this.salario = salario;
        this.cargo = cargo;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getIdade() { return idade; }
    public void setIdade(int idade) { this.idade = idade; }

    public String getRegFunc() { return regFunc; }
    public void setRegFunc(String regFunc) { this.regFunc = regFunc; }

    public char getSexo() { return sexo; }
    public void setSexo(char sexo) { this.sexo = sexo; }

    public float getSalario() { return salario; }
    public void setSalario(float salario) { this.salario = salario; }

    public String getCargo() { return cargo; }
    public void setCargo(String cargo) { this.cargo = cargo; }  


    
    @Override
    // utilizando como chave de ordenação o atributo regFunc
    public int compareTo(Trabalhador outro) {
    if(regFunc.compareTo(outro.getRegFunc()) < 0) return -1;
    else if(regFunc.compareTo(outro.getRegFunc()) == 0) return 0;
    else return 1;
    } 
}
