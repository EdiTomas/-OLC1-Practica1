/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FaseCompilador;

import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;

/**
 *
 * @author edi
 */
public class PintarPalabras {

    public JTextPane texto;
    private StyleContext sc;
    private DefaultStyledDocument doc;

    public PintarPalabras() {
        this.texto = new JTextPane();
        this.sc = new StyleContext();
        this.doc = new DefaultStyledDocument(sc);
    }

    public void darEstilo(String textApintar) {
        texto.setDocument(doc);
        try {
            doc.insertString(0, textApintar, null);
        } catch (Exception ex) {
        }

    }

    public void pintarRojo(int inicial, int tamaño) {

        Style rojo = sc.addStyle("ConstantWidth", null);
        StyleConstants.setForeground(rojo, Color.red);
        doc.setCharacterAttributes(inicial, tamaño, rojo, false);

    }

    public void pintarAzul(int inicial, int tamaño) {

        Style Azul = sc.addStyle("ConstantWidth", null);
        StyleConstants.setForeground(Azul, Color.blue);
        doc.setCharacterAttributes(inicial, tamaño, Azul, false);
    }

    public void pintarVerde(int inicial, int tamaño) {

        Style Verde = sc.addStyle("ConstantWidth", null);
        StyleConstants.setForeground(Verde, Color.GREEN);
        doc.setCharacterAttributes(inicial, tamaño, Verde, false);
    }

    public void pintarAmarillo(int inicial, int tamaño) {

        Style Amarillo = sc.addStyle("ConstantWidth", null);
        StyleConstants.setForeground(Amarillo, Color.YELLOW);
        doc.setCharacterAttributes(inicial, tamaño, Amarillo, false);
    }

}
