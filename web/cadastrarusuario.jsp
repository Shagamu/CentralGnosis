<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <link rel="stylesheet" href="css/cadastro.css">

        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>

        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.15/jquery.mask.min.js"></script>

        <link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon">

        <title>Central Gnosis</title>
    </head>
    <body>
        <div class="container">
            <div class="title" style="text-align: center;">Cadastro de Usuário</div>
            <div class="content">
                <form name="cadastrarusuario" action="CadastrarUsuario" method="POST">
                    <div class="user-details">
                        <div class="input-box">
                            <span class="details">Nome Completo</span>
                            <input type="text" placeholder="Digite seu nome" name="nomeUsuario" required>
                        </div>
                        <div class="input-box">
                            <span class="details">CPF</span>
                            <input type="text" placeholder="Digite seu CPF" name="cpfUsuario" onkeypress="$(this).mask('000.000.000-00')" required>
                        </div>
                        <div class="input-box">
                            <span class="details">Telefone</span>
                            <input type="text" placeholder="Digite seu telefone" name="telefoneUsuario" onkeypress="$(this).mask('(00) 0000-00009')" required>
                        </div>
                        <div class="input-box">
                            <span class="details">Estado</span>
                            <input type="text" placeholder="Digite sua cidade" name="estadoUsuario" required>
                        </div>
                        <div class="input-box">
                            <span class="details">Cidade</span>
                            <input type="text" placeholder="Digite sua cidade" name="cidadeUsuario" required>
                        </div>
                        <div class="input-box">
                            <span class="details">Bairro</span>
                            <input type="text" placeholder="Digite seu bairro" name="bairroUsuario" required>
                        </div>
                        <div class="input-box">
                            <span class="details">Rua</span>
                            <input type="text" placeholder="Digite sua rua" name="ruaUsuario" required>
                        </div>
                        <div class="input-box">
                            <span class="details">Número</span>
                            <input type="text" placeholder="Digite o número de sua casa" name="numeroUsuario" required>
                        </div>
                        <div class="input-box">
                            <span class="details">CEP</span>
                            <input type="text" placeholder="Digite seu CEP" class="form-control" onkeypress="$(this).mask('00.000-000')" name="cepUsuario" required>
                        </div>
                        <div class="input-box">
                            <span class="details">Email</span>
                            <input type="email" placeholder="Digite seu email" name="emailUsuario" required>
                        </div>
                        <div class="input-box">
                            <span class="details">Senha</span>
                            <input type="password" placeholder="Digite sua senha" name="senhaUsuario" required>
                        </div>
                    </div>
                    <div class="button">
                        <input type="submit" name="cadastrar" value="Cadastrar">
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>
