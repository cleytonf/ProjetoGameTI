package br.edu.ifs.controle;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;  

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
import br.edu.ifs.util.FormataData;

/**
 * Servlet implementation class CadastrarResposta
 */
@WebServlet("/CadastrarResposta.do")
public class CadastrarResposta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastrarResposta() {
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
		
		// Recuperar os parâmetros do request - Enviados do JSP
				
				Usuario usuario = (Usuario) request.getSession().getAttribute("usuarioAutenticado");
		
				int usuario_id = usuario.getId();
				String pergunta_id = request.getParameter("pergunta_id");
				String alternativa = request.getParameter("alternativa");
				
				
			   
				
			     
				try { 
					
					
				Resposta resposta = new Resposta(usuario_id,Integer.parseInt(pergunta_id), Integer.parseInt(alternativa), null);
				IFabricaConexoes fabrica = new FabricaConexoesPostegres();
				IRespostadao respostadao = new RespostadaoPostegres(fabrica.obterConexao());
				int id = respostadao.criar(resposta);

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
