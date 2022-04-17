package modelo.persistencia.Mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidades.Usuarios;
import modelo.persistencia.interfaces.DaoUsuario;

public class DaoUsuarioMySql implements DaoUsuario{
	
private Connection conexion;

	static {
	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");//
	     } catch (ClassNotFoundException e) {
	        System.out.println("No se ha encontrado el driver MySQL");
	     }
	     System.out.println("Se ha cargado el driver MySQL");
	}



	
	public boolean abrirConexion(){
		String url = "jdbc:mysql://localhost:3306/bbddusuario";
		String usuario = "root";
		String password = "";
		try {
			conexion = DriverManager.getConnection(url,usuario,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean cerrarConexion(){
		try {
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@Override
	public boolean alta(Usuarios usuario) {
		if(!abrirConexion()){
			return false;
		}
		boolean alta = true;
		
		String query = "insert into usuarios (NOMBRE,PASSWORD) "
				+ " values(?,?)";
		try {
			
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setString(1, usuario.getNombre());
			ps.setString(2, usuario.getPassword());
			
			int numeroFilasAfectadas = ps.executeUpdate();
			if(numeroFilasAfectadas == 0) {
				alta = false;
			}
		} catch (SQLException e) {
			System.out.println("alta -> Error al insertar: " + usuario);
			alta = false;
			e.printStackTrace();
		} finally{
			cerrarConexion();
		}
		
		return alta;
	}
	
	
	@Override
	public List<Usuarios> listar() {
		if(!abrirConexion()){
			return null;
		}		
		List<Usuarios> listaUsuarios = new ArrayList<>();
		
		String query = "select NOMBRE,PASSWORD from usuarios";
		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				Usuarios usuario = new Usuarios();
				usuario.setNombre(rs.getString(1));
				usuario.setPassword(rs.getString(2));
				listaUsuarios.add(usuario);
			}
		} catch (SQLException e) {
			System.out.println("listar -> error al obtener las "
					+ "usuarios");
			e.printStackTrace();
		} finally {
			cerrarConexion();
		}
		return listaUsuarios;
	}

	
}
