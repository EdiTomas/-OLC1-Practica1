/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aplicacion;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 *
 * @author edi
 */
public class PanelTab  extends JPanel{
    JTabbedPane pestañas;
 int tipo;


    public PanelTab(JTabbedPane p,int op) {
     
        if (p != null) {
         this.pestañas = p;
         tipo=op;
            setOpaque(false);
            JLabel titulo = new JLabel() {
                public String getText() {
                    int i =  pestañas.indexOfTabComponent(PanelTab.this);
                    if (i != -1) {
                        return pestañas.getTitleAt(i);
                    }
                    return null;
                }
            };
            add(titulo);
            titulo.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 5));
            JButton button = new Botonx(pestañas,this,tipo);
            add(button);
        }
    }
    
    
    
    
    
}
