package com.java.CRUDMYSQL.main;


import java.util.Date;


import com.java.CRUDMYSQL.dao.ContatosDao;
import com.java.CRUDMYSQL.model.Contatos;

public class Main {

	public static void main(String[] args) {
		Contatos contato1= new Contatos();
		ContatosDao contatosDao = new ContatosDao();
		
		contato1.setId(18);
		contato1.setNome("Joao");
		contato1.setDataCadastro(new Date());
		
		contatosDao.Salvar(contato1);
		

	}

}
