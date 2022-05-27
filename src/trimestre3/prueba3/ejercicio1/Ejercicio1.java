package trimestre3.prueba3.ejercicio1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Ejercicio1 {

	// ruta del fichero
	final static String NOMBRE1 = "beneficiarios.txt";
	final static String NOMBRE2 = "beneficiarios_ofuscado.txt";
	final static String SEPARADOR = ";";

	static int ofuscarFicheroBeneficiarios(String ruta) {

		// definimos las rutas a los ficheros de entrada y salida
		File fich_entrada = new File(ruta + "/" + NOMBRE1);
		File fich_salida = new File(ruta + "/" + NOMBRE2);
		int num_lineas = 0;
		// inicialización de flujos de entrada y salida
		try (BufferedReader lector = new BufferedReader(new FileReader(fich_entrada));
				BufferedWriter escritor = new BufferedWriter(new FileWriter(fich_salida))) {

			String linea, linea_ofuscada;
			// leemos el fichero de entrada linea a línea
			while ((linea = lector.readLine()) != null) {
				// obtenemos la línea ofuscada y la escribimos en fichero de salida
				linea_ofuscada = ofuscarLinea(linea);
				escritor.write(linea_ofuscada);
				escritor.write("\n");
				num_lineas++;
			}

		} catch (IOException e) {
			System.out.println("Se produjo el error siguiente :" + e.getMessage());
			return 0;

		}

		return num_lineas;

	} // fin del método

	static String ofuscarLinea(String linea) {
		String ofuscada = "";
		// separar los campos del fichero CSV
		String[] tokens = linea.split(SEPARADOR);
		// el primer token es el DNI
		ofuscada += "**" + tokens[0].substring(2, 6) + "**";

		// el segundo token son los dos apellidos
		String[] apellidos = tokens[1].split("\\p{Space}+");
		ofuscada += ofuscarApellidos(apellidos[0], apellidos[1]);

		// el siguiente token es la lista de nombre o nombres

		String[] nombres = tokens[2].split("\\p{Space}+");
		ofuscada += ofuscarNombres(nombres);

		// por ultimo, el último token se dejasin cambiar
		ofuscada += SEPARADOR + tokens[3];

		return ofuscada;
	}

	static String ofuscarApellidos(String apellido1, String apellido2) {
		String resultado = "";
		// el primer apellido se pasa como está
		resultado += SEPARADOR + apellido1;
		// del segndo apellido se deja solamente el punto
		resultado += " " + apellido2.substring(0, 1) + ".";
		return resultado;

	}

	static String ofuscarNombres(String[] nombres) {
		String resultado = "";
		// de cada nombre dejamos solamente la inicial y el punto
		for (int i = 0; i < nombres.length; i++) {
			// en la primera línea, hay que agregar el separador
			if (i == 0) {
				resultado += SEPARADOR;
			}
			// en cualquier caso, hay que agregar la inicial del nombre, seguida de "."
			resultado += nombres[i].substring(0, 1) + ".";

		} // fin del bucle
		return resultado;

	}

	// prueba del método de ofuscación
	public static void main(String[] args) {
		System.out.println("Líneas tratadas del fichero " + ofuscarFicheroBeneficiarios("."));
	}
}
