package ticoviaje.Modelos;

import java.util.Date;
import java.util.Observable;
import ticoviaje.Objetos.ConjuntoEncomienda;
import ticoviaje.Objetos.Encomienda;

public class Viaje extends Observable {

    private final ConjuntoEncomienda encomiendas;
    private String puntoSalida;
    private String puntoDestino;
    private Date fecha;
    private String horaSalida;
    private String horaDestino;
    private int kilometros;
    private int costo;
    private Bus unidad;

    public Viaje() {
        this.encomiendas = new ConjuntoEncomienda();
        this.puntoSalida = "";
        this.puntoDestino = "";
        this.fecha = null;
        this.horaSalida = "";
        this.horaDestino = "";
        this.kilometros = 0;
        this.costo = 0;
        this.unidad = new Bus();
    }

    public void agregarEncomienda(Encomienda encomienda) {
        encomiendas.add(encomienda);
        setChanged();
        notifyObservers("Actualizando Viaje");
    }

    public String getPuntoSalida() {
        return puntoSalida;
    }

    public void setPuntoSalida(String puntoSalida) {
        this.puntoSalida = puntoSalida;
        setChanged();
        notifyObservers("Actualizando Viaje");
    }

    public String getPuntoDestino() {
        return puntoDestino;
    }

    public void setPuntoDestino(String puntoDestino) {
        this.puntoDestino = puntoDestino;
        setChanged();
        notifyObservers("Actualizando Viaje");
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
        setChanged();
        notifyObservers("Actualizando Viaje");
    }

    public String getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
        setChanged();
        notifyObservers("Actualizando Viaje");
    }

    public String getHoraDestino() {
        return horaDestino;
    }

    public void setHoraDestino(String horaDestino) {
        this.horaDestino = horaDestino;
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
        this.unidad = unidad;
        setChanged();
        notifyObservers("Actualizando Viaje");
    }

    public int getCantEncomiendas() {
        return encomiendas.size();
    }

    @Override
    public String toString() {
        return "Viaje{" + "encomiendas=" + encomiendas + ", puntoSalida=" + puntoSalida + ", puntoDestino=" + puntoDestino + ", fecha=" + fecha + ", horaSalida=" + horaSalida + ", horaDestino=" + horaDestino + ", kilometros=" + kilometros + ", costo=" + costo + ", unidad=" + unidad + '}';
    }
}
