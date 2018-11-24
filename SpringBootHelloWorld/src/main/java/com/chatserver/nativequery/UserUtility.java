package com.chatserver.nativequery;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.chatserver.MysqlConnection;
import com.chatserver.entity.User;

public class UserUtility {
	
	
	public static List<User> getAllUserExcept(String email) throws Exception{
		List<User>  list=new ArrayList<>();
		
		Connection con=MysqlConnection.getMysqlConnection();
		PreparedStatement ps= con.prepareStatement("select * from user where email_id !=?");
		ps.setString(1, email);
	ResultSet rs=	ps.executeQuery();
	while (rs.next()) {
		User user=new User();
		user.setId(rs.getInt("id"));
		user.setEmailId(rs.getString("email_id"));
		list.add(user);
	}
		return list;
		
	}
	
	

}
