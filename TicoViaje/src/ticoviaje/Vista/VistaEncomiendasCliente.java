package ticoviaje.Vista;

import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import ticoviaje.Controlador.EncomiendasClienteControlador;
import ticoviaje.Objetos.Cliente;

public class VistaEncomiendasCliente extends javax.swing.JFrame implements Observer {

    private EncomiendasClienteControlador controlador;

    public VistaEncomiendasCliente(Cliente cliente, int posicion) {
        super("VistaEncomiendasCliente");
        controlador = new EncomiendasClienteControlador(cliente, posicion);
        initComponents();
    }

    public void iniciar() {
        controlador.cargarBD(TablaEncomiendas);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaEncomiendas = new javax.swing.JTable();
        btnRegresar = new javax.swing.JButton();
        btnCambiarEstado = new javax.swing.JButton();
        btnAgregarEncomienda = new javax.swing.JButton();
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
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(TablaEncomiendas);
        if (TablaEncomiendas.getColumnModel().getColumnCount() > 0) {
            TablaEncomiendas.getColumnModel().getColumn(0).setResizable(false);
            TablaEncomiendas.getColumnModel().getColumn(0).setPreferredWidth(8);
            TablaEncomiendas.getColumnModel().getColumn(1).setResizable(false);
            TablaEncomiendas.getColumnModel().getColumn(1).setPreferredWidth(8);
            TablaEncomiendas.getColumnModel().getColumn(2).setResizable(false);
            TablaEncomiendas.getColumnModel().getColumn(2).setPreferredWidth(8);
            TablaEncomiendas.getColumnModel().getColumn(3).setResizable(false);
            TablaEncomiendas.getColumnModel().getColumn(3).setPreferredWidth(8);
            TablaEncomiendas.getColumnModel().getColumn(4).setResizable(false);
            TablaEncomiendas.getColumnModel().getColumn(4).setPreferredWidth(8);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, 960, 300));

        btnRegresar.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 490, 150, -1));

        btnCambiarEstado.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btnCambiarEstado.setText("Cambiar Estado");
        btnCambiarEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambiarEstadoActionPerformed(evt);
            }
        });
        jPanel1.add(btnCambiarEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 490, -1, -1));

        btnAgregarEncomienda.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btnAgregarEncomienda.setText("Agregar Encomienda");
        btnAgregarEncomienda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarEncomiendaActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregarEncomienda, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 490, 290, -1));

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
        controlador.regresar();
        setVisible(false);
    }//GEN-LAST:event_btnRegresarActionPerformed
    private void btnCambiarEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambiarEstadoActionPerformed
        try {
            controlador.cambiar_estado(TablaEncomiendas);
        } catch (Exception ex) {
            Logger.getLogger(VistaEncomiendasCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnCambiarEstadoActionPerformed

    private void btnAgregarEncomiendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarEncomiendaActionPerformed
        controlador.agregar_encomienda(TablaEncomiendas);
    }//GEN-LAST:event_btnAgregarEncomiendaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaEncomiendas;
    private javax.swing.JButton btnAgregarEncomienda;
    private javax.swing.JButton btnCambiarEstado;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelFondo;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Observable o, Object arg) {
        if (arg != null) {
            JOptionPane.showMessageDialog(null, arg);
        }
    }
}
