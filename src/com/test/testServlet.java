package com.test;
import com.bean.*;
import com.dao.*;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class testServlet
 */
@WebServlet("/testServlet")
public class testServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public testServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDao dao = new UserDao();
		/*Student stu=new Student();
		stu.setAddress("1");
		stu.setName("2");
		stu.setNumber("3");
		stu.setPhone("4");
		stu.setUserClass("5");
		stu.setUserSex("6");
		Boolean result=dao.addStudent(stu);*/
		String number="10001";
		String userClass="";
		ArrayList stulist=new ArrayList();
		stulist=dao.inquiryStudent(number, userClass);
		Boolean result=stulist.isEmpty();
		
		response.getWriter().append("Served at: "+result).append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		doGet(request, response);
	}

}
