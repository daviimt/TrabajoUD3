package app;

// TODO: Auto-generated Javadoc
/**
 * The Class SchoolEnrollment.
 */
public class SchoolEnrollment {

	/** The dni student. */
	private String dni_student;

	/** The id subject. */
	private int id_subject;

	/**
	 * Instantiates a new school enrollment.
	 */
	public SchoolEnrollment() {
		super();
	}

	/**
	 * Instantiates a new school enrollment.
	 *
	 * @param dni_student the dni student
	 * @param id_subject  the id subject
	 */
	public SchoolEnrollment(String dni_student, int id_subject) {
		super();
		this.dni_student = dni_student;
		this.id_subject = id_subject;
	}

	/**
	 * Gets the dni student.
	 *
	 * @return the dni student
	 */
	public String getDni_student() {
		return dni_student;
	}

	/**
	 * Sets the dni student.
	 *
	 * @param dni_student the new dni student
	 */
	public void setDni_student(String dni_student) {
		this.dni_student = dni_student;
	}

	/**
	 * Gets the id subject.
	 *
	 * @return the id subject
	 */
	public int getId_subject() {
		return id_subject;
	}

	/**
	 * Sets the id subject.
	 *
	 * @param id_subject the new id subject
	 */
	public void setId_subject(int id_subject) {
		this.id_subject = id_subject;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "SchoolEnrollment [dni_student=" + dni_student + ", id_subject=" + id_subject + "]";
	}

}
