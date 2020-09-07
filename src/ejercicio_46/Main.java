package ejercicio_46;

import java.util.Arrays;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {
    static String[] clases = {"Primera Clase", "Economica"};
    public static void main(String []args){
        Flight nuevoVuelo = new Flight();
        var continuar = true;
        System.out.println("VENTA DE PASAJES");
        while(!nuevoVuelo.isFlightFull() && continuar){
            int seleccion = menu();
            switch (seleccion) {
                case 1 -> {
                    if (!nuevoVuelo.assignFirstClass()) {
                        System.out.println("Primera clase llena");
                        if (alternativa_vuelo(clases[0]) == 1) {
                            nuevoVuelo.assignEconomyClass();
                        }
                    }
                    nuevoVuelo.printFlight();
                }
                case 2 -> {
                    if (!nuevoVuelo.assignEconomyClass()) {
                        System.out.println("Economica llena");
                        if (alternativa_vuelo(clases[1]) == 1) {
                            nuevoVuelo.assignFirstClass();
                        }
                    }
                    nuevoVuelo.printFlight();
                }
                case 0 -> {
                    continuar = false;
                    System.out.println("Finalizada la venta de pasajes:");
                    nuevoVuelo.printFlight();
                }
                case -1 -> System.out.println("Eleccion incorrecta, intente nuevamente");
            }
        }
        System.out.println("VUELO COMPLETO");
        nuevoVuelo.printFlight();
    }

    public static int menu(){
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese 1 para Primera Clase.");
        System.out.println("Ingrese 2 para Económico.");
        System.out.println("Ingrese 0 para terminar.");
        var seleccion = entrada.nextInt();
        return switch (seleccion) {
            case 0, 1, 2 -> seleccion;
            default -> -1;
        };
    }

    public static int alternativa_vuelo(String clase) {
        Stream<String> clasesAlternativas = Arrays.stream(clases).dropWhile(s -> s.equals(clase));
        Optional<String> claseAlternativa = clasesAlternativas.findFirst();
        if (claseAlternativa.isPresent()) {
            System.out.printf("La clase %s esta llena, desea un pasaje de la clase %s?\n", clase, claseAlternativa.get());
            Scanner entrada = new Scanner(System.in);
            System.out.println("[1] para aceptar [0] para rechazar");
            var seleccion = entrada.nextInt();
            while (!(seleccion == 0 || seleccion == 1)) {
                System.out.println("Opcion incorrecta!");
                System.out.println("[1] para aceptar [0] para rechazar");
                seleccion = entrada.nextInt();
            }
            return seleccion;
        }
        return 0;
    }
}
