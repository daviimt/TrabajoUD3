package app;

public class Subject {
	private int id, hours;
	private String name, dni_teacher;

	public Subject() {
		super();
	}

	public Subject(int id, int hours, String name, String dni_teacher) {
		super();
		this.id = id;
		this.hours = hours;
		this.name = name;
		this.dni_teacher = dni_teacher;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDni_teacher() {
		return dni_teacher;
	}

	public void setDni_teacher(String dni_teacher) {
		this.dni_teacher = dni_teacher;
	}

	@Override
	public String toString() {
		return "Subject [id=" + id + ", hours=" + hours + ", name=" + name + ", dni_teacher=" + dni_teacher + "]";
	}

}
