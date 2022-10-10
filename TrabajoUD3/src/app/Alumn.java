package app;

import java.sql.Date;

public class Alumn {
	private String dni, nombre, apellidos, telefono,foto;
	private Date fecha_nac;
	
	public Alumn() {
		super();
	}
	public Alumn(String dni, String nombre, String apellidos, String telefono, String foto, Date fecha_nac) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.telefono = telefono;
		this.foto = foto;
		this.fecha_nac = fecha_nac;
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
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	public Date getFecha_nac() {
		return fecha_nac;
	}
	public void setFecha_nac(Date fecha_nac) {
		this.fecha_nac = fecha_nac;
	}
	@Override
	public String toString() {
		return "Alumno [dni=" + dni + ", nombre=" + nombre + ", apellidos=" + apellidos + ", telefono=" + telefono
				+ ", foto=" + foto + ", fecha_nac=" + fecha_nac + ", getDni()=" + getDni() + ", getNombre()="
				+ getNombre() + ", getApellidos()=" + getApellidos() + ", getTelefono()=" + getTelefono()
				+ ", getFoto()=" + getFoto() + ", getFecha_nac()=" + getFecha_nac() + "]";
	}

	
	
}
