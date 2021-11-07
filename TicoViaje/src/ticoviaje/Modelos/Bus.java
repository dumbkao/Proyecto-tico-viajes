package ticoviaje.Modelos;

import java.util.Observable;
import java.util.Observer;
import java.util.Random;
import ticoviaje.Objetos.Chofer;

public class Bus extends Observable {

    private String estado, placa;

    private int numeroUnico;
    private int capacidad;

    Chofer chofer;

    public Bus() {
        this.estado = "Disponible";
        this.placa = placaAleatoria();
        this.numeroUnico=0;
        this.capacidad = 11;
        this.chofer = new Chofer();
       
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

        char[] chars = "0123456789abcdefghijklmnopqrstuvwxyz".toCharArray();

        int charsLength = chars.length;

        Random random = new Random();

        StringBuilder buffer = new StringBuilder();

        for (int i = 0; i < 10; i++) {
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
}
