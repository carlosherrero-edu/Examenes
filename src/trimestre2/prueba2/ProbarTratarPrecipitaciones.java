package trimestre2.prueba2;

import java.util.Arrays;

public class ProbarTratarPrecipitaciones {

	public static void main(String[] args) {

		int[][] precipitaciones = new int[][] { { 5, 0, 11, 15, 9, 8, 6, 4, 5, 4, 7, 7 },
				{ 6, 4, 14, 14, 8, 5, 5, 2, 7, 5, 8, 7 }, 
				{ 8, 4, 15, 14, 10, 3, 4, 3, 6, 4, 9, 7 },
				{ 15, 5, 10, 25, 11, 6, 5, 5, 7, 12, 11, 15 }, 
				{ 12, 3, 7, 21, 8, 6, 4, 6, 7, 8, 10, 14 },
				{ 13, 3, 9, 21, 9, 2, 3, 3, 6, 14, 14, 15 }, 
				{ 5, 2, 7, 19, 11, 10, 5, 6, 7, 5, 10, 15 },
				{ 9, 2, 13, 18, 12, 11, 5, 5, 10, 11, 0, 10 } };
				
				int[] minimos = { 1, 7, 5, 1, 1, 5, 1, 10 };
				int[] maximos = { 3, 2, 2, 3, 3, 3, 3, 3 };
			
		//prueba1
		try {

			int[] precipitacionAnual = TratarPrecipitaciones.obtenerPrecipitacionAnual(precipitaciones);
			int[] esperados1 = { 81, 85, 87, 127, 106, 112, 102, 106 };
			boolean resultado1 = Arrays.equals(precipitacionAnual, esperados1);
			System.out.println("Prueba 1 :" + (resultado1 ? "Correcta" : "Fallida"));

		} catch (Exception e) {
			System.out.println("Se encontr� el siguiente error en Prueba 1 :" + e.getMessage());
		}

		//prueba2
		try {

			int[] promedioMensual = TratarPrecipitaciones.obtenerPromedioMensual(precipitaciones);
			int[] esperados2 = { 9, 2, 10, 18, 9, 6, 4, 4, 6, 7, 8, 11 };
	
		
			boolean resultado2 = Arrays.equals(promedioMensual, esperados2);
			System.out.println("Prueba 2 :" + (resultado2 ? "Correcta" : "Fallida"));

		} catch (Exception e) {
			System.out.println("Se encontr� el siguiente error en Prueba 2 :" + e.getMessage());
		}

		//prueba 3
				try {

			
					boolean resultado3 = true;
			
					for (int i=0; i<precipitaciones.length; i++) {
						int[] valores= TratarPrecipitaciones.obtenerMesesExtremos(precipitaciones, i);
						// comprobar valores
						if (valores[0]!=minimos[i] || valores[1]!=maximos[i]) {
							resultado3 = false; // al haber una discrepancia, la prueba falla
							break;
						}
						
					}

					System.out.println("Prueba 3 :" + (resultado3 ? "Correcta" : "Fallida"));

				} catch (Exception e) {
					System.out.println("Se encontr� el siguiente error en Prueba 3 :" + e.getMessage());
				}
//		
		//prueba 4
		try {

			int[][] extremos = TratarPrecipitaciones.obtenerMesesExtremos(precipitaciones);

			boolean resultado4 = true;
			int contador = 0;
			for (int[] fila : extremos) {
				// comprobar m�nimo
				if (fila[0] != minimos[contador]) {
					resultado4 = false;
					break;
				}
				// comprobar m�ximo
				if (fila[1] != maximos[contador]) {
					resultado4 = false;
					break;
				}
				contador++;

			}

			System.out.println("Prueba 4 :" + (resultado4 ? "Correcta" : "Fallida"));

		} catch (Exception e) {
			System.out.println("Se encontr� el siguiente error en Prueba 3 :" + e.getMessage());
		}

//		int [][] extremos = TratarPrecipitaciones.obtenerMeseExtremos(precipitaciones);
//		
//		for (int i=0; i<precipitaciones.length; i++) {
//			System.out.format("%n Localidad %d  : Mes m�nimo: %d   Mes M�ximo: %d",
//					           i, extremos[i][0],extremos[i][1] );
//		}
//		

	}
}
