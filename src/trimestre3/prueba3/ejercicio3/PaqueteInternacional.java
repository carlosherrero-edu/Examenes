package trimestre3.prueba3.ejercicio3;

public class PaqueteInternacional extends Paquete {

	static final double IMPORTE_KG_INTER = 10.0;
	static final double MINIMO_INTER = 10.0;
	static final double VALORINICIAL = 30;
	// propiedades de la clase
	private String pais;
	private double valorDeclarado;

	public PaqueteInternacional(int largo, int ancho, int alto, double peso, String pais) {
		super(largo, ancho, alto, peso);
		setPais(pais);
		setValorDeclarado(VALORINICIAL);
	}

	public PaqueteInternacional(int largo, int ancho, int alto, double peso, String destinatario, boolean prioritario) {
		super(largo, ancho, alto, peso, destinatario, prioritario);
		setPais(pais);
		setValorDeclarado(VALORINICIAL);
	}

	public String getPais() {
		return pais;
	}

	private void setPais(String pais) {
		// debe constar de 3 letras
		if (pais.toUpperCase().matches("[A-Z]{3}")) {
			throw new IllegalArgumentException("El país debe constar de 3 letras");
		}

		this.pais = pais;
	}

	public double getValorDeclarado() {
		return valorDeclarado;
	}

	public void setValorDeclarado(double valorDeclarado) {
		this.valorDeclarado = valorDeclarado;
	}

	@Override
	public double calcularCosteEnvio() {
		double coste = MINIMO_INTER + IMPORTE_KG_INTER * Math.ceil(getPeso());
		return (isPrioritario() ? coste : coste * 1.5);
	}

}
