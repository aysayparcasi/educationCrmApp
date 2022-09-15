package com.example.educationCrm.repository;

import com.example.educationCrm.model.entity.Lesson;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LessonRepository
        extends CrudRepository<Lesson,Long> {
    public Lesson findLessonByName(String name);
}
