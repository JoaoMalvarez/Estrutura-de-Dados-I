package Lista_Duplamente_Encadeada_Cricular;

public class ADLLGenerics {
// bancoDeDados(DLL<Trabalhador> func): realiza o cadastro de 10
// trabalhadores na lista duplamente ligada (DLL) func.
    public static void bancoDeDados(DLL<Trabalhador> func) {
        func.insertAscending(new Trabalhador(1, 25, "1165822", 'M', 5000.0f, "Analista Jr."));
        func.insertAscending(new Trabalhador(2, 22, "1263814", 'M', 3000.0f, "Auxiliar Administrativo."));
        func.insertAscending(new Trabalhador(3, 27, "1066325", 'F', 5000.0f, "Analista Jr."));
        func.insertAscending(new Trabalhador(4, 35, "1005116", 'M', 7000.0f, "Programador Sr."));
        func.insertAscending(new Trabalhador(5, 45, "1465881", 'F', 7000.0f, "Gerente Jr."));
        func.insertAscending(new Trabalhador(6, 51, "1665227", 'M', 7500.0f, "Gerente Pleno"));
        func.insertAscending(new Trabalhador(7, 60, "1775441", 'M', 8000.0f, "VicePresidente"));
        func.insertAscending(new Trabalhador(8, 34, "2166629", 'F', 7000.0f, "Analista Pleno"));
        func.insertAscending(new Trabalhador(9, 43, "1000823", 'F', 8000.0f, "Programador Sr."));
        func.insertAscending(new Trabalhador(10, 63, "0665340", 'F', 10000.0f, "Presidente"));
    }

    public static void main(String[] args) {
        DLL<Trabalhador> func = new DLL<Trabalhador>();
        bancoDeDados(func);
        System.out.println(func);
        int pos = 5;
        Node<Trabalhador> funcionario = func.get(pos);
        System.out.println("Funcionário da posição " + pos + ": ");
        System.out.println(funcionario.getData());
        System.out.println("Funcionário Removido: " + func.remove(pos).getData());
        System.out.println(func);
        System.out.println("Funcionário da posição " + func.getSize() + ": ");
        System.out.println("Funcionário Removido: " +
        func.remove(func.getSize()).getData());
        System.out.println(func);
        System.out.println("Funcionários em ordem crescente: ");
        func.showAscending();
        System.out.println("Funcionários em ordem decrescente: ");
        func.showDescending();
        }
}