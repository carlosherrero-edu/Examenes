package ordinario.ejercicio4;

public class BicicletaCarrera extends Bicicleta {
	

	
	private static final double VELOCIDAD_MINIMA = 10.0;


	//constructor
	public BicicletaCarrera (double velo, int plato, int pinon){
	
		super (velo, plato, pinon);
	
	}

	
	//método sobreescrito de Bicicleta
	@Override
	public void acelerar(){
		
			if (getVelocidadActual()==0) {
				setVelocidadActual(VELOCIDAD_MINIMA);
			} else {
				setVelocidadActual (2.0*getVelocidadActual());
			}
		
		

	}

}
