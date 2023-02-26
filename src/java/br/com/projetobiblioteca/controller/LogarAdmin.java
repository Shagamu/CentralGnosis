package br.com.projetobiblioteca.controller;

import br.com.projetobiblioteca.dao.AdminDAOImpl;
import br.com.projetobiblioteca.dao.BibliotecarioDAOImpl;
import br.com.projetobiblioteca.model.Admin;
import br.com.projetobiblioteca.model.Bibliotecario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "LogarAdmin", urlPatterns = {"/LogarAdmin"})
public class LogarAdmin extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            String loginAdmin = request.getParameter("loginAdmin");
            String senhaAdmin = request.getParameter("senhaAdmin");

            String mensagem = null;

            if (!loginAdmin.equals("") && !senhaAdmin.equals("")) {
                AdminDAOImpl dao = new AdminDAOImpl();
                Admin admin = (Admin) dao.logarAdmin(loginAdmin, senhaAdmin);
                if (admin != null) {
                    HttpSession sessao = request.getSession(true);
                    sessao.setAttribute("admin", admin);
                    sessao.setAttribute("mensagem", mensagem);
                    request.getRequestDispatcher("dashboard.jsp").forward(request, response);
                } else {
                    mensagem = "Login ou Senha Inválidos!";
                    request.setAttribute("mensagem", mensagem);
                    request.getRequestDispatcher("admin.jsp").forward(request, response);
                }
            } else {
                mensagem = "É necessário digitar Login e Senha";
                request.setAttribute("mensagem", mensagem);
                request.getRequestDispatcher("admin.jsp").forward(request, response);
            }

        } catch (Exception ex) {
            System.out.println("Problemas logar! Erro: " + ex.getMessage());
            ex.printStackTrace();
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
