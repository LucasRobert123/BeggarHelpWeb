<%@page import="beggarHelp.model.Donor"%>
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
	    String profile= "";
	    List<Institution> list = new ArrayList<Institution>();
	    try{
	    
			Donor user = (Donor) session.getAttribute("user");
		    profile = user.getProfilePicture();
		    
		    InstitutionDao iDao = new InstitutionDao();
		    list.addAll(iDao.getAll());
	    }
	    catch(Exception e){
	    	response.sendRedirect("index.jsp");
	    }
	%>
	<div class="container-dashboard-doador">
		<header>
			<h1>Estas são as instituições que você pode ajudar</h1>
			<div class="user" onmouseover="showListOptions()">
				<p>usuario.@gmail.com</p>
				<img class="profile"
					src="http://localhost:8081/BeggarHelpWeb/images/<%=profile%>" alt="profile">
				<div class="list-options" onmouseout="setDisplayNone()">
					<div class="item">
						<img src="./assets/power.svg" alt="power"> <a
							href="exit.jsp">Sair</a>
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
			<form action="donor?id=<%=institution.getId()%>" method="post">

				<div class="card-user">
					<header>
						<div class="avatar">
							<img
								src="http://localhost:8081/BeggarHelpWeb/images/<%=institution.getProfilePicture()%>"
								alt="profile">
							<p><%=institution.getName()%></p>
						</div>
						<div class="icon-plus">
							<img src="./assets/plus.svg" alt="plus" onclick="showModal(<%=institution.getId()%>, 'donor')">
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
		
		<div class="modal-overlay">
            <div class="modal">
                <h1>Mais dados</h1>

                 <button id="close" onclick="setVisible()">
				   <img src="./assets/close.svg" alt="close"/>
				</button>
                <div class="items-content">
                    <img src="./assets/institution.svg" alt="person" />
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
<script src="./mainscript.js">
	
</script>
</html>