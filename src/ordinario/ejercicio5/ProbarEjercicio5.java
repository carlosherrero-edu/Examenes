package ordinario.ejercicio5;

import java.util.Set;

public class ProbarEjercicio5 {

	public static void main(String[] args) {
		Set<ResultadoEbau> lista, listaNueva;
		
		try {
			/* llenamos la lista*/
			lista=UtilidadesEbau.leerExpedientes();
			
			/*Guardamos los expedientes en un fichero*/
			int registros= UtilidadesEbau.escribirFichero("ficheros/expedientesEbau.csv",lista);
			System.out.format("%n Se han escrito %d registros", registros);
			
			/*leemos el contenido del fichero en una nueva lista*/
			listaNueva= UtilidadesEbau.leerFichero("ficheros/expedientesEbau.csv");
			
			/*buscamos algunos expedientes*/
			UtilidadesEbau.buscarExpediente(listaNueva, 11111111);
			UtilidadesEbau.buscarExpediente(listaNueva, 55555555);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
