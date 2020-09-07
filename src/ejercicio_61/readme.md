61.	Un cuadrado mágico se compone de números enteros comprendidos entre 1 y n2, donde n es un número impar que indica el orden de la matriz cuadrada que contiene los números que forman dicho cuadrado mágico. La matriz que forma este cuadrado mágico, cumple que la suma de los valores que componen cada fila, cada columna y cada diagonal es la misma. Por ejemplo, un cuadrado mágico de orden 3, implica un valor de n=3 lo que dará lugar a una matriz de 3 por 3. Por lo tanto, los valores de la matriz estarán comprendidos entre 1 y 9 y dispuestos de la forma siguiente:
8 1 6
3 5 7
4 9 2
Realizar un programa que visualice un cuadrado mágico de orden impar n. El programa verificará que n es impar y que está comprendido entre 3 y 15.
Una forma de construirlo puede ser: situar el número 1 en el centro de la primera línea, el número siguiente en la casilla situada encima y a la derecha, y así sucesivamente. Es preciso tener en cuenta que el cuadrado se cierra sobre sí mismo, esto es, la línea encima de la primera es la última y la columna a la derecha de la última es la primera. Siguiendo esta regla, cuando el número caiga en una casilla ocupada, se elige la casilla situada debajo del último número situado.
Se deberán hacer al menos los métodos siguientes:
esImpar. Este método verificará si n es impar.
cuadradoMágico. Este método construirá el cuadrado mágico.
