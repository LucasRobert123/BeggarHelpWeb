package beggarHelp.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;


@Entity
public class Institution extends User {

String cnpj,description;
	
	@OneToMany
	List<Donor> doadores;
	
	public Institution() {}

	public Institution(int id, String profilePicture, String name, String phone, String email, String password,
			String neighborhood, String street, String number, String city, String uf, String cnpj, String description,
			List<Donor> doadores) {
		super(id, profilePicture, name, phone, email, password, neighborhood, street, number, city, uf);
		this.cnpj = cnpj;
		this.description = description;
		this.doadores = doadores;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Donor> getDoadores() {
		return doadores;
	}

	public void setDoadores(List<Donor> doadores) {
		 this.doadores = doadores;
	}

	@Override
	public String toString() {
		return super.toString() + "Institution [cnpj=" + cnpj + ", \ndescription=" + description + 
				                ", doadores=" + doadores + "]";
	}

	
	
}
