import java.util.Scanner;

public class calculadoraIMC {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            // Mensagem de saudação
            System.out.println("Seja bem-vindo(a) à calculadora de IMC!");

            // Validação do nome
            String nome;
            while (true) {
                System.out.print("Digite seu nome (apenas letras): ");
                nome = scanner.nextLine();
                if (nome.matches("[a-zA-Záàâãéèêíïóôõöúç]+( [a-zA-Záàâãéèêíïóôõöúç]+)*")) {
                    break;
                } else {
                    System.out.println("Nome inválido. Por favor, insira apenas letras.");
                }
            }

            // Validação da altura
            double altura;
            while (true) {
                System.out.print("Digite sua altura (exemplo: 1.75 ou 1,75): ");
                String alturaInput = scanner.nextLine().replace(',', '.');  // Substitui vírgula por ponto
                try {
                    altura = Double.parseDouble(alturaInput);
                    if (altura > 0) {
                        break;
                    } else {
                        System.out.println("Altura inválida. A altura deve ser maior que zero.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Altura inválida. Por favor, insira um número válido.");
                }
            }

            // Validação do peso
            double peso;
            while (true) {
                System.out.print("Digite seu peso (exemplo: 70.5 ou 70,5): ");
                String pesoInput = scanner.nextLine().replace(',', '.');  // Substitui vírgula por ponto
                try {
                    peso = Double.parseDouble(pesoInput);
                    if (peso > 0) {
                        break;
                    } else {
                        System.out.println("Peso inválido. O peso deve ser maior que zero.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Peso inválido. Por favor, insira um número válido.");
                }
            }

            // Calcula o IMC
            double imc = peso / (altura * altura);
            System.out.printf("%s, seu IMC é: %.2f\n", nome, imc);

            // Classificação do IMC
            if (imc < 16) {
                System.out.printf("%s, seu IMC é: %.2f. Classificação: Magreza grave\n", nome, imc);
            } else if (imc >= 16.0 && imc <= 16.9) {
                System.out.printf("%s, seu IMC é: %.2f. Classificação: Magreza moderada\n", nome, imc);
            } else if (imc >= 17.0 && imc <= 18.4) {
                System.out.printf("%s, seu IMC é: %.2f. Classificação: Magreza leve\n", nome, imc);
            } else if (imc >= 18.5 && imc <= 24.9) {
                System.out.printf("%s, seu IMC é: %.2f. Classificação: Peso normal\n", nome, imc);
            } else if (imc >= 25.0 && imc <= 29.9) {
                System.out.printf("%s, seu IMC é: %.2f. Classificação: Sobrepeso\n", nome, imc);
            } else if (imc >= 30.0 && imc <= 34.9) {
                System.out.printf("%s, seu IMC é: %.2f. Classificação: Obesidade grau I\n", nome, imc);
            } else if (imc >= 35.0 && imc <= 39.9) {
                System.out.printf("%s, seu IMC é: %.2f. Classificação: Obesidade grau II (severa)\n", nome, imc);
            } else {
                System.out.printf("%s, seu IMC é: %.2f. Classificação: Obesidade grau III (mórbida)\n", nome, imc);
            }

            scanner.close();
        }
    }