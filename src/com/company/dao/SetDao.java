package com.company.dao;

import com.company.domain.Set;

public interface SetDao {

    public Set findById(String testNo);
    public void create(String testNo,int year,boolean sem,String tea_id,String c_id);

}
