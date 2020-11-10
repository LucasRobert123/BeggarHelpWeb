<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/login.css">
    <title>Login</title>
</head>
<body>
    <div class="container-login">
        <div class="body-img">
          <img src="./assets/authentication.svg" alt="auth">
        </div>
        <div class="body-form">
            <form action="signin" method="get">
                <h1>Fazer login</h1>
                
                <select name="user">
					<option value="" hidden selected>Tipo de usuário</option>
					<option value="institution">Instituicão</option>
					<option value="donor">Doador</option>
				</select> 
                <input placeholder="Email" type="email" name="email"/>
                <input placeholder="Senha" type="password" name="password"/>

                 <div class="group-checkbox">
                    <input type="checkbox" id="check" hidden/>
                    <label for="check" class="checkmark"></label>
                    <p>Lembrar-me</p>
                </div>
                
                <button type="submit">Entrar</button>
            </form>

            <footer>
                <p>Não tenho conta?</p>
                <a href="./sign_up.jsp">Cadastre-se</a>
            </footer>
        </div>
    </div>
</body>
</html>