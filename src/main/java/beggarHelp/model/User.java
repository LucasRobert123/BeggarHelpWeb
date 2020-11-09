package beggarHelp.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class User {
	@Id
	int id;
	String profilePicture,name, phone, email,password, neighborhood, street, number,city,uf;
	
	public User() {}
	
	
    public User(int id, String profilePicture, String name, String phone, String email, String password,
			String neighborhood, String street, String number, String city, String uf) {
		super();
		this.id = id;
		this.profilePicture = profilePicture;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.password = password;
		this.neighborhood = neighborhood;
		this.street = street;
		this.number = number;
		this.city = city;
		this.uf = uf;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProfilePicture() {
		return profilePicture;
	}

	public void setProfilePicture(String profilePicture) {
		this.profilePicture = profilePicture;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}


	public String toString() {
		return "User [profilePicture=" + profilePicture + ", name=" + name + ", phone=" + phone + ", \nemail=" + email
				+ ", password=" + password + ", neighborhood=" + neighborhood + ", \nstreet=" + street + ", number="
				+ number + ", city=" + city + ", \nuf=" + uf + "]";
	}
	
	
	
}
