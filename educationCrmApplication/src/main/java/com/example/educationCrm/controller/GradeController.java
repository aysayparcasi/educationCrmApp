package com.example.educationCrm.controller;

import com.example.educationCrm.model.entity.Grade;
import com.example.educationCrm.model.entity.Student;
import com.example.educationCrm.model.entity.Teacher;
import com.example.educationCrm.service.GradeService;
import com.example.educationCrm.service.StudentClassService;
import com.example.educationCrm.service.StudentService;
import com.example.educationCrm.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.util.List;

@Controller
@Scope(value = "view")
public class GradeController {
    private Grade grade;

    private Grade selectedGrade;

    private List<Grade> gradeList;

   private List<Student> studentList;

   private List<Teacher> teacherList;

   @Autowired
   private GradeService gradeService;

   @Autowired
   private StudentService studentService;

   @Autowired
   private TeacherService teacherService;

   @PostConstruct
   public void init(){
       this.grade = new Grade();
       this.gradeList = gradeService.findAll();
       this.studentList = studentService.findAll();
       this.teacherList = teacherService.findAll();
   }
   public void save(){
       this.gradeService.save(this.grade);
       infoMessage("Not Kaydedildi",
               "Kaydedilen Not : ", this.grade);
   }
    public void infoMessage(String summary, String detail, Grade grade) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null,
                new FacesMessage(summary,
                        detail + grade.getGrade()));
    }

    public void update(Grade grade){
       this.gradeService.update(this.selectedGrade);
       infoMessage("Not Güncellendi",
               "Güncellenen Not : ", this.selectedGrade);
       this.selectedGrade = new Grade();
    }
    public void delete(Grade grade){
       this.gradeService.delete(grade);
       infoMessage("Not Silindi ", "Silinen Not : " ,grade);
       this.gradeList.remove(grade);
    }

    public void selectGrade(Grade grade){
       this.selectedGrade = grade;
    }

}
