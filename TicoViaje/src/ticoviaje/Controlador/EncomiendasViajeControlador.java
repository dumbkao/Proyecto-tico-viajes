
package ticoviaje.Controlador;

import java.util.Observer;
import javax.swing.JTable;
import ticoviaje.Modelos.EncomiendasViaje;
import ticoviaje.Modelos.Viaje;

public class EncomiendasViajeControlador {
    private EncomiendasViaje modelo;
    
    public EncomiendasViajeControlador(Viaje viaje) {
        modelo = new EncomiendasViaje(viaje);
    }
    
    public void agregarObservador(Observer observer) {
        modelo.agregarObservador(observer);
    }
    
    public void regresar() {
        modelo.regresar();
    }
    
    public void generar_tabla(JTable tabla) {
        modelo.generar_tabla(tabla);
    }
}
