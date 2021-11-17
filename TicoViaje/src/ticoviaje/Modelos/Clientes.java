package ticoviaje.Modelos;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import ticoviaje.Objetos.Cliente;
import ticoviaje.Vista.VistaEncomiendas;
import ticoviaje.Vista.VistaEncomiendasCliente;

import ticoviaje.Bases_Datos.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Clientes extends Observable {

    private static final String COMANDO_INSERTAR = "INSERT INTO clientes " + "(nombre) " + "VALUES(?);";

    private Conexion cn;

    private ArrayList<Cliente> clientes;

    public Clientes() {
        this.cn = new Conexion();
        clientes = new ArrayList();
    }

    public void agregarClientes(JTable tabla) {
        Statement st;
        String nombre = JOptionPane.showInputDialog(null, "Digite su nombre");
        if (nombre != null && !nombre.equals("")) {
            try {
                st = cn.getConexion().createStatement();
                PreparedStatement stm = cn.getConexion().prepareStatement(COMANDO_INSERTAR);

                stm.setString(1, nombre);
                Cliente nuevo = new Cliente();
                nuevo.setNombre(nombre);
                
                clientes.add(nuevo);

                DefaultTableModel model = (DefaultTableModel) tabla.getModel();
                model.addRow(new Object[]{nuevo.getNombre()});

                if (stm.executeUpdate() != 1) {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public void cargarBD(JTable tabla) {
        Statement st;
        ResultSet rs;

        try {
            st = cn.getConexion().createStatement();
            rs = st.executeQuery("SELECT * FROM clientes");

            while (rs.next()) {
                DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
                modelo.addRow(new Object[]{rs.getString("nombre")});

                Cliente nuevo = new Cliente();
                nuevo.setNombre(rs.getString("nombre"));
                clientes.add(nuevo);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        setChanged();
        notifyObservers();
    }

    public boolean verClientes(JTable tabla) {
        int fila = tabla.getSelectedRow();
        if (fila != -1) {
            VistaEncomiendasCliente vista = new VistaEncomiendasCliente(clientes.get(fila), new ConjuntoViajes(), (fila + 1));
            vista.iniciar();
            return true;
        }
        return false;
    }

    public void regresar() {
        VistaEncomiendas vista = new VistaEncomiendas();
        vista.iniciar();
        cn.cerrar();
    }

    public void agregarObservador(Observer observer) {
        addObserver(observer);
        setChanged();
        notifyObservers();
    }
}
