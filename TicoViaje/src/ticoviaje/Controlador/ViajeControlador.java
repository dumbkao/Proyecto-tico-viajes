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

    public String getPuntoSalida() {
        return modelo.getPuntoSalida();
    }

    public void setPuntoSalida(String puntoSalida) {
        modelo.setPuntoSalida(puntoSalida);
    }

    public String getPuntoDestino() {
        return modelo.getPuntoDestino();
    }

    public void setPuntoDestino(String puntoDestino) {
        modelo.setPuntoDestino(puntoDestino);
    }

    public Date getFecha() {
        return modelo.getFecha();
    }

    public void setFecha() {
        modelo.getFecha();
    }

    public String getHoraSalida() {
        return modelo.getHoraSalida();
    }

    public void setHoraSalida(String horaSalida) {
        modelo.setHoraSalida(horaSalida);
    }

    public String getHoraDestino() {
        return modelo.getHoraDestino();
    }

    public void setHoraDestino(String horaDestino) {
        modelo.setHoraDestino(horaDestino);
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
