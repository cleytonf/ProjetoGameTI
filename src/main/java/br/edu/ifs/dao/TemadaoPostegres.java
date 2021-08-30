package br.edu.ifs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifs.modelo.Tema;

public class TemadaoPostegres implements ITemadao {

private Connection conexao;
	
	public TemadaoPostegres (Connection pconexao) {
		this.conexao = pconexao;
		}
	

	@Override
	public int criar(Tema tema) throws SQLException {
		
		String sql = "INSERT INTO public.tema(nome, descricao, status) VALUES (?, ?, ?)";
		
		int id = 0;
		
		try {
			
			PreparedStatement stmt = this.conexao.prepareStatement(sql);
			
			stmt.setString(1, tema.getNome());
			stmt.setString(2, tema.getDescricao());
			stmt.setInt(3, tema.getStatus());
			stmt.execute();
			
			sql = "SELECT CURRVAL(pg_get_serial_sequence('tema','id')) AS id";
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
	public Tema recuperar(int id) throws Exception, SQLException {
		// TODO Auto-generated method stub

		String sql = "SELECT * FROM tema WHERE id = ?";
		
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			
			stmt.setInt(1, id);
			
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()) {
				Tema tema = new Tema
						(rs.getInt("id"),
						rs.getString("nome"),
						rs.getString("descricao"), 
						rs.getInt("status"));
				return tema;
				
			} else {
				throw new Exception("O ID do tema não existe.");
			}
			
		} catch (SQLException e) {
			throw e;
		}
		finally {
			conexao.close();
		}
	}


	@Override
	public List<Tema> listar() throws SQLException {
		String sql = "SELECT id, nome, descricao, status FROM tema  ORDER BY id";
		
		List<Tema> listaTema = new ArrayList<Tema>();
		
		try {
			
			PreparedStatement stmt = conexao.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				
				Tema tema = new Tema
						(rs.getInt("id"),
						rs.getString("nome"),
						rs.getString("descricao"),
						rs.getInt("status"));
						
				listaTema.add(tema);
				
			}
			
			return listaTema;
			
		} catch (SQLException e) {
			throw e;
		}
		finally {
			conexao.close();
		}
	}


	@Override
	public boolean atualizar(Tema tema) throws SQLException {
		
		String sql = "UPDATE tema SET nome=?, descricao=?, status=? WHERE id=?";
		
		try {
					
					PreparedStatement stmt = conexao.prepareStatement(sql);
						
						stmt.setString(1, tema.getNome());
						stmt.setString(2, tema.getDescricao());
						stmt.setInt(3, tema.getStatus());
						stmt.setInt(4, tema.getId());
						
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
	public boolean excluir(Tema tema) throws SQLException {
		
		String sql = "DELETE FROM tema WHERE id=?";

		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			
			stmt.setInt(1, tema.getId());
			
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
