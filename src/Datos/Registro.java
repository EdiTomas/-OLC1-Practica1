/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.util.ArrayList;

/**
 *
 * @author edi
 */
public class Registro {

    private Object Valor;
    private int Columna;
    private int Fila;

    public Registro() {

        Valor = null;
        Columna = 0;
        Fila = 0;
    }

    public Registro(Object Valor, int Columna, int Fila) {
        this.setValor(Valor);
        this.setColumna(Columna);
        this.setFila(Fila);
    }

    /**
     * @return the Valor
     */
    public Object getValor() {
        return Valor;
    }

    /**
     * @param Valor the Valor to set
     */
    public void setValor(Object Valor) {
        this.Valor = Valor;
    }

    /**
     * @return the Columna
     */
    public int getColumna() {
        return Columna;
    }

    /**
     * @param Columna the Columna to set
     */
    public void setColumna(int Columna) {
        this.Columna = Columna;
    }

    /**
     * @return the Fila
     */
    public int getFila() {
        return Fila;
    }

    /**
     * @param Fila the Fila to set
     */
    public void setFila(int Fila) {
        this.Fila = Fila;
    }

}
