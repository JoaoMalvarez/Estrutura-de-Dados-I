package Exercícios_Para_N1.Ex1;

public class Ex1 {
    public static void main(String[] args) {
        // Criando o primeiro carro usando Construtor com Parâmetros
        Carro carro1 = new Carro(1993, "Toyota", "Corolla", "Esportivo");

        // Criando o segundo carro usando o Construtor Padrão
        Carro carro2 = new Carro();
        carro2.setAno(2025);
        carro2.setModelo("Civic");
        carro2.setMarca("Honda");
        carro2.setCategoria("Comercial");
        
        // Exibição de Dados
        System.out.printf("Carro 1:\nAno: %d\nMarca: %s\nModelo: %s\nCategoria: %s", carro1.getAno(), carro1.getMarca(), carro1.getModelo(), carro1.getCategoria());
        System.out.println("Carro 2: \n" + carro2.getAno() + " " + carro2.getMarca() + "\n" + carro2.getModelo() + " " + carro2.getCategoria());

    }
}
