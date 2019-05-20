package com.stackroute.db;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class JDBCBatchProcessingDemo {
    Connection con;
    public void jdbcBatchProcessingDemo(){

    try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("Driver loaded");//create connection
        con= DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/customerdb","root","Root@123");
        System.out.println("got connected");

        PreparedStatement ps=con.prepareStatement("insert into customer values(?,?,?)");

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        while(true){

            System.out.println("enter id");
            String s1=br.readLine();
            int id=Integer.parseInt(s1);

            System.out.println("enter name");
            String name=br.readLine();

            System.out.println("enter gender");
            String gender=br.readLine();


            ps.setInt(1,id);
            ps.setString(2,name);
            ps.setString(3,gender);

            ps.addBatch();
            System.out.println("Want to add more records y/n");
            String ans=br.readLine();
            if(ans.equals("n")){
                break;
            }

        }
        ps.executeBatch();

        System.out.println("record successfully saved");

        con.close();
    }catch(Exception e){System.out.println(e);}

}
}

