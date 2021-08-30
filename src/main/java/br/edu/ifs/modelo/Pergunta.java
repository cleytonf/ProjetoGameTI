package br.edu.ifs.modelo;

public class Pergunta {
	
	private int id;
	private int usuario_id;
	private int tema_id;
	
	private String descricao;
	private String alternativa_1;
	private String alternativa_2;
	private String alternativa_3;
	private String alternativa_4;
	private int gabarito;
	private int status;
	
	public Pergunta(int id, int usuario_id, int tema_id, String descricao, String alternativa_1, String alternativa_2, String alternativa_3,
			String alternativa_4, int gabarito, int status) {
		super();
		this.id = id;
		this.usuario_id = usuario_id;
		this.tema_id = tema_id;
		this.descricao = descricao;
		this.alternativa_1 = alternativa_1;
		this.alternativa_2 = alternativa_2;
		this.alternativa_3 = alternativa_3;
		this.alternativa_4 = alternativa_4;
		this.gabarito = gabarito;
		this.status = status;
	}
	
	public Pergunta( int usuario_id, int tema_id, String descricao, String alternativa_1, String alternativa_2, String alternativa_3,
			String alternativa_4, int gabarito, int status) {
		super();
		this.usuario_id = usuario_id;
		this.tema_id = tema_id;
		this.descricao = descricao;
		this.alternativa_1 = alternativa_1;
		this.alternativa_2 = alternativa_2;
		this.alternativa_3 = alternativa_3;
		this.alternativa_4 = alternativa_4;
		this.gabarito = gabarito;
		this.status = status;
	}
	
	public Pergunta() {
		super();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getAlternativa_1() {
		return alternativa_1;
	}
	public void setAlternativa_1(String alternativa_1) {
		this.alternativa_1 = alternativa_1;
	}
	public String getAlternativa_2() {
		return alternativa_2;
	}
	public void setAlternativa_2(String alternativa_2) {
		this.alternativa_2 = alternativa_2;
	}
	public String getAlternativa_3() {
		return alternativa_3;
	}
	public void setAlternativa_3(String alternativa_3) {
		this.alternativa_3 = alternativa_3;
	}
	public String getAlternativa_4() {
		return alternativa_4;
	}
	public void setAlternativa_4(String alternativa_4) {
		this.alternativa_4 = alternativa_4;
	}
	public int getGabarito() {
		return gabarito;
	}
	public void setGabarito(int gabarito) {
		this.gabarito = gabarito;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	public int getUsuario_id() {
		return usuario_id;
	}

	public void setUsuario_id(int usuario_id) {
		this.usuario_id = usuario_id;
	}

	public int getTema_id() {
		return tema_id;
	}

	public void setTema_id(int tema_id) {
		this.tema_id = tema_id;
	}
}
