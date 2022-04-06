package com.alex.sms.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

// TODO: Auto-generated Javadoc
/**
 * The Class Teaching.
 */
@Entity
public class Teaching {
	
	/** The id. */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	/** The c. */
	@NotNull
	@ManyToOne
	private Class c;

	/** The subject. */
	@NotNull
	@ManyToOne
	private Subject subject;

	/** The teacher. */
	@NotNull
	@ManyToOne
	private Teacher teacher;
	
	/** The Report card details. */
	@OneToMany(cascade = CascadeType.ALL, mappedBy="teaching")
    private List<ReportCardDetail> ReportCardDetails;

	/**
	 * Instantiates a new teaching.
	 */
	public Teaching() {
		super();
	}

	/**
	 * Instantiates a new teaching.
	 *
	 * @param id the id
	 * @param c the c
	 * @param subject the subject
	 * @param teacher the teacher
	 */
	public Teaching(Integer id, Class c, Subject subject, Teacher teacher) {
		super();
		this.id = id;
		this.c = c;
		this.subject = subject;
		this.teacher = teacher;
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
	 * Gets the c.
	 *
	 * @return the c
	 */
	public Class getC() {
		return c;
	}

	/**
	 * Sets the c.
	 *
	 * @param c the c to set
	 */
	public void setC(Class c) {
		this.c = c;
	}

	/**
	 * Gets the subject.
	 *
	 * @return the subject
	 */
	public Subject getSubject() {
		return subject;
	}

	/**
	 * Sets the subject.
	 *
	 * @param subject the subject to set
	 */
	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	/**
	 * Gets the teacher.
	 *
	 * @return the teacher
	 */
	public Teacher getTeacher() {
		return teacher;
	}

	/**
	 * Sets the teacher.
	 *
	 * @param teacher the teacher to set
	 */
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
}
