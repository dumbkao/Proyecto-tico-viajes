/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticoviaje.Objetos;

import java.util.ArrayList;

/**
 *
 * @author hilla
 */
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
