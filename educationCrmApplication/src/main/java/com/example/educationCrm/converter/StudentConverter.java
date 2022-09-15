package com.example.educationCrm.converter;

import com.example.educationCrm.model.entity.Student;
import com.example.educationCrm.model.entity.Teacher;
import com.example.educationCrm.serviceImp.StudentServiceImp;
import com.example.educationCrm.serviceImp.TeacherServiceImp;
import org.springframework.stereotype.Component;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@Component
@FacesConverter(value = "studentConverter")
public class StudentConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component,
                              String value) {

        if (value == null || value.equals("")) {
            return null;
        }
        StudentServiceImp studentServiceImp = context.getApplication()
                .evaluateExpressionGet(context, "#{studentServiceImp}"
                        , StudentServiceImp.class);
        return studentServiceImp.findByName(value);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value instanceof Student) {
            return ((Student) value).getName();
        }
        return "";
    }
}
