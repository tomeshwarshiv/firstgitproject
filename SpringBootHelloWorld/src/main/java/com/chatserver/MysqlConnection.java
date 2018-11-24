package com.chatserver;

import java.sql.Connection;
import java.sql.DriverManager;

public class MysqlConnection {

	
	
	public static Connection getMysqlConnection() throws Exception {
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/chat", "root","root");
		return con;
		
	}
}
