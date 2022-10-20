package app;

// TODO: Auto-generated Javadoc
/**
 * The Class Qualifies.
 */
public class Qualifies {

	/** The dni student. */
	private String dni_student;

	/** The id RA. */
	private int id_RA;

	/** The mark. */
	private float mark;

	/**
	 * Instantiates a new qualifies.
	 */
	public Qualifies() {
		super();
	}

	/**
	 * Instantiates a new qualifies.
	 *
	 * @param dni_student the dni student
	 * @param id_RA       the id RA
	 * @param mark        the mark
	 */
	public Qualifies(String dni_student, int id_RA, float mark) {
		super();
		this.dni_student = dni_student;
		this.id_RA = id_RA;
		this.mark = mark;
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
	 * Gets the id RA.
	 *
	 * @return the id RA
	 */
	public int getId_RA() {
		return id_RA;
	}

	/**
	 * Sets the id RA.
	 *
	 * @param id_RA the new id RA
	 */
	public void setId_RA(int id_RA) {
		this.id_RA = id_RA;
	}

	/**
	 * Gets the mark.
	 *
	 * @return the mark
	 */
	public float getMark() {
		return mark;
	}

	/**
	 * Sets the mark.
	 *
	 * @param mark the new mark
	 */
	public void setMark(float mark) {
		this.mark = mark;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Qualifies [dni_student=" + dni_student + ", id_RA=" + id_RA + ", mark=" + mark + "]";
	}

}
