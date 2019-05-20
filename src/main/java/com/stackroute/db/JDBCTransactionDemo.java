package com.stackroute.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBCTransactionDemo {

    public void jdbcTransactionDemo() {
        Connection con;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded");
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/customerdb", "root", "Root@123");
            System.out.println("got connected");
            con.setAutoCommit(false);
            Statement stmt = con.createStatement();
            stmt.executeUpdate("insert into customer values(5,'Jaskiran','female','student')");
            System.out.println("Added Records succesfully");
            // stmt.executeUpdate("insert into customer values(5, 'Uday' ,'Male');
            con.commit();
            con.close();
        } catch (Exception e) {

            System.out.println(e);
        }
    }
}
