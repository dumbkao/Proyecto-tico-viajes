/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticoviaje.Vista;

import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import ticoviaje.Controlador.BusControlador;
import xml.UtilidadesXML;

/**
 *
 * @author hilla
 */
public class BusVista extends javax.swing.JFrame {

    private BusControlador controlador;
    private ImageIcon icono_rojo;
    private ImageIcon icono_verde;
    private static String propietario;

    public BusVista(String pro) {
        controlador = new BusControlador();
        icono_rojo = new ImageIcon("src/ticoviaje/Imagen/asientoOcupado.png");
        icono_verde = new ImageIcon("src/ticoviaje/Imagen/asientoDisponible.png");
        propietario = pro;
        initComponents();
    }

    public void iniciar(String ruta, String dia, String horario) {
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        Ruta.setText(ruta);
        Dia.setText(dia);
        Horario.setText(horario);
        verificarBotones();
    }

    public BusControlador getControlador() {
        return controlador;
    }

    public void setControlador(BusControlador controlador) {
        this.controlador = controlador;
    }

    public void verificarBotones() {
        ArrayList<JButton> botones = new ArrayList();
        botones.add(Asiento1);
        botones.add(Asiento2);
        botones.add(Asiento3);
        botones.add(Asiento4);
        botones.add(Asiento5);
        botones.add(Asiento6);
        botones.add(Asiento7);
        botones.add(Asiento8);
        botones.add(Asiento9);
        botones.add(Asiento10);
        botones.add(Asiento11);

        for (int i = 0; i < 11; i++) {
            if (controlador.getAsientos().get(i).isDisponible() == false) {
                botones.get(i).setIcon(icono_rojo);
            }
        }
    }

    private void guardarBuses() {
        try {
            Document d = UtilidadesXML.crearDocumento();
            Node r = d.createElement("DatosPersonales");
            r.appendChild(controlador.toXML(d));
            
            d.appendChild(r);
            UtilidadesXML.guardarArchivoXML(d, "personas.xml");
        } catch (ParserConfigurationException ex) {

        }
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
        Unidad = new javax.swing.JLabel();
        LabelRuta = new javax.swing.JLabel();
        LabelDia = new javax.swing.JLabel();
        LabelHorario = new javax.swing.JLabel();
        Ruta = new javax.swing.JLabel();
        Dia = new javax.swing.JLabel();
        Horario = new javax.swing.JLabel();
        botonAceptar = new javax.swing.JButton();
        LabelFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
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

        Unidad.setBackground(new java.awt.Color(0, 0, 0));
        Unidad.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        Unidad.setForeground(new java.awt.Color(0, 0, 0));
        Unidad.setText("Unidad");
        jPanel1.add(Unidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 60, -1, -1));

        LabelRuta.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        LabelRuta.setForeground(new java.awt.Color(0, 0, 0));
        LabelRuta.setText("Ruta:");
        jPanel1.add(LabelRuta, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 150, -1, -1));

        LabelDia.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        LabelDia.setForeground(new java.awt.Color(0, 0, 0));
        LabelDia.setText("Dia:");
        jPanel1.add(LabelDia, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 190, -1, -1));

        LabelHorario.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        LabelHorario.setForeground(new java.awt.Color(0, 0, 0));
        LabelHorario.setText("Horario:");
        jPanel1.add(LabelHorario, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 230, -1, -1));

        Ruta.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        Ruta.setForeground(new java.awt.Color(0, 0, 0));
        Ruta.setText("horario");
        jPanel1.add(Ruta, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 230, -1, -1));

        Dia.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        Dia.setForeground(new java.awt.Color(0, 0, 0));
        Dia.setText("ruta");
        jPanel1.add(Dia, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 150, -1, -1));

        Horario.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        Horario.setForeground(new java.awt.Color(0, 0, 0));
        Horario.setText("dia");
        jPanel1.add(Horario, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 190, -1, -1));

        botonAceptar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        botonAceptar.setText("Aceptar asientos");
        botonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAceptarActionPerformed(evt);
            }
        });
        jPanel1.add(botonAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 300, -1, -1));

        LabelFondo.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        LabelFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ticoviaje/Imagen/bus.png"))); // NOI18N
        jPanel1.add(LabelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 530, 440));

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

        if (controlador.getAsientos().get(0).getPropetario().equals("")) {
            Asiento1.setIcon(icono_rojo);
            controlador.getAsientos().get(0).setPropetario(propietario);
            controlador.getAsientos().get(0).setDisponible(false);
        } else if (controlador.getAsientos().get(0).getPropetario().equals(propietario)) {
            Asiento1.setIcon(icono_verde);
            controlador.getAsientos().get(0).setPropetario("");
            controlador.getAsientos().get(0).setDisponible(true);
        }
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

    private void botonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAceptarActionPerformed
        JOptionPane.showMessageDialog(null, "Los asientos han sido seleccionados");
        setVisible(false);
        TicoViajesVista vista = new TicoViajesVista();
        vista.iniciar();
    }//GEN-LAST:event_botonAceptarActionPerformed

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
                new BusVista(propietario).setVisible(true);
            }
        });

    }


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
    private javax.swing.JLabel Dia;
    private javax.swing.JLabel Horario;
    private javax.swing.JLabel LabelDia;
    private javax.swing.JLabel LabelFondo;
    private javax.swing.JLabel LabelHorario;
    private javax.swing.JLabel LabelRuta;
    private javax.swing.JLabel Ruta;
    private javax.swing.JLabel Unidad;
    private javax.swing.JButton botonAceptar;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
