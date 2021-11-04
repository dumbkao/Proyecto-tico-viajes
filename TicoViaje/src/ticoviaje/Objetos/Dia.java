
package ticoviaje.Objetos;

import java.util.Date;
import ticoviaje.Modelos.Viaje;

public class Dia {
    private Date fecha;
    private ConjuntoViajes viajes;
    
    public Dia() {
        fecha = new Date();
        viajes = new ConjuntoViajes();
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public ConjuntoViajes getViajes() {
        return viajes;
    }

    public void setViajes(ConjuntoViajes viajes) {
        this.viajes = viajes;
    }
    
    public void addViaje(Viaje viaje) {
        viajes.add(viaje);
    }
}
