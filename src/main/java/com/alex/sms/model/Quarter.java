package com.alex.sms.model;

import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

// TODO: Auto-generated Javadoc
/**
 * The Class Quarter.
 */
@Entity
public class Quarter {
	
	/** The id. */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	/** The number. */
	@NotNull
	private Integer number;

	/** The start date. */
	@NotNull
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date startDate;

	/** The end date. */
	@NotNull
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date endDate;

	/** The school year. */
	@NotNull
	@ManyToOne
	@JoinColumn(name = "school_year_id")
	private SchoolYear schoolYear;
	
	/** The report cards. */
	@OneToMany(cascade = CascadeType.ALL, mappedBy="quarter")
    private List<ReportCard> reportCards;

	/**
	 * Instantiates a new quarter.
	 */
	public Quarter() {
		super();
	}

	/**
	 * Instantiates a new quarter.
	 *
	 * @param id the id
	 * @param number the number
	 * @param startDate the start date
	 * @param endDate the end date
	 * @param schoolYear the school year
	 */
	public Quarter(Integer id, Integer number, Date startDate, Date endDate, SchoolYear schoolYear) {
		super();
		this.id = id;
		this.number = number;
		this.startDate = startDate;
		this.endDate = endDate;
		this.schoolYear = schoolYear;
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
	 * Gets the number.
	 *
	 * @return the number
	 */
	public Integer getNumber() {
		return number;
	}

	/**
	 * Sets the number.
	 *
	 * @param number the number to set
	 */
	public void setNumber(Integer number) {
		this.number = number;
	}

	/**
	 * Gets the start date.
	 *
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * Sets the start date.
	 *
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * Gets the end date.
	 *
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * Sets the end date.
	 *
	 * @param endDate the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * Gets the school year.
	 *
	 * @return the schoolYear
	 */
	public SchoolYear getSchoolYear() {
		return schoolYear;
	}

	/**
	 * Sets the school year.
	 *
	 * @param schoolYear the schoolYear to set
	 */
	public void setSchoolYear(SchoolYear schoolYear) {
		this.schoolYear = schoolYear;
	}
}
