/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticoviaje.Vista;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import ticoviaje.Objetos.Cliente;
import ticoviaje.Objetos.Encomienda;

/**
 *
 * @author Jefte
 */
public class VistaEncomiendasCliente extends javax.swing.JFrame {
    
    private static Cliente cliente;
    
    public VistaEncomiendasCliente(Cliente c) {
        cliente = c;
        initComponents();
    }
    
    public void iniciar() {
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        
        DefaultTableModel model = (DefaultTableModel) TablaEncomiendas.getModel();
        for (Encomienda encomienda : cliente.getEncomiendas().getEncomiendas()) {
            model.addRow(new Object[]{encomienda.getPeso(), encomienda.getCodigo(), encomienda.getPrecioPorPeso(), encomienda.getPersonaEntrega(), encomienda.getPersonaRetira(), encomienda.getHoraFecha(), encomienda.isEstadoViaje()});
        }
        
        setVisible(true);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaEncomiendas = new javax.swing.JTable();
        btnRegresar = new javax.swing.JButton();
        btnCambiarEstado = new javax.swing.JButton();
        labelFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        TablaEncomiendas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Peso", "Codigo", "Precio", "Entrego", "Retira", "Hora y Fecha", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(TablaEncomiendas);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, 930, 300));

        btnRegresar.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btnRegresar.setText("REGRESAR");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 490, -1, -1));

        btnCambiarEstado.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btnCambiarEstado.setText("CAMBIAR ESTADO");
        btnCambiarEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambiarEstadoActionPerformed(evt);
            }
        });
        jPanel1.add(btnCambiarEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 490, -1, -1));

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

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        VistaClientes vista = new VistaClientes();
        vista.iniciar();
        setVisible(false);
    }//GEN-LAST:event_btnRegresarActionPerformed
    private void btnCambiarEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambiarEstadoActionPerformed
        ArrayList<String> opciones = new ArrayList();
        opciones.add("En Espera de Salida");
        opciones.add("En Viaje");
        opciones.add("Pendiente de Retiro");
        opciones.add("Retirado");
        
        int fila = TablaEncomiendas.getSelectedRow();
        
        if (fila != -1) {
            for (int i = 0; i < 4; i++) {
                if (opciones.get(i).equals(cliente.getEncomiendas().getEncomiendas().get(fila).isEstadoViaje())) {//es un get
                    opciones.remove(i);
                    break;
                }
            }
            String opc = (String) JOptionPane.showInputDialog(null, "Eliga el nuevo estado de la encomienda", "ESTADOS", JOptionPane.QUESTION_MESSAGE, null, opciones.toArray(), opciones.get(0));
            cliente.getEncomiendas().getEncomiendas().get(fila).setEstadoViaje(opc);
            
            DefaultTableModel model = (DefaultTableModel) TablaEncomiendas.getModel();
            
            model.setValueAt(opc, fila, 6);
        }

    }//GEN-LAST:event_btnCambiarEstadoActionPerformed
    
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
            java.util.logging.Logger.getLogger(VistaEncomiendasCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaEncomiendasCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaEncomiendasCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaEncomiendasCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaEncomiendasCliente(cliente).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaEncomiendas;
    private javax.swing.JButton btnCambiarEstado;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelFondo;
    // End of variables declaration//GEN-END:variables
}
