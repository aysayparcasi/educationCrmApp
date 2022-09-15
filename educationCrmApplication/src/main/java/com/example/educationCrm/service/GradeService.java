package com.example.educationCrm.service;

import com.example.educationCrm.model.dto.GradeDTO;
import com.example.educationCrm.model.dto.GradeFilterLessonDTO;
import com.example.educationCrm.model.entity.Grade;
import com.example.educationCrm.serviceImp.GradeServiceImp;

import java.util.List;

public interface GradeService {
    public void update(Grade grade);
    public void save(Grade grade);
    public void delete(Grade grade);
    public List<Grade> findAll();



  //  public List<Object>getGradesByLessonName(String lessonName);
   // public List<GradeFilterLessonDTO>getGradesByLessonNameWithDerived(String lessonName);
   // public List<GradeDTO> getEntegrationGrade();
}
