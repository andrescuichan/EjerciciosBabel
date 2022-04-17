package modelo.persistencia.Mysql;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import modelo.entidad.Coche;

class TestMySql {

	@Test
	void testBuscarId() {
		
		Coche cocheEsperado = new Coche();
		cocheEsperado.setId(3);
		cocheEsperado.setMatricula("ERTE234");
		cocheEsperado.setMarca("Ferrari");
		cocheEsperado.setModelo("12FG3");
		cocheEsperado.setKilometros(21500);
		
		DaoCocheMySql DaoCoche = new DaoCocheMySql();
		Coche cocheObtenido = DaoCoche.buscarId(3);
		
		assertEquals(cocheEsperado.toString(), cocheObtenido.toString());
	}
	
	
	
	
	
	

}
