<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Central Gnosis</title>
        <link rel="stylesheet" href="css/index.css">

        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.min.js" integrity="sha384-ODmDIVzN+pFdexxHEHFBQH3/9/vQ9uori45z4JjnFsRydbmQbmL5t1tQ0culUzyK" crossorigin="anonymous"></script>

        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@fortawesome/fontawesome-free@6.1.2/css/fontawesome.min.css">

        <link
            href="https://unpkg.com/boxicons@2.1.1/css/boxicons.min.css"
            rel="stylesheet"
            />

        <link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon">
    </head>
    <body>
        <section id="nav-bar">

            <nav class="navbar navbar-expand-lg navbar-light">
                <a class="navbar-brand" href="#"><img src="images/logo.png"></a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarNav">
                    <ul class="navbar-nav ml-auto">
                        <li class="nav-item">
                            <a class="nav-link" href="#top">HOME</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#services">SERVIÇOS</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#about-us">SOBRE</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#testimonials">AVALIAÇÕES</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#footer">CONTATO</a>
                        </li>
                    </ul>
                </div>
            </nav>
        </section>

        <!------banner section------->
        <section id="banner">
            <div class="container">
                <div class="row">
                    <div class="col-md-6">
                        <p class="promo-title">CENTRAL GNOSIS</p>
                        <p>Central que reúne bibliotecas e livrarias de regiões diversas com a finalidade de facilitar a acessibilidade de livros físicos</p>
                        <a href="logarusuario.jsp"><button type="button" class="btn login">Faça login</button></a>
                    </div>
                    <div class="col-md-6 text-center" class="home2">
                        <img src="images/home2.png" class="img-fluid" id="home2">
                    </div>
                </div>
            </div>
            <img src="images/wave1.png" class="bottom-img">
        </section>

        <!------Services Section------->
        <section id="services">
            <div class="container text-center">
                <h1 class="title">O QUE FAZEMOS?</h1>
                <div class="row text-center">
                    <div class="col-md-4 services">
                        <img src="images/service1.png" class="service-img">
                        <h4>Centro de conhecimento</h4>
                        <p>Área dedicada em agrupar bibliotecas e livrarias com a maior variedade de livros possíves em um lugar só</p>
                    </div>
                    <div class="col-md-4 services">
                        <img src="images/service2.png" class="service-img">
                        <h4>Gerencia online</h4>
                        <p>Sistema de gerenciamento de estoque de livros fácil, intuitivo e acessível</p>
                    </div>
                    <div class="col-md-4 services">
                        <img src="images/service3.png" class="service-img">
                        <h4>Livros próximos à você</h4>
                        <p>Sistema de busca e filtragem para buscar produtos em sua proximidade</p>
                    </div>
                </div>
                <a href="logarbibliotecario.jsp"><button type="button" class="btn btn-primary">Logar como Bibliotecário</button></a>
            </div>
        </section>

        <!------About Us------->
        <section id="about-us">
            <div class="container">
                <h1 class="title text-center">VANTAGENS DO SOFTWARE</h1>
                <div class="row">
                    <div class="col-md-6 about-us">
                        <ul>
                            <li>Site acessível e intuitivo</li>
                            <li>Filtro de busca personalizado</li>
                            <li>Contato com várias bibliotecas</li>
                            <li>Segurança e confiança na compra</li>
                            <li>Fácil comunicação entre clientes e bibliotecários</li>
                            <li>Suporte aos usuários</li>
                        </ul>
                    </div>
                    <div class="col-md-6">
                        <img src="images/network.png" class="img-fluid">
                    </div>
                </div>
            </div>
        </section>

        <!------Testimonials------->
        <section id="testimonials">
            <div class="container">
                <h1 class="title text-center">AVALIAÇÃO DOS CLIENTES</h1>
                <div class="row offset-1">
                    <div class="col-md-5 testimonials">
                        <p>Muito bom e intuitivo, adquiri vários livros. Além disso a equipe da Gnosis me ajudaram com minhas dúvidas.</p>
                        <img src="images/user1.jpg">
                        <p class="user-details"><b>Roseli</b><br> Usuário</p>
                    </div>
                    <div class="col-md-5 testimonials">
                        <p>Muito bom e intuitivo, adquiri vários livros. Além disso a equipe da Gnosis me ajudaram com minhas dúvidas.</p>
                        <img src="images/user2.jpg">
                        <p class="user-details"><b>Pedro</b><br> Usuário</p>
                    </div>
                </div>
            </div>
        </section>

        <!------Social Media section------->
        <section id="social-media">
            <div class="container text-center">
                <p>NOSSAS REDES SOCIAIS</p>
                <div class="social-icons">
                    <a href="#"><img src="images/facebook-icon.png"></a>
                    <a href="https://instagram.com/centralgnosis_ofc?igshid=YmMyMTA2M2Y=" target="_blank"><img src="images/instagram-icon.png"></a>
                    <a href="https://twitter.com/CentralGnosis" target="_blank"><img src="images/twitter-icon.png"></a>
                    <a href="#"><img src="images/whatsapp-icon.png"></a>
                    <a href="#"><img src="images/linkedin-icon.png"></a>
                    <a href="#"><img src="images/snapchat-icon.png"></a>
                </div>
            </div>
        </section>

        <!------footer section------->
        <section id="footer">
            <img src="images/wave2.png" class="footer-img">
            <div class="container">
                <div class="row">
                    <div class="col-md-4 footer-box">
                        <img src="images/logo.png" class="footer-img2">
                        <p>Aqui você encontra livros de todos os gêneros e localidades, com um sistema de organização único.</p>
                    </div>
                    <div class="col-md-4 footer-box">
                        <p><b>CONTATE-NOS</b></p>
                        <p><i class="bx bx-user icon"></i>centralgnosis@gmail.com</p>
                        <p><i class="bx bx-user icon"></i>(17) 99834-3643</p>
                    </div>
                    <div class="col-md-4 footer-box">
                        <p><b>ASSINE</b></p>
                        <input type="email" class="form-control" placeholder="Seu E-mail">
                        <button type="button" class="btn btn-primary">Enviar</button>
                    </div>
                </div>
            </div>
        </section>

        <!------Smooth Scroll------->
        <script src="script/smooth-scroll.js"></script>
        <script>
            var scroll = new SmoothScroll('a[href*="#"]');
        </script>
    </body>
</html>
