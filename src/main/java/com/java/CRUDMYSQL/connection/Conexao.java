package com.java.CRUDMYSQL.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
	private static final Connection connection = construirConexao();
	private static final String USERNAME = "root";
	private static final String PASSWORD = "root";
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/CRUD_MYSQL?useSSL=false";
	
	
	private static Connection construirConexao() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
		}catch (Exception e) {
			System.err.println("Conexao falhou "+e.getMessage());
			
		}
		
		return null;
		
	}
	
	public static Connection getConnetion() {
		return connection;
	}

}
