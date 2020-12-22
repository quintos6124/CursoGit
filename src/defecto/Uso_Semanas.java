package defecto;

import java.util.Scanner;

public class Uso_Semanas {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        System.out.println("Escriba un dia de la Semana: LUNES,MARTES,MIERCOLES,JUEVES,VIERNES,SABADO,DOMINGO");
        String respuesta=entrada.next().toUpperCase();

        DiasSemana laborable=DiasSemana.valueOf(respuesta);

        System.out.println("Este dia es Laborable?\n"+laborable.getLaborable());
    }
}
