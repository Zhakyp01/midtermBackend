package com.alex.sms.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

// TODO: Auto-generated Javadoc
/**
 * The Class School.
 */
@Entity
public class School {
	
	/** The id. */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	/** The name. */
	@NotNull
	private String name;
	
	/** The classes. */
	@OneToMany(cascade = CascadeType.ALL, mappedBy="school")
    private List<Class> classes;
	
	/**
	 * Instantiates a new school.
	 */
	public School() {
		super();
	}

	/**
	 * Instantiates a new school.
	 *
	 * @param id the id
	 * @param name the name
	 */
	public School(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
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
}
