package trimestre3.prueba3.ejercicio3;

/**
 * @author Alumno
 *
 */
public class PaqueteNacional extends Paquete {
	
	 static final double MINIMO_NAC = 5.0;
 static final double IMPORTE_KG_NAC = 3.0;
	private String codPostal;

	public PaqueteNacional(int largo, int ancho, int alto, double peso, String codPostal) {
		super(largo, ancho, alto, peso);
		setCodPostal(codPostal);
	}

	public PaqueteNacional(int largo, int ancho, int alto, double peso, String destinatario, boolean prioritario, String codPostal) {
		super(largo, ancho, alto, peso, destinatario, prioritario);
		setCodPostal(codPostal);
	}
	
	

	public String getCodPostal() {
		return codPostal;
	}

	private void setCodPostal(String codPostal) {
		//validar con expresión regular
		if (!codPostal.matches("\\d{5}")) {
			throw new IllegalArgumentException("El código postal debe constar de 5 dígitos");
		}
		
		this.codPostal = codPostal;
	}

	@Override
	public double calcularCosteEnvio() {
	
		double coste= MINIMO_NAC+IMPORTE_KG_NAC*Math.ceil(getPeso());
		return (isPrioritario()?coste: coste*1.3);
	}

}
