package service;

import java.util.List;

import modelo.Pedido;

public interface PedidoService {
	
	public List<Pedido> allPedidos();
	public boolean cambiarStockProducto(int codigoProducto, int unidadesCompradas);
	public void altaPedido(Pedido pedido);
	public double precioUnitarioProducto(int codigoProducto);
}
