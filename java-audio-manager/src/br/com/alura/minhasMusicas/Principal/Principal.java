package br.com.alura.minhasMusicas.Principal;

import java.util.Scanner;
import br.com.alura.minhasMusicas.Modelos.Musica;
import br.com.alura.minhasMusicas.Modelos.Podcast;
import br.com.alura.minhasMusicas.Modelos.MinhasPreferidas;

public class Principal {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MinhasPreferidas preferidas = new MinhasPreferidas();

        // Saudação
        System.out.print("👤 Digite seu nome: ");
        String nomeUsuario = scanner.nextLine();
        System.out.println("\n✨ Seja muito bem-vindo(a), " + nomeUsuario + "! Vamos começar sua experiência musical! 🎶🎧");

        int opcao = -1;

        while (opcao != 0) {
            System.out.println("\n🎵 MENU - MINHAS MÍDIAS 🎧");
            System.out.println("1. Adicionar Música");
            System.out.println("2. Adicionar Podcast");
            System.out.println("3. Listar Todas as Músicas");
            System.out.println("4. Listar Músicas Preferidas");
            System.out.println("5. Listar Todos os Podcasts");
            System.out.println("6. Listar Podcasts Preferidos");
            System.out.println("7. Excluir Música");
            System.out.println("8. Excluir Podcast");
            System.out.println("9. Voltar ao menu anterior");
            System.out.println("0. Sair");

            System.out.print("Escolha uma opção (0 a 9): ");
            String entrada = scanner.nextLine().trim();

            if (!entrada.matches("[0-9]")) {
                System.out.println("⚠ Entrada inválida. Digite um número de 0 a 9.");
                continue;
            }

            opcao = Integer.parseInt(entrada);

            switch (opcao) {
                case 1:
                    Musica musica = new Musica();
                    musica.setTitulo(lerTexto(scanner, "🎶 Título da música: "));
                    musica.setArtista(lerTexto(scanner, "🎤 Artista: "));
                    musica.setAlbum(lerTextoOuVazio(scanner, "📀 Álbum (opcional): "));
                    musica.setGenero(lerTextoOuVazio(scanner, "🎼 Gênero (opcional): "));

                    System.out.print("▶ Quantas vezes deseja reproduzir? ");
                    int repsMusica = lerNumeroFormatado(scanner);
                    for (int i = 0; i < repsMusica; i++) {
                        musica.reproduz();
                    }

                    System.out.print("❤ Quantas curtidas? ");
                    int likesMusica = lerNumeroFormatado(scanner);
                    for (int i = 0; i < likesMusica; i++) {
                        musica.curte();
                    }

                    if (repsMusica > 1000) {
                        System.out.println("🎶 Uau! Sua música está sendo muito reproduzida!");
                    }
                    if (likesMusica > 500) {
                        System.out.println("❤ Que sucesso! Sua música tem muitas curtidas!");
                    }

                    System.out.print("Deseja adicionar a música aos preferidos? (sim/nao): ");
                    String respostaMusica = scanner.nextLine().trim();

                    if (respostaMusica.equalsIgnoreCase("sim")) {
                        preferidas.incluiMusica(musica, true);
                        System.out.println("🎶 Música adicionada aos seus preferidos!");
                    } else if (respostaMusica.equalsIgnoreCase("nao")) {
                        preferidas.incluiMusica(musica, false);
                        System.out.println("🎶 Música não foi adicionada aos seus preferidos, mas foi cadastrada.");
                    } else {
                        preferidas.incluiMusica(musica, false);
                        System.out.println("⚠ Resposta inválida. A música foi cadastrada, mas não adicionada aos seus preferidos.");
                    }
                    break;

                case 2:
                    Podcast podcast = new Podcast();
                    podcast.setTitulo(lerTexto(scanner, "🎧 Título do podcast: "));
                    podcast.setApresentador(lerTexto(scanner, "🗣 Apresentador: "));
                    podcast.setDescricao(lerTextoOuVazio(scanner, "📝 Descrição (opcional): "));

                    System.out.print("▶ Quantas vezes deseja reproduzir? ");
                    int repsPod = lerNumeroFormatado(scanner);
                    for (int i = 0; i < repsPod; i++) {
                        podcast.reproduz();
                    }

                    System.out.print("❤ Quantas curtidas? ");
                    int likesPod = lerNumeroFormatado(scanner);
                    for (int i = 0; i < likesPod; i++) {
                        podcast.curte();
                    }

                    if (repsPod > 1000) {
                        System.out.println("🎧 Uau! Seu podcast está sendo muito reproduzido!");
                    }
                    if (likesPod > 500) {
                        System.out.println("❤ Que sucesso! Seu podcast tem muitas curtidas!");
                    }

                    System.out.print("Deseja adicionar o podcast aos preferidos? (sim/nao): ");
                    String respostaPodcast = scanner.nextLine().trim();

                    if (respostaPodcast.equalsIgnoreCase("sim")) {
                        preferidas.incluiPodcast(podcast, true);
                        System.out.println("🎧 Podcast adicionado aos seus preferidos!");
                    } else if (respostaPodcast.equalsIgnoreCase("nao")) {
                        preferidas.incluiPodcast(podcast, false);
                        System.out.println("🎧 Podcast não foi adicionado aos seus preferidos, mas foi cadastrado.");
                    } else {
                        preferidas.incluiPodcast(podcast, false);
                        System.out.println("⚠ Resposta inválida. O podcast foi cadastrado, mas não adicionado aos seus preferidos.");
                    }
                    break;

                case 3:
                    preferidas.listarTodasAsMusicas();
                    break;
                case 4:
                    preferidas.listarMusicasPreferidas();
                    break;
                case 5:
                    preferidas.listarTodosOsPodcasts();
                    break;
                case 6:
                    preferidas.listarPodcastsPreferidos();
                    break;
                case 7:
                    System.out.print("Digite o título da música que deseja excluir: ");
                    String tituloMusicaExcluir = scanner.nextLine();
                    preferidas.excluirAudio(tituloMusicaExcluir, "musica");
                    break;
                case 8:
                    System.out.print("Digite o título do podcast que deseja excluir: ");
                    String tituloPodcastExcluir = scanner.nextLine();
                    preferidas.excluirAudio(tituloPodcastExcluir, "podcast");
                    break;
                case 9:
                    System.out.println("↩ Voltando ao menu anterior...");
                    break;
                case 0:
                    System.out.println("👋 Encerrando o programa. Até logo!");
                    break;
                default:
                    System.out.println("⚠ Opção inválida. Escolha um número de 0 a 9.");
            }
        }

        scanner.close();
    }

    public static String lerTexto(Scanner scanner, String mensagem) {
        System.out.print(mensagem);
        return scanner.nextLine();
    }

    public static String lerTextoOuVazio(Scanner scanner, String mensagem) {
        System.out.print(mensagem);
        return scanner.nextLine();
    }

    public static int lerNumeroFormatado(Scanner scanner) {
        String input;
        int numero = 0;
        boolean validado = false;
        while (!validado) {
            input = scanner.nextLine().replaceAll("[^0-9]", "");
            if (!input.isEmpty()) {
                try {
                    numero = Integer.parseInt(input);
                    validado = true;
                } catch (NumberFormatException e) {
                    System.out.println("⚠ Entrada inválida. Digite apenas números.");
                }
            } else {
                System.out.println("⚠ Entrada inválida. Digite um número.");
            }
        }
        return numero;
    }
}

// Este projeto foi desenvolvido por Leonardo Mendes Rodrigues.
// This project was developed by Leonardo Mendes Rodrigues.





