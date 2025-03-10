package projetos;

import java.util.Scanner;

public class calculadoraSimples {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Mensagem de boas-vindas e recebendo o nome do usuário
        System.out.print("Digite seu nome: ");
        String nome = scanner.nextLine();  
        System.out.println("Olá " + nome + "! Seja bem-vindo, vamos fazer alguns cálculos! :)");

        double num1 = obterNumero(scanner, "Digite o primeiro número: ");
        double num2 = obterNumero(scanner, "Digite o segundo número: ");

        int operacao;
        double resultado = 0;
        
        while (true) {
            // Exibe o menu de operações
            System.out.println("\nEscolha a operação:");
            System.out.println("1 - Adição (+)");
            System.out.println("2 - Subtração (-)");
            System.out.println("3 - Multiplicação (*)");
            System.out.println("4 - Divisão (/)");
            operacao = obterOperacao(scanner);

            // Processa a operação escolhida
            switch (operacao) {
                case 1:
                    resultado = num1 + num2;
                    break;
                case 2:
                    resultado = num1 - num2;
                    break;
                case 3:
                    resultado = num1 * num2;
                    break;
                case 4:
                    resultado = (num2 == 0) ? 0 : num1 / num2; // Se for divisão por zero, resultado será 0
                    break;
            }

            // Exibe o resultado
            System.out.println("O resultado da operação é: " + resultado);

            // Pergunta se deseja fazer outra operação
            System.out.print("\nDeseja escolher outra operação? (S/N): ");
            char escolha = scanner.next().toUpperCase().charAt(0);
            if (escolha != 'S') {
                break; // Sai do loop se o usuário não quiser continuar
            }
        }

        System.out.println("\nObrigado por usar a calculadora, " + nome + "! Até a próxima.");
        scanner.close();
    }

    // Método para obter um número válido
    private static double obterNumero(Scanner scanner, String mensagem) {
        double numero;
        while (true) {
            System.out.print(mensagem);
            if (scanner.hasNextDouble()) {
                numero = scanner.nextDouble();
                scanner.nextLine(); // Limpar buffer do Scanner
                break;
            } else {
                System.out.println("Entrada inválida! Digite um número válido.");
                scanner.nextLine(); // Limpar entrada inválida
            }
        }
        return numero;
    }

    // Método para obter uma operação válida
    private static int obterOperacao(Scanner scanner) {
        int operacao;
        while (true) {
            System.out.print("Digite a operação desejada (1-4): ");
            if (scanner.hasNextInt()) {
                operacao = scanner.nextInt();
                if (operacao >= 1 && operacao <= 4) {
                    scanner.nextLine(); // Limpar buffer
                    break;
                } else {
                    System.out.println("Opção inválida! Escolha um número entre 1 e 4.");
                }
            } else {
                System.out.println("Entrada inválida! Digite um número entre 1 e 4.");
                scanner.nextLine(); // Limpar entrada inválida
            }
        }
        return operacao;
    }
}
