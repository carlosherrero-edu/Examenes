package trimestre3.prueba3.ejercicio4;

import java.time.LocalTime;

public class LlamadaEnEspera {
	
	//propiedades
	private String telefono;
	private LocalTime hora;
	
	
	
	//constructor
	/**
	 * @param telefono
	 * @param hora
	 */
	public LlamadaEnEspera(String telefono) {
		this.telefono = telefono;
		this.hora = LocalTime.now();
	}
	
	
	//getters y setters
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public LocalTime getHora() {
		return hora;
	}
	public void setHora(LocalTime hora) {
		this.hora = hora;
	}
	

}
