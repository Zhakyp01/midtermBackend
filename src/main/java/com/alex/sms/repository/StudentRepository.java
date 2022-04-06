package com.alex.sms.repository;

import org.springframework.data.repository.CrudRepository;

import com.alex.sms.model.Student;

// TODO: Auto-generated Javadoc
/**
 * The Interface StudentRepository.
 */
public interface StudentRepository extends CrudRepository<Student, Integer> {
	
	/**
	 * Find by name or forename containing.
	 *
	 * @param name the name
	 * @param forename the forename
	 * @return the iterable
	 */
	Iterable<Student> findByNameOrForenameContaining(String name, String forename);
}
