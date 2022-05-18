package service;

import java.util.List;
import java.util.Optional;
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
	public List<Producto> allProdutos() {
		return productosDao.findAll();
	}

	@Override
	public boolean actualizarProducto(int codigoProducto, int unidadesCompradas) {
		Optional<Producto> p = productosDao.findById(codigoProducto);
		if(p.isPresent()) {
			Producto producto = p.get();
			int stockDisponible = producto.getStock() - unidadesCompradas;
			if (stockDisponible >= 0) {
				producto.setStock(stockDisponible);
				productosDao.save(producto);
				return true;
			}
		}
		return false;
	}

	@Override
	public double precioProducto(int codigoProducto) {
		Optional<Producto> p = productosDao.findById(codigoProducto);
		if(p.isPresent()) {
			Producto producto = p.get();
			return producto.getPrecioUnitario();
		}
		return 0.0;
	}

}
