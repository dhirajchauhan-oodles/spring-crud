package io.oodles.springbootcrud.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.oodles.springbootcrud.model.Student;
import io.oodles.springbootcrud.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	public List<Student> listAll(){
		return studentRepository.findAll();
	}
	
	
	public Optional<Student> getStudent(Integer id) {
		return studentRepository.findById(id);
		
	}
	
	public void addStudent(Student s) {
		studentRepository.save(s);
	}
	
	public void updateStudent(Student s) {
		studentRepository.save(s);
	}
	
	public void delete(Integer id) {
		studentRepository.deleteById(id);
	}
	
}
