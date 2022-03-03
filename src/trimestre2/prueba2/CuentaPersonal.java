package trimestre2.prueba2;

public class CuentaPersonal extends Cuenta {
	
	private static final double TIPO_INTERES_2 = 1.0;
	private static final double TIPO_INTERES_1 = 0.5;
	private static final int TRAMO2_SALDO = 30000;
	private static final int TRAMO1_SALDO = 3000;
	
	private String nombreApellidos;
	private int documento;

	public CuentaPersonal(int codigoCuenta, Oficinas oficina, String nombreApe, int documento) {
		super(codigoCuenta, oficina);
		setNombreApellidos(nombreApe);
		setDocumento(documento);
		
	}

	
	
	private void setNombreApellidos(String nombreApellidos) {
		if (nombreApellidos.length()<5) {
			throw new IllegalArgumentException("La longitud mínima es de 5 caracteres");
		}
		
		this.nombreApellidos = nombreApellidos;
	}



	private void setDocumento(int documento) {
		if (documento<1_000_000 || documento>99_999_999) {
			throw new IllegalArgumentException("El documento debe tener 7 u 8 dígitos");
		}
		this.documento = documento;
	}



	public String getNombreApellidos() {
		return nombreApellidos;
	}

	public int getDocumento() {
		return documento;
	}
	
	public double calcularInteres() {
		double interes;
		
		if (getSaldo()<TRAMO1_SALDO) {
			interes=0;
		} else if (getSaldo()<TRAMO2_SALDO) {
			interes=getSaldo()*TIPO_INTERES_1*0.01;
		} else {
			interes=getSaldo()*TIPO_INTERES_2*0.01;
		}
		
		return interes;
	}
	
	@Override
	public String toString() {
		
	
		
		return super.toString() + String.format(" -  Titular: %10d  %30s", this.documento, this.nombreApellidos);
		
	}
	
	

}
