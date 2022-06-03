package ordinario.ejercicio3;

import java.security.SecureRandom;
import java.util.Scanner;



public class Ejercicio3 {

	//elemento SecureRandom que usaremos para los lanzamientos
	
	static SecureRandom dadoAzar= new SecureRandom();
	
	/**
	 * Método para simular el lanzamiento al azar de un dado
	 * @return entero de 1 a 6
	 */
	static int lanzarDado() {
		
		return dadoAzar.nextInt(6)+1;
				
	}
	
	/**
	 * Método para simular el lanzamiento de 2 dados por un jugador
	 * El jugador gana si ambos lados quedan iguales, y pierde en caso contrario
	 */
	static void jugarOpcion1() {
		int dado1, dado2;
		String resultado;
		
		//simulamos el lanzamiento de los dados
		dado1=lanzarDado();
		dado2= lanzarDado();
		if (dado1==dado2) {
			resultado= "HAS GANADO. FELICIDADES";
		} else {
			resultado= "HAS PERDIDO. OTRA VEZ SERÁ...";
		}
		System.out.println(resultado);
		System.out.format("Dados obtenidos:  %d    % d   %n", dado1, dado2);
	}
	
	/**
	 * Método para simular el lanzamiento de 1 dado por un jugardor y de otro dado por un segundo jugador
	 * Gana el jugador que obtenga el dado más alto; si ambos quedan iguales, empatan
	 */
	static void jugarOpcion2() {
		int dado1, dado2;
		String resultado;
		
		//simulamos el lanzamiento de los dados
		dado1=lanzarDado();
		dado2= lanzarDado();
		if (dado1>dado2) {
			resultado= "GANA EL JUGADOR 1";
		} else if (dado1<dado2) {
			 resultado= "GANA EL JUGADOR 2";
		} else {
			resultado= "LOS DOS JUGADORES EMPATAN";
		}
		
		System.out.println(resultado);
		System.out.format("Dados obtenidos:  Jugador 1: %d   Jugador 2: % d   %n", dado1, dado2);
	}
	
	/**
	 * Método para simular una partida de 2 jugadores que lanzan de forma separada 2 dados cada uno
	 * Gana el jugador que obtenga sus 2 dados iguales.
	 * Si ambos obtienen sus 2 dados iguales, gana aquél para el que sus dados sean de mayor valor
	 * En cualquier otra situación, empatan
	 * 
	 */
	static void jugarOpcion3() {
		int dado11, dado12; //dados del primer jugador
		int dado21, dado22; //dados del segundo jugador
		String resultado;
		
		//simulamos el lanzamiento de los dados
		dado11=lanzarDado();
		dado12=lanzarDado();
		dado21= lanzarDado();
		dado22= lanzarDado();
		if ( dado11==dado12 && (dado21!=dado22 || (dado21==dado22 && dado11>dado21)) ) {
			resultado= "GANA EL JUGADOR 1";
		} else if( dado21==dado22 && (dado11!=dado12 || (dado11==dado12 && dado11<dado21)) ) {
			 resultado= "GANA EL JUGADOR 2";
		} else {
			resultado= "LOS DOS JUGADORES EMPATAN";
		}
		System.out.println(resultado);
		System.out.format("Dados obtenidos:  Jugador 1: %d    % d   %n", dado11, dado12);
		System.out.format("                  Jugador 2: %d    % d   %n", dado21, dado22);
	}
	
	
	 /**
	 * Método que imprime por pantalla el menú de opciones del programa
	 */
	static void mostrarMenu() {
		System.out.println(" \n\t\t MENÚ DE OPCIONES :                    ");
		System.out.println(" \t\t---------------------------------------\n");
		System.out.println("1. OPCIÓN 1: 1 Jugador, 2 Dados");
		System.out.println("2. OPCIÓN 2: 2 Jugadores, 1 Dado");
		System.out.println("3. OPCIÓN 3: 2 Jugadores, 2 Dados");
		System.out.println("4. Abandonar el programa");
		System.out.print("Ingrese una opcion de menú >>>>");
	}
	
	
	public static void main(String[] args) {
		
		//opciones mínima y máxima del menú
		final int OPCIONMIN=1;
		final int OPCIONMAX=4;
		
try(Scanner opcion = new Scanner(System.in)) {
			
			boolean seguirEnPrograma = true;
			

			
			while (seguirEnPrograma) {
				//imprimimos el menú de opciones
				mostrarMenu();
				boolean opcionOK=false;
				int opcionSeleccionada=0;
				//mientras la opción no sea válida, la pedimos por teclado
				while (!opcionOK) {
					
					try {
						opcionSeleccionada = Integer.parseInt(opcion.nextLine());
						if (opcionSeleccionada<OPCIONMIN|| opcionSeleccionada> OPCIONMAX) {
							throw new IllegalArgumentException("Opción fuera del rango permitido");
						} else {
							opcionOK=true;
						}
					}  catch (Exception e ){
						System.out.println("Introdujuste un valor u opción incorrecta. Por favor, vuelve introducirlo");
						System.out.print("Ingrese una opcion de menú >>>>");
						
					}
					
				}
				
				switch (opcionSeleccionada) {
				case 1: {
					jugarOpcion1();
					break;
				}
				case 2: {
					jugarOpcion2();
					break;
				}
				case 3: {
					jugarOpcion3();
					break;
				}
				
				case 4: {

					seguirEnPrograma = false;
					opcion.close(); //cerramos el objeto escáner
				
					System.out.println(" \n !!! Muchas gracias por jugar!!!");
					System.exit(0);
					break;

				}
				
				}//fin del switch-case
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	
	} //fin del main
	

}
