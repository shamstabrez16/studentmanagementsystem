package com.shamstabrez16.studentmanagementsystem.controller;

import com.shamstabrez16.studentmanagementsystem.dto.StudentDto;
import com.shamstabrez16.studentmanagementsystem.model.Student;
import com.shamstabrez16.studentmanagementsystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/all")
    public String listStudents(Model model) {
        List<Student> students = studentService.getAllStudents();
        model.addAttribute("students", students);
        return "list";
    }

    @GetMapping("/{id}")
    public String viewStudent(@PathVariable Long id, Model model) {
        Student student = studentService.getStudentById(id);
        model.addAttribute("student", student);
        return "view";
    }
    @GetMapping("/create")
    public String showStudentForm(Model model) {
        model.addAttribute("student", new Student());
        return "create";
    }

    @PostMapping("/create")
    public String createStudent(@ModelAttribute StudentDto student) {
        Student student1 = Student.builder()
                .firstName(student.getFirstName())
                .lastName(student.getLastName()).build();
        studentService.saveStudent(student1);
        return "redirect:/students/all";
    }

    @PostMapping("/{id}")
    public String deleteStudent(@PathVariable Long id, Model model) {
         studentService.deleteStudent(id);
        return "redirect:/students/all";
    }
}
