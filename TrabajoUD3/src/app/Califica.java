package app;

public class Califica {
	private String dni_Alumno;
	private int id_RA;
	private float nota;
	public Califica() {
		super();
	}
	public Califica(String dni_Alumno, int id_RA, float nota) {
		super();
		this.dni_Alumno = dni_Alumno;
		this.id_RA = id_RA;
		this.nota = nota;
	}
	public String getDni_Alumno() {
		return dni_Alumno;
	}
	public void setDni_Alumno(String dni_Alumno) {
		this.dni_Alumno = dni_Alumno;
	}
	public int getId_RA() {
		return id_RA;
	}
	public void setId_RA(int id_RA) {
		this.id_RA = id_RA;
	}
	public float getNota() {
		return nota;
	}
	public void setNota(float nota) {
		this.nota = nota;
	}
	@Override
	public String toString() {
		return "Califica [dni_Alumno=" + dni_Alumno + ", id_RA=" + id_RA + ", nota=" + nota + ", getDni_Alumno()="
				+ getDni_Alumno() + ", getId_RA()=" + getId_RA() + ", getNota()=" + getNota() + "]";
	}

}
