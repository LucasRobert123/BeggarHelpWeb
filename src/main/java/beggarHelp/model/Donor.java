package beggarHelp.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Donor extends User {
	String cpf;

	public Donor() {
		
	}

	public Donor(String profilePicture, String name, String phone, String email, String password,
			String neighborhood, String street, String number, String city, String uf, String cpf, String status) {
		super(profilePicture, name, phone, email, password, neighborhood, street, number, city, uf, status);
		this.cpf = cpf;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@Override
	public String toString() {
		return super.toString() + "Donor [cpf=" + cpf + "]";
	}

}
