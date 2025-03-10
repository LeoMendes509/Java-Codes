package projetos;

import java.util.Scanner;

public class projetoTabuada {

    public static void main(String[] args) {
     Scanner scanner = new Scanner(System.in);
//      Solicita o nome do usuário e exibe uma mensagem de saudação
     
     System.out.println("Digite seu nome : ");
     String nome = scanner.nextLine();

     System.out.print("Olá " + nome + " . Seja bem vindo ao projeto tabuada !");

//      Solicita ao usuário um número para a tabuada

     System.out.println("\nDigite um número para ver a tabuada : ");
     int numero = scanner.nextInt();

//   Exibe a tabuada de 1 a 10

     System.out.println("Tabuada do " + numero + " : ");
     for (int i = 1; i <= 10; i++) {
        System.out.println(numero + " x " + i + " = " + (numero * i ));
     }
     scanner.close(); // Fecha o scanner
    }


    
}
