package service;

import java.util.List;

import modelo.Producto;

public interface BuscadorServiceInterface {
	
	public void altaProducto(Producto producto);
	public void eliminarProducto(String nombre);
	public void modificarPrecioProducto(String nombre, double nuevoPrecio);
	public List<Producto> productosSeccion(String seccion);
	
	public List<Producto> buscarProducto (int idProducto);
	public List<Producto> buscarProducto(String nombre);

}
