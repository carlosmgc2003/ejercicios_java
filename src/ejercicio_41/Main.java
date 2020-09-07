package ejercicio_41;

public class Main {

    public static void main(String[] args) {
        int[][] datosEntrada = {{6, 0, 0, 0, 4}, {0, 5, 0, 0, 2}, {2, 0, 0, 0, 0}, {0, 0, 7, 0, 0}, {0, 0, 0, 8, 0}};
        IntegerMatrix matrizDispersa = new IntegerMatrix(datosEntrada);
        int[] vectorComprimido = crearArreglo(datosEntrada, 5, 5);
        System.out.println("Traduccion a arreglo unidimensional");
        for (Integer n : vectorComprimido) {
            System.out.printf("%d ", n);
        }
        System.out.print("\n");
        System.out.println("Traduccion a matriz dispersa");
        visualizar(vectorComprimido, 5, 5);
    }

    /**
     * @param m matriz dispersa de dos dimensiones de enteros.
     * @param fi cantidad de filas totales de la matriz de dos dimensiones m
     * @param co cantidad de columnas totales de la matriz de dos dimensiones m
     * @return vector comprimido de la matriz dispersa
     */
    public static int[] crearArreglo(int[][] m, int fi, int co) {
        IntegerMatrix sparseMatrix = new IntegerMatrix(m);
        return sparseMatrix.translateToSparseMatrix();
    }

    /**
     * @param v vector comprimido de una matriz dispersa de la forma [i0,j0,d0,in,jn,dn,...]
     * @param f cantidad de filas totales que debe tener la matriz reconstruida
     * @param c cantidad de columnas totales que debe tener la matriz reconstruida
     */
    public static void visualizar(int[] v, int f, int c) {
        IntegerMatrix.visualizeSparseMatrix(v, f, c);
    }
}
