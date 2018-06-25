package com.dao;

import java.sql.*;
import javax.sql.DataSource;
import javax.naming.*;
public class BaseDao {
	DataSource datasource;
	public BaseDao() {
		try {
			Context context = new InitialContext();
			datasource = (DataSource)context.lookup("java:comp/env/jdbc/student");
		}
		catch(NamingException e) {
			System.out.println("Exception:"+e);
			System.out.println("");
		}
	}

	public Connection getConnection()throws Exception{
		return datasource.getConnection();
	}
}
