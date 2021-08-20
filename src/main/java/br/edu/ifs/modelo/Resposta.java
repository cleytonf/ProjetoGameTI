package br.edu.ifs.modelo;

import java.sql.Date;

public class Resposta {
	
	private int id;
	private int usuario_id;
	private int pergunta_id;
	private int alternativa;
	private Date data_resposta;
	
	public Resposta(int id, int usuario_id, int pergunta_id, int alternativa, Date data_resposta) {
		super();
		this.id = id;
		this.usuario_id = usuario_id;
		this.pergunta_id = pergunta_id;
		this.alternativa = alternativa;
		this.data_resposta = data_resposta;
	}
	
	public Resposta() {
		super();
	}
	
	public Date getData_resposta() {
		return data_resposta;
	}

	public void setData_resposta(Date data_resposta) {
		this.data_resposta = data_resposta;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAlternativa() {
		return alternativa;
	}
	public void setAlternativa(int alternativa) {
		this.alternativa = alternativa;
	}

	public int getUsuario_id() {
		return usuario_id;
	}

	public void setUsuario_id(int usuario_id) {
		this.usuario_id = usuario_id;
	}

	public int getPergunta_id() {
		return pergunta_id;
	}

	public void setPergunta_id(int pergunta_id) {
		this.pergunta_id = pergunta_id;
	}

}
