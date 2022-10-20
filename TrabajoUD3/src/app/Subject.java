package app;

// TODO: Auto-generated Javadoc
/**
 * The Class Subject.
 */
public class Subject {

	/** The hours. */
	private int id, hours;

	/** The dni teacher. */
	private String name, dni_teacher;

	/**
	 * Instantiates a new subject.
	 */
	public Subject() {
		super();
	}

	/**
	 * Instantiates a new subject.
	 *
	 * @param id          the id
	 * @param hours       the hours
	 * @param name        the name
	 * @param dni_teacher the dni teacher
	 */
	public Subject(int id, int hours, String name, String dni_teacher) {
		super();
		this.id = id;
		this.hours = hours;
		this.name = name;
		this.dni_teacher = dni_teacher;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Gets the hours.
	 *
	 * @return the hours
	 */
	public int getHours() {
		return hours;
	}

	/**
	 * Sets the hours.
	 *
	 * @param hours the new hours
	 */
	public void setHours(int hours) {
		this.hours = hours;
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
	 * Gets the dni teacher.
	 *
	 * @return the dni teacher
	 */
	public String getDni_teacher() {
		return dni_teacher;
	}

	/**
	 * Sets the dni teacher.
	 *
	 * @param dni_teacher the new dni teacher
	 */
	public void setDni_teacher(String dni_teacher) {
		this.dni_teacher = dni_teacher;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Subject [id=" + id + ", hours=" + hours + ", name=" + name + ", dni_teacher=" + dni_teacher + "]";
	}

}
