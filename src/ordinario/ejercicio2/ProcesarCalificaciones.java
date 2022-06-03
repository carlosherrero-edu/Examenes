package ordinario.ejercicio2;

public class ProcesarCalificaciones {



	public static int contarAlumnosAprobados (double[][] calificaciones) {
		
		
		return 0;
		
		
	} //fin del método contarAlumnosAprobados
	
	public static double[] obtenerMediaAlumnos(double[][]calificaciones) {
		
	
		return null;
		
	}//fin del método obtenerMediaAlumnos
	
	public static double[][] obtenerCalificacionesExtremas(double[][] calificaciones) {
		
	
		
		return null;
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


