package br.edu.ifs.dao;

import java.sql.SQLException;
import java.util.List;

import br.edu.ifs.modelo.Pergunta;
import br.edu.ifs.modelo.Tema;

public interface IPerguntadao {

	//CRUD(Criar, Recuperar, Deletar, Alterar)//

	public int criar(Pergunta pergunta) throws SQLException;
	public Pergunta recuperar(int id) throws Exception, SQLException;
	public boolean atualizar(Pergunta pergunta) throws SQLException;
	public boolean excluir(Pergunta pergunta) throws SQLException;
	
	//Outras Funcionalidades//
	public List<Pergunta> listar() throws SQLException;
	
}