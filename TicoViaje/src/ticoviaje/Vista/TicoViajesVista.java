package ticoviaje.Vista;

import java.util.Observable;
import java.util.Observer;
import ticoviaje.Controlador.*;

public final class TicoViajesVista extends javax.swing.JFrame implements Observer {

    private TicoViajesControlador controlador;

    public TicoViajesVista() {
        this.controlador = new TicoViajesControlador();
        initComponents();
    }

    public void iniciar() {
        controlador.agregarObservador(this);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Tiquetes = new javax.swing.JButton();
        Encomiendas = new javax.swing.JButton();
        ImagenPanel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Tiquetes.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        Tiquetes.setText("<html><body><center>Gestion de<br>Tiquetes</center></body></html>");
        Tiquetes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TiquetesActionPerformed(evt);
            }
        });
        jPanel1.add(Tiquetes, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 300, -1, -1));

        Encomiendas.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        Encomiendas.setText("<html><body><center>Gestion de<br>Encomientas</center></body></html>");
        Encomiendas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EncomiendasActionPerformed(evt);
            }
        });
        jPanel1.add(Encomiendas, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 300, -1, -1));

        ImagenPanel.setForeground(new java.awt.Color(255, 255, 255));
        ImagenPanel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ticoviaje/Imagen/ticoviajesfondo.png"))); // NOI18N
        ImagenPanel.setToolTipText("");
        jPanel1.add(ImagenPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TiquetesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TiquetesActionPerformed
        if (controlador.abrirTiquetes() == true) {
            setVisible(false);
        }
    }//GEN-LAST:event_TiquetesActionPerformed

    private void EncomiendasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EncomiendasActionPerformed
        controlador.abrirEncomiendas();
        setVisible(false);
    }//GEN-LAST:event_EncomiendasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Encomiendas;
    private javax.swing.JLabel ImagenPanel;
    private javax.swing.JButton Tiquetes;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Observable o, Object arg) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
