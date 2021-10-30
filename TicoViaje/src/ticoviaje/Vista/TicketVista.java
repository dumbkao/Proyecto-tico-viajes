package ticoviaje.Vista;

import java.util.Observable;
import java.util.Observer;
import ticoviaje.Controlador.TicketControlador;

public class TicketVista extends javax.swing.JFrame implements Observer {

    public TicketVista() {
        this.controlador = new TicketControlador();
        initComponents();
        iniciar();
    }

    public void iniciar() {
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        controlador.agregarObservador(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlPrincipal = new javax.swing.JPanel();
        labelPrecio = new javax.swing.JLabel();
        precio = new javax.swing.JLabel();
        labelPSalida = new javax.swing.JLabel();
        puntoSalida = new javax.swing.JLabel();
        labelPDestino = new javax.swing.JLabel();
        puntoDestino = new javax.swing.JLabel();
        labelFecha = new javax.swing.JLabel();
        fecha = new javax.swing.JLabel();
        labelHoraSalida = new javax.swing.JLabel();
        horaSalida = new javax.swing.JLabel();
        labelHoraDestino = new javax.swing.JLabel();
        HoraDestino = new javax.swing.JLabel();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Vista Ticket");
        setResizable(false);

        pnlPrincipal.setBackground(new java.awt.Color(114, 113, 93));
        pnlPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelPrecio.setText("Precio:");
        pnlPrincipal.add(labelPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 50, 30));

        precio.setText(controlador.getViajeUsuario().getCosto() + "");
        pnlPrincipal.add(precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, 80, 30));

        labelPSalida.setText("Punto Salida:");
        pnlPrincipal.add(labelPSalida, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        puntoSalida.setText(controlador.getViajeUsuario().getPuntoSalida());
        pnlPrincipal.add(puntoSalida, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, 80, 40));

        labelPDestino.setText("Punto Destino:");
        pnlPrincipal.add(labelPDestino, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        puntoDestino.setText(controlador.getViajeUsuario().getPuntoDestino());
        pnlPrincipal.add(puntoDestino, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, 80, 40));

        labelFecha.setText("Fecha:");
        pnlPrincipal.add(labelFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        fecha.setText(controlador.getViajeUsuario().getFecha() + "");
        pnlPrincipal.add(fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 120, -1, -1));

        labelHoraSalida.setText("Hora salida:");
        pnlPrincipal.add(labelHoraSalida, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, -1));

        horaSalida.setText(controlador.getViajeUsuario().getHoraSalida());
        pnlPrincipal.add(horaSalida, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 150, -1, -1));

        labelHoraDestino.setText("Hora destino:");
        pnlPrincipal.add(labelHoraDestino, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));

        HoraDestino.setText(controlador.getViajeUsuario().getHoraDestino());
        pnlPrincipal.add(HoraDestino, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 180, -1, -1));

        labelBus.setText("Bus :");
        pnlPrincipal.add(labelBus, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, -1, -1));

        numero_bus.setText(controlador.getViajeUsuario().getUnidad().getNumeroUnico() + "");
        pnlPrincipal.add(numero_bus, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 210, -1, -1));

        labelChofer.setText("Chofer");
        pnlPrincipal.add(labelChofer, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, -1, -1));

        chofer.setText(controlador.getViajeUsuario().getUnidad().getChofer().getNombre());
        pnlPrincipal.add(chofer, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 240, -1, -1));

        labelKM1.setText("Kilometros:");
        pnlPrincipal.add(labelKM1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, -1, -1));

        kilometros.setText(controlador.getViajeUsuario().getKilometros() + "");
        pnlPrincipal.add(kilometros, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 270, -1, -1));

        labelAsiento1.setText("Asiento:");
        pnlPrincipal.add(labelAsiento1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, 50, -1));

        numero_asiento.setText(controlador.getAsientoUsuario().getIdAsiento() + "");
        pnlPrincipal.add(numero_asiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 10, 90, -1));

        labelCliente.setText("Cliente:");
        pnlPrincipal.add(labelCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 40, -1, -1));

        nombre_cliente.setText(controlador.getNombreCliente());
        pnlPrincipal.add(nombre_cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 40, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlPrincipal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlPrincipal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TicketVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TicketVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TicketVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TicketVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TicketVista().setVisible(true);
            }
        });
    }

    private TicketControlador controlador;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel HoraDestino;
    private javax.swing.JLabel chofer;
    private javax.swing.JLabel fecha;
    private javax.swing.JLabel horaSalida;
    private javax.swing.JLabel kilometros;
    private javax.swing.JLabel labelAsiento1;
    private javax.swing.JLabel labelBus;
    private javax.swing.JLabel labelChofer;
    private javax.swing.JLabel labelCliente;
    private javax.swing.JLabel labelFecha;
    private javax.swing.JLabel labelHoraDestino;
    private javax.swing.JLabel labelHoraSalida;
    private javax.swing.JLabel labelKM1;
    private javax.swing.JLabel labelPDestino;
    private javax.swing.JLabel labelPSalida;
    private javax.swing.JLabel labelPrecio;
    private javax.swing.JLabel nombre_cliente;
    private javax.swing.JLabel numero_asiento;
    private javax.swing.JLabel numero_bus;
    private javax.swing.JPanel pnlPrincipal;
    private javax.swing.JLabel precio;
    private javax.swing.JLabel puntoDestino;
    private javax.swing.JLabel puntoSalida;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Observable o, Object o1) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
