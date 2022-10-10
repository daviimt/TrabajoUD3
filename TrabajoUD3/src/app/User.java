package app;

public class User {
	private int id;
	private String password, role;

	public User() {
		super();
	}

	public User(int id, String password, String role) {
		super();
		this.id = id;
		this.password = password;
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
		return "User [id=" + id + ", password=" + password + ", role=" + role + "]";
	}

	
	
}
