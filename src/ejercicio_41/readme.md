41.	Para almacenar una matriz bidimensional que generalmente tiene muchos elementos nulos (matriz sparse) se puede utilizar un arreglo unidimensional en el que sólo se guardarán los elementos no nulos precedidos por sus índices, fila y columna, lo que redunda en un aprovechamiento de espacio. Por ejemplo, la matriz:
60004
05002
20000
00700
00080
Se guardará en un arreglo unidimensional así:
0	0	6	0	4	4	1	1	5	1	4	2	2	0	2	3	2	7	4	3	8
Se pide:
a)	Escribir un método que lea una matriz bidimensional por filas y la almacene en un arreglo  v unidimensional. El prototipo de este método será:
Int CrearArregloUni(int[] v,int fi, int co);
Los parámetros fi y co se corresponden con el número de fila y de columnas de la supuesta matriz bidimensional.
b)	Escribir un método que permita representar en pantalla la matriz bidimensional por filas y columnas. El prototipo de este método será:
Int Visualizar(int f, int c, int [] v);
Los parámetros f y c se corresponden con la fila y la columna del elemento que se visualiza. El valor del elemento que se visualiza se obtiene, lógicamente del arreglo unidimensional creada en el punto a, así: buscamos por los índices f y c; si se encuentran, el método Visualizar devuelve el valor almacenado justamente a continuación; si no se encuentran, entonces devuelve un cero.
Escribir un programa que, utilizando el método CrearArregloUni, cree un arreglo unidimensional a partir de una supuesta matriz sparse bidimensional y a continuación, utilizando el método Visualizar, muestre en pantalla la matriz bidimensional.
