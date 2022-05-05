package dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import modelo.Movimiento;

public interface MovimientoDao extends JpaRepository<Movimiento,Integer>{
	
	@Query("select m from Movimiento m where m.cuenta.numeroCuenta=?1")
	List<Movimiento> findByNumCuenta(int numeroCuenta);
	
	@Query("select m from Movimiento m where m.idCuenta=?1 AND m.fecha Between ?2 and ?3")
	List<Movimiento> findByFechaBetween(int numeroCuenta ,Date desde, Date hasta);
	
}
