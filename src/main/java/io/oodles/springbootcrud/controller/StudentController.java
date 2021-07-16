package io.oodles.springbootcrud.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.oodles.springbootcrud.model.Student;
import io.oodles.springbootcrud.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/students")
	public List<Student> listAll(){
		return studentService.listAll();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/students/{id}")
	public Optional<Student> getStudent(@PathVariable Integer id) {
		return studentService.getStudent(id);
		
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/students")
	public String addStudent(@RequestBody Student s) {
		studentService.addStudent(s);
		return "Student Added";
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/students")
	public String updateStudent(@RequestBody Student s) {
		studentService.updateStudent(s);
		return "Student Upated";
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/students/{id}")
	public ResponseEntity<Student> delete(@PathVariable Integer id) {
		try {
			Student s = studentService.getStudent(id).get();
			studentService.delete(id);
			return new ResponseEntity<Student>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
		}
	}

}
