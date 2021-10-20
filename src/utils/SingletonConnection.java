package utils;

import java.sql.DriverManager;

import java.sql.SQLException;

import java.sql.Connection;

public class SingletonConnection {
	private static Connection connection ;
	
	private SingletonConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/produitjava","root","");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}

public static Connection getInstance() {
	if(connection==null)
		new 
		SingletonConnection();
	return connection ;
}
}