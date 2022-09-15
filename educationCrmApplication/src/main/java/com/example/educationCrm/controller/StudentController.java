package com.example.educationCrm.controller;

import com.example.educationCrm.model.entity.School;
import com.example.educationCrm.model.entity.Student;
import com.example.educationCrm.model.entity.StudentClass;
import com.example.educationCrm.model.entity.Teacher;
import com.example.educationCrm.service.SchoolService;
import com.example.educationCrm.service.StudentClassService;
import com.example.educationCrm.service.StudentService;
import jdk.internal.dynalink.linker.LinkerServices;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.util.List;

@Controller
@Scope(value = "view")
@Getter
@Setter
public class StudentController {

    private Student student;

    private Student selectedStudent;

    private List<Student> studentList;

    private List<School> schoolList;

    private List<StudentClass> studentClassList;

    @Autowired
    private StudentService studentService;

    @Autowired
    private SchoolService schoolService;

    @Autowired
    private StudentClassService studentClassService;

    @PostConstruct
    public void init(){
        this.student = new Student();
        this.studentList = studentService.findAll();
        this.schoolList = schoolService.findAll();
        this.studentClassList = studentClassService.findAll();
    }

    public void save(){
        this.studentService.save(this.student);
        this.studentList.add(student);
        infoMessage("Öğrenci Kaydedildi",
                "Kaydedilen Öğrenci : ",this.student);
        this.student = new Student();
    }
    public void infoMessage(String summary, String detail, Student student) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null,
                new FacesMessage(summary,
                        detail + student.getName()));
    }

    public void delete(Student student){
        this.studentService.delete(student);
        infoMessage("Öğrenci Silindi",
                "Silinen Öğrenci : ", student);
        this.studentList.remove(student);
    }

    public void update(){
        this.studentService.update(this.selectedStudent);
        infoMessage("Güncellendi",
                "Güncellenen Öğrenci",this.selectedStudent);
        this.selectedStudent = new Student();
    }

    public void selectStudent(Student student){
        this.selectedStudent = student;
    }

}
