package br.com.projetobiblioteca.model;

public class Livro {
    private int idLivro;
    private String tituloLivro;
    private String autorLivro;
    private String editoraLivro;
    private String anoLivro; 
    private String isbnLivro;
    private double valorLivro;
    private int quantidadeLivro;
    private Biblioteca idBiblioteca;

    public Livro() {
    }

    public Livro(int idLivro, String tituloLivro, String autorLivro, String editoraLivro, String anoLivro, String isbnLivro, double valorLivro, int quantidadeLivro, Biblioteca idBiblioteca) {
        this.idLivro = idLivro;
        this.tituloLivro = tituloLivro;
        this.autorLivro = autorLivro;
        this.editoraLivro = editoraLivro;
        this.anoLivro = anoLivro;
        this.isbnLivro = isbnLivro;
        this.valorLivro = valorLivro;
        this.quantidadeLivro = quantidadeLivro;
        this.idBiblioteca = idBiblioteca;
    }

    public Livro(int idLivro) {
        this.idLivro = idLivro;
    }

    public Livro(String tituloLivro) {
        this.tituloLivro = tituloLivro;
    }

    public int getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(int idLivro) {
        this.idLivro = idLivro;
    }

    public String getTituloLivro() {
        return tituloLivro;
    }

    public void setTituloLivro(String tituloLivro) {
        this.tituloLivro = tituloLivro;
    }

    public String getAutorLivro() {
        return autorLivro;
    }

    public void setAutorLivro(String autorLivro) {
        this.autorLivro = autorLivro;
    }

    public String getEditoraLivro() {
        return editoraLivro;
    }

    public void setEditoraLivro(String editoraLivro) {
        this.editoraLivro = editoraLivro;
    }

    public String getAnoLivro() {
        return anoLivro;
    }

    public void setAnoLivro(String anoLivro) {
        this.anoLivro = anoLivro;
    }

    public String getIsbnLivro() {
        return isbnLivro;
    }

    public void setIsbnLivro(String isbnLivro) {
        this.isbnLivro = isbnLivro;
    }

    public double getValorLivro() {
        return valorLivro;
    }

    public void setValorLivro(double valorLivro) {
        this.valorLivro = valorLivro;
    }

    public int getQuantidadeLivro() {
        return quantidadeLivro;
    }

    public void setQuantidadeLivro(int quantidadeLivro) {
        this.quantidadeLivro = quantidadeLivro;
    }

    public Biblioteca getIdBiblioteca() {
        return idBiblioteca;
    }

    public void setIdBiblioteca(Biblioteca idBiblioteca) {
        this.idBiblioteca = idBiblioteca;
    }

}