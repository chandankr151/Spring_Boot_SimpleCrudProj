package com.springboot.crud.dao;

import com.springboot.crud.entities.Student;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface StudentRepository extends CrudRepository<Student, Integer> {

	public Student findByCity(String city);

	public List<Student> findByNameAndCity(String name, String city);

	/// Based on user query...using JPQL
	// @Query("select s from Student s")
	// public List<Student> getAllRecord();

//	@Query("select s from Student s where s.name = :n")
//	public List<Student> getUserByName(@Param("n") String name);

//	@Query("SELECT s from Student s where s.name = :n and s.city = :c ")
//	public Student getUserByNameAndCity(@Param("n") String name, @Param("c") String city);

	////Native Query...
	
	@Query(value= "select * from Student", nativeQuery = true)
	public List<Student> getStudent();
	
}
