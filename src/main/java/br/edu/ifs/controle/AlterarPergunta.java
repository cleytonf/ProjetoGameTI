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
import br.edu.ifs.modelo.Usuario;

/**
 * Servlet implementation class AlterarPergunta
 */
@WebServlet("/AlterarPergunta.do")
public class AlterarPergunta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlterarPergunta() {
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
		
		String Id = request.getParameter("id");

		Usuario usuario = (Usuario) request.getSession().getAttribute("usuarioAutenticado");

		int usuario_id = usuario.getId();
		String tema_id= request.getParameter("tema_id");
		String descricao = request.getParameter("descricao");
		String alternativa_1 = request.getParameter("alternativa_1");
		String alternativa_2 = request.getParameter("alternativa_2");
		String alternativa_3 = request.getParameter("alternativa_3");
		String alternativa_4 = request.getParameter("alternativa_4");
		String gabarito = request.getParameter("gabarito");
		String status = request.getParameter("status");
		
try {
			Pergunta pergunta = new Pergunta();
			pergunta.setId(Integer.parseInt(Id));
			pergunta.setUsuario_id(usuario_id);
			pergunta.setTema_id(Integer.parseInt(tema_id));
			pergunta.setDescricao(descricao);
			pergunta.setAlternativa_1(alternativa_1);
			pergunta.setAlternativa_2(alternativa_2);
			pergunta.setAlternativa_3(alternativa_3);
			pergunta.setAlternativa_4(alternativa_4);
			pergunta.setGabarito(Integer.parseInt(gabarito));
			pergunta.setStatus(Integer.parseInt(status));
			
			IFabricaConexoes fabrica = new FabricaConexoesPostegres();
			IPerguntadao perguntadao = new PerguntadaoPostegres(fabrica.obterConexao());
			perguntadao.atualizar(pergunta);
			
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

