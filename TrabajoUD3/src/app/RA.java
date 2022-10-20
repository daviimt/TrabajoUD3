package app;

// TODO: Auto-generated Javadoc
/**
 * The Class RA.
 */
public class RA {

	/** The id. */
	private int id;

	/** The description. */
	private String name, description;

	/** The id subject. */
	private int weighing, id_subject;

	/**
	 * Instantiates a new ra.
	 */
	public RA() {
		super();
	}

	/**
	 * Instantiates a new ra.
	 *
	 * @param id          the id
	 * @param name        the name
	 * @param description the description
	 * @param weighing    the weighing
	 * @param id_subject  the id subject
	 */
	public RA(int id, String name, String description, int weighing, int id_subject) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.weighing = weighing;
		this.id_subject = id_subject;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the description.
	 *
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the description.
	 *
	 * @param description the new description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Gets the weighing.
	 *
	 * @return the weighing
	 */
	public int getWeighing() {
		return weighing;
	}

	/**
	 * Sets the weighing.
	 *
	 * @param weighing the new weighing
	 */
	public void setWeighing(int weighing) {
		this.weighing = weighing;
	}

	/**
	 * Gets the id subject.
	 *
	 * @return the id subject
	 */
	public int getId_subject() {
		return id_subject;
	}

	/**
	 * Sets the id subject.
	 *
	 * @param id_subject the new id subject
	 */
	public void setId_subject(int id_subject) {
		this.id_subject = id_subject;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "RA [id=" + id + ", name=" + name + ", description=" + description + ", weighing=" + weighing
				+ ", id_subject=" + id_subject + "]";
	}

}
