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
public class Contar {

    public String id;
    public int Columna;
    public int Fila;

    public Contar(String id, int Columna, int Fila) {
        this.id = id;
        this.Fila = Fila;
        this.Columna = Columna;
    }

    public int ConteoTotal() {
        int contar = 0;
        try {
            LeerArchivo graficar = (LeerArchivo) this.Busqueda(id);
            contar = graficar.registro.size();

        } catch (Exception error) {
            contar = 0;
            ErrorSemantico errorsemantico = new ErrorSemantico("Error Semantico", id,
                    Columna, Fila, "No existe id o es invalido"
            );
            listaErrorSemantico.add(errorsemantico);
        }

        return contar;
    }

    public Object Busqueda(String id) {
        int z;
        Object Valor = null;
        for (z = 0; z < globales.size(); z++) {
            if (globales.get(z).id.equals(id)
                    && globales.get(z).Tipo.equalsIgnoreCase("Archivo")
                    && globales.get(z).valor instanceof LeerArchivo) {
                Valor = globales.get(z).valor;
                break;
            }
        }
        return Valor;
    }

}
