package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import modelo.Pedido;

import service.PedidoService;

@CrossOrigin("*")
@RestController
public class PedidosController {
	
	@Autowired
	PedidoService service;
	
	@GetMapping(value="Pedidos", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Pedido> pedidos(){
		return service.allPedidos();
	}
	
	@PostMapping(value="Pedido", consumes = MediaType.APPLICATION_JSON_VALUE)
	public boolean updatePedidoProductos(@RequestBody Pedido pedido) {
		if(service.cambiarStockProducto(pedido.getCodigoProducto(), pedido.getUnidades()) == true) {
			double precioUnitario = service.precioUnitarioProducto(pedido.getCodigoProducto());
			double totalRedondeado = Math.round((pedido.getUnidades() * precioUnitario) * 10.0) / 10.0;
			pedido.setTotal(totalRedondeado);
			service.altaPedido(pedido);
			return true;
		}
		return false;
	}
}
