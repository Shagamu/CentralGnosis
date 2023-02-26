<%@page import="br.com.projetobiblioteca.model.Usuario"%>
<%@page import="br.com.projetobiblioteca.model.Genero"%>
<%@page import="java.util.List"%>
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
        <section id="wallet-content" class="page-content">
            <fieldset>
                <h4>Título</h4>
                <input type="text" name="tituloLivro" value="${livro.tituloLivro}" readonly/>
                <h4>Autor</h4>
                <input type="text" name="autorLivro" value="${livro.autorLivro}" readonly/>
                <h4>Editora</h4>
                <input type="text" name="editoraLivro" value="${livro.editoraLivro}" readonly/>
                <h4>Ano de Publicação</h4>
                <input type="text" name="anoLivro" value="${livro.anoLivro}" readonly/>
                <h4>ISBN</h4>
                <input type="text" name="isbnLivro" value="${livro.isbnLivro}" readonly/>
                <h4>Valor</h4>
                <input type="text"  name="valorLivro" value="${livro.valorLivro}" readonly/>
                <h4>Estoque</h4>
                <input type="text" name="quantidadeLivro" value="${livro.quantidadeLivro}" readonly/>
                <h4>Gêneros</h4>
                <table>
                    <%
                        List<Genero> generos = (List<Genero>) request.getAttribute("generos");
                        for (Genero genero : generos) {
                    %>
                    <tr>
                        <td><%=genero.getNomeGenero()%></td>
                    </tr>

                    <%
                        }
                    %>
                </table>
                <form name="cadastrarcompra" action="CadastrarCompra" method="POST">
                    <div class="none">
                        ID: <input type="text" name="idLivro" value="${livro.idLivro}" readonly>
                    </div>
                    <div class="none">
                        ID: <input type="text" name="idUsuario" value="${usuario.idUsuario}" readonly>
                    </div>
                    <div class="none">
                        Quantidade: <input type="text" name="quantidadeLivro" value="${livro.quantidadeLivro}" readonly>
                    </div>
                    <h4>Quantidade</h4>
                    <input type="number" name="quantidadeCompra" />
                    <div class="none">
                        Valor: <input type="text" name="valorLivro" value="${livro.valorLivro}" readonly>
                    </div>
                    <input type="submit" name="cadastrar" class="next action-button" value="Comprar" />
                </form>
                <form name="carregarbibliotecausuario" action="CarregarBibliotecaUsuario" method="POST">
                    <div class="none">
                        Valor: <input type="text" name="idBiblioteca" value="${livro.idBiblioteca.idBiblioteca}" readonly>
                    </div>
                    <input type="submit" name="cadastrar" class="next action-button" value="Biblioteca" />
                </form>
            </fieldset>    
        </section>
    </body>
</html>
<%
    } else {
        ((HttpServletResponse) response).sendRedirect("index.jsp");
    }
%>