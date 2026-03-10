public class Contador {
    // atributos
    int valor;
    
    // construtores
    public Contador() {
        valor = 0;
    }
    
    // métodos
    public void incrementa() {
        valor++;
    }
    
    public void zera() {
        valor = 0;
    }
    
    public int getValor() {
        return valor;
    }
}