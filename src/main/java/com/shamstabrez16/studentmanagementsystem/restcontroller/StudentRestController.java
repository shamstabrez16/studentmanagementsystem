package com.shamstabrez16.studentmanagementsystem.restcontroller;


import com.shamstabrez16.studentmanagementsystem.dto.StudentDto;
import com.shamstabrez16.studentmanagementsystem.model.Student;
import com.shamstabrez16.studentmanagementsystem.service.StudentService;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    private final StudentService studentService;

    @Autowired
    public StudentRestController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<StudentDto>> listStudents() {
        try {
            List<Student> students = studentService.getAllStudents();
            List<StudentDto> studentDtos = students.stream().map(student -> {
                StudentDto dto = new StudentDto();
                dto.setId(student.getId());
                dto.setFirstName(student.getFirstName());
                dto.setLastName(student.getLastName());
                return dto;
            }).toList();
            if (!students.isEmpty()) {
                return ResponseEntity.ok(studentDtos);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return ResponseEntity.internalServerError().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> viewStudent(@PathVariable @NotNull Long id) {
        Student student = studentService.getStudentById(id);
        if (student != null) {
            StudentDto dto = StudentDto.builder()
                    .firstName(student.getFirstName())
                    .lastName(student.getLastName())
                    .id(student.getId()).build();
            return ResponseEntity.ok(dto);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/create")
    public ResponseEntity<StudentDto> createStudent(@RequestBody StudentDto student) {
        try {
            Student student1 = Student.builder()
                    .firstName(student.getFirstName())
                    .lastName(student.getLastName()).build();
            Student s = studentService.saveStudent(student1);
            student.setId(s.getId());
            return ResponseEntity.ok(student);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable @NotNull Long id) {
        try{
            Optional<Student> deletedStudent =  studentService.deleteStudent(id);
            return ResponseEntity.ok("Deleted ");
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return ResponseEntity.badRequest().build();
    }
}
