package ordinario.ejercicio1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class Ejercicio1Test {
	
	
	@DisplayName("Comprobamos la generación de la excepción")
	@Test
	void testNoValido() {
		assertThrows(IllegalArgumentException.class, () -> {
			Ejercicio1.calcularAlmacenes(499);
		    }
		);
	}
	

	@DisplayName("Comprobando funcionamiento correcto del método")
	@Test
	void testValido() {
		
		int[] articulos = {500,1000,1500,3000,3001,6200,6201};
		int [] almacenesEsperados= {2,3,4,4,5,5,6};
		int[] distanciasEsperadas= {5,10,15,15,20,20,25};
		for (int i=0; i<articulos.length; i++) {
			assertTrue(almacenesEsperados[i] == Ejercicio1.calcularAlmacenes(articulos[i]));
			assertTrue(distanciasEsperadas[i] == Ejercicio1.calcularDistancia(articulos[i]));
		}
	   

	}

}
