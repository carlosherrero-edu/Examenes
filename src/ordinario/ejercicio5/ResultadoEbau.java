package ordinario.ejercicio5;



public class ResultadoEbau {

	// propiedades de la clase
	int nia;
	String apellidosNombre;
	double calificacion;

	// constructor
	public ResultadoEbau(int nia, String nombre, double calificacion) throws Exception {

		try {
			setNia(nia);
			setApellidosNombre(nombre);
			setCalificacion(calificacion);

		} catch (Exception e) {
			throw e;
		}
	}

	// getters y setters
	public int getNia() {
		return nia;
	}

	public void setNia(int nia) {

		if (!Integer.toString(nia).matches("\\d{8}")) {
			throw new IllegalArgumentException("El NIA ha de constar de 8 dígitos");
		}
		this.nia = nia;
	}

	public String getApellidosNombre() {

		return apellidosNombre;
	}

	public void setApellidosNombre(String apellidosNombre) {
		if (apellidosNombre.length() > 100) {
			throw new IllegalArgumentException("La longitud máxima del nombre y apellidos es de 100");
		}

		this.apellidosNombre = apellidosNombre;
	}

	public double getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(double calificacion) {
		if (calificacion >= 0 && calificacion <= 10) {
			this.calificacion = calificacion;
		} else {
			throw new IllegalArgumentException("La calificación debe estar entre 0 y 10");
		}

	}

	// método equals
	public boolean equals(Object otroExpe) {

		boolean sonIguales = false;
		if (otroExpe instanceof ResultadoEbau) {
			// comprobamos si los nia son iguales

			if (((ResultadoEbau) otroExpe).getNia() == this.getNia()) {
				// sólo en este caso los objetos son iguales
				sonIguales = true;
			}
		}
		return sonIguales;

	}

}
