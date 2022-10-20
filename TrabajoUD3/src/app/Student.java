package app;

// TODO: Auto-generated Javadoc
/**
 * The Class Student.
 */
public class Student {

	/** The photo. */
	private String dni, name, lastname, birth_date, phone, photo;

	/**
	 * Instantiates a new student.
	 */
	public Student() {
		super();
	}

	/**
	 * Instantiates a new student.
	 *
	 * @param dni        the dni
	 * @param name       the name
	 * @param lastname   the lastname
	 * @param birth_date the birth date
	 * @param phone      the phone
	 * @param photo      the photo
	 */
	public Student(String dni, String name, String lastname, String birth_date, String phone, String photo) {
		super();
		this.dni = dni;
		this.name = name;
		this.lastname = lastname;
		this.phone = phone;
		this.photo = photo;
		this.birth_date = birth_date;
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
	 * Gets the phone.
	 *
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * Sets the phone.
	 *
	 * @param phone the new phone
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * Gets the photo.
	 *
	 * @return the photo
	 */
	public String getPhoto() {
		return photo;
	}

	/**
	 * Sets the photo.
	 *
	 * @param photo the new photo
	 */
	public void setPhoto(String photo) {
		this.photo = photo;
	}

	/**
	 * Gets the birth date.
	 *
	 * @return the birth date
	 */
	public String getBirth_date() {
		return birth_date;
	}

	/**
	 * Sets the birth date.
	 *
	 * @param birth_date the new birth date
	 */
	public void setBirth_date(String birth_date) {
		this.birth_date = birth_date;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Student [dni=" + dni + ", name=" + name + ", lastname=" + lastname + ", phone=" + phone + ", photo="
				+ photo + ", birth_date=" + birth_date + "]";
	}

}
