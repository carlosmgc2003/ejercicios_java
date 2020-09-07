46.	Una línea aérea pequeña acaba de comprar una computadora para su nuevo sistema automatizado de reservaciones. Se le ha pedido a usted que programe este sistema. Deberá escribir un programa que asigne asientos en cada vuelo del único avión de la compañía (capacidad 10 filas de 4 asientos).
Su programa deberá presentar el siguiente menú de alternativas:
•	1 para “PRIMERA CLASE”, 
•	2 para “ECONÓMICO”.
Si se teclea 1, el programa deberá asignar un asiento en la sección de primera clase (fila 1 a 5) si se teclea 2, se asignará un asiento en la sección económica (fila 6 a 10).
Mediante una matriz de dos subíndices de tipo primitivo boolean, represente la grafica de asientos del avión. Inicialice con false a todos los elementos de la matriz, indicando que todos los asientos están vacíos. A medida que se asigne un asiento, establezca en true el elemento correspondiente, indicando que ya no está disponible. El programa deberá imprimir un pase de abordaje que indique el número de asiento del pasajero, y si se encuentra en la sección de primera clase o clase económica del avión.
El programa claro está, no deberá volver a asignar un asiento ya asignado. Cuando la sección económica esté llena, el programa deberá preguntar si es aceptable asignar un asiento en la sección de primera clase (y viceversa). Si la persona acepta, entonces haga la asignación. Sino, imprima el mensaje “EL PROXIMO VUELO PARTE EN TRES HORAS”.
Nota: Utilice un método que convierta el número de la columna de la posición del asiento en una letra (A, B, C, D).
