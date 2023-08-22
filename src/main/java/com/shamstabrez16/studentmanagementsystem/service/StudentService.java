package com.shamstabrez16.studentmanagementsystem.service;

import com.shamstabrez16.studentmanagementsystem.model.Student;
import com.shamstabrez16.studentmanagementsystem.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    List<Student> getAllStudents();
    Student getStudentById(Long id);
    Student saveStudent(Student student);
    Optional<Student> deleteStudent(Long id);
}

