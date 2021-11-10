package ticoviaje.Vista;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import ticoviaje.Modelos.Bus;
import ticoviaje.Modelos.Flotilla;
import ticoviaje.Modelos.Viaje;
import ticoviaje.Objetos.Chofer;
import ticoviaje.Modelos.ConjuntoViajes;

public final class TicoViajesVista extends javax.swing.JFrame {

    private ConjuntoViajes conjuntoViaje;
    private Flotilla flotilla;

    public TicoViajesVista() {
        this.conjuntoViaje = new ConjuntoViajes();
        this.flotilla = new Flotilla();
        agregarBuses();
        agregarViajes();
        initComponents();
    }

    public void agregarViajes() {
        agregarViaje("Alajuela-San Jose", "Domingo", "12md - 2pm", 5, 1000, 0);
        agregarViaje("Alajuela-San Jose", "Lunes", "2:30pm - 3:30pm", 5, 1000, 0);
        agregarViaje("San Jose-Alajuela", "Domingo", "6pm - 7pm", 5, 1000, 0);
        agregarViaje("San Jose-Alajuela", "Domingo", "10am - 11am", 5, 1000, 0);
    }

    public void agregarViaje(String ruta, String fecha, String horario, int kilometros, int costo, int bus) {
        Viaje viaje = new Viaje();
        viaje.setRuta(ruta);
        viaje.setFecha(fecha);
        viaje.setHorario(horario);
        viaje.setKilometros(kilometros);
        viaje.setCosto(costo);
        viaje.setUnidad(flotilla.getEspecifico(bus));
        conjuntoViaje.add(viaje);
    }

    public void agregarBuses() {
        String nombres[] = {"Juanito", "Andres", "Ramses", "Hillary", "Rosa", "Pedrito", "Sofia", "Eduardo", "Jaime", "Jose", "Maria", "Marco", "Lucia", "Jair", "Noel", "Rachel", "Emanuel", "Abigail", "Gerardo", "Wilson"};
        for (int i = 0; i < 20; i++) {
            Chofer chofer = new Chofer();
            chofer.setNombre(nombres[i]);
            Bus bus = new Bus();
            bus.setChofer(chofer);
            flotilla.add(bus);
        }
    }

    public void iniciar() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
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
        String nombre = JOptionPane.showInputDialog(null, "Digite su nombre:", "Nombre", JOptionPane.QUESTION_MESSAGE);
        if (nombre != null && !nombre.equals("")) {
            ArrayList<String> listaRuta = conjuntoViaje.getRutas();
            String ruta = (String) JOptionPane.showInputDialog(null, "Elija la ruta que desea", "RUTAS", JOptionPane.QUESTION_MESSAGE, null, listaRuta.toArray(), listaRuta.get(0));

            if (ruta != null) {
                ArrayList<String> listaFecha = conjuntoViaje.getDiasRuta(ruta);
                String fecha = (String) JOptionPane.showInputDialog(null, "Elija la fecha que desea", "FECHAS", JOptionPane.QUESTION_MESSAGE, null, listaFecha.toArray(), listaFecha.get(0));

                if (fecha != null) {
                    ArrayList<String> listaHorarios = conjuntoViaje.getHorarioDiaRuta(ruta, fecha);
                    String horario = (String) JOptionPane.showInputDialog(null, "Elija el Horario que desea", "HORARIOS", JOptionPane.QUESTION_MESSAGE, null, listaHorarios.toArray(), listaHorarios.get(0));

                    if (horario != null) {
                        BusVista vista = new BusVista(nombre);

                        vista.getControlador().setDatos(flotilla.getEspecifico(0));
                        setVisible(false);

                        vista.iniciar(ruta, fecha, horario);
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe digitar un nombre valido", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_TiquetesActionPerformed

    private void EncomiendasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EncomiendasActionPerformed
        VistaEncomiendas vista = new VistaEncomiendas();
        vista.iniciar();
        setVisible(false);
    }//GEN-LAST:event_EncomiendasActionPerformed

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
            java.util.logging.Logger.getLogger(TicoViajesVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TicoViajesVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TicoViajesVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TicoViajesVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TicoViajesVista().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Encomiendas;
    private javax.swing.JLabel ImagenPanel;
    private javax.swing.JButton Tiquetes;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
