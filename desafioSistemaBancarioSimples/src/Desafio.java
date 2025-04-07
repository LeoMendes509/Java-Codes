import java.util.Scanner; // Importa a classe Scanner para leitura de dados do console

public class Desafio {

    public static void main(String[] args) {
        // Cria um Scanner para ler entradas do usuário
        Scanner scanner = new Scanner(System.in);

        // Solicita e armazena o nome do cliente
        String nome = solicitarNome(scanner);

        // Solicita e armazena o tipo de conta escolhido
        String tipoConta = selecionarTipoConta(scanner);

        // Solicita e armazena o saldo inicial
        double saldo = solicitarSaldoInicial(scanner);

        // Exibe um resumo das informações do cliente
        exibirResumoCliente(nome, tipoConta, saldo);

        int opcao; // Variável para controlar a opção do menu

        // Loop principal do menu, só para quando o usuário digita 4 (sair)
        do {
            exibirMenu(); // Mostra as opções do menu
            opcao = scanner.nextInt(); // Lê a opção do usuário

            // Executa ações diferentes dependendo da opção
            switch (opcao) {
                case 1 -> consultarSaldo(saldo); // Mostra o saldo atual
                case 2 -> saldo = transferirValor(scanner, saldo); // Solicita e faz a transferência
                case 3 -> saldo = receberValor(scanner, saldo); // Solicita e adiciona o valor recebido
                case 4 -> System.out.println("Encerrando sistema. Obrigado por utilizar!"); // Sai do sistema
                default -> System.out.println("⚠️  Opção inválida. Tente novamente."); // Se o número não for entre 1 e 4
            }
        } while (opcao != 4); // Repete o menu até a opção ser 4 (sair)

        scanner.close(); // Fecha o Scanner ao final do programa
    }

    // Método para solicitar o nome do cliente
    public static String solicitarNome(Scanner scanner) {
        System.out.print("Digite seu nome: ");
        return scanner.nextLine(); // Lê o nome completo (inclui espaços)
    }

    // Método para o usuário escolher o tipo de conta
    public static String selecionarTipoConta(Scanner scanner) {
        System.out.println("\nEscolha seu tipo de conta:");
        System.out.println("1 - Conta Corrente");
        System.out.println("2 - Conta Poupança");
        System.out.println("3 - Conta Salário");
        System.out.println("4 - Conta Digital");
        System.out.println("5 - Conta Investimento");
        System.out.print("Opção: ");

        // Garante que o valor digitado seja um número
        while (!scanner.hasNextInt()) {
            System.out.print("Digite um número válido para o tipo de conta: ");
            scanner.next();
        }

        int opcao = scanner.nextInt(); // Lê a opção
        scanner.nextLine(); // Consome o "enter" pendente

        // Retorna o tipo de conta com base na opção escolhida
        return switch (opcao) {
            case 1 -> "Conta Corrente";
            case 2 -> "Conta Poupança";
            case 3 -> "Conta Salário";
            case 4 -> "Conta Digital";
            case 5 -> "Conta Investimento";
            default -> {
                System.out.println("⚠️  Opção inválida. Tipo de conta não definido.");
                yield "Desconhecido"; // Usado para retornar em blocos de switch
            }
        };
    }

    // Método para solicitar o saldo inicial do cliente
    public static double solicitarSaldoInicial(Scanner scanner) {
        System.out.print("\nDigite seu saldo bancário: ");
        // Garante que o valor digitado seja um número decimal válido
        while (!scanner.hasNextDouble()) {
            System.out.print("Digite um valor válido para o saldo: ");
            scanner.next();
        }
        return scanner.nextDouble(); // Retorna o saldo
    }

    // Mostra os dados do cliente (nome, tipo de conta e saldo)
    public static void exibirResumoCliente(String nome, String tipoConta, double saldo) {
        System.out.println("\n**********************************");
        System.out.println("Olá, " + nome);
        System.out.println("Tipo de conta: " + tipoConta);
        System.out.printf("Saldo atual: R$ %.2f\n", saldo); // Formata o saldo com 2 casas decimais
        System.out.println("**********************************");
    }

    // Mostra o menu principal de operações
    public static void exibirMenu() {
        System.out.println("""
                
                ========================
                Escolha uma opção:
                1 - Consultar saldo
                2 - Transferir valor
                3 - Receber valor
                4 - Sair
                ========================
                """);
        System.out.print("Digite sua opção: ");
    }

    // Mostra o saldo atual
    public static void consultarSaldo(double saldo) {
        System.out.printf("💰 Saldo atual: R$ %.2f\n", saldo);
    }

    // Método para realizar uma transferência
    public static double transferirValor(Scanner scanner, double saldo) {
        System.out.print("Digite o valor que deseja transferir: ");
        double valor = scanner.nextDouble(); // Lê o valor a transferir

        // Verifica se o valor é válido
        if (valor <= 0) {
            System.out.println("⚠️  Valor inválido. Digite um valor positivo.");
        } else if (valor > saldo) {
            System.out.println("❌ Saldo insuficiente para a transferência.");
        } else {
            saldo -= valor; // Subtrai o valor do saldo
            System.out.printf("✅ Transferência de R$ %.2f concluída.\n", valor);
            System.out.printf("💰 Saldo atual: R$ %.2f\n", saldo);
        }

        return saldo; // Retorna o novo saldo
    }

    // Método para receber um valor (depósito)
    public static double receberValor(Scanner scanner, double saldo) {
        System.out.print("Digite o valor a receber: ");
        double valor = scanner.nextDouble(); // Lê o valor a receber

        // Verifica se o valor é válido
        if (valor <= 0) {
            System.out.println("⚠️  Valor inválido. Digite um valor positivo.");
        } else {
            saldo += valor; // Adiciona o valor ao saldo
            System.out.printf("✅ Valor de R$ %.2f recebido com sucesso.\n", valor);
            System.out.printf("💰 Saldo atual: R$ %.2f\n", saldo);
        }

        return saldo; // Retorna o novo saldo

    }
}

