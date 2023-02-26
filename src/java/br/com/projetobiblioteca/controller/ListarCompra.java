package br.com.projetobiblioteca.controller;

import br.com.projetobiblioteca.dao.CompraDAOImpl;
import br.com.projetobiblioteca.model.Compra;
import br.com.projetobiblioteca.model.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ListarCompra", urlPatterns = {"/ListarCompra"})
public class ListarCompra extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            
            HttpServletRequest httpServletRequest = (HttpServletRequest) request;
    
            HttpSession sessao = httpServletRequest.getSession();
    
            if (sessao.getAttribute("usuario") != null) {
            
                Integer idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
                
                Compra compra = new Compra();
                
                compra.setIdUsuario(new Usuario(idUsuario));

                try {
                    CompraDAOImpl dao = new CompraDAOImpl();
                    request.setAttribute("compras", dao.listarCompra(idUsuario));
                    request.getRequestDispatcher("listarcompra.jsp").forward(request, response);
                } catch (Exception e) {
                    System.out.println("Problemas ao listar compras! Erro: " + e.getMessage());
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
