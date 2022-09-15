package com.example.educationCrm.model.dto;

import java.util.List;

public class TeacherStudentDTO {
    Long teacherId;
    List<Long> studentIds;

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    public List<Long> getStudentIds() {
        return studentIds;
    }

    public void setStudentIds(List<Long> studentIds) {
        this.studentIds = studentIds;
    }
}
