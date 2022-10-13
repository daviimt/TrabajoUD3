package app;

public class User {
	private String dni, password, role;

	public User() {
		super();
	}

	public User(String dni, String password, String role) {
		super();
		this.dni = dni;
		this.password = password;
		this.role = role;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [dni=" + dni + ", password=" + password + ", role=" + role + "]";
	}
	
}
