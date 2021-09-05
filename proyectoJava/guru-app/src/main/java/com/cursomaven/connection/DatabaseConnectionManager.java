package com.cursomaven.connection;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class DatabaseConnectionManager{
	private final String url;
	private final Properties properties; 

	public DatabaseConnectionManager(String host, 
		String databaseName, 
		String userName, 
		String password){
		
		this.url = "jdbc:mysql://"+host+"/"+databaseName;
		this.properties = new Properties();
		this.properties.setProperty("user",userName);
		this.properties.setProperty("password",password);
		System.out.println("URL: "+this.url);
		System.out.println("Properties: "+this.properties);
	}

	public Connection getConnection()throws SQLException{
		//return DriverManager.getConnection(url, this.properties.getProperty("user"), this.properties.getProperty("password"));
		return DriverManager.getConnection(this.url+"?useSSL=false", this.properties);
	}
}