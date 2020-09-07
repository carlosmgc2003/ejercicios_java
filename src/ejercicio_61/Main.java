package ejercicio_61;

class Main
{

    /**
     * Funcion para generar un Cuadrado Mágico, una matriz cuadrada n * n cuya suma de filas columnas y diagonales da
     * el mismo numero
     * @param n Dimension de la matriz mágica
     */
    static void generateSquare(int n)
    {
        int[][] magicSquare = new int[n][n];

        // Inicializar la posicion del 1
        int j = n/2;
        int i = 0;

        // Poniendo los valores 1 a uno
        for (int num=1; num <= n*n; )
        {
            if (i==-1 && j==n) //Cuando se excede la esquina superior derecha de la matriz
            {
                j = n-1;
                i = i + 2;
            }
            else
            {
                //Cuando el indice de las columnas excede el borde derecho, volvemos al izq
                if (j == n)
                    j = 0;

                //Cuando el indice de las filas exede el borde superior volvemos al piso
                if (i < 0)
                    i=n-1;
            }

            //Cuando el recuadro ya fue ocupado bajamos al inferior del colocado anteriormente (1 paso atraas)
            if (magicSquare[i][j] != 0)
            {
                i=i+2; j--;
                continue;
            }
            else
                //Colocamos el numero
                magicSquare[i][j] = num++;

            //Condicion de avance
            j++;  i--;
        }

        // Imprimir el cuadrado magico
        System.out.println("El cuadrado magico para "+n+":");
        System.out.println("La suma de cada fila columna y diagonal "+n*(n*n+1)/2+":");
        for(i=0; i<n; i++)
        {
            for(j=0; j<n; j++)
                System.out.print(magicSquare[i][j]+"\t");
            System.out.println();
        }
    }

    // driver program
    public static void main (String[] args)
    {
        //Funciona solo cuando n es impar
        int n = 5;
        generateSquare(n);
    }
}