package Aula06;

import java.util.Comparator;
public class TestaFila {
    public static void main(String[] args) throws Exception {
        FilaPrioridade<Paciente> fila = new FilaPrioridade<>(
            Comparator.comparingInt(Paciente::getGravidade)
        );

        fila.enqueue(new Paciente("Carlos", 2));
        fila.enqueue(new Paciente("Ana", 3));
        fila.enqueue(new Paciente("Bruno", 3));
        fila.enqueue(new Paciente("Diana", 1));
        fila.enqueue(new Paciente("Eduardo",2));

        while (!fila.isEmpty()) {
            System.out.println(fila.dequeue());
        }
    }
}