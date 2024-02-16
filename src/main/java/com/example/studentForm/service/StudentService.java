package com.example.studentForm.service;

import com.example.studentForm.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudent();
    void addNewStudent (Student student);

    Student getStudentById(Long id);

    void updateStudent(Student student);

    void deleteStudent(Long id);

}
