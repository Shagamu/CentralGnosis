package br.com.projetobiblioteca.controller;

import br.com.projetobiblioteca.dao.CompraDAOImpl;
import br.com.projetobiblioteca.dao.GenericDAO;
import br.com.projetobiblioteca.model.Compra;
import br.com.projetobiblioteca.model.Livro;
import br.com.projetobiblioteca.model.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "CadastrarCompra", urlPatterns = {"/CadastrarCompra"})
public class CadastrarCompra extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            HttpServletRequest httpServletRequest = (HttpServletRequest) request;

            HttpSession sessao = httpServletRequest.getSession();

            if (sessao.getAttribute("usuario") != null) {

                double valorLivro = Double.parseDouble(request.getParameter("valorLivro"));
                int quantidadeLivros = Integer.parseInt(request.getParameter("quantidadeLivro"));
                int quantidadeCompra = Integer.parseInt(request.getParameter("quantidadeCompra"));
                Integer idLivro = Integer.parseInt(request.getParameter("idLivro"));
                Integer idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
                double valorCompra = valorLivro * quantidadeCompra;
                int quantidadeLivro = quantidadeLivros - quantidadeCompra;

                String mensagem = null;

                Compra compra = new Compra();
                compra.setValorCompra(valorCompra);
                compra.setQuantidadeCompra(quantidadeCompra);
                compra.setIdLivro(new Livro(idLivro));
                compra.setIdUsuario(new Usuario(idUsuario));
                
                Livro livro = new Livro();
                livro.setIdLivro(idLivro);
                livro.setQuantidadeLivro(quantidadeLivro);

                try {
                    GenericDAO dao = new CompraDAOImpl();
                    if (dao.cadastrar(compra)) {
                        mensagem = "Compra realizada com sucesso!";
                    } else {
                        mensagem = "Problemas ao realizar Compra. "
                                + "Verifique os dados informados e tente novamente!";
                    }
                    request.setAttribute("mensagem", mensagem);
                    request.getRequestDispatcher("AlterarCompra").forward(request, response);
                } catch (Exception ex) {
                    System.out.println("Problemas no Servlet ao realizar Compra! Erro: " + ex.getMessage());
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
