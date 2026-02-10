import java.util.Scanner;

public class Saudacao {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        // Objeto que lê criado acima

        System.out.print("Digite seu nome: ");
        // o que sai do sistema para a pessoa digitar (tipo print)
        String nome = entrada.nextLine();
        // variável que pega o nome lido e se torna ele (tipo scan)
        System.out.println("Olá, " + nome + "!");
        // print com o nome da pessoa

        System.out.print("Digite sua idade: ");
        // o que sai do sistema
        int idade = entrada.nextInt();
        // variável int que pega o numero e se torna ele
        System.out.println("Você, " + nome + ", têm " + idade + " anos!");
    }
}