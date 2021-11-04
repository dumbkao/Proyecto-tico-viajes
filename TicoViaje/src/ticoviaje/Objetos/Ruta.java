
package ticoviaje.Objetos;

public class Ruta {
    private String ruta;
    private ConjuntoDias dias;
    
    public Ruta() {
        ruta = "";
        dias = new ConjuntoDias();
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public ConjuntoDias getDias() {
        return dias;
    }

    public void setDias(ConjuntoDias dias) {
        this.dias = dias;
    }
    
    public void addDia(Dia dia) {
        dias.add(dia);
    }
}
