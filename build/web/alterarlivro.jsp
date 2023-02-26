<%@page import="br.com.projetobiblioteca.model.Bibliotecario"%>
<%@page import="br.com.projetobiblioteca.model.Genero"%>
<%
    HttpServletRequest httpServletRequest = (HttpServletRequest) request;

    HttpSession sessao = httpServletRequest.getSession();

    if (sessao.getAttribute("bibliotecario") != null) {
        Bibliotecario bibliotecario = (Bibliotecario) sessao.getAttribute("bibliotecario");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.com.projetobiblioteca.model.Livro"%>
<%@page import="br.com.projetobiblioteca.model.Livro"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />

        <!----======== CSS ======== -->
        <link rel="stylesheet" href="css/dashboard/style-dashboard.css" />
        <link rel="stylesheet" href="css/dashboard/cadastrar.css" />
        <link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon" />

        <script src="https://kit.fontawesome.com/a81368914c.js"></script>
        <script src="http://igorescobar.github.io/jQuery-Mask-Plugin/"></script>
        <!----===== Boxicons CSS ===== -->
        <link
            href="https://unpkg.com/boxicons@2.1.1/css/boxicons.min.css"
            rel="stylesheet"
            />

        <style>
            form .button input {
                background-image: linear-gradient(to right, #006494, #13293D);
            }

            form .button input:hover {
                background-image: linear-gradient(to right, #006494, #13293D);
            }

            .botgenero {
                width: 30px;
                border-radius: 5px;
                border: 2px solid #006494;
                color: #fff;
                font-size: 18px;
                font-weight: 500;
                cursor: pointer;
                transition: all 0.3s ease;
                background-color: #006494;
            }

            .botgenero:hover {
                color: #006494;
                background-color: #fff;
            }

            .user-details .input-box input:focus,
            .user-details .input-box input:valid{
                border-color: #006494;
            }
            .container .title::before{
                content: "";
                position: absolute;
                left: 0;
                bottom: 0;
                height: 3px;
                width: 100%;
                border-radius: 5px;
                background-image: linear-gradient(to right, #006494, #13293D);
            }
            .none{
                display: none;
            }

            div.none{
                display: none;
            }


        </style>

        <script>
            String.prototype.reverse = function () {
                return this.split('').reverse().join('');
            };

            function mascaraMoeda(campo, evento) {
                var tecla = (!evento) ? window.event.keyCode : evento.which;
                var valor = campo.value.replace(/[^\d]+/gi, '').reverse();
                var resultado = "";
                var mascara = "##.###.###,##".reverse();
                for (var x = 0, y = 0; x < mascara.length && y < valor.length; ) {
                    if (mascara.charAt(x) != '#') {
                        resultado += mascara.charAt(x);
                        x++;
                    } else {
                        resultado += valor.charAt(y);
                        y++;
                        x++;
                    }
                }
                campo.value = resultado.reverse();
            }
        </script>
        <title>Central Gnosis</title>
        <script src="js/jquery-1.10.1.js" type="text/javascript"></script>
        <script src="js/jquery.validate.min.js" type="text/javascript"></script>
    </head>
    <body>
        <nav class="sidebar close">
            <header>
                <div class="image-text">
                    <span class="image">
                        <img src="images/logo-dashboard.png" alt="" />
                    </span>

                    <div class="text logo-text">
                        <span class="name">Gnosis</span>
                        <span class="profession">Bibliotecário</span>
                    </div>
                </div>

                <i class="bx bx-chevron-right toggle"></i>
            </header>

            <div class="menu-bar">
                <div class="menu">
                    <ul class="menu-links">
                        <abbr title="Listar Livro">
                            <li class="nav-link">
                                <a href="ListarLivro?idBiblioteca=<%=bibliotecario.getIdBiblioteca().getIdBiblioteca()%>" onclick="toggleContent('home')">
                                    <i class="bx bx-book icon"></i>
                                    <span class="text nav-text">Listar</span>
                                </a>
                            </li>
                        </abbr>

                        <abbr title="Cadastrar Livro"
                              ><li class="nav-link">
                                <a href="CarregarBibliotecaLivro?idBiblioteca=<%=bibliotecario.getIdBiblioteca().getIdBiblioteca()%>" onclick="toggleContent('stats')">
                                    <i class="bx bx-pen icon"></i>
                                    <span class="text nav-text">Cadastrar</span>
                                </a>
                            </li></abbr>

                        <abbr title="Biblioteca"><li class="nav-link">
                                <a href="CarregarBiblioteca?idBiblioteca=<%=bibliotecario.getIdBiblioteca().getIdBiblioteca()%>" onclick="toggleContent('notis')">
                                    <i class="bx bx-home icon"></i>
                                    <span class="text nav-text">Biblioteca</span>
                                </a>
                            </li></abbr
                        >

                        <abbr title="Perfil"><li class="nav-link">
                                <a href="CarregarBibliotecario?idPessoa=<%=bibliotecario.getIdPessoa()%>" onclick="toggleContent('wallet')">
                                    <i class="bx bx-user icon"></i>
                                    <span class="text nav-text">Perfil</span>
                                </a>
                            </li></abbr
                        >
                    </ul>
                </div>

                <div class="bottom-content">
                    <li class="">
                        <a href="EncerrarSessao">
                            <i class="bx bx-log-out icon"></i>
                            <span class="text nav-text">Logout</span>
                        </a>
                    </li>
                </div>
            </div>
        </nav>

        <section id="stats-content" class="page-content">
            <div class="container">
                <div class="title">Alterar Livro</div>
                <div class="content">
                    <form name="alterarlivro" action="AlterarLivro" method="POST">
                        <div class="user-details">
                            <div class="none">
                                <input class="none" type="text" placeholder="Digite o título" name="idLivro" value="${livro.idLivro}" required>
                            </div>
                            <div class="input-box">
                                <span class="details">Título</span>
                                <input type="text" placeholder="Digite o título" name="tituloLivro" value="${livro.tituloLivro}" required>
                            </div>
                            <div class="input-box">
                                <span class="details">Autor</span>
                                <input type="text" placeholder="Digite o autor" name="autorLivro" value="${livro.autorLivro}" required>
                            </div>
                            <div class="input-box">
                                <span class="details">Editora</span>
                                <input type="text" placeholder="Digite a editora" name="editoraLivro" value="${livro.editoraLivro}" required>
                            </div>
                            <div class="input-box">
                                <span class="details">Ano de publicação</span>
                                <input type="number" placeholder="Digite o ano de publicação" name="anoLivro" value="${livro.anoLivro}" required>
                            </div>
                            <table>
                                <%
                                    List<Genero> generoslivro = (List<Genero>) request.getAttribute("generoslivro");
                                    for (Genero genero : generoslivro) {
                                %>
                                <tr>
                                    <td><%=genero.getNomeGenero()%></td>
                                </tr>

                                <%
                                    }
                                %>
                            </table>
                            <div class="input-box">
                                <span class="details">Gênero</span>
                                <div class="wrapper">
                                    <select class="generos" name="idGenero" id="genero">
                                        <c:forEach var="genero" items="${generos}">
                                            <option value="${genero.idGenero}">
                                                ${genero.nomeGenero}</option>
                                            </c:forEach>
                                    </select>
                                </div>

                                <button class="botgenero" type="button" onclick="add()" class="buttonelements">+</button>
                                <button class="botgenero" type="button" onclick="remove()" class="buttonelements">-</button>

                                <script rel="javascript">
                                    const add = () => {
                                        const conveniosDentista = document.getElementsByClassName("generos")
                                        if (conveniosDentista.length <= 10)
                                            conveniosDentista[conveniosDentista.length - 1].parentNode.insertBefore(conveniosDentista[0].cloneNode(true), conveniosDentista[conveniosDentista.length - 1].nextSibling)
                                    }
                                    const remove = () => {
                                        const conveniosDentista = document.getElementsByClassName("generos")
                                        if (conveniosDentista.length > 1)
                                            conveniosDentista[conveniosDentista.length - 1].remove()
                                    }
                                </script>
                            </div>
                            <div class="input-box">
                                <span class="details">ISBN</span>
                                <input type="number" placeholder="Digite o ISBN" name="isbnLivro" value="${livro.isbnLivro}" required>
                            </div>
                            <div class="input-box">
                                <span class="details">Valor</span>
                                <input type="text" onKeyUp="mascaraMoeda(this, event)" placeholder="Digite o valor" name="valorLivro" value="${livro.valorLivro}" required>
                            </div>
                            <div class="input-box">
                                <span class="details">Quantidade</span>
                                <input type="number" placeholder="Digite a quantidade" name="quantidadeLivro" value="${livro.quantidadeLivro}" required>
                            </div>
                        </div>
                        <div class="button">
                            <input type="submit" id="alterar" name="alterar" value="Alterar">
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </section>

    <script src="js/script-dashboard.js"></script>
    <script type="text/javascript" src="js/main.js"></script>
</body>
</html>
<%
    } else {
        ((HttpServletResponse) response).sendRedirect("index.jsp");
    }
%>