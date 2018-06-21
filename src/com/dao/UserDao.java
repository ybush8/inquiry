package com.dao;
import com.bean.*;

import java.io.UnsupportedEncodingException;
import java.sql.*;
import java.util.ArrayList;

import javax.sql.DataSource;

public class UserDao extends BaseDao{
	//Ìí¼Ó
	public boolean addStudent(Student stu)
	{
		String sql = "INSERT INTO student"+"(number,name,sex,class,phone,address)VALUES(?,?,?,?,?,?)";
		try(Connection conn = datasource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql))
		{
			pstmt.setString(1, stu.getNumber());
			pstmt.setString(2, stu.getName());
			pstmt.setString(3, stu.getUserSex());
			pstmt.setString(4, stu.getUserClass());
			pstmt.setString(5, stu.getPhone());
			pstmt.setString(6, stu.getAddress());
			pstmt.executeUpdate();
			return true;
		}catch(SQLException e)
		{
			e.printStackTrace();
			return false;
		}
	}
	
	//²éÑ¯
	public ArrayList<Student> inquiryStudent(String number,String userClass)
	{
		ArrayList stulist = new ArrayList();
		String sql1 = "select * from student where number=?";
		String sql2 = "select * from student where class=?";
		if(number.equals(""))
		{
			try(Connection conn = datasource.getConnection();
					PreparedStatement pstmt = conn.prepareStatement(sql2))
			{
				pstmt.setString(1, userClass);
				try(ResultSet rst = pstmt.executeQuery()){
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
			   }
				return stulist;
			}
			catch(SQLException e)
			{
				e.printStackTrace();
				return null;
			}
		}
		
		else
		{
			try(Connection conn = datasource.getConnection();
					PreparedStatement pstmt = conn.prepareStatement(sql1))
			{
				pstmt.setString(1, number);
				try(ResultSet rst = pstmt.executeQuery()){
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
			   }
				return stulist;
			}
			catch(SQLException e)
			{
				e.printStackTrace();
				return null;
			}		
		}
	}
	
   //ÐÞ¸Ä
	public boolean changeStudent(Student stu) throws UnsupportedEncodingException
	{
		String name=new String(stu.getName().getBytes("ISO8859-1"),"UTF-8");
		String sql = "update student set name=?,sex=?,class=?,phone=?,address=? where number=?";
		try(Connection conn = datasource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql))
		{
			pstmt.setString(1, name);
			pstmt.setString(2, stu.getUserSex());
			pstmt.setString(3, stu.getUserClass());
			pstmt.setString(4, stu.getPhone());
			pstmt.setString(5, stu.getAddress());
			pstmt.setString(6, stu.getNumber());
			pstmt.executeUpdate();
			return true;
		}catch(SQLException e)
		{
			e.printStackTrace();
			return false;
		}
	}
	
	//É¾³ý
	public boolean deleteStudent(Student stu)
	{
		String sql = "delete from student where number=?";
		try(Connection conn = datasource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql))
		{
			pstmt.setString(1, stu.getNumber());
			pstmt.executeUpdate();
			return true;
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			return false;
		}
	}
	
	
}
