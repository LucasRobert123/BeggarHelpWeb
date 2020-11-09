<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./css/sign_up.css">
    <title>Cadastro</title>
</head>

<body>
    <div class="container-sign-up">
        <div class="form-cad">
            <h1>Cadastre-se</h1>
            <form action="">
                <div class="upload-img">
                    <img src="./assets/camera.svg" alt="camera">
                    <p>Selecione sua foto de perfil</p>
                </div>
                <div class="group-input">
                    <input type="text" placeholder="Nome">
                    <input type="tel" placeholder="Telefone">
                </div>

                <input type="email" placeholder="E-mail">

                <div class="group-input">
                    <input type="password" placeholder="Senha">
                    <input type="text" placeholder="Bairro">
                </div>

                <div class="group-input">
                    <input type="text" placeholder="Rua">
                    <input type="tel" placeholder="Número">
                </div>

                <div class="group-input">
                    <input type="text" placeholder="Cidade">
                    <input type="text" placeholder="Uf">
                </div>

                <select name="" id="">
                    <option value="" hidden selected>Tipo de usuário</option>
                    <option value="">Instituicão</option>
                    <option value="">Doador</option>
                </select>

                <input type="text" placeholder="CNPJ" style="width: 99%;">
                
                <textarea rows="4" cols="50" placeholder="Descricão"></textarea>
            
                <div class="group-btns">
                    <button>VOLTAR</button>
                    <button>SALVAR</button>
                </div>
               
            </form>
        </div>
        <div class="txt-img">
           <p>Registre-se e ajude o próximo</p>
           <img src="./assets/sign_up.svg" alt="sign_up">
        </div>
    </div>
</body>

</html>