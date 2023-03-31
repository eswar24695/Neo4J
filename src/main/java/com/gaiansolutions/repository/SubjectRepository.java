package com.gaiansolutions.repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import com.gaiansolutions.entity.Subject;

@Repository
public interface SubjectRepository extends Neo4jRepository<Subject, Long>{

}
