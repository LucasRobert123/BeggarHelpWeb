
async function loadUfs(id) {
   
	fetch("https://servicodados.ibge.gov.br/api/v1/localidades/estados")
		.then(response => {
			return response.json()
		})
		.then(response => {
			let ufs = response.map(uf => uf.sigla)
			setSelect(ufs.sort());
			setList(id)
		})
}


function setSelect(ufs) {
	ufs.map(uf => {
		var x = document.getElementById("ufs");
		var option = document.createElement("option");
		option.text = uf;
		x.add(option);
	})
}


async function setList(id) {

	fetch(`http://localhost:8081/BeggarHelpWeb/donor?list=true`)
		.then(response => {
			return response.json()
		})
		.then(response => {
		   console.log(response)
		   setCards(response,id)
		})

}


function setCards(cards, id) {
	cards.map(card => {
	    let doadores = card.doadores.map(r => r.id);
	    
	    console.log(doadores)
	    if(!doadores.includes(id)){
			document.querySelector("#list-institutions").innerHTML +=
				`
				<form action="donor?id=${card.id}" method="post">
			        <div class="card-user" disabled>
						<header>
							<div class="avatar">
								<img src=http://localhost:8081/BeggarHelpWeb/images/${card.profilePicture} alt="profile">
								<p>${card.name}</p>
							</div>
							<div class="icon-plus" disabled>
								<img src="./assets/plus.svg" alt="plus" onclick="showModal(${card.id}, 'donor')">
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
	     }})


}


function setSelectCidades(uf){
   console.log(uf)
   clearSelect()
   fetch(`https://servicodados.ibge.gov.br/api/v1/localidades/estados/${uf}/municipios`)
		.then(response => {
			return response.json()

		})
		.then(response => {
			let cities = response.map(city => city.nome)
			
			setCities(cities);
			
		})
}

function setCities(cities){
   cities.map(city => {
	   let x = document.getElementById("cities");
	   let option = document.createElement("option");
	   option.text = city;
	   x.add(option);
	})
}






