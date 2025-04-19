package br.com.alura.minhasMusicas.Modelos;

/**
 * Classe que representa um podcast, herdando as propriedades e métodos da classe Audio.
 * Inclui atributos específicos para podcasts, como apresentador e descrição.
 */
public class Podcast extends Audio {

    private String apresentador;
    private String descricao;

    public String getApresentador() {
        return apresentador;
    }

    public void setApresentador(String apresentador) {
        this.apresentador = apresentador;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * Sobrescreve o método getClassificacao() para gerar uma classificação
     * para o podcast com base no número de curtidas.
     *
     * @return A classificação do podcast.
     */
    @Override
    public int getClassificacao() {
        if (this.getTotalDeCurtidas() > 500) {
            return 10; // Sucesso absoluto!
        } else {
            return 8; // Bom, mas poderia ter mais curtidas.
        }
    }
}

// Este projeto foi desenvolvido por Leonardo Mendes Rodrigues.
// This project was developed by Leonardo Mendes Rodrigues.
