/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reportes;

import static FaseCompilador.Lexico.listaError;
import static FaseCompilador.Sintactico.ErrorSintactico;
import static FaseCompilador.Sintactico.listaErrorSemantico;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author edi
 */
public class ListaReportesHtml {

    public ListaReportesHtml() {
    }

    public static String FechaActual() {
        Date fecha = new Date();

        SimpleDateFormat formatofecha = new SimpleDateFormat("dd/MM/YYYY " + " HH:mm:ss " + "a");
        return formatofecha.format(fecha);
    }

    public void GenerarReportesErroresLexicos() {
        try {
            FileWriter archivo = new FileWriter("ReporteErrorLexico.html");
            PrintWriter escritura = new PrintWriter(archivo);
            //escribimos un archivo de texto con la estructura de html
            escritura.println("<html>");
            escritura.println(" <head>");
            escritura.println("<title> Reportes1 </title>");   // "< font color=white>"   D</FONT>
            escritura.println("<font color= white > " + "Fecha y Hora: " + FechaActual() + "</font> ");
            escritura.println(" <style type=\"text/css\">\n"
                    + //  " td{background:#ccc;}\n" +
                    " tr:hover td{   background:#369681;     color: white  }\n"
                    + "</style> "
            );

            escritura.println(" <h1><center> <font color= white >  ERRORES LEXICOS </font></center></h1>");
            escritura.println(" </head>");
            escritura.println(" <body  bgcolor= black >");    //#800000
            escritura.println("<center>" + "<table   BORDER = 0  width =100%  bgcolor=white cellspacing=0 cellpadding=10  > ");  //#008080
            escritura.println(
                    "<tr bgcolor= #246355   >" + "<td>" + "<B>" + "<font color= white >" + "No" + "</font>" + "</B>" + "</td>" //#008080
                    + "<td>" + "<B>" + "<font color= white >" + "Tipo" + "</font>" + "</B>" + "</td>"
                    + "<td>" + "<B>" + "<font color= white >" + "Lexema" + "</font>" + "</B>" + "</td>"
                    + "<td>" + "<B>" + "<font color= white >" + "Linea" + "</font>" + "</B>" + "</td>"
                    + "<td>" + "<B>" + "<font color= white >" + "Columna" + "</font>" + "</B>" + "</td>"
                    + "<td>" + "<B>" + "<font color= white >" + "Descripcion" + "</font>" + "</B>" + "</td>"
                    + "</tr>" + "</B>");

            for (int i = 0; i < listaError.size(); i++) {

                if (i % 2 == 0) {
                    escritura.println(
                            "<tr bgcolor=#ddd      >"
                            + "<td   >" + (i + 1) //#87CEFA
                            + "</td>" + "<td>" + listaError.get(i).tipo
                            + "</td>" + "<td>" + listaError.get(i).error
                            + "</td>" + "<td>" + listaError.get(i).linea
                            + "</td>" + "<td>" + listaError.get(i).columna
                            + "</td>" + "<td>" + listaError.get(i).Descripcion + "</td>" + "</tr>"
                    );

                } else {

                    escritura.println(
                            "<tr bgcolor=#F5F5F5    >" + "<td>" + (i + 1)
                            + "</td>" + "<td>" + listaError.get(i).tipo
                            + "</td>" + "<td>" + listaError.get(i).error
                            + "</td>" + "<td>" + listaError.get(i).linea
                            + "</td>" + "<td>" + listaError.get(i).columna
                            + "</td>" + "<td>" + listaError.get(i).Descripcion + "</td>" + "</tr>"
                    );
                }

            }
            escritura.println("</table>" + "</center>");
            escritura.println("</body>");
            escritura.println("</html>");

//nos aseguramos de cerrar el archivo
            archivo.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void GenerarReportesErroresSintacticos() {

        try {
            FileWriter archivo = new FileWriter("ReporteErrorSintactico.html");
            PrintWriter escritura = new PrintWriter(archivo);
            //escribimos un archivo de texto con la estructura de html
            escritura.println("<html>");
            escritura.println(" <head>");
            escritura.println("<title> Reportes2 </title>");   // "< font color=white>"   D</FONT>
            escritura.println("<font color= white > " + "Fecha y Hora: " + FechaActual() + "</font> ");
            escritura.println(" <style type=\"text/css\">\n"
                    + //  " td{background:#ccc;}\n" +
                    " tr:hover td{   background:#1c1c1c;     color: white  }\n"
                    + "</style> "
            );
//#369681
            escritura.println(" <h1><center> <font color= white > ERRORES SINTACTICOS  </font></center></h1>");
            escritura.println(" </head>");
            escritura.println(" <body  bgcolor= #632432 >");    //#800000
            escritura.println("<center>" + "<table   BORDER = 0  width =100%  bgcolor=white cellspacing=0 cellpadding=10  > ");  //#008080
            escritura.println(
                    "<tr bgcolor= black >" + "<td>" + "<B>" + "<font color= white >" + "No" + "</font>" + "</B>" + "</td>" //#008080

                    + "<td>" + "<B>" + "<font color= white >" + "Tipo" + "</font>" + "</B>" + "</td>"
                    + "<td>" + "<B>" + "<font color= white >" + "Lexema" + "</font>" + "</B>" + "</td>"
                    + "<td>" + "<B>" + "<font color= white >" + "Linea" + "</font>" + "</B>" + "</td>"
                    + "<td>" + "<B>" + "<font color= white >" + "Columna" + "</font>" + "</B>" + "</td>"
                    + "<td>" + "<B>" + "<font color= white >" + "Descripcion" + "</font>" + "</B>" + "</td>"
                    + "</tr>" + "</B>");

            for (int i = 0; i < ErrorSintactico.size(); i++) {

                if (i % 2 == 0) {
                    escritura.println(
                            "<tr bgcolor=#ddd      >"
                            + "<td   >" + (i + 1) //#87CEFA
                            + "</td>" + "<td>" + ErrorSintactico.get(i).tipo
                            + "</td>" + "<td>" + ErrorSintactico.get(i).error
                            + "</td>" + "<td>" + ErrorSintactico.get(i).linea
                            + "</td>" + "<td>" + ErrorSintactico.get(i).columna
                            + "</td>" + "<td>" + ErrorSintactico.get(i).Descripcion + "</td>" + "</tr>"
                    );

                } else {

                    escritura.println(
                            "<tr bgcolor=#F5F5F5    >" + "<td>" + (i + 1)
                            + "</td>" + "<td>" + ErrorSintactico.get(i).tipo
                            + "</td>" + "<td>" + ErrorSintactico.get(i).error
                            + "</td>" + "<td>" + ErrorSintactico.get(i).linea
                            + "</td>" + "<td>" + ErrorSintactico.get(i).columna
                            + "</td>" + "<td>" + ErrorSintactico.get(i).Descripcion + "</td>" + "</tr>"
                    );
                }

            }
            escritura.println("</table>" + "</center>");
            escritura.println("</body>");
            escritura.println("</html>");

            //nos aseguramos de cerrar el archivo
            archivo.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void GenerarReportesErroresSemanticos() {

        try {
            FileWriter archivo = new FileWriter("ReporteErrorSemantico.html");
            PrintWriter escritura = new PrintWriter(archivo);
            //escribimos un archivo de texto con la estructura de html
            escritura.println("<html>");
            escritura.println(" <head>");
            escritura.println("<title> Reportes3 </title>");   // "< font color=white>"   D</FONT>
            escritura.println("<font color= white > " + "Fecha y Hora: " + FechaActual() + "</font> ");
            escritura.println(" <style type=\"text/css\">\n"
                    + //  " td{background:#ccc;}\n" +
                    " tr:hover td{   background:#FFA07A;     color: white  }\n"
                    + "</style> "
            );
//#369681
            escritura.println(" <h1><center> <font color= white > ERRORES SEMANTICOS  </font></center></h1>");
            escritura.println(" </head>");
            // escritura.println(" <body  bgcolor= #632432 >");    //#800000
            escritura.println(" <body  bgcolor= #008000 >");
            escritura.println("<center>" + "<table   BORDER = 0  width =100%  bgcolor=white cellspacing=0 cellpadding=10  > ");  //#008080
            escritura.println(
                    "<tr bgcolor= black >" + "<td>" + "<B>" + "<font color= white >" + "No" + "</font>" + "</B>" + "</td>" //#008080

                    + "<td>" + "<B>" + "<font color= white >" + "Tipo" + "</font>" + "</B>" + "</td>"
                    + "<td>" + "<B>" + "<font color= white >" + "Lexema" + "</font>" + "</B>" + "</td>"
                    + "<td>" + "<B>" + "<font color= white >" + "Linea" + "</font>" + "</B>" + "</td>"
                    + "<td>" + "<B>" + "<font color= white >" + "Columna" + "</font>" + "</B>" + "</td>"
                    + "<td>" + "<B>" + "<font color= white >" + "Descripcion" + "</font>" + "</B>" + "</td>"
                    + "</tr>" + "</B>");

            for (int i = 0; i < listaErrorSemantico.size(); i++) {

                if (i % 2 == 0) {
                    escritura.println(
                            "<tr bgcolor=#ddd      >"
                            + "<td   >" + (i + 1) //#87CEFA
                            + "</td>" + "<td>" + listaErrorSemantico.get(i).tipo
                            + "</td>" + "<td>" + listaErrorSemantico.get(i).error
                            + "</td>" + "<td>" + listaErrorSemantico.get(i).linea
                            + "</td>" + "<td>" + listaErrorSemantico.get(i).columna
                            + "</td>" + "<td>" + listaErrorSemantico.get(i).Descripcion + "</td>" + "</tr>"
                    );

                } else {

                    escritura.println(
                            "<tr bgcolor=#F5F5F5    >" + "<td>" + (i + 1)
                            + "</td>" + "<td>" + listaErrorSemantico.get(i).tipo
                            + "</td>" + "<td>" + listaErrorSemantico.get(i).error
                            + "</td>" + "<td>" + listaErrorSemantico.get(i).linea
                            + "</td>" + "<td>" + listaErrorSemantico.get(i).columna
                            + "</td>" + "<td>" + listaErrorSemantico.get(i).Descripcion + "</td>" + "</tr>"
                    );
                }

            }
            escritura.println("</table>" + "</center>");
            escritura.println("</body>");
            escritura.println("</html>");

            //nos aseguramos de cerrar el archivo
            archivo.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
