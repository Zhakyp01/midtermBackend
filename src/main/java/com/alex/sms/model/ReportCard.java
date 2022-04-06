package com.alex.sms.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

// TODO: Auto-generated Javadoc
/**
 * The Class ReportCard.
 */
@Entity
public class ReportCard {
	
	/** The id. */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	/** The quarter. */
	@NotNull
	@ManyToOne
	private Quarter quarter;

	/** The registration. */
	@NotNull
	@OneToOne
	private Registration registration;
	
	/** The appreciation. */
	@NotNull
	String appreciation;
	
	/** The report card detail. */
	@OneToMany(cascade = CascadeType.ALL, mappedBy="reportCard")
    private List<ReportCardDetail> reportCardDetail;

	/**
	 * Instantiates a new report card.
	 */
	public ReportCard() {
		super();
	}

	/**
	 * Instantiates a new report card.
	 *
	 * @param id the id
	 * @param quarter the quarter
	 * @param registration the registration
	 * @param appreciation the appreciation
	 */
	public ReportCard(Integer id, Quarter quarter, Registration registration, String appreciation) {
		super();
		this.id = id;
		this.quarter = quarter;
		this.registration = registration;
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
	 * Gets the quarter.
	 *
	 * @return the quarter
	 */
	public Quarter getQuarter() {
		return quarter;
	}

	/**
	 * Sets the quarter.
	 *
	 * @param quarter the quarter to set
	 */
	public void setQuarter(Quarter quarter) {
		this.quarter = quarter;
	}

	/**
	 * Gets the registration.
	 *
	 * @return the registration
	 */
	public Registration getRegistration() {
		return registration;
	}

	/**
	 * Sets the registration.
	 *
	 * @param registration the registration to set
	 */
	public void setRegistration(Registration registration) {
		this.registration = registration;
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
