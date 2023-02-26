package br.com.projetobiblioteca.model;

public class Compra {

    private int idCompra;
    private double valorCompra;
    private int quantidadeCompra;
    private Livro idLivro;
    private Livro tituloLivro;
    private Usuario idUsuario;

    public Compra() {
    }

    public Compra(int idCompra, double valorCompra, int quantidadeCompra, Livro idLivro, Livro tituloLivro, Usuario idUsuario) {
        this.idCompra = idCompra;
        this.valorCompra = valorCompra;
        this.quantidadeCompra = quantidadeCompra;
        this.idLivro = idLivro;
        this.tituloLivro = tituloLivro;
        this.idUsuario = idUsuario;
    }

    public int getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    public double getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(double valorCompra) {
        this.valorCompra = valorCompra;
    }

    public int getQuantidadeCompra() {
        return quantidadeCompra;
    }

    public void setQuantidadeCompra(int quantidadeCompra) {
        this.quantidadeCompra = quantidadeCompra;
    }

    public Livro getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(Livro idLivro) {
        this.idLivro = idLivro;
    }

    public Livro getTituloLivro() {
        return tituloLivro;
    }

    public void setTituloLivro(Livro tituloLivro) {
        this.tituloLivro = tituloLivro;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

}
