<%@page import="br.com.projetobiblioteca.model.Usuario"%>
<%@page import="java.util.List"%>
<%@page import="br.com.projetobiblioteca.model.Biblioteca"%>
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
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />

        <link rel="stylesheet" href="css/home.css" />
        <link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon">
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
        <br>
        <h1 class="title">Bibliotecas</h1>

        <div class="infinite-scroll-area">
            <div id="infinite-scroll-list" class="infinite-scroll-list">
                <%
                    List<Biblioteca> bibliotecas = (List<Biblioteca>) request.getAttribute("bibliotecas");
                    for (Biblioteca biblioteca : bibliotecas) {
                %>
                <div class="li">
                    <div class="img">
                        <img
                            src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQwJf1CsNCdaKLdbA2nif-NG-XsZ6-7_oBlTw&usqp=CAU"
                            alt=""
                            />
                    </div>
                    <div class="info">
                        <h2 class="title"><%=biblioteca.getNomeBiblioteca()%></h2>
                        <p class="summary"><%=biblioteca.getTelefoneBiblioteca()%></p>
                        <p class="summary"><%=biblioteca.getEmailBiblioteca()%></p>
                        <a href="CarregarBibliotecaUsuario?idBiblioteca=<%=biblioteca.getIdBiblioteca()%>" class="detail">Ver mais</a>
                    </div>
                </div>
                <%
                    }
                %>
            </div>
            <button id="more-btn" class="more-btn">CARREGAR MAIS</button>
        </div>
        <script src="js/home.js"></script>
    </body>
</html>
<%
    } else {
        ((HttpServletResponse) response).sendRedirect("index.jsp");
    }
%>