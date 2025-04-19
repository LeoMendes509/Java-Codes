package br.com.alura.minhasMusicas.Modelos;

/**
 * Classe base que representa um áudio genérico, seja música ou podcast.
 * Contém as propriedades comuns a todos os áudios, como título, número de reproduções,
 * curtidas e classificação.
 */
public class Audio {

    private String titulo;
    private int totalDeReproducoes;
    private int totalDeCurtidas;
    private int classificacao;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getTotalDeReproducoes() {
        return totalDeReproducoes;
    }

    public int getTotalDeCurtidas() {
        return totalDeCurtidas;
    }

    public int getClassificacao() {
        return classificacao;
    }

    /**
     * Incrementa o número de curtidas do áudio.
     */
    public void curte() {
        this.totalDeCurtidas++;
    }

    /**
     * Incrementa o número de reproduções do áudio.
     */
    public void reproduz() {
        this.totalDeReproducoes++;
    }
}

// Este projeto foi desenvolvido por Leonardo Mendes Rodrigues.
// This project was developed by Leonardo Mendes Rodrigues.
