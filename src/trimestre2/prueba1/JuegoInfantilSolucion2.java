
package trimestre2.prueba1;

import java.util.Random;
import java.util.Scanner;

/**
 *  Clase para jugar a Piedra, Papel y Tijera. Solución 2
 * Solución para el examen de 2º Trimestre, Ejercicio 1
 * @author Carlos Herrero
 */
public class JuegoInfantilSolucion2 {
    
    static Scanner teclado= new Scanner (System.in);
    static Random dado= new Random();
    static final String[] OPCIONES= {"Piedra","Papel","Tijera"};
    
    /**
     * Método que determina el ganador de una partida según los resultados
     * @param resultado1 resultado del jugador 1 (0:Piedra, 1: Papel, 2: Tijera)
     * @param resultado2 resultado del jugador 2 (0:Piedra, 1: Papel, 2: Tijera)
     * @return ganador de la partida:  1, 2 , 0 (empate)
     */
    
    static int dimeGanador(int resultado1, int resultado2){
        //los 2 resultados no pueden ser iguales
        int ganador=1;
        //definimos una matriz con los ganadores posibles según los resultados
        final int [][] GANADOR = {
                                   {0, 2, 1},  //jugador 1 obtiene Piedra
                                   {1, 0, 2} , // jugador 1 obtiene Papel
                                   {2, 1, 0}   //jugador 1 obtiene Tijera
                
                                };
       
        return GANADOR[resultado1][resultado2];
    } //fin del método dimeGanador

    
    static final String REGLAS_JUEGO= """
                                 Vamos a jugar a PIEDRA, PAPEL O TIJERA
                                 ***La Piedra golpea a la Tijera
                                 ***La Tijera corta al Papel
                                 ***El Papel envuelve a la Piedra
                                 ***Si sacáis lo mismo, empatáis...
                                 
                                 """;
    
    static final String MENSAJE="\nPulsa cualquier tecla para una nueva partida, 0 para salir :>>>";
    
    public static void main (String[] args){
        //nombres de los jugadores
        String jugador1, jugador2;
        
        //partidas que ha ganado cada uno
        int ganadas1=0;
        int ganadas2=0;
        
        //resultados al azar para cada jugador
        int resultado1, resultado2;
        
        //opción para iniciar o abandonar el juego
        char teclaPulsada='x';
        
        //en el juego pedimos en primer lugar el nombre de los jugadores
        System.out.print( "\n Escribe el nombre del primer jugador: >>>");
        jugador1= teclado.nextLine();
        
         System.out.print( "\n Escribe ahora el nombre del segundo jugador: >>>");
        jugador2= teclado.nextLine();
        
        //mostramos al comienzo las reglas del juego
        System.out.print(REGLAS_JUEGO);
        System.out.print(MENSAJE);
        teclaPulsada= teclado.next().trim().charAt(0);
        
       while (teclaPulsada !='0'){
           
           //extraemos 2 números al azar
            resultado1= dado.nextInt(3);
            resultado2= dado.nextInt(3);
            
          // mostramos lo que ha obtenido cada uno
             System.out.println(jugador1 +" ha sacado "+OPCIONES[resultado1]);
             System.out.println(jugador2 +" ha sacado "+OPCIONES[resultado2]);
             
           // determinamos el ganador
           int ganador= dimeGanador(resultado1, resultado2);
           
           switch(ganador){
               case 0:
                   System.out.println(" Los 2 habéis sacado lo mismo, así que empatáis");
                   break;
               case 1:
                   System.out.println("Ha ganado "+ jugador1);
                   ganadas1++;
                   break;
               case 2:
                   System.out.println("Ha ganado "+ jugador2);
                    ganadas2++;
                    break;
                   
           }//fin del case
            
            
            //vemos si quieren seguir jugando
             System.out.print(MENSAJE);
             teclaPulsada= teclado.next().trim().charAt(0);
           
       }//fin del bucle while
       
      //una vez que hemos salido, imprimimos los resultados de cada jugador
       System.out.format("\n*Partidas ganadas por %s: %d ", jugador1,ganadas1);
         System.out.format("\n*Partidas ganadas por %s: %d ", jugador2,ganadas2);
         System.out.println("\n ¡¡ Gracias por jugar a PIEDRA, PAPEL Y TIJERA!!");
    
}
   
}
