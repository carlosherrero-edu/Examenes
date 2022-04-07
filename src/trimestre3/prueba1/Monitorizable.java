package trimestre3.prueba1;

/**
 * Interfaz Monitorizable para el control de dieta de mascotas
 * @author Carlos Herrero- Carlos Molina
 *
 */
public interface Monitorizable {
	
	
	/**
	 * Método que calcula el consumo diario de una mascota según su peso
	 * @return consumo diario aconsejado para la mascota en Kilocalorías
	 */
	public double calcularDieta();

}
