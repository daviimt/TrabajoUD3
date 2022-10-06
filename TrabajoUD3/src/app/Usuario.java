package app;

public class Usuario {
	private String codigo, password, rol;

	public Usuario() {
		super();
	}

	public Usuario(String codigo, String password, String rol) {
		super();
		this.codigo = codigo;
		this.password = password;
		this.rol = rol;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	@Override
	public String toString() {
		return "Usuario [codigo=" + codigo + ", password=" + password + ", rol=" + rol + ", getCodigo()=" + getCodigo()
				+ ", getPassword()=" + getPassword() + ", getRol()=" + getRol() + "]";
	}
	
}
