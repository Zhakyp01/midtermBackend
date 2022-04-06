package com.alex.sms.repository;

import org.springframework.data.repository.CrudRepository;

import com.alex.sms.model.Grade;

// TODO: Auto-generated Javadoc
/**
 * The Interface GradeRepository.
 */
public interface GradeRepository extends CrudRepository<Grade, Integer> {
	
	/**
	 * Find by report card detail id.
	 *
	 * @param id the id
	 * @return the iterable
	 */
	Iterable<Grade> findByReportCardDetailId(Integer id);
}
