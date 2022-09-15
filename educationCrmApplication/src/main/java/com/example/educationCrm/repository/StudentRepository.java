package com.example.educationCrm.repository;

import com.example.educationCrm.model.dto.StudentInformationDTO;
import com.example.educationCrm.model.entity.Student;
import com.example.educationCrm.serviceImp.StudentServiceImp;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository
        extends CrudRepository<Student,Long> {
    /*interface StudentInformation{
        public String getName();
        public String getSurname();
    }*/

    StudentInformationDTO getStudentById(Long id);
    List<StudentInformationDTO> findStudentBySchoolName
            (String schoolName);

    Student findStudentByName(String name);

}
