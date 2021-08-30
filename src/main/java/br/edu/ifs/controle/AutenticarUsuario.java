package br.edu.ifs.controle;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.edu.ifs.dao.FabricaConexoesPostegres;
import br.edu.ifs.dao.IFabricaConexoes;
import br.edu.ifs.dao.IUsuariodao;
import br.edu.ifs.dao.UsuariodaoPostegres;
import br.edu.ifs.modelo.Usuario;

/**
 * Servlet implementation class AutenticarUsuario
 */
@WebServlet("/AutenticarUsuario.do")
public class AutenticarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AutenticarUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession sessao = request.getSession(false);
		
		if (sessao != null) {
			sessao.invalidate();
		}
		request.setAttribute("msg", "Sair");
		request.getRequestDispatcher("/autenticacao/Login.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String Login = request.getParameter("login");
		String Senha = request.getParameter("senha");
		
	try {
			
			IFabricaConexoes fabrica = new FabricaConexoesPostegres();
			IUsuariodao usuariodao = new UsuariodaoPostegres(fabrica.obterConexao());
			Usuario usuarioAutenticado = usuariodao.autenticar(Login, Senha); 

			if (usuarioAutenticado != null) {
				HttpSession sessao = request.getSession(true);
				sessao.setAttribute("usuarioAutenticado", usuarioAutenticado);
				
				sessao.setMaxInactiveInterval(60 * 15);
				request.getRequestDispatcher("/tema/ListarTemas.jsp").forward(request, response);
			}
			else {
				
				request.setAttribute("msg", "Erro na senha ou login!");
				request.getRequestDispatcher("/autenticacao/Login.jsp").forward(request, response);
			
			}
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
