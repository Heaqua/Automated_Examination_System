package com.company.dao;
import com.company.domain.Class1;
import com.company.domain.Subject;
import com.company.domain.Teacher;

public interface TeacherDao {
    public Teacher findById(String id);
    public Subject[] findAllSubjects(Teacher teacher);
    public Class1[] findAllClasses(Teacher teacher);

}
