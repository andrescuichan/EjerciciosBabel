package dao;

import org.springframework.data.jpa.repository.JpaRepository;
import modelo.Pedido;

public interface PedidoDao extends JpaRepository<Pedido,Integer>{

}
