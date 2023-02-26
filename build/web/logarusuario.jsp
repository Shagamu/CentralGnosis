<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <link rel="stylesheet" type="text/css" href="css/login.css">

        <link href="https://fonts.googleapis.com/css?family=Poppins:600&display=swap" rel="stylesheet">

        <script src="https://kit.fontawesome.com/a81368914c.js"></script>

        <link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon">
        
        <title>Central Gnosis</title>
    </head>
    <body>
        <img class="wave" src="images/wave3.png">
        <div class="container">
            <div class="img">
                <img src="images/bg.png">
            </div>
            <div class="login-content">
                <form name="logarusuario" action="LogarUsuario" method="POST">
                    <img src="images/avatar.png">
                    <h2 class="title">Bem-vindo</h2>
                    <div class="input-div one">
                        <div class="i">
                            <i class="fas fa-user"></i>
                        </div>
                        <div class="div">
                            <h5>E-mail: </h5>
                            <input type="text" class="input" name="emailUsuario">
                        </div>
                    </div>
                    <div class="input-div pass">
                        <div class="i"> 
                            <i class="fas fa-lock"></i>
                        </div>
                        <div class="div">
                            <h5>Senha</h5>
                            <input type="password" class="input" name="senhaUsuario">
                        </div>
                    </div>
                    <a href="cadastrarusuario.jsp">Não possui conta?</a>
                    <input type="submit" class="btn" value="Login">
                </form>
            </div>
        </div>
        <script type="text/javascript" src="js/main.js"></script>
    </body>
</html>
