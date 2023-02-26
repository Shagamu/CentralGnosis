<% 
    HttpServletRequest httpServletRequest = (HttpServletRequest) request;
    
    HttpSession sessao = httpServletRequest.getSession();
    
    if (sessao.getAttribute("admin") !=null) {
%>

<%@page import="br.com.projetobiblioteca.model.Biblioteca"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Central Gnosis</title>
    </head>
    <body>
        <table>
            <tr>
                <th>ID Biblioteca</th>
                <th>Nome</th>
                <th>Estado</th>
                <th>Cidade</th>
                <th>Bairro</th>
                <th>Rua</th>
                <th>Número</th>
                <th>CEP</th>
                <th>Telefone</th>
                <th>E-mail</th>
                <th colspan="2">Editar</th>
            </tr>

            <%
                List<Biblioteca> bibliotecas = (List<Biblioteca>) request.getAttribute("bibliotecas");
                for (Biblioteca biblioteca : bibliotecas) {
            %>
            <tr>
                <td><%=biblioteca.getIdBiblioteca()%></td>
                <td><%=biblioteca.getNomeBiblioteca()%></td>
                <td><%=biblioteca.getEstadoBiblioteca()%></td>
                <td><%=biblioteca.getCidadeBiblioteca()%></td>
                <td><%=biblioteca.getBairroBiblioteca()%></td>
                <td><%=biblioteca.getRuaBiblioteca()%></td>
                <td><%=biblioteca.getNumeroBiblioteca()%></td>
                <td><%=biblioteca.getCepBiblioteca()%></td>
                <td><%=biblioteca.getTelefoneBiblioteca()%></td>
                <td><%=biblioteca.getEmailBiblioteca()%></td>
                <td><a class="update" href="CarregarBibliotecaAdm?idBiblioteca=<%=biblioteca.getIdBiblioteca()%>">Cadastrar Funcionário</a></td>
            </tr>

            <%
                }
            %>
        </table>
    </body>
</html>
<%
    } else {
        ((HttpServletResponse) response).sendRedirect("index.jsp");
    }
%>