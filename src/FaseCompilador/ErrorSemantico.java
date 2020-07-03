/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FaseCompilador;

/**
 *
 * @author edi
 */
public class ErrorSemantico {

    public String error;
    public String tipo;
    public int linea;
    public int columna;
    public String Descripcion;

    public ErrorSemantico(String tipo, String error, int columna, int linea, String Descripcion) {
        this.tipo = tipo;
        this.error = error;
        this.columna = columna;
        this.linea = linea;
        this.Descripcion = Descripcion;
    }
}
