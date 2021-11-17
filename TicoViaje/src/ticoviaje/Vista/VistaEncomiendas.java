package ticoviaje.Vista;

import java.util.Observable;
import java.util.Observer;
import javax.swing.JOptionPane;
import ticoviaje.Controlador.EncomiendasControlador;

public class VistaEncomiendas extends javax.swing.JFrame implements Observer {

    private EncomiendasControlador controlador;

    public VistaEncomiendas() {
        super("VistaEncomiendas");
        controlador = new EncomiendasControlador();
        initComponents();
    }

    public void iniciar() {
        controlador.agregarObservador(this);
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
        btnEncomiendaEspecifica = new javax.swing.JButton();
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
        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 490, -1, -1));

        btnEncomiendaEspecifica.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btnEncomiendaEspecifica.setText("Ver Encomienda por codigo");
        btnEncomiendaEspecifica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEncomiendaEspecificaActionPerformed(evt);
            }
        });
        jPanel1.add(btnEncomiendaEspecifica, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 400, -1, -1));

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
        controlador.ver_clientes();
        setVisible(false);
    }//GEN-LAST:event_btnVerClientesActionPerformed

    private void btnEncomiendaViajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEncomiendaViajeActionPerformed
        if (controlador.encomienda_viaje() == true) {
            setVisible(false);
        }
    }//GEN-LAST:event_btnEncomiendaViajeActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        controlador.regresar();
        setVisible(false);
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnEncomiendaEspecificaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEncomiendaEspecificaActionPerformed
        controlador.encomienda_codigo();
    }//GEN-LAST:event_btnEncomiendaEspecificaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEncomiendaEspecifica;
    private javax.swing.JButton btnEncomiendaViaje;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnVerClientes;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelFondo;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Observable o, Object arg) {
        if (arg == "No se encontro la encomienda") {
            JOptionPane.showMessageDialog(null, "No se encontro la encomienda");
        } else if (arg == "Debe digitar un codigo valido") {
            JOptionPane.showMessageDialog(null, "Debe digitar un codigo valido");
        } else {
            if (arg != null) {
                JOptionPane.showMessageDialog(null, arg);
            }
        }
    }
}
