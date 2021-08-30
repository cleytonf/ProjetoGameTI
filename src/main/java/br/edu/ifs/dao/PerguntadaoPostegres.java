package br.edu.ifs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifs.modelo.Pergunta;
import br.edu.ifs.modelo.Tema;

public class PerguntadaoPostegres implements IPerguntadao {

private Connection conexao;
	
	public PerguntadaoPostegres (Connection pconexao) {
		this.conexao = pconexao;
		}
	

	@Override
	public int criar(Pergunta pergunta) throws SQLException {
		
		String sql = "INSERT INTO public.pergunta(usuario_id, tema_id, descricao, alternativa_1, alternativa_2, alternativa_3, alternativa_4, gabarito, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		int id = 0;
		
		try {
			
			PreparedStatement stmt = this.conexao.prepareStatement(sql);
			
			stmt.setInt(1, pergunta.getUsuario_id());
			stmt.setInt(2, pergunta.getTema_id());
			stmt.setString(3, pergunta.getDescricao());
			stmt.setString(4, pergunta.getAlternativa_1());
			stmt.setString(5, pergunta.getAlternativa_2());
			stmt.setString(6, pergunta.getAlternativa_3());
			stmt.setString(7, pergunta.getAlternativa_4());
			stmt.setInt(8, pergunta.getGabarito());
			stmt.setInt(9, pergunta.getStatus());
			stmt.execute();
			
			sql = "SELECT CURRVAL(pg_get_serial_sequence('pergunta','id')) AS id";
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
	public Pergunta recuperar(int id) throws Exception, SQLException {
		// TODO Auto-generated method stub

		String sql = "SELECT * FROM pergunta WHERE id = ?";
		
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			
			stmt.setInt(1, id);
			
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()) {
				Pergunta pergunta = new Pergunta
						(rs.getInt("id"),
						rs.getInt("usuario_id"),
						rs.getInt("tema_id"),
						rs.getString("descricao"),
						rs.getString("alternativa_1"),
						rs.getString("alternativa_2"),
						rs.getString("alternativa_3"),
						rs.getString("alternativa_4"),
						rs.getInt("gabarito"),
						rs.getInt("status"));
				return pergunta;
				
			} else {
				throw new Exception("O ID da pergunta não existe.");
			}
			
		} catch (SQLException e) {
			throw e;
		}
		finally {
			conexao.close();
		}
	}


	@Override
	public List<Pergunta> listar() throws SQLException {
		String sql = "SELECT id, usuario_id, tema_id, descricao, alternativa_1, alternativa_2, alternativa_3, alternativa_4, gabarito, status FROM pergunta ORDER BY id";
		
		List<Pergunta> listaPergunta = new ArrayList<Pergunta>();
		
		try {
			
			PreparedStatement stmt = conexao.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				
				Pergunta pergunta = new Pergunta
						(rs.getInt("id"),
						rs.getInt("usuario_id"),
						rs.getInt("tema_id"),
						rs.getString("descricao"),
						rs.getString("alternativa_1"),
						rs.getString("alternativa_2"),
						rs.getString("alternativa_3"),
						rs.getString("alternativa_4"),
						rs.getInt("gabarito"),
						rs.getInt("status"));
						
				listaPergunta.add(pergunta);
				
			}
			
			return listaPergunta;
			
		} catch (SQLException e) {
			throw e;
		}
		finally {
			conexao.close();
		}
	}


	@Override
	public boolean atualizar(Pergunta pergunta) throws SQLException {
		
		String sql = "UPDATE pergunta SET usuario_id=?, tema_id=?, descricao=?, alternativa_1=?, alternativa_2=?, alternativa_3=?, alternativa_4=?, gabarito=?, status=? WHERE id=?";
		
		try {
					
					PreparedStatement stmt = conexao.prepareStatement(sql);
						
						
					stmt.setInt(1, pergunta.getUsuario_id());
					stmt.setInt(2, pergunta.getTema_id());
					stmt.setString(3, pergunta.getDescricao());
					stmt.setString(4, pergunta.getAlternativa_1());
					stmt.setString(5, pergunta.getAlternativa_2());
					stmt.setString(6, pergunta.getAlternativa_3());
					stmt.setString(7, pergunta.getAlternativa_4());
					stmt.setInt(8, pergunta.getGabarito());
					stmt.setInt(9, pergunta.getStatus());
					stmt.setInt(10, pergunta.getId());
						
					System.out.println(stmt.toString());
					
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
	public boolean excluir(Pergunta pergunta) throws SQLException {
		
		String sql = "DELETE FROM pergunta WHERE id=?";

		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			
			stmt.setInt(1, pergunta.getId());
			
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
