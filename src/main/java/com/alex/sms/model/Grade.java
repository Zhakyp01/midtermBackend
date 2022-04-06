package com.alex.sms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

// TODO: Auto-generated Javadoc
/**
 * The Class Grade.
 */
@Entity
public class Grade {
	
	/** The id. */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	/** The report card detail. */
	@NotNull
	@ManyToOne
	private ReportCardDetail reportCardDetail;

	/** The value. */
	@NotNull
	double value;

	/** The appreciation. */
	@NotNull
	String appreciation;

	/**
	 * Instantiates a new grade.
	 */
	public Grade() {
		super();
	}

	/**
	 * Instantiates a new grade.
	 *
	 * @param id the id
	 * @param reportCardDetail the report card detail
	 * @param value the value
	 * @param appreciation the appreciation
	 */
	public Grade(Integer id, ReportCardDetail reportCardDetail, double value, String appreciation) {
		super();
		this.id = id;
		this.reportCardDetail = reportCardDetail;
		this.value = value;
		this.appreciation = appreciation;
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
	 * Gets the report card detail.
	 *
	 * @return the reportCardDetail
	 */
	public ReportCardDetail getReportCardDetail() {
		return reportCardDetail;
	}

	/**
	 * Sets the report card detail.
	 *
	 * @param reportCardDetail the reportCardDetail to set
	 */
	public void setReportCardDetail(ReportCardDetail reportCardDetail) {
		this.reportCardDetail = reportCardDetail;
	}

	/**
	 * Gets the value.
	 *
	 * @return the value
	 */
	public double getValue() {
		return value;
	}

	/**
	 * Sets the value.
	 *
	 * @param value the value to set
	 */
	public void setValue(double value) {
		this.value = value;
	}

	/**
	 * Gets the appreciation.
	 *
	 * @return the appreciation
	 */
	public String getAppreciation() {
		return appreciation;
	}

	/**
	 * Sets the appreciation.
	 *
	 * @param appreciation the appreciation to set
	 */
	public void setAppreciation(String appreciation) {
		this.appreciation = appreciation;
	}
}
