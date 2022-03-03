package trimestre2.prueba2;

public class Movimiento {
	
	private int codigoCuenta;
	private String concepto;
	private double importe;
	
	
	public Movimiento(int codigoCuenta, String concepto, double importe) {
		//super();
		this.codigoCuenta = codigoCuenta;
		this.concepto = concepto;
		this.importe = importe;
	}


	public int getCodigoCuenta() {
		return codigoCuenta;
	}


	public String getConcepto() {
		return concepto;
	}


	public double getImporte() {
		return importe;
	}
	
	
	

	
	
	

}
