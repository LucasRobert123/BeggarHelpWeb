package beggarHelp.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Convert;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Donor extends User {
	String cpf;
	
	@ElementCollection
	List<Integer> listIdsInstitutionsPendente;
	
	public Donor() {
		listIdsInstitutionsPendente = new ArrayList<Integer>();
	}

	public Donor(String profilePicture, String name, String phone, String email, String password,
			String neighborhood, String street, String number, String city, String uf, String cpf) {
		super(profilePicture, name, phone, email, password, neighborhood, street, number, city, uf);
		this.cpf = cpf;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	

	public List<Integer> getListIdsInstitutionsPendente() {
		return listIdsInstitutionsPendente;
	}

	public void setListIdsInstitutionsPendente(Integer statusId) {
		this.listIdsInstitutionsPendente.add(statusId);
	}

	@Override
	public String toString() {
		return super.toString() + "Donor [cpf=" + cpf + "]";
	}

}
