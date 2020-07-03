/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArchivoDeReportes;

import FaseCompilador.ErrorSemantico;
import static FaseCompilador.Sintactico.globales;
import static FaseCompilador.Sintactico.listaErrorSemantico;
import static FaseCompilador.Sintactico.print;
import java.util.ArrayList;

/**
 *
 * @author edi
 */
public class Imprimir {

    public ArrayList<Object> listaimpresiones;

    public Imprimir(ArrayList<Object> listaimpresiones) {
        this.listaimpresiones = listaimpresiones;
    }

    public Object ValidadObjecto() {
        int x, i;
        boolean encontrado = false;
        boolean existeid = false;
        String ValorObjecto = "";
        for (i = 0; i < listaimpresiones.size(); i++) {
            if (listaimpresiones.get(i) instanceof String) {
                ValorObjecto += listaimpresiones.get(i).toString() + " ";
            } else if (listaimpresiones.get(i) instanceof Double) {
                ValorObjecto += listaimpresiones.get(i).toString() + " ";
            } else if (listaimpresiones.get(i) instanceof Integer) {
                ValorObjecto += listaimpresiones.get(i).toString() + " ";
            } else if ((ID) listaimpresiones.get(i) instanceof ID) {
                ID valor = (ID) listaimpresiones.get(i);
                for (x = 0; x < globales.size(); x++) {
                    if (valor.getId().toString().equals(globales.get(x).id)
                            && globales.get(x).Tipo.equalsIgnoreCase("Archivo")
                            && globales.get(x).valor instanceof LeerArchivo) {
                        ValorObjecto += this.Resultados(globales.get(x).valor) + " ";
                        encontrado = true;
                        break;
                    } else if (valor.getId().toString().equals(globales.get(x).id)
                            && globales.get(x).Tipo.equalsIgnoreCase("Cadena")
                            && globales.get(x).valor instanceof ObtenerSi) {
                        ValorObjecto += this.Resultados(globales.get(x).valor) + " ";
                        encontrado = true;
                        break;
                    } else if (valor.getId().toString().equals(globales.get(x).id)
                            && globales.get(x).Tipo.equalsIgnoreCase("Numerico")
                            && globales.get(x).valor instanceof Sumar) {
                        ValorObjecto += this.Resultados(globales.get(x).valor) + " ";
                        encontrado = true;
                        break;
                    } else if (valor.getId().toString().equals(globales.get(x).id)
                            && globales.get(x).Tipo.equalsIgnoreCase("Numerico")
                            && globales.get(x).valor instanceof Contar) {
                        ValorObjecto += this.Resultados(globales.get(x).valor) + " ";
                        encontrado = true;
                        break;
                    } else if (valor.getId().toString().equals(globales.get(x).id)
                            && globales.get(x).Tipo.equalsIgnoreCase("Numerico")
                            && globales.get(x).valor instanceof ContarSi) {
                        ValorObjecto += this.Resultados(globales.get(x).valor) + " ";
                        encontrado = true;
                        break;
                    } else if (valor.getId().toString().equals(globales.get(x).id)
                            && globales.get(x).Tipo.equalsIgnoreCase("Numerico")
                            && globales.get(x).valor instanceof Promedio) {
                        ValorObjecto += this.Resultados(globales.get(x).valor) + " ";
                        encontrado = true;
                        break;
                    }

                }// fin del for buscar
                if (encontrado == false) {   //se clasifica todos los errores semanticos
                    int j;
                    for (j = 0; j < globales.size(); j++) {
                        if (globales.get(j).valor instanceof ObtenerSi && (!globales.get(j).Tipo.equalsIgnoreCase("Cadena"))) {
                            ErrorSemantico error = new ErrorSemantico("Error Semantico", globales.get(j).Tipo,
                                    globales.get(j).Columna, globales.get(j).Fila, "Error Semantico de Tipo Cadena"
                            );
                            listaErrorSemantico.add(error);
                            existeid = true;
                            break;
                        } else if (globales.get(j).valor instanceof Sumar && (!globales.get(j).Tipo.equalsIgnoreCase("Numerico"))) {
                            ErrorSemantico error = new ErrorSemantico("Error Semantico", globales.get(j).Tipo,
                                    globales.get(j).Columna, globales.get(j).Fila, "Error Semantico de Tipo Numerico "
                            );
                            listaErrorSemantico.add(error);
                            existeid = true;
                            break;
                        } else if (globales.get(j).valor instanceof Promedio && (!globales.get(j).Tipo.equalsIgnoreCase("Numerico"))) {
                            ErrorSemantico error = new ErrorSemantico("Error Semantico", globales.get(j).Tipo,
                                    globales.get(j).Columna, globales.get(j).Fila, "Error Semantico de Tipo Numerico "
                            );
                            listaErrorSemantico.add(error);
                            existeid = true;
                            break;
                        } else if (globales.get(j).valor instanceof Contar && (!globales.get(j).Tipo.equalsIgnoreCase("Numerico"))) {
                            ErrorSemantico error = new ErrorSemantico("Error Semantico", globales.get(j).Tipo,
                                    globales.get(j).Columna, globales.get(j).Fila, "Error Semantico de Tipo Numerico "
                            );
                            listaErrorSemantico.add(error);
                            existeid = true;
                            break;
                        } else if (globales.get(j).valor instanceof ContarSi && (!globales.get(j).Tipo.equalsIgnoreCase("Numerico"))) {
                            ErrorSemantico error = new ErrorSemantico("Error Semantico", globales.get(j).Tipo,
                                    globales.get(j).Columna, globales.get(j).Fila, "Error Semantico de Tipo Numerico "
                            );
                            listaErrorSemantico.add(error);
                            existeid = true;
                            break;
                        } else if (globales.get(j).valor instanceof LeerArchivo && (!globales.get(j).Tipo.equalsIgnoreCase("Archivo"))) {
                            ErrorSemantico error = new ErrorSemantico("Error Semantico", globales.get(j).Tipo,
                                    globales.get(j).Columna, globales.get(j).Fila, "Error Semantico de Tipo Archivo "
                            );
                            listaErrorSemantico.add(error);
                            existeid = true;
                            break;
                        }
                    }
                    if (existeid == false) {
                        ErrorSemantico error = new ErrorSemantico("Error Semantico", valor.getId().toString(),
                                valor.getColumna(), valor.getFila(), "Error Semantico el identificador no existe "
                        );
                        listaErrorSemantico.add(error);
                    } // fin del if error semantico   
                }
            }
        }   // fin del for
        return ValorObjecto;
    }

    public String Resultados(Object Valor) {

        String RetornarValor = "";
        if (Valor instanceof LeerArchivo) {
            LeerArchivo readFile = (LeerArchivo) Valor;
            RetornarValor = readFile.Cabecera();
        } else if (Valor instanceof Sumar) {
            Sumar sum = (Sumar) Valor;
            RetornarValor = String.valueOf(sum.sumando());
        } else if (Valor instanceof Contar) {
            Contar cont = (Contar) Valor;
            RetornarValor = String.valueOf(cont.ConteoTotal());
        } else if (Valor instanceof Promedio) {
            Promedio prom = (Promedio) Valor;
            RetornarValor = String.valueOf(prom.Promediar());  // el ValueOf combierte cualquier tipo de Numero a String
        } else if (Valor instanceof ContarSi) {
            ContarSi consi = (ContarSi) Valor;
            RetornarValor = String.valueOf(consi.ContarCondicional());
        } else if (Valor instanceof ObtenerSi) {
            ObtenerSi obt = (ObtenerSi) Valor;
            RetornarValor = obt.ImprimirRegistro();
        }
        return RetornarValor; // retono un String
    }

}
