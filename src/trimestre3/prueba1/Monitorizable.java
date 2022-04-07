package trimestre3.prueba1;

/**
 * Interfaz Monitorizable para el control de dieta de mascotas
 * @author Carlos Herrero- Carlos Molina
 *
 */
public interface Monitorizable {
	
	
	/**
	 * M�todo que calcula el consumo diario de una mascota seg�n su peso
	 * @return consumo diario aconsejado para la mascota en Kilocalor�as
	 */
	public double calcularDieta();

}
