package com.alex.sms.repository;

import org.springframework.data.repository.CrudRepository;

import com.alex.sms.model.Registration;

// TODO: Auto-generated Javadoc
/**
 * The Interface RegistrationRepository.
 */
public interface RegistrationRepository extends CrudRepository<Registration, Integer> {
	
	/**
	 * Find by C id.
	 *
	 * @param id the id
	 * @return the iterable
	 */
	Iterable<Registration> findByCId(Integer id);
	
	/**
	 * Find first 5 by order by timestamp desc.
	 *
	 * @return the iterable
	 */
	Iterable<Registration> findFirst5ByOrderByTimestampDesc();
	
	/**
	 * Find by student id.
	 *
	 * @param id the id
	 * @return the registration
	 */
	Registration findByStudentId(Integer id);
}
