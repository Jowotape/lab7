package prob1;

import java.io.IOException;
import java.io.BufferedReader;

public class Prob1 {
    private int filas;
    private int columnas;
    private int[][] matriz;

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

    public void problemarse1(BufferedReader br) throws IOException {
        validarInput(br);
    }

    public void validarInput(BufferedReader br) throws IOException {

    }
}

