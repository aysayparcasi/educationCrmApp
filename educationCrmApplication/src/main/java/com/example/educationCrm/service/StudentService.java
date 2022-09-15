package com.example.educationCrm.service;

import com.example.educationCrm.model.dto.StudentDTO;
import com.example.educationCrm.model.dto.StudentInformationDTO;
import com.example.educationCrm.model.dto.TeacherStudentDTO;
import com.example.educationCrm.model.entity.Student;
import com.example.educationCrm.model.entity.Teacher;

import java.text.ParseException;
import java.util.List;

public interface StudentService {
    void save(Student student);
    void update(Student student);
    void delete(Student student);
    List<Student> findAll();

    public Student findByName(String name);



}
