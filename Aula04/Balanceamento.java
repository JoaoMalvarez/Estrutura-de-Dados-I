/*Desenvolva um programa que verifique se uma expressão 
matemática possui parênteses balanceados. Uma expressão 
possui parênteses balanceados quando:
Cada abre parêntese "(" tem um fecha parêntese ")" 
correspondente. O fechamento ocorre na ordem correta.
Regras:
1. O programa deve ler uma string contendo a expressão (exemplo: "
((2+3)*5)" ).
2. Utilizar uma pilha para armazenar os parênteses de abertura.
3. Ao encontrar um parêntese de fechamento “)” deve-se verificar se existe
um parêntese de abertura correspondente no topo da pilha:
Se existir, desempilhar.
Se não existir, a expressão está incorreta.
4. Ao final da leitura:
Se a pilha estiver vazia → a expressão está correta.
Se a pilha não estiver vazia → a expressão está incorreta.
Exemplos de Entrada/Saída esperada:
Entrada: (2+3)*(5+7) → Saída: Parênteses balanceados
Entrada: ((2+3)*5 → Saída: Parênteses não balanceados
Entrada: (2+3)*5) → Saída: Parênteses não balanceados

 */

import java.util.Scanner;
public class Balanceamento {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.print("Expressão: ");
        String expressao = entrada.nextLine();
        if (estaBalanceada(expressao)) {
            System.out.println("Os parenteses estão balanceados.");
        }
        else {
            System.out.println("Os parenteses não estão balanceados.");
        }
        entrada.close();
    }
 
    public static boolean estaBalanceada(String expressao) {
        exPilha<Character> p = new exPilha<Character>();
        for (int i = 0; i < expressao.length(); i++) {
            char c = expressao.charAt(i);
            try {
                if (c == '(') {
                    p.push(c);
                }
                else if (c == ')') {
                    if (!p.isEmpty()) {
                        p.pop();
                    }
                    else {
                        return false;
                    }
                }
            } catch (Exception e) {
                return false;
            }
        }
        return p.isEmpty();
    }
}