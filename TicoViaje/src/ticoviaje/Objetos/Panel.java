/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticoviaje.Objetos;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author hilla
 */
public class Panel extends JPanel {
    ImageIcon imagen;
    String ruta;
    
public Panel(String ruta){
    this.ruta=ruta;
}

    @Override
    public void paint(Graphics g){
    Dimension tamanio=getSize();
    imagen=new ImageIcon(getClass().getResource(ruta));
    g.drawImage(imagen.getImage(), 0, 0, tamanio.width, tamanio.height,null);
    setOpaque(false);
    paint(g);
}
}
