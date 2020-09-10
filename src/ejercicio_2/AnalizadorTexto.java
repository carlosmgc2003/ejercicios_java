package ejercicio_2;

import java.util.Arrays;

public class AnalizadorTexto {
    private String texto;

    public AnalizadorTexto(String texto) {
        if(texto.length() > 0) {
            this.texto = texto;
        }
    }

    @Override
    public String toString() {
        return "AnalizadorTexto{" +
                "texto='" + texto + '\'' +
                '}';
    }
    /**
     * Calcula el promedio de la longitud de las palabras del texto La descripcion del codigo funcional es:
     * Arrays.stream -> convierte el array de strings en un stream de datos
     * map -> mapea la funcion length a todos las cadenas del string, convirtiendo el stream a enteros.
     * mapToInt -> se asegura de aplicar el casteo int a todos los elementos del stream.
     * reduce -> suma todos los valores del stream de enteros.
     * @return un entero que es el cociente entre la suma de las longitudes de todas las palabras y la cantidad de palabras.
     */
    public int calcularPromPalabras() {
        var palabras = this.texto.split(" ");
        return Arrays.stream(palabras)
                .map(String::length)
                .mapToInt(v -> v)
                .reduce(0, Integer::sum) / palabras.length;
    }

    /**
     * Cuenta la cantidad de palabras que empiezan y terminan con la misma letra. ejemplos: a abra allana:
     * Arrays.stream -> convierte el array de strings en un stream de datos
     * map -> mapea una lambda que devuelve true si el primer y ultimo caracter de la palabra es igual.
     * map -> mapea una lambda que devuelve 1 si se recibe un true y 0 si se recibe un false en un stream booleando.
     * reduce -> suma todos los valores del stream de enteros.
     * @return un entero que es la suma de todos los 1 y 0 que salen de la lambda anterior.
     */
    public int contarPalabras() {
        var palabras = this.texto.split(" ");
        return Arrays.stream(palabras)
                .map(p -> p.charAt(0) == p.charAt(p.length()-1))
                .map(b -> b? 1 : 0)
                .reduce(0, Integer::sum);
    }

    /**
     * Cuenta la cantidad de palabras que empiezan y terminan con la misma letra. ejemplos: a abra allana:
     * Arrays.stream -> convierte el array de strings en un stream de datos
     * map -> mapea la length de todas las string del array.
     * map -> mapea el casteo int para todos los elementos del array.
     * max -> obtiene el mayor valor del stream de int.
     * orElse -> como el maximo puede ser null si el stream es vacio, esto previene obtener un nullpointer exception de salida
     * al dar 0 si recibe null.
     * @return un entero que es la longitud de la palabra mas larga.
     */
    public int buscarPalabraLarga() {
        var palabras = this.texto.split(" ");
        return Arrays.stream(palabras)
                .map(String::length)
                .mapToInt(v -> v).max()
                .orElse(0);
    }

}
