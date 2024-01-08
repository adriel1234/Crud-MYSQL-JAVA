package com.java.CRUDMYSQL.main;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.java.CRUDMYSQL.dao.ContatosDao;
import com.java.CRUDMYSQL.model.Contatos;

public class Main {

	public static void main(String[] args) {
		Contatos contato1= new Contatos();
		ContatosDao contatosDao = new ContatosDao();
		
//		contato1.setIdade(18);
//		contato1.setNome("Joao teste");
//		contato1.setDataCadastro(new Date());
//		
//		contatosDao.Salvar(contato1);
		
		
		
		
//		contato1.setId(6);
//		contato1.setIdade(51);
//		contato1.setNome("Joao update");
//		contato1.setDataCadastro(new Date());
//		
//		contatosDao.atualizar(contato1);
		
		contatosDao.deletar(8);
		
		List<Contatos> conts = new ArrayList<Contatos>();
		conts = contatosDao.consultar();
		
		for (Contatos contato : conts) {
			System.out.println("\nId: "+contato.getId());
			System.out.println("Nome: "+contato.getNome());
			System.out.println("Idade: "+contato.getIdade());
			System.out.println("Data de Cadastro: "+contato.getDataCadastro());
			
		}
		

	}

}
