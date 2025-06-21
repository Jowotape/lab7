package prob2;

import exceptions.NumeroInvalidoException;

import java.io.IOException;
import java.io.BufferedReader;

public class Prob2 {
    private int filas;
    private int columnas;
    private int[][] matriz;
    private int columnaDelMayor;

    public Prob2() {
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
        return matriz;
    }

    public void setFilas(int filas) {
        this.filas = filas;
    }
    public void setColumnas(int columnas) {
        this.columnas = columnas;
    }
    public void setMatriz() {
        this.matriz = new int[filas][columnas];
    }

    public void llenarMatriz(int fila, int columna, int valor){
        this.matriz[fila][columna] = valor;
    }

    public int encontrarMayor(int fila) {
        int mayor = 0;
        for (int columna = 0; columna < columnas; columna++) {
            if (this.matriz[fila][columna] > mayor) {
                mayor = this.matriz[fila][columna];
                columnaDelMayor = columna;
            }
        }
        return mayor;
    }

    public void problemarse2(BufferedReader br) throws IOException {
        while (true) {
            try {
                System.out.println("Introduzca la cantidad de columnas de la matriz");
                int columnas = Integer.parseInt(br.readLine());
                setColumnas(columnas);
                break;
            } catch (NumeroInvalidoException e){
                System.out.println("Error: " + e.getMessage() + ". Por favor, intente nuevamente. \n");
            } catch (NumberFormatException e){
                System.out.println("Error: " + e.getMessage() + ". Por favor, intente nuevamente. \n");
            }
        }
        while (true) {
            try {
                System.out.println("Introduzca la cantidad de filas de la matriz");
                int filas = Integer.parseInt(br.readLine());
                setFilas(filas);
                break;
            } catch (NumeroInvalidoException e){
                System.out.println("Error: " + e.getMessage() + ". Por favor, intente nuevamente. \n");
            } catch (NumberFormatException e){
                System.out.println("Error: " + e.getMessage() + ". Por favor, intente nuevamente. \n");
            }
        }
        setMatriz();

        for (int fila = 0; fila < filas; fila++) {
            for (int columna = 0; columna < columnas; columna++) {
                while (true) {
                    try {
                        System.out.println("Inserte el valor que será asignado a la posición " + fila + ", " + columna);
                        int valor = Integer.parseInt(br.readLine());
                        llenarMatriz(fila, columna, valor);
                        break;
                    } catch (NumeroInvalidoException e){
                        System.out.println("Error: " + e.getMessage() + ". Por favor, intente nuevamente. \n");
                    } catch (NumberFormatException e){
                        System.out.println("Error: " + e.getMessage() + ". Por favor, intente nuevamente. \n");
                    }
                }
            }
        }

        for (int fila = 0; fila < filas; fila++) {
            System.out.println("El mayor valor de la fila #" + fila + " es: " + encontrarMayor(fila) + " en la posición vertical #" + columnaDelMayor);
        }
    }

}