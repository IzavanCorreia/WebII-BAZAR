package com.ifpe.recife.bazar.entites;

public class OrgaoDonatario {
	
	private int id;
	private String nome;
	private String endereco;
	private String telefone;
	private String horariofuncionamento;
	private String descricao;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getHorariofuncionamento() {
		return horariofuncionamento;
	}
	public void setHorariofuncionamento(String horariofuncionamento) {
		this.horariofuncionamento = horariofuncionamento;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
