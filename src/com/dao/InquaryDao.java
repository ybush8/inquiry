package com.dao;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.bean.Student;

public class InquaryDao {
	public boolean addStudent(Student stu) {
		System.out.println("success");
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet res = null;
        String url = "jdbc:mysql://localhost:3306/student?characterEncoding=utf8&useSSL=false";
        String user = "root";
        String password = "1212";
        String sql = "INSERT INTO student"+"(number,name,sex,class,phone,address)VALUES(?,?,?,?,?,?)";
        try {
            Driver driver = new com.mysql.jdbc.Driver();
            DriverManager.registerDriver(driver);
            conn = DriverManager.getConnection(url, user, password);           
			pstmt.setString(1, stu.getNumber());
			pstmt.setString(2, stu.getName());
			pstmt.setString(3, stu.getUserSex());
			pstmt.setString(4, stu.getUserClass());
			pstmt.setString(5, stu.getPhone());
			pstmt.setString(6, stu.getAddress());
            pstmt = conn.prepareStatement(sql);
            pstmt.executeUpdate();
            return true;
            } 
        catch (SQLException e)
        {
            e.printStackTrace();
            return false;
        }
    }
	
	public ArrayList<Student> inquiryStudent(String number,String userClass)
	{
		System.out.println(number);
		System.out.println(userClass);
		ArrayList stulist = new ArrayList();
		Connection conn = null;
		PreparedStatement pstmt = null;
        String url = "jdbc:mysql://localhost:3306/student?characterEncoding=utf8&useSSL=false";
        String user = "root";
        String password = "1212";
		String sql1 = "select * from student where number=?";
		String sql2 = "select * from student where class=?";
		try {
			System.out.println("1");
            Driver driver = new com.mysql.jdbc.Driver();
            DriverManager.registerDriver(driver);
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("2");
    		if(number.equals(""))
    		{
    			System.out.println("3");
    			pstmt.setString(1, userClass);
    			System.out.println("3.1");
    			pstmt = conn.prepareStatement(sql2);
    			System.out.println("3.2");
    			try(ResultSet rst = pstmt.executeQuery())
    			{
    				System.out.println("4");
    				while(rst.next())
    				{
    					Student stu = new Student();
    					stu.setNumber(rst.getString("number"));
    					stu.setName(rst.getString("name"));
    					stu.setUserSex(rst.getString("sex"));
    					stu.setUserClass(rst.getString("class"));
    					stu.setPhone(rst.getString("phone"));
    					stu.setAddress(rst.getString("address"));
    					stulist.add(stu);
    				}
    				return stulist;
    		    }
    		}
			else
			{
    			pstmt.setString(1, number);
    			pstmt = conn.prepareStatement(sql1);
    			try(ResultSet rst = pstmt.executeQuery())
    			{
    				while(rst.next())
    				{
    					Student stu = new Student();
    					stu.setNumber(rst.getString("number"));
    					stu.setName(rst.getString("name"));
    					stu.setUserSex(rst.getString("sex"));
    					stu.setUserClass(rst.getString("class"));
    					stu.setPhone(rst.getString("phone"));
    					stu.setAddress(rst.getString("address"));
    					stulist.add(stu);
    				}
    				return stulist;
			    }
			}
		}catch(SQLException se)
		{
			se.printStackTrace();
			System.out.println("5");
			return null;
		}
	}
	
	public boolean changeStudent(Student stu) {
		System.out.println("success");
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet res = null;
        String url = "jdbc:mysql://localhost:3306/student?characterEncoding=utf8&useSSL=false";
        String user = "root";
        String password = "1212";
        String sql = "update student set name=?,sex=?,class=?,phone=?,address=? where number=?";
        try {
            Driver driver = new com.mysql.jdbc.Driver();
            DriverManager.registerDriver(driver);
            conn = DriverManager.getConnection(url, user, password);           	
			pstmt.setString(1, stu.getName());
			pstmt.setString(2, stu.getUserSex());
			pstmt.setString(3, stu.getUserClass());
			pstmt.setString(4, stu.getPhone());
			pstmt.setString(5, stu.getAddress());
            pstmt.setString(6, stu.getNumber());
            pstmt = conn.prepareStatement(sql);
            pstmt.executeUpdate();
            return true;
            } 
        catch (SQLException e)
        {
            e.printStackTrace();
            return false;
        }
    }
	
	public boolean deleteStudent(Student stu) {
		System.out.println("success");
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet res = null;
        String url = "jdbc:mysql://localhost:3306/student?characterEncoding=utf8&useSSL=false";
        String user = "root";
        String password = "1212";
        String sql = "delete from student where number=?";
        try {
            Driver driver = new com.mysql.jdbc.Driver();
            DriverManager.registerDriver(driver);
            conn = DriverManager.getConnection(url, user, password);           	
			pstmt.setString(1, stu.getNumber());
            pstmt = conn.prepareStatement(sql);
            pstmt.executeUpdate();
            return true;
            } 
        catch (SQLException e)
        {
            e.printStackTrace();
            return false;
        }
    }
	
}
