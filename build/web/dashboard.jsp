<%
    HttpServletRequest httpServletRequest = (HttpServletRequest) request;

    HttpSession sessao = httpServletRequest.getSession();

    if (sessao.getAttribute("admin") != null) {
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Central Gnosis</title>
    </head>
    <body>
        <div>
            <a href="cadastrarbiblioteca.jsp">Cadastrar Biblioteca</a>
            <a href="ListarBiblioteca">Listar Bibliotecas</a>
            <a href="EncerrarSessao">Sair</a>
        </div>
    </body>
</html>

<%
    } else {
        ((HttpServletResponse) response).sendRedirect("index.jsp");
    }
%>
