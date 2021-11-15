package ticoviaje.Vista;

import java.util.Observable;
import java.util.Observer;
import ticoviaje.Controlador.TicketControlador;
import ticoviaje.Modelos.Viaje;

public class TicketVista extends javax.swing.JFrame implements Observer {

    public TicketVista() {
        this.controlador = new TicketControlador();
    }

    public void iniciar(Viaje viaje, String propietario, String asientos) {
        controlador.setViajeUsuario(viaje);
        controlador.setNombreCliente(propietario);
        controlador.setAsientoUsuario(asientos);
        controlador.agregarObservador(this);
        initComponents();
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlPrincipal = new javax.swing.JPanel();
        labelPrecio = new javax.swing.JLabel();
        precio = new javax.swing.JLabel();
        LabelRuta = new javax.swing.JLabel();
        ruta = new javax.swing.JLabel();
        labelFecha = new javax.swing.JLabel();
        fecha = new javax.swing.JLabel();
        labelHorario = new javax.swing.JLabel();
        Horario = new javax.swing.JLabel();
        labelBus = new javax.swing.JLabel();
        numero_bus = new javax.swing.JLabel();
        labelChofer = new javax.swing.JLabel();
        chofer = new javax.swing.JLabel();
        labelKM1 = new javax.swing.JLabel();
        kilometros = new javax.swing.JLabel();
        labelAsiento1 = new javax.swing.JLabel();
        numero_asiento = new javax.swing.JLabel();
        labelCliente = new javax.swing.JLabel();
        nombre_cliente = new javax.swing.JLabel();
        nota = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Vista Ticket");
        setResizable(false);

        pnlPrincipal.setBackground(new java.awt.Color(0, 0, 0));
        pnlPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelPrecio.setForeground(new java.awt.Color(255, 255, 255));
        labelPrecio.setText("Precio:");
        pnlPrincipal.add(labelPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 50, 30));

        precio.setForeground(new java.awt.Color(255, 255, 255));
        precio.setText(controlador.getViajeUsuario().getCosto() + "");
        pnlPrincipal.add(precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, 110, 30));

        LabelRuta.setForeground(new java.awt.Color(255, 255, 255));
        LabelRuta.setText("Ruta:");
        pnlPrincipal.add(LabelRuta, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        ruta.setForeground(new java.awt.Color(255, 255, 255));
        ruta.setText(controlador.getViajeUsuario().getRuta());
        pnlPrincipal.add(ruta, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, 90, 40));

        labelFecha.setForeground(new java.awt.Color(255, 255, 255));
        labelFecha.setText("Fecha:");
        pnlPrincipal.add(labelFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        fecha.setForeground(new java.awt.Color(255, 255, 255));
        fecha.setText(controlador.getViajeUsuario().getFecha() + "");
        pnlPrincipal.add(fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 120, -1, -1));

        labelHorario.setForeground(new java.awt.Color(255, 255, 255));
        labelHorario.setText("Horario:");
        pnlPrincipal.add(labelHorario, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));

        Horario.setForeground(new java.awt.Color(255, 255, 255));
        Horario.setText(controlador.getViajeUsuario().getHorario());
        pnlPrincipal.add(Horario, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 180, -1, -1));

        labelBus.setForeground(new java.awt.Color(255, 255, 255));
        labelBus.setText("Bus :");
        pnlPrincipal.add(labelBus, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, -1, -1));

        numero_bus.setForeground(new java.awt.Color(255, 255, 255));
        numero_bus.setText(controlador.getViajeUsuario().getUnidad().getNumeroUnico() + "");
        pnlPrincipal.add(numero_bus, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 210, -1, -1));

        labelChofer.setForeground(new java.awt.Color(255, 255, 255));
        labelChofer.setText("Chofer");
        pnlPrincipal.add(labelChofer, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, -1, -1));

        chofer.setForeground(new java.awt.Color(255, 255, 255));
        chofer.setText(controlador.getViajeUsuario().getUnidad().getChofer().getNombre());
        pnlPrincipal.add(chofer, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 240, -1, -1));

        labelKM1.setForeground(new java.awt.Color(255, 255, 255));
        labelKM1.setText("Kilometros:");
        pnlPrincipal.add(labelKM1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, -1, -1));

        kilometros.setForeground(new java.awt.Color(255, 255, 255));
        kilometros.setText(controlador.getViajeUsuario().getKilometros() + "");
        pnlPrincipal.add(kilometros, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 270, -1, -1));

        labelAsiento1.setForeground(new java.awt.Color(255, 255, 255));
        labelAsiento1.setText("Asiento:");
        pnlPrincipal.add(labelAsiento1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, 60, -1));

        numero_asiento.setForeground(new java.awt.Color(255, 255, 255));
        numero_asiento.setText(controlador.getAsientoUsuario());
        pnlPrincipal.add(numero_asiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 10, 90, -1));

        labelCliente.setForeground(new java.awt.Color(255, 255, 255));
        labelCliente.setText("Cliente:");
        pnlPrincipal.add(labelCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 40, 60, -1));

        nombre_cliente.setForeground(new java.awt.Color(255, 255, 255));
        nombre_cliente.setText(controlador.getNombreCliente());
        pnlPrincipal.add(nombre_cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 40, -1, -1));

        nota.setForeground(new java.awt.Color(255, 255, 255));
        nota.setText("NOTA: Realice una captura de pantalla");
        pnlPrincipal.add(nota, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 260, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlPrincipal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 586, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlPrincipal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private TicketControlador controlador;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Horario;
    private javax.swing.JLabel LabelRuta;
    private javax.swing.JLabel chofer;
    private javax.swing.JLabel fecha;
    private javax.swing.JLabel kilometros;
    private javax.swing.JLabel labelAsiento1;
    private javax.swing.JLabel labelBus;
    private javax.swing.JLabel labelChofer;
    private javax.swing.JLabel labelCliente;
    private javax.swing.JLabel labelFecha;
    private javax.swing.JLabel labelHorario;
    private javax.swing.JLabel labelKM1;
    private javax.swing.JLabel labelPrecio;
    private javax.swing.JLabel nombre_cliente;
    private javax.swing.JLabel nota;
    private javax.swing.JLabel numero_asiento;
    private javax.swing.JLabel numero_bus;
    private javax.swing.JPanel pnlPrincipal;
    private javax.swing.JLabel precio;
    private javax.swing.JLabel ruta;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Observable o, Object o1) {
        //thrlabelHorarioedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
