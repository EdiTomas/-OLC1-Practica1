/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FaseCompilador2;

/**
 *
 * @author edi
 */
public class CompilarArchivos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        generarcompiladores();
    }

    public static void generarcompiladores() {
        try {
            String ruta = "src/FaseCompilador2/";
            String opcFlex[] = {ruta + "scanner.jflex", "-d", ruta};
            jflex.Main.generate(opcFlex);

            String opcCUP[] = {"-destdir", ruta, "-parser", "Parser", ruta + "Parser.cup"};
            java_cup.Main.main(opcCUP);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
