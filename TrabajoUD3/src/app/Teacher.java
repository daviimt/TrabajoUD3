package app;

// TODO: Auto-generated Javadoc
/**
 * The Class Teacher.
 */
public class Teacher {

	/** The email. */
	private String dni, name, lastname, email;

	/**
	 * Instantiates a new teacher.
	 */
	public Teacher() {
		super();
	}

	/**
	 * Instantiates a new teacher.
	 *
	 * @param dni      the dni
	 * @param name     the name
	 * @param lastname the lastname
	 * @param email    the email
	 */
	public Teacher(String dni, String name, String lastname, String email) {
		super();
		this.dni = dni;
		this.name = name;
		this.lastname = lastname;
		this.email = email;
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
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the lastname.
	 *
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * Sets the lastname.
	 *
	 * @param lastname the new lastname
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email.
	 *
	 * @param email the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Teacher [dni=" + dni + ", name=" + name + ", lastname=" + lastname + ", email=" + email + "]";
	}

}
