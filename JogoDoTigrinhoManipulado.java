package secao3.projetos;

import java.util.Random;
import java.util.Scanner;

public class JogoDoTigrinhoManipulado {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        // Símbolos do caça-níqueis
        String[] simbolos = {"🐯", "💰", "⭐", "🍀", "🔥"}; 
        
        System.out.println("🎰 Bem-vindo ao Jogo do Tigrinho! 🎰");
        System.out.print("💵 Digite o valor da aposta: R$ ");
        double aposta = scanner.nextDouble();
        
        // Gera três símbolos aleatórios
        String simbolo1 = simbolos[random.nextInt(simbolos.length)];
        String simbolo2 = simbolos[random.nextInt(simbolos.length)];
        String simbolo3 = simbolos[random.nextInt(simbolos.length)];
        
        // 🚨 MANIPULAÇÃO 1: Criar falsa esperança (70% de chance de sair dois símbolos iguais)
        if (random.nextDouble() < 0.70) {
            simbolo2 = simbolo1; // Faz parecer que o jogador quase ganhou
        }
        
        // 🚨 MANIPULAÇÃO 2: Reduzir a chance de vitória (80% das vezes, força uma perda)
        if (random.nextDouble() < 0.80) {
            simbolo3 = "💀"; // Troca o terceiro símbolo para garantir que o jogador perca
        }
        
        // Exibe os resultados
        System.out.println("\n🎲 Girando os rolos... 🎲");
        System.out.println("[" + simbolo1 + "] [" + simbolo2 + "] [" + simbolo3 + "]");

        // 🚨 MANIPULAÇÃO 3: Fraude no pagamento (Mesmo que o jogador acerte, 90% das vezes ele perde)
        if (simbolo1.equals(simbolo2) && simbolo2.equals(simbolo3)) {
            if (random.nextDouble() < 0.90) { // 90% de chance de alterar o resultado final
                simbolo3 = "💀";
                System.out.println("❌ Você perdeu! Tente novamente. ❌");
            } else {
                double premio = aposta * 3;
                System.out.println("🎉 PARABÉNS! Você ganhou R$ " + premio + "! 🎉");
            }
        } else {
            System.out.println("❌ Você perdeu! Tente novamente. ❌");
        }

        scanner.close();
    }
}
