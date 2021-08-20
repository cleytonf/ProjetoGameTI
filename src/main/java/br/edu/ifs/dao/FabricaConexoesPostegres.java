package br.edu.ifs.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaConexoesPostegres implements IFabricaConexoes {
	
	private static String DriverJDBC = "org.postgresql.Driver";
	private static String usuario = "postgres" ;
	private static String senha = "rsv160907";
	private static String URL = "jdbc:postgresql://localhost:5432/GameTI";

	@Override
	public Connection obterConexao() throws ClassNotFoundException, SQLException {
		
		try {
			Class.forName(DriverJDBC);
			return DriverManager.getConnection(URL, usuario, senha);
		}
		catch (SQLException e) {
			throw e;
		}
		catch (ClassNotFoundException e) {
			throw e;
		}
	}

}
