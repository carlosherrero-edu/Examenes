package ordinario.ejercicio4;

public class BicicletaTandem extends Bicicleta {
	

	
	//propiedad de una bicicleta Tandem
	int numAsientos;
	
	//constructor
		public BicicletaTandem (double velo, int plato, int pinon, int asientos) throws IllegalArgumentException{
			super (velo, plato, pinon);
			
			try {
				this.setNumAsientos(asientos);
			}catch (IllegalArgumentException e) {
				throw e;
			}
			
		}

		
	//métodos get y set para el número de asientos	
	public int getNumAsientos() {
		return numAsientos;
	}

	public void setNumAsientos(int numAsientos) {
		if (numAsientos<2){
			throw new IllegalArgumentException("una bicicleta tandem tiene al menos 2 asientos");
		}
		this.numAsientos = numAsientos;
	}
	
	

}
