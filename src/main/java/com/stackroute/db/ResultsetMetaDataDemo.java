package com.stackroute.db;

import java.sql.*;

public class ResultsetMetaDataDemo {

    Connection con;
    public  void resultSetMetaDataDemo(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded");//create connection
            con= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/customerdb","root","Root@123");
            System.out.println("got connected");
            PreparedStatement ps=con.prepareStatement("select * from customer");
            ResultSet rs=ps.executeQuery();
            ResultSetMetaData rsmd=rs.getMetaData();

            System.out.println("Total columns: "+rsmd.getColumnCount());
            System.out.println("Column Name of 1st column: "+rsmd.getColumnName(1));
            System.out.println("Column Type Name of 1st column: "+rsmd.getColumnTypeName(1));
            con.close();
        }catch(Exception e){ System.out.println(e);}
    }
}
