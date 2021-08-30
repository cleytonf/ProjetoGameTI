package br.edu.ifs.dao;

import java.sql.SQLException;
import java.util.List;
import br.edu.ifs.modelo.Usuario;

public interface IUsuariodao {

	//CRUD//

	public int criar(Usuario usuario) throws SQLException;
	public Usuario recuperar(int id) throws Exception, SQLException;
	public boolean atualizar(Usuario usuario) throws SQLException;
	public boolean excluir(Usuario usuario) throws SQLException;
	
	//Outras Funcionalidades//
	public List<Usuario> listar() throws SQLException;
	public Usuario autenticar(String login, String senha) throws SQLException;
	
}
