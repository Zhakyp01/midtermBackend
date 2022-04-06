package com.alex.sms.repository;

import org.springframework.data.repository.CrudRepository;

import com.alex.sms.model.ReportCardDetail;

// TODO: Auto-generated Javadoc
/**
 * The Interface ReportCardDetailRepository.
 */
public interface ReportCardDetailRepository extends CrudRepository<ReportCardDetail, Integer> {
	
	/**
	 * Find by report card id.
	 *
	 * @param id the id
	 * @return the iterable
	 */
	Iterable<ReportCardDetail> findByReportCardId(Integer id);
}
