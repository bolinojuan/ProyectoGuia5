/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guia5.Vistas;

import guia5.Entidades.*;
import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import guia5.AccesoADatos.*;
import java.awt.Color;
import java.util.*;

/**
 *
 * @author dev0
 */
public class ListadoMaterias extends javax.swing.JInternalFrame {
DefaultTableModel modelo = new DefaultTableModel();
    /**
     * Creates new form ListadoMaterias
     */
    public ListadoMaterias() {
        initComponents();
        armarCabecera();
        cargarCombo();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jCBMateria = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTAlumnos = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(800, 600));

        jLabel1.setFont(new java.awt.Font("Noto Sans", 1, 20)); // NOI18N
        jLabel1.setText("Listado de Alumnos por Materias");

        jLabel2.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        jLabel2.setText("Seleccione una Materia:");

        jCBMateria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBMateriaActionPerformed(evt);
            }
        });

        jTAlumnos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTAlumnos);

        jButton1.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        jButton1.setText("Salir");
        jButton1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jButton1MouseMoved(evt);
            }
        });
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton1MouseExited(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(55, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 671, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(63, 63, 63))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jCBMateria, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(99, 99, 99)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(126, 126, 126))))
            .addGroup(layout.createSequentialGroup()
                .addGap(196, 196, 196)
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCBMateria, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 102, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(107, 107, 107)
                .addComponent(jButton1)
                .addGap(105, 105, 105))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
   int respuesta=JOptionPane.showConfirmDialog(this, "desea salir al menu principal?","confirm",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
if(respuesta==JOptionPane.NO_OPTION){
return;
}else{
    try {
        setClosed(true);
    } catch (PropertyVetoException ex) {
        Logger.getLogger(FormularioAlumno.class.getName()).log(Level.SEVERE, null, ex);
    }
}
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jCBMateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBMateriaActionPerformed
        borrarFilas();
        Materia materia=(Materia)jCBMateria.getSelectedItem();
        InscripcionData inscripcion=new InscripcionData();
        ArrayList <Alumno> listado=new ArrayList();
        listado.addAll(inscripcion.obtenerAlumnosXMateria(materia.getIdMateria()));
        for(Alumno a:listado){
            modelo.addRow(new Object[]{a.getIdAlumno(),a.getDni(),a.getApellido(),a.getNombre()});
        }
    }//GEN-LAST:event_jCBMateriaActionPerformed

    private void jButton1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseExited
        jButton1.setBackground(Color.lightGray);
    }//GEN-LAST:event_jButton1MouseExited

    private void jButton1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseMoved
       jButton1.setBackground(new Color(171,181,38));
    }//GEN-LAST:event_jButton1MouseMoved


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<Materia> jCBMateria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTAlumnos;
    // End of variables declaration//GEN-END:variables


    private void armarCabecera(){
    modelo.addColumn("ID");
    modelo.addColumn("DNI");
    modelo.addColumn("Apellido");
    modelo.addColumn("Nombre");
    jTAlumnos.setModel(modelo);
    }

    private void cargarCombo(){
        MateriaData materiadata = new MateriaData();
        ArrayList <Materia> lista = new ArrayList<>();
        lista.addAll(materiadata.listarMaterias());

        for (Materia m : lista){
            jCBMateria.addItem(m);
        }
    }
    private void borrarFilas(){
        int f=jTAlumnos.getRowCount()-1;
        for(;f>=0;f--){
            modelo.removeRow(f);
        }
    }

}
