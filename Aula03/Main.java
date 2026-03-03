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

        Pilha p = new Pilha (20);
        do {
            resto = numero % 2;
            p.push(resto); 
            numero = numero / 2;
        } while (numero != 0); 

        System.out.printf("Total de elementos na pilha: %d\n", +p.sizeElements());
        System.out.printf("O correspondente binário do valor %d é: ");
        while (! p.isEmpty( )) System.out.print( p.pop( )); 




        try{
            p.push(5);
        } catch(Exception e){
            System.out.println("Algo deu errado");
        }
        //vai tentar pegar a excessão e vai trata-la

    }
}