package com.company.dao;

import com.company.domain.Exam;
import com.company.domain.Student;
import com.company.domain.Subject;

import java.sql.ResultSet;

public interface StudentDao {
    public Student findById(String id);
    public Subject[] allSubjects(Student student);
    public Exam[] allExams(Student student);
    public Student[] findByCId(String cId);
}
