package com.company.dao;

import com.company.domain.Set;

public interface SetDao {

    public Set findById(String testNo);
    public void create(String testNo,int year,int sem,String tea_id,String c_id);
    public void deleteSete(String testId);
    public Set findByTeaId(String teaId);
}
