package trimestre3.prueba1;

/**
 * Clase Ave que herera de la clase Mascota y desarrolla la interfaz Monitorizable
 * @author Carlos Herrero y Carlos Molina
 *
 */
public class Ave extends Mascota implements Monitorizable {
	
	final String ERANILLA="[A-Z]{3}\\d{3}";
	/*
	 * propiedad nueva de esta clase
	 */
	private String anilla;
	

	/**
	 * Constructor único de la clase
	 * @param nombre cadena con elnombre de la mascota, al menos 5 caracteres
	 * @param especie cadena con la especie a la que pertenece, al menos 5 caracteres
	 * @param fechaNacimiento cadena con la fecha de nacimiento, en formato "AAAA-MM"
	 * @param peso peso en kilogramos
	 * @param anilla cadena con el identificador anilla, de la forma XYZ123
	 */
	public Ave(String nombre, String especie, String fechaNacimiento, double peso, String anilla) {
		super(nombre, especie, fechaNacimiento, peso);
		
		if (!anilla.matches(ERANILLA))
			throw new IllegalArgumentException("Fallo en formato de anilla");
		else 
			this.anilla=anilla;		
	
	}

	@Override
	public String toString() {
		return "Ave [" + super.toString() + " anilla= " + anilla + "]";
	}
	
	public String getAnilla() {
		return anilla;
	}

	/**
	 *Método que devuelve el consumo recomendado según el peso del ave, en KIlocalorías
	 */
	@Override
	public double calcularDieta() {
		
		double calorias;
		calorias= 84.5*Math.pow(getPeso(), 0.75);
		
		return calorias;
	}
	
	
	
	
}
