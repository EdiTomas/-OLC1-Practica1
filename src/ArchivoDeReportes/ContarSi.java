/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArchivoDeReportes;

import FaseCompilador.ErrorSemantico;
import static FaseCompilador.Sintactico.globales;
import static FaseCompilador.Sintactico.listaErrorSemantico;

/**
 *
 * @author edi
 */
public class ContarSi {

    public String id;
    public String Clave;
    public String Operarcion_Relacional;
    public Object valor;
    public int Columna;
    public int Fila;

    public ContarSi(String id, String Clave, String Operarcion_Relacional, Object valor, int Columna, int Fila) {
        this.id = id;
        this.Clave = Clave;
        this.Operarcion_Relacional = Operarcion_Relacional;
        this.valor = valor;
        this.Columna = Columna;
        this.Fila = Fila;
    }

    public int ContarCondicional() {

        int y, x;
        boolean errorsemantico = false;
        int resultado = 0;
        try {
            LeerArchivo graficar = (LeerArchivo) this.Busqueda(id);
            if (graficar != null) {
                int total = 0;
                for (y = 0; y < graficar.registro.size(); y++) {

                    for (x = 0; x < graficar.registro.get(y).size(); x++) {
                        if ((valor instanceof Double)
                                && (graficar.registro.get(y).get(busquedaX(graficar)).getValor() instanceof Double)) {
                            double a = Double.parseDouble(graficar.registro.get(y).get(busquedaX(graficar)).getValor().toString());
                            double b = Double.parseDouble(valor.toString());
                            switch (Operarcion_Relacional) {
                                case ">":
                                    if (a > b) {
                                        total += 1;
                                        resultado = total;
                                        errorsemantico = true;
                                    }
                                    break;
                                case "<":
                                    if (a < b) {
                                        total += 1;
                                        resultado = total;
                                        errorsemantico = true;
                                    }
                                    break;
                                case "<=":
                                    if (a <= b) {
                                        total += 1;
                                        resultado = total;
                                        errorsemantico = true;
                                    }
                                    break;
                                case ">=":
                                    if (a >= b) {
                                        total += 1;
                                        resultado = total;
                                        errorsemantico = true;
                                    }
                                    break;
                                case "==":
                                    if (a == b) {
                                        total += 1;
                                        resultado = total;
                                        errorsemantico = true;
                                    }
                                    break;
                                case "!=":
                                    if (a != b) {
                                        total += 1;
                                        resultado = total;
                                        errorsemantico = true;
                                    }
                                    break;
                            }

                            break;
                        } else if ((valor instanceof String) && (graficar.registro.get(y).get(busquedaX(graficar)).getValor() instanceof String)) {
                            String a = graficar.registro.get(y).get(busquedaX(graficar)).getValor().toString();
                            String b = valor.toString();
                            switch (Operarcion_Relacional) {
                                case "==":
                                    if (a.equals(b)) {
                                        total += 1;
                                        resultado = total;
                                        errorsemantico = true;
                                    }
                                    break;
                                case "!=":
                                    if (!a.equals(b)) {
                                        total += 1;
                                        resultado = total;
                                        errorsemantico = true;
                                    }
                                    break;
                            }

                            break;
                        }
                    }    // for interno
                } // fin del for
                if (errorsemantico == false) {
                    ErrorSemantico ers = new ErrorSemantico("Error Semantico", valor.toString(),
                            Columna, Fila, "Valor es invalido");
                    listaErrorSemantico.add(ers);
                }
            } else {
                ErrorSemantico ersm = new ErrorSemantico("Error Semantico", id,
                        Columna, Fila, "No existe"
                );
                listaErrorSemantico.add(ersm);
            }
        } catch (Exception errores) {

            ErrorSemantico ers = new ErrorSemantico("Error Semantico", Clave,
                    Columna, Fila, "Clave es invalido");
            listaErrorSemantico.add(ers);
        }
        return resultado;
    }

    public Object Busqueda(String id) {
        int z;
        boolean encontrado = false;
        Object Valor = null;
        for (z = 0; z < globales.size(); z++) {
            if (globales.get(z).id.equals(id)
                    && globales.get(z).Tipo.equals("Archivo")
                    && globales.get(z).valor instanceof LeerArchivo) {
                Valor = globales.get(z).valor;
                encontrado = true;
                break;
            }
        }

        return Valor;
    }

    public int busquedaX(LeerArchivo graficar) {
        int x;
        for (x = 0; x < graficar.encabezado.size(); x++) {
            if (Clave.equals(graficar.encabezado.get(x))) {
                return x;
            }
        }
        return -1;
    }

}
