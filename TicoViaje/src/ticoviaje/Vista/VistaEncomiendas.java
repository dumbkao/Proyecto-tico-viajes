package ticoviaje.Vista;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import ticoviaje.Modelos.ConjuntoViajes;

public class VistaEncomiendas extends javax.swing.JFrame {

    private ConjuntoViajes conjuntoViaje;

    public VistaEncomiendas() {
        conjuntoViaje = new ConjuntoViajes();
        initComponents();
    }

    public void iniciar() {
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnVerClientes = new javax.swing.JButton();
        btnEncomiendaViaje = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        btnEncomiendaEspecifica1 = new javax.swing.JButton();
        labelFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnVerClientes.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btnVerClientes.setText("Ver Clientes");
        btnVerClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerClientesActionPerformed(evt);
            }
        });
        jPanel1.add(btnVerClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 220, -1, -1));

        btnEncomiendaViaje.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btnEncomiendaViaje.setText("Ver Encomiendas por Viaje");
        btnEncomiendaViaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEncomiendaViajeActionPerformed(evt);
            }
        });
        jPanel1.add(btnEncomiendaViaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 310, -1, -1));

        btnRegresar.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btnRegresar.setText("REGRESAR");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 500, -1, -1));

        btnEncomiendaEspecifica1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btnEncomiendaEspecifica1.setText("Ver Encomienda por codigo");
        btnEncomiendaEspecifica1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEncomiendaEspecifica1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnEncomiendaEspecifica1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 400, -1, -1));

        labelFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ticoviaje/Imagen/ticoviajesfondo.png"))); // NOI18N
        jPanel1.add(labelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

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

    private void btnVerClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerClientesActionPerformed
        VistaClientes vista = new VistaClientes();
        vista.iniciar();
        setVisible(false);
    }//GEN-LAST:event_btnVerClientesActionPerformed

    private void btnEncomiendaViajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEncomiendaViajeActionPerformed
        ArrayList<String> listaRuta = conjuntoViaje.getRutas();
        String ruta = (String) JOptionPane.showInputDialog(null, "Elija la ruta que desea", "RUTAS", JOptionPane.QUESTION_MESSAGE, null, listaRuta.toArray(), listaRuta.get(0));

        if (ruta != null) {
            ArrayList<String> listaFecha = conjuntoViaje.getDiasRuta(ruta);
            
            String fecha = (String) JOptionPane.showInputDialog(null, "Elija la fecha que desea", "FECHAS", JOptionPane.QUESTION_MESSAGE, null, listaFecha.toArray(), listaFecha.get(0));
            if (fecha != null) {
                ArrayList<String> listaHorarios = conjuntoViaje.getHorarioDiaRuta(ruta, fecha);
                
                String horario = (String) JOptionPane.showInputDialog(null, "Elija el Horario que desea", "HORARIOS", JOptionPane.QUESTION_MESSAGE, null, listaHorarios.toArray(), listaHorarios.get(0));
                if (horario != null) {
                    
                }
            }
        }
    }//GEN-LAST:event_btnEncomiendaViajeActionPerformed

    public void leerBD(ConjuntoViajes c) {
        conjuntoViaje = c;
    }


    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        TicoViajesVista vista = new TicoViajesVista();
        vista.iniciar();
        setVisible(false);
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnEncomiendaEspecifica1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEncomiendaEspecifica1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEncomiendaEspecifica1ActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VistaEncomiendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaEncomiendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaEncomiendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaEncomiendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaEncomiendas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEncomiendaEspecifica1;
    private javax.swing.JButton btnEncomiendaViaje;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnVerClientes;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelFondo;
    // End of variables declaration//GEN-END:variables
}
