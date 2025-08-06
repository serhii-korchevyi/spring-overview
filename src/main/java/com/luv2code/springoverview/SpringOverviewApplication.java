package com.luv2code.springoverview;

import com.luv2code.springoverview.dao.StudentDAO;
import com.luv2code.springoverview.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

/*@SpringBootApplication(
		scanBasePackages = {"com.luv2code.springoverview",
		"com.luv2code.util"}
)*/
@SpringBootApplication
public class SpringOverviewApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringOverviewApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			// createStudent(studentDAO);
			createMultipleStudents(studentDAO);
			// readStudent(studentDAO);

			// queryForStudents(studentDAO);
			// queryForStudentsByLastName(studentDAO);

			// updateStudent(studentDAO);

			// deleteStudent(studentDAO);
			// deleteAll(studentDAO);
		};
	}

	private void deleteAll(StudentDAO studentDAO) {
		int deletedRows = studentDAO.deleteAll();
		System.out.println("deleted rows: " + deletedRows);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 7;
		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {
		int studentId = 1;
		Student student = studentDAO.findById(studentId);

		student.setFirstName("Scooby");

		studentDAO.update(student);

		System.out.println("Updated student: " + student);
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		List<Student> students = studentDAO.findByLastName("Public");

		for (Student tempStudent : students) {
			System.out.println(tempStudent);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
		List<Student> students = studentDAO.findAll();

		for (Student tempStudent : students) {
			System.out.println(tempStudent);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		Student tempStudent = new Student("Daffy", "Duck", "daffy@lub2code.com");

		studentDAO.save(tempStudent);

		int id = tempStudent.getId();

		Student myStudent = studentDAO.findById(id);

		System.out.println("Found the student: " + myStudent);
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		Student tempStudent1 = new Student("John", "Doe", "john@luv2code.com");
		Student tempStudent2 = new Student("Mary", "Public", "mary@luv2code.com");
		Student tempStudent3 = new Student("Bonita", "Applebum", "bonita@luv2code.com");

		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
	}

	private void createStudent(StudentDAO studentDAO) {
		// create the student object
		System.out.println("createStudent");
		Student tempStudent = new Student("Paul", "Doe", "paul@luv2code.com");

		// save the student object
		System.out.println("saveStudent");
		studentDAO.save(tempStudent);

		// display id of the saved student
		System.out.println("Save student. Generated id: " + tempStudent.getId());

		Student student = studentDAO.findById(tempStudent.getId());
		System.out.println("Find student by id: " + student);
	}

}
