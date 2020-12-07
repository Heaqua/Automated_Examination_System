package com.company.dao;
import java.sql.*;
import oracle.jdbc.driver.*;

import com.company.dao.sqlplus.TestApplication;
public class Retrieve {
    public static Statement stmt;
    public PreparedStatement preStmt;
    public static OracleConnection conn = TestApplication.conn;

    static {
        try {
            stmt = conn.createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static ResultSet retrieve(String sql) throws SQLException {
        ResultSet rset = stmt.executeQuery(sql);
        return rset;
    }

    public Retrieve(String prepared){

        return;
    }
}
