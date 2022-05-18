package service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import dao.ProductoDao;
import modelo.Producto;

@Service
public class ProductosServiceImpl implements ProductosService{
	
	ProductoDao productosDao;
	
	
	public ProductosServiceImpl(@Autowired ProductoDao productosDao) {
		super();
		this.productosDao = productosDao;
	}


	@Override
	public Producto buscarProducto(int idProducto) {
		return productosDao.findById(idProducto).orElseGet(null);
	}


	@Override
	public void altaProducto(Producto producto) {
		productosDao.save(producto);
		
	}

	@Override
	public boolean eliminarProducto(int idProducto) {
		if (buscarProducto(idProducto) != null) {
			productosDao.deleteById(idProducto);
			return true;
		}
		return false;
	}

	@Override
	public List<Producto> todosProductos() {
		return productosDao.findAll();
	}

	@Override
	public List<String> secciones() {
		return productosDao.findAll()
				.stream()
				.map(a->a.getSeccion())
				.collect(Collectors.toList());
	}
	
	
	
}
