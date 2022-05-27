package trimestre3.prueba3.ejercicio3;

/**
 * @author Carlos Herrero
 *
 */
public abstract class Paquete implements Comparable<Paquete>{
	
	//atributos
	private int largo;
	private int ancho;
	private int alto;
	private double peso;
	private String destinatario;
	private boolean prioritario;
	
	public Paquete(int largo, int ancho, int alto, double peso) {
		//todas las propiedades deben ser >0
		if (largo>0 && ancho>0 && alto>0 &&peso >0) {
			this.largo = largo;
			this.ancho = ancho;
			this.alto = alto;
			this.peso = peso;
			setPrioritario(false);
			
		} else {
			//alguna de las propiedades no es correcta, lanzamos una excepción
			throw new IllegalArgumentException ("Alguno de los valores pasados no es >0");
		}
	
	}

	public Paquete(int largo, int ancho, int alto, double peso, String destinatario, boolean prioritario) {
		//llamamos al constructor anterior
		this(largo, ancho, alto, peso);
		setDestinatario(destinatario);
		setPrioritario(prioritario);
		this.destinatario = destinatario;
		this.prioritario = prioritario;
	}
	
	//getters y setters. Muchas propiedades no tienen set, sólo se cambian en constructor

	public String getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}

	public boolean isPrioritario() {
		return prioritario;
	}

	public void setPrioritario(boolean prioritario) {
		this.prioritario = prioritario;
	}

	public int getLargo() {
		return largo;
	}

	public int getAncho() {
		return ancho;
	}

	public int getAlto() {
		return alto;
	}

	public double getPeso() {
		return peso;
	}
	
	public int calcularVolumen() {
		return this.largo*this.ancho*this.alto;
	}
	
	public abstract double calcularCosteEnvio();
	
	public int compareTo (Paquete otro) {
		
		//si el primer paquete es prioritario y el segundo no...
		if (this.isPrioritario() && !otro.isPrioritario()) {
			return -1;
		} else {
			//si el primer paquete no es prioritario y el segundo si...
			if (!this.isPrioritario() && otro.isPrioritario()) {
				return +1;
			} else {
				//ordenar según peso; primero el más ligero
				return Double.compare(this.getPeso(), otro.getPeso());
			}
		}
	}
	

}
