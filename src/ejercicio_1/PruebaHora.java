package ejercicio_1;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PruebaHora {
    public static void main(String []args){
        Scanner entrada = new Scanner(System.in);
        System.out.println("¿Cuántas horas desea ingresar?");
        int cantidadHoras;
        try {
            cantidadHoras = entrada.nextInt();
            var instanciasHoras = new Hora[cantidadHoras];
            var segundosEspera = new int[cantidadHoras];
            for(var i = 0; i < cantidadHoras; i ++){
                instanciasHoras[i] = cargarHora(i);
                segundosEspera[i] = (int) getRandomIntegerBetweenRange(1,25);
            }
            for(var i = 0; i < cantidadHoras; i ++){
                instanciasHoras[i].mostrarHora();
                for(var j = 0; j < segundosEspera[i]; j ++){
                    try
                    {
                        Thread.sleep(1000);
                    }
                    catch(InterruptedException ex)
                    {
                        Thread.currentThread().interrupt();
                    }
                    instanciasHoras[i].setSegundos(instanciasHoras[i].getSegundos() + 1);
                    instanciasHoras[i].mostrarHora();
                }
            }

        } catch (InputMismatchException e) {
            System.out.println("Cantidad incorrecta, terminando");
        }
    }
    public static Hora cargarHora(int indice){
        Hora hora = new Hora();
        System.out.printf("Ingrese la hora %d, con formato [HH:MM:SS]", indice + 1);
        Scanner entrada = new Scanner(System.in);
        var horaUsuario = entrada.next();
        while (!horaUsuario.matches("(2[0-3]|[0-1]?[0-9]):[0-5]*\\d:[0-5]*\\d")) {
            System.out.println("Hora no valida, intente nuevamente");
        }
        var primerDelimitador = horaUsuario.indexOf(':');
        hora.setHoras(Integer.parseInt(horaUsuario.substring(0,primerDelimitador)));
        var segundoDelimitador = horaUsuario.lastIndexOf(':');
        hora.setMinutos(Integer.parseInt(horaUsuario.substring(primerDelimitador + 1, segundoDelimitador)));
        hora.setSegundos(Integer.parseInt(horaUsuario.substring(segundoDelimitador + 1)));
        return hora;
    }
    public static double getRandomIntegerBetweenRange(double min, double max){
        double x = (int)(Math.random()*((max-min)+1))+min;
        return x;
    }
}
