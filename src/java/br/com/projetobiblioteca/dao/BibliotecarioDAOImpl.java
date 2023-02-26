package br.com.projetobiblioteca.dao;

import br.com.projetobiblioteca.model.Biblioteca;
import br.com.projetobiblioteca.model.Bibliotecario;
import br.com.projetobiblioteca.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class BibliotecarioDAOImpl implements GenericDAO {

    private Connection conn;

    public BibliotecarioDAOImpl() throws Exception {
        try {
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Conectado com sucesso!");
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }
    
    @Override
    public Boolean cadastrar(Object object) {
        
        Bibliotecario bibliotecario = (Bibliotecario) object;
        PreparedStatement stmt = null;

        String sql = "Insert into bibliotecario(idbiblioteca, idpessoa) values (?, ?);";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, bibliotecario.getIdBiblioteca().getIdBiblioteca());
            stmt.setInt(2, new PessoaDAOImpl().cadastrar(bibliotecario));
            stmt.execute();
            return true;
        } catch (Exception ex) {
            System.out.println("Problemas ao cadastrar usuario! Erro: " + ex.getMessage());
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
    
    public Object logarBibliotecario(String email, String senha){
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Bibliotecario bibliotecario = null;
        String sql = "select p.*, bi.* from pessoa p, bibliotecario bi where p.emailpessoa = ? and p.senhapessoa = ? and p.idpessoa = bi.idpessoa";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, email);
            stmt.setString(2, senha);
            rs = stmt.executeQuery();
            while (rs.next()) {
                bibliotecario = new Bibliotecario();
                bibliotecario.setIdBibliotecario(rs.getInt("idbibliotecario"));
                bibliotecario.setEmailPessoa(rs.getString("emailpessoa"));
                bibliotecario.setSenhaPessoa(rs.getString("senhapessoa"));
                bibliotecario.setIdPessoa(rs.getInt("idpessoa"));
                bibliotecario.setIdBiblioteca(new Biblioteca(rs.getInt("idbiblioteca")));
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
        return bibliotecario;
    }
    
    @Override
    public List<Object> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean excluir(int idOject) {
        PreparedStatement stmt = null;
        
        String sql = "delete from bibliotecario where idpessoa = ?;"
                    +"commit;"
                    +"delete from pessoa where idpessoa=?";
        try{
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idOject);
            stmt.setInt(2, idOject);
            stmt.executeUpdate();
            return true;
        }catch (Exception ex){
             System.out.println("Problemas ao listar bibliotecario! Erro:" + ex.getMessage());
             ex.printStackTrace();
             return false;
        }finally{
            try{
                ConnectionFactory.closeConnection(conn, stmt);
            }catch (Exception e){
              System.out.println("Problemas ao fechar conexÃ£o! Erro:" + e.getMessage());
              e.printStackTrace();
            }
        }
    }

    @Override
    public Object carregar(int idObject) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Bibliotecario bibliotecario = null;
        String sql = "select p.*, b.* from pessoa p, bibliotecario b where p.idpessoa = b.idpessoa and  b.idpessoa = ?;";
        try {
            stmt = conn.prepareStatement (sql);
            stmt.setInt(1, idObject);
            rs = stmt.executeQuery();
	
            while (rs.next()) {
		bibliotecario = new Bibliotecario();
                bibliotecario.setIdBibliotecario(rs.getInt("idbibliotecario"));
		bibliotecario.setNomePessoa(rs.getString("nomepessoa"));
		bibliotecario.setTelefonePessoa(rs.getString("telefonepessoa"));
                bibliotecario.setCpfPessoa(rs.getString("cpfpessoa"));
                bibliotecario.setEmailPessoa(rs.getString("emailpessoa"));
                bibliotecario.setIdPessoa(rs.getInt("idpessoa"));
                bibliotecario.setIdBiblioteca(new Biblioteca(rs.getInt("idbiblioteca")));
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
        return bibliotecario;
    }

    @Override
    public Boolean alterar(Object object) {
        Bibliotecario bibliotecario = (Bibliotecario) object;
        PreparedStatement stmt = null;
        String sql = "update bibliotecario set idbibliotecario = ? where idpessoa = ?;";
        try {
            stmt = conn.prepareStatement (sql);
            stmt.setInt(1, bibliotecario.getIdBibliotecario());
            stmt.setInt(2, bibliotecario.getIdPessoa());
            if (new PessoaDAOImpl().alterar(bibliotecario)){
                stmt.executeUpdate();
                return true;
            } else {
                return false;
            }
        } catch (Exception ex) {
            System.out.println("Problemas ao alterar terreno! Erro: " + ex.getMessage());
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
    
}