package app;

public class Matricula {
	private String dni_Alumno;
	private int cod_Asig;
	public Matricula() {
		super();
	}
	public Matricula(String dni_Alumno, int cod_Asig) {
		super();
		this.dni_Alumno = dni_Alumno;
		this.cod_Asig = cod_Asig;
	}
	public String getDni_Alumno() {
		return dni_Alumno;
	}
	public void setDni_Alumno(String dni_Alumno) {
		this.dni_Alumno = dni_Alumno;
	}
	public int getCod_Asig() {
		return cod_Asig;
	}
	public void setCod_Asig(int cod_Asig) {
		this.cod_Asig = cod_Asig;
	}
	@Override
	public String toString() {
		return "Matricula [dni_Alumno=" + dni_Alumno + ", cod_Asig=" + cod_Asig + ", getDni_Alumno()=" + getDni_Alumno()
				+ ", getCod_Asig()=" + getCod_Asig() + "]";
	}
	
	
}
