package br.com.projetobiblioteca.dao;

import br.com.projetobiblioteca.model.Compra;
import br.com.projetobiblioteca.model.Livro;
import br.com.projetobiblioteca.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CompraDAOImpl implements GenericDAO {

    private Connection conn;

    public CompraDAOImpl() throws Exception {
        try {
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Conectado com sucesso!");
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    @Override
    public Boolean cadastrar(Object object) {
        Compra compra = (Compra) object;
        PreparedStatement stmt = null;

        String sql = "Insert into compra(valorcompra, quantidadecompra, idlivro, idusuario) values (?, ?, ?, ?);";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setDouble(1, compra.getValorCompra());
            stmt.setInt(2, compra.getQuantidadeCompra());
            stmt.setInt(3, compra.getIdLivro().getIdLivro());
            stmt.setInt(4, compra.getIdUsuario().getIdUsuario());
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

    @Override
    public List<Object> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean excluir(int idOject) {
        PreparedStatement stmt = null;

        String sql = "delete from compra where idusuario = ?;";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idOject);
            stmt.executeUpdate();
            return true;
        } catch (Exception ex) {
            System.out.println("Problemas ao listar usuario! Erro:" + ex.getMessage());
            ex.printStackTrace();
            return false;
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception e) {
                System.out.println("Problemas ao fechar conexÃ£o! Erro:" + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    @Override
    public Object carregar(int idObject) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean alterar(Object object) {
        Livro livro = (Livro) object;
        PreparedStatement stmt = null;
        String sql = "update livro set quantidadelivro = ? where idlivro = ?;";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, livro.getQuantidadeLivro());
            stmt.setInt(2, livro.getIdLivro());
            stmt.executeUpdate();
            return true;
        } catch (Exception ex) {
            System.out.println("Problemas ao alterar livro! Erro: " + ex.getMessage());
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

    public Object listarCompra(int idUsuario) {
        List<Object> compras = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Compra compra = null;
            String sql = "select c.*, l.* from compra c, livro l where c.idlivro = l.idlivro and c.idusuario = ?;";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idUsuario);
            rs = stmt.executeQuery();

            while (rs.next()) {
                compra = new Compra();
                compra.setIdCompra(rs.getInt("idcompra"));
                compra.setValorCompra(rs.getDouble("valorcompra"));
                compra.setQuantidadeCompra(rs.getInt("quantidadecompra"));
                compra.setIdLivro(new Livro(rs.getInt("idlivro")));
                compra.setTituloLivro(new Livro(rs.getString("titulolivro")));
                compras.add(compra);
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao listar compras! Erro:" + ex.getMessage());
            ex.printStackTrace();

        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt, rs);
            } catch (Exception e) {
                System.out.println("Problemas ao fechar a conexão! Erro" + e.getMessage());
                e.printStackTrace();
            }
        }
        return compras;
    }

}
