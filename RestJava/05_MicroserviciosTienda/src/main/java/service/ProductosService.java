package service;

import java.util.List;

import modelo.Producto;

public interface ProductosService {
	
	Producto buscarProducto(int idProducto);
	void altaProducto(Producto producto);
	boolean eliminarProducto(int idProducto);
	List<Producto> todosProductos();
	List<String> secciones();
	
}
