package com.company;

import com.company.view.GUI.OriginalLoginPage;
import java.io.*;
import java.sql.*;
import oracle.jdbc.driver.*;
import oracle.sql.*;

public class Application
{
    public static void main(String args[]) throws SQLException, IOException
    {
        new OriginalLoginPage();
        String username, password;
        username = "\"19079968d\"";			// Your Oracle Account ID
        password = "fyntaioc"; 		// Password of Oracle Account

        // Connection
        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
        OracleConnection conn =
                (OracleConnection)DriverManager.getConnection(
                        "jdbc:oracle:thin:@studora.comp.polyu.edu.hk:1521:dbms",
                        username, password);
        Statement stmt = conn.createStatement();
        ResultSet rset = stmt.executeQuery("SELECT EMPNO, ENAME, JOB FROM EMP");
        while (rset.next())
        {
            System.out.println(rset.getInt(1)
                    + " " + rset.getString(2)
                    + " " + rset.getString(3));
        }
        System.out.println();

        conn.close();

    }
}


