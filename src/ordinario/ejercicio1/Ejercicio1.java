package ordinario.ejercicio1;

public class Ejercicio1 {
	
	static final int UNIDADESMINIMAS=500;
	static final int CAPACIDADINICIAL=200;
	static final int DISTANCIAINICIAL=0;
	
	
	/**
	 * Método para calcular el número de almacenes necesarios para guardar una cantidad de artículos
	 * El primer almacén cuenta con una capacidad inicial; cada sucesivo almacén duplica la capacidad del anterior
	 * @param numUnidades  número de artículos que deben almacenarse
	 * @return array con dos valores enteros: [0]: número de almacenes necsarios
	 * 											[1]: distancia a la que se encuentra el último almacén
	 * @throws IllegalArgumentException si el número de artículos es inferior a un umbral mínimo
	 */
	public static int[] calcularAlmacenesAntiguo (int numUnidades) throws IllegalArgumentException{
		
		//validación de la entrada
		if (numUnidades < UNIDADESMINIMAS) {
			throw new IllegalArgumentException (" El número mínimo de unidades debe ser "+UNIDADESMINIMAS );
		}
		
		//definición del retorno de la función: Array con 2 celdas
		int[] retorno= new int[2];
		
		//incialización de variables
		int capacidad= CAPACIDADINICIAL;
		int capacidadAnterior= CAPACIDADINICIAL;
		int distanciaCentro= DISTANCIAINICIAL;
		int capacidadSiguiente;
		//número de almacenes que precisamos contratar; empezamos en 1
		int numAlmacenes=1;
		
		/*
		 * La capacidad aumenta en una progresión geométrica de razón 2 ,
		 * mientras que la distancia lo hace en progresión aritmética de razón 5
		 */
		int factorCapacidad=2;
		int incrementoDistancia=5;
		
		//vamos incrementando el número de almacenes y la distancia mientras la capacidad esté por debajo del número de artículos
		while (capacidad < numUnidades) {
			numAlmacenes++;
			distanciaCentro= distanciaCentro + incrementoDistancia;
			//calculamos la capacidad del siguiente almacén y la sumamos a la capacidad total
			capacidadSiguiente= capacidadAnterior* factorCapacidad;
			
			capacidad= capacidad + capacidadSiguiente;
			
			capacidadAnterior= capacidadSiguiente;   //para el sigiente paso del cálculo
						
		}
		
		//cuando salgamos del bucle, habremos completado el número de almacenes que necesitamos
		retorno[0] = numAlmacenes;
		retorno[1] = distanciaCentro;
		return retorno;
			
	}
	
	
public static int calcularAlmacenes (int numUnidades) throws IllegalArgumentException{
		
		//validación de la entrada
		if (numUnidades < UNIDADESMINIMAS) {
			throw new IllegalArgumentException (" El número mínimo de unidades debe ser "+UNIDADESMINIMAS );
		}
		
		
		//incialización de variables
		int capacidad= CAPACIDADINICIAL;
		int capacidadAnterior= CAPACIDADINICIAL;
		
		int capacidadSiguiente;
		//número de almacenes que precisamos contratar; empezamos en 1
		int numAlmacenes=1;
		
		/*
		 * La capacidad aumenta en una progresión geométrica de razón 2 ,
		 * mientras que la distancia lo hace en progresión aritmética de razón 5
		 */
		int factorCapacidad=2;
	
		
		//vamos incrementando el número de almacenes y la distancia mientras la capacidad esté por debajo del número de artículos
		while (capacidad < numUnidades) {
			numAlmacenes++;
		
			//calculamos la capacidad del siguiente almacén y la sumamos a la capacidad total
			capacidadSiguiente= capacidadAnterior* factorCapacidad;
			
			capacidad= capacidad + capacidadSiguiente;
			
			capacidadAnterior= capacidadSiguiente;   //para el sigiente paso del cálculo
						
		}
		
		//cuando salgamos del bucle, habremos completado el número de almacenes que necesitamos
		
		return numAlmacenes;
			
	}


public static int calcularDistancia (int numUnidades) throws IllegalArgumentException{
	
	//validación de la entrada
	if (numUnidades < UNIDADESMINIMAS) {
		throw new IllegalArgumentException (" El número mínimo de unidades debe ser "+UNIDADESMINIMAS );
	}
	
	return  (calcularAlmacenes(numUnidades)-1)*5;
}
	

}
