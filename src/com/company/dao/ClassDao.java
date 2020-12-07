package com.company.dao;

import com.company.domain.Class1;
import com.company.domain.Student;

public interface ClassDao {

    public Class1 findById(String id);
    public Student[] allStudents(Class1 class1);
   // public void create(String c_id, String instructor_id);


}
