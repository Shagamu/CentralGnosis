package br.com.projetobiblioteca.dao;

import br.com.projetobiblioteca.model.Usuario;
import br.com.projetobiblioteca.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAOImpl implements GenericDAO {

    private Connection conn;

    public UsuarioDAOImpl() throws Exception {
        try {
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Conectado com sucesso!");
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    @Override
    public Boolean cadastrar(Object object) {

        Usuario usuario = (Usuario) object;
        PreparedStatement stmt = null;

        String sql = "Insert into usuario(estadousuario, cidadeusuario, bairrousuario, ruausuario, numerousuario, cepusuario, idpessoa) values (?, ?, ?, ?, ?, ?, ?);";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, usuario.getEstadoUsuario());
            stmt.setString(2, usuario.getCidadeUsuario());
            stmt.setString(3, usuario.getBairroUsuario());
            stmt.setString(4, usuario.getRuaUsuario());
            stmt.setString(5, usuario.getNumeroUsuario());
            stmt.setString(6, usuario.getCepUsuario());
            stmt.setInt(7, new PessoaDAOImpl().cadastrar(usuario));
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

    public Object logarUsuario(String email, String senha) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Usuario usuario = null;
        String sql = "select p.*, u.* from pessoa p, usuario u where p.emailpessoa = ? and p.senhapessoa = ?;";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, email);
            stmt.setString(2, senha);
            rs = stmt.executeQuery();
            while (rs.next()) {
                usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt("idusuario"));
                usuario.setEmailPessoa(rs.getString("emailpessoa"));
                usuario.setSenhaPessoa(rs.getString("senhapessoa"));
                usuario.setIdPessoa(rs.getInt("idpessoa"));
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao listar usuarios! Erro:" + ex.getMessage());
            ex.printStackTrace();

        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt, rs);
            } catch (Exception e) {
                System.out.println("Problemas ao fechar a conexão! Erro" + e.getMessage());
                e.printStackTrace();
            }
        }
        return usuario;
    }

    @Override
    public List<Object> listar() {
        List<Object> usuarios = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Usuario usuario = null;

        String sql = "select u.*, p.* from usuario u, pessoa p where p.idpessoa = u.idpessoa and u.idpessoa = ?;";

        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt("idusuario"));
                usuario.setNomePessoa(rs.getString("nomepessoa"));
                usuario.setTelefonePessoa(rs.getString("telefonepessoa"));
                usuario.setCpfPessoa(rs.getString("cpfpessoa"));
                usuario.setEmailPessoa(rs.getString("emailpessoa"));
                usuario.setSenhaPessoa(rs.getString("senhapessoa"));
                usuario.setIdPessoa(rs.getInt("idpessoa"));
                usuarios.add(usuario);
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao listar usuario! Erro:" + ex.getMessage());
            ex.printStackTrace();

        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt, rs);
            } catch (Exception e) {
                System.out.println("Problemas ao fechar a conexão! Erro" + e.getMessage());
                e.printStackTrace();
            }
        }
        return usuarios;
    }

    @Override
    public Boolean excluir(int idOject) {
        PreparedStatement stmt = null;

        String sql = "delete from usuario where idpessoa = ?;"
                + "commit;"
                + "delete from pessoa where idpessoa=?";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idOject);
            stmt.setInt(2, idOject);
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
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Usuario usuario = null;
        String sql = "select p.*, u.* from pessoa p, usuario u where p.idpessoa = u.idpessoa and u.idpessoa = ?;";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            rs = stmt.executeQuery();

            while (rs.next()) {
                usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt("idusuario"));
                usuario.setNomePessoa(rs.getString("nomepessoa"));
                usuario.setEstadoUsuario(rs.getString("estadousuario"));
                usuario.setCidadeUsuario(rs.getString("cidadeusuario"));
                usuario.setBairroUsuario(rs.getString("bairrousuario"));
                usuario.setRuaUsuario(rs.getString("ruausuario"));
                usuario.setNumeroUsuario(rs.getString("numerousuario"));
                usuario.setCepUsuario(rs.getString("cepusuario"));
                usuario.setTelefonePessoa(rs.getString("telefonepessoa"));
                usuario.setCpfPessoa(rs.getString("cpfpessoa"));
                usuario.setEmailPessoa(rs.getString("emailpessoa"));
                usuario.setIdPessoa(rs.getInt("idpessoa"));
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
        return usuario;
    }

    @Override
    public Boolean alterar(Object object) {
        Usuario usuario = (Usuario) object;
        PreparedStatement stmt = null;
        String sql = "update usuario set estadousuario = ?, cidadeusuario = ?, bairrousuario = ?, ruausuario = ?, numerousuario = ?, cepusuario = ? where idpessoa= ?;";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, usuario.getEstadoUsuario());
            stmt.setString(2, usuario.getCidadeUsuario());
            stmt.setString(3, usuario.getBairroUsuario());
            stmt.setString(4, usuario.getRuaUsuario());
            stmt.setString(5, usuario.getNumeroUsuario());
            stmt.setString(6, usuario.getCepUsuario());
            stmt.setInt(7, usuario.getIdPessoa());
            if (new PessoaDAOImpl().alterar(usuario)) {
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
