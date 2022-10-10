package app;

public class Qualifies {
	private String dni_student;
	private int id_RA;
	private float mark;

	public Qualifies() {
		super();
	}

	public Qualifies(String dni_student, int id_RA, float mark) {
		super();
		this.dni_student = dni_student;
		this.id_RA = id_RA;
		this.mark = mark;
	}

	public String getDni_student() {
		return dni_student;
	}

	public void setDni_student(String dni_student) {
		this.dni_student = dni_student;
	}

	public int getId_RA() {
		return id_RA;
	}

	public void setId_RA(int id_RA) {
		this.id_RA = id_RA;
	}

	public float getMark() {
		return mark;
	}

	public void setMark(float mark) {
		this.mark = mark;
	}

	@Override
	public String toString() {
		return "Qualifies [dni_student=" + dni_student + ", id_RA=" + id_RA + ", mark=" + mark + "]";
	}

}
