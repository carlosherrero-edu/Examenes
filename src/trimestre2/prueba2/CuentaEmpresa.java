package trimestre2.prueba2;

public class CuentaEmpresa extends Cuenta {
	
	private static final int COMISION_3 = 200;
	private static final int COMISION_2 = 400;
	private static final int TRAMO_SALDO2 = 60_000;
	private static final int COMISION_1 = 600;
	private static final int TRAMO_SALDO1 = 6000;
	
	private String cif;
	private String razonSocial;

	public CuentaEmpresa(int codigoCuenta, Oficinas oficina, String cif, String razonSocial) {
		super(codigoCuenta, oficina);
		setCif(cif);
		setRazonSocial(razonSocial);
	}

	public String getCif() {
		return cif;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	private void setCif(String cif) {
		if (cif.length()!=9) {
			throw new IllegalArgumentException("El cif debe tener 9 caracteres");
		}
		this.cif = cif;
	}

	private void setRazonSocial(String razonSocial) {
		if (razonSocial.length()<5) {
			throw new IllegalArgumentException("La longitud mínima es de 5 caracteres");
		}
		this.razonSocial = razonSocial;
	}
	
	
	public double calcularComisionMantenimiento() {
		double comision;
		
		if (getSaldo()<TRAMO_SALDO1) {
			comision=COMISION_1;
			
		} else if (getSaldo()< TRAMO_SALDO2) {
			comision=COMISION_2;
		} else {
			comision=COMISION_3;
		}
		
		return comision;
	}
	
	@Override
	public String toString() {
		
		return super.toString() + String.format(" -  Razón Social: %9s  %30s", getCif(), getRazonSocial());
		
	}
	
	

}
