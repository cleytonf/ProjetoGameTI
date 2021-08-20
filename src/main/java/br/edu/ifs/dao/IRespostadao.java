package br.edu.ifs.dao;

import java.sql.SQLException;
import java.util.List;

import br.edu.ifs.modelo.Resposta;
import br.edu.ifs.modelo.Usuario;

public interface IRespostadao {

	//CRUD(Criar, Recuperar, Deletar, Alterar)//

	public int criar(Resposta resposta) throws SQLException;
	public Resposta recuperar(int id) throws Exception, SQLException;
	public boolean atualizar(Resposta resposta) throws SQLException;
	public boolean excluir(Resposta resposta) throws SQLException;
	
	//Outras Funcionalidades//
	public List<Resposta> listar() throws SQLException;
	
}