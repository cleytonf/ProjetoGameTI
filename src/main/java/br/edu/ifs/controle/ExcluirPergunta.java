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
import br.edu.ifs.dao.IPerguntadao;
import br.edu.ifs.dao.PerguntadaoPostegres;
import br.edu.ifs.modelo.Pergunta;

/**
 * Servlet implementation class ExcluirPergunta
 */
@WebServlet("/ExcluirPergunta.do")
public class ExcluirPergunta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExcluirPergunta() {
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
String Id= request.getParameter("id");
		
		try {
			Pergunta pergunta = new Pergunta();
			pergunta.setId(Integer.parseInt(Id));
		
		
		IFabricaConexoes fabrica = new FabricaConexoesPostegres();
		IPerguntadao perguntadao = new PerguntadaoPostegres(fabrica.obterConexao());
		perguntadao.excluir(pergunta);
		
		response.sendRedirect("pergunta/ListarPerguntas.jsp");
		
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
