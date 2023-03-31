package com.gaiansolutions.service;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gaiansolutions.entity.Department;
import com.gaiansolutions.entity.IsLearningRelation;
import com.gaiansolutions.entity.Student;
import com.gaiansolutions.entity.Subject;
import com.gaiansolutions.repository.DepartmentRepository;
import com.gaiansolutions.repository.StudentRepository;
import com.gaiansolutions.repository.SubjectRepository;
import com.gaiansolutions.request.CreateStudentRequest;
import com.gaiansolutions.request.CreateSubjectRequest;
import com.gaiansolutions.request.UpdateStudentRequest;

@Service

public class StudentService {
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	SubjectRepository subjectRepository;
	
	@Autowired
	DepartmentRepository departmentRepository;
	 

	public Student createStudent(CreateStudentRequest createStudentRequest) {
		//Logic to create the nodes and relationship between nodes
		Department department=new Department();
		department.setDepName(createStudentRequest.getDepartment().getDepName());
		departmentRepository.save(department);
		
		List<IsLearningRelation> isLearningRelationList=
				new ArrayList<IsLearningRelation>();
		
		if(createStudentRequest.getSubjectList()!=null) {	
			for(CreateSubjectRequest createSub: createStudentRequest.getSubjectList()) {
				
				Subject subject=new Subject();  //for creation of  create nodes
				subject.setSubName(createSub.getSubjectName());
				subjectRepository.save(subject); //to create the nodes 
				IsLearningRelation relation =new IsLearningRelation();
				relation.setMarks(createSub.getMarks());
				relation.setSubject(subject);
				isLearningRelationList.add(relation);
			}
		}
		Student student=new Student();
		student.setName(createStudentRequest.getName());
		student.setCountry(createStudentRequest.getCountry());
		student.setBirthyear(createStudentRequest.getBirthYear());
		student.setDepartment(department); // student relation to department
		student.setIsLearningRelationList(isLearningRelationList); //student is learning subjects along with the properties
		studentRepository.save(student);
			
		return student;
	}


	public Student getStudentById(long id) {
		// TODO Auto-generated method stub
		return studentRepository.findById(id).get(); //internally will call by id
	}


	public List<Student> getStudentByName(String name) {
		// TODO Auto-generated method stub
		return studentRepository.findByName(name);
		
	}


	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		//return studentRepository.findAll(); 
		return studentRepository.queryall();
	}


	public Student updateStudent(UpdateStudentRequest updateStudentRequest) {
		// TODO Auto-generated method stub
		Student student=studentRepository.findById(updateStudentRequest.getId()).get();
		student.setName(updateStudentRequest.getName());
		student.setCountry(updateStudentRequest.getCountry());
		student.setBirthyear(updateStudentRequest.getBirthYear());
		
		studentRepository.save(student);  //Used for the update as well as creation it all depends on the unique identifier what we provided
		return student;
	}


	public String deleteStudent(long id) {
		// TODO Auto-generated method stub
		studentRepository.deleteById(id);
		return "Deleted";
	}


	public String deleteAllStudents() {
		// TODO Auto-generated method stub
		studentRepository.deleteAll1();
		return "Deleted all Student nodes (Custom)";
	}

}
