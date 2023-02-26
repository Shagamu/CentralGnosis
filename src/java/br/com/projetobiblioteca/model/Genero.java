package br.com.projetobiblioteca.model;

public class Genero {
    private Integer idGenero;
    private String nomeGenero;

    public Genero() {
    }

    public Genero(Integer idGenero, String nomeGenero) {
        this.idGenero = idGenero;
        this.nomeGenero = nomeGenero;
    }

    public Genero(Integer idGenero) {
        this.idGenero = idGenero;
    }

    public Integer getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(Integer idGenero) {
        this.idGenero = idGenero;
    }

    public String getNomeGenero() {
        return nomeGenero;
    }

    public void setNomeGenero(String nomeGenero) {
        this.nomeGenero = nomeGenero;
    }
    
    
}
