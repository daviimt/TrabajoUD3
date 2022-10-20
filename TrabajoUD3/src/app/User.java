package app;

// TODO: Auto-generated Javadoc
/**
 * The Class User.
 */
public class User {

	/** The role. */
	private String dni, password, role;

	/**
	 * Instantiates a new user.
	 */
	public User() {
		super();
	}

	/**
	 * Instantiates a new user.
	 *
	 * @param dni      the dni
	 * @param password the password
	 * @param role     the role
	 */
	public User(String dni, String password, String role) {
		super();
		this.dni = dni;
		this.password = password;
		this.role = role;
	}

	/**
	 * Gets the dni.
	 *
	 * @return the dni
	 */
	public String getDni() {
		return dni;
	}

	/**
	 * Sets the dni.
	 *
	 * @param dni the new dni
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}

	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password.
	 *
	 * @param password the new password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Gets the role.
	 *
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * Sets the role.
	 *
	 * @param role the new role
	 */
	public void setRole(String role) {
		this.role = role;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "User [dni=" + dni + ", password=" + password + ", role=" + role + "]";
	}

}
