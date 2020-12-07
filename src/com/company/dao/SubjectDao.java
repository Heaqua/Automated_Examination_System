package com.company.dao;

import com.company.domain.Subject;

public interface SubjectDao {

    public Subject findById(String id);
    public Subject findByTeaClaId(String teaId,String classId);

}
