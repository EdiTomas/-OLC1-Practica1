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
public class ArchivoDatos {

    private ArrayList<String> listastring;
    private ArrayList<ArrayList<Registro>> listadatos;

    public ArchivoDatos() {
        this.listastring = null;
        this.listadatos = null;
    }

    public ArchivoDatos(ArrayList<String> listastring, ArrayList<ArrayList<Registro>> listadatos) {
        this.listastring = listastring;
        this.listadatos = listadatos;
    }

    /**
     * @return the listastring
     */
    public ArrayList<String> getListastring() {
        return listastring;
    }

    /**
     * @param listastring the listastring to set
     */
    public void setListastring(ArrayList<String> listastring) {
        this.listastring = listastring;
    }

    /**
     * @return the listadatos
     */
    public ArrayList<ArrayList<Registro>> getListadatos() {
        return listadatos;
    }

    /**
     * @param listadatos the listadatos to set
     */
    public void setListadatos(ArrayList<ArrayList<Registro>> listadatos) {
        this.listadatos = listadatos;
    }

}
