package br.com.projetobiblioteca.dao;

import br.com.projetobiblioteca.model.Pessoa;
import br.com.projetobiblioteca.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class PessoaDAOImpl implements GenericDAO {

    private Connection conn;

    public PessoaDAOImpl() throws Exception {
        try {
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Conectado com sucesso!");
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    public Integer cadastrar(Pessoa pessoa) {

        PreparedStatement stmt = null;
        ResultSet rs = null;
        Integer idPessoa = null;

        String sql = "Insert into pessoa(nomepessoa, telefonepessoa, cpfpessoa, emailpessoa, senhapessoa) values (?, ?, ?, ?, ?) returning idpessoa;";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, pessoa.getNomePessoa());
            stmt.setString(2, pessoa.getTelefonePessoa());
            stmt.setString(3, pessoa.getCpfPessoa());
            stmt.setString(4, pessoa.getEmailPessoa());
            stmt.setString(5, pessoa.getSenhaPessoa());
            rs = stmt.executeQuery();

            if (rs.next()) {
                idPessoa = rs.getInt("idpessoa");
            }
        } catch (Exception ex) {
            System.out.println("Problemas ao cadastrar pessoa! Erro: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar a conexão! Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
        return idPessoa;
    }

    @Override
    public Boolean cadastrar(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Object> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean excluir(int idOject) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object carregar(int idObject) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Boolean alterar(Pessoa pessoa) {
        PreparedStatement stmt = null;
        String sql = "update pessoa set nomepessoa = ?, telefonepessoa = ?, cpfpessoa = ?, emailpessoa = ? where idpessoa = ?;";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, pessoa.getNomePessoa());
            stmt.setString(2, pessoa.getTelefonePessoa());
            stmt.setString(3, pessoa.getCpfPessoa());
            stmt.setString(4, pessoa.getEmailPessoa());
            stmt.setInt(5, pessoa.getIdPessoa());
            stmt.executeUpdate();
            return true;
        } catch (Exception ex) {
            System.out.println("Problemas ao alterar bibliotecario! Erro: " + ex.getMessage());
            ex.printStackTrace();
            return false;
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar a conexão! Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
    }

    @Override
    public Boolean alterar(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
