package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>, StudentRepositoryCustom {
	
	List<Student> findByName(String name);
	
	@Query("SELECT s FROM Student s WHERE s.name = :name AND s.id=:id")
	Student findStudent(@Param("name") String name, @Param("id") Long id);

}
