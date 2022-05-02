package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import modelo.Alumno;
import modelo.Curso;

@Repository
public class AlumnosDaoImpl implements AlumnosDao {

	@PersistenceContext
	EntityManager entityManager;
	
	
	@Override
	public Alumno findByUsuarioAndPassword(String usuario, String password) {
		Alumno alumno = null;
		String jpql = "select a from Alumno a where a.usuario=?1 AND a.password=?2";
		Query qr = entityManager.createQuery(jpql);
		qr.setParameter(1, usuario);
		qr.setParameter(2, password);
		try {
			alumno = (Alumno)qr.getSingleResult();
		} catch (Exception e) {
			
		}	
		return alumno;
	}

	@Override
	public List<Alumno> findByCurso(String nombreCurso) {
		String jpql = "select a from Alumno a join a.cursos c where c.nombre=:nombre";
		TypedQuery<Alumno> query = entityManager.createQuery(jpql,Alumno.class);
		query.setParameter("nombre", nombreCurso);
		List<Alumno> alumnos = query.getResultList();
		return alumnos.size()>0?alumnos:null;
	}
	
	@Override
	public List<Alumno> findAll(){
		String jpql = "select a from Alumno a";
		TypedQuery<Alumno> query = entityManager.createQuery(jpql, Alumno.class);
		return query.getResultList();
	}

	@Override
	public Alumno findById(String usuario) {
		Alumno alumno = null;
		String jpql = "select a from Alumno a where a.usuario=?1";
		Query qr = entityManager.createQuery(jpql);
		qr.setParameter(1, usuario);
		try {
			alumno = (Alumno)qr.getSingleResult();
		} catch (Exception e) {
			
		}	
		return alumno;
	}

	@Transactional
	@Override
	public void update(Alumno alumno) {
		entityManager.merge(alumno);
	}
	

}
