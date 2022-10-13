package app;

public class Teacher {
	private String dni, name, lastname, email;

	public Teacher() {
		super();
	}

	public Teacher(String dni, String name, String lastname, String email) {
		super();
		this.dni = dni;
		this.name = name;
		this.lastname = lastname;
		this.email = email;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Teacher [dni=" + dni + ", name=" + name + ", lastname=" + lastname + ", email=" + email + "]";
	}

}
