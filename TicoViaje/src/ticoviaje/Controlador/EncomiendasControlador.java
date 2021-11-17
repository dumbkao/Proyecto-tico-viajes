
package ticoviaje.Controlador;

import java.util.Observer;
import ticoviaje.Modelos.Encomiendas;

public class EncomiendasControlador {
    
    private Encomiendas modelo;
    
    public EncomiendasControlador() {
        modelo = new Encomiendas();
    }
    
    public void ver_clientes() {
        modelo.ver_clientes();
    }
    
    public boolean encomienda_viaje() {
        return modelo.encomienda_viaje();
    }
    
    public void regresar() {
        modelo.regresar();
    }
    
    public void encomienda_codigo() {
        modelo.encomienda_codigo();
    }
    
    public void agregarObservador(Observer observer) {
        modelo.agregarObservador(observer);
    }
}
