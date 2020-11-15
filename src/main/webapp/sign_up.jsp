<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="pt-br">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="css/sign_up.css">
<title>Cadastro</title>
<script type="text/javascript" src="./scripts/load.js">
  
  
</script>
</head>

<body>
	<div class="container-sign-up">
		<div class="form-cad">
			<h1>Cadastre-se</h1>
			<form action="signup" method="post" enctype="multipart/form-data">
				 <label class="upload-img" for="file">
                    <img id="preview" src="./assets/camera.svg" alt="camera">
                    <p id="text-select">Selecione sua foto de perfil</p>
                    <input type="file" 
                           id="file" 
                           name="file"
                           accept="image/*"
                           onchange="previewImage(this.files)"
                           hidden
                    /> 
                </label>
				<div class="group-input">
					<input type="text" placeholder="Nome" name="name" autocomplete="off"> 
					<input type="tel" placeholder="Telefone" name="phone">
				</div>

                
				<input type="email" placeholder="E-mail" name="email">
				   
			   
				<div class="group-input">
					<input type="password" placeholder="Senha" name="password">
					<input type="text" placeholder="Bairro" name="neighborhood">
				</div>

				<div class="group-input">
					<input type="text" placeholder="Rua" name="street"> 
					<input type="tel" placeholder="Número" name="number">
				</div>

				<div class="group-input">
					<select name="uf" id="ufs" onchange="setSelectCidades(this.value)")>
					   <option value="" hidden selected>UF</option>
				    </select> 
					<select name="city" id="cities">
						<option value="" hidden selected>Cidade</option>
					</select>
				</div>

				<select name="user" id="selectUser" onchange="showDataComplement()">
					<option value="" hidden selected>Tipo de usuário</option>
					<option value="institution">Instituicão</option>
					<option value="donor">Doador</option>
				</select> 
				
				<input id="cpf" type="text" placeholder="Cpf" name="cpf">
				
				<input id="cnpj" type="text" placeholder="CNPJ" style="width: 99%;" name="cnpj">

				<textarea id="description" rows="4" cols="50"
				placeholder="Descricão" name="description"></textarea>

				<div class="group-btns">
					<a href="index.jsp">VOLTAR</a>
					<button type="submit">SALVAR</button>
				</div>

			</form>
		</div>
		<div class="txt-img">
			<p>Registre-se e ajude o próximo</p>
			<img src="./assets/sign_up.svg" alt="sign_up">
		</div>
	</div>
</body>

<script type="text/javascript" src="./scripts/mainscript.js">
	
</script>

</html>