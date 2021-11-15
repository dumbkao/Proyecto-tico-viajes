
package ticoviaje.Controlador;

import java.util.Observer;
import ticoviaje.Modelos.EncomiendasViaje;

public class EncomiendasViajeControlador {
    private EncomiendasViaje modelo;
    
    public EncomiendasViajeControlador() {
        modelo = new EncomiendasViaje();
    }
    
    public void agregarObservador(Observer observer) {
        modelo.agregarObservador(observer);
    }
    
    public void regresar() {
        modelo.regresar();
    }
}
