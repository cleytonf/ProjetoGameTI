package br.edu.ifs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifs.modelo.Usuario;

public class UsuariodaoPostegres implements IUsuariodao {
	
	private Connection conexao;
	
	public UsuariodaoPostegres (Connection pconexao) {
		this.conexao = pconexao;
		}
	

	@Override
	public int criar(Usuario usuario) throws SQLException {
		
		String sql = "INSERT INTO public.usuario(nome, email, login, senha, tipo) VALUES (?, ?, ?, MD5(?), ?)";
		
		int id = 0;
		
		try {
			
			PreparedStatement stmt = this.conexao.prepareStatement(sql);
			
			stmt.setString(1, usuario.getNome());
			stmt.setString(2, usuario.getEmail());
			stmt.setString(3, usuario.getLogin());
			stmt.setString(4, usuario.getSenha());
			stmt.setInt   (5, 2);
			stmt.execute();
			
			sql = "SELECT CURRVAL(pg_get_serial_sequence('usuario','id')) AS id";
			stmt = this.conexao.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()) {
				
				id = rs.getInt("id");
			}
			
			return id;
			
		} catch (SQLException e) {
			throw e;
		}
		finally {
			conexao.close();
		}
	}
	
	@Override
	public Usuario recuperar(int id) throws Exception, SQLException {
		// TODO Auto-generated method stub

		String sql = "SELECT * FROM usuario WHERE id = ?";
		
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			
			stmt.setInt(1, id);
			
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()) {
				Usuario usuario = new Usuario
						(rs.getInt("id"),
						rs.getString("nome"),
						rs.getString("email"), 
						rs.getString("login"),	
						rs.getString("senha"),
						rs.getInt("tipo"));
				return usuario;
				
			} else {
				throw new Exception("O ID do usuário não existe.");
			}
			
		} catch (SQLException e) {
			throw e;
		}
		finally {
			conexao.close();
		}
	}


	@Override
	public List<Usuario> listar() throws SQLException {
String sql = "SELECT id, nome, email, login, senha, tipo FROM usuario  ORDER BY id";
		
		List<Usuario> listaUsuarios = new ArrayList<Usuario>();
		
		try {
			
			PreparedStatement stmt = conexao.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				
				Usuario usuario = new Usuario
						(rs.getInt("id"),
						rs.getString("nome"),
						rs.getString("email"),
						rs.getString("login"),
						rs.getString("senha"),
						rs.getInt("tipo"));
				
				listaUsuarios.add(usuario);
				
			}
			
			return listaUsuarios;
			
		} catch (SQLException e) {
			throw e;
		}
		finally {
			conexao.close();
		}
	}


	@Override
	public boolean atualizar(Usuario usuario) throws SQLException {
		
		String sql = "UPDATE usuario SET nome=?, email=?, login=?, senha=MD5(?) WHERE id=?";
		
		try {
					
					PreparedStatement stmt = conexao.prepareStatement(sql);
						
						stmt.setString(1, usuario.getNome());
						stmt.setString(2, usuario.getEmail());
						stmt.setString(3, usuario.getLogin());
						stmt.setString(4, usuario.getSenha());
						stmt.setInt(5, usuario.getId());
						
						stmt.executeUpdate();
						
						return true;
									
				} catch (SQLException e) {
					throw e;
				}
				finally {
					conexao.close();
				}
			}


	@Override
	public boolean excluir(Usuario usuario) throws SQLException {
		
		String sql = "DELETE FROM usuario WHERE id=?";

		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			
			stmt.setInt(1, usuario.getId());
			
			stmt.execute();
			
			return true;
		
	} catch (SQLException e) {
		throw e;
	}
	finally {
		conexao.close();
		}
	}

}