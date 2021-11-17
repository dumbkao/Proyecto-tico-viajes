
package ticoviaje.Controlador;

import java.util.ArrayList;
import java.util.Observer;
import ticoviaje.Modelos.ConjuntoViajes;
import ticoviaje.Modelos.Flotilla;
import ticoviaje.Modelos.Mantenimiento;
import ticoviaje.Objetos.Chofer;

public class MantenimientoControlador {
    private Mantenimiento modelo;
    
    public MantenimientoControlador(ConjuntoViajes viajes, ArrayList<Chofer> choferes, Flotilla flotilla) {
        modelo = new Mantenimiento(viajes, choferes, flotilla);
    }
    
    public void agregar_viaje() {
        modelo.agregar_viaje();
    }
    
    public void remover_viaje() {
        modelo.remover_viaje();
    }

    public void agregar_chofer() {
        modelo.agregar_chofer();
    }
    
    public void remover_chofer() {
        modelo.remover_chofer();
    }

    public void regresar() {
        modelo.regresar();
    }

    public void agregarObservador(Observer observer) {
        modelo.agregarObservador(observer);
    }
}
