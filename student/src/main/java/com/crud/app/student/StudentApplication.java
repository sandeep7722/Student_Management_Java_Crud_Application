package com.crud.app.student;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.sql.*;

@SpringBootApplication
public class StudentApplication {

	public static void main(String[] args) {

		SpringApplication.run(StudentApplication.class, args);

		StudentDAO studentDAO=new StudentDAO();

		//create student
		Student student=new Student(6,"kk",20,"js");
		studentDAO.createStudent(student);

		//read student
		studentDAO.getStudent(3);

		//update student
		student.setAge(27);
		studentDAO.updateStudent(student);

		//delete student
		studentDAO.deleteStudent(5);



	}

}
