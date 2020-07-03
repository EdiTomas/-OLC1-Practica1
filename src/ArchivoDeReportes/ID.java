/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArchivoDeReportes;

/**
 *
 * @author edi
 */
public class ID {

    private Object id;
    private int Columna;
    private int Fila;

    public ID(Object id, int Columna, int Fila) {
        this.id = id;
        this.Columna = Columna;
        this.Fila = Fila;
    }

    /**
     * @return the id
     */
    public Object getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Object id) {
        this.id = id;
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
