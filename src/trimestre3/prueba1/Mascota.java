package trimestre3.prueba1;

import java.time.LocalDate;


/**
 * Clase abstracta Mascota para representar la información común de una Mascota
 * @author Carlos Herrero-Carlos Molina
 *
 */
public abstract class Mascota implements Comparable<Mascota>  {
	
	final String ERFECHANACIMIENTO="^20[0-9]{2}-(0[1-9]|1[0-2])";
	
	/* 
	 * Propiedades de un objeto de la clase Mascota
	 */
	private String nombre;
	private String especie;
	private String fechaNacimiento;
	private double peso;
	
	
	/**
	 * Constructor único de la clase
	 * @param nombre cadena con elnombre de la mascota, al menos 5 caracteres
	 * @param especie cadena con la especie a la que pertenece, al menos 5 caracteres
	 * @param fechaNacimiento cadena con la fecha de nacimiento, en formato "AAAA-MM"
	 * @param peso peso en kilogramos
	 */
	public Mascota(String nombre, String especie, String fechaNacimiento, double peso) {
		
		//Validaciones de especie y fecha nacimiento que no se pueden cambiar se hacen en el propio 
		//constructor, las demas en los sets
		
		try {
			setNombre(nombre);
			
			if(especie.length()<5)throw new IllegalArgumentException("Error en nº de carácteres de la especie");
				else this.especie=especie;
			
			if(!fechaNacimiento.matches(ERFECHANACIMIENTO)) throw new IllegalArgumentException("Error en formato de fecha");
				else this.fechaNacimiento=fechaNacimiento;
			
			setPeso(peso);
			
		} catch (Exception e) {
			throw e;
		} //si pilla alguna excepcion en el constructor, la vuelve a lanzar
		
		
	}

	/*
	 * Métodos get y set públicos
	 */
	public double getPeso() {
		
		return peso;
	}

	public void setPeso(double peso) {
		
		//Set de peso con validación de valor positivo
		if(peso<0) 
			throw new IllegalArgumentException("El peso debe ser positivo");
		else 
			this.peso = peso;
	}

	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		
		//Validacion en nº de caracteres
		if(nombre.length()<5)
			throw new IllegalArgumentException("Error en nº de carácteres del nombre"); 
		else 
			this.nombre = nombre;
	}

	public String getEspecie() {
		return especie;
	}
	


	public String getFechaNacimiento() {
		return fechaNacimiento;
	}
	


	/**
	 *Método para devolver una representación imprimible de la clase
	 */
	@Override
	public String toString() {
		return "Mascota [nombre=" + nombre + ", especie=" + especie + ", fechaNacimiento=" + fechaNacimiento + "]";
	}

	/**
	 *Método para ordenar 2 mascotas por los criterios pedidos.
	 *1. Por la especie, alfabéticamente, sin distinguir mayúsculas-minúsculas
	 *2. Por la fecha de nacimiento (alfabético, pues la guardamos en la forma AAAA-MM
	 */
	@Override
	public int compareTo(Mascota o) {
		
		
		if (this.getEspecie().equalsIgnoreCase(o.getEspecie()))
			return this.getFechaNacimiento().compareTo(o.getFechaNacimiento());
		else {
			return this.getEspecie().compareToIgnoreCase(o.getEspecie());
		}
		
		
	}
	
	/**
	 * Método que devuelve la edad de la mascota a partir de su fecha de nacimiento
	 * @return edad en años , entera, contada en la fecha actual
	 */
	public int calcularEdad() {
		//año y mes actuales, obtenidos con LocalDate
		int anio= LocalDate.now().getYear();
		int mes= LocalDate.now().getMonthValue();
		/*
		 * En general parseInt debería ir en un bloque try-catch para tratar posibles errores de conversión
		 * En este caso, como la fecha de nacimiento se valida con expresión regular, sabemos que es correcta
		 */
		int mesNacimiento= Integer.parseInt(getFechaNacimiento().substring(5));
		int anioNacimiento= Integer.parseInt(getFechaNacimiento().substring(0,4));
		if (mesNacimiento>= mes) {
			//ya ha pasado el "cumpleaños" de la mascota, y ha cumplido otro año
			return (anio-anioNacimiento);
		} else {
			return (anio-anioNacimiento-1);
		}
		
	}



}
