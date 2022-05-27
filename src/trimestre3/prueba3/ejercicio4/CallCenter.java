package trimestre3.prueba3.ejercicio4;

import java.util.LinkedList;
import java.time.Duration;
import java.time.LocalTime;

public class CallCenter {
	
	private LinkedList<LlamadaEnEspera> colaLlamadas;
	
	//constructor
	public CallCenter() {
		colaLlamadas= new LinkedList<>();
	}
	
	/**
	 * Método para devolver el número de llamadas que existen en la cola
	 * @return tamaño de la cola
	 */
	public int devolverNumeroLlamadas() {
		return colaLlamadas.size();
	}
	
	/**
	 * Método para localizar la posición de un número de teléfono en la cola
	 * @param numero cadena con el número de teléfono que buscamos
	 * @return índice del nodo que coincide con ese número de teléfono, o -1 si no hay ninguno
	 */
	int buscarTelefono(String numero) {
		//hay que buscar la lista hasta que encontremos ese nï¿½mero
		int contador=0;
		boolean encontrado=false;
		for (LlamadaEnEspera llamada: colaLlamadas) {

			if (llamada.getTelefono().equals(numero)){
				//hemos encontrado el nï¿½mero: abandomanos el bucle
				encontrado=true;
				break;
			}
			contador++;  //vamos aumentando el contador
		}//fin del bucle for 
		
		//si no se ha encontraro el numero, devuelve -1
		return (encontrado?contador:-1);
	}

	/**
	 * Metodo para poner una nueva llamada en espera
	 * @param telefono numero de telefono que deseamos poner en espera
	 * genera una excepción si hay un elemento en la cola con ese numero
	 */
	public void ponerEnEspera(String telefono) {
		
		if (buscarTelefono(telefono)>=0) {
			throw new IllegalArgumentException ("Ese telefono ya se encuentra en la cola de espera");
		}
		
		colaLlamadas.addLast(new LlamadaEnEspera(telefono));
		
		
		
	}  
	
	
	/**
	 * Metodo para devolver el primer numero de la cola
	 * @return cadena con el numero de telefono que lleva mas tiempo en la cola
	 * genera una excepcion si la cola está vacia
	 */
	public String atenderLlamada() {
		
		if (colaLlamadas.isEmpty()) {
			throw new IllegalArgumentException ("La cola se encuentra vacia");
		}
		
		return colaLlamadas.pop().getTelefono();
	}
	
	/**
	 * Metodo para eliminar un nodo de la cola de llamadas
	 * @param telefono numero de telefono que queremos eliminar
	 * Genera una excepcion si no hay ningun elemento en la cola con ese numero
	 */
	public void eliminarLlamada (String telefono) {
		int posicion;
		if ((posicion=buscarTelefono(telefono))<0) {
			throw new IllegalArgumentException ("El telefono no se encuentra en la cola de espera");
		}
		//en caso contrario, la eliminamos de la cola
		colaLlamadas.remove(posicion);
		
		
	}
	
	/**
	 * Metodo para calcular el numero de segundos que lleva en espera un numero de telefono
	 * @param telefono
	 * @return numero de segundos que lleva en espera desde que entró en la cola, o -1 si no está en la cola
	 */
	public long segundosEnEspera (String telefono) {
		int posicion;
		if ((posicion=buscarTelefono(telefono))<0) {
			//el telÃ©fono no estÃ¡ en la cola, devolvemos un valor negativo
			return -1;
		} else {
			return Duration.between(colaLlamadas.get(posicion).getHora(), LocalTime.now()).getSeconds();
			
		}
	}

}
