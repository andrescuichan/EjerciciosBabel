package modelo.persistencia.interfaces;

import java.util.List;

import entidades.Usuarios;

public interface DaoUsuario {
	
	public boolean alta(Usuarios usuario);
	public List<Usuarios> listar();
}
