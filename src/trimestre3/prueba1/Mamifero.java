package trimestre3.prueba1;

/**
 * Clase Mamifero que hereda de Mascota y desarrolla la interfaz Monitorizable
 * @author Carlos Herrero-Carlos Molina
 *
 */
public class Mamifero extends Mascota implements Monitorizable {
	
	final String ERCHIP="\\d{15}";
	 
	//propiedad nueva de la clase
	private String chip;
	

	/**
	 * Constructor único de la clase
 	*  @param nombre cadena con elnombre de la mascota, al menos 5 caracteres
	 * @param especie cadena con la especie a la que pertenece, al menos 5 caracteres
	 * @param fechaNacimiento cadena con la fecha de nacimiento, en formato "AAAA-MM"
	 * @param peso peso en kilogramos
	 * @param chip cadena con el identificador de chip, con 15 dígitos
	 */
	public Mamifero(String nombre, String especie, String fechaNacimiento, double peso, String chip) {
		super(nombre, especie, fechaNacimiento, peso);
		
		if (!chip.matches(ERCHIP))throw new IllegalArgumentException("El chip debe tener 15 digitos");
		else this.chip=chip;		
	}

	
	//métodos get públicos
	public String getChip() {
		return chip;
	}
	
	@Override
	public String toString() {
		return "Mamifero [" + super.toString() + " chip=" + chip + "]";
	}


	/**
	 *Método para calcular el consumo de la mascota en Kilocalorías, según su peso
	 */
	@Override
	public double calcularDieta() {
		
		double calorias;
		
		if (getPeso()<40) 
			calorias=  getPeso()*40+380;
		else calorias =  
				getPeso()*35+580;
		
		
		return calorias;
		
	}


	
	
	
	
	

}
