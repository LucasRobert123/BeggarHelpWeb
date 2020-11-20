
function showListOptions() {
	document.querySelector(".list-options").style.display = "block"
}

function setDisplayNone() {
	document.querySelector(".list-options").style.display = "none"
}

async function showModal(id, servelet) {
	const { name, email, phone, street, number, neighborhood } = await getData(id, servelet);
   
	const address = street + ", " + number + ", " + neighborhood;

	document.querySelector(".modal-overlay").style.display = "flex"
	document.getElementById("name").innerHTML = name;
	document.getElementById("phone").innerHTML = phone;
	document.getElementById("email").innerHTML = email;
	document.getElementById("point").innerHTML = address;

}

async function getData(id, servelet) {
	return fetch(`http://localhost:8081/BeggarHelpWeb/${servelet}?id=${id}&details=true`)
		.then(response => {
			return response.json()

		})
		.then(response => {
			return response
		})
}

function setVisible() {
	document.querySelector(".modal-overlay").style.display = "none"
}

function previewImage(val) {
	let url = URL.createObjectURL(val[0]);
	
	document.querySelector("#text-select").style.display = "none"
	document.querySelector("#preview").style.objectFit = "cover";
	document.querySelector("#preview").style.width = "100%"
	document.querySelector("#preview").style.height = "100%"
	document.querySelector("#preview").style.borderRadius = "7px"
	document.querySelector("#preview").style.borderRadius = "7px"
	document.querySelector("#preview").src = url
	
}

function showDataComplement() {
		let value = document.querySelector("#selectUser").value;

		if (value == "institution") {
			document.querySelector("#cnpj").style.display = "block"
			document.querySelector("#description").style.display = "block"
			document.querySelector("#cpf").style.display = "none"
			document.querySelector("#cpf").value = ""
		} else {
			document.querySelector("#cnpj").style.display = "none"
			document.querySelector("#description").style.display = "none"
			document.querySelector("#cnpj").value = ""
			document.querySelector("#description").value = ""
		    document.querySelector("#cpf").style.display = "block"
		}
}


function clearSelect(){
	let select = document.getElementById("cities");
	let length = select.options.length;
	for (i = length-1; i >= 0; i--) {
	  select.options[i] = null;
	}
}

function filterInstitutions(){
   
   let uf = document.getElementById("ufs").value;
   let city = document.getElementById("cities").value;
  
   fetch(`http://localhost:8081/BeggarHelpWeb/donor?uf=${uf}&city=${city}`)
   .then(response =>{
      return response.json()
   })
   .then(response =>{
      let institution = response;
      setCard(institution);
   })
}

function setCard(cards) {
    document.querySelector("#list-institutions").innerHTML = "";
	cards.map(card => {
		document.querySelector("#list-institutions").innerHTML +=
			`
			<form action="donor?id=${card.id}" method="post">
		        <div class="card-user">
					<header>
						<div class="avatar">
							<img src=http://localhost:8081/BeggarHelpWeb/images/${card.profilePicture} alt="profile">
							<p>${card.name}</p>
						</div>
						<div class="icon-plus">
							<img src="./assets/plus.svg" alt="plus" onclick=showModal(${card.id}, 'donor')>
						</div>
					</header>
					<div class="content">
						<p>${card.description}</p>
					</div>
					<div class="btn">
						<button type="submit">Quero doar</button>
					</div>
		
				</div>
		</form>
     `

	})


}



async function deleteDonor(id, userId){
  
   await fetch(`http://localhost:8081/BeggarHelpWeb/institution?id=${id.toString()}&delete=true&idInst=${userId.toString()}`)
	.then(response => {
		return response.json()

	})
	.then(response => {
	    console.log(response)
	    document.getElementById("list-donors").innerHTML = "";
		if(response.length > 0){
		  setCardsDonor(response, userId)
		}
		
	})
}

function showModalConfirmDelete(cardId,userId){
    document.querySelector("#visible").style.display = "flex";
    
   document.getElementById("not").addEventListener("click", function() {
       document.querySelector("#visible").style.display = "none";
   });
   
   document.getElementById("yes").addEventListener("click", async function() {
       await deleteDonor(cardId,userId);
       document.querySelector("#visible").style.display = "none";
   });
}

function setCardsDonor(cards, userId) {
   
	cards.map(card => {
		document.querySelector("#list-donors").innerHTML +=
			`
			<div class="card-user">
				<header>
					<div class="avatar">
						<img
							src="http://localhost:8081/BeggarHelpWeb/images/${card.profilePicture}"
							alt="profile">
						<p>${card.name}</p>
					</div>
					<div class="icon-plus">
						<button onclick="showModalConfirmDelete(${card.id},${userId})" 
						>
						   <img src="./assets/delete.svg" alt="delete">
						</button> 
						<img src="./assets/plus.svg" alt="plus" onclick="showModal(${card.id}, 'institution')">
					</div>
				</header>
				<div class="content">
					<img src="./assets/location.svg" alt="">
					<p>${card.street},
						${card.number},
						${card.neighborhood}</p>
				</div>
				<div class="btn-whatsapp">
					<button>
						<img src="./assets/whatsapp.svg" alt="whatsapp"> 
						<a href="https://wa.me/55${card.phone}" target="_blank">Entrar em contato</a>
					</button>
				</div>

			</div>
     `

	})


}

function loadList(id){
    fetch(`http://localhost:8081/BeggarHelpWeb/institution?id=${id}&listDonors=true`)
	.then(response => {
		return response.json()

	})
	.then(response => {
		setCardsDonor(response, id)
	})
}









