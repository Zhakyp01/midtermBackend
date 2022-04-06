package com.alex.sms.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

// TODO: Auto-generated Javadoc
/**
 * The Class SchoolYear.
 */
@Entity
public class SchoolYear {
	
	/** The id. */
	@Id
	@Column(unique=true)
	private Integer id;
	
	/** The classes. */
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy="schoolYear")
    private List<Class> classes;
	
	/** The quarters. */
	@OneToMany(cascade = CascadeType.ALL, mappedBy="schoolYear")
    private List<Quarter> quarters;

	/**
	 * Instantiates a new school year.
	 */
	public SchoolYear() {
		super();
	}

	/**
	 * Instantiates a new school year.
	 *
	 * @param id the id
	 */
	public SchoolYear(Integer id) {
		super();
		this.id = id;
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
