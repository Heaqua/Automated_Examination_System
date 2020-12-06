package com.company.controller.commands;
import java.io.*;
import java.sql.*;
import oracle.jdbc.driver.*;
import oracle.sql.*;

import com.company.Application;
public class Retrieve {
    public static Statement stmt;
    public PreparedStatement preStmt;
    public static OracleConnection conn = Application.conn;

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
