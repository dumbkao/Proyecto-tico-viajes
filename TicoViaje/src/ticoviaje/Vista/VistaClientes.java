package ticoviaje.Vista;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import ticoviaje.Objetos.Cliente;
import ticoviaje.Objetos.Encomienda;

public class VistaClientes extends javax.swing.JFrame {
    
    private ArrayList<Cliente> clientes;
    
    public VistaClientes() {
        initComponents();
        clientes = new ArrayList();
    }
    
    public void iniciar() {
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);        
        setVisible(true);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPrincipal = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaClientes = new javax.swing.JTable();
        btnVerEncomienda = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        btnAgregarClientes = new javax.swing.JButton();
        labelFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        TablaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Clientes"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(TablaClientes);

        panelPrincipal.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 190, 530, 280));

        btnVerEncomienda.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnVerEncomienda.setText("Ver Encomienda");
        btnVerEncomienda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerEncomiendaActionPerformed(evt);
            }
        });
        panelPrincipal.add(btnVerEncomienda, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 490, 240, 30));

        btnRegresar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        panelPrincipal.add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 540, 110, 30));

        btnAgregarClientes.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnAgregarClientes.setText("Agregar Cliente");
        btnAgregarClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarClientesActionPerformed(evt);
            }
        });
        panelPrincipal.add(btnAgregarClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 490, 240, 30));

        labelFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ticoviaje/Imagen/ticoviajesfondo.png"))); // NOI18N
        panelPrincipal.add(labelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void btnAgregarClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarClientesActionPerformed
        String nombre = JOptionPane.showInputDialog(null, "Digite su nombre");
        if (nombre != null && !nombre.equals("")) {
            Cliente nuevo = new Cliente();
            nuevo.setNombre(nombre);
            
            int Opc = 1;
            
            do {
                Encomienda encomienda = new Encomienda();
                String peso = JOptionPane.showInputDialog(null, "Digite el peso de la encomienda");
                
                if (peso != null && !peso.equals("")) {
                    
                    double aux = 0;
                    
                    do {
                        aux = Math.floor(Math.random() * (1000 - 0 + 1) + 0);
                    } while (codigoRandom(aux) == true);
                    
                    String personaEntrega = JOptionPane.showInputDialog(null, "Digite la persona que entrega");
                    
                    if (personaEntrega != null && !personaEntrega.equals("")) {
                        String personaRetira = JOptionPane.showInputDialog(null, "Digite la persona que va a retirar");
                        
                        if (personaRetira != null && !personaRetira.equals("")) {
                            String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
                            String estadoViaje = "En Espera de Salida";
                            encomienda.setCodigo((int) aux);
                            encomienda.setEstadoViaje(estadoViaje);
                            encomienda.setPeso(Integer.parseInt(peso));
                            encomienda.setPrecioPorPeso(1000 * Integer.parseInt(peso));
                            encomienda.setPersonaEntrega(personaEntrega);
                            encomienda.setPersonaRetira(personaRetira);
                            encomienda.setHoraFecha(timeStamp);
                            
                            nuevo.getEncomiendas().add(encomienda);
                        }
                    }
                }
                
                Opc = JOptionPane.showConfirmDialog(null, "¿Desea agregar otra encomienda?");
            } while (Opc == 0);
            
            clientes.add(nuevo);
            DefaultTableModel model = (DefaultTableModel) TablaClientes.getModel();
            model.addRow(new Object[]{nuevo.getNombre()});
        }
    }//GEN-LAST:event_btnAgregarClientesActionPerformed
    
    private boolean codigoRandom(double codigo) {
        for (Cliente cliente : clientes) {
            for (Encomienda encomienda : cliente.getEncomiendas().getEncomiendas()) {
                if (encomienda.getCodigo() == codigo) {
                    return true;
                }
            }
        }
        return false;
    }
    

    private void btnVerEncomiendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerEncomiendaActionPerformed
        int fila = TablaClientes.getSelectedRow();
        if (fila != -1) {
            VistaEncomiendasCliente vista = new VistaEncomiendasCliente(clientes.get(fila));
            vista.iniciar();
            setVisible(false);
        }
    }//GEN-LAST:event_btnVerEncomiendaActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        TicoViajesVista vista = new TicoViajesVista();
        vista.iniciar();
        setVisible(false);
    }//GEN-LAST:event_btnRegresarActionPerformed
    
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
            java.util.logging.Logger.getLogger(VistaClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaClientes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaClientes;
    private javax.swing.JButton btnAgregarClientes;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnVerEncomienda;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelFondo;
    private javax.swing.JPanel panelPrincipal;
    // End of variables declaration//GEN-END:variables
}
