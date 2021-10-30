/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticoviaje.Vista;

import ticoviaje.Controlador.BusControlador;

/**
 *
 * @author hilla
 */
public class BusVista extends javax.swing.JFrame {

    /**
     * Creates new form BusDesign
     */
    public BusVista() {
        initComponents();
    }

    public void iniciar() {
        setVisible(true);
        controlador = new BusControlador();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Asiento3 = new javax.swing.JButton();
        Asiento5 = new javax.swing.JButton();
        Asiento7 = new javax.swing.JButton();
        Asiento11 = new javax.swing.JButton();
        Asiento6 = new javax.swing.JButton();
        Asiento10 = new javax.swing.JButton();
        Asiento8 = new javax.swing.JButton();
        Asiento4 = new javax.swing.JButton();
        Asiento2 = new javax.swing.JButton();
        Asiento1 = new javax.swing.JButton();
        Asiento9 = new javax.swing.JButton();
        LabelFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setEnabled(false);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Asiento3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ticoviaje/Imagen/asientoDisponible.png"))); // NOI18N
        Asiento3.setBorder(null);
        Asiento3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Asiento3MouseClicked(evt);
            }
        });
        jPanel1.add(Asiento3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 210, -1, -1));

        Asiento5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ticoviaje/Imagen/asientoDisponible.png"))); // NOI18N
        Asiento5.setBorder(null);
        Asiento5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Asiento5MouseClicked(evt);
            }
        });
        jPanel1.add(Asiento5, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 250, -1, -1));

        Asiento7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ticoviaje/Imagen/asientoDisponible.png"))); // NOI18N
        Asiento7.setBorder(null);
        Asiento7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Asiento7MouseClicked(evt);
            }
        });
        jPanel1.add(Asiento7, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 290, -1, -1));

        Asiento11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ticoviaje/Imagen/asientoDisponible.png"))); // NOI18N
        Asiento11.setBorder(null);
        Asiento11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Asiento11MouseClicked(evt);
            }
        });
        jPanel1.add(Asiento11, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 370, -1, -1));

        Asiento6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ticoviaje/Imagen/asientoDisponible.png"))); // NOI18N
        Asiento6.setBorder(null);
        Asiento6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Asiento6MouseClicked(evt);
            }
        });
        jPanel1.add(Asiento6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 290, -1, -1));

        Asiento10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ticoviaje/Imagen/asientoDisponible.png"))); // NOI18N
        Asiento10.setBorder(null);
        Asiento10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Asiento10MouseClicked(evt);
            }
        });
        jPanel1.add(Asiento10, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 370, -1, -1));

        Asiento8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ticoviaje/Imagen/asientoDisponible.png"))); // NOI18N
        Asiento8.setBorder(null);
        Asiento8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Asiento8MouseClicked(evt);
            }
        });
        jPanel1.add(Asiento8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 330, -1, -1));

        Asiento4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ticoviaje/Imagen/asientoDisponible.png"))); // NOI18N
        Asiento4.setBorder(null);
        Asiento4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Asiento4MouseClicked(evt);
            }
        });
        jPanel1.add(Asiento4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 250, -1, -1));

        Asiento2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ticoviaje/Imagen/asientoDisponible.png"))); // NOI18N
        Asiento2.setBorder(null);
        Asiento2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Asiento2MouseClicked(evt);
            }
        });
        jPanel1.add(Asiento2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, -1, -1));

        Asiento1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ticoviaje/Imagen/asientoDisponible.png"))); // NOI18N
        Asiento1.setBorder(null);
        Asiento1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Asiento1MouseClicked(evt);
            }
        });
        jPanel1.add(Asiento1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, -1, -1));

        Asiento9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ticoviaje/Imagen/asientoDisponible.png"))); // NOI18N
        Asiento9.setBorder(null);
        Asiento9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Asiento9MouseClicked(evt);
            }
        });
        jPanel1.add(Asiento9, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 330, -1, -1));

        LabelFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ticoviaje/Imagen/bus.png"))); // NOI18N
        jPanel1.add(LabelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -4, -1, 440));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Asiento1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Asiento1MouseClicked

    }//GEN-LAST:event_Asiento1MouseClicked

    private void Asiento2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Asiento2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Asiento2MouseClicked

    private void Asiento4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Asiento4MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Asiento4MouseClicked

    private void Asiento6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Asiento6MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Asiento6MouseClicked

    private void Asiento8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Asiento8MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Asiento8MouseClicked

    private void Asiento10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Asiento10MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Asiento10MouseClicked

    private void Asiento3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Asiento3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Asiento3MouseClicked

    private void Asiento5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Asiento5MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Asiento5MouseClicked

    private void Asiento7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Asiento7MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Asiento7MouseClicked

    private void Asiento9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Asiento9MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Asiento9MouseClicked

    private void Asiento11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Asiento11MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Asiento11MouseClicked

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(BusVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BusVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BusVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BusVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BusVista().setVisible(true);
            }
        });

    }

    private BusControlador controlador;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Asiento1;
    private javax.swing.JButton Asiento10;
    private javax.swing.JButton Asiento11;
    private javax.swing.JButton Asiento2;
    private javax.swing.JButton Asiento3;
    private javax.swing.JButton Asiento4;
    private javax.swing.JButton Asiento5;
    private javax.swing.JButton Asiento6;
    private javax.swing.JButton Asiento7;
    private javax.swing.JButton Asiento8;
    private javax.swing.JButton Asiento9;
    private javax.swing.JLabel LabelFondo;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
