/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticoviaje.Controlador;

import java.util.Observer;
import ticoviaje.Objetos.Bus;

/**
 *
 * @author hilla
 */
public class BusControlador {
     private final Bus datos;
    
    public BusControlador() {
        datos = new Bus();
    }

    public void agregarObservador(Observer observador) {
        datos.addObserver(observador);
    }

}
