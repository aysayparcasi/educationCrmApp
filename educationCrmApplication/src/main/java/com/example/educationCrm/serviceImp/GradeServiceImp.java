package com.example.educationCrm.serviceImp;

import com.example.educationCrm.helper.ModelMapperHelper;
import com.example.educationCrm.model.dto.GradeDTO;
import com.example.educationCrm.model.dto.GradeFilterLessonDTO;
import com.example.educationCrm.model.entity.Grade;
import com.example.educationCrm.model.entity.Student;
import com.example.educationCrm.model.entity.Teacher;
import com.example.educationCrm.repository.GradeRepository;
import com.example.educationCrm.repository.LessonRepository;
import com.example.educationCrm.repository.StudentRepository;
import com.example.educationCrm.repository.TeacherRepository;
import com.example.educationCrm.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/*
    Rest Template detayı için :
    https://www.baeldung.com/rest-template
    https://www.baeldung.com/spring-resttemplate-json-list
 */
@Service
public class GradeServiceImp implements GradeService {
    @Autowired
    private GradeRepository gradeRepository;

    @Transactional
    @Override
    public void update(Grade grade) {
        this.gradeRepository.save(grade);

    }

    @Transactional
    @Override
    public void save(Grade grade) {
        this.gradeRepository.save(grade);
    }

    @Transactional
    @Override
    public void delete(Grade grade) {
       this.gradeRepository.delete(grade);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Grade> findAll() {
       return (List<Grade>) this.gradeRepository.findAll();
    }




}
