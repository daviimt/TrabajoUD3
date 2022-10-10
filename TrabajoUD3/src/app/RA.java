package app;

public class RA {
	private int id;
	private String name, description;
	private int weighing, id_subject;

	public RA() {
		super();
	}

	public RA(int id, String name, String description, int weighing, int id_subject) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.weighing = weighing;
		this.id_subject = id_subject;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getWeighing() {
		return weighing;
	}

	public void setWeighing(int weighing) {
		this.weighing = weighing;
	}

	public int getId_subject() {
		return id_subject;
	}

	public void setId_subject(int id_subject) {
		this.id_subject = id_subject;
	}

	@Override
	public String toString() {
		return "RA [id=" + id + ", name=" + name + ", description=" + description + ", weighing=" + weighing
				+ ", id_subject=" + id_subject + "]";
	}

}
