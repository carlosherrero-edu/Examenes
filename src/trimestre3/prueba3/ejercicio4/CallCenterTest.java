package trimestre3.prueba3.ejercicio4;



import static org.junit.jupiter.api.Assertions.*;



import org.junit.jupiter.api.AfterAll;

import org.junit.jupiter.api.BeforeAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CallCenterTest {
	
	static CallCenter centralita;
	static String[] telefonos = {"914445566","666777888", "915505500","678678678"};

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		centralita= new CallCenter();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		centralita=null;
	}


	@Test
	@DisplayName ("Comprobando funcionamiento correcto de PonerEnEspera")
	void test1() {
		try {
			for(String numero: telefonos) {
				centralita.ponerEnEspera(numero);
				Thread.sleep(2000); //espera de 2 segundos entre llamada y llamada
			}
			//si no se producen errores,  se da por superada la prueba
			assertTrue(centralita.devolverNumeroLlamadas()==4);
		} catch (Exception e) {
			fail("Falló el método ponerEnEspera");
		}
		
	}
	
	@Test 
	@DisplayName ("Comprobando excepción en  ponerEnEspera")
	void test2() {
		//tratamos de añadir un número que ya existe
		assertThrows(Exception.class, () -> {
			centralita.ponerEnEspera(telefonos[1]);}
		);
		
	}
	
	@Test
	@DisplayName ("Comprobando funcionamiento correcto de atenderLlamada")
	void test3() {
		try {
			for (String numero: telefonos) {
				assertTrue(centralita.atenderLlamada().equals(numero));
			}
	} catch (Exception e) {
		fail("Falló el método atenderLlamada");
	}
		
	}
	
	@Test 
	@DisplayName ("Comprobando excepción en  atenderLlamada")
	void test4() {
		//tratamos de obtener una llamada de la cola vacía
		assertThrows(Exception.class, () -> {
			centralita.atenderLlamada();}
		);
		
	}
	
	@Test
	@DisplayName ("Comprobando funcionamiento correcto de eliminarLlamada")
	void test5() {
		for(String numero: telefonos) {
			centralita.ponerEnEspera(numero);	
		}
		centralita.eliminarLlamada("915505500");
		//comprobamos que ahora la cola tiene un elemento menos
		assertTrue(centralita.devolverNumeroLlamadas()==3);
		
	}
	
	
	@Test
	@DisplayName ("Comprobando excepción en eliminarLlamada")
	void test6() {
		assertThrows(Exception.class, () -> {
			centralita.eliminarLlamada("915505500");}
		);
		
	}
	
	@Test
	@DisplayName ("Comprobando obtención duración llamadas")
	void test7() {
		centralita= new CallCenter();
		try {
			for(String numero: telefonos) {
				centralita.ponerEnEspera(numero);
				Thread.sleep(2000); //espera de 2 segundos entre llamada y llamada
			}
		
		} catch (Exception e) {
			fail("Falló el método ponerEnEspera");
		}
		assertEquals(centralita.segundosEnEspera("914445566"),8);
		assertEquals(centralita.segundosEnEspera("915505500"),4);
		
		
	}

}
