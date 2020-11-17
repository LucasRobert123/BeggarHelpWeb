<%@page import="com.google.gson.Gson"%>
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

<%
	String profile="";
    Donor user;
    String json = "";
    try{
    
	    user = (Donor) session.getAttribute("user");
	    profile = user.getProfilePicture();
	    json = new Gson().toJson(user.getListIdsInstitutionsPendente());
    }
    catch(Exception e){
    	response.sendRedirect("index.jsp");
    }
%>
</head>
<script src="./scripts/load.js">
  
</script>
<body onload="loadUfs(<%=json%>)">
	
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

				<select name="" 
				        id="ufs"
				        onchange="setSelectCidades(this.value)"
				>
					<option value="" hidden selected>UF</option>
				</select> 
				<select name="" id="cities">
					<option value="" hidden selected>Cidade</option>
				</select>

				<button class="search" onclick="filterInstitutions()">
					<img src="./assets/search.svg" alt="">
				</button>
			</div>

		</header>
		<main id="list-institutions">

			<%--Lista --%>
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


<script type="text/javascript" src="./scripts/mainscript.js">
	
</script>

</html>