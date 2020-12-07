package com.company;

import java.io.*;
import java.sql.*;
import oracle.jdbc.driver.*;
import oracle.sql.*;

import com.company.model.*;

public class TestApplication
{
    public static OracleConnection conn;
    public static void main(String args[]) throws SQLException, IOException
    {
        String username, password;
        username = "\"18080915d\"";			// Your Oracle Account ID
        password = "jephoufg"; 		// Password of Oracle Account

        // Connection
        System.out.println("Before connection");
        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
        conn =
                (OracleConnection)DriverManager.getConnection(
                        "jdbc:oracle:thin:@studora.comp.polyu.edu.hk:1521:dbms",
                        username, password);
        Statement stmt = conn.createStatement();
        System.out.println("After connection");
        ResultSet rset = stmt.executeQuery("SELECT INSTRUCTORNO, INSTRUCTORNAME, INSTRUCTORPHONE FROM INSTRUCTOR");
        while (rset.next())
        {
            System.out.println(rset.getInt(1) + " " + rset.getString(2) + " " + rset.getInt(3));
        }
        System.out.println();
        System.out.println(new Student("S180101").login("123456"));
        conn.close();
    }
}
