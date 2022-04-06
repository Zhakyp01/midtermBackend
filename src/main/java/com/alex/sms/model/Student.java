package com.alex.sms.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

// TODO: Auto-generated Javadoc
/**
 * The Class Student.
 */
@Entity
public class Student extends Person {
	
	/** The id. */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	/** The registration. */
	@OneToOne(cascade = {CascadeType.REMOVE, CascadeType.REFRESH}, mappedBy="student")
    private Registration registration;

	/**
	 * Instantiates a new student.
	 */
	public Student() {
		super();
	}

	/**
	 * Instantiates a new student.
	 *
	 * @param id the id
	 */
	public Student(Integer id) {
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
