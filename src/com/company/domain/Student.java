package com.company.domain;

import com.company.dao.sqlplus.TestApplication;
import oracle.jdbc.driver.OracleConnection;
import java.math.BigDecimal;
import java.sql.*;

public class Student extends People {

    private String classId;

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getClassId() {
        return classId;
    }
}