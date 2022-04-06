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
 * The Class Class.
 */
@Entity
public class Class {
	
	/** The id. */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	/** The name. */
	@NotNull
	private String name;
	
	/** The school. */
	@NotNull
	@ManyToOne
	private School school;
	
	/** The level. */
	@NotNull
	@ManyToOne
	private Level level;
	
	/** The school year. */
	@NotNull
	@ManyToOne
	private SchoolYear schoolYear;
	
	/** The teachings. */
	@OneToMany(cascade = CascadeType.ALL, mappedBy="c")
    private List<Teaching> teachings;
	
	/** The registrations. */
	@OneToMany(cascade = CascadeType.ALL, mappedBy="c")
    private List<Registration> registrations;

	/**
	 * Instantiates a new class.
	 */
	public Class() {
		super();
	}

	/**
	 * Instantiates a new class.
	 *
	 * @param id the id
	 * @param name the name
	 * @param school the school
	 * @param level the level
	 * @param schoolYear the school year
	 */
	public Class(Integer id, String name, School school, Level level, SchoolYear schoolYear) {
		super();
		this.id = id;
		this.name = name;
		this.school = school;
		this.level = level;
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

	/**
	 * Gets the school.
	 *
	 * @return the school
	 */
	public School getSchool() {
		return school;
	}

	/**
	 * Sets the school.
	 *
	 * @param school the school to set
	 */
	public void setSchool(School school) {
		this.school = school;
	}

	/**
	 * Gets the level.
	 *
	 * @return the level
	 */
	public Level getLevel() {
		return level;
	}

	/**
	 * Sets the level.
	 *
	 * @param level the level to set
	 */
	public void setLevel(Level level) {
		this.level = level;
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
