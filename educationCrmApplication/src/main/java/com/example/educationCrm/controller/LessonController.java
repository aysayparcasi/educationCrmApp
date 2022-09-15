package com.example.educationCrm.controller;

import com.example.educationCrm.model.entity.Lesson;
import com.example.educationCrm.model.entity.School;
import com.example.educationCrm.model.entity.Student;
import com.example.educationCrm.model.entity.Teacher;
import com.example.educationCrm.service.LessonService;
import com.example.educationCrm.service.StudentService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.util.ArrayList;
import java.util.List;

@Controller
@Scope(value = "view")
@Getter
@Setter
public class LessonController {

    private List<Student> students;
    private List<Student> selectedStudents;


    private Lesson lesson;
    private Lesson selectedLesson;

    private List<Lesson> lessonList;
    @Autowired
    private LessonService lessonService;

    @Autowired
    private StudentService studentService;

    @PostConstruct
    public void init(){
        this.lesson = new Lesson();
        this.lessonList = lessonService.findAll();
        this.selectedStudents = studentService.findAll();
    }

    public void save (){
        this.lessonService.save(this.lesson);
        infoMessage("Kaydedildi",
                "Kaydedilen Ders : ",this.lesson);
        this.lessonList.add(lesson);
        this.lesson = new Lesson();
    }

    public void delete(Lesson lesson){
        this.lessonService.delete(lesson);
        infoMessage("Silindi.",
                "Silinen Ders : ",lesson);
        this.lessonList.remove(lesson);
    }

    public void update(){
        this.lessonService.update(this.selectedLesson);
        infoMessage("Güncellendi.",
                "Güncellenen Ders : ",this.selectedLesson);
        this.selectedLesson = new Lesson();
    }

    public void selectLesson(Lesson lesson){
        this.selectedLesson =lesson;
    }

    public void assignStudent(){
        this.selectedLesson.setStudents(this.selectedStudents);
        this.lessonService.save(this.selectedLesson);
        infoMessage("Atama tamamlandı. ", "Atama yapılan ders : ", this.selectedLesson);
        this.selectedLesson = new Lesson();
        this.selectedStudents = new ArrayList<>();
    }

    public void infoMessage(String summary, String detail, Lesson lesson) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null,
                new FacesMessage(summary,
                        detail + lesson.getName()));
    }
}
