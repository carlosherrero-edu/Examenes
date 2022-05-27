package trimestre3.prueba2;


import java.util.TreeMap;

public class TraductorMorse {
	
	/*
	 * La estructura más adecuada es un diccionario, ya que necesitamos guardar pares de objetos:
	 * Una letra  (clase Character) y una secuencia de puntos y rayas - clase String- 
	 * ADemás cada letra debe tener una codificación única (no puede repetirse)
	 * TreeMap nos garantiza la ordenación, aunque en este caso no es relevante...
	 * ... pues el diccionario va a tener pocos elementos
	 */
	
	private static TreeMap<Character,String> codigos;
	
	public  TraductorMorse() {
		codigos=new TreeMap<>();
		//introducimos ahora la codificación de las 5 vocales en morse
		codigos.put('A', ".-");
		codigos.put('E', ".");
		codigos.put('I', "..");
		codigos.put('O', "---");
		codigos.put('U', "..-");
		
	}
	
	public static String traducirAMorse (String frase){

		frase= frase.trim().toUpperCase();
		String salidaMorse="";
		char letra;
		/*
		 * Bucle para ir recorriendo la cadena y obtener cada carácter
		 */
		for (int i=0; i< frase.length(); i++){
			letra=frase.charAt(i);
			if (letra==' ') {
				salidaMorse+="  "; //2 espacios
			} else {
				//obtenemos el código morse correspondiente y agregamos 1 espacio
				salidaMorse+=codigos.get(letra);
				salidaMorse+=" "; //1 espacio
			}
		

		} // fin del bucle


		return salidaMorse;
		} //fin función
	
		public static void main(String[] args) {
			TraductorMorse traductor=new TraductorMorse();
			String frase1="AEIOU AEIOU AEIOU";
			String frase2="AAE EEA IO OOU";
			System.out.println(traductor.traducirAMorse(frase1));
			System.out.println(traductor.traducirAMorse(frase2));
		}


}
