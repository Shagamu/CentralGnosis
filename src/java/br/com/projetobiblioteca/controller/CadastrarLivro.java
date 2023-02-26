package br.com.projetobiblioteca.controller;

import br.com.projetobiblioteca.dao.GenericDAO;
import br.com.projetobiblioteca.dao.GeneroLivroDAOImpl;
import br.com.projetobiblioteca.dao.LivroDAOImpl;
import br.com.projetobiblioteca.model.Biblioteca;
import br.com.projetobiblioteca.model.Genero;
import br.com.projetobiblioteca.model.GeneroLivro;
import br.com.projetobiblioteca.model.Livro;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "CadastrarLivro", urlPatterns = {"/CadastrarLivro"})
public class CadastrarLivro extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            HttpServletRequest httpServletRequest = (HttpServletRequest) request;
    
            HttpSession sessao = httpServletRequest.getSession();
    
            if (sessao.getAttribute("bibliotecario") != null) {
        
                String tituloLivro = request.getParameter("tituloLivro");
                String autorLivro = request.getParameter("autorLivro");
                String editoraLivro = request.getParameter("editoraLivro");
                String anoLivro = request.getParameter("anoLivro");
                String isbnLivro = request.getParameter("isbnLivro");
                double valorLivro = Double.parseDouble(request.getParameter("valorLivro"));
                int quantidadeLivro = Integer.parseInt(request.getParameter("quantidadeLivro"));
                Integer idBiblioteca = Integer.parseInt(request.getParameter("idBiblioteca"));
                String[] idGenero = request.getParameterValues("idGenero");
                Integer quantidadeGeneros = idGenero.length;
                

                String mensagem = null;

                Livro livro = new Livro();

                livro.setTituloLivro(tituloLivro);
                livro.setAutorLivro(autorLivro);
                livro.setEditoraLivro(editoraLivro);
                livro.setAnoLivro(anoLivro);
                livro.setIsbnLivro(isbnLivro);
                livro.setValorLivro(valorLivro);
                livro.setQuantidadeLivro(quantidadeLivro);
                livro.setIdBiblioteca(new Biblioteca(idBiblioteca));
                Integer idLivro = null;

                try {
                    LivroDAOImpl dao = new LivroDAOImpl();
                    idLivro = dao.cadastrarLivro(livro);
                    if (idLivro > 0) {
                        livro.setIdLivro(idLivro);
                        for (int i = 0; i < quantidadeGeneros; i++) {
                            GeneroLivro generolivro = new GeneroLivro();
                            generolivro.setIdGenero(new Genero(Integer.parseInt(idGenero[i])));
                            generolivro.setIdLivro(livro);

                            GenericDAO daoGenero = new GeneroLivroDAOImpl();
                            if (daoGenero.cadastrar(generolivro)) {
                                mensagem = "Livro cadastrado com sucesso!";
                            } else {
                                mensagem = "Problemas ao cadastrar Livro. Verifique os dados e tente novamente!";
                            }
                        }
                    } else {
                        mensagem = "Problemas ao cadastrar Livro. Verifique os dados e tente novamente!";    
                    }
                    request.setAttribute("mensagem", mensagem);
                    request.getRequestDispatcher("ListarGenero").forward(request, response);
                } catch (Exception ex) {
                    System.out.println("Problemas no Servlet ao cadastrar livro! Erro: " + ex.getMessage());
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
