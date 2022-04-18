package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Usuarios;
import modelo.negocio.GestorUsuario;

/**
 * Servlet implementation class servletControlador
 */
@WebServlet("/usuarios/login")
public class servletControlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		String password = request.getParameter("password");
		
		Usuarios usuario = new Usuarios();
		usuario.setNombre(nombre);
		usuario.setPassword(password);
		
		GestorUsuario grUsuario = new GestorUsuario();
		String validacion = grUsuario.usuarioValidado(usuario);
		
		response.getWriter().append(validacion);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
