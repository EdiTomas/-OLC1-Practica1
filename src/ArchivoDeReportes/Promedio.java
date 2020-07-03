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
public class Promedio {

    public String id;
    public String clave;
    public int Columna;
    public int Fila;

    public Promedio(String id, String clave, int Columna, int Fila) {
        this.id = id;
        this.clave = clave;
        this.Columna = Columna;
        this.Fila = Fila;
    }

    public double Promediar() {

        int y, x;
        boolean existeclave = false;
        double resultado = 0.0;
        double total = 0.0;
        try {

            LeerArchivo graficar = (LeerArchivo) this.Busqueda(id);
            if (graficar != null) {

                total = graficar.registro.size();
                for (y = 0; y < graficar.registro.size(); y++) {

                    for (x = 0; x < graficar.registro.get(y).size(); x++) {
                        if ((graficar.registro.get(y).get(busquedaX(graficar)).getValor() instanceof Double)
                                || (graficar.registro.get(y).get(busquedaX(graficar)).getValor() instanceof Integer)) {
                            resultado += Double.parseDouble(graficar.registro.get(y).get(busquedaX(graficar)).getValor().toString());
                            existeclave = true;
                            break;
                        }
                    }
                }

                if (existeclave == false) {
                    ErrorSemantico errorsemantico = new ErrorSemantico("Error Semantico", clave,
                            Columna, Fila, "Clave  es invalido"
                    );
                    listaErrorSemantico.add(errorsemantico);
                }
            } else {
                ErrorSemantico errorsemantico = new ErrorSemantico("Error Semantico", id,
                        Columna, Fila, "No existe"
                );
                listaErrorSemantico.add(errorsemantico);
            }
        } catch (Exception v) {
            ErrorSemantico errorsemantico = new ErrorSemantico("Error Semantico", clave,
                    Columna, Fila, "Clave  es invalido"
            );
            listaErrorSemantico.add(errorsemantico);
        }
        return (resultado / total);
    }

    public Object Busqueda(String id) {
        int z;
        Object Valor = null;
        for (z = 0; z < globales.size(); z++) {
            if (globales.get(z).id.equals(id) && globales.get(z).Tipo.equals("Archivo")) {
                Valor = globales.get(z).valor;
                break;
            }
        }
        return Valor;
    }

    public int busquedaX(LeerArchivo graficar) {
        int x;
        for (x = 0; x < graficar.encabezado.size(); x++) {
            if (clave.equals(graficar.encabezado.get(x))) {
                return x;
            }
        }
        return -1;
    }

}
