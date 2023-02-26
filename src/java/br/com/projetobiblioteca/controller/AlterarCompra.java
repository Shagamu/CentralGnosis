package br.com.projetobiblioteca.controller;

import br.com.projetobiblioteca.dao.BibliotecarioDAOImpl;
import br.com.projetobiblioteca.dao.CompraDAOImpl;
import br.com.projetobiblioteca.dao.GenericDAO;
import br.com.projetobiblioteca.model.Livro;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "AlterarCompra", urlPatterns = {"/AlterarCompra"})
public class AlterarCompra extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            HttpServletRequest httpServletRequest = (HttpServletRequest) request;

            HttpSession sessao = httpServletRequest.getSession();

            if (sessao.getAttribute("usuario") != null) {

                int quantidadeLivros = Integer.parseInt(request.getParameter("quantidadeLivro"));
                int quantidadeCompra = Integer.parseInt(request.getParameter("quantidadeCompra"));
                Integer idLivro = Integer.parseInt(request.getParameter("idLivro"));
                int quantidadeLivro = quantidadeLivros - quantidadeCompra;

                String mensagem = null;

                Livro livro = new Livro();
                livro.setIdLivro(idLivro);
                livro.setQuantidadeLivro(quantidadeLivro);
                
                
                try {
                    GenericDAO dao = new CompraDAOImpl();
                    if (dao.alterar(livro)) {
                        mensagem = "Compra realizada com sucesso!";
                    } else {
                        mensagem = "Problemas ao realizar Compra. "
                                + "Verifique os dados informados e tente novamente!";
                    }
                    request.setAttribute("mensagem", mensagem);
                    request.getRequestDispatcher("ListarLivros").forward(request, response);
                } catch (Exception ex) {
                    System.out.println("Problemas no Servlet ao alterar Bibliotecario! Erro: " + ex.getMessage());
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
