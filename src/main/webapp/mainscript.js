
function showListOptions() {
	document.querySelector(".list-options").style.display = "block"
}

function setDisplayNone() {
	document.querySelector(".list-options").style.display = "none"
}

async function showModal(id, servelet){

	const{name, email, phone, street, number, neighborhood} = await getData(id, servelet);

	const address = street + ", " + number + ", " + neighborhood;
	
	document.querySelector(".modal-overlay").style.display = "flex"
	document.getElementById("name").innerHTML = name; 
	document.getElementById("phone").innerHTML = phone; 
	document.getElementById("email").innerHTML = email; 
	document.getElementById("point").innerHTML = address;
	
}

async function getData(id, servelet){
	return fetch(`http://localhost:8081/BeggarHelpWeb/${servelet}?id=${id}`)
	.then(response =>{
		return response.json()
		
	})
	.then(response =>{
		return response
	})
}

function setVisible(){
    document.querySelector(".modal-overlay").style.display = "none"
}





