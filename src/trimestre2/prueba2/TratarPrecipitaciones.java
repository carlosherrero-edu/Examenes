package trimestre2.prueba2;

public class TratarPrecipitaciones {
	
	static final int MESES=12;

	
	
	public static int[] obtenerPrecipitacionAnual (int[][] precipitaciones) {
		
		int num_localidades= precipitaciones.length;
		
		int [] precipitacionAnual= new int[num_localidades];
		
		for (int i=0; i<num_localidades; i++) { //recorre filas- localidades
			int suma=0;
			
			for (int j=0; j<MESES; j++) { //recorrido en cada fila
				suma = suma +precipitaciones[i][j];
			} //termino de recorrer la fila
			precipitacionAnual[i] = suma;
		}
		
		return precipitacionAnual;
	}
	
	
	
	public static int[] obtenerPromedioMensual (int[][] precipitaciones) {
		int num_localidades= precipitaciones.length;
		int[] promedioMensual= new int[MESES];
		
		
		for (int j=0; j<MESES; j++) { //recorro meses-columnas
			int suma=0;
			for (int i=0; i<num_localidades;i++) { //recorro los elementos de cada columna
				suma += precipitaciones[i][j];
			}
			promedioMensual[j] =suma/num_localidades;
			
		}
		
		return promedioMensual;
	}
	
	
	public static int[] obtenerMesesExtremos (int[][] precipitaciones, int localidad) {
		/*
		 * mesesExtremos[0] guarda el mes con la precipitación mínima
		 * mesesExtremos[1] guarda el mes con la precipitación máxima
		 */
		int[] mesesExtremos= new int[2];
		
		//inicialmente supongo que el valor máximo está en el primer elemento
		int precipitacionMaxima=precipitaciones[localidad][0];
		mesesExtremos[1]=0;
		
		//inicialmente supongo que el valor máximo está en el primer elemento
		int precipitacionMinima=precipitaciones[localidad][0];
		mesesExtremos[0]=0;
		
		for (int j=0; j<MESES; j++) {  //recorro la fila dada por "localidad"
			//localizo precipitación Máxima
			if (precipitaciones[localidad][j] > precipitacionMaxima) {
				precipitacionMaxima= precipitaciones[localidad][j];
				mesesExtremos[1]=j;
			}
			//localizo precipitación Mínima
			if (precipitaciones[localidad][j] < precipitacionMinima) {
				precipitacionMinima= precipitaciones[localidad][j];
				mesesExtremos[0]=j;
			}
		}
		
		return mesesExtremos;
	}
	
	public static int[][] obtenerMesesExtremos (int[][] precipitaciones) {
		
		int num_localidades= precipitaciones.length;
		
		int [][] mesesExtremos= new int[num_localidades][2];
		
		for (int i=0; i< num_localidades;i++) {
			mesesExtremos[i] = obtenerMesesExtremos(precipitaciones, i);
		}
		
		return mesesExtremos;
	}

}
