package com.alex.sms.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

// TODO: Auto-generated Javadoc
/**
 * The Class Teacher.
 */
@Entity
public class Teacher extends Person {
	
	/** The id. */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	/** The teachings. */
	@OneToMany(cascade = CascadeType.ALL, mappedBy="teacher")
    private List<Teaching> teachings;

	/**
	 * Instantiates a new teacher.
	 */
	public Teacher() {
		super();
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
}
