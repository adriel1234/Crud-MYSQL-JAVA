package com.java.CRUDMYSQL.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
	private static Connection connection = null;
	private static final String USERNAME = "root";
	private static final String PASSWORD = "root";
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/CRUD_MYSQL?useSSL=false";
	
	static {
		construirConexao();
	}
	
	public Conexao() {
		construirConexao();
	}
	
	private static void construirConexao() {
		
		try {
			if(connection == null) {
				Class.forName("com.mysql.jdbc.Driver");
				connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
				connection.setAutoCommit(false);
			}
		}catch (Exception e) {
			System.err.println("Conexao falhou "+e.getMessage());
			
		}
		
		
	}
	
	public static Connection getConnetion() {
		return connection;
	}

}
