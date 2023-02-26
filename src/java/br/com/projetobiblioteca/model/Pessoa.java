package br.com.projetobiblioteca.model;

public class Pessoa {
    
    private int idPessoa;
    private String nomePessoa;
    private String telefonePessoa;
    private String cpfPessoa;
    private String emailPessoa;
    private String senhaPessoa;

    public Pessoa() {
    }

    public Pessoa(int idPessoa, String nomePessoa, String telefonePessoa, String cpfPessoa, String emailPessoa, String senhaPessoa) {
        this.idPessoa = idPessoa;
        this.nomePessoa = nomePessoa;
        this.telefonePessoa = telefonePessoa;
        this.cpfPessoa = cpfPessoa;
        this.emailPessoa = emailPessoa;
        this.senhaPessoa = senhaPessoa;
    }

    public int getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getNomePessoa() {
        return nomePessoa;
    }

    public void setNomePessoa(String nomePessoa) {
        this.nomePessoa = nomePessoa;
    }

    public String getTelefonePessoa() {
        return telefonePessoa;
    }

    public void setTelefonePessoa(String telefonePessoa) {
        this.telefonePessoa = telefonePessoa;
    }

    public String getCpfPessoa() {
        return cpfPessoa;
    }

    public void setCpfPessoa(String cpfPessoa) {
        this.cpfPessoa = cpfPessoa;
    }

    public String getEmailPessoa() {
        return emailPessoa;
    }

    public void setEmailPessoa(String emailPessoa) {
        this.emailPessoa = emailPessoa;
    }

    public String getSenhaPessoa() {
        return senhaPessoa;
    }

    public void setSenhaPessoa(String senhaPessoa) {
        this.senhaPessoa = senhaPessoa;
    }
    
}
