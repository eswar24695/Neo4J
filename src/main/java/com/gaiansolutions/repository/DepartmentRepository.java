package com.gaiansolutions.repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import com.gaiansolutions.entity.Department;

@Repository
public interface DepartmentRepository extends Neo4jRepository <Department,Long>{

}
