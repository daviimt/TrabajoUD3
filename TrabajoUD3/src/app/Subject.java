package app;

public class Subject {
	private int codigo;
	private String nombre;
	private int horas;
	private String dni_Prof;
	
	public Subject() {
		super();
	}
	public Subject(int codigo, String nombre, int horas, String dni_Prof) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.horas = horas;
		this.dni_Prof = dni_Prof;
	}
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getHoras() {
		return horas;
	}
	public void setHoras(int horas) {
		this.horas = horas;
	}
	public String getDni_Prof() {
		return dni_Prof;
	}
	public void setDni_Prof(String dni_Prof) {
		this.dni_Prof = dni_Prof;
	}
	@Override
	public String toString() {
		return "Asignatura [codigo=" + codigo + ", nombre=" + nombre + ", horas=" + horas + ", dni_Prof=" + dni_Prof
				+ ", getCodigo()=" + getCodigo() + ", getNombre()=" + getNombre() + ", getHoras()=" + getHoras()
				+ ", getDni_Prof()=" + getDni_Prof() + "]";
	}


	
}
