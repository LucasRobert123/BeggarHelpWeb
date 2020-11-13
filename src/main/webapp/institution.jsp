<%@page import="java.util.ArrayList"%>
<%@page import="beggarHelp.model.Donor"%>
<%@page import="java.util.List"%>
<%@page import="beggarHelp.model.Institution"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="css/institution.css">
<title>Dashboard</title>
</head>

<body>
	<%
		List<Donor> donors = new ArrayList<Donor>();
	String profile = "";

	try {
		Institution user = (Institution) session.getAttribute("user");

		profile = user.getProfilePicture();

		donors.addAll(user.getDoadores());

	} catch (Exception e) {
		response.sendRedirect("index.jsp");
	}
	%>
	<div class="container-dashboard-institution">
		<header id="header">
			<h1>Estes são os interessados em doar a sua instituição</h1>
			<div class="user" onmouseover="showListOptions()">
				<p>usuario.@gmail.com</p>
				<img class="profile"
					src="http://localhost:8081/BeggarHelpWeb/images/<%=profile%>"
					alt="profile">
				<div class="list-options" onmouseout="setDisplayNone()">
					<div class="item">
						<img src="./assets/power.svg" alt="power"> <a
							href="exit.jsp">Sair</a>
					</div>
				</div>
			</div>
		</header>
		<main>
			<%
				for (Donor d : donors) {
			%>
			<div class="card-user">
				<header>
					<div class="avatar">
						<img
							src="http://localhost:8081/BeggarHelpWeb/images/<%=d.getProfilePicture()%>"
							alt="profile">
						<p><%=d.getName()%></p>
					</div>
					<div class="icon-plus">
						<a href="institution?id=<%=d.getId()%>&delete=true"> <img
							src="./assets/delete.svg" alt="delete">
						</a> <img src="./assets/plus.svg" alt="plus"
							onclick="showModal(<%=d.getId()%>, 'institution')">
					</div>
				</header>
				<div class="content">
					<img src="./assets/location.svg" alt="">
					<p><%=d.getStreet()%>,
						<%=d.getNumber()%>,
						<%=d.getNeighborhood()%></p>
				</div>
				<div class="btn-whatsapp">
					<button>
						<img src="./assets/whatsapp.svg" alt="whatsapp"> <a href="">Entrar
							em contato</a>
					</button>
				</div>

			</div>
			<%
				}
			%>
		</main>

		<div class="modal-overlay">
			<div class="modal">
			    
				<h1>Mais dados</h1>
				<button id="close" onclick="setVisible()">
				   <img src="./assets/close.svg" alt="close"/>
				</button>
               
				<div class="items-content">
					<img src="./assets/person.svg" alt="person" />
					<p id="name"></p>
				</div>

				<div class="items-content">
					<img src="./assets/phone.svg" alt="phone" />
					<p id="phone"></p>
				</div>

				<div class="items-content">
					<img src="./assets/email.svg" alt="email" />
					<p id="email"></p>
				</div>

				<div class="items-content">
					<img src="./assets/point.svg" alt="point" />
					<p id="point"></p>
				</div>
			</div>
		</div>

	</div>
</body>
<script type="text/javascript" src="./mainscript.js">
	
</script>
</html>