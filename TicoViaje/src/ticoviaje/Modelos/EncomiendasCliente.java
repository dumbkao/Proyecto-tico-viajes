
package ticoviaje.Modelos;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import ticoviaje.Objetos.Cliente;
import ticoviaje.Objetos.Encomienda;
import ticoviaje.Vista.VistaClientes;

public class EncomiendasCliente extends Observable {
    private static Cliente cliente;
    
    public EncomiendasCliente(Cliente c) {
        cliente = c;
    }
    
    public void generarTabla(JTable tabla) {
        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
        for (Encomienda encomienda : cliente.getEncomiendas().getEncomiendas()) {
            model.addRow(new Object[]{encomienda.getPeso(), encomienda.getCodigo(), encomienda.getPrecioPorPeso(), encomienda.getPersonaEntrega(), encomienda.getPersonaRetira(), encomienda.getHoraFecha(), encomienda.isEstadoViaje()});
        }
    }
    
    public void regresar() {
        VistaClientes vista = new VistaClientes();
        vista.iniciar();
    }
    
    public void cambiar_estado(JTable tabla) {
        ArrayList<String> opciones = new ArrayList();
        opciones.add("En Espera de Salida");
        opciones.add("En Viaje");
        opciones.add("Pendiente de Retiro");
        opciones.add("Retirado");
        int fila = tabla.getSelectedRow();
        if (fila != -1) {
            for (int i = 0; i < 4; i++) {
                if (opciones.get(i).equals(cliente.getEncomiendas().getEncomiendas().get(fila).isEstadoViaje())) {//es un get
                    opciones.remove(i);
                    break;
                }
            }
            String opc = (String) JOptionPane.showInputDialog(null, "Eliga el nuevo estado de la encomienda", "ESTADOS", JOptionPane.QUESTION_MESSAGE, null, opciones.toArray(), opciones.get(0));
            cliente.getEncomiendas().getEncomiendas().get(fila).setEstadoViaje(opc);
            DefaultTableModel model = (DefaultTableModel) tabla.getModel();
            model.setValueAt(opc, fila, 6);
        }
    }
    
    public void agregar_encomienda(JTable tabla) {
        Encomienda encomienda = new Encomienda();
        String peso = JOptionPane.showInputDialog(null, "Digite el peso de la encomienda");
        if (peso != null && !peso.equals("")) {
            double aux = Math.floor(Math.random() * (1000 - 0 + 1) + 0);
            String personaEntrega = cliente.getNombre();
            if (personaEntrega != null && !personaEntrega.equals("")) {
                String personaRetira = JOptionPane.showInputDialog(null, "Digite la persona que va a retirar");
                if (personaRetira != null && !personaRetira.equals("")) {
                    String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
                    String estadoViaje = "En Espera de Salida";
                    encomienda.setCodigo((int) aux);
                    encomienda.setEstadoViaje(estadoViaje);
                    encomienda.setPeso(Integer.parseInt(peso));
                    encomienda.setPrecioPorPeso(1000 * Integer.parseInt(peso));
                    encomienda.setPersonaEntrega(personaEntrega);
                    encomienda.setPersonaRetira(personaRetira);
                    encomienda.setHoraFecha(timeStamp);
                    cliente.getEncomiendas().add(encomienda);
                    DefaultTableModel model = (DefaultTableModel) tabla.getModel();
                    model.addRow(new Object[]{peso, (int) aux, 1000 * Integer.parseInt(peso), personaEntrega, personaRetira, timeStamp, estadoViaje});
                }
            }
        }
    }
    
    public void agregarObservador(Observer observer) {
        addObserver(observer);
        setChanged();
        notifyObservers();
    }
}
