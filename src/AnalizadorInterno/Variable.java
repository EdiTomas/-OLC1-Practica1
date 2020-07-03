/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AnalizadorInterno;

/**
 *
 * @author edi
 */
public class Variable {

    public String Tipo;
    public String id;
    public Object valor;
    public int Columna;
    public int Fila;

    public Variable(String Tipo, String id, Object valor, int Columna, int Fila) {
        this.Tipo = Tipo;
        this.id = id;
        this.valor = valor;
        this.Columna = Columna;
        this.Fila = Fila;
    }

    public Variable() {
        this.Tipo = "";
        this.id = "";
        this.valor = null;
        this.Columna = 0;
        this.Fila = 0;

    }

}
