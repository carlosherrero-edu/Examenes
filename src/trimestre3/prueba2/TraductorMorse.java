package trimestre3.prueba2;

public class TraductorMorse {

	/*
	 * Contestar aqui&acute; al apartado 1 y definir a continuacio&acute; n el tipo
	 * de estructura necesaria
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */

	/*
	 * Definir aqui&acute; el constructor de la clase Dentro del constructor,
	 * rellenar la estructura para que se traduzcan a Morse las 5 vocales
	 */

	public static String traducirAMorse(String frase) {

		frase = frase.trim().toUpperCase();
		// cadena donde generaremos la salida del método
		String salidaMorse = "";

		// iniciar un bucle para ir recorriendo los caracteres de "frase"
		{
			/*
			 * Dentro del bucle:
			 *  leer un nuevo caracter 
			 *  a) si es separador de palabra,escribir en la salida 2 espacios. 
			 *  b) si no es separador de palabra: 
			 *  Obtener la representacio&acute;n en Morse del cara&acute;cter 
			 *  agregar la representacio&acute;n Morse a la salida 
			 *  agregar un espacio entre caractres
			 */

		} // fin del bucle

		return salidaMorse;
	} // fin función

	// clase de prueba
	public static void main(String[] args) {
		TraductorMorse traductor = new TraductorMorse();
		String frase1 = "AEIOU AEIOU AEIOU";
		String frase2 = "AAE EEA IO OOU";
		System.out.println(TraductorMorse.traducirAMorse(frase1));
		System.out.println(TraductorMorse.traducirAMorse(frase2));
	}

}
