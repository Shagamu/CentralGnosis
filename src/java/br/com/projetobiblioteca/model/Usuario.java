package br.com.projetobiblioteca.model;

public class Usuario extends Pessoa {
    
    private int idUsuario;
    private String estadoUsuario;
    private String cidadeUsuario;
    private String bairroUsuario;        
    private String ruaUsuario;
    private String numeroUsuario;
    private String cepUsuario;    
            
    public Usuario() {
    }

    public Usuario(int idUsuario, String estadoUsuario, String cidadeUsuario, String bairroUsuario, String ruaUsuario, String numeroUsuario, String cepUsuario) {
        this.idUsuario = idUsuario;
        this.estadoUsuario = estadoUsuario;
        this.cidadeUsuario = cidadeUsuario;
        this.bairroUsuario = bairroUsuario;
        this.ruaUsuario = ruaUsuario;
        this.numeroUsuario = numeroUsuario;
        this.cepUsuario = cepUsuario;
    }

    public Usuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getEstadoUsuario() {
        return estadoUsuario;
    }

    public void setEstadoUsuario(String estadoUsuario) {
        this.estadoUsuario = estadoUsuario;
    }

    public String getCidadeUsuario() {
        return cidadeUsuario;
    }

    public void setCidadeUsuario(String cidadeUsuario) {
        this.cidadeUsuario = cidadeUsuario;
    }

    public String getBairroUsuario() {
        return bairroUsuario;
    }

    public void setBairroUsuario(String bairroUsuario) {
        this.bairroUsuario = bairroUsuario;
    }

    public String getRuaUsuario() {
        return ruaUsuario;
    }

    public void setRuaUsuario(String ruaUsuario) {
        this.ruaUsuario = ruaUsuario;
    }

    public String getNumeroUsuario() {
        return numeroUsuario;
    }

    public void setNumeroUsuario(String numeroUsuario) {
        this.numeroUsuario = numeroUsuario;
    }

    public String getCepUsuario() {
        return cepUsuario;
    }

    public void setCepUsuario(String cepUsuario) {
        this.cepUsuario = cepUsuario;
    }

   
}
