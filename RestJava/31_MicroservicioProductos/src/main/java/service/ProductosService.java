package service;

import java.util.List;

import modelo.Producto;

public interface ProductosService {
	
	public List<Producto> allProdutos();
	public boolean actualizarProducto(int codigoProducto, int unidadesCompradas);
	public double precioProducto(int codigoProducto); 
}
