package ticoviaje.Modelos;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import ticoviaje.Objetos.Asiento;
import ticoviaje.Objetos.Chofer;
import xml.UtilidadesXML;

public class Bus extends Observable {

    private String estado, placa;
    private int numeroUnico;
    private int capacidad;
    private ArrayList<Asiento> asientos;
    private Chofer chofer;
    public static final String DESCRIPCION_XML = "bus";

    public Bus() {
        this.estado = "Disponible";
        this.placa = placaAleatoria();
        this.numeroUnico = 0;
        this.capacidad = 11;
        this.chofer = new Chofer();
        this.asientos = new ArrayList();
        for (int i = 0; i < 11; i++) {
            Asiento asiento = new Asiento();
            asientos.add(asiento);
        }
    }

    public Node toXML(Document doc) {
        Node r = doc.createElement(getNodeName());
        r.appendChild(UtilidadesXML.crearNodo(doc, "Estado_bus", estado));
        r.appendChild(UtilidadesXML.crearNodo(doc, "Placa_bus", placa));
        r.appendChild(UtilidadesXML.crearNodo(doc, "Numero_unico_bus", numeroUnico + ""));
        r.appendChild(UtilidadesXML.crearNodo(doc, "Capacidad_bus", capacidad + ""));
        r.appendChild(UtilidadesXML.crearNodo(doc, "Chofer", chofer.getNombre()));
        r.appendChild(UtilidadesXML.crearNodo(doc, "Licencia_chofer", chofer.getLicencia()));
        r.appendChild(UtilidadesXML.crearNodo(doc, "Edad_chofer ", chofer.getEdad() + ""));
        Node rr = doc.createElement("Asientos");
        for (int i = 0; i < 11; i++) {
            rr.appendChild(UtilidadesXML.crearNodo(doc, "Asiento " + (i + 1), asientos.get(i).getPropetario()));
            rr.appendChild(UtilidadesXML.crearNodo(doc, "Asiento " + (i + 1), asientos.get(i).getIdAsiento() + ""));
            rr.appendChild(UtilidadesXML.crearNodo(doc, "Asiento " + (i + 1), asientos.get(i).isDisponible() + ""));
        }
        r.appendChild(rr);
        return r;
    }

    public String getNodeName() {
        return DESCRIPCION_XML;
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
