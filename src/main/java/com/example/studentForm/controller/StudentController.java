package com.example.studentForm.controller;

import com.example.studentForm.model.Student;
import com.example.studentForm.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    //////////////////////////////////////////////////////////////////

    // Page to list all Students
    @GetMapping(value = "/students")
    public String getAllUsers(Model model) {
        model.addAttribute("students", studentService.getAllStudent());
        return "list_students";
    }

    //////////////////////////////////////////////////////////////////

    // Page to add a new Student !
    @GetMapping(value = "/students/add")
    public String createNewStudent(Model model){
        Student student = new Student();
        model.addAttribute("student", student);
        return "etudiantForm";
    }
    // Method to handler a new Student's values
    @PostMapping("/students")
    public String saveStudent(@ModelAttribute("student") Student student) {
        studentService.addNewStudent(student);
        return "redirect:/students";
    }

    /////////////////////////////////////////////////////////////////////

    // Page to update a Student !
    @GetMapping(value = "/student/edit/{id}")
    public String getStudentById (@PathVariable Long id, Model model) {
        model.addAttribute("student", studentService.getStudentById(id));
        return "edit_student";
    }

    // Method to edit a exist Student
    @PostMapping(value = "/students/{id}")
    public String updateStudent(@PathVariable Long id, @ModelAttribute("student") Student student) {
        Student existingStudent = studentService.getStudentById(id);

        existingStudent.setId(id);
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setEmail(student.getEmail());
        existingStudent.setUniversity(student.getUniversity());

        studentService.updateStudent(existingStudent);

        return "redirect:/students";
    }

    /////////////////////////////////////////////////////////////////////

    // Method to delete a student !
    @GetMapping(value = "/student/delete/{id}")
    public String deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
        return "redirect:/students";
    }

}
