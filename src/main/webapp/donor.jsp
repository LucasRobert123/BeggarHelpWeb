<%@page import="beggarHelp.dao.InstitutionDao"%>
<%@page import="beggarHelp.model.Institution"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="css/donor.css">
<title>Dashboard</title>
</head>

<body>
	<%	
		List<Institution> list = new ArrayList<Institution>();
	    InstitutionDao iDao = new InstitutionDao();

	    list.addAll(iDao.getAll());
	%>
	<div class="container-dashboard-doador">
		<header>
			<h1>Estas são as instituições que você pode ajudar</h1>
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

			<div class="group-selects">

				<select name="" id="">
					<option value="" hidden selected>UF</option>
					<option value="">MG</option>
					<option value="">SP</option>
				</select> <select name="" id="">
					<option value="" hidden selected>Cidade</option>
					<option value="">Campos Gerais</option>
					<option value="">Alfenas</option>
				</select>

				<button class="search">
					<img src="./assets/search.svg" alt="">
				</button>
			</div>

		</header>
		<main>

			<%
				for (Institution institution : list) {
			%>
			<form action="donor?id=<%=institution.getId() %>" method="post">
			    
				<div class="card-user">
					<header>
						<div class="avatar">
							<div></div>
							<p><%=institution.getName()%></p>
						</div>
						<div class="icon-plus">
							<img src="./assets/plus.svg" alt="plus">
						</div>
					</header>
					<div class="content">
						<p><%=institution.getDescription()%></p>
					</div>
					<div class="btn">
						<button type="submit">Quero doar</button>
					</div>

				</div>
			</form>

			<%
				}
			%>

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