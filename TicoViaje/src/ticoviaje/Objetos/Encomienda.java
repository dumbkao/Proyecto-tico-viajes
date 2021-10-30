package ticoviaje.Objetos;

import java.util.Date;

public class Encomienda {

    private int peso;
    private int codigo;
    private int precioPorPeso;
    private String personaEntrega;
    private String personaRetira;
    private Date horaFecha;
    private boolean estadoViaje;

    public Encomienda() {
        this.peso = 0;
        this.codigo = 0;
        this.precioPorPeso = 0;
        this.personaEntrega = "";
        this.personaRetira = "";
        this.horaFecha = null;
        this.estadoViaje = false;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getPrecioPorPeso() {
        return precioPorPeso;
    }

    public void setPrecioPorPeso(int precioPorPeso) {
        this.precioPorPeso = precioPorPeso;
    }

    public String getPersonaEntrega() {
        return personaEntrega;
    }

    public void setPersonaEntrega(String personaEntrega) {
        this.personaEntrega = personaEntrega;
    }

    public String getPersonaRetira() {
        return personaRetira;
    }

    public void setPersonaRetira(String personaRetira) {
        this.personaRetira = personaRetira;
    }

    public Date getHoraFecha() {
        return horaFecha;
    }

    public void setHoraFecha(Date horaFecha) {
        this.horaFecha = horaFecha;
    }

    public boolean isEstadoViaje() {
        return estadoViaje;
    }

    public void setEstadoViaje(boolean estadoViaje) {
        this.estadoViaje = estadoViaje;
    }

    @Override
    public String toString() {
        return "Encomienda{" + "peso=" + peso + ", codigo=" + codigo + ", precioPorPeso=" + precioPorPeso + ", personaEntrega=" + personaEntrega + ", personaRetira=" + personaRetira + ", horaFecha=" + horaFecha + ", estadoViaje=" + estadoViaje + '}';
    }
    
    

}
