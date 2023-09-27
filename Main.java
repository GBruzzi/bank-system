import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double saldoInicial = getData(scanner);
        System.out.println("Agora vamos para o próximo passo !");
        listChoice(scanner, saldoInicial);
        scanner.close();
        System.out.println("Obrigado por participar !");
    }

    public static double getData(Scanner scanner) {
        String nome;
        String conta = "";
        double saldoInicial;

        System.out.println("Olá! Entre com os seus dados para que eu possa continuar o atendimento:");

        System.out.println("Nome:");
        nome = scanner.nextLine();

        while (!conta.equalsIgnoreCase("corrente") && !conta.equalsIgnoreCase("poupanca")) {
            System.out.println("Tipo de conta:[corrente ou poupanca]");
            conta = scanner.nextLine().toUpperCase();
        }

        System.out.println("Saldo Inicial:");
        saldoInicial = scanner.nextDouble();

        scanner.nextLine(); // Consumir a quebra de linha pendente

        String msg = """
            Prazer %s! Feliz de ter você aqui.
            Sua conta é do tipo %s
            """.formatted(nome, conta);

        System.out.println(msg);
        return saldoInicial;
    }

    public static void listChoice(Scanner scanner, double saldoInicial) {
        int choice = 0;
        double valor;
        while (true) {
            System.out.println("""
                Qual sua opção ?
                [1] consultar saldo
                [2] Depositar ou sacar um valor
                [3] Sair
                """);

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Você escolheu verificar saldo");
                    System.out.println("Saldo Inicial: " + saldoInicial);
                    break;
                case 2:
                    System.out.println("Você escolheu adicionar ou retirar fundos");
                    System.out.println("Qual valor voce quer adicionar ?[valor negativo para retirar]");
                    valor = scanner.nextInt();
                    saldoInicial += valor;
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Opção inválida, entre com um número válido");
            }
        }
    }
}
