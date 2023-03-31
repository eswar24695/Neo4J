package com.gaiansolutions.repository;

import java.util.List;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import com.gaiansolutions.entity.Student;

@Repository
public interface StudentRepository extends Neo4jRepository<Student, Long>{
	List<Student> findByName(String name); //No need to provide the list if you feel like it returns only on ename
	@Query("match (node) return node")
	List<Student> queryall();
	@Query("match (node) detach delete node")
	List<Student> deleteAll1();
	
	

}
 