package dao;

import org.springframework.data.jpa.repository.JpaRepository;
import modelo.Cuenta;

public interface CuentaDao extends JpaRepository<Cuenta,Integer>{

}
