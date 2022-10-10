package app;

import java.sql.Date;

public class Student {
	private String dni, name, lastname, phone, photo;
	private Date fecha_nac;

	public Student() {
		super();
	}

	public Student(String dni, String name, String lastname, String phone, String photo, Date fecha_nac) {
		super();
		this.dni = dni;
		this.name = name;
		this.lastname = lastname;
		this.phone = phone;
		this.photo = photo;
		this.fecha_nac = fecha_nac;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Date getFecha_nac() {
		return fecha_nac;
	}

	public void setFecha_nac(Date fecha_nac) {
		this.fecha_nac = fecha_nac;
	}

	@Override
	public String toString() {
		return "Student [dni=" + dni + ", name=" + name + ", lastname=" + lastname + ", phone=" + phone + ", photo="
				+ photo + ", fecha_nac=" + fecha_nac + "]";
	}

}
