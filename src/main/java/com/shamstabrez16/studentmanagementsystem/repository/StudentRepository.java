package com.shamstabrez16.studentmanagementsystem.repository;

import com.shamstabrez16.studentmanagementsystem.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
    // Add custom query methods if needed
}
