package com.alex.sms.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

// TODO: Auto-generated Javadoc
/**
 * The Class Person.
 */
@MappedSuperclass
public class Person {
	
	/** The id. */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	/** The name. */
	@NotNull
	private String name;

	/** The forename. */
	@NotNull
	private String forename;

	/**
	 * Instantiates a new person.
	 */
	public Person() {
		super();
	}

	/**
	 * Instantiates a new person.
	 *
	 * @param id the id
	 * @param name the name
	 * @param forename the forename
	 */
	public Person(Integer id, String name, String forename) {
		super();
		this.id = id;
		this.name = name;
		this.forename = forename;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the id to set
	 */
	public void setId(Integer id) {
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
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the forename.
	 *
	 * @return the forename
	 */
	public String getForename() {
		return forename;
	}

	/**
	 * Sets the forename.
	 *
	 * @param forename the forename to set
	 */
	public void setForename(String forename) {
		this.forename = forename;
	}
}
