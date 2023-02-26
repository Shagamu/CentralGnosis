package br.com.projetobiblioteca.model;

public class GeneroLivro {
    private Genero idGenero;
    private Livro idLivro;

    public GeneroLivro() {
    }

    public GeneroLivro(Genero idGenero, Livro idLivro) {
        this.idGenero = idGenero;
        this.idLivro = idLivro;
    }

    public Genero getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(Genero idGenero) {
        this.idGenero = idGenero;
    }

    public Livro getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(Livro idLivro) {
        this.idLivro = idLivro;
    }
    
}
