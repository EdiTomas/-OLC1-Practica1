/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AnalizadorInterno;

import static Aplicacion.Ventana.texto;
import Datos.ArchivoDatos;
import Datos.Registro;
import FaseCompilador.ErrorSemantico;
import static FaseCompilador.Lexico.listaError;
import static FaseCompilador.Sintactico.ErrorSintactico;
import static FaseCompilador.Sintactico.listaErrorSemantico;
import FaseCompilador2.Parser;
//import static FaseCompilador2.Parser.listastring;
import FaseCompilador2.scanner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static org.jvnet.substance.watermark.SubstanceBinaryWatermark.getName;

/**
 *
 * @author edi
 */
public class Analizador {

    public ArchivoDatos archivosdatos;
    public ArrayList<ArrayList<Registro>> registro;
    public ArrayList<String> encabezado;

    public Analizador() {
        registro = new ArrayList();
        encabezado = new ArrayList();
    }

    public void LeerArchivo(String ruta, int Columna, int Fila) {
        String temp = "";
        try {
            BufferedReader bf = new BufferedReader(new FileReader(ruta));
            String bfRead;
            while ((bfRead = bf.readLine()) != null) {
                temp = temp + bfRead + "\n";
            }
            this.Compilador(temp);
        } catch (Exception e) {
            ErrorSemantico errorsemantico = new ErrorSemantico("Error Semantico", ruta,
                    Columna, Fila, "Ruta Invalida"
            );
            listaErrorSemantico.add(errorsemantico);
        }
        return;
    }

    public void ReiniciarMemoria() {
        listaError.clear();
        listaError.trimToSize();
        ErrorSintactico.clear();
        ErrorSintactico.trimToSize();
        listaErrorSemantico.clear();
        listaErrorSemantico.trimToSize();
        registro.clear();
        registro.trimToSize();
        encabezado.clear();
        encabezado.trimToSize();
    }

    public void Compilador(String texto) {
        this.ReiniciarMemoria();
        scanner lx = new scanner(new BufferedReader(new StringReader(texto)));
        Parser sin = new Parser(lx);
        try {
            sin.parse();
            archivosdatos = sin.archivo;

        } catch (Exception ex) {
            Logger.getLogger(getName()).log(Level.SEVERE, null, ex);
        }
        try {
            if (listaError.isEmpty() && ErrorSintactico.isEmpty()) {
                encabezado = archivosdatos.getListastring();
                registro = this.verificar(archivosdatos);
                System.out.println("La gramatica esta correcta");   //JOptionPane.showMessageDialog(null, "La gramatica esta correcta");
            } else {
                System.out.println("La gramatica esta correcta");//   JOptionPane.showMessageDialog(null, "La gramatica No es correcta");
            }
        } catch (Exception error) {
            System.out.println("error");
        }
    }

    public ArrayList<ArrayList<Registro>> verificar(ArchivoDatos archivosdatos) {
        int i, j, k;
        ArrayList< ArrayList<Registro>> registrar = new ArrayList();
        for (i = 0; i < archivosdatos.getListadatos().size(); i++) {
            ArrayList<Registro> re = new ArrayList();
            Registro registrados = null;
            if (archivosdatos.getListastring().size() == archivosdatos.getListadatos().get(i).size()) {
                for (j = 0; j < archivosdatos.getListastring().size(); j++) {
                    if ((archivosdatos.getListadatos().get(0).get(j).getValor() instanceof Double
                            && archivosdatos.getListadatos().get(i).get(j).getValor() instanceof Double)
                            || (archivosdatos.getListadatos().get(0).get(j).getValor() instanceof String
                            && archivosdatos.getListadatos().get(i).get(j).getValor() instanceof String)) { // verifica si los tipos son correctos al igual que el primero  (segundo filtro)
                        registrados = new Registro(
                                archivosdatos.getListadatos().get(i).get(j).getValor(),
                                archivosdatos.getListadatos().get(i).get(j).getColumna(),
                                archivosdatos.getListadatos().get(i).get(j).getFila()
                        );
                        re.add(registrados);
                    } else { // error semantico basico
                        if (archivosdatos.getListadatos().get(i).get(j).getValor() instanceof String) {
                            ErrorSemantico error = new ErrorSemantico("Error Semantico",
                                    archivosdatos.getListadatos().get(i).get(j).getValor().toString(),
                                    archivosdatos.getListadatos().get(i).get(j).getColumna(),
                                    archivosdatos.getListadatos().get(i).get(j).getFila(),
                                    "Error semantico porque la clave es Tipo de  Cadena");
                            listaErrorSemantico.add(error);

                        } else if (archivosdatos.getListadatos().get(i).get(j).getValor() instanceof Double) {
                            ErrorSemantico error = new ErrorSemantico("Error Semantico",
                                    archivosdatos.getListadatos().get(i).get(j).getValor().toString(),
                                    archivosdatos.getListadatos().get(i).get(j).getColumna(),
                                    archivosdatos.getListadatos().get(i).get(j).getFila(),
                                    "Error semantico porque la clave es Tipo de  Numerico");
                            listaErrorSemantico.add(error);
                        }
                    }// fin del else
                }// fin del for interno                                      
            } else { // tamaño error semantico
                for (k = 0; k < archivosdatos.getListadatos().get(i).size(); k++) {
                    if (archivosdatos.getListastring().size() != archivosdatos.getListadatos().get(i).size()) {
                        ErrorSemantico error = new ErrorSemantico("Error Semantico",
                                "Tamaño de la lista",
                                archivosdatos.getListadatos().get(i).get(k).getColumna(),
                                archivosdatos.getListadatos().get(i).get(k).getFila(),
                                "Error, la cantidad de valores del registro es incorrecta");
                        listaErrorSemantico.add(error);
                        break;
                    }
                }
            }
            registrar.add(re);
        } // fin del  primer for   
        return registrar;
    }
}
