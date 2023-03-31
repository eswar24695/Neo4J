package com.gaiansolutions.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gaiansolutions.entity.Student;
import com.gaiansolutions.request.CreateStudentRequest;
import com.gaiansolutions.request.UpdateStudentRequest;
import com.gaiansolutions.service.StudentService;

@RestController
@RequestMapping("/api/student")


public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@PostMapping("/create")
	public Student createStudent(@RequestBody CreateStudentRequest createStudentRequest) {
		return studentService.createStudent(createStudentRequest);
	}
	//Find the student using id
	@GetMapping("/getStudentById/{id}")
	public Student getStudentById(@PathVariable long id) {
		return studentService.getStudentById(id);
	}
	//find the node using the property name for student
	@GetMapping("/getStudentByName/{name}")
	public List<Student> getStudentByName(@PathVariable String name) {
		return studentService.getStudentByName(name);
	}
	//get all nodes
	@GetMapping("/getAllStudents")
	public List<Student> getAllStudents() {
		return studentService.getAllStudents();
	} 
	//update nodes
	@PutMapping("/update")
	public Student updateStudent(@RequestBody UpdateStudentRequest updateStudentRequest) {
		return studentService.updateStudent(updateStudentRequest);
	}
	//delete the node
	@DeleteMapping("/delete/{id}")
	public String deleteStudent(@PathVariable long id) {
		return studentService.deleteStudent(id);
	}
	
	//delete all nodes - custom
		@DeleteMapping("/delete/all")
		public String deleteAllStudents() {
			return studentService.deleteAllStudents();
		}
		
	
	

}
