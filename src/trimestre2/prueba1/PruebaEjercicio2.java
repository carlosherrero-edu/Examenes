package trimestre2.prueba1;

import java.util.Arrays;

/**
 * Clase de Prueba para el Ejercicio 2- EXamen Febrero 2022
 *
 * @author Carlos H
 */
public class PruebaEjercicio2 {

    public static void main(String[] args) {

        //matriz de prueba
        int[][] ventas = {
            {20, 30, 40, 1, 6, 3, 20, 0, 70, 10}, //enero
            {10, 20, 30, 8, 6, 6, 30, 0, 10, 10}, //febrero
            {20, 10, 70, 1, 6, 3, 40, 0, 40, 10}, //marzo
            {50, 20, 30, 8, 6, 6, 40, 0, 10, 10}, //abril
            {50, 20, 30, 8, 6, 6, 40, 0, 10, 10}, //mayo
            {10, 30, 30, 0, 0, 0, 30, 0, 10, 50},//junio
            {10, 10, 10, 10, 10, 10, 10, 0, 10, 10}, //julio
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //agosto, mes sin ventas
            {20, 30, 40, 1, 6, 3, 20, 0, 70, 10}, //septiembre
            {50, 20, 30, 8, 6, 6, 40, 0, 10, 10}, //octubre
            {10, 20, 30, 8, 6, 6, 30, 0, 10, 10}, //noviembre
            {10, 30, 30, 0, 0, 0, 30, 0, 10, 50} //diciembre
        };

        //resultados esperados y obtenidos a partir de la matriz de prueba
        // cada prueba se encierra en un try-catch para tratar e independizar posibles excepciones
        try {
            int[] ventasPorMesEsperado = new int[]{200, 130, 200, 180, 180, 160, 90, 0, 200, 180, 130, 160};
            int[] ventasPorMes = Ejercicio2.obtenerVentasPorMes(ventas);
            System.out.print("\n Prueba del método obtenerVentasPorMes  :");
            System.out.println(Arrays.equals(ventasPorMes, ventasPorMesEsperado)
                    ? "CORRECTA" : "FALLIDA");

        } catch (Exception e) {
            System.out.println("Excepción en Prueba 1 " + e.getMessage());
        }

        try {
            int[] ventasPorProducto = Ejercicio2.obtenerVentasPorProducto(ventas);
            int[] ventasPorProductoEsperado = new int[]{260, 240, 370, 53, 58, 49, 330, 0, 260, 190};
            System.out.print("\n Prueba del método obtenerVentasPorProducto  :");
            System.out.println(Arrays.equals(ventasPorProducto, ventasPorProductoEsperado)
                    ? "CORRECTA" : "FALLIDA");
        } catch (Exception e) {
            System.out.println("Excepción en Prueba 1 " + e.getMessage());
        }

        try {
            int[] productosEstrella = Ejercicio2.obtenerProductoEstrellaMes(ventas);
            int[] productosEstrellaEsperado = new int[]{8, 2, 2, 0, 0, 9, 0, 0, 8, 0, 2, 9};
            System.out.print("\n Prueba del método obtenerProductoEstrellaMes :");
            System.out.println(Arrays.equals(productosEstrella, productosEstrellaEsperado)
                    ? "CORRECTA" : "FALLIDA");
        } catch (Exception e) {
            System.out.println("Excepción en Prueba 1 " + e.getMessage());
        }

    }

}
