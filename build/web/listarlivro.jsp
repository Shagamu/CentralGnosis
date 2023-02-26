<%@page import="br.com.projetobiblioteca.model.Bibliotecario"%>
<%
    HttpServletRequest httpServletRequest = (HttpServletRequest) request;

    HttpSession sessao = httpServletRequest.getSession();

    if (sessao.getAttribute("bibliotecario") != null) {
    Bibliotecario bibliotecario = (Bibliotecario) sessao.getAttribute("bibliotecario");
%>

<%@page import="br.com.projetobiblioteca.model.Livro"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link rel="stylesheet" href="css/dashboard/style-dashboard.css" />
        <link rel="stylesheet" href="css/dashboard/listar.css" />
        <link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon" />

        <script src="https://kit.fontawesome.com/a81368914c.js"></script>
        <script src="http://igorescobar.github.io/jQuery-Mask-Plugin/"></script>
        <!----===== Boxicons CSS ===== -->
        <link
            href="https://unpkg.com/boxicons@2.1.1/css/boxicons.min.css"
            rel="stylesheet"
            />
        <title>Central Gnosis</title>
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
                            </li></abbr
                        >

                        <abbr title="Biblioteca"
                              ><li class="nav-link">
                                <a href="CarregarBiblioteca?idBiblioteca=<%=bibliotecario.getIdBiblioteca().getIdBiblioteca()%>" onclick="toggleContent('notis')">
                                    <i class="bx bx-home icon"></i>
                                    <span class="text nav-text">Biblioteca</span>
                                </a>
                            </li></abbr
                        >

                        <abbr title="Perfil"
                              ><li class="nav-link">
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

        <section id="home-content" class="page-content">
            <div class="text">Livros</div>
            <table class="rwd-table">
                <tr>
                    <th>Título</th>
                    <th>Autor</th>
                    <th>Editora</th>
                    <th>Ano de Publicação</th>
                    <th>ISBN</th>
                    <th>Valor</th>
                    <th>Quantidade</th>
                    <th>Editar</th>
                    <th>Excluir</th>
                </tr>
                <%
                    List<Livro> livros = (List<Livro>) request.getAttribute("livros");
                    for (Livro livro : livros) {
                %>
                <tr>
                    <td><%=livro.getTituloLivro()%></td>
                    <td><%=livro.getAutorLivro()%></td>
                    <td><%=livro.getEditoraLivro()%></td>
                    <td><%=livro.getAnoLivro()%></td>
                    <td><%=livro.getIsbnLivro()%></td>
                    <td><%=livro.getValorLivro()%></td>
                    <td><%=livro.getQuantidadeLivro()%></td>
                    <td><a href="CarregarLivro?idLivro=<%=livro.getIdLivro()%>"><i class="bx bx-pen icon"></i></a></td>
                    <td><a href="ExcluirLivro?idLivro=<%=livro.getIdLivro()%>"><i class="bx bx-trash icon"></i></a></td>
                </tr>
                <%
                    }
                %>

            </table>
        </section>

        <script src="js/script-dashboard.js"></script>
    </body>
</html>
<%
    } else {
        ((HttpServletResponse) response).sendRedirect("index.jsp");
    }
%>