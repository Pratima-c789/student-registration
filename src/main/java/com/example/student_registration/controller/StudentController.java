package com.example.student_registration.controller;

import com.example.student_registration.entity.Student;
import com.example.student_registration.repository.StudentRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {

    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // -----------------------------------------
    // 1) HOME PAGE
    // -----------------------------------------
    @GetMapping("/home")
    public String homePage() {
        return "home";   // loads home.html
    }

    // -----------------------------------------
    // 2) STUDENT LIST PAGE
    // -----------------------------------------
    @GetMapping("/list")
    public String listStudents(Model model) {
        List<Student> allStudents = studentRepository.findAll();
        model.addAttribute("students", allStudents);
        return "studentsList";   // loads studentsList.html
    }

    // -----------------------------------------
    // 3) REST API to get all students (JSON)
    // -----------------------------------------
    @GetMapping("/api")
    @ResponseBody
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // -----------------------------------------
    // 4) SHOW STUDENT REGISTRATION FORM
    // -----------------------------------------
    @GetMapping("/form")
    public String showForm(Model model) {
        model.addAttribute("student", new Student());
        return "studentForm";   // loads studentForm.html
    }

    // -----------------------------------------
    // 5) PROCESS STUDENT FORM SUBMISSION
    // -----------------------------------------
    @PostMapping
    public String submitForm(@ModelAttribute Student student, Model model) {
        studentRepository.save(student);
        model.addAttribute("message", "Student registered successfully!");
        model.addAttribute("student", new Student()); // resets form
        return "studentForm";  
    }

}
