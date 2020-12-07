package com.company.domain;

import com.company.dao.sqlplus.TestApplication;
import oracle.jdbc.driver.OracleConnection;
import java.math.BigDecimal;
import java.sql.*;

public class Student extends People {
    private String c_id;

    public String getC_id() {
        return c_id;
    }

    public void setC_id(String c_id) {
        this.c_id = c_id;
    }
}