package com.alex.sms.model;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

// TODO: Auto-generated Javadoc
/**
 * The Class Registration.
 */
@Entity
public class Registration {
	
	/** The id. */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	/** The timestamp. */
	@NotNull
	private Timestamp timestamp = Timestamp.valueOf(LocalDateTime.now());

	/** The c. */
	@NotNull
	@ManyToOne
	private Class c;

	/** The student. */
	@NotNull
	@OneToOne
	private Student student;
	
	/** The report card. */
	@OneToOne(cascade = {CascadeType.REMOVE, CascadeType.REFRESH}, mappedBy="registration")
    private ReportCard reportCard;

	/**
	 * Instantiates a new registration.
	 */
	public Registration() {
		super();
	}

	/**
	 * Instantiates a new registration.
	 *
	 * @param id the id
	 * @param timestamp the timestamp
	 * @param c the c
	 * @param student the student
	 * @param reportCard the report card
	 */
	public Registration(Integer id, @NotNull Timestamp timestamp, @NotNull Class c, @NotNull Student student,
			ReportCard reportCard) {
		super();
		this.id = id;
		this.timestamp = timestamp;
		this.c = c;
		this.student = student;
		this.reportCard = reportCard;
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
	 * Gets the student.
	 *
	 * @return the student
	 */
	public Student getStudent() {
		return student;
	}

	/**
	 * Sets the student.
	 *
	 * @param student the student to set
	 */
	public void setStudent(Student student) {
		this.student = student;
	}

	/**
	 * Gets the timestamp.
	 *
	 * @return the timestamp
	 */
	public Timestamp getTimestamp() {
		return timestamp;
	}

	/**
	 * Sets the timestamp.
	 *
	 * @param timestamp the timestamp to set
	 */
	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	/**
	 * Gets the report card.
	 *
	 * @return the reportCard
	 */
	public ReportCard getReportCard() {
		return reportCard;
	}

	/**
	 * Sets the report card.
	 *
	 * @param reportCard the reportCard to set
	 */
	public void setReportCard(ReportCard reportCard) {
		this.reportCard = reportCard;
	}
}
