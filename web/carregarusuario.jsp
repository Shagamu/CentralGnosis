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
        <link rel="stylesheet" href="css/carregarusuario.css">
        <link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon">

        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>

        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.15/jquery.mask.min.js"></script>
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
        <br>

        <div class="container">  
            <form id="contact" name="alterarusuario" action="AlterarUsuario" method="POST">
                <fieldset>
                    <input class="none" type="text" name="idUsuario" tabindex="1" value="${usuario.idUsuario}" required >
                </fieldset>
                <fieldset>
                    <input class="none" type="text" tabindex="1" name="idPessoa" value="${usuario.idPessoa}" required >
                </fieldset>
                <fieldset>
                    <input type="text" name="nomeUsuario" value="${usuario.nomePessoa}" tabindex="1" required >
                </fieldset>
                <fieldset>
                    <input type="text" name="estadoUsuario" value="${usuario.estadoUsuario}" tabindex="2" required>
                </fieldset>
                <fieldset>
                    <input type="text" name="cidadeUsuario" value="${usuario.cidadeUsuario}" tabindex="3" required>
                </fieldset>
                <fieldset>
                    <input type="text" name="bairroUsuario" value="${usuario.bairroUsuario}" tabindex="4" required>
                </fieldset>
                <fieldset>
                    <input type="text" name="ruaUsuario" value="${usuario.ruaUsuario}" tabindex="4" required>
                </fieldset>
                <fieldset>
                    <input type="text" name="numeroUsuario" value="${usuario.numeroUsuario}" tabindex="4" required>
                </fieldset>
                <fieldset>
                    <input type="text" name="cepUsuario" value="${usuario.cepUsuario}" onkeypress="$(this).mask('00.000-000')" tabindex="4" required>
                </fieldset>
                <fieldset>
                    <input type="text" name="telefoneUsuario" value="${usuario.telefonePessoa}" onkeypress="$(this).mask('(00) 0000-00009')" tabindex="4" required>
                </fieldset>
                <fieldset>
                    <input type="text" name="cpfUsuario" value="${usuario.cpfPessoa}" onkeypress="$(this).mask('000.000.000-00')" tabindex="4" required>
                </fieldset>
                <fieldset>
                    <input type="email" name="emailUsuario" value="${usuario.emailPessoa}" tabindex="4" required>
                </fieldset>
                <fieldset>
                    <button name="Alterar" value="editar" type="submit" id="contact-submit" >Alterar</button>
                </fieldset>
                <fieldset>
                    <a href="ExcluirCompra?idUsuario=<%=usuario.getIdUsuario()%>" class="botao">Excluir</a>
                </fieldset>
            </form>
        </div>
    </body>
</html>

<%
    } else {
        ((HttpServletResponse) response).sendRedirect("index.jsp");
    }
%>