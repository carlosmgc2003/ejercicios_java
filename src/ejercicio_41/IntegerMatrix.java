package ejercicio_41;


/**
 * Clase que abstrae una matriz de enteros con las operaciones solicitadas por el ejercicio 41.
 */
public class IntegerMatrix {
    public int[][] getIntegerMatrix() {
        return integerMatrix;
    }

    int[][] integerMatrix;
    int totalColumns;
    int totalRows;

    /**
     * @param inputMatrix Recibe una matriz bidimensiona de enteros y la carga en los atributos de clase
     */
    public IntegerMatrix(int[][] inputMatrix) {
        this.totalColumns = inputMatrix[0].length;
        this.totalRows = inputMatrix.length;
        this.integerMatrix = inputMatrix.clone();
    }


    /**
     * @return Devuelve un vector comprimido de la matriz de enteros cargada en integerMatrix
     */
    public int[] translateToSparseMatrix() {
        int no_zero = totalRows * totalColumns;
        for (var row : integerMatrix) {
            for (var data : row) {
                if (data == 0) {
                    no_zero--;
                }
            }
        }
        int[] vector = new int[no_zero * 3];
        int index = 0;
        for (int i = 0; i < this.totalRows; i++) {
            for (int j = 0; j < this.totalColumns; j++) {
                if (this.integerMatrix[i][j] != 0) {
                    vector[index] = i;
                    vector[++index] = j;
                    vector[++index] = integerMatrix[i][j];
                    index++;
                }
            }
        }
        return vector;
    }

    /**
     * @param integerVector vector comprimido de una matriz dispersa de la forma [i0,j0,d0,in,jn,dn,...]
     * @param totalRows cantidad de filas totales que debe tener la matriz reconstruida
     * @param totalColumns cantidad de columnas totales que debe tener la matriz reconstruida
     */
    public static void visualizeSparseMatrix(int[] integerVector, int totalRows, int totalColumns) {
        int[][] matrix = new int[totalRows][totalColumns];
        for (var i = 0; i < totalRows; i++) {
            for (var j = 0; j < totalColumns; j++) {
                matrix[i][j] = 0;
            }
        }
        int dataRow = 0, dataCol = 0;
        for (int i = 0; i < integerVector.length; i++) {
            switch (i % 3) {
                case 0 -> dataRow = integerVector[i];
                case 1 -> dataCol = integerVector[i];
                case 2 -> matrix[dataRow][dataCol] = integerVector[i];
            }
        }
        for (var row : matrix) {
            for (var data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.print("\n");
        }
    }
}
