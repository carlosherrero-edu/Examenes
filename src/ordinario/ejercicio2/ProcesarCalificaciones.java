package ordinario.ejercicio2;

public class ProcesarCalificaciones {

	public static int contarAlumnosAprobados(double[][] calificaciones) {

		int apruebanTodo = 0; // número de alumnos que superan todos los módulos

		int numAlumnos = calificaciones.length; // número de filas
		int numModulos = calificaciones[0].length;

		// recorrido por alumos
		boolean aprueba;
		for ( double[] fila : calificaciones) {
			// recorrer las calificaciones del alumno
			aprueba = true;

			for ( double calificacion :fila) {
				if (calificacion< 5.0) {
					// ese alumno no aprueba todos los módulos
					aprueba = false;
					//break;
				}
			} // fin bucle columnas
				// si el alumno aprobó todas las materias, incremento el contador
			if (aprueba) {
				apruebanTodo++;
			}
		} // fin bucle filas

		return apruebanTodo;

	} // fin del método contarAlumnosAprobados

	public static double[] obtenerMediaAlumnos(double[][] calificaciones) {
		
		int numAlumnos = calificaciones.length; // número de filas
		int numModulos = calificaciones[0].length; //número de columnas
		
		//declaramos un array con las notas medias de cada alumno
		double[] medias= new double[numAlumnos];
		
		
		for (int i=0; i<numAlumnos; i++) { //recorrido por filas -alumnos
			double suma=0;
			
			for (int j=0; j<numModulos; j++) { //recorrido por columnas-calificaciones
				suma= suma + calificaciones[i][j];
			}
			
			
			//calculo la media de ese alumno y la guardo en el array de medias
			medias[i]=suma/numModulos;
		}

		return medias;

	}// fin del método obtenerMediaAlumnos

	public static double[][] obtenerCalificacionesExtremas(double[][] calificaciones) {
		

		int numAlumnos = calificaciones.length; // número de filas
		int numModulos = calificaciones[0].length; //número de columnas
		
		double[][] extremos= new double[numModulos][2];
		
		for (int j=0; j<numModulos;j++) {
			double notaMinima, notaMaxima;
			notaMinima=calificaciones[0][j];
			notaMaxima=calificaciones[0][j];
			
			//recorro por filas para la asignatura j
			for (int i=1; i<numAlumnos;i++) {
				// veo si tengo que actualizar la nota mínima
				if (calificaciones[i][j]<notaMinima) {
					notaMinima=calificaciones[i][j];
				}
				
				// veo si tengo que actualizar la nota maxima
				if (calificaciones[i][j]> notaMaxima) {
					notaMaxima=calificaciones[i][j];
				}
				
			}//fin del recorrido por filas
			extremos[j][0]=notaMinima;
			extremos[j][1]=notaMaxima;
			
		}//fin recorrido por columnas

		return extremos;
	} // fin del método obtenerCalificacionesExtremas

	public static void main(String[] args) {
		double[][] calificaciones = { 
				{ 5.0, 6.0, 7.0, 8.0 }, // calificaciones[0]
				{ 4.0, 5.0, 6.0, 7.0 }, // calificaciones[1]
				{ 6.0, 7.0, 8.0, 9.0 }, //
				{ 6.0, 4.9, 3.0, 8.0 }, 
				{ 5.0, 5.5, 6.0, 6.5 } // calificaciones[4] o
																// calificaciones[calificaciones.lenght-1]
		};

		//System.out.format("%nAlumnos que aprueban todo : %d %n%n", contarAlumnosAprobados(calificaciones));

		double[] medias = obtenerMediaAlumnos(calificaciones);

		// mostramos el resultado
		for (int i = 0; i < calificaciones.length; i++) {
			System.out.format("%n Media del Alumno %d : %.2f", (i + 1), medias[i]);
		}

		System.out.println("\n");

		double[][] extremos = obtenerCalificacionesExtremas(calificaciones);

		// mostramos el resultado
		for (int k = 0; k < calificaciones[0].length; k++) {
			System.out.format("%n Asignatura %d :  Nota mínima: %.2f - Nota máxima: %.2f", (k + 1), extremos[k][0],
					extremos[k][1]);
		}

	} // fin del main
}
