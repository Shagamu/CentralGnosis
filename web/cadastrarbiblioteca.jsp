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
        <form name="cadastrarbiblioteca" action="CadastrarBiblioteca" method="POST">
            <div>
                Nome:  <input type="text" name="nomeBiblioteca">
            </div>
            <div>
                Estado: <input type="text" name="estadoBiblioteca">
            </div>
            <div>
                Cidade: <input type="text" name="cidadeBiblioteca">
            </div>
            <div>
                Bairro: <input type="text" name="bairroBiblioteca">
            </div>
            <div>
                Rua: <input type="text" name="ruaBiblioteca">
            </div>
            <div>
                Número: <input type="text" name="numeroBiblioteca">
            </div>
            <div>
                CEP: <input type="text" name="cepBiblioteca">
            </div>
            <div>
                Telefone: <input type="text" name="telefoneBiblioteca">
            </div>
            <div>
                E-mail <input type="text" name="emailBiblioteca">
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