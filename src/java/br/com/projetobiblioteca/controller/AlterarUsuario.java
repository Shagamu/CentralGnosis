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
import javax.servlet.http.HttpSession;

@WebServlet(name = "AlterarUsuario", urlPatterns = {"/AlterarUsuario"})
public class AlterarUsuario extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            HttpServletRequest httpServletRequest = (HttpServletRequest) request;
    
            HttpSession sessao = httpServletRequest.getSession();
    
            if (sessao.getAttribute("usuario") != null) {
                
                Integer idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
                Integer idPessoa = Integer.parseInt(request.getParameter("idPessoa"));
                String nomePessoa = request.getParameter("nomeUsuario");
                String estadoUsuario = request.getParameter("estadoUsuario");
                String cidadeUsuario = request.getParameter("cidadeUsuario");
                String bairroUsuario = request.getParameter("bairroUsuario");
                String ruaUsuario = request.getParameter("ruaUsuario");
                String numeroUsuario = request.getParameter("numeroUsuario");
                String cepUsuario = request.getParameter("cepUsuario");
                String telefonePessoa = request.getParameter("telefoneUsuario");
                String cpfPessoa = request.getParameter("cpfUsuario");
                String emailPessoa = request.getParameter("emailUsuario");

                String mensagem = null;

                Usuario usuario = new Usuario();
                usuario.setIdUsuario(idUsuario);
                usuario.setIdPessoa(idPessoa);
                usuario.setNomePessoa(nomePessoa);
                usuario.setEstadoUsuario(estadoUsuario);
                usuario.setCidadeUsuario(cidadeUsuario);
                usuario.setBairroUsuario(bairroUsuario);
                usuario.setRuaUsuario(ruaUsuario);
                usuario.setNumeroUsuario(numeroUsuario);
                usuario.setCepUsuario(cepUsuario);
                usuario.setTelefonePessoa(telefonePessoa);
                usuario.setCpfPessoa(cpfPessoa);
                usuario.setEmailPessoa(emailPessoa);

                 try {
                    GenericDAO dao = new UsuarioDAOImpl();
                    if (dao.alterar(usuario)) {
                        mensagem = "Usuario alterado com sucesso!";
                    } else {
                        mensagem = "Problemas ao alterar Usuario. "
                                + "Verifique os dados informados e tente novamente!";
                    }
                    request.setAttribute("mensagem", mensagem);
                    request.getRequestDispatcher("CarregarUsuario").forward(request, response);
                } catch (Exception ex) {
                    System.out.println("Problemas no Servlet ao alterar Usuario! Erro: " + ex.getMessage());
                    ex.printStackTrace();
                }
            } else {
                ((HttpServletResponse) response).sendRedirect("index.jsp");
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
