package br.edu.ifs.filtro;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class FiltroDeAutenticacao
 */
@WebFilter(dispatcherTypes = {DispatcherType.REQUEST}, urlPatterns = "/*")
public class FiltroDeAutenticacao implements Filter {

	private HttpServletRequest httpRequest;
	
	private String caminhoURL;
	
	private static final String[] URLsNecessitamAutenticacao = {
	
			"/pergunta", "/resposta",  "/usuario", "/tema" 
			
	};
	
    /**
     * Default constructor. 
     */
    public FiltroDeAutenticacao() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		httpRequest = (HttpServletRequest) request;
		/*
		String path = httpRequest.getRequestURI().substring(httpRequest.getContextPath().length());
		 
		if (path.startsWith("/*")) {
		    chain.doFilter(request, response);
		    return;
		}
		*/
		
		caminhoURL = httpRequest.getRequestURI().substring(httpRequest.getContextPath().length());
		
		System.out.println(caminhoURL);
		
		HttpSession sessao = httpRequest.getSession(false);
		
		boolean usuarioEstaAutenticado = (sessao != null && sessao.getAttribute("usuarioAutenticado") != null);
		
		System.out.println(usuarioEstaAutenticado);
		
	//	String loginURI = httpRequest.getContextPath() + "/autenticacao/Login.jsp";
	//	boolean ehUmaRequisicaoLogin = httpRequest.getRequestURI().equals(loginURI);
	//	boolean ehUmaPaginaLogin = httpRequest.getRequestURI().endsWith("Login.jsp");
	
		boolean ehUmaRequisicaoLogin = caminhoURL.equals("/autenticacao/Login.jsp"); 
		
		if (usuarioEstaAutenticado && ehUmaRequisicaoLogin) {
			
			httpRequest.getRequestDispatcher("/tema/ListarTemas.jsp").forward(request, response);
			
		} else if (!usuarioEstaAutenticado && ehNecessarioAutenticacao()) {
		
			String PaginaLogin = "/autenticacao/Login.jsp";
			RequestDispatcher dispatcher = httpRequest.getRequestDispatcher(PaginaLogin);
			dispatcher.forward(request, response);
			
		} else {
			
			chain.doFilter(request, response);
			
		}
		
		
	}

		private boolean ehNecessarioAutenticacao() {
			
			
			for (String URL : URLsNecessitamAutenticacao) {
				if (caminhoURL.contains(URL)) {
					System.out.println(URL);
					return true;
				}
			}
			return false;
		}
	
	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
