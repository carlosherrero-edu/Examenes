
package trimestre2.prueba1;


import java.util.Scanner;

/**
 * Clase que simula el juego infantil de PIEDRA, PAPEL Y TIJERA
 * @author Alumno
 */
public class JuegoInfantil {
    
    static Scanner teclado= new Scanner (System.in);
     static final String[] OPCIONES= {"Piedra","Papel","Tijera"};
    
    static final String reglasJuego= """
                                 Vamos a jugar a PIEDRA, PAPEL O TIJERA
                                 ***La Piedra golpea a la Tijera
                                 ***La Tijera corta al Papel
                                 ***El Papel envuelve a la Piedra
                                 ***Si sacáis lo mismo, empatáis...
                                 
                                 """;
    
    static final String mensaje="\nPulsa cualquier tecla para una nueva partida, 0 para salir :>>>";

    /**
     * Método para determinar el ganador de cada partida
     * @param resultado1 número aleatorio obtenido por el jugador 1, entre 0 y 2
     * @param resultado2 número aleatorio obtenido por el jugador 2, entre 0 y 2, distinto a resultado1
     * @return  1 si gana el Jugador 1, 2 si gana el Jugador 2
     */
    static int dimeGanador(int resultado1, int resultado2){
        //esta función debe devolver el ganador de cada partida
        int ganador=1;
         //TODO
        return ganador;
    }

   
    
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
        
        //mostramos al comienzo las reglas del juego
        System.out.print(reglasJuego);
        
        //pedimos a continuación el nombre de los jugadores
        System.out.print( "\n Escribe el nombre del primer jugador: >>>");
        //TODO
        
        //DEsarrollo del juego.
       //TODO
      //una vez que hemos salido, imprimimos los resultados de cada jugador
       //TODO
         System.out.println("\n ¡¡ Gracias por jugar a PIEDRA, PAPEL Y TIJERA!!");
         teclado.close();
    
}//fin del main
   
}//fin de la clase
