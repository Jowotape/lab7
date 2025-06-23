package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import prob1.*;
import prob2.*;
import prob3.*;
import prob4.*;


public class Main {
    public static void main(String[] args) throws IOException {

        Prob1 prob1 = new Prob1();
        Prob2 prob2 = new Prob2();
        Prob3 prob3 = new Prob3();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Prob1 problema1 = new Prob1();
        Prob2 problema2 = new Prob2();
        Prob3 problema3 = new Prob3();
        Prob4 problema4 = new Prob4();

        boolean salir = false;

        while (!salir) {
            System.out.println("\n--- Menú de Problemas ---");
            System.out.println("1. Trasponer una matriz");
            System.out.println("2. Mostrar elemento más grande de una fila en una matriz mxn");
            System.out.println("3. Mostrar diagonal secundaria de una matriz de mayor a menor");
            System.out.println("4. Mostrar nombre de estudiantes y notas");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            String opcionStr = reader.readLine();
            int opcion;

            try {
                opcion = Integer.parseInt(opcionStr);
            } catch (NumberFormatException e) {
                System.out.println("Opción inválida, intente de nuevo.");
                continue;
            }

            switch (opcion) {
                case 1:
                    problema1.problemarse1(reader);
                    break;
                case 2:
                    problema2.problemarse2(reader);
                    break;
                case 3:
                    problema3.problemarse3(reader);
                    break;
                case 4:

                    break;
                case 5:
                    salir = true;
                    System.out.println("https://tinyurl.com/clickparasalir. ¡Hasta luego! ");
                    break;
                default:
                    System.out.println("Opción inválida, intente de nuevo.");
                    break;
            }
            if (salir) {
                break;
            }
            String respuesta = "";
            while (true) {
                System.out.println("\n¿Desea volver al menú principal?");
                System.out.println("1. Sí");
                System.out.println("2. No (Salir)");
                respuesta = reader.readLine();

                if (respuesta.equals("1")) {
                    break; // Vuelve al menú principal
                } else if (respuesta.equals("2")) {
                    salir = true;
                    System.out.println("Saliendo del programa. ¡Hasta luego!");
                    break;
                } else {
                    System.out.println("Opción inválida. Por favor ingrese 1 o 2.");
                }
            }

        }
    }
}


