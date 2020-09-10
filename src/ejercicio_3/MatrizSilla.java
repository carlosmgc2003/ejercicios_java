package ejercicio_3;

import ejercicio_41.IntegerMatrix;

import java.util.Arrays;

public class MatrizSilla extends IntegerMatrix{

    /**
     * @param inputMatrix Recibe una matriz bidimensiona de enteros y la carga en los atributos de clase
     */
    public MatrizSilla(int[][] inputMatrix) {
        super(inputMatrix);
    }

    /**
     * Dado un indice de la matriz devuelve un vector con los datos de columna que corresponde a ese indice.
     * @param indice indice de la columna que se desea extraer
     * @return vector con los datos de la columna.
     */
    private int[] tomarColumna(int indice){
        int[] columna = new int[this.getIntegerMatrix().length];
        var i = 0;
        for(var fila : this.getIntegerMatrix()){
            columna[i] = fila[indice];
            i ++;
        }
        return columna;
    }

    /**
     * Dado un vector devuelve el indice de la primera ocurrencia del dato, ingnorando si hay otras ocurrencias.
     * @param vector contiene los datos donde se busca.
     * @param dato que se busca
     * @return indice de la ubicacion del dato en el vector. -1 si no se encuentra.
     */
    private int indiceDato(int []vector, int dato){
        for(var i = 0; i < vector.length; i++) {
            if(vector[i] == dato){
                return i;
            }
        }
        return -1;
    }

    /**
     * Devuelve el valor del dato que es silla de la matriz si existe, si no devuelve -1.
     * @return indice de la ubicacion del dato en el vector. -1 si no se encuentra.
     */
    public int hallarSilla() {
        int silla = -1;
        for(var fila : this.getIntegerMatrix()){
            int mayor = Arrays.stream(fila).max().orElse(0);
            int menor = Arrays.stream(this.tomarColumna(this.indiceDato(fila, mayor))).min().orElse(0);
            if(mayor == menor){
                silla = mayor;
                break;
            }
        }
        return silla;
    }


    public static void main(String []args){
        int [][] datosPrueba = {{4,5,3,2,1,4},{3,7,2,5,8,4},{2,8,6,3,5,6},{3,9,5,2,4,3},{2,6,4,7,3,2},{3,7,5,6,8,1}};
        MatrizSilla matriz = new MatrizSilla(datosPrueba);
        System.out.printf("El punto silla de esta matriz es: %d\n",matriz.hallarSilla());
        visualizeSparseMatrix(matriz.translateToSparseMatrix(), matriz.getIntegerMatrix().length,matriz.getIntegerMatrix().length);
    }


}
