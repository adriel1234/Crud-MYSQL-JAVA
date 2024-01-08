package com.java.CRUDMYSQL.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
	
	public List<Contatos> consultar(){
		String sql = "SELECT * FROM contatos";
		List<Contatos> contatos = new ArrayList<Contatos>();

		try {
			
			PreparedStatement preparedSql= (PreparedStatement) connection.prepareStatement(sql);
			ResultSet rset = preparedSql.executeQuery();
			
			while(rset.next()) {
				Contatos contato = new Contatos();
				contato.setId(rset.getInt("id"));
				contato.setNome(rset.getString("nome"));
				contato.setDataCadastro(rset.getDate("dataCadastro"));
				contato.setIdade(rset.getInt("idade"));
				
				contatos.add(contato);
			}				
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
		}
		return contatos;
	}
	
	public void atualizar(Contatos contato) {
		String sql = "UPDATE contatos SET nome=?, idade=?, dataCadastro=? where id = ?";

		try {
			PreparedStatement prepareSql = (PreparedStatement) connection.prepareStatement(sql);
			prepareSql.setString(1, contato.getNome());
			prepareSql.setInt(2, contato.getIdade());
			prepareSql.setDate(3, new java.sql.Date(contato.getDataCadastro().getTime()));
			prepareSql.setInt(4, contato.getId());

			prepareSql.execute();
			connection.commit();

		} catch (Exception e) {
			try {
				connection.rollback(); // reverte a operação
			} catch (SQLException e1) {

				e1.printStackTrace();
			} finally {
				try {
					connection.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();

				}

			}
		}

	}

}

			
			
