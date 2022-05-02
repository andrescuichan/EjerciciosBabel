package testing;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import config.ServiceConfig;
import modelo.Alumno;
import modelo.Curso;
import service.FormacionService;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {ServiceConfig.class})
class FormacionServiceTest {

	@Autowired
	FormacionService buscadorService;
	
	@Test
	void testValidarUsuario() {
		Alumno a = buscadorService.validarUsuario("aaa","sseeeee");
		assertEquals(a.getNombre(), "ordenador");
		assertNull(buscadorService.validarUsuario("noexistee","noexistee"));
	}
	
	@Test
	void testCursosAlumno() {
		List<Curso> c = buscadorService.cursosAlumno("admin");
		assertEquals(c.size(), 4);
		assertNull(buscadorService.cursosAlumno("noexistee"));
	}
	
	@Test
	void testListaCursos() {
		List<Curso> c = buscadorService.listaCursos();
		assertEquals(c.size(), 18);
	}
	
	@Test
	void testAlumnosCurso() {
		List<Alumno> a = buscadorService.alumnosCurso("python");
		assertEquals(a.size(), 5);
		assertNull(buscadorService.alumnosCurso("noexistee"));
	}
	
	/*
	@Test
	void testMatricularAlumno() {
		List<Curso> aBefore = buscadorService.cursosAlumno("aaa");
		buscadorService.matricularAlumno("aaa", 8);
		int aBeaforeSize = aBefore.size() + 1;
		System.out.println(aBeaforeSize);
		List<Curso> aAfter = buscadorService.cursosAlumno("aaa");
		assertEquals(aBeaforeSize,aAfter.size());
		//assertNull(buscadorService.alumnosCurso("noexistee"));
	}
	*/
	
}
