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
 * The Class ReportCardDetail.
 */
@Entity
public class ReportCardDetail {
	
	/** The id. */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	/** The report card. */
	@NotNull
	@ManyToOne
	private ReportCard reportCard;

	/** The teaching. */
	@NotNull
	@ManyToOne
	private Teaching teaching;
	
	/** The grades. */
	@OneToMany(cascade = CascadeType.ALL, mappedBy="reportCardDetail")
    private List<Grade> grades;
	
	/** The appreciation. */
	String appreciation;

	/**
	 * Instantiates a new report card detail.
	 */
	public ReportCardDetail() {
		super();
	}

	/**
	 * Instantiates a new report card detail.
	 *
	 * @param id the id
	 * @param reportCard the report card
	 * @param teaching the teaching
	 * @param appreciation the appreciation
	 */
	public ReportCardDetail(Integer id, ReportCard reportCard, Teaching teaching, String appreciation) {
		super();
		this.id = id;
		this.reportCard = reportCard;
		this.teaching = teaching;
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

	/**
	 * Gets the teaching.
	 *
	 * @return the teaching
	 */
	public Teaching getTeaching() {
		return teaching;
	}

	/**
	 * Sets the teaching.
	 *
	 * @param teaching the teaching to set
	 */
	public void setTeaching(Teaching teaching) {
		this.teaching = teaching;
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
