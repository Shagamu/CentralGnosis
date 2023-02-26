package br.com.projetobiblioteca.controller;

import br.com.projetobiblioteca.dao.BibliotecarioDAOImpl;
import br.com.projetobiblioteca.dao.GenericDAO;
import br.com.projetobiblioteca.model.Biblioteca;
import br.com.projetobiblioteca.model.Bibliotecario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CadastrarBibliotecario", urlPatterns = {"/CadastrarBibliotecario"})
public class CadastrarBibliotecario extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            String nomeBibliotecario = request.getParameter("nomeBibliotecario");
            String cpfBibliotecario = request.getParameter("cpfBibliotecario");
            String telefoneBibliotecario = request.getParameter("telefoneBibliotecario");
            String emailBibliotecario = request.getParameter("emailBibliotecario");
            String senhaBibliotecario = request.getParameter("senhaBibliotecario");
            int idBiblioteca = Integer.parseInt(request.getParameter("idBiblioteca"));

            String mensagem = null;

            Bibliotecario bibliotecario = new Bibliotecario();

            bibliotecario.setNomePessoa(nomeBibliotecario);
            bibliotecario.setCpfPessoa(cpfBibliotecario);
            bibliotecario.setTelefonePessoa(telefoneBibliotecario);
            bibliotecario.setEmailPessoa(emailBibliotecario);
            bibliotecario.setSenhaPessoa(senhaBibliotecario);
            bibliotecario.setIdBiblioteca(new Biblioteca(idBiblioteca));

            try {
                GenericDAO dao = new BibliotecarioDAOImpl();
                if (dao.cadastrar(bibliotecario)) {
                    mensagem = "Bibliotecario cadastrado com sucesso!";
                } else {
                    mensagem = "Problemas ao cadastrar Bibliotecario. "
                            + "Verifique os dados informados e tente novamente!";
                }
                request.setAttribute("mensagem", mensagem);
                request.getRequestDispatcher("cadastrarbibliotecario.jsp").forward(request, response);
            } catch (Exception ex) {
                System.out.println("Problemas no Servlet ao cadastrar Bibliotecario! Erro: " + ex.getMessage());
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
