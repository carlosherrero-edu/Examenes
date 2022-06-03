package ordinario.ejercicio5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import ordinario.ejercicio1.Ejercicio1;

class ResultadoEbauTest {
	
	ResultadoEbau resu;

	@DisplayName("Comprobamos creación de un objeto válido de la clase")
	@Test
	void testOK() {
		try {
			int nia=12345678;
			resu= new ResultadoEbau(nia, "Perico de los Palotes", 8.50);
			assertNotNull(resu);
			assertTrue(resu.getNia()==nia);
		} catch (Exception e) {
			//no hacemos nada si se produce la excepción
		}
	}
	
	@DisplayName("Comprobamos la generación de la excepción si el nia no es correcto")
	@Test
	void testNoValido1() {
		assertThrows(IllegalArgumentException.class, () -> {
			int nia=1234567;
			resu= new ResultadoEbau(nia, "Perico de los Palotes", 8.50);
		    }
		);
	}
	
	@DisplayName("Comprobamos la generación de la excepción si la calificación es superior a 10")
	@Test
	void testNoValido2() {
		assertThrows(IllegalArgumentException.class, () -> {
			int nia=12345679;
			double calificacion=10.01;
			resu= new ResultadoEbau(nia, "Perico de los Palotes",calificacion);
		    }
		);
	}
	
	@DisplayName("Comprobamos la generación de la excepción si la calificación es negativa")
	@Test
	void testNoValido3() {
		assertThrows(IllegalArgumentException.class, () -> {
			int nia=12345679;
			double calificacion=-0.01;
			resu= new ResultadoEbau(nia, "Perico de los Palotes",calificacion);
		    }
		);
	}

}
