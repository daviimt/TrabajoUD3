package app;

public class RA {
	private int id;
	private String nombre, descripcion;
	private int ponderacion, id_Asig;
	public RA() {
		super();
	}
	public RA(int id, String nombre, String descripcion, int ponderacion, int id_Asig) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.ponderacion = ponderacion;
		this.id_Asig = id_Asig;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getPonderacion() {
		return ponderacion;
	}
	public void setPonderacion(int ponderacion) {
		this.ponderacion = ponderacion;
	}
	public int getId_Asig() {
		return id_Asig;
	}
	public void setId_Asig(int id_Asig) {
		this.id_Asig = id_Asig;
	}
	@Override
	public String toString() {
		return "RA [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", ponderacion=" + ponderacion
				+ ", id_Asig=" + id_Asig + ", getId()=" + getId() + ", getNombre()=" + getNombre()
				+ ", getDescripcion()=" + getDescripcion() + ", getPonderacion()=" + getPonderacion()
				+ ", getId_Asig()=" + getId_Asig() + "]";
	}

	
}
