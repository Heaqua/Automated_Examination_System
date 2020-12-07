package com.company.dao;
import java.sql.*;
import oracle.jdbc.driver.*;

import com.company.dao.sqlplus.TestApplication;
public class Retrieve {
    // Static methods are for statements. non-static methods are for prepared statements.
    // You can create a Retrieve instance and use it as a prepared statement.
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

    public Retrieve(String prepared) throws SQLException {
        preStmt = conn.prepareStatement(prepared);
        return;
    }

}
