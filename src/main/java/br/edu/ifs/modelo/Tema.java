package br.edu.ifs.modelo;

public class Tema {

	private int id;
	private String nome;
	private String descricao;
	private int status;
	
	public Tema(int id, String nome, String descricao, int status) {
		super();
		this.id= id;
		this.nome = nome;
		this.descricao = descricao;
		this.status = status;
	}
	
	public Tema( String nome, String descricao, int status) {
		super();
		this.nome = nome;
		this.descricao = descricao;
		this.status = status;
	}
	
	public Tema() {
		super();
	}

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
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	
}
