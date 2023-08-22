package com.shamstabrez16.studentmanagementsystem.service;

import com.shamstabrez16.studentmanagementsystem.model.Student;
import com.shamstabrez16.studentmanagementsystem.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }
    @Override
    public Optional<Student> deleteStudent(Long id) {
       studentRepository.deleteById(id);
        return studentRepository.findById(id);
    }
}