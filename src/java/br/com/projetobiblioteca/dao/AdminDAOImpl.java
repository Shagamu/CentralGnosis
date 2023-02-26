package br.com.projetobiblioteca.dao;

import br.com.projetobiblioteca.model.Admin;
import br.com.projetobiblioteca.model.Biblioteca;
import br.com.projetobiblioteca.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class AdminDAOImpl implements GenericDAO{

    private Connection conn;

    public AdminDAOImpl() throws Exception {
        try {
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Conectado com sucesso!");
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    @Override
    public Boolean cadastrar(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public Object logarAdmin(String login, String senha){
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Admin admin = null;
        String sql = "select * from admin where loginadmin = ? and senhaadmin = ?";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, login);
            stmt.setString(2, senha);
            rs = stmt.executeQuery();
            while (rs.next()) {
                admin = new Admin();
                admin.setIdAdmin(rs.getInt("idadmin"));
                admin.setLoginAdmin(rs.getString("loginadmin"));
                admin.setSenhaAdmin(rs.getString("senhapessoa"));
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao logar! Erro:" + ex.getMessage());
            ex.printStackTrace();

        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt, rs);
            } catch (Exception e) {
                System.out.println("Problemas ao fechar a conexão! Erro" + e.getMessage());
                e.printStackTrace();
            }
        }
        return admin;
    }

    @Override
    public List<Object> listar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Boolean excluir(int idOject) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Object carregar(int idObject) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Biblioteca biblioteca = null;
        String sql = "select * from biblioteca where idbiblioteca = ?;";
        try {
            stmt = conn.prepareStatement (sql);
            stmt.setInt(1, idObject);
            rs = stmt.executeQuery();
	
            while (rs.next()) {
		biblioteca = new Biblioteca();
                biblioteca.setIdBiblioteca(rs.getInt("idbiblioteca"));
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao carregar usuario! Erro:" + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt, rs);
            } catch (Exception e) {
                System.out.println("Problemas ao fechar a conexão! Erro" + e.getMessage());
                e.printStackTrace();
            }
        }
        return biblioteca;
    }
    @Override
    public Boolean alterar(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
