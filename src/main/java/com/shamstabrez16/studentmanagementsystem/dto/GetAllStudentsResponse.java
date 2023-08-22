package com.shamstabrez16.studentmanagementsystem.dto;

import com.shamstabrez16.studentmanagementsystem.model.Student;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetAllStudentsResponse")
public class GetAllStudentsResponse {
    @XmlElement(name = "student")
    private List<Student> students = new ArrayList<>();

    public List<Student> getStudents() {
        return students;
    }
}
