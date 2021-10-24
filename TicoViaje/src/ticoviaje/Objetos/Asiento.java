/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticoviaje.Objetos;

/**
 *
 * @author hilla
 */
public class Asiento {

    private int idAsiento;
    private boolean disponible;

    public Asiento() {
        this.idAsiento = 0;
        this.disponible = true;
    }

    public int getIdAsiento() {
        return idAsiento;
    }

    public void setIdAsiento(int idAsiento) {
        this.idAsiento = idAsiento;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
}
