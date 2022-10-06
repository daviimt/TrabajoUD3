package app;

public class Profesor {
	private String dni, nombre, apellidos, email;

	public Profesor() {
		super();
	}

	public Profesor(String dni, String nombre, String apellidos, String email) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
	}
	
	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Profesor [dni=" + dni + ", nombre=" + nombre + ", apellidos=" + apellidos + ", email=" + email
				+ ", getDni()=" + getDni() + ", getNombre()=" + getNombre() + ", getApellidos()=" + getApellidos()
				+ ", getEmail()=" + getEmail() + "]";
	}


	
}
