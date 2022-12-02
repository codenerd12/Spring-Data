package com.app.repository;


import org.springframework.stereotype.Repository;
import com.app.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;


@Repository
public class StudentRepositoryImpl implements StudentRepositoryCustom {
	
	 @PersistenceContext
	 private EntityManager entityManager;

	@Override
	public Student getStudentById(Long id) {
		 Query query = entityManager.createQuery("SELECT s FROM Student s WHERE s.id = :id");
	     query.setParameter("id", id);

	     return (Student) query.getSingleResult();
	}

}
