
package trimestre2.prueba1;

/**
 * Clase con métodos estáticos que resuelven el Ejercicio 2 del examen
 * Todas estas clases procesan una matriz con las unidades vendidas en una empresa de cada producto en cada mes del año
 * @author Carlos Herrero
 */
public class Ejercicio2 {
    
    static final int MESES=12;
    
    /**
     * Método auxiliarque suma una lista de números enteros
     * @param lista array de números enteros que queremos sumar
     * @return resultado de la suma
     */
    static int sumarLista(int[] lista){
        int suma=0;
        for (int valor: lista){
            suma += valor;
        }
        return suma;
    }
    
    /**
     * Método que obtiene las ventas totales de unidades de productos en cada mes del año
     * @param ventas array 2D -tabla- con las ventas de varios productos en cada mes del año
     * @return  array de 12 posiciones con el total de unidades vendidas en cada mes
     */
    static int[] obtenerVentasPorMes (int[][] ventas){
        int[] ventasPorMes= new int[MESES];
        
        for (int i=0; i<MESES; i++){
            //tenemos que sumar fila a fila. ventas[i] son las ventas de ese mes
            ventasPorMes[i] = sumarLista(ventas[i]);
        }
        return ventasPorMes;
    }
    
    /**
     * Método para obtener las ventas totales de cada producto a lo largo del año
     * @param ventas array 2D -tabla- con las ventas de varios productos en cada mes del año
     * @return array con el número de unidades vendidas de cada producto durante todo el año
     */
    static int[] obtenerVentasPorProducto (int[][] ventas){
        //número de productos o columnas de la matriz
        int productos= ventas[0].length;
        int[] ventasPorProducto= new int[productos];
        //recorrer por columnas
        for (int k=0; k<productos; k++){
            //la columna k consta de 12 filas, hay que recorrerla
            int[] columna= new int[MESES];
            
             for (int i=0; i<MESES; i++){
                 columna[i]=ventas[i][k];
             }
             //calculamos la suma de los términos de la columna
             ventasPorProducto[k]=sumarLista(columna);
        }
        
        return ventasPorProducto;
    }
    
    /**
     * Método para calcular y obtener el producto más vendido ("producto estrella") de cada mes
     * @param ventas  array 2D -tabla- con las ventas de varios productos en cada mes del año
     * @return array de 12 posiciones con el código del producto más vendido -producto estrella- en cada mes
     * si en un mes hay varios productos "estrella", se devuelve el de código más bajo
     */
    static int[] obtenerProductoEstrellaMes(int[][] ventas){
        //número de productos o columnas de la matriz
        int productos= ventas[0].length;
        
        int[] productosEstrella= new int[MESES];
        
        for (int i=0; i<MESES; i++){
           //suponemos inicialmente que el primer producto es el más vendido del mes
           int estrella=0;
           int ventasEstrella= ventas[i][0];
           //ahora recorremos el resto de productos
           for (int k=1; k<productos; k++){
               if (ventas[i][k]>ventasEstrella){
                   //encontramos un producto con más ventas. Actualizar
                   estrella=k;
                   ventasEstrella= ventas[i][k];
               }
           }
           //el producto más vendido del  mes está guardado en estrella
            productosEstrella[i] = estrella;
        }
        return productosEstrella;
    }
    
}
