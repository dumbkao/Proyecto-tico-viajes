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
        controlador = new MantenimientoControlador(viajes, choferes, flotilla);
        initComponents();
    }

    public void iniciar() {
        controlador.agregarObservador(this);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Regresar = new javax.swing.JButton();
        RemoverChofer = new javax.swing.JButton();
        AgregarChofer = new javax.swing.JButton();
        RemoverViaje = new javax.swing.JButton();
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
        jPanel1.add(Regresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 420, 150, -1));

        RemoverChofer.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        RemoverChofer.setText("Remover Chofer");
        RemoverChofer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoverChoferActionPerformed(evt);
            }
        });
        jPanel1.add(RemoverChofer, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 330, 230, -1));

        AgregarChofer.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        AgregarChofer.setText("Agregar Chofer");
        AgregarChofer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarChoferActionPerformed(evt);
            }
        });
        jPanel1.add(AgregarChofer, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 330, 230, -1));

        RemoverViaje.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        RemoverViaje.setText("Remover Viaje");
        RemoverViaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoverViajeActionPerformed(evt);
            }
        });
        jPanel1.add(RemoverViaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 240, 210, -1));

        AgregarViaje.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        AgregarViaje.setText("Agregar Viaje");
        AgregarViaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarViajeActionPerformed(evt);
            }
        });
        jPanel1.add(AgregarViaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 240, 210, -1));

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

    private void RemoverViajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoverViajeActionPerformed
        controlador.remover_viaje();
    }//GEN-LAST:event_RemoverViajeActionPerformed

    private void RemoverChoferActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoverChoferActionPerformed
        controlador.remover_chofer();
    }//GEN-LAST:event_RemoverChoferActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AgregarChofer;
    private javax.swing.JButton AgregarViaje;
    private javax.swing.JLabel Fondo;
    private javax.swing.JButton Regresar;
    private javax.swing.JButton RemoverChofer;
    private javax.swing.JButton RemoverViaje;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Observable o, Object arg) {
        if (arg != null) {
            JOptionPane.showMessageDialog(null, arg);
        }
    }
}
