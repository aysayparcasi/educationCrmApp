package com.example.educationCrm.model.entity;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@Where(clause = "is_active=true")
@SQLDelete(sql = "update grade set is_active=false where id=?")
public class Grade extends BaseEntity{

    private Double grade;
    @ManyToOne
    private Student student;
    @ManyToOne
    private Teacher teacher;

    private Boolean isActive;

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }
}
