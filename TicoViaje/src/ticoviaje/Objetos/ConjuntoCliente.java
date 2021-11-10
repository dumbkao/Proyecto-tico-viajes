package ticoviaje.Objetos;

import java.util.ArrayList;

public class ConjuntoCliente {

    private ArrayList<Cliente> clientes;

    public ConjuntoCliente() {
        this.clientes = new ArrayList();
    }

    public int size() {
        return clientes.size();
    }

    public void add(Cliente cliente) {
        clientes.add(cliente);
    }

    public Cliente getEspecifico(int index) {
        return clientes.get(index);
    }

    public Cliente getPorNombre(String codigo) {
        for (Cliente cliente : clientes) {
            if (cliente.getNombre().equals(codigo)) {
                return cliente;
            }
        }
        return null;
    }
}
