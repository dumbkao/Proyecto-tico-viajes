package ticoviaje.Objetos;

public class Asiento {

    private int idAsiento;
    private boolean disponible;
    private String propetario;

    public Asiento() {
        this.idAsiento = 0;
        this.disponible = true;
        this.propetario = "";
    }

    public String getPropetario() {
        return propetario;
    }

    public void setPropetario(String propetario) {
        this.propetario = propetario;
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
