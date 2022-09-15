package com.example.educationCrm.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="studentLevel")
/*@NamedEntityGraph(name = "StudentClass.detail",
        attributeNodes = @NamedAttributeNode("students"))*/
public class StudentClass extends  BaseEntity{

    private String name;
    @JsonIgnore
    @OneToMany(mappedBy = "studentClass",fetch = FetchType.EAGER)
    private List<Student> students;
    @ManyToMany
    private List<Teacher> teachers;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }
}
