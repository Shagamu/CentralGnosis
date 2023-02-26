package br.com.projetobiblioteca.model;

public class Admin {
    private Integer idAdmin;
    private String loginAdmin;
    private String senhaAdmin;

    public Admin(Integer idAdmin, String loginAdmin, String senhaAdmin) {
        this.idAdmin = idAdmin;
        this.loginAdmin = loginAdmin;
        this.senhaAdmin = senhaAdmin;
    }

    public Admin() {
    }

    public Integer getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(Integer idAdmin) {
        this.idAdmin = idAdmin;
    }

    public String getLoginAdmin() {
        return loginAdmin;
    }

    public void setLoginAdmin(String loginAdmin) {
        this.loginAdmin = loginAdmin;
    }

    public String getSenhaAdmin() {
        return senhaAdmin;
    }

    public void setSenhaAdmin(String senhaAdmin) {
        this.senhaAdmin = senhaAdmin;
    }
    
}
