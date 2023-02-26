
package br.com.projetobiblioteca.model;


public class Bibliotecario extends Pessoa {
    
    private int idBibliotecario;
    private String loginBibliotecario;
    private Biblioteca idBiblioteca;

    public Bibliotecario() {
    }

    public Bibliotecario(int idBibliotecario, String loginBibliotecario, Biblioteca idBiblioteca) {
        this.idBibliotecario = idBibliotecario;
        this.loginBibliotecario = loginBibliotecario;
        this.idBiblioteca = idBiblioteca;
    }

    public int getIdBibliotecario() {
        return idBibliotecario;
    }

    public void setIdBibliotecario(int idBibliotecario) {
        this.idBibliotecario = idBibliotecario;
    }

    public String getLoginBibliotecario() {
        return loginBibliotecario;
    }

    public void setLoginBibliotecario(String loginBibliotecario) {
        this.loginBibliotecario = loginBibliotecario;
    }

    public Biblioteca getIdBiblioteca() {
        return idBiblioteca;
    }

    public void setIdBiblioteca(Biblioteca idBiblioteca) {
        this.idBiblioteca = idBiblioteca;
    }

}
