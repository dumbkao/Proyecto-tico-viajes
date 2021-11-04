package ticoviaje.Controlador;

import java.util.Date;
import java.util.Observer;
import ticoviaje.Modelos.Bus;
import ticoviaje.Modelos.Viaje;
import ticoviaje.Objetos.Encomienda;

public class ViajeControlador {

    private final Viaje modelo;

    public ViajeControlador() {
        modelo = new Viaje();
    }

    public void agregarObservador(Observer observer) {
        modelo.addObserver(observer);
    }

    public void agregarEncomienda(Encomienda encomienda) {
        modelo.agregarEncomienda(encomienda);
    }

    public String getRuta() {
        return modelo.getRuta();
    }

    public void setRuta(String puntoSalida) {
        modelo.setRuta(puntoSalida);
    }

    public Date getFecha() {
        return modelo.getFecha();
    }

    public void setFecha() {
        modelo.getFecha();
    }

    public String getHorario() {
        return modelo.getHorario();
    }

    public void setHorario(String horaSalida) {
        modelo.setHorario(horaSalida);
    }

    public int getKilometros() {
        return modelo.getKilometros();
    }

    public void setKilometros(int kilometros) {
        modelo.setKilometros(kilometros);
    }

    public int getCosto() {
        return modelo.getCosto();
    }

    public void setCosto(int costo) {
        modelo.setCosto(costo);
    }

    public Bus getUnidad() {
        return modelo.getUnidad();
    }

    public void setUnidad(Bus unidad) {
        modelo.setUnidad(unidad);
    }

    public int cantEncomiendas() {
        return modelo.getCantEncomiendas();
    }

    @Override
    public String toString() {
        return modelo.toString();
    }
}
