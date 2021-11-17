package ticoviaje.Modelos;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;
import javax.swing.JOptionPane;
import ticoviaje.Objetos.Asiento;
import ticoviaje.Objetos.Chofer;
import ticoviaje.Vista.TicketVista;
import ticoviaje.Vista.TicoViajesVista;

public class Bus extends Observable {

    private String estado, placa;
    private int numeroUnico;
    private int capacidad;
    private ArrayList<Asiento> asientos;
    private Chofer chofer;
    private String propietario;
    private Viaje viaje;

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public Bus() {
        this.estado = "Disponible";
        this.placa = placaAleatoria();
        this.numeroUnico = 0;
        this.capacidad = 11;
        this.chofer = new Chofer();
        this.asientos = new ArrayList();
        this.viaje= null;
        this.propietario = "";
        for (int i = 0; i < 11; i++) {
            Asiento asiento = new Asiento();
            asiento.setIdAsiento(i + 1);
            asientos.add(asiento);
        }
    }

    public Viaje getViaje() {
        return viaje;
    }

    public void setViaje(Viaje viaje) {
        this.viaje = viaje;
    }

    public ArrayList<Asiento> getAsientos() {
        return asientos;
    }

    public void setAsientos(ArrayList<Asiento> asientos) {
        this.asientos = asientos;
        setChanged();
        notifyObservers("Actualizando Bus");
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
        setChanged();
        notifyObservers("Actualizando Bus");
    }

    public String getPlaca() {
        return placa;
    }

    public static String placaAleatoria() {

        char[] chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

        int charsLength = chars.length;

        Random random = new Random();

        StringBuilder buffer = new StringBuilder();

        for (int i = 0; i < 6; i++) {
            buffer.append(chars[random.nextInt(charsLength)]);
        }

        return (buffer.toString());
    }

    public void setPlaca(String placa) {
        this.placa = placa;
        setChanged();
        notifyObservers("Actualizando Bus");
    }

    public int getNumeroUnico() {
        return numeroUnico;
    }

    public void setNumeroUnico(int numeroUnico) {
        this.numeroUnico = numeroUnico;
        setChanged();
        notifyObservers("Actualizando Bus");
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
        setChanged();
        notifyObservers("Actualizando Bus");
    }

    public Chofer getChofer() {
        return chofer;
    }

    public void setChofer(Chofer chofer) {
        this.chofer = chofer;
        setChanged();
        notifyObservers("Actualizando Bus");
    }

    public void agregarObservador(Observer observador) {
        addObserver(observador);
        setChanged();
        notifyObservers("Actualizando Bus");
    }

    public void aceptarAsientos() {
        JOptionPane.showMessageDialog(null, "Los asientos han sido seleccionados");
        TicketVista vista = new TicketVista();
        vista.iniciar(viaje, propietario, asientos_propietario());
    }
    public void regresar(){
        TicoViajesVista vista = new TicoViajesVista();
        vista.iniciar();
    }
    
    public String asientos_propietario() {
        String informacion = "";
        for (Asiento asiento : asientos) {
            if (asiento.getPropetario().equals(propietario)) {
                informacion = informacion + asiento.getIdAsiento() + ", ";
            }
        }
        return informacion;
    }
}
