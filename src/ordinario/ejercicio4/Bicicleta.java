package ordinario.ejercicio4;

public class Bicicleta extends Vehiculo implements Imprimible{
	
	final int PLATO_MAXIMO = 3;
	final int PIÑON_MAXIMO = 8;
	final double VELOCIDAD_MAXIMA= 50.0;
	final double INCREMENTO_VELOCIDAD= 5.0;
	

	//métodos
	// velocidadActual la llevamos a la clase padre, junto con sus getters y setters
	
	private int platoActual;
	private int pinonActual;
	
	//constructores
	
	public Bicicleta (double velo, int plato, int pinon){
		
		super(velo);
		
		try {
			setPlatoActual(plato);
			setPinonActual(pinon);
		}catch (IllegalArgumentException e) {
			throw e;
		}
		
	}
	
	public Bicicleta(){
		this (0.0, 1, 1);
	}
	
	
	//métodos getXxX y setXxX
	
	public int getPlatoActual() {
		return platoActual;
	}
	public void setPlatoActual(int platoActual) {
		if (platoActual<1 || platoActual> PLATO_MAXIMO){
			throw new IllegalArgumentException("El plato no está entre los valores permitidos");
		}
		this.platoActual = platoActual;
	}
	
	
	public int getPinonActual() {
		return pinonActual;
	}
	
	
	public void setPinonActual(int pinonActual) {
		if (pinonActual<1 || pinonActual> PIÑON_MAXIMO){
			throw new IllegalArgumentException("El piñón no está entre los valores permitidos");
		}
		this.pinonActual = pinonActual;
	}
	
	//métodos que nos pide el enunciado
	public void acelerar(){
	
			if (getVelocidadActual()+ INCREMENTO_VELOCIDAD < VELOCIDAD_MAXIMA) {
				setVelocidadActual(getVelocidadActual()+ INCREMENTO_VELOCIDAD);
			} else {
				setVelocidadActual(VELOCIDAD_MAXIMA);
			}
		
		
	}
	
	public void frenar(){
		setVelocidadActual (0.5*getVelocidadActual());
		
	}
	
	
	
	public void cambiarPlato (int nuevoPlato) throws IllegalArgumentException{
		try {
			this.setPlatoActual(nuevoPlato);
		}catch (IllegalArgumentException e) {
			throw e;
		}
		
		
	}
	
	
	
	public void cambiarPinon (int nuevoPinon) throws IllegalArgumentException{
		
		try {
			this.setPinonActual(nuevoPinon);
		}catch (IllegalArgumentException e) {
			throw e;
		}
		
		
	}
	
	
	
	//implementación de la interfaz
	public void imprime(){
		System.out.println("Velocidad actual :"+ this.getVelocidadActual());
		System.out.println("Plato actual:" + this.getPlatoActual());
		System.out.println("Piñón actual"+ this.getPinonActual());
	}
	
	
}
