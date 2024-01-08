package com.java.CRUDMYSQL.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.java.CRUDMYSQL.connection.Conexao;
import com.java.CRUDMYSQL.model.Contatos;
import com.mysql.jdbc.PreparedStatement;

public class ContatosDao {
	private Connection connection;
	
	public ContatosDao() {
		connection = Conexao.getConnetion();
	}
	
	public void Salvar(Contatos contatos) {
		
		try {
			String sql = "INSERT INTO contatos (nome,idade,dataCadastro) values (?,?,?);";
			PreparedStatement preparedSql= (PreparedStatement) connection.prepareStatement(sql);
			preparedSql.setString(1, contatos.getNome());
			preparedSql.setInt(2, contatos.getIdade());
			preparedSql.setDate(3, new java.sql.Date(contatos.getDataCadastro().getTime()));
			
			preparedSql.execute();
			connection.commit();
			
			System.out.println("Contato salvo com sucesso");
			
		}catch (Exception e) {
			try {
				connection.rollback(); //reverte a operação
			} catch (SQLException e1) {
				
				e1.printStackTrace();
			}finally {
				try {
					connection.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
			e.printStackTrace();
		}
		
	}

}
