package com.stackroute.db;

import com.sun.rowset.JdbcRowSetImpl;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.Connection;
import java.sql.DriverManager;

public class RowsetDemo {

    Connection con;
    //Demo of Connected Rowset
    public void rowSetDemo() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded");//create connection
            //Creating and Executing RowSet
            JdbcRowSet rowSet = RowSetProvider.newFactory().createJdbcRowSet();
            // JdbcRowSetImpl rowSet = new JdbcRowSetImpl(con);
            rowSet.setUrl("jdbc:mysql://localhost:3306/customerdb");
            rowSet.setUsername("root");
            rowSet.setPassword("Root@123");
            rowSet.setCommand("select * from customer");
            rowSet.execute();

            while (rowSet.next()) {
                // Generating cursor Moved event
                System.out.println("Id: " + rowSet.getString(1));
                System.out.println("Name: " + rowSet.getString(2));
                System.out.println("Gender: " + rowSet.getString(3));
            }

        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
//Demo of Disconnected Rowset;

