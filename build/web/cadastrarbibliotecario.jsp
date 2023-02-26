<% 
    HttpServletRequest httpServletRequest = (HttpServletRequest) request;
    
    HttpSession sessao = httpServletRequest.getSession();
    
    if (sessao.getAttribute("admin") !=null) {
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Central Gnosis</title>
    </head>
    <body>
        <form name="cadastrarbibliotecario" action="CadastrarBibliotecario" method="POST">
            <div>
                ID Biblioteca: <input type="text" name="idBiblioteca" value="${biblioteca.idBiblioteca}" readonly>
            </div>
            <div>
                Nome:  <input type="text" name="nomeBibliotecario">
            </div>
            <div>
                CPF: <input type="text" name="cpfBibliotecario">
            </div>
            <div>
                Telefone: <input type="text" name="telefoneBibliotecario">
            </div>
            <div>
                E-mail: <input type="text" name="emailBibliotecario">
            </div>
            <div>
                Senha: <input type="text" name="senhaBibliotecario">
            </div>
            <div>
                <input type="submit" name="cadastrar" value="Cadastrar">
            </div>
        </form>
    </body>
</html>
<%
    } else {
        ((HttpServletResponse) response).sendRedirect("index.jsp");
    }
%>