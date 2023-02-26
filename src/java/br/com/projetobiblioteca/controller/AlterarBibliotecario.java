package br.com.projetobiblioteca.controller;

import br.com.projetobiblioteca.dao.BibliotecarioDAOImpl;
import br.com.projetobiblioteca.dao.GenericDAO;
import br.com.projetobiblioteca.model.Bibliotecario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "AlterarBibliotecario", urlPatterns = {"/AlterarBibliotecario"})
public class AlterarBibliotecario extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
    
            HttpServletRequest httpServletRequest = (HttpServletRequest) request;
    
            HttpSession sessao = httpServletRequest.getSession();
    
            if (sessao.getAttribute("bibliotecario") != null) {
                
                Integer idBibliotecario = Integer.parseInt(request.getParameter("idBibliotecario"));
                Integer idPessoa = Integer.parseInt(request.getParameter("idPessoa"));
                String nomePessoa = request.getParameter("nomePessoa");
                String cpfPessoa = request.getParameter("cpfPessoa");
                String telefonePessoa = request.getParameter("telefonePessoa");
                String emailPessoa = request.getParameter("emailPessoa");

                String mensagem = null;

                Bibliotecario bibliotecario = new Bibliotecario();
                bibliotecario.setIdBibliotecario(idBibliotecario);
                bibliotecario.setIdPessoa(idPessoa);
                bibliotecario.setNomePessoa(nomePessoa);
                bibliotecario.setCpfPessoa(cpfPessoa);
                bibliotecario.setTelefonePessoa(telefonePessoa);
                bibliotecario.setEmailPessoa(emailPessoa);

                 try {
                    GenericDAO dao = new BibliotecarioDAOImpl();
                    if (dao.alterar(bibliotecario)) {
                        mensagem = "Bibliotecario alterado com sucesso!";
                    } else {
                        mensagem = "Problemas ao alterar Bibliotecario. "
                                + "Verifique os dados informados e tente novamente!";
                    }
                    request.setAttribute("mensagem", mensagem);
                    request.getRequestDispatcher("CarregarBibliotecario").forward(request, response);
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
