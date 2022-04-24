package service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import modelo.Producto;

@Service
public class BuscadorServiceImpl implements BuscadorServiceInterface{

	
	@PersistenceContext
	EntityManager entityManager;
	

	@Transactional
	@Override
	public void altaProducto(Producto producto) {
		// TODO Auto-generated method stub
		entityManager.persist(producto);
	}
	
	@Transactional
	@Override
	public void eliminarProducto(String nombre) {
		
		String jpql="select p from Producto p where p.nombre= :nombre";
		
		try {
			Query qr = entityManager.createQuery(jpql);
			qr.setParameter("nombre", nombre);
			Producto producto = (Producto)qr.getSingleResult();
			entityManager.remove(producto);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("nombre no encontrado");
		}
		
	}
	
	@Transactional
	@Override
	public void modificarPrecioProducto(String nombre, double nuevoPrecio) {

		String jpql = ("UPDATE Producto p SET p.precio = :nuevoPrecio WHERE p.nombre= :nombre");
		Query query = entityManager.createQuery(jpql);
		query.setParameter("nuevoPrecio", nuevoPrecio);
		query.setParameter("nombre", nombre);;
		int rowsUpdated = query.executeUpdate();
	}
	
	@Override
	public List<Producto> productosSeccion(String seccion) {
		String jpql="select p from Producto p where p.seccion='"+ seccion + "'";
		Query qr = entityManager.createQuery(jpql);
		List<Producto> productos = (List<Producto>)qr.getResultList();
		return productos;
	}
	
	@Override
	public List<Producto> buscarProducto(int idProducto) {
		String jpql="select p from Producto p where p.idProducto='"+ idProducto + "'";
		Query qr = entityManager.createQuery(jpql);
		List<Producto> productos = (List<Producto>)qr.getResultList();
		return productos;
	}
	
	@Override
	public List<Producto> buscarProducto(String nombre) {
		String jpql="select p from Producto p where p.nombre= :nombre";
		Query qr = entityManager.createQuery(jpql);
		qr.setParameter("nombre", nombre);
		List<Producto> productos = (List<Producto>)qr.getResultList();
		return productos;
	}
	
}
