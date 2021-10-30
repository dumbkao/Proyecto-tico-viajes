/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticoviaje.Modelos;

import java.util.Observable;
import java.util.Observer;
import ticoviaje.Objetos.Chofer;

/**
 *
 * @author hilla
 */
public class Bus extends Observable{

    private String estado, placa;

    private int numeroUnico, capacidad; 

    Chofer chofer; 
    
    public Bus(){
        this.estado="";
        this.placa="";
        this.numeroUnico=0;
        this.capacidad=0;
        this.chofer= new Chofer();
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
    public void agregarObservador(Observer observador){
        addObserver(observador);
        setChanged();
        notifyObservers();
    }
    
}
