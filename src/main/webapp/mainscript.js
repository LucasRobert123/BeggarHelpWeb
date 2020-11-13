
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
	return fetch(`http://localhost:8081/BeggarHelpWeb/${servelet}?id=${id}`)
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





