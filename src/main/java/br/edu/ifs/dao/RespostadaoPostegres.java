package br.edu.ifs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.edu.ifs.modelo.Pergunta;
import br.edu.ifs.modelo.Resposta;

public class RespostadaoPostegres implements IRespostadao {

private Connection conexao;
	
	public RespostadaoPostegres (Connection pconexao) {
		this.conexao = pconexao;
		}
	

	@Override
	public int criar(Resposta resposta) throws SQLException {
		
		String sql = "INSERT INTO public.resposta(usuario_id, pergunta_id, alternativa) VALUES (?, ?, ?)";
		
		int id = 0;
		
		try {
			
			PreparedStatement stmt = this.conexao.prepareStatement(sql);
			
			stmt.setInt(1, resposta.getUsuario_id());
			stmt.setInt(2, resposta.getPergunta_id());
			stmt.setInt(3, resposta.getAlternativa());
			
			System.out.println(stmt.toString());
			stmt.execute();
			
			sql = "SELECT CURRVAL(pg_get_serial_sequence('resposta','id')) AS id";
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
	public Resposta recuperar(int id) throws Exception, SQLException {
		// TODO Auto-generated method stub

		String sql = "SELECT * FROM resposta WHERE id = ?";
		
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			
			stmt.setInt(1, id);
			
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()) {
				Resposta resposta = new Resposta
						(rs.getInt("id"),
						rs.getInt("usuario_id"),
						rs.getInt("pergunta_id"),
						rs.getInt("alternativa"),
						rs.getDate("data_resposta"));
						
				return resposta;
				
			} else {
				throw new Exception("O ID da resposta não existe.");
			}
			
		} catch (SQLException e) {
			throw e;
		}
		finally {
			conexao.close();
		}
	}


	@Override
	public List<Resposta> listar() throws SQLException {
		String sql = "SELECT id, usuario_id, pergunta_id, alternativa, data_resposta FROM resposta ORDER BY id";
		
		List<Resposta> listaResposta = new ArrayList<Resposta>();
		
		try {
			
			PreparedStatement stmt = conexao.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				
				Resposta resposta = new Resposta
						(rs.getInt("id"),
						rs.getInt("usuario_id"),
						rs.getInt("pergunta_id"),
						rs.getInt("alternativa"),
						rs.getDate("data_resposta"));
						
				listaResposta.add(resposta);
				
			}
			
			return listaResposta;
			
		} catch (SQLException e) {
			throw e;
		}
		finally {
			conexao.close();
		}
	}


	@Override
	public boolean atualizar(Resposta resposta) throws SQLException {
		
		String sql = "UPDATE resposta SET  pergunta_id=?, alternativa=?, data_resposta=? WHERE id=?";
		
		try {
					
					PreparedStatement stmt = conexao.prepareStatement(sql);
						
						
					
					stmt.setInt(1, resposta.getPergunta_id());
					stmt.setInt(2, resposta.getAlternativa());
					stmt.setDate(3, resposta.getData_resposta());
					stmt.setInt(4, resposta.getId());
						
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
	public boolean excluir(Resposta resposta) throws SQLException {
		
		String sql = "DELETE FROM resposta WHERE id=?";

		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			
			stmt.setInt(1, resposta.getId());
			
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
