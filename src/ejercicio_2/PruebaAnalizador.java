package ejercicio_2;

public class PruebaAnalizador {
    public static void main(String [] args) {
        String texto = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, " +
                "sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. " +
                "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris " +
                "nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit " +
                "in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint " +
                "occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit " +
                "anim id est laborum.";

        AnalizadorTexto analizador = new AnalizadorTexto(texto);
        System.out.printf("El promedio de largo de las palabras es de %d\n", analizador.calcularPromPalabras());
        System.out.printf("La cantidad de palabras que empiezan y terminan con la misma letra son %d\n", analizador.contarPalabras());
        System.out.printf("El largo de la palabra mas larga es de %d\n", analizador.buscarPalabraLarga());
    }

}
