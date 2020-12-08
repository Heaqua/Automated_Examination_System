package com.company.dao.sqlplus;

import com.company.dao.TeachDao;
import com.company.domain.Teacher;
import oracle.jdbc.driver.OracleConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TeachDaoImp implements TeachDao {
    static OracleConnection conn = TestApplication.conn;
    static PreparedStatement findTea;

    static{
        try {
            findTea = conn.prepareStatement("SELECT TEA_NAME, TEA_PWD FROM TEACHER WHERE TEA_ID = ?");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public Teacher findById(String tea_id) {
        Teacher teacher = null;
        try {
            findTea.setString(1, tea_id);
            ResultSet rs = findTea.executeQuery();
            rs.next();
            String name = rs.getString(1);
            String pwd = rs.getString(2);
            teacher = new Teacher(tea_id, name, pwd);
            return teacher;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
