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
public class ObtenerSi {

    public String id;
    public String Clave;
    public String Operarcion_Relacional;
    public Object valor;
    public int Columna;
    public int Fila;

    public ObtenerSi(String id, String Clave, String Operarcion_Relacional, Object valor, int Columna, int Fila) {
        this.id = id;
        this.Clave = Clave;
        this.Operarcion_Relacional = Operarcion_Relacional;
        this.valor = valor;
        this.Columna = Columna;
        this.Fila = Fila;
    }

    public String ImprimirRegistro() {
        String cadena = "";
        boolean encontrado = false;
        int x, y;
        try {
            LeerArchivo graficar = (LeerArchivo) this.Busqueda(id);
            if (graficar != null) {
                for (y = 0; y < graficar.registro.size(); y++) {

                    if (y == 0) {
                        cadena += "[ \n";
                    }

                    String bandera = "";

                    for (x = 0; x < graficar.registro.get(y).size(); x++) {

                        if ((graficar.registro.get(y).get(busquedaX(graficar)).getValor() instanceof Double)
                                && (valor instanceof Double)) {
                            double a = Double.parseDouble(graficar.registro.get(y).get(busquedaX(graficar)).getValor().toString());
                            double b = Double.parseDouble(valor.toString());
                            switch (Operarcion_Relacional) {
                                case ">":
                                    if (a > b) {
                                        if (x == graficar.registro.get(y).size() - 1) {
                                            bandera += graficar.encabezado.get(x) + ": " + graficar.registro.get(y).get(x).getValor().toString() + " }" + "\n";
                                            encontrado = true;
                                        } else if (x == 0) {
                                            bandera += "{ " + graficar.encabezado.get(x) + ": " + graficar.registro.get(y).get(x).getValor().toString() + ",  ";
                                            encontrado = true;
                                        } else {
                                            bandera += graficar.encabezado.get(x) + ": " + graficar.registro.get(y).get(x).getValor().toString() + ",  ";
                                            encontrado = true;
                                        }
                                    }
                                    break;
                                case "<":
                                    if (a < b) {
                                        if (x == graficar.registro.get(y).size() - 1) {
                                            bandera += graficar.encabezado.get(x) + ": " + graficar.registro.get(y).get(x).getValor().toString() + " }" + "\n";
                                            encontrado = true;
                                        } else if (x == 0) {
                                            bandera += "{ " + graficar.encabezado.get(x) + ": " + graficar.registro.get(y).get(x).getValor().toString() + ",  ";
                                            encontrado = true;
                                        } else {
                                            bandera += graficar.encabezado.get(x) + ": " + graficar.registro.get(y).get(x).getValor().toString() + ",  ";
                                            encontrado = true;
                                        }
                                    }
                                    break;
                                case "<=":
                                    if (a <= b) {
                                        if (x == graficar.registro.get(y).size() - 1) {
                                            encontrado = true;
                                            bandera += graficar.encabezado.get(x) + ": " + graficar.registro.get(y).get(x).getValor().toString() + " }" + "\n";
                                        } else if (x == 0) {
                                            encontrado = true;
                                            bandera += "{ " + graficar.encabezado.get(x) + ": " + graficar.registro.get(y).get(x).getValor().toString() + ",  ";
                                        } else {
                                            encontrado = true;
                                            bandera += graficar.encabezado.get(x) + ": " + graficar.registro.get(y).get(x).getValor().toString() + ",  ";
                                        }
                                    }
                                    break;
                                case ">=":
                                    if (a >= b) {
                                        if (x == graficar.registro.get(y).size() - 1) {
                                            encontrado = true;
                                            bandera += graficar.encabezado.get(x) + ": " + graficar.registro.get(y).get(x).getValor().toString() + " }" + "\n";
                                        } else if (x == 0) {
                                            encontrado = true;
                                            bandera += "{ " + graficar.encabezado.get(x) + ": " + graficar.registro.get(y).get(x).getValor().toString() + ",  ";
                                        } else {
                                            encontrado = true;
                                            bandera += graficar.encabezado.get(x) + ": " + graficar.registro.get(y).get(x).getValor().toString() + ",  ";
                                        }
                                    }
                                    break;
                                case "==":
                                    if (a == b) {
                                        if (x == graficar.registro.get(y).size() - 1) {
                                            bandera += graficar.encabezado.get(x) + ": " + graficar.registro.get(y).get(x).getValor().toString() + " }" + "\n";
                                            encontrado = true;
                                        } else if (x == 0) {
                                            bandera += "{ " + graficar.encabezado.get(x) + ": " + graficar.registro.get(y).get(x).getValor().toString() + ",  ";
                                            encontrado = true;
                                        } else {
                                            bandera += graficar.encabezado.get(x) + ": " + graficar.registro.get(y).get(x).getValor().toString() + ",  ";
                                            encontrado = true;
                                        }
                                    }
                                    break;
                                case "!=":
                                    if (a != b) {
                                        if (x == graficar.registro.get(y).size() - 1) {
                                            bandera += graficar.encabezado.get(x) + ": " + graficar.registro.get(y).get(x).getValor().toString() + " }" + "\n";
                                            encontrado = true;
                                        } else if (x == 0) {
                                            bandera += "{ " + graficar.encabezado.get(x) + ": " + graficar.registro.get(y).get(x).getValor().toString() + ",  ";
                                            encontrado = true;
                                        } else {
                                            bandera += graficar.encabezado.get(x) + ": " + graficar.registro.get(y).get(x).getValor().toString() + ",  ";
                                            encontrado = true;
                                        }
                                    }
                                    break;
                            }

                        } else if ((graficar.registro.get(y).get(busquedaX(graficar)).getValor() instanceof String)
                                && (valor instanceof String)) {

                            String a = graficar.registro.get(y).get(busquedaX(graficar)).getValor().toString();
                            String b = valor.toString();
                            switch (Operarcion_Relacional) {
                                case "==":
                                    if (a.equals(b)) {
                                        if (x == graficar.registro.get(y).size() - 1) {
                                            bandera += graficar.encabezado.get(x) + ": " + graficar.registro.get(y).get(x).getValor().toString() + " }" + "\n";
                                            encontrado = true;
                                        } else if (x == 0) {
                                            bandera += "{ " + graficar.encabezado.get(x) + ": " + graficar.registro.get(y).get(x).getValor().toString() + ",  ";
                                            encontrado = true;
                                        } else {
                                            bandera += graficar.encabezado.get(x) + ": " + graficar.registro.get(y).get(x).getValor().toString() + ",  ";
                                            encontrado = true;
                                        }
                                    }
                                    break;
                                case "!=":
                                    if (!a.equals(b)) {
                                        if (x == graficar.registro.get(y).size() - 1) {
                                            bandera += graficar.encabezado.get(x) + ": " + graficar.registro.get(y).get(x).getValor().toString() + " }" + "\n";
                                            encontrado = true;
                                        } else if (x == 0) {
                                            bandera += "{ " + graficar.encabezado.get(x) + ": " + graficar.registro.get(y).get(x).getValor().toString() + ",  ";
                                            encontrado = true;
                                        } else {
                                            bandera += graficar.encabezado.get(x) + ": " + graficar.registro.get(y).get(x).getValor().toString() + ",  ";
                                            encontrado = true;
                                        }
                                    }
                                    break;
                            }
                        }
                    }
                    cadena += bandera;
                    if (y == graficar.registro.size() - 1) {
                        cadena += " ]";
                    }
                }  // fin del for

                if (encontrado == false) {
                    ErrorSemantico ers = new ErrorSemantico("Error Semantico", valor.toString(),
                            Columna, Fila, "Valor es invalido");
                    listaErrorSemantico.add(ers);
                    cadena = "";
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
        return cadena;
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
