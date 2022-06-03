package ordinario.ejercicio2;

public class PruebaCalificaciones {

	static final double MINAPROBADO = 5.0;

	public static int contarAlumnosAprobados (double[][] calificaciones) {
		
		//iniciar contador con los alumnos aprobados
		int apruebanTodo=0;
		
		//hacemos un bucle para recorrer los alumnos
		for (double [] alumno: calificaciones) {
			boolean noSuspensos=true;
			/*
			 * REcorremos las calificaciones del alumno
			 * Si hay algún suspenso, abandonamos el bucle y cambiamos noSuspensos
			 */
			for (double nota: alumno) {
				if (nota <MINAPROBADO) {
					//tiene un suspenso: salimos del bucle
					noSuspensos=false;
					break;
				}
			} 
			//si ha aprobado todas las asignaturas, incrementamos el contador
			if (noSuspensos) {
				apruebanTodo++;
			}
		} //fin del primer bucle
		
	
		return apruebanTodo;
		
		
	} //fin del método contarAlumnosAprobados
	
	public static double[] obtenerMediaAlumnos(double[][]calificaciones) {
		int numAsignaturas= calificaciones[0].length;
		//iniciamos el array con las medias
		double[] medias= new double[calificaciones.length];
		
		//hacemos un bucle para recorrer los alumnos
		for (int i=0; i<calificaciones.length; i++) {
			double suma=0.0;
			/*
			 * REcorremos las calificaciones del alumno
			 * Si hay algún suspenso, abandonamos el bucle y cambiamos noSuspensos
			 */
			for (int k=0; k<numAsignaturas; k++) {
				suma+=calificaciones[i][k];
			} 
			//calculamos la media y la guardamos en la posición correspondiente de medias
			medias[i]= suma/numAsignaturas;
		} //fin del bucle por recorrido de alumnos
	
		return medias;
		
	}//fin del método obtenerMediaAlumnos
	
	public static double[][] obtenerCalificacionesExtremas(double[][] calificaciones) {
		
		int numAsignaturas= calificaciones[0].length;
		//iniciamos el array con los valores extremos
		double[][] extremos= new double[numAsignaturas][2];
		
		//hemos de recorrer el array por columnas
		for (int k=0; k<numAsignaturas; k++) {
			//para cada asignatura, el mínimo inicialmente es 10 y el máximo es 0
			double minimo=10;
			double maximo=0;
			//recorremos por filas (alumnos)
			for (int i=0; i<calificaciones.length; i++) {
				if (calificaciones[i][k]<minimo) {
					//hay que actualizar el valor mínimo
					minimo=calificaciones[i][k];
				}
				
				if (calificaciones[i][k]>maximo) {
					//hay que actualizar el valor maximo
					maximo=calificaciones[i][k];
				}
			}//fin del recorrido por filas
			//guardamos el valor mínimo y máximo para esa asignatura
			extremos[k][0]=minimo;
			extremos[k][1]=maximo;
		}
		
		return extremos;
	} //fin del método obtenerCalificacionesExtremas
		
		

	

	public static void main(String[] args) {
		double [][] calificaciones= {
				{5.0, 6.0, 7.0, 8.0},
				{4.0, 5.0, 6.0, 7.0},
				{6.0, 7.0, 8.0, 9.0},
				{6.0, 7.0, 3.0, 8.0},
				{5.0, 5.5, 6.0, 6.5}
		};
		
		System.out.format("%nAlumnos que aprueban todo : %d %n%n",  contarAlumnosAprobados(calificaciones));
		
		double[] medias= obtenerMediaAlumnos(calificaciones);
		
		//mostramos el resultado
		for (int i=0; i<calificaciones.length; i++) {
			System.out.format("%n Media del Alumno %d : %.2f", (i+1),medias[i]);
		}
		
		System.out.println("\n");
		
		double[][] extremos= obtenerCalificacionesExtremas(calificaciones);
							
		
	
	//mostramos el resultado
			for (int k=0; k<calificaciones[0].length; k++) {
				System.out.format("%n Asignatura %d :  Nota mínima: %.2f - Nota máxima: %.2f",
									(k+1),extremos[k][0], extremos[k][1]);
			}

	} //fin del main
}


