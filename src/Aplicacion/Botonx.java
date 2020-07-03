/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aplicacion;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextPane;
import javax.swing.plaf.basic.BasicButtonUI;

/**
 *
 * @author edi
 */
public class Botonx extends JButton implements MouseListener {
    
    private JTabbedPane panel;
 private PanelTab btc;
 private int tipo;
 ArrayList<JTextPane> lista;
 
 
  Botonx(JTabbedPane pane,PanelTab btc,int op) {
     
      lista = Ventana.texto;
      panel=pane;
     this.btc=btc;
     tipo=op;
        int size = 17;
        setPreferredSize(new Dimension(size, size));
        setToolTipText("Cerrar Pestaña");
        setUI(new BasicButtonUI());
        setContentAreaFilled(false);
        setFocusable(false);
        setBorder(BorderFactory.createEtchedBorder());
        setBorderPainted(false);
        addMouseListener(this);
        setRolloverEnabled(true);
        addActionListener(new ActionListener(){
       //  private Component btc;

            
            
   @Override
   public void actionPerformed(ActionEvent e) {
    int i =    getPanel().getSelectedIndex();
          // panel.indexOfTabComponent(Botonx.this);
                  
    if (i != -1) 
          {
               getPanel().remove(i);
               lista.remove(i);
               Ventana.numero = Ventana.numero-1;
          }
   }
        });
    }
   
    public void updateUI() {
    }
   
    
    /*
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        if(tipo==0){
         if (getModel().isPressed()) {
          g2.translate(1, 1);
         }
         g2.setStroke(new BasicStroke(3));
         g2.setColor(Color.BLACK);
         if (getModel().isRollover()) {
          g2.setColor(Color.RED);
         }
         g2.drawLine(5, 5, 12, 12);
         g2.drawLine(12, 6, 6, 12);
         g2.dispose();
        }else{
        // ImageIcon img=new ImageIcon(this.getClass().getResource("Salir.png"));
        // g2.drawImage(img.getImage(), 1,0,14,14, this);
           
       g2.dispose();
        }
    }
    
    */
    
    protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g.create();
            //shift the image for pressed buttons
            if (getModel().isPressed()) {
                g2.translate(1, 1);
            }
            g2.setStroke(new BasicStroke(2));
            g2.setColor(Color.BLACK);
            if (getModel().isRollover()) {
                g2.setColor(Color.RED);
            }
            int delta = 6;
            g2.drawLine(delta, delta, getWidth() - delta - 1, getHeight() - delta - 1);
            g2.drawLine(getWidth() - delta - 1, delta, delta, getHeight() - delta - 1);
            g2.dispose();
        }
    
    @Override
    public void mouseClicked(MouseEvent e) {
      
        
    
    
    }

    @Override
    public void mousePressed(MouseEvent e) {
    
    
    
    
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    
    
    
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    
        Component component = e.getComponent();
        if (component instanceof AbstractButton) {
            AbstractButton button = (AbstractButton) component;
            button.setBorderPainted(true);
        }
        
        
    
    }

    @Override
    public void mouseExited(MouseEvent e) {
    
    Component component = e.getComponent();
        if (component instanceof AbstractButton) {
            AbstractButton button = (AbstractButton) component;
            button.setBorderPainted(false);
        }
        
        
    
    }

    public JTabbedPane getPanel() {
        return panel;
    }

    public void setPanel(JTabbedPane panel) {
        this.panel = panel;
    }

    public PanelTab getBtc() {
        return btc;
    }

    public void setBtc(PanelTab btc) {
        this.btc = btc;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
    
    
    
}
