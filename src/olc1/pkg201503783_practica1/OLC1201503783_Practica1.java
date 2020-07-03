/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package olc1.pkg201503783_practica1;

import Aplicacion.Ventana;
import static FaseCompilador.GeneradorDeCompilador.generarcompiladores;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import org.jvnet.substance.SubstanceLookAndFeel;

/**
 *
 * @author edi
 */
public class OLC1201503783_Practica1 {

    public static void main(String[] args) {
//        colocarSkin();
        JFrame.setDefaultLookAndFeelDecorated(true);
        SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.EmeraldDuskSkin");
        // SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.MagmaSkin");
        // SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.RavenSkin");
        generarcompiladores();
        Ventana vn = new Ventana();
        vn.show();

    }

    public static void colocarSkin() throws UnsupportedLookAndFeelException {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
    }

}
