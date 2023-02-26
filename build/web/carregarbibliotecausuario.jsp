<%@page import="br.com.projetobiblioteca.model.Usuario"%>
<%
    HttpServletRequest httpServletRequest = (HttpServletRequest) request;

    HttpSession sessao = httpServletRequest.getSession();

    if (sessao.getAttribute("usuario") != null) {
        Usuario usuario = (Usuario) sessao.getAttribute("usuario");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon">
        <link rel="stylesheet" href="css/compralivro.css">
        <title>Central Gnosis</title>
    </head>
    <body>
        <div id="header">
            <div class="logo">
                <a href="#">Gnosis</a>
            </div>  
            <nav>
                <ul>
                    <li>
                        <a href="ListarLivros">Livros</a>
                    </li>
                    <li>
                        <a href="ListarCompra?idUsuario=<%=usuario.getIdUsuario()%>">Compras</a>
                    </li>
                    <li class="dropdown">
                        <a href="ListarBibliotecas">Bibliotecas</a>    
                    </li>
                    <li>
                        <a href="CarregarUsuario?idPessoa=<%=usuario.getIdPessoa()%>">Perfil</a>
                    </li>
                    <li>
                        <a href="EncerrarSessao">Sair</a>
                    </li>
                </ul>
            </nav>
        </div>
        <br>
        <br>
        <br>
        <section id="wallet-content" class="page-content">
            <fieldset>
                <h4>Nome</h4>
                <input type="text" name="nomeBiblioteca" value="${biblioteca.nomeBiblioteca}" readonly/>
                <h4>Estado</h4>
                <input type="text" name="estadoBiblioteca" value="${biblioteca.estadoBiblioteca}" readonly/>
                <h4>Cidade</h4>
                <input type="text" name="cidadeBiblioteca" value="${biblioteca.cidadeBiblioteca}" readonly/>
                <h4>Bairro</h4>
                <input type="text" name="bairroBiblioteca" value="${biblioteca.bairroBiblioteca}" readonly/>
                <h4>Rua</h4>
                <input type="text" name="ruaBiblioteca" value="${biblioteca.ruaBiblioteca}" readonly/>
                <h4>Número</h4>
                <input type="text" name="numeroBiblioteca" value="${biblioteca.numeroBiblioteca}" readonly/>
                <h4>CEP</h4>
                <input type="text" name="numeroBiblioteca" value="${biblioteca.numeroBiblioteca}" readonly/>
                <h4>Telefone</h4>
                <input type="text" name="telefoneBiblioteca" value="${biblioteca.telefoneBiblioteca}" readonly/>
                <h4>E-mail</h4>
                <input type="text" name="emailBiblioteca" value="${biblioteca.emailBiblioteca}" readonly/>
            </fieldset>    
        </section>
    </body>
</html>
<%
    } else {
        ((HttpServletResponse) response).sendRedirect("index.jsp");
    }
%>