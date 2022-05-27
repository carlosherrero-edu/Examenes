package trimestre3.prueba2;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class GestionarTurnosTest {
	
	//objeto de la clase GestionarTurnos que se usará durante las pruebas
	GestionarTurnos turnos;

	@BeforeEach
	void setUp() throws Exception {
		turnos=new GestionarTurnos();
		
		turnos.asignarTurno("11111111A");
		
		turnos.asignarTurno("22222222B");
		turnos.asignarTurno("33333333C");

	}

	@AfterEach
	void tearDown() throws Exception {
		turnos=null;
		
	}

	@Test
	@DisplayName("Llegada de un cliente cuando hay más clientes en espera")
	void testAsignarTurno1() {
		//agregamos un nuevo cliente a la lista
		assertEquals(3,turnos.asignarTurno("44444444D"));
	}
	
	@Test
	@DisplayName("Llegada de un cliente cuando la lista está vacía")
	void testAsignarTurno2() {
		//vaciamos la lista, instanciándola de nuevo
		turnos=new GestionarTurnos();
		//agregamos un nuevo cliente a la lista 
		assertEquals(0,turnos.asignarTurno("33333333C"));
	}
	
	@Test
	@DisplayName("No se agrega a un cliente que está ya en espera")
	void testAsignarTurno3() {
	
		//agregamos un cliente que ya existe en la lista
		assertTrue(turnos.asignarTurno("22222222B")<0);
	}

	@Test
	@DisplayName("Obtención del turno de un cliente de la lista")
	void testDimeMiTurno1() {
		assertEquals(2,turnos.dimeMiTurno("33333333C"));
	}
	
	@Test
	@DisplayName("Obtención del turno de un cliente que no está en la lista")
	void testDimeMiTurno2() {
		//preguntamos por el turno de un cliente que no existe
		assertTrue(turnos.dimeMiTurno("44444444B")<0);
	}

	@Test
	@DisplayName("Eliminación de un cliente existente")
	void testEliminarTurno1() {
		//eliminamos a un cliente existente
		assertTrue(turnos.eliminarTurno("22222222B"));
	}
	
	@Test
	@DisplayName("Eliminación de un cliente que no existe")
	void testEliminarTurno2() {
		//tratamos de eliminar a un cliente que no existe en la lista
		assertFalse(turnos.eliminarTurno("44444444D"));
	}

	@Test
	@DisplayName("Se atiende a un cliente en una lista vacía")
	void testAtenderCliente1() {
		//dejamos vacía la lista, instanciándola de nuevo
		turnos=new GestionarTurnos();
		assertTrue(turnos.atenderCliente().equals(""));
	}
	
	@Test
	@DisplayName("Se atiende a un solo cliente")
	void testAtenderCliente2() {
	
		assertTrue(turnos.atenderCliente().equals("11111111A"));
	}
	
	@Test
	@DisplayName("Se atiende a menos clientes que los que hay en espera")
	void testAtenderClientes1() {
		String[] lista=turnos.atenderCliente(2);
		assertArrayEquals(new String[] {"11111111A","22222222B"}, lista);
	}
	
	@Test
	@DisplayName("Se atiende a más clientes que los que hay en espera")
	void testAtenderClientes2() {
		String[] lista=turnos.atenderCliente(4);
		assertArrayEquals(new String[] {"11111111A","22222222B","33333333C"}, lista);
		
	}

}
