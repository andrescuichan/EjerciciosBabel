package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import dao.PedidoDao;
import modelo.Pedido;


@Service
public class PedidoServiceImpl implements PedidoService{
	
	PedidoDao pedidosDao;
	RestTemplate template;
	
	String urlBase = "http://servicio-productos/app";
	
	public PedidoServiceImpl(@Autowired PedidoDao pedidosDao, @Autowired RestTemplate template) {
		super();
		this.pedidosDao = pedidosDao;
		this.template = template;
	}

	@Override
	public List<Pedido> allPedidos() {
		return pedidosDao.findAll();
	}
	
	@Override
	public void altaPedido(Pedido pedido) {
		pedidosDao.save(pedido);	
	}
	
	@Override
	public boolean cambiarStockProducto(int codigoProducto, int unidadesCompradas) {
		return template.exchange(urlBase + "/Producto?codigoProducto="+ codigoProducto +"&unidadesCompradas=" + unidadesCompradas, 
				HttpMethod.PUT, null, boolean.class).getBody();
	}

	@Override
	public double precioUnitarioProducto(int codigoProducto) {
		return template.exchange(urlBase + "/Producto/" + codigoProducto, 
				HttpMethod.GET, null, double.class).getBody();
	}
	
}
