package br.com.projetobiblioteca.controller;

import br.com.projetobiblioteca.dao.BibliotecaDAOImpl;
import br.com.projetobiblioteca.dao.GenericDAO;
import br.com.projetobiblioteca.model.Biblioteca;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/CadastrarBiblioteca"})
public class CadastrarBiblioteca extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            HttpServletRequest httpServletRequest = (HttpServletRequest) request;

            HttpSession sessao = httpServletRequest.getSession();

            if (sessao.getAttribute("admin") != null) {

                String nomeBiblioteca = request.getParameter("nomeBiblioteca");
                String estadoBiblioteca = request.getParameter("estadoBiblioteca");
                String cidadeBiblioteca = request.getParameter("cidadeBiblioteca");
                String bairroBiblioteca = request.getParameter("bairroBiblioteca");
                String ruaBiblioteca = request.getParameter("ruaBiblioteca");
                String numeroBiblioteca = request.getParameter("numeroBiblioteca");
                String cepBiblioteca = request.getParameter("cepBiblioteca");
                String telefoneBiblioteca = request.getParameter("telefoneBiblioteca");
                String emailBiblioteca = request.getParameter("emailBiblioteca");

                String mensagem = null;

                Biblioteca biblioteca = new Biblioteca();

                biblioteca.setNomeBiblioteca(nomeBiblioteca);
                biblioteca.setEstadoBiblioteca(estadoBiblioteca);
                biblioteca.setCidadeBiblioteca(cidadeBiblioteca);
                biblioteca.setBairroBiblioteca(bairroBiblioteca);
                biblioteca.setRuaBiblioteca(ruaBiblioteca);
                biblioteca.setNumeroBiblioteca(numeroBiblioteca);
                biblioteca.setCepBiblioteca(cepBiblioteca);
                biblioteca.setTelefoneBiblioteca(telefoneBiblioteca);
                biblioteca.setEmailBiblioteca(emailBiblioteca);

                try {
                    GenericDAO dao = new BibliotecaDAOImpl();
                    if (dao.cadastrar(biblioteca)) {
                        mensagem = "Biblioteca cadastrada com sucesso!";
                    } else {
                        mensagem = "Problemas ao cadastrar Biblioteca. "
                                + "Verifique os dados informados e tente novamente!";
                    }
                    request.setAttribute("mensagem", mensagem);
                    request.getRequestDispatcher("cadastrarbiblioteca.jsp").forward(request, response);
                } catch (Exception ex) {
                    System.out.println("Problemas no Servlet ao cadastrar Biblioteca! Erro: " + ex.getMessage());
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
