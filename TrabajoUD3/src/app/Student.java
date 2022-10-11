package app;

import java.sql.Date;

public class Student {
	private int id;
	private String dni, name, lastname, phone, photo;
	private Date birth_date;

	public Student() {
		super();
	}

	public Student(int id, String dni, String name, String lastname, String phone, String photo, Date birth_date) {
		super();
		this.id = id;
		this.dni = dni;
		this.name = name;
		this.lastname = lastname;
		this.phone = phone;
		this.photo = photo;
		this.birth_date = birth_date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Date getBirth_date() {
		return birth_date;
	}

	public void setBirth_date(Date birth_date) {
		this.birth_date = birth_date;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", dni=" + dni + ", name=" + name + ", lastname=" + lastname + ", phone=" + phone
				+ ", photo=" + photo + ", birth_date=" + birth_date + "]";
	}

}
