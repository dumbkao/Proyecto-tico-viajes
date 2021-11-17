/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticoviaje.Controlador;
import java.util.Observer;
import ticoviaje.Modelos.*;

public class TicoViajesControlador {
    private TicoViajes modelo;
    public TicoViajesControlador(){
        this.modelo= new TicoViajes();
    }
    public void agregarObservador(Observer o){
        modelo.agregarObservador(o);
    }
    public void abrirEncomiendas() {
     modelo.abrirEncomiendas();
    }
    public boolean abrirTiquetes(){
       return modelo.abrirTiquetes();
    }
    public void mantenimiento() {
        modelo.mantenimiento();
    }
}
