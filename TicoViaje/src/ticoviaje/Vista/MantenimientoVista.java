package ticoviaje.Vista;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JOptionPane;
import ticoviaje.Controlador.MantenimientoControlador;
import ticoviaje.Modelos.ConjuntoViajes;
import ticoviaje.Modelos.Flotilla;
import ticoviaje.Objetos.Chofer;

public class MantenimientoVista extends javax.swing.JFrame implements Observer {

    private MantenimientoControlador controlador;

    public MantenimientoVista(ConjuntoViajes viajes, ArrayList<Chofer> choferes, Flotilla flotilla) {
        super("MantenimientoVista");
        controlador = new MantenimientoControlador(viajes, choferes, flotilla);
        initComponents();
    }

    public void iniciar() {
        controlador.agregarObservador(this);
        //setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Regresar = new javax.swing.JButton();
        AgregarChofer = new javax.swing.JButton();
        AgregarViaje = new javax.swing.JButton();
        Fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Regresar.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        Regresar.setText("Regresar");
        Regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegresarActionPerformed(evt);
            }
        });
        jPanel1.add(Regresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 380, 150, -1));

        AgregarChofer.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        AgregarChofer.setText("Agregar Chofer");
        AgregarChofer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarChoferActionPerformed(evt);
            }
        });
        jPanel1.add(AgregarChofer, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 270, 230, -1));

        AgregarViaje.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        AgregarViaje.setText("Agregar Viaje");
        AgregarViaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarViajeActionPerformed(evt);
            }
        });
        jPanel1.add(AgregarViaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 270, 210, -1));

        Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ticoviaje/Imagen/ticoviajesfondo.png"))); // NOI18N
        jPanel1.add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AgregarViajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarViajeActionPerformed
        controlador.agregar_viaje();
    }//GEN-LAST:event_AgregarViajeActionPerformed

    private void AgregarChoferActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarChoferActionPerformed
        controlador.agregar_chofer();
    }//GEN-LAST:event_AgregarChoferActionPerformed

    private void RegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegresarActionPerformed
        controlador.regresar();
        setVisible(false);
    }//GEN-LAST:event_RegresarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AgregarChofer;
    private javax.swing.JButton AgregarViaje;
    private javax.swing.JLabel Fondo;
    private javax.swing.JButton Regresar;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Observable o, Object arg) {
        if (arg != null) {
            JOptionPane.showMessageDialog(null, arg);
        }
    }
}
