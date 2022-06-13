package trimestre2.prueba2;

import java.util.Arrays;

public class TratarPrecipitaciones {
	
	public static int[] obtenerPrecipitacionAnual (int[][] precipitaciones) {
		
		int localidades=precipitaciones.length;
		int meses= precipitaciones[0].length;  //va a ser 12
		
		int[] anuales= new int[localidades];
		
		for (int i=0; i<localidades;i++) {
			int suma=0;
			for (int j=0; j<meses;j++) {
				suma=suma+precipitaciones[i][j];
			}
			anuales[i]=suma;
		} //fin del bucle principal
		
		return anuales;
		
		
	}
	
	
	public static int[] obtenerPromedioMensual (int[][] precipitaciones) {
		int localidades=precipitaciones.length;
		int meses= 12;
		
		int[] promedios= new int[meses];
		
		for (int j=0; j< meses; j++) {
			int suma=0;
			
			//voy recorriendo localidades y sumando
			for (int i=0; i<localidades; i++) {
				suma= suma+precipitaciones[i][j];
			}
			promedios[j]= suma/localidades;
		}
		
		return promedios;
		
	}
	
	public static int[] obtenerMesesExtremos(int[][] lluvias, int localidad) {
		
		int[] mesesExtremos= new int[2];
		
		int mesMenor=0; 
		int lluviaMenor=lluvias[localidad][0];
		
		int mesMayor=0; 
		int lluviaMayor=lluvias[localidad][0];
		
		
		for (int j=0;j<12; j++) {
			
			if (lluvias[localidad][j]<lluviaMenor) {
				lluviaMenor=lluvias[localidad][j];
				mesMenor=j;
			}
			
			if (lluvias[localidad][j]>lluviaMayor) {
				lluviaMayor=lluvias[localidad][j];
				mesMayor=j;
			}
			
		}
		mesesExtremos[0]=mesMenor;
		mesesExtremos[1]=mesMayor;
		
		return mesesExtremos;
		
	}
	
	public static int[][] obtenerMesesExtremos (int[][] lluvias){
		
		int localidades=lluvias.length;
		
		
		int [][] mesesExtremos= new int [localidades][2];
		
		for (int i=0; i<localidades; i++) {
			
			mesesExtremos[i]=obtenerMesesExtremos(lluvias, i);
			
		}
		
		return mesesExtremos;
		
		
	}

}
