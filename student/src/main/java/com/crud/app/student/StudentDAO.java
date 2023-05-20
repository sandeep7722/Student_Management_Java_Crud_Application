package com.crud.app.student;

import java.sql.*;

public class StudentDAO {
    //create student method
    public void createStudent(Student student)
    {
        String query="INSERT INTO first_db.students (roll_no,name,age,course) VALUES (?,?,?,?)";

        try( Connection connection=DatabaseConnection.getConnection();
             PreparedStatement statement=connection.prepareStatement(query)){
            statement.setInt(1,student.getRoll_no());
            statement.setString(2,student.getName());
            statement.setInt(3,student.getAge());
            statement.setString(4,student.getCourse());

            statement.executeUpdate();
            System.out.println("Student created successfully");

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
    //get student method
    public void getStudent(int roll_no)
    {
        String query="SELECT * FROM first_db.students WHERE roll_no=?";
        try(Connection connection=DatabaseConnection.getConnection();
            PreparedStatement statement=connection.prepareStatement(query))
        {
            statement.setInt(1,roll_no);
            ResultSet resultSet=statement.executeQuery();
            if(resultSet.next())
            {
                int rollNo=resultSet.getInt("roll_no");
                String name=resultSet.getString("name");
                int age=resultSet.getInt("age");
                String course=resultSet.getString("course");

                Student student=new Student(rollNo,name,age,course);
                System.out.println(student);

            }
            else {
                System.out.println("Student not found.");
            }

        }catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    //update student method
    public void updateStudent(Student student)
    {
        String query="UPDATE first_db.students SET name=?,age=?,course=? WHERE roll_no=?";
        try(Connection connection=DatabaseConnection.getConnection();
            PreparedStatement statement=connection.prepareStatement(query);
        )
        {
            statement.setString(1,student.getName());
            statement.setInt(2,student.getAge());
            statement.setString(3,student.getCourse());
            statement.setInt(4,student.getRoll_no());

            int rowsAffected=statement.executeUpdate();
            if (rowsAffected>0)
            {
                System.out.println("student updated successfully.");
            }
            else {
                System.out.println("student not found!");
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
    //delete student method
    public void deleteStudent(int roll_no)
    {
        String query="DELETE FROM first_db.students WHERE roll_no=?";
        try(Connection connection=DatabaseConnection.getConnection();
            PreparedStatement statement=connection.prepareStatement(query);
        )
        {
            statement.setInt(1,roll_no);
            int rowsAffected=statement.executeUpdate();

            if (rowsAffected>0)
            {
                System.out.println("student delete successfully.");
            }
            else {
                System.out.println("student not found.");
            }

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}
