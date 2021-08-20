package br.edu.ifs.dao;

import java.sql.SQLException;
import java.util.List;

import br.edu.ifs.modelo.Tema;
import br.edu.ifs.modelo.Usuario;

public interface ITemadao {

	//CRUD(Criar, Recuperar, Deletar, Alterar)//

	public int criar(Tema tema) throws SQLException;
	public Tema recuperar(int id) throws Exception, SQLException;
	public boolean atualizar(Tema tema) throws SQLException;
	public boolean excluir(Tema tema) throws SQLException;
	
	//Outras Funcionalidades//
	public List<Tema> listar() throws SQLException;
	
}