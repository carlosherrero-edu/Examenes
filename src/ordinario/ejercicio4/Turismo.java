package ordinario.ejercicio4;



public class Turismo extends Vehiculo implements Imprimible {
	
	final double VELOCIDAD_MAXIMA=120;
	
	//propiedades de la clase Turismo
	private String matricula;
	private double potencia;
	
	//constructor único
	public Turismo(double velo, String matricula, double potencia) throws IllegalArgumentException{
		
		try {
			this.setVelocidadActual(velo);
			this.setMatricula(matricula);
			this.setPotencia(potencia);
		}catch (IllegalArgumentException e) {
			throw e;
		}
	
	
	}
	
	//métodos getXxX y setXxX
	public double getPotencia() {
		return potencia;
	}

	public void setPotencia(double potencia) {
		if (potencia >0) {
			this.potencia = potencia;
		} else {
			throw new IllegalArgumentException ("La potencia de un turismo debe ser mayor de 0");
		}
	}

	
	
	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		if (matricula.matches("^\\d{4}[A-Z]{3}$")) {
			this.matricula = matricula;
		} else {
			throw new IllegalArgumentException ("La matrícula de un turismo debe obedecer el patrón 9999AAA");
		}
	
	}
	
	//método redefinido de la clase Vehículo
	@Override
	public void setVelocidadActual (double velocidad) {
		if ( velocidad <0 || velocidad >VELOCIDAD_MAXIMA) {
			throw new IllegalArgumentException ("La velocidad debe estar comprendida entre 0 y " + VELOCIDAD_MAXIMA);
		}
		this.velocidadActual= velocidad;
	}

	


	public void acelerar(double aumento) throws IllegalArgumentException {
		
		try {
			setVelocidadActual (getVelocidadActual()+ aumento);
		}catch (IllegalArgumentException e) {
			throw e;
		}
	

	}

	public void frenar(double reduccion) throws IllegalArgumentException {
		
		try {
			setVelocidadActual (getVelocidadActual()- reduccion);
		}catch (IllegalArgumentException e) {
			throw e;
		}
	

	}

	
	
	//método heredado de la interfaz
	@Override
	public void imprime(){
			
		
		System.out.println("Matrícula  : "+ this.getMatricula());
		System.out.println("Velocidad actual  : "+ this.getVelocidadActual());
		System.out.println("Potencia  :"+ this.getPotencia());
				
	
	}

}
