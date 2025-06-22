package prob3;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Prob3 {
    private int filas;
    private int columnas;
    int[][] matriz;

    public Prob3() {
        this.filas = filas;
        this.columnas = columnas;
    }

    public void setFilas(int filas) {
        this.filas = filas;
    }
    public void setColumnas(int columnas) {
        this.columnas = columnas;
    }
    public void setMatriz(int[][] matriz) {
        this.matriz = matriz;
    }
     public int getFilas() {
        return filas;
     }
     public int getColumnas() {
        return columnas;
     }
     public int[][] getMatriz() {
        return matriz;
     }

    public void problemarse3 (BufferedReader reader)  {
        boolean datosvalidos = false;
        while (!datosvalidos) {
            datosvalidos = validarInput(reader);
            if (datosvalidos) {
                ingresarMatriz();
                imprimirDiagonalsecundaria();
            }
        }
    }
    public boolean validarInput(BufferedReader br)  {
        try {

            System.out.print("Ingrese el número de filas de la matriz: ");

            int filas = (Integer.parseInt(br.readLine()));

            System.out.print("Ingrese el número de columnas de la matriz: ");
            int columnas = (Integer.parseInt(br.readLine()));

            if (filas <= 0 || columnas <= 0) {
                System.out.println("El número de filas y columnas debe ser mayor que 0. Intente de nuevo.");
                return false;
            }
            if (filas != columnas) {
                System.out.println("Su matriz no es cuadrada, intente de nuevo");
                return false;
            }
            this.setColumnas(columnas);
            this.setFilas(filas);
            matriz = new int[filas][columnas];
            return true;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }

    public void ingresarMatriz() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Ingrese los elementos de la matriz:");

        for (int i = 0; i < this.filas; i++) {
            for (int j = 0; j < this.columnas; j++) {
                boolean datoValido = false;
                while (!datoValido) {
                    System.out.print("Elemento [" + i + "][" + j + "]: ");
                    try {
                        int valor = Integer.parseInt(reader.readLine());
                        matriz[i][j] = valor;
                        datoValido = true; // solo saldrá del while si es válido
                    } catch (NumberFormatException | IOException e) {
                        System.out.println("Error: valor no válido. Intente de nuevo.");
                    }
                }
            }
        }
        System.out.print("Matriz ingresada: \n");
        for (int i = 0; i <filas; i++) {
            for (int j = 0; j <columnas; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }
    public void imprimirDiagonalsecundaria() {
        int n = this.getFilas();
        int[] diagonalSecundaria = new int[n];

        // Extraer la diagonal secundaria
        for (int i = 0; i < n; i++) {
            diagonalSecundaria[i] = matriz[i][this.getColumnas() - 1 - i];
        }

        // Ordenar menor a mayor no lo hace de mayor a menor
        Arrays.sort(diagonalSecundaria);

        // Invertir el arreglo para que quede de mayor a menor
        for (int i = 0; i < n / 2; i++) {
            int ordenar = diagonalSecundaria[i];
            diagonalSecundaria[i] = diagonalSecundaria[n - 1 - i];
            diagonalSecundaria[n - 1 - i] = ordenar;
        }

        // Imprimir
        System.out.print("Diagonal secundaria: \n");
        for (int i = 0; i < n; i++) {
            System.out.print(diagonalSecundaria[i] + " ");
        }
        System.out.println();
    }

    }



