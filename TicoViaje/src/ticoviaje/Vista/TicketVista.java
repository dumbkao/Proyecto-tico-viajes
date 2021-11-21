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
        nombre_cliente = new javax.swing.JLabel();
        precio = new javax.swing.JLabel();
        ruta = new javax.swing.JLabel();
        fecha = new javax.swing.JLabel();
        Horario = new javax.swing.JLabel();
        numero_bus = new javax.swing.JLabel();
        chofer = new javax.swing.JLabel();
        kilometros = new javax.swing.JLabel();
        numero_asiento = new javax.swing.JLabel();
        nota = new javax.swing.JLabel();
        precio1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Vista Ticket");
        setResizable(false);

        pnlPrincipal.setBackground(new java.awt.Color(0, 0, 0));
        pnlPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nombre_cliente.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        nombre_cliente.setForeground(new java.awt.Color(255, 255, 255));
        nombre_cliente.setText("Cliente: " + controlador.getNombreCliente());
        nombre_cliente.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        pnlPrincipal.add(nombre_cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, 230, 20));

        precio.setFont(new java.awt.Font("Dialog", 0, 70)); // NOI18N
        precio.setForeground(new java.awt.Color(255, 255, 255));
        precio.setText("₡" + controlador.getViajeUsuario().getCosto());
        pnlPrincipal.add(precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 100, 260, 100));

        ruta.setForeground(new java.awt.Color(255, 255, 255));
        ruta.setText("Ruta: " + controlador.getViajeUsuario().getRuta());
        pnlPrincipal.add(ruta, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 30, 230, 40));

        fecha.setForeground(new java.awt.Color(255, 255, 255));
        fecha.setText("Fecha: " + controlador.getViajeUsuario().getFecha());
        pnlPrincipal.add(fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 70, 250, -1));

        Horario.setForeground(new java.awt.Color(255, 255, 255));
        Horario.setText("Horario: " + controlador.getViajeUsuario().getHorario());
        pnlPrincipal.add(Horario, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 100, 230, -1));

        numero_bus.setForeground(new java.awt.Color(255, 255, 255));
        numero_bus.setText("Placa del Bus: " + controlador.getViajeUsuario().getUnidad().getPlaca());
        pnlPrincipal.add(numero_bus, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 130, 320, -1));

        chofer.setForeground(new java.awt.Color(255, 255, 255));
        chofer.setText("Chofer: " + controlador.getViajeUsuario().getUnidad().getChofer().getNombre());
        pnlPrincipal.add(chofer, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 160, 260, -1));

        kilometros.setForeground(new java.awt.Color(255, 255, 255));
        kilometros.setText("Kilometros: " + controlador.getViajeUsuario().getKilometros());
        pnlPrincipal.add(kilometros, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 190, 260, -1));

        numero_asiento.setForeground(new java.awt.Color(255, 255, 255));
        numero_asiento.setText("Asientos: " + controlador.getAsientoUsuario());
        pnlPrincipal.add(numero_asiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 220, 260, -1));

        nota.setForeground(new java.awt.Color(255, 255, 255));
        nota.setText("NOTA: Realice una captura de pantalla");
        pnlPrincipal.add(nota, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 290, -1, -1));

        precio1.setFont(new java.awt.Font("Dialog", 0, 38)); // NOI18N
        precio1.setForeground(new java.awt.Color(255, 255, 255));
        precio1.setText("PRECIO:");
        precio1.setToolTipText("");
        pnlPrincipal.add(precio1, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 30, 160, 90));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ticoviaje/Imagen/ticket2.png"))); // NOI18N
        pnlPrincipal.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, -1));

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

    private TicketControlador controlador;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Horario;
    private javax.swing.JLabel chofer;
    private javax.swing.JLabel fecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel kilometros;
    private javax.swing.JLabel nombre_cliente;
    private javax.swing.JLabel nota;
    private javax.swing.JLabel numero_asiento;
    private javax.swing.JLabel numero_bus;
    private javax.swing.JPanel pnlPrincipal;
    private javax.swing.JLabel precio;
    private javax.swing.JLabel precio1;
    private javax.swing.JLabel ruta;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Observable o, Object o1) {
        //thrlabelHorarioedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
