package br.com.projetobiblioteca.controller;

import br.com.projetobiblioteca.dao.GenericDAO;
import br.com.projetobiblioteca.dao.UsuarioDAOImpl;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ExcluirUsuario", urlPatterns = {"/ExcluirUsuario"})
public class ExcluirUsuario extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            HttpServletRequest httpServletRequest = (HttpServletRequest) request;

            HttpSession sessao = httpServletRequest.getSession();

            if (sessao.getAttribute("usuario") != null) {
                int idPessoa = Integer.parseInt(request.getParameter("idPessoa"));

                String mensagem = null;

                try {
                    GenericDAO dao = new UsuarioDAOImpl();
                    if (dao.excluir(idPessoa)) {
                        mensagem = "Usuário excluido com sucesso!";
                    } else {
                        mensagem = "Problemas ao excluir usuário!";
                    }
                    request.setAttribute("mensagem", mensagem);
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                } catch (Exception e) {
                    System.out.println("Problemas na Servelet ao excluir usuário!"
                            + "Erro:" + e.getMessage());

                    e.printStackTrace();
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
