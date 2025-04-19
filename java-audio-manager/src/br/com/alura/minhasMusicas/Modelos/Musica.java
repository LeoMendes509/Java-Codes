package br.com.alura.minhasMusicas.Modelos;

/**
 * Classe que representa uma música, herdando as propriedades e métodos da classe Audio.
 * Inclui atributos específicos para músicas, como gênero e álbum.
 */
public class Musica extends Audio {

    private String artista;
    private String album;
    private String genero;

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    /**
     * Sobrescreve o método getClassificacao() para gerar uma classificação
     * para a música com base no número de curtidas.
     *
     * @return A classificação da música.
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