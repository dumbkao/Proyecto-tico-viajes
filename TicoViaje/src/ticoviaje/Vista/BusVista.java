/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticoviaje.Vista;

import java.awt.Container;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JFrame;
import ticoviaje.Controlador.BusControlador;

/**
 *
 * @author hilla
 */
public class BusVista extends JFrame implements Observer {

    private BusControlador controlador;

    public BusVista(String titulo) {
        super(titulo);
        controlador = new BusControlador();
    }

    public void iniciar() {
        setSize(700, 300);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ajustarComponentes(getContentPane());
        agregarEventos();
        setVisible(true);
    }

    public void ajustarComponentes(Container container) {

    }

    public void agregarEventos() {

    }

    @Override
    public void update(Observable o, Object arg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
