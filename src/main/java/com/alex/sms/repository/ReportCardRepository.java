package com.alex.sms.repository;

import org.springframework.data.repository.CrudRepository;

import com.alex.sms.model.ReportCard;

// TODO: Auto-generated Javadoc
/**
 * The Interface ReportCardRepository.
 */
public interface ReportCardRepository extends CrudRepository<ReportCard, Integer> {
	
	/**
	 * Find by registration id.
	 *
	 * @param id the id
	 * @return the report card
	 */
	ReportCard findByRegistrationId(Integer id);
}
