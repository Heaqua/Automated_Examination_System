package com.company.dao;

import com.company.domain.Set;

public interface SetDao {

    public Set findById(String testNo);
    public Set[] findByTeaId(String teaId);
    public void create(String testNo,short year,boolean sem,String tea_id,String c_id);

}
