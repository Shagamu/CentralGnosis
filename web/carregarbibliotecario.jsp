<%
    HttpServletRequest httpServletRequest = (HttpServletRequest) request;

    HttpSession sessao = httpServletRequest.getSession();

    if (sessao.getAttribute("bibliotecario") != null) {
        Bibliotecario bibliotecario = (Bibliotecario) sessao.getAttribute("bibliotecario");
%>

<%@page import="br.com.projetobiblioteca.model.Bibliotecario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />

        <!----======== CSS ======== -->
        <link rel="stylesheet" href="css/dashboard/style-dashboard.css" />
        <link rel="stylesheet" href="css/dashboard/perfil.css" />
        <link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon" />

        <script src="https://kit.fontawesome.com/a81368914c.js"></script>
        <script src="http://igorescobar.github.io/jQuery-Mask-Plugin/"></script>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.15/jquery.mask.min.js"></script>
        <!----===== Boxicons CSS ===== -->
        <link
            href="https://unpkg.com/boxicons@2.1.1/css/boxicons.min.css"
            rel="stylesheet"
            />
        <style>
            .none{
                display:none;
            }
        </style>
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
        <form name="alterarbibliotecario" action="AlterarBibliotecario" method="POST">
            <section id="wallet-content" class="page-content">
                <fieldset>
                    <h2 class="fs-title" style="text-align: center;">Perfil</h2>
                    <h4 class="none">ID</h4>
                    <input type="text" class="none" name="idBibliotecario" value="${bibliotecario.idBibliotecario}"/>
                    <h4 class="none">ID</h4>
                    <input type="text" class="none" name="idPessoa"  value="${bibliotecario.idPessoa}"/>
                    <h4>Nome</h4>
                    <input type="text" name="nomePessoa" value="${bibliotecario.nomePessoa}"/>
                    <h4>E-mail</h4>
                    <input type="text" name="emailPessoa" value="${bibliotecario.emailPessoa}"/>
                    <h4>Telefone</h4>
                    <input type="text" name="telefonePessoa" value="${bibliotecario.telefonePessoa}" onkeypress="$(this).mask('(00) 0000-00009')" />
                    <h4>CPF</h4>
                    <input type="text" name="cpfPessoa" value="${bibliotecario.cpfPessoa}" onkeypress="$(this).mask('000.000.000-00')" />
                    
                    <input type="submit" name="alterar" class="next action-button" value="Alterar" />
                    
                    <a href="ExcluirBibliotecario?idPessoa=<%=bibliotecario.getIdPessoa()%>" class="botao">Excluir</a>
                </fieldset>    
            </section>
        </form>
        <script src="js/script-dashboard.js"></script>
    </body>
</html>

<%
    } else {
        ((HttpServletResponse) response).sendRedirect("index.jsp");
    }
%>