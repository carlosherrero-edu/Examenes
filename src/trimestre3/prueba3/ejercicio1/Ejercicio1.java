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
		// inicializaci�n de flujos de entrada y salida
		try (BufferedReader lector = new BufferedReader(new FileReader(fich_entrada));
				BufferedWriter escritor = new BufferedWriter(new FileWriter(fich_salida))) {

			String linea, linea_ofuscada;
			// leemos el fichero de entrada linea a l�nea
			while ((linea = lector.readLine()) != null) {
				// obtenemos la l�nea ofuscada y la escribimos en fichero de salida
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

	} // fin del m�todo
	
	//12345678;Abad Martin;Pedro Luis;333.33
	//**3456**;Abad M.;P.L.;333.33

	static String ofuscarLinea(String linea) {
		String ofuscada = "";
		// separar los campos del fichero CSV
		String[] tokens = linea.split(SEPARADOR);
		// el primer token es el DNI
		//12345678
		ofuscada += "**" + tokens[0].substring(2, 6) + "**";

		// el segundo token son los dos apellidos
		String[] apellidos = tokens[1].split("\\p{Space}+");
		ofuscada += SEPARADOR+ ofuscarApellidos(apellidos[0], apellidos[1]);

		// el siguiente token es la lista de nombre o nombres

		String[] nombres = tokens[2].split("\\p{Space}+");
		ofuscada += SEPARADOR+ ofuscarNombres(nombres);

		// por ultimo, el �ltimo token se dejasin cambiar
		ofuscada += SEPARADOR + tokens[3];

		return ofuscada;
	}

	static String ofuscarApellidos(String apellido1, String apellido2) {
	
		return apellido1+" "+apellido2.substring(0, 1) + ".";

	}

	static String ofuscarNombres(String[] nombres) {
		String resultado = "";
		
		for (String nombre : nombres) {
			resultado = resultado+ nombre.substring(0, 1) + ".";
		}// fin del bucle
		
	
		return resultado;

	}

	// prueba del m�todo de ofuscaci�n
	public static void main(String[] args) {
		Ejercicio1 objeto= new Ejercicio1();
		System.out.println("L�neas tratadas del fichero " + objeto.ofuscarFicheroBeneficiarios("."));
	}
}
