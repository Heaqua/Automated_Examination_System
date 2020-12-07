package com.company.dao.sqlplus;

import java.io.*;
import java.sql.*;
import oracle.jdbc.driver.*;

// java -cp ojdbc7.jar:. com.company.TestApplication
public class TestApplication
{
    public static OracleConnection conn;
    public static void testApplication() throws SQLException, IOException
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

        //System.out.println(new Student("S180101").login("123456"));
        conn.close();
    }
}
