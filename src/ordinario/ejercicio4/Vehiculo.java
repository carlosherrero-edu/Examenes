package ordinario.ejercicio4;

public abstract class Vehiculo {

	protected double velocidadActual;

	// constructores

	public Vehiculo(double velocidad) throws IllegalArgumentException {

		try {
			setVelocidadActual(velocidad);
		} catch (IllegalArgumentException e) {
			throw e;
		}
	}

	public Vehiculo() {
		setVelocidadActual(0.0);
	}

	// métodos get y set de velocidadActual

	public double getVelocidadActual() {
		return velocidadActual;
	}


	public void setVelocidadActual(double velocidadActual) {
		if (velocidadActual < 0) {
			throw new IllegalArgumentException("La velocidad no puede ser negativa");
		}
		this.velocidadActual = velocidadActual;
	}

//método común en las clases hijas
	public void detener() {
		setVelocidadActual(0.0);
	}

}
