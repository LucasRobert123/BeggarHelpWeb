<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="./css/institution.css">
<title>Dashboard</title>
</head>

<body>
	<div class="container-dashboard-institution">
		<header id="header">
			<h1>Estes são os interessados em doar a sua instituição</h1>
			<div class="user" onmouseover="showListOptions()">
				<p>usuario.@gmail.com</p>
				<div class="profile"></div>
				<div class="list-options" onmouseout="setDisplayNone()">
					<div class="item">
						<img src="./assets/power.svg" alt="power">
						<p>Sair</p>
					</div>
				</div>
			</div>
		</header>
		<main>
			<div class="card-user">
				<header>
					<div class="avatar">
						<div></div>
						<p>Lucas</p>
					</div>
					<div class="icon-plus">
						<img src="./assets/plus.svg" alt="plus">
					</div>
				</header>
				<div class="content">
					<img src="./assets/location.svg" alt="">
					<p>Rua José Augusto,174, São Benedito</p>
				</div>
				<div class="btn-whatsapp">
					<button>
						<img src="./assets/whatsapp.svg" alt="whatsapp"> Entrar em
						contato
					</button>
				</div>

			</div>

			<div class="card-user">
				<header>
					<div class="avatar">
						<div></div>
						<p>Lucas</p>
					</div>
					<div class="icon-plus">
						<img src="./assets/plus.svg" alt="plus">
					</div>
				</header>
				<div class="content">
					<img src="./assets/location.svg" alt="">
					<p>Rua José Augusto,174, São Benedito</p>
				</div>
				<div class="btn-whatsapp">
					<button>
						<img src="./assets/whatsapp.svg" alt="whatsapp"> Entrar em
						contato
					</button>
				</div>

			</div>


			<div class="card-user">
				<header>
					<div class="avatar">
						<div></div>
						<p>Lucas</p>
					</div>
					<div class="icon-plus">
						<img src="./assets/plus.svg" alt="plus">
					</div>
				</header>
				<div class="content">
					<img src="./assets/location.svg" alt="">
					<p>Rua José Augusto,174, São Benedito</p>
				</div>
				<div class="btn-whatsapp">
					<button>
						<img src="./assets/whatsapp.svg" alt="whatsapp"> Entrar em
						contato
					</button>
				</div>

			</div>

			<div class="card-user">
				<header>
					<div class="avatar">
						<div></div>
						<p>Lucas</p>
					</div>
					<div class="icon-plus">
						<img src="./assets/plus.svg" alt="plus">
					</div>
				</header>
				<div class="content">
					<img src="./assets/location.svg" alt="">
					<p>Rua José Augusto,174, São Benedito</p>
				</div>
				<div class="btn-whatsapp">
					<button>
						<img src="./assets/whatsapp.svg" alt="whatsapp"> Entrar em
						contato
					</button>
				</div>

			</div>
		</main>
	</div>
</body>
<script>
	function showListOptions() {
		document.querySelector(".list-options").style.display = "block"
	}
	function setDisplayNone() {
		document.querySelector(".list-options").style.display = "none"
	}
</script>
</html>