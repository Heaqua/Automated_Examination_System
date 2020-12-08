package com.company.dao;

import com.company.domain.Subject;

public interface SubjectDao {

    public Subject findById(String id);
    public Subject findByTeaClaId(short year,boolean sem,String teaId,String classId);

}
