package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.Student;
import com.app.repository.StudentRepository;

@RestController
@RequestMapping(value = "/app")
public class StudentController {

	@Autowired
	private StudentRepository studentRepository;
	
	@GetMapping("/students")
	public List<Student> findAllStudent() {
		
		return studentRepository.findAll();
	}
	
	@GetMapping("/students/{id}")
	public Student findByStudentId(@PathVariable Long id) {
		return studentRepository.getStudentById(id);
	}
	
	@GetMapping("/students/{name}/{id}")
	public Student findByStudentByNameAndId(@PathVariable String name, @PathVariable Long id) {
		return studentRepository.findStudent(name, id);
	}
	
	
	
}
