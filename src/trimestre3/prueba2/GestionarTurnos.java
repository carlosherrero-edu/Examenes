package trimestre3.prueba2;

import java.util.LinkedList;


public class GestionarTurnos {
	
	/*
	 * Aunque pueden usarse varias estructuras, LinkedList ofrece mejor rendimiento puesç
	 * vamos a realizar continuamente altas y bajas de elementos.
	 * Gestionaremos una estructura de tipo cola
	 */
	
	private LinkedList<String> colaEspera;
	
	public GestionarTurnos() {
		colaEspera= new LinkedList<>();
	}
	
	//métodos estáticos de la clase
	
	/**
	 * Método que permite agregar un nuevo cliente a la cola de espera
	 * @param cliente cadena con un identificativo del cliente
	 * @return el número de clientes que tiene antes en espera, si no estaba ya en la cola y se le puede agregar
	 * en caso contrario, devuelve -1
	 */
	public  int  asignarTurno (String cliente) {
		//comprobamos primero si el cliente está ya en la cola
		if (colaEspera.contains(cliente)) {
			return -1;
		} else {
			/*
			 * es un nuevo cliente. Hay que agregarlo a la cola
			 * guardamos el tamaño de la cola antes de agregar el nuevo cliente, para devolverlo
			 */
			
			int clientesPorDelante=colaEspera.size();
			colaEspera.addLast(cliente);
			return clientesPorDelante;
		}
		
	}
	
	/**
	 * Método para saber el número de personas que tiene un cliente por delante en espera
	 * @param cliente cadena con un identificativo del cliente
	 * @return número de personas que están antes en la cola , o -1 si no se encuentra en la cola
	 */
	public  int  dimeMiTurno (String cliente) {
		/*
		 * Si es el primer cliente, índice 0, no tiene nadie en espera
		 */
		return colaEspera.indexOf(cliente);
	}
	
	/**
	 * Método para eliminar un cliente de la cola de espera
	 * @param cliente cadena con un identificativo del cliente
	 * @return Verdadero si el cliente existía y se le pudo eliminar, Falso en otro caso
	 */
	public  boolean  eliminarTurno (String cliente) {
		//comprobamos primero si el cliente está ya en la cola
		return colaEspera.remove(cliente);
	}
	
	/**
	 * Método para atender al primer cliente, eliminándolo de la cola de espera
	 * @return cadena con el identificativo del primer cliente, o "" si la cola está vacía
	 */
	public  String atenderCliente() {
		if (colaEspera.isEmpty()) {
			return "";
		} else {
			return colaEspera.pop();
		}

	}
	
	/**
	 * Método para atender sucesivamente a varios clientes, eliminándolos de la lista de espera
	 * @param n número de clientes que deseamos atender
	 * @return array de cadenas con los identificativos de clientes que son atendidos
	 */
	public  String[] atenderCliente(int n) {
		/*
		 * Si el tamaño de la cola es inferior a n, atendemos a todos los clientes de la cola
		 */
		int atendidos= (n< colaEspera.size()? n: colaEspera.size());
		String[] lista= new String[atendidos];//array que devolveremos
		for (int k=0; k<atendidos; k++) {
			lista[k]=atenderCliente();
			
		}
		
		return lista;

	}
}
