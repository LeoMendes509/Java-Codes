package br.com.alura.minhasMusicas.Modelos;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsável por gerenciar músicas e podcasts cadastrados,
 * além de controlar os itens favoritos do usuário.
 */
public class MinhasPreferidas {

    // Listas para armazenar todas as mídias
    private List<Musica> todasAsMusicas = new ArrayList<>();
    private List<Podcast> todosOsPodcasts = new ArrayList<>();
    private List<Musica> musicasPreferidas = new ArrayList<>();
    private List<Podcast> podcastsPreferidos = new ArrayList<>();

    // === MÉTODOS DE INCLUSÃO ===

    public void incluiMusica(Musica musica, boolean adicionarPreferido) {
        if (musica == null || musica.getTitulo().isBlank()) {
            System.out.println("❌ Título da música inválido.");
            return;
        }

        if (!todasAsMusicas.contains(musica)) {
            todasAsMusicas.add(musica);
        }

        if (adicionarPreferido) {
            adicionarMusicaAosFavoritos(musica);
        }
    }

    public void incluiPodcast(Podcast podcast, boolean adicionarPreferido) {
        if (podcast == null || podcast.getTitulo().isBlank()) {
            System.out.println("❌ Título do podcast inválido.");
            return;
        }

        if (!todosOsPodcasts.contains(podcast)) {
            todosOsPodcasts.add(podcast);
        }

        if (adicionarPreferido) {
            adicionarPodcastAosFavoritos(podcast);
        }
    }

    // === MÉTODOS AUXILIARES PARA ADIÇÃO AOS FAVORITOS ===

    private void adicionarMusicaAosFavoritos(Musica musica) {
        if (!musicasPreferidas.contains(musica)) {
            musicasPreferidas.add(musica);
            System.out.printf("🎶✨ *%s* adicionada aos seus favoritos com sucesso! 💖🎧%n", musica.getTitulo());
        } else {
            System.out.println("⚠️ " + musica.getTitulo() + " já está na lista de preferidos.");
        }
    }

    private void adicionarPodcastAosFavoritos(Podcast podcast) {
        if (!podcastsPreferidos.contains(podcast)) {
            podcastsPreferidos.add(podcast);
            System.out.printf("🎧✨ *%s* foi adicionado aos seus favoritos! 📻💬%n", podcast.getTitulo());
        } else {
            System.out.println("⚠️ " + podcast.getTitulo() + " já está na lista de preferidos.");
        }
    }

    // === MÉTODOS DE LISTAGEM ===

    public void listarTodasAsMusicas() {
        if (todasAsMusicas.isEmpty()) {
            System.out.println("📭 Não há músicas cadastradas.");
            return;
        }

        System.out.println("\n🎵 Músicas Cadastradas:");
        for (Musica musica : todasAsMusicas) {
            exibirInfoMusica(musica);
        }
    }

    public void listarMusicasPreferidas() {
        if (musicasPreferidas.isEmpty()) {
            System.out.println("📭 Não há músicas preferidas.");
            return;
        }

        System.out.println("\n💖 Músicas Preferidas:");
        for (Musica musica : musicasPreferidas) {
            exibirInfoMusica(musica);
        }
    }

    public void listarTodosOsPodcasts() {
        if (todosOsPodcasts.isEmpty()) {
            System.out.println("📭 Não há podcasts cadastrados.");
            return;
        }

        System.out.println("\n🎙️ Podcasts Cadastrados:");
        for (Podcast podcast : todosOsPodcasts) {
            exibirInfoPodcast(podcast);
        }
    }

    public void listarPodcastsPreferidos() {
        if (podcastsPreferidos.isEmpty()) {
            System.out.println("📭 Não há podcasts preferidos.");
            return;
        }

        System.out.println("\n💖 Podcasts Preferidos:");
        for (Podcast podcast : podcastsPreferidos) {
            exibirInfoPodcast(podcast);
        }
    }

    // === MÉTODOS AUXILIARES DE EXIBIÇÃO ===

    private void exibirInfoMusica(Musica musica) {
        System.out.println("- " + musica.getTitulo());
        if (!musica.getAlbum().isBlank()) {
            System.out.println("  Álbum: " + musica.getAlbum());
        }
        System.out.println("  Artista: " + musica.getArtista());
    }

    private void exibirInfoPodcast(Podcast podcast) {
        System.out.println("- " + podcast.getTitulo());
        if (!podcast.getDescricao().isBlank()) {
            System.out.println("  Descrição: " + podcast.getDescricao());
        }
        System.out.println("  Apresentador: " + podcast.getApresentador());
    }

    // === MÉTODO DE EXCLUSÃO GERAL ===

    public void excluirAudio(String titulo, String tipo) {
        if (titulo == null || titulo.isBlank() || tipo == null) {
            System.out.println("❌ Título ou tipo inválido.");
            return;
        }

        if (tipo.equalsIgnoreCase("musica")) {
            removerMusica(titulo);
        } else if (tipo.equalsIgnoreCase("podcast")) {
            removerPodcast(titulo);
        } else {
            System.out.println("❌ Tipo inválido. Use 'musica' ou 'podcast'.");
        }
    }

    // === REMOÇÃO DE MÚSICA DE TODAS AS LISTAS ===
    private void removerMusica(String titulo) {
        Musica musicaParaRemover = null;

        for (Musica musica : todasAsMusicas) {
            if (musica.getTitulo().equalsIgnoreCase(titulo)) {
                musicaParaRemover = musica;
                break;
            }
        }

        if (musicaParaRemover != null) {
            todasAsMusicas.remove(musicaParaRemover);
            musicasPreferidas.remove(musicaParaRemover);
            System.out.println("🗑️ Música \"" + titulo + "\" removida com sucesso de todas as listas.");
        } else {
            System.out.println("⚠️ Música \"" + titulo + "\" não encontrada.");
        }
    }

    // === REMOÇÃO DE PODCAST DE TODAS AS LISTAS ===
    private void removerPodcast(String titulo) {
        Podcast podcastParaRemover = null;

        for (Podcast podcast : todosOsPodcasts) {
            if (podcast.getTitulo().equalsIgnoreCase(titulo)) {
                podcastParaRemover = podcast;
                break;
            }
        }

        if (podcastParaRemover != null) {
            todosOsPodcasts.remove(podcastParaRemover);
            podcastsPreferidos.remove(podcastParaRemover);
            System.out.println("🗑️ Podcast \"" + titulo + "\" removido com sucesso de todas as listas.");
        } else {
            System.out.println("⚠️ Podcast \"" + titulo + "\" não encontrado.");
        }
    }
}

// Este projeto foi desenvolvido por Leonardo Mendes Rodrigues.
// This project was developed by Leonardo Mendes Rodrigues.
