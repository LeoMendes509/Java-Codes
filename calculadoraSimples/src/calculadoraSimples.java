import java.util.Scanner;

public class calculadoraSimples {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicita o nome do usuário e dá boas-vindas
        System.out.print("Digite seu nome: ");
        String nome = scanner.nextLine();
        System.out.println("Olá " + nome + "! Seja bem-vindo, vamos fazer alguns cálculos! :)");

        // Recebe dois números com validação
        double num1 = obterNumero(scanner, "Digite o primeiro número: ");
        double num2 = obterNumero(scanner, "Digite o segundo número: ");

        int operacao;
        double resultado;

        // Loop principal que permite repetir cálculos
        while (true) {
            exibirMenu(); // Mostra as opções de operação
            operacao = obterOperacao(scanner); // Lê a operação válida
            resultado = realizarCalculo(num1, num2, operacao); // Executa a operação escolhida

            System.out.println("Resultado da operação: " + resultado);

            // Pergunta se o usuário deseja fazer outro cálculo
            System.out.print("\nDeseja escolher outra operação? (S/N): ");
            char escolha = scanner.next().toUpperCase().charAt(0);
            if (escolha != 'S') {
                break; // Encerra se a resposta for diferente de 'S'
            }
        }

        System.out.println("\nObrigado por usar a calculadora, " + nome + "! Até a próxima.");
        scanner.close(); // Encerra o Scanner
    }

    // Exibe o menu com as operações disponíveis
    private static void exibirMenu() {
        System.out.println("\nEscolha a operação:");
        System.out.println("1 - Adição (+)");
        System.out.println("2 - Subtração (-)");
        System.out.println("3 - Multiplicação (*)");
        System.out.println("4 - Divisão (/)");
    }

    // Recebe um número com validação
    private static double obterNumero(Scanner scanner, String mensagem) {
        double numero;
        while (true) {
            System.out.print(mensagem);
            if (scanner.hasNextDouble()) {
                numero = scanner.nextDouble();
                scanner.nextLine(); // Limpa buffer
                break;
            } else {
                System.out.println("Entrada inválida! Digite um número válido.");
                scanner.nextLine(); // Descarta entrada inválida
            }
        }
        return numero;
    }

    // Recebe a opção da operação com validação
    private static int obterOperacao(Scanner scanner) {
        int operacao;
        while (true) {
            System.out.print("Digite a operação desejada (1-4): ");
            if (scanner.hasNextInt()) {
                operacao = scanner.nextInt();
                if (operacao >= 1 && operacao <= 4) {
                    scanner.nextLine(); // Limpa buffer
                    break;
                } else {
                    System.out.println("Opção inválida! Escolha um número entre 1 e 4.");
                }
            } else {
                System.out.println("Entrada inválida! Digite um número entre 1 e 4.");
                scanner.nextLine(); // Descarta entrada inválida
            }
        }
        return operacao;
    }

    // Realiza o cálculo de acordo com a operação escolhida
    private static double realizarCalculo(double num1, double num2, int operacao) {
        return switch (operacao) {
            case 1 -> num1 + num2; // Adição
            case 2 -> num1 - num2; // Subtração
            case 3 -> num1 * num2; // Multiplicação
            case 4 -> {
                if (num2 == 0) {
                    System.out.println("⚠️ Erro: divisão por zero! Retornando 0.");
                    yield 0;
                } else {
                    yield num1 / num2; // Divisão
                }
            }
            default -> 0; // Caso nunca deve acontecer por conta da validação
        };
    }
}
