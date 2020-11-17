package beggarHelp.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

@Entity
public class Institution extends User {

	String cnpj, description;

	@ManyToMany
	@JoinTable(name = "institution_donor", joinColumns = { @JoinColumn(name = "Institution_id") }, inverseJoinColumns = {
			@JoinColumn(name = "doadores_id") })
	List<Donor> doadores;

	public Institution() {
		doadores = new ArrayList<Donor>();
	}

	public Institution(String profilePicture, String name, String phone, String email, String password,
			String neighborhood, String street, String number, String city, String uf, String cnpj, String description,
			String status) {
		super(profilePicture, name, phone, email, password, neighborhood, street, number, city, uf);
		this.cnpj = cnpj;
		this.description = description;

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

	public void setDoador(Donor doador) {
		this.doadores.add(doador);
	}

	@Override
	public String toString() {
		return super.toString() + "Institution [cnpj=" + cnpj + ", \ndescription=" + description + "]";
	}

}
