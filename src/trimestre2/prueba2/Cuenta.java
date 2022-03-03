package trimestre2.prueba2;

import java.util.ArrayList;

enum Oficinas {
	OFICINA1,
	OFICINA2,
	OFICINA3,
	OFICINA4
}

public class Cuenta {
	
	private static final double COMISION_FIJA = 120.0;
	
	private int codigoCuenta;
	private Oficinas oficina;
	private double saldo;
	private ArrayList<Movimiento> movimientos;
	
	
	public Cuenta(int codigoCuenta, Oficinas oficina) {
		//super();
		setCodigoCuenta(codigoCuenta);
		this.oficina = oficina;
		this.saldo=0.0;
		movimientos=new ArrayList<>();
	}

	
	
	private void setCodigoCuenta(int codigoCuenta) {
		
		if (codigoCuenta<1_000_000 || codigoCuenta>99_999_999) {
			throw new IllegalArgumentException ("El código de cuenta debe tener 7 u 8 dígitos");
		}
		
		this.codigoCuenta = codigoCuenta;
	}



	private void setSaldo(double saldo) {
		this.saldo = saldo;
	}



	public int getCodigoCuenta() {
		return codigoCuenta;
	}


	public double getSaldo() {
		return saldo;
	}
	
	public boolean agregarMovimiento(String concepto, double importe) {

		//crear el nuevo objeto Movimiento
		Movimiento nuevo= new Movimiento (this.codigoCuenta, concepto, importe);
		//agregarlo al arraylist
		boolean resultado=movimientos.add(nuevo);
		//si se ha agregado correctamente, actualizo el saldu
		if (resultado) {
			this.saldo= this.saldo+importe;
			
		}
		
		return resultado;
	}
	
	public String listarMovimientos() {
//		String salida="";
//		
//		int contador=1;
//		for (Movimiento mov: this.movimientos) {
//			salida = salida +String.format("%n Número: %2d - Concepto: %30s - Importe: %8.2f", 
//											contador, mov.getConcepto(), mov.getImporte());
//			contador++;
//			
//		}
//		
//		return salida;
		return listarMovimientos(Double.NEGATIVE_INFINITY);
	}
	
	
	public String listarMovimientos(double importeMinimo) {
		String salida="";
		
		int contador=1;
		for (Movimiento mov: this.movimientos) {
			if (mov.getImporte()>=importeMinimo) {
				salida = salida +String.format("%n Número: %2d - Concepto: %30s - Importe: %8.2f", 
						contador, mov.getConcepto(), mov.getImporte());
				contador++;
			}
			
			
			
		}
		
		return salida;
	}
	
	
	public  double calcularComisionMantenimiento () {
		  return COMISION_FIJA;
	}
	
	@Override
	public String toString() {
		return  String.format("%nCódigo cuenta: %8d  - Oficina: %10s  - Saldo:%8.2f ", 
								this.codigoCuenta, this.oficina, this.saldo);
	}
	
	
	
	
	
	

}
