package br.edu.ifs.controle;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifs.dao.FabricaConexoesPostegres;
import br.edu.ifs.dao.IFabricaConexoes;
import br.edu.ifs.dao.IRespostadao;
import br.edu.ifs.dao.RespostadaoPostegres;
import br.edu.ifs.modelo.Resposta;
import br.edu.ifs.modelo.Usuario;

/**
 * Servlet implementation class AlterarResposta
 */
@WebServlet("/AlterarResposta.do")
public class AlterarResposta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlterarResposta() {
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
		String pergunta_id= request.getParameter("pergunta_id");
		String alternativa = request.getParameter("alternativa");
		
		
try {
			Resposta resposta = new Resposta();
			resposta.setId(Integer.parseInt(Id));
			resposta.setUsuario_id(usuario_id);
			resposta.setPergunta_id(Integer.parseInt(pergunta_id));
			resposta.setAlternativa(Integer.parseInt(alternativa));
			resposta.setData_resposta(new Date(new java.util.Date().getTime()));
			
			IFabricaConexoes fabrica = new FabricaConexoesPostegres();
			IRespostadao respostadao = new RespostadaoPostegres(fabrica.obterConexao());
			respostadao.atualizar(resposta);
			
			response.sendRedirect("resposta/ListarRespostas.jsp");
			
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
