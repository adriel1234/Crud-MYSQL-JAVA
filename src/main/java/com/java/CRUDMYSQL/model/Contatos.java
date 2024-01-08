package com.java.CRUDMYSQL.model;

import java.util.Date;

public class Contatos {
	
	private Integer id;
	private String nome;
	private int idade;
	private Date dataCadastro;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public Date getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	@Override
	public String toString() {
		return "Contatos [id=" + id + ", nome=" + nome + ", idade=" + idade + ", dataCadastro=" + dataCadastro + "]";
	}
	
	
	
	
	

}
