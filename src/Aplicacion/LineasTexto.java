/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aplicacion;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.text.Document;

/**
 *
 * @author edi
 */
public class LineasTexto extends JPanel {
 
  public JTextPane texto;
  public JScrollPane scrollPane;

public LineasTexto (){
    super ();
    setMinimumSize (new Dimension (30, 30));
    setPreferredSize (new Dimension (30, 30));
    setMinimumSize (new Dimension (30, 30));
    texto = new JTextPane (){ // se necesita pintar las lineas en el panel 
     
     public void paint (Graphics g)
      {
	super.paint (g);
	LineasTexto.this.repaint ();
     
      }
    };
   scrollPane = new JScrollPane ();
  
  
  }

@Override
  public void paint (Graphics g){
    super.paint (g);
   
    int start =
      texto.viewToModel (scrollPane.getViewport ().getViewPosition ());
    int end = texto.viewToModel (new
		   Point (scrollPane.getViewport ().getViewPosition ().x +
			  texto.getWidth (),
			  scrollPane.getViewport ().getViewPosition ().y +
			  texto.getHeight ()));
  
    
    
    Document doc = texto.getDocument ();
    int startline = doc.getDefaultRootElement ().getElementIndex (start);
    int endline = doc.getDefaultRootElement ().getElementIndex (end)+1; //pinta la linea numero 1
    int fontHeight = g.getFontMetrics (texto.getFont ()).getHeight ();	// fuente
    
    for (int line = startline, y = 0; line <= endline;line++, y += fontHeight){
	//g.setColor(new Color(80, 13, 255));
        g.setColor(Color.BLUE);
        g.drawString (Integer.toString (line), 0, y);
      }
    
  }


    
    
    
}
