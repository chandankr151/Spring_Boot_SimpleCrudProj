package com.springboot.crud;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.springboot.crud.dao.StudentRepository;
import com.springboot.crud.entities.Student;

@SpringBootApplication
public class SpringbootCrudApplication {

	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringbootCrudApplication.class, args);

		StudentRepository studentRepository = context.getBean(StudentRepository.class);

		/// Crud in Spring Boot standAlone application

/// Create Operation
//		Student student1 = new Student();
//		student1.setName("Chandan Kumar");
//		student1.setCity("Noida");
//		studentRepository.save(student1);
//		System.out.println("Student added successfully.");
//
//		Student student2 = new Student();
//		student2.setName("Shashi Kumar");
//		student2.setCity("Delhi");
//
//		try {
//			studentRepository.save(student2);
//			System.out.println("Student added successfully.");
//		}catch(Exception e) {
//			System.out.println("Error!!!\nStudent could not inserted.\nCheck it.");
//		}

///===================================================

/// One Record Read operation.
		int id;

		System.out.println("Enter Student id to get student from database: ");
		id = s.nextInt();

		try {
			Optional<Student> studentRecord = studentRepository.findById(id);
			if(studentRecord.isEmpty()) {
				System.out.println("Student with given Id does not exists.\nTry Again.");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}

///========================================================

/// Read All record from database.
//		Iterable<Student> allRecord = studentRepository.findAll();
//
//		Iterator<Student> itr = allRecord.iterator();
//		System.out.println("Total Available Student in database: ");
//		while (itr.hasNext()) {
//			System.out.println(itr.next());
//		}

		/// displaying all records using java 8 advance features. pridicate.

//		Iterable<Student> data = studentRepository.findAll();
//
//		data.forEach(student -> {
//			System.out.println(student);
//		});

///==============================================================
		/// Update Operation:

//		int id;
//		System.out.println("Enter Student id to update: ");
//		id = s.nextInt();
//		s.nextLine();
//		System.out.println("Enter New Name: ");
//		String newName = s.nextLine();
//
//		System.out.println("Enter New City: ");
//		String newCity = s.nextLine();
//
//		Optional<Student> record = studentRepository.findById(id);
//		Student student = record.get();
//		student.setName(newName);
//		student.setCity(newCity);
//
//		studentRepository.save(student);
//		System.out.println("Student update successfully");

		/// =============================
		//// Delete Operation

//		int id;
//		System.out.print("Enter Student Id to delete: ");
//		id = s.nextInt();
//		studentRepository.deleteAll();
//		System.out.println("All record deleted successfully");

////==============================================================================
		/// Get record from data base using derived methods.

//		Student byCity = studentRepository.findByCity("Noida");
//		System.out.println(byCity);
//------------------------------------
		/// finding data based on NameAndCity...

//		List<Student> userByName = studentRepository.getUserByName("chandan");
//
//		userByName.forEach(student -> {
//			System.out.println("StudentId: " + student.getId());
//			System.out.println("StudentName: " + student.getName());
//			System.out.println("StudentCity: " + student.getCity());
//			System.out.println("-----------------------------------");
//		});
///-------------------------------------

//		Student userByNameAndCity = studentRepository.getUserByNameAndCity("chandan", "Noida");
//		System.out.println(userByNameAndCity);

//		List<Student> student = studentRepository.getStudent();
//		student.forEach(student2 -> {
//			System.out.println(student2);
//			System.out.println("------------------");
//		});
	}
}