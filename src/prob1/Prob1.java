package prob1;

import java.io.IOException;
import java.io.BufferedReader;

public class Prob1 {
    private int filas;
    private int columnas;
    private int[][] matrizOg;
    private int[][] matrizTras;

    public Prob1() {
        this.filas = 0;
        this.columnas = 0;
    }

    public int getFilas() {
        return filas;
    }
    public int getColumnas() {
        return columnas;
    }
    public int[][] getMatriz() {
        return matrizOg;
    }

    public int[][] getMatrizTrans() {
        return matrizTras;
    }

    public void setFilas(int filas) {
        this.filas = filas;
    }
    public void setColumnas(int columnas) {
        this.columnas = columnas;
    }
    public void setMatrizOg() {
        this.matrizOg = new int[filas][columnas];
    }

    public void setMatrizTrans() {
        this.matrizTras = new int[columnas][filas];
    }

    public void problemarse1(BufferedReader br) throws  IOException   {
        boolean datosvalidos = false;
        while (!datosvalidos) {
            datosvalidos = validarInput(br);
            if (datosvalidos) {
                ingresarElementos(br);
                calcularTraspuesta();
                imprimirMatrices();
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

            this.setColumnas(columnas);
            this.setFilas(filas);
            this.setMatrizOg();
            this.setMatrizTrans();
            return true;

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }

    public void ingresarElementos (BufferedReader br) throws IOException {
        System.out.println("Ingrese los elementos de la matriz");
        for (int i = 0; i < this.filas; i++){
            for (int j = 0; j < this.columnas; j++){
                boolean datoValido = false;
                while (!datoValido) {
                    try {
                        System.out.print("Ingrese el elemento de la posicion [" + i + "][" + j + "] ");
                        int valor = Integer.parseInt(br.readLine());
                        this.matrizOg[i][j] = valor;
                        datoValido = true;  // salió del while porque es válido
                    } catch (NumberFormatException e) {
                        System.out.println("Error: debe ingresar un número entero válido. Intente de nuevo.");
                    }
                }
            }
        }
    }

    public void calcularTraspuesta() {
        for (int i = 0; i < this.filas; i++) {
            for (int j = 0; j < this.columnas; j++){
                this.matrizTras[j][i] = this.matrizOg[i][j];
            }
        }
    }

    private void imprimirMatriz(int[][] matriz, int numFilas, int numColumnas) {
        for (int i = 0; i < numFilas; i++) {
            for (int j = 0; j < numColumnas; j++) {
                System.out.print(matriz[i][j] + "\t");
            }
            System.out.println(" ");
        }
    }

    public void imprimirMatrices() {
        System.out.println("\nMatriz Original:");
        imprimirMatriz(this.matrizOg, this.filas, this.columnas);

        System.out.println("\nMatriz Traspuesta:");
        imprimirMatriz(this.matrizTras, this.columnas, this.filas); // Las dimensiones son invertidas para la traspuesta
    }

}