package com.company.dao;

import com.company.domain.Exam;
import com.company.domain.Student;
import com.company.domain.Subject;

public interface StudentDao {
    public Student findById(String id);
    public Subject[] findAllSubjects(Student student);
    public Exam[] findAllExams(Student student);
}
