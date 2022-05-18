package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import modelo.Producto;
import service.ProductosService;

@CrossOrigin("*")
@RestController
public class ProductosController {

	@Autowired
	ProductosService service;
	
	@GetMapping(value="Productos", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Producto> productos(){
		return service.allProdutos();
	}
	
	@PutMapping(value="Producto")
	public boolean updateProducto(@RequestParam("codigoProducto") int codigoProducto, @RequestParam("unidadesCompradas") int unidadesCompradas) {
		return service.actualizarProducto(codigoProducto, unidadesCompradas);
	}
	
	@GetMapping(value="Producto/{codigoProducto}")
	public double priceProducto(@PathVariable("codigoProducto") int codigoProducto){
		return service.precioProducto(codigoProducto);
	}
}
