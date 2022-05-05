package trimestre3.prueba1;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Clase de prueba en la que creamos una lista de objetos de la clase Mascota
 * la recorremos y vamos mostrando sus propiedades
 * @author Carlos Herrero - Carlos Molina
 *
 */
public class PruebaMascotas {
	
	public static void main(String[] args) {
		
		/*
		 * Lista din�mica de mascotas gestionada sobre ArrayList
		 */
		ArrayList<Mascota> mascotas = new ArrayList<>();

		mascotas.add(new Reptil("Pirulo", "Iguana", "2017-03", 30.0));
		mascotas.add(new Mamifero("Taliii", "Perro", "2015-04", 30.0, "111111111111111"));
		mascotas.add(new Ave("Lolaaa", "Agaporni", "2018-02", 0.05, "AAA252"));
		mascotas.add(new Reptil("Nombre", "Iguana", "2015-12", 30.0));
		mascotas.add(new Ave("Chiquito", "Agaporni", "2018-03", 0.075, "AAA999"));

		// ordenaci�n de  las mascotas por su orden natural, con Collections.sor
		Collections.sort(mascotas);

		//recorrido de la clase mostrando la informaci�n que nos piden
		for (Mascota animal : mascotas) {

			System.out.println("****************\n"+animal.toString());
			System.out.format("El animal tiene actualmente %d a�os %n", animal.calcularEdad());
			/*
			 * Se puede comprobar si el animal es de la clase Mamifero o Ave y hacer la
			 * conversi�n descendente (casting) para poder invocar al m�todo calcularDieta
			 * 
			 * if (animal instanceof Mamifero){ //
			 * System.out.format("El animal consume %.2f Kilocalor�as diarias %n",
			 * ((Mamifero)animal).calcularDieta()); // } else if (animal instanceof Ave){ //
			 * System.out.format("El animal consume %.2f Kilocalor�as diarias %n",
			 * ((Ave)animal).calcularDieta()); // } // } // }
			 * 
			 * ... pero hay una soluci�n m�s concisa y elegante comprobando si "pertenece" 
			 * a la interfaz Monitorizable, que es de donde procede calcularDieta()
			 */

			if (animal instanceof Monitorizable) {
				System.out.format("El animal consume %.2f Kilocalor�as diarias %n",
						((Monitorizable) animal).calcularDieta());
			}

		}
	}
}
