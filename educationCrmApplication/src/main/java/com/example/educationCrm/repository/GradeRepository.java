package com.example.educationCrm.repository;

import com.example.educationCrm.model.entity.Grade;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GradeRepository
        extends CrudRepository<Grade,Long> {
    @Query(value = "select g.grade,s.name,s.surname" +
            ",l.name as lessonName from grade g" +
            " left join student s on s.id = g.student_id" +
            " left join teacher t on t.id = g.teacher_id" +
            " left join lesson l on t.lesson_id = l.id" +
            " where" +
            " l.name=:lessonName",nativeQuery = true)
    List<Object> getGradesByLessonName(String lessonName);

    List<Grade> findGradeByTeacher_LessonName(String lessonName);


}
