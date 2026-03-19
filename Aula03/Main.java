//Esse main pegou a pilha e está fazendo a transcrição de:
// decimal para binário (assim como na conta que fazemos)

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.print("Número decimal: ");
        int numero = entrada.nextInt();
        int numeroSalvo = numero;
        int resto;
        try {
            Pilha<Integer> p = new Pilha<>(20);
            do {
                resto = numero % 2;
                p.push(resto);
                numero = numero / 2;
            } while (numero != 0);

            System.out.printf("Total de elementos na pilha: %d\n", p.sizeElements());
            System.out.printf("O correspondente binario do valor %d e: ", numeroSalvo);
            while (!p.isEmpty()) {
                System.out.print(p.pop());
            }
            System.out.println();
        }
        catch (Exception e) {
            System.out.printf("Erro:  %s\n", e.getMessage());
        }
    entrada.close();    
    }
} 