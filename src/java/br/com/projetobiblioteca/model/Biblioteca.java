package br.com.projetobiblioteca.model;

public class Biblioteca {

    private Integer idBiblioteca;
    private String nomeBiblioteca;
    private String estadoBiblioteca;
    private String cidadeBiblioteca;
    private String bairroBiblioteca;
    private String ruaBiblioteca;
    private String numeroBiblioteca;
    private String cepBiblioteca;
    private String telefoneBiblioteca;
    private String emailBiblioteca;

    public Biblioteca() {
    }

    public Biblioteca(Integer idBiblioteca, String nomeBiblioteca, String estadoBiblioteca, String cidadeBiblioteca, String bairroBiblioteca, String ruaBiblioteca, String numeroBiblioteca, String cepBiblioteca, String telefoneBiblioteca, String emailBiblioteca) {
        this.idBiblioteca = idBiblioteca;
        this.nomeBiblioteca = nomeBiblioteca;
        this.estadoBiblioteca = estadoBiblioteca;
        this.cidadeBiblioteca = cidadeBiblioteca;
        this.bairroBiblioteca = bairroBiblioteca;
        this.ruaBiblioteca = ruaBiblioteca;
        this.numeroBiblioteca = numeroBiblioteca;
        this.cepBiblioteca = cepBiblioteca;
        this.telefoneBiblioteca = telefoneBiblioteca;
        this.emailBiblioteca = emailBiblioteca;
    }

    public Biblioteca(Integer idBiblioteca) {
        this.idBiblioteca = idBiblioteca;
    }

    public Integer getIdBiblioteca() {
        return idBiblioteca;
    }

    public void setIdBiblioteca(Integer idBiblioteca) {
        this.idBiblioteca = idBiblioteca;
    }

    public String getNomeBiblioteca() {
        return nomeBiblioteca;
    }

    public void setNomeBiblioteca(String nomeBiblioteca) {
        this.nomeBiblioteca = nomeBiblioteca;
    }

    public String getEstadoBiblioteca() {
        return estadoBiblioteca;
    }

    public void setEstadoBiblioteca(String estadoBiblioteca) {
        this.estadoBiblioteca = estadoBiblioteca;
    }

    public String getCidadeBiblioteca() {
        return cidadeBiblioteca;
    }

    public void setCidadeBiblioteca(String cidadeBiblioteca) {
        this.cidadeBiblioteca = cidadeBiblioteca;
    }

    public String getBairroBiblioteca() {
        return bairroBiblioteca;
    }

    public void setBairroBiblioteca(String bairroBiblioteca) {
        this.bairroBiblioteca = bairroBiblioteca;
    }

    public String getRuaBiblioteca() {
        return ruaBiblioteca;
    }

    public void setRuaBiblioteca(String ruaBiblioteca) {
        this.ruaBiblioteca = ruaBiblioteca;
    }

    public String getNumeroBiblioteca() {
        return numeroBiblioteca;
    }

    public void setNumeroBiblioteca(String numeroBiblioteca) {
        this.numeroBiblioteca = numeroBiblioteca;
    }

    public String getCepBiblioteca() {
        return cepBiblioteca;
    }

    public void setCepBiblioteca(String cepBiblioteca) {
        this.cepBiblioteca = cepBiblioteca;
    }

    public String getTelefoneBiblioteca() {
        return telefoneBiblioteca;
    }

    public void setTelefoneBiblioteca(String telefoneBiblioteca) {
        this.telefoneBiblioteca = telefoneBiblioteca;
    }

    public String getEmailBiblioteca() {
        return emailBiblioteca;
    }

    public void setEmailBiblioteca(String emailBiblioteca) {
        this.emailBiblioteca = emailBiblioteca;
    }

}
