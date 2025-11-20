package com.example.student_registration.controller;

import com.example.student_registration.entity.Student;
import com.example.student_registration.repository.StudentRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// MAIN CONTROLLER FOR ROOT URL
@Controller
class MainController {
    @GetMapping("/")
    public String rootHome() {
        return "home";       // your main link → home.html
    }
}

@Controller
@RequestMapping("/students")
public class StudentController {

    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // HOME PAGE inside students (optional)
    @GetMapping("/home")
    public String homePage() {
        return "home";
    }

    @GetMapping("/list")
    public String listStudents(Model model) {
        List<Student> allStudents = studentRepository.findAll();
        model.addAttribute("students", allStudents);
        return "studentsList";
    }

    @GetMapping("/api")
    @ResponseBody
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @GetMapping("/form")
    public String showForm(Model model) {
        model.addAttribute("student", new Student());
        return "studentForm";
    }

    @PostMapping("/save")
    public String submitForm(@ModelAttribute Student student, Model model) {
        studentRepository.save(student);
        model.addAttribute("message", "Student registered successfully!");
        model.addAttribute("student", new Student());
        return "studentForm";
    }
}
