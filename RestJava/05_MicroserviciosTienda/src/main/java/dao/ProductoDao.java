package dao;

import org.springframework.data.jpa.repository.JpaRepository;

import modelo.Producto;


public interface ProductoDao extends JpaRepository<Producto,Integer>{

}
