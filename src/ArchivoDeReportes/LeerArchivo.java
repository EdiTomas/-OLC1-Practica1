/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArchivoDeReportes;

import AnalizadorInterno.Analizador;
import Datos.Registro;
import java.util.ArrayList;

/**
 *
 * @author edi
 */
public class LeerArchivo {
    public String ruta;
    public int Columna;
    public int Fila;
    public ArrayList <ArrayList<Registro>> registro;
    public ArrayList<String> encabezado;
    Analizador ana;
    
    public LeerArchivo() {
        this.ruta = "";
        this.Columna =0;
        this.Fila = 0;
        ana = new Analizador();
        registro = new ArrayList();
        encabezado =new ArrayList();
    }
 
    public LeerArchivo(String ruta, int Columna, int Fila) {
        ana = new Analizador();
        registro = new ArrayList();
        encabezado =new ArrayList();
        this.interprete(ruta,Columna,Fila);
    }
       
       public void interprete(String ruta,int Columna, int Fila){
              ana.LeerArchivo(ruta,Columna,Fila);
              registro = ana.registro;
              encabezado = ana.encabezado; 
       }
       
       public String Cabecera(){
           String out = "";
          for (int i = 0; i < encabezado.size(); i++) {
                if (i == encabezado.size() - 1) {
                    out +=encabezado.get(i) + " ] ";
                }else if(i==0){
                    out += "clave = [ "+ encabezado.get(i)+ ",  " ;
                }else {
                    out += encabezado.get(i) + ",  ";
                }
            }
         return out;
       }
       
       
       
       
     





}
