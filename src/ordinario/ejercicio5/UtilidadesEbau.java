package ordinario.ejercicio5;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import java.util.HashSet;

import java.util.Scanner;
import java.util.Set;

/**
 * @author Alumno
 *
 */
public class UtilidadesEbau {

	static final String SEPARADOR = ";";// caracter separador de campos
	
	 
	static Set<ResultadoEbau> leerExpedientes(){
		Set<ResultadoEbau> lista=new HashSet<>();
		
		Scanner teclado=new Scanner(System.in);
		
		boolean continuar=true;
		while (continuar) {
			
			try {
				System.out.println("Introduce el número de expediente, 0 para finalizar >>>");
				int  expediente = Integer.parseInt(teclado.nextLine());
				
				/* si se produce la condición de finalización, salimos del bucle*/
				if (expediente==0) {
					continuar=false;
					break;
				}
				System.out.println("Introduce los apellidos y nombre >>>");
				String nombre = teclado.nextLine();

				System.out.println("Introduce la calificación>>>");
				double nota = Double.parseDouble(teclado.nextLine());
				// si aquí no se producen errores, es todo correcto y creamos el bojeto
				ResultadoEbau nuevo = new ResultadoEbau(expediente, nombre, nota);
				//lo agregamos a la lista
				lista.add(nuevo);

			} catch (Exception e) {
				// si se produce cualquier excepción , mostramos el error proeucido
				System.out.println(" Se produjo el siguiente error: " + e.getMessage());

			}
			
			
		} //fin del bucle while
			

		//cerramos el objeto Scanner
		teclado.close();

		return lista;

	} 

	/**
	 * Método para almacenar registros de la clase ResultadoEbau en un fichero de texto CSV
	 * @param ruta cadena con la ruta y nombre del fichero CSV donde se agregarán los registros
	 * @param lista Colección de objetos de la clase ResultadoEbau
	 * @throws Exception si se producen errores al abrir o manipular el fichero
	 */
	static int escribirFichero(String ruta, Set<ResultadoEbau> lista) throws Exception {

		File fichero = new File(ruta);
		String linea;
		int registros=0;

		// uso la clase BufferedWriter para escribir línea a línea, pero podrían haberse
		// usado otraso muchoas
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(fichero, true))) {

			for (ResultadoEbau res : lista) {
				linea = res.getNia() + SEPARADOR + res.getApellidosNombre() + SEPARADOR + res.getCalificacion();
				// agregamos la línea al fichero con un salto de línea a continuación
				bw.write(linea);
				bw.newLine();
				registros++;
			}
			return registros;

		} catch (Exception e) {
			throw e;

		}

	}

	/**
	 * Método para generar una lista de objetos de la clase ResultadoEbau a partir de un fichero de texto
	 * @param ruta cadena con la ruta y nombre del fichero CSV donde se almacenan las propiedades de los objetos
	 * @return lista Colección de objetos de la clase ResultadoEbau
	 * la lista se devuelve ordenada en sentido decreciente por la calificación usando la clase DefinirOrden
	 * @throws Exception si se producen errores al abrir o manipular el fichero
	 * @see 
	 */
	static Set<ResultadoEbau> leerFichero(String ruta) throws Exception {

		File fichero = new File(ruta);

		Set<ResultadoEbau> lista = new HashSet<>();

		// vamos a utilizar la clase Scanner para la lectura, aunque pueden usarse otras
		try (Scanner lector = new Scanner(fichero)) {

			ResultadoEbau resu;

			while (lector.hasNextLine()) {
				// vamos leyendo línea a línea
				String linea = lector.nextLine().trim();
				// Separamos por el carácter separador
				String[] campos = linea.split(SEPARADOR);
				// creamos el nuevo objeto
				resu = new ResultadoEbau(Integer.parseInt(campos[0]), campos[1], Double.parseDouble(campos[2]));
				// lo agregamos a la colección
				lista.add(resu);
			} // llegamos al final del fichero


		} catch (Exception e) {
				throw e;
		}

		return lista;

	}
	
	/**
	 * Método para localizar el expediente de un objeto ResultadoEbau
	 * @param lista Colección de objetos de la clase ResultadoEbau.
	 * @param nia entero con el número de expediente que deseamos localizar
	 * Se puede hacer más sencillo y eficiente  ordenando previamente la lista por el nia y utilizando búsqueda binaria.
	 */
	static void buscarExpediente(Set<ResultadoEbau> lista, int nia) {
		
		//compruebo si la lista está vacía
		if (lista.size() <1) {
			System.out.println("La lista está vacía");
		} else {
			//recorremos la lista hasta encontrar ese expediente
			boolean encontrado=false;
			for (ResultadoEbau expediente: lista) {
				if (expediente.getNia()==nia) {
					//imprimimos la información
					System.out.println("Información del expediente con NIA "+ nia) ;
					System.out.format("%n Nombre y Apellidos: %80s  ***Calificación: %5.2f", 
							expediente.getApellidosNombre().trim(), expediente.getCalificacion() );
					//abandonamos el bucle
					encontrado=true;
					break;
				}
			}
			//si al final del bucle no se ha encontrado, lo indicamos
			if (!encontrado) {
				System.out.println("Este expediente no se encuentra en la lista") ;
			}
			
		}
	} //fin del método

}


