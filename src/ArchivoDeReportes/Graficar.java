/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArchivoDeReportes;

import static FaseCompilador.Sintactico.globales;
import java.io.File;
import java.io.IOException;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.chart.ChartUtilities;

/**
 *
 * @author edi
 */
public class Graficar {

    public String Nombre;
    public String Titulo;
    public String id;
    public String Valoresx;
    public String Valoresy;

    public Graficar(String Nombre, String Titulo, String id, String Valoresx, String Valoresy) {
        this.Nombre = Nombre;
        this.Titulo = Titulo;
        this.id = id;
        this.Valoresx = Valoresx;
        this.Valoresy = Valoresy;
    }

    public void GenerarGrafica() {
        int y, x;
        try {
            DefaultCategoryDataset dataset = new DefaultCategoryDataset();
            LeerArchivo graficar = (LeerArchivo) this.Busqueda(id);
            for (y = 0; y < graficar.registro.size(); y++) {

                for (x = 0; x < graficar.registro.get(y).size(); x++) {

                    if (((graficar.registro.get(y).get(busquedaY(graficar)).getValor() instanceof Double)
                            || (graficar.registro.get(y).get(busquedaY(graficar)).getValor() instanceof Integer))
                            || (graficar.registro.get(y).get(busquedaX(graficar)).getValor() instanceof String)) {

                        dataset.addValue(
                                Double.parseDouble(graficar.registro.get(y).get(busquedaY(graficar)).getValor().toString()),
                                graficar.registro.get(y).get(busquedaX(graficar)).getValor().toString(),
                                graficar.registro.get(y).get(busquedaX(graficar)).getValor().toString());

                    }

                }// FIN DEL PRIMER FOR

            } // FIN DEL SEGUNDO FOR
            JFreeChart barChart = ChartFactory.createBarChart(
                    Titulo,
                    Valoresx, Valoresy,
                    dataset, PlotOrientation.VERTICAL,
                    true, true, false);

            int width = 640;
            /* Width of the image */
            int height = 480;
            /* Height of the image */
            File BarChart = new File(Nombre);
            ChartUtilities.saveChartAsJPEG(BarChart, barChart, width, height);
        } catch (IOException error) {
        }
    }

    public Object Busqueda(String id) {
        int z;
        boolean encontrado = false;
        Object Valor = null;
        for (z = 0; z < globales.size(); z++) {
            if (globales.get(z).id.equals(id) && globales.get(z).Tipo.equals("Archivo")) {
                Valor = globales.get(z).valor;
                encontrado = true;
                break;
            }
        }
        if (encontrado == false) {
            // error semantico
        }
        return Valor;
    }

    public int busquedaX(LeerArchivo graficar) {
        int x;
        for (x = 0; x < graficar.encabezado.size(); x++) {
            if (Valoresx.equals(graficar.encabezado.get(x))) {
                return x;
            }
        }
        return 0;
    }

    public int busquedaY(LeerArchivo graficar) {
        int x;
        for (x = 0; x < graficar.encabezado.size(); x++) {
            if (Valoresy.equals(graficar.encabezado.get(x))) {
                return x;
            }
        }
        return 0;
    }

}
