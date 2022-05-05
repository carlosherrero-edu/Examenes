package trimestre3.prueba1;

/**
 * Clase Reptil que hereda de la clase Mascota
 * @author Carlos Herrero - CArlos Molina
 *
 */
public class Reptil extends Mascota{

	/**
	 * Constructor único de la clase
	 * @param nombre cadena con elnombre de la mascota, al menos 5 caracteres
	 * @param especie cadena con la especie a la que pertenece, al menos 5 caracteres
	 * @param fechaNacimiento cadena con la fecha de nacimiento, en formato "AAAA-MM"
	 * @param peso peso en kilogramos
	 */
	public Reptil(String nombre, String especie, String fechaNacimiento, double peso) {
		super(nombre, especie, fechaNacimiento, peso);
	
	}


	@Override
	public String toString() {
		return "Reptil [" + super.toString() + "]";
	}
	
	
	

}
