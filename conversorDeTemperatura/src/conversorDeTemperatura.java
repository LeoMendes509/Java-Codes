import java.util.Scanner;

public class conversorDeTemperatura {

    // Constantes de mensagens
    private static final String MENSAGEM_NOME_INVALIDO = "Nome inválido. Digite apenas letras e espaços.";
    private static final String MENSAGEM_ENTRADA_INVALIDA = "Entrada inválida. Digite um número válido para a temperatura.";
    private static final String TITULO_PROGRAMA = "=== CONVERSOR DE TEMPERATURA ===";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Cabeçalho do programa
        System.out.println(TITULO_PROGRAMA);

        // Solicita e valida nome do usuário
        String nome = obterNomeValido(scanner);
        System.out.println("Olá " + nome + ", seja bem-vindo ao conversor de temperatura!");

        // Solicita e valida a temperatura em Fahrenheit
        double temperaturaFahrenheit = obterTemperaturaValida(scanner);

        // Converte para Celsius
        double temperaturaCelsius = converterFahrenheitParaCelsius(temperaturaFahrenheit);

        // Exibe resultado formatado
        System.out.printf("%.2f°F equivalem a %.2f°C%n", temperaturaFahrenheit, temperaturaCelsius);

        // Finaliza
        System.out.println("Obrigado por utilizar o conversor, " + nome + "!");
        scanner.close();
    }

    // Método para validar o nome (somente letras e espaços)
    private static String obterNomeValido(Scanner scanner) {
        String nome;
        while (true) {
            System.out.print("Digite seu nome: ");
            nome = scanner.nextLine().trim();

            if (nome.matches("[A-Za-zÀ-ÿ ]+")) {
                return nome;
            }
            System.out.println(MENSAGEM_NOME_INVALIDO);
        }
    }

    // Método para validar a entrada da temperatura (deve ser um número)
    private static double obterTemperaturaValida(Scanner scanner) {
        while (true) {
            System.out.print("Digite a temperatura em Fahrenheit: ");
            String entrada = scanner.nextLine().trim();

            try {
                return Double.parseDouble(entrada);
            } catch (NumberFormatException e) {
                System.out.println(MENSAGEM_ENTRADA_INVALIDA);
            }
        }
    }

    // Método para conversão Fahrenheit → Celsius
    private static double converterFahrenheitParaCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5.0 / 9.0;
    }
}

