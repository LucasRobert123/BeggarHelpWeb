<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./css/login.css">
    <title>Login</title>
</head>
<body>
    <div class="container-login">
        <div class="body-img">
          <img src="./assets/authentication.svg" alt="auth">
        </div>
        <div class="body-form">
            <form action="">
                <h1>Fazer login</h1>
                <input placeholder="Email" type="email" value=""/>
                <input placeholder="Senha" type="password" value=""/>

                <div>
                    <input type="checkbox" id="check" hidden/>
                    <label for="check" class="checkmark"></label>
                    <p>Lembrar-me</p>
                </div>
                
                <button>Entrar</button>
            </form>

            <footer>
                <p>Não tenho conta?</p>
                <a href="../Cadastro/index.html">Cadastre-se</a>
            </footer>
        </div>
    </div>
</body>
</html>