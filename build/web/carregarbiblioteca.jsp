<%@page import="br.com.projetobiblioteca.model.Bibliotecario"%>
<%
    HttpServletRequest httpServletRequest = (HttpServletRequest) request;

    HttpSession sessao = httpServletRequest.getSession();

    if (sessao.getAttribute("bibliotecario") != null) {
        Bibliotecario bibliotecario = (Bibliotecario) sessao.getAttribute("bibliotecario");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />

        <!----======== CSS ======== -->
        <link rel="stylesheet" href="css/dashboard/style-dashboard.css" />
        <link rel="stylesheet" href="css/dashboard/biblioteca.css" />
        <link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon" />

        <script src="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"></script>
        <script src="https://kit.fontawesome.com/a81368914c.js"></script>
        <script src="http://igorescobar.github.io/jQuery-Mask-Plugin/"></script>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>

        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.15/jquery.mask.min.js"></script>
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

        <section id="notis-content" class="page-content">
            <div class="login-container">
                <form name="alterarbiblioteca" action="AlterarBiblioteca" class="form-login" method="POST">
                    <ul class="login-nav">
                        <li class="login-nav__item active">
                            <a href="#">Biblioteca</a>
                        </li>
                    </ul>
                    <div class="">
                        <input id="login-input-user" class="none" type="text" name="idBiblioteca" value="${bibliotecario.idBiblioteca.idBiblioteca}" required/>
                        <label for="login-input-user" class="login__label">
                            Nome
                        </label>
                        <input id="login-input-user" class="login__input" type="text" name="nomeBiblioteca" value="${biblioteca.nomeBiblioteca}" required/>
                        <label for="login-input-password" class="login__label">
                            Estado
                        </label>
                        <input id="login-input-password" class="login__input" type="text" name="estadoBiblioteca" value="${biblioteca.estadoBiblioteca}" required/>
                        <label for="login-input-user" class="login__label">
                            Cidade
                        </label>
                        <input id="login-input-user" class="login__input" type="text" name="cidadeBiblioteca" value="${biblioteca.cidadeBiblioteca}" required/>
                        <label for="login-input-password" class="login__label">
                            Bairro
                        </label>
                        <input id="login-input-password" class="login__input" type="text" name="bairroBiblioteca" value="${biblioteca.bairroBiblioteca}" required/>
                        <label for="login-input-user" class="login__label">
                            Rua
                        </label>
                        <input id="login-input-user" class="login__input" type="text" name="ruaBiblioteca" value="${biblioteca.ruaBiblioteca}" required/>
                        <label for="login-input-password" class="login__label">
                            Número
                        </label>
                        <input id="login-input-password" class="login__input" type="text" name="numeroBiblioteca" value="${biblioteca.numeroBiblioteca}" required/>
                        <label for="login-input-user" class="login__label">
                            CEP
                        </label>
                        <input id="login-input-user" class="login__input" type="text" onkeypress="$(this).mask('00.000-000')" name="cepBiblioteca" value="${biblioteca.cepBiblioteca}"required/>
                        <label for="login-input-password" class="login__label">
                            Telefone
                        </label>
                        <input id="login-input-password" class="login__input" type="text" onkeypress="$(this).mask('(00) 0000-00009')" name="telefoneBiblioteca" value="${biblioteca.telefoneBiblioteca}" required/>
                        <label for="login-input-password" class="login__label">
                            E-mail
                        </label>
                        <input id="login-input-password" class="login__input" type="text" name="emailBiblioteca" value="${biblioteca.emailBiblioteca}"/>
                        <input type="submit" name="alterar" class="login__submit" value="Alterar">
                        </form>
                    </div>
                    </section>

                    <script src="js/script-dashboard.js"></script>

                    </body>
                    </html>
                    <%
                        } else {
                            ((HttpServletResponse) response).sendRedirect("index.jsp");
                        }
                    %>