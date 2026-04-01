package Exercícios_Para_N1.Ex2;
/* Colocar na classe principal:
• A leitura dos dados de N trabalhadores (utilizar um vetor de no máximo
MAX_TRABALHADOR = 50 (constante) objetos da classe Trabalhador. Não se esqueça de
fazer a verificação no main e a sua alocação);
• Calcular a média dos salários dos trabalhadores;
• Apresentar os dados dos homens com salário acima da média;
• Calcular a média dos salários dos homens com idade superior a 30 anos e determinar
quantos homens (com idade superior a 30 ) tem salário abaixo dessa média.
• Determinar e visualizar os dados do trabalhador que possui o maior salário.
• Determinar e visualizar os dados da mulher com menor salário. */
import java.util.Scanner;

public class Ex2 {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        final int MAX_TRABALHADOR = 50;
        // Trabalhador trabalhador1 = new Trabalhador("João Pedro", 10950, "42454667827", 19, 'm', "Rua Monte Alegre 502");
        Trabalhador[] lista = new Trabalhador[MAX_TRABALHADOR];

        System.out.println("Quantos trabalhadores quer cadastrar? (Máx 50) ");
        int n = leitor.nextInt();
        leitor.nextLine(); // limpa o buffer

        float somaSalarios = 0;

        for (int i = 0; i < n; i++) {
            System.out.println("\n--- Cadastro do Trabalhador " + (i + 1) + " ---");
            System.out.print("Nome: "); 
            String nome = leitor.nextLine();
            System.out.print("Salário: "); 
            float salario = leitor.nextFloat();
            System.out.print("CPF: "); 
            leitor.nextLine(); 
            String cpf = leitor.nextLine();
            System.out.print("Idade: "); 
            int idade = leitor.nextInt();
            System.out.print("Sexo (M/F): "); 
            char sexo = leitor.next().toUpperCase().charAt(0);
            System.out.print("Endereço: "); 
            leitor.nextLine(); 
            String endereco = leitor.nextLine();

            // Alocando o objeto na posição i do vetor
            lista[i] = new Trabalhador(nome, salario, cpf, idade, sexo, endereco);
            somaSalarios += salario;
        }

        // Média do Salários e Prints
        float mediaSalarios = 0;
        int contador = 0;
        float somaSal30 = 0;
        mediaSalarios = somaSalarios / n;
        System.out.println("\nDados dos Homens com Salário acima da média: ");
        for (int i = 0; i < n; i++) {
            // Salarios acima da media
            if (lista[i].getSalario() >= mediaSalarios && lista[i].getSexo() == 'M') { lista[i].mostra(); }
            if (lista[i].getIdade() > 30 && lista[i].getSexo() == 'M') {
                contador++;
                somaSal30 += lista[i].getSalario();
            }
        }
        // Salarios dos homens com 30+ anos
        float media30 = 0;
        media30 = somaSal30 / contador;
        contador = 0;
        for (int i = 0; i < n; i++) {
            if (lista[i].getIdade() > 30 && lista[i].getSexo() == 'M') {
                if (lista[i].getSalario() <= media30) {
                    contador++;
                }
            }
        }
        System.out.println("Quantidade de Homens acima dos 30 anos e com media menor: " + contador);

        // Determinar o maior e menor valor de trabalhador
        float comparma = 0;
        float comparme = 10000000;
        int guarda = 0;
        int guarde = 0;
        for (int i = 0; i < n; i++) {
            if (lista[i].getSexo() == 'F') {
                if (lista[i].getSalario() < comparme) {
                    comparme = lista[i].getSalario();
                    guarde = i;
                }
            }
            if (lista[i].getSalario() > comparma) {
                comparma = lista[i].getSalario();
                guarda = i;
            }
        }
        System.out.println("Dados do Maior Salário: ");
        lista[guarda].mostra();
        System.out.println("Dados da Mulher com Menor Salário: ");
        lista[guarde].mostra();


// Extra: lógica de troca (Bubble Sort) para ordenar
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (lista[j].getSalario() < lista[j + 1].getSalario()) {
                    // Troca os objetos de lugar no vetor
                    Trabalhador temp = lista[j];
                    lista[j] = lista[j + 1];
                    lista[j + 1] = temp;
                }
            }
        }
    }
}