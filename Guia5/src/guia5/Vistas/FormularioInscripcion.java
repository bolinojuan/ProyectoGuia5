/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guia5.Vistas;

import guia5.AccesoADatos.AlumnoData;
import guia5.AccesoADatos.InscripcionData;
import guia5.Entidades.Alumno;
import guia5.Entidades.Inscripcion;
import guia5.Entidades.Materia;
import java.beans.PropertyVetoException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author dev0
 */
public class FormularioInscripcion extends javax.swing.JInternalFrame {
private DefaultTableModel modelo = new DefaultTableModel();
    /**
     * Creates new form FormularioConsulta
     */
    public FormularioInscripcion() {
        initComponents();
        armarCabecera();
       cargarCombobox();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jBInscribir = new javax.swing.JButton();
        jBAnular = new javax.swing.JButton();
        jBSalir = new javax.swing.JButton();
        jCBAlumno = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jRMatIns = new javax.swing.JRadioButton();
        jRMatNoIns = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTInsc = new javax.swing.JTable();

        setPreferredSize(new java.awt.Dimension(590, 350));

        jBInscribir.setText("Inscribir");
        jBInscribir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBInscribirActionPerformed(evt);
            }
        });

        jBAnular.setText("Anular Inscripcion");

        jBSalir.setText("Salir");
        jBSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSalirActionPerformed(evt);
            }
        });

        jCBAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBAlumnoActionPerformed(evt);
            }
        });

        jLabel1.setText("Seleccione un alumno");

        jLabel2.setFont(new java.awt.Font("Noto Sans", 1, 16)); // NOI18N
        jLabel2.setText("Listado de Materias");

        jLabel3.setFont(new java.awt.Font("Noto Sans", 1, 18)); // NOI18N
        jLabel3.setText("Formulario de Inscripcion");

        jRMatIns.setText("Materias Inscriptas");
        jRMatIns.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRMatInsMouseClicked(evt);
            }
        });

        jRMatNoIns.setText("Materias NO inscriptas");
        jRMatNoIns.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRMatNoInsActionPerformed(evt);
            }
        });

        jTInsc.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTInsc);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(19, 19, 19)
                                .addComponent(jCBAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jRMatIns)
                                .addGap(120, 120, 120)
                                .addComponent(jRMatNoIns))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(jBInscribir)
                        .addGap(62, 62, 62)
                        .addComponent(jBAnular)
                        .addGap(76, 76, 76)
                        .addComponent(jBSalir))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(146, 146, 146)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCBAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRMatIns)
                    .addComponent(jRMatNoIns))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBAnular)
                    .addComponent(jBInscribir)
                    .addComponent(jBSalir))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jRMatNoInsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRMatNoInsActionPerformed
     jRMatNoIns.setEnabled(false);
     if(jRMatNoIns.isSelected()){
     jRMatIns.setSelected(false);
         //borrarFilas();
        //if(jRMatIns.isSelected()){
        Alumno alumno =  (Alumno)jCBAlumno.getSelectedItem();
        InscripcionData insc = new InscripcionData();
        ArrayList<Materia> materias = new ArrayList<>();
        materias.addAll(insc.obtenerMateriasNoCursadas(alumno.getIdAlumno()));
        for (Materia mat: materias) {
       modelo.addRow(new Object[]{mat.getIdMateria()+"",mat.getNombre(),mat.getAnioMateria()+""});
           
        //}
        }
     
     }
    }//GEN-LAST:event_jRMatNoInsActionPerformed

    private void jBSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalirActionPerformed
        JOptionPane.showMessageDialog(this,"desea volver al menu principal?");
        try {            
            setClosed(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(FormularioInscripcion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jBSalirActionPerformed

    private void jRMatInsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRMatInsMouseClicked
       jRMatIns.setEnabled(false);
       if(jRMatNoIns.isSelected()){
       jRMatIns.setSelected(false);
         //borrarFilas();
        Alumno alumno =  (Alumno)jCBAlumno.getSelectedItem();
        InscripcionData insc = new InscripcionData();
        ArrayList<Materia> materias = new ArrayList<>();
        materias.addAll(insc.obtenerMateriasCursadas(alumno.getIdAlumno()));
        for (Materia mat: materias) {
       modelo.addRow(new Object[]{mat.getIdMateria()+"",mat.getNombre(),mat.getAnioMateria()+""});
           
        }
        }
       
       
       
     
       
    }//GEN-LAST:event_jRMatInsMouseClicked

    private void jBInscribirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBInscribirActionPerformed
        Inscripcion insc = new Inscripcion();
        
        InscripcionData insdat =new InscripcionData();
        
        insdat.guardarInscripcion(insc);
    }//GEN-LAST:event_jBInscribirActionPerformed

    private void jCBAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBAlumnoActionPerformed

        
//        borrarFilas();
//        if(jRMatIns.isSelected()){
//        Alumno alumno =  (Alumno)jCBAlumno.getSelectedItem();
//        InscripcionData insc = new InscripcionData();
//        ArrayList<Materia> materias = new ArrayList<>();
//        materias.addAll(insc.obtenerMateriasCursadas(alumno.idAlumno));
//        for (Materia mat: materias) {
//       modelo.addRow(new Object[]{mat.getIdMateria()+"",mat.getNombre(),mat.getAnioMateria()+""});
//           
//         }
//     
    
     
    
    }//GEN-LAST:event_jCBAlumnoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAnular;
    private javax.swing.JButton jBInscribir;
    private javax.swing.JButton jBSalir;
    private javax.swing.JComboBox<Alumno> jCBAlumno;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JRadioButton jRMatIns;
    private javax.swing.JRadioButton jRMatNoIns;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTInsc;
    // End of variables declaration//GEN-END:variables


private void armarCabecera(){
modelo.addColumn("ID");
modelo.addColumn("Nombre");
modelo.addColumn("Año");
jTInsc.setModel(modelo);
}

private void cargarCombobox(){
AlumnoData alumnodata = new AlumnoData();
ArrayList <Alumno> lista = new ArrayList<>();
 lista.addAll(alumnodata.listarAlumno());
        
    for (Alumno a : lista){
        jCBAlumno.addItem(a);
        }

}
private void borrarFilas(){
        int f=jTInsc.getRowCount()-1;
        for(;f>=0;f--){
            modelo.removeRow(f);
        }
    }
}