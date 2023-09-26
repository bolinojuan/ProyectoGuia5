/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guia5.Vistas;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author dev0
 */
public class MenuPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form MenuPrincipal
     */
    public MenuPrincipal() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setSize(800,600);
        
    }


    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ImageIcon icono = new ImageIcon(getClass().getResource("/recursos/universidadVista.jpg"));
        Image miImagen = icono.getImage();
        escritorio = new javax.swing.JDesktopPane(){
            public void paintComponent(Graphics g){
                g.drawImage(miImagen,0,0,getWidth(),getHeight(),this);
            }
        };
        jMenuBar1 = new javax.swing.JMenuBar();
        jMAlumno = new javax.swing.JMenu();
        jMFormAlumno = new javax.swing.JMenuItem();
        jMMateria = new javax.swing.JMenu();
        jMFormularioMateria = new javax.swing.JMenuItem();
        jMAdministracion = new javax.swing.JMenu();
        jMManejoIns = new javax.swing.JMenuItem();
        jMManipNotas = new javax.swing.JMenuItem();
        jMConsultas = new javax.swing.JMenu();
        jMAlumnosPorMateria = new javax.swing.JMenuItem();
        jMSalir = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(800, 600));

        escritorio.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                escritorioPropertyChange(evt);
            }
        });

        jMAlumno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/alumno.png"))); // NOI18N

        jMFormAlumno.setText("Formulario de Alumno");
        jMFormAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMFormAlumnoActionPerformed(evt);
            }
        });
        jMAlumno.add(jMFormAlumno);

        jMenuBar1.add(jMAlumno);

        jMMateria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/materia.png"))); // NOI18N

        jMFormularioMateria.setText("Formulario de Materia");
        jMFormularioMateria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMFormularioMateriaActionPerformed(evt);
            }
        });
        jMMateria.add(jMFormularioMateria);

        jMenuBar1.add(jMMateria);

        jMAdministracion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/administracion.png"))); // NOI18N

        jMManejoIns.setText("Manejo de Inscripciones");
        jMManejoIns.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMManejoInsActionPerformed(evt);
            }
        });
        jMAdministracion.add(jMManejoIns);

        jMManipNotas.setText("Manipulacion de Notas");
        jMManipNotas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMManipNotasActionPerformed(evt);
            }
        });
        jMAdministracion.add(jMManipNotas);

        jMenuBar1.add(jMAdministracion);

        jMConsultas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/consultas.png"))); // NOI18N

        jMAlumnosPorMateria.setText("Alumnos por Materia");
        jMAlumnosPorMateria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMAlumnosPorMateriaActionPerformed(evt);
            }
        });
        jMConsultas.add(jMAlumnosPorMateria);

        jMenuBar1.add(jMConsultas);

        jMSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/salida.png"))); // NOI18N
        jMSalir.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuSelected(javax.swing.event.MenuEvent evt) {
                jMSalirMenuSelected(evt);
            }
            public void menuDeselected(javax.swing.event.MenuEvent evt) {
            }
            public void menuCanceled(javax.swing.event.MenuEvent evt) {
            }
        });
        jMenuBar1.add(jMSalir);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(escritorio, javax.swing.GroupLayout.DEFAULT_SIZE, 408, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMFormAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMFormAlumnoActionPerformed
    escritorio.removeAll();
    escritorio.repaint();
    
    FormularioAlumno f = new FormularioAlumno();
    f.setVisible(true);
    f.getContentPane().setBackground(new Color(250,252,207));
    escritorio.add(f);
    escritorio.moveToFront(f);
    
    }//GEN-LAST:event_jMFormAlumnoActionPerformed

    private void jMFormularioMateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMFormularioMateriaActionPerformed
      escritorio.removeAll();
      escritorio.repaint();
      FormularioMaterias f = new FormularioMaterias();
      f.setVisible(true);
      f.getContentPane().setBackground(new Color(250,252,207));
      escritorio.add(f);
      escritorio.moveToFront(f);
    }//GEN-LAST:event_jMFormularioMateriaActionPerformed

    private void escritorioPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_escritorioPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_escritorioPropertyChange

    private void jMSalirMenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_jMSalirMenuSelected
      JOptionPane.showMessageDialog(null, "Desea cerrar el programa?");
      System.exit(0);
    }//GEN-LAST:event_jMSalirMenuSelected

    private void jMManejoInsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMManejoInsActionPerformed
       escritorio.removeAll();
       escritorio.repaint();
       FormularioInscripcion fc = new FormularioInscripcion();
       fc.setVisible(true);
       fc.getContentPane().setBackground(new Color(250,252,207));
       escritorio.add(fc);
       escritorio.moveToFront(fc);
    }//GEN-LAST:event_jMManejoInsActionPerformed

    private void jMManipNotasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMManipNotasActionPerformed
       escritorio.removeAll();
       escritorio.repaint();
       cargaDeNotas cn = new cargaDeNotas();
       cn.setVisible(true);
       cn.getContentPane().setBackground(new Color(250,252,207));
       escritorio.add(cn);
       escritorio.moveToFront(cn);
    }//GEN-LAST:event_jMManipNotasActionPerformed

    private void jMAlumnosPorMateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMAlumnosPorMateriaActionPerformed
       escritorio.removeAll();
       escritorio.repaint();
       ListadoMaterias lm = new ListadoMaterias();
       lm.setVisible(true);
       lm.getContentPane().setBackground(new Color(250,252,207));
       escritorio.add(lm);
       escritorio.moveToFront(lm);
    }//GEN-LAST:event_jMAlumnosPorMateriaActionPerformed

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
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
    
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new MenuPrincipal().setVisible(true);
        }); 
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane escritorio;
    private javax.swing.JMenu jMAdministracion;
    private javax.swing.JMenu jMAlumno;
    private javax.swing.JMenuItem jMAlumnosPorMateria;
    private javax.swing.JMenu jMConsultas;
    private javax.swing.JMenuItem jMFormAlumno;
    private javax.swing.JMenuItem jMFormularioMateria;
    private javax.swing.JMenuItem jMManejoIns;
    private javax.swing.JMenuItem jMManipNotas;
    private javax.swing.JMenu jMMateria;
    private javax.swing.JMenu jMSalir;
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration//GEN-END:variables
        
    
        
                


        
}



