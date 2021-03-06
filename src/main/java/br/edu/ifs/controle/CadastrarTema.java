package br.edu.ifs.controle;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifs.dao.FabricaConexoesPostegres;
import br.edu.ifs.dao.IFabricaConexoes;
import br.edu.ifs.dao.ITemadao;
import br.edu.ifs.dao.TemadaoPostegres;
import br.edu.ifs.modelo.Tema;

/**
 * Servlet implementation class CadastrarTema
 */
@WebServlet("/CadastrarTema.do")
public class CadastrarTema extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastrarTema() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		// Recuperar os parāmetros do request - Enviados do JSP
				String nome = request.getParameter("nome");
				String descricao = request.getParameter("descricao");
				String status = request.getParameter("status");
				
				try {
				Tema tema = new Tema(nome, descricao, Integer.parseInt(status));
				IFabricaConexoes fabrica = new FabricaConexoesPostegres();
				ITemadao temadao = new TemadaoPostegres(fabrica.obterConexao());
				int id = temadao.criar(tema);

				response.sendRedirect("tema/ListarTemas.jsp");
				}
				catch (SQLException e) {
					request.getSession().setAttribute("erro", e.getMessage().toString());
					response.sendRedirect("erro/ExibirErro.jsp");
				}
				catch (ClassNotFoundException e) {
					request.getSession().setAttribute("erro", e.getMessage().toString());
					response.sendRedirect("erro/ExibirErro.jsp");
				}
	}
}
