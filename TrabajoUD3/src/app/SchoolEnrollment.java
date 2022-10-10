package app;

public class SchoolEnrollment {
	private String dni_student;
	private int id_subject;

	public SchoolEnrollment() {
		super();
	}

	public SchoolEnrollment(String dni_student, int id_subject) {
		super();
		this.dni_student = dni_student;
		this.id_subject = id_subject;
	}

	public String getDni_student() {
		return dni_student;
	}

	public void setDni_student(String dni_student) {
		this.dni_student = dni_student;
	}

	public int getId_subject() {
		return id_subject;
	}

	public void setId_subject(int id_subject) {
		this.id_subject = id_subject;
	}

	@Override
	public String toString() {
		return "SchoolEnrollment [dni_student=" + dni_student + ", id_subject=" + id_subject + "]";
	}

}
