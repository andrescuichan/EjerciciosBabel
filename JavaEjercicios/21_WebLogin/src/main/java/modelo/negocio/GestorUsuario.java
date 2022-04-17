package modelo.negocio;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.google.gson.Gson;

import entidades.UsuarioValidacion;
import entidades.Usuarios;
import modelo.persistencia.Mysql.DaoUsuarioMySql;
import modelo.persistencia.interfaces.DaoUsuario;

public class GestorUsuario {
	
	private DaoUsuario daoCoche = new DaoUsuarioMySql();
	
	public boolean UsuarioAutentificacion(Usuarios usuario) {
		boolean usuarioEncontradoBbdd = false;
		List<Usuarios> listaUsuarios = daoCoche.listar();
		
		for(Usuarios userLista: listaUsuarios) {
			if(userLista.getNombre().equals(usuario.getNombre()) && userLista.getPassword().equals(usuario.getPassword())) {
				usuarioEncontradoBbdd = true;
			}
		}
		
		return usuarioEncontradoBbdd;
	}
	
	public String usuarioValidado(Usuarios usuario) {
		
		Gson gson = new Gson();
		UsuarioValidacion userV = new UsuarioValidacion();
		
		if(UsuarioAutentificacion(usuario)) {
			userV.setValidado(true);
		}
		
		String json = gson.toJson(userV);
		File file = new File("listaUsuario.json");
		
		try(FileWriter fw = new FileWriter(file)){			
			fw.write(json);
			System.out.println("Fichero JSON creado");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return json;
	}
	

}
