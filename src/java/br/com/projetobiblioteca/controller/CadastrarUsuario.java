package br.com.projetobiblioteca.controller;

import br.com.projetobiblioteca.dao.GenericDAO;
import br.com.projetobiblioteca.dao.UsuarioDAOImpl;
import br.com.projetobiblioteca.model.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "CadastrarUsuario", urlPatterns = {"/CadastrarUsuario"})
public class CadastrarUsuario extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String nomeUsuario = request.getParameter("nomeUsuario");
            String cpfUsuario = request.getParameter("cpfUsuario");
            String telefoneUsuario = request.getParameter("telefoneUsuario");
            String estadoUsuario = request.getParameter("estadoUsuario");
            String cidadeUsuario = request.getParameter("cidadeUsuario");
            String bairroUsuario = request.getParameter("bairroUsuario");
            String ruaUsuario = request.getParameter("ruaUsuario");
            String numeroUsuario = request.getParameter("numeroUsuario");
            String cepUsuario = request.getParameter("cepUsuario");
            String emailUsuario = request.getParameter("emailUsuario");
            String senhaUsuario = request.getParameter("senhaUsuario");
            
            String mensagem = null;

            Usuario usuario = new Usuario ();
            
            usuario.setNomePessoa(nomeUsuario);
            usuario.setCpfPessoa(cpfUsuario);
            usuario.setTelefonePessoa(telefoneUsuario);
            usuario.setEstadoUsuario(estadoUsuario);
            usuario.setCidadeUsuario(cidadeUsuario);
            usuario.setBairroUsuario(bairroUsuario);
            usuario.setRuaUsuario(ruaUsuario);
            usuario.setNumeroUsuario(numeroUsuario);
            usuario.setCepUsuario(cepUsuario);
            usuario.setEmailPessoa(emailUsuario);
            usuario.setSenhaPessoa(senhaUsuario);
  
            try {
                GenericDAO dao = new UsuarioDAOImpl();
                if (dao.cadastrar(usuario)) {
                    mensagem = "Usuario cadastrado com sucesso!";
                } else {
                    mensagem = "Problemas ao cadastrar Usuario. "
                            + "Verifique os dados informados e tente novamente!";
                }
                request.setAttribute("mensagem", mensagem);
                request.getRequestDispatcher("logarusuario.jsp").forward(request, response);
            } catch (Exception ex) {
                System.out.println("Problemas no Servlet ao cadastrar Terreno! Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
