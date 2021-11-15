package ticoviaje.Modelos;

import java.util.Observable;
import ticoviaje.Objetos.ConjuntoEncomienda;
import ticoviaje.Objetos.Encomienda;

public class Viaje extends Observable {

    private final ConjuntoEncomienda encomiendas;
    private String ruta;
    private String fecha;
    private String horario;
    private int kilometros;
    private int costo;
    private Bus unidad;

    public Viaje() {
        this.encomiendas = new ConjuntoEncomienda();
        this.ruta = "";
        this.fecha = "";
        this.horario = "";
        this.kilometros = 0;
        this.costo = 0;
        this.unidad = new Bus();
    }

    public ConjuntoEncomienda getEncomiendas() {
        return encomiendas;
    }

    public void agregarEncomienda(Encomienda encomienda) {
        encomiendas.add(encomienda);
        setChanged();
        notifyObservers("Actualizando Viaje");
    }

    @Override
    public String toString() {
        return "Viaje{" + "encomiendas=" + encomiendas + ", ruta=" + ruta + ", fecha=" + fecha + ", horario=" + horario + ", kilometros=" + kilometros + ", costo=" + costo + ", unidad=" + unidad + '}';
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
        setChanged();
        notifyObservers("Actualizando Viaje");
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
        setChanged();
        notifyObservers("Actualizando Viaje");
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
        setChanged();
        notifyObservers("Actualizando Viaje");
    }

    public int getKilometros() {
        return kilometros;
    }

    public void setKilometros(int kilometros) {
        this.kilometros = kilometros;
        setChanged();
        notifyObservers("Actualizando Viaje");
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
        setChanged();
        notifyObservers("Actualizando Viaje");
    }

    public Bus getUnidad() {
        return unidad;
    }

    public void setUnidad(Bus unidad) {
        if (!unidad.equals(null)) {
            this.unidad = unidad;
            setChanged();
            notifyObservers("Actualizando Viaje");
        }
    }

    public int getCantEncomiendas() {
        return encomiendas.size();
    }
}
