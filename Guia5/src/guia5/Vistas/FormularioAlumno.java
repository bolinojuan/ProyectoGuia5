/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guia5.Vistas;

import guia5.AccesoADatos.*;
import guia5.Entidades.*;
import java.awt.Color;
import java.beans.PropertyVetoException;
import java.sql.Date;
import java.time.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/**
 *
 * @author dev0
 */
public class FormularioAlumno extends javax.swing.JInternalFrame {
private LocalDate fecha;
private AlumnoData aldat;
    /**
     * Creates new form FormularioAlumno
     */
    public FormularioAlumno() {
        initComponents();
        aldat = new AlumnoData();
     
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTDni = new javax.swing.JTextField();
        jTApellido = new javax.swing.JTextField();
        jTNombre = new javax.swing.JTextField();
        jBBuscar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jREstado = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jBNuevo = new javax.swing.JButton();
        jBEliminar = new javax.swing.JButton();
        jBGuardar = new javax.swing.JButton();
        jBSalir = new javax.swing.JButton();
        jDCFechaNac = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(800, 600));

        jTApellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTApellidoKeyTyped(evt);
            }
        });

        jBBuscar.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        jBBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/magnifier.png"))); // NOI18N
        jBBuscar.setText("Buscar ID");
        jBBuscar.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jBBuscarMouseMoved(evt);
            }
        });
        jBBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jBBuscarMouseExited(evt);
            }
        });
        jBBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBBuscarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        jLabel1.setText("Documento");

        jLabel2.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        jLabel2.setText("Apellido");

        jLabel3.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        jLabel3.setText("Nombre");

        jREstado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jREstadoMouseClicked(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        jLabel4.setText("Estado");

        jLabel5.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        jLabel5.setText("Fecha de Nacimiento");

        jBNuevo.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        jBNuevo.setText("Nuevo");
        jBNuevo.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jBNuevoMouseMoved(evt);
            }
        });
        jBNuevo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jBNuevoMouseExited(evt);
            }
        });
        jBNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBNuevoActionPerformed(evt);
            }
        });

        jBEliminar.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        jBEliminar.setText("Eliminar");
        jBEliminar.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jBEliminarMouseMoved(evt);
            }
        });
        jBEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jBEliminarMouseExited(evt);
            }
        });
        jBEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEliminarActionPerformed(evt);
            }
        });

        jBGuardar.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        jBGuardar.setText("Guardar");
        jBGuardar.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jBGuardarMouseMoved(evt);
            }
        });
        jBGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jBGuardarMouseExited(evt);
            }
        });
        jBGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBGuardarActionPerformed(evt);
            }
        });

        jBSalir.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        jBSalir.setText("Salir");
        jBSalir.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jBSalirMouseMoved(evt);
            }
        });
        jBSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBSalirMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jBSalirMouseExited(evt);
            }
        });

        jDCFechaNac.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDCFechaNacPropertyChange(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Noto Sans", 1, 26)); // NOI18N
        jLabel6.setText("Alumno");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                        .addComponent(jBEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(74, 74, 74)
                        .addComponent(jBGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(72, 72, 72)
                        .addComponent(jBSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(192, 192, 192)
                        .addComponent(jREstado)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jLabel5)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(90, 90, 90)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(78, 78, 78))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jTDni, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jBBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jTNombre)
                                            .addComponent(jTApellido)
                                            .addComponent(jDCFechaNac, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE))
                                        .addGap(0, 0, Short.MAX_VALUE)))))))
                .addGap(76, 76, 76))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel6)
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTDni, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(jBBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jTApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(28, 28, 28)
                        .addComponent(jREstado))
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jDCFechaNac, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jBGuardar)
                            .addComponent(jBEliminar)
                            .addComponent(jBNuevo)
                            .addComponent(jBSalir))
                        .addGap(121, 121, 121))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBBuscarActionPerformed
        Alumno alu = new Alumno();
        
        AlumnoData aludata = new AlumnoData();   
       
        try{
           int dni = Integer.parseInt(jTDni.getText());
           
           if(dni>0){
               alu = aludata.buscarPorDni(dni);
            }else{
               jTDni.setText(null);
               JOptionPane.showMessageDialog(this, "Ingrese un dni válido");
               return;      
            }
           
           if(alu==null){
               borrarCampos();
          
            }else{
                jTApellido.setText(alu.getApellido());
                jTNombre.setText(alu.getNombre());       
                jDCFechaNac.setDate(Date.valueOf(alu.getFechaNac()));
                jREstado.setSelected(alu.isActivo());     
            }
        }catch(NumberFormatException nf){
            jTDni.setText(null);
            JOptionPane.showMessageDialog(this, "Revise que los datos ingresados sean correctos ");
        }
    }//GEN-LAST:event_jBBuscarActionPerformed
       
    private void jREstadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jREstadoMouseClicked
    jREstado.setSelected(true);
 
    }//GEN-LAST:event_jREstadoMouseClicked

    private void jBNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBNuevoActionPerformed
       if(jTApellido.getText().isEmpty() || jTDni.getText().isEmpty() || jTNombre.getText().isEmpty()||fecha==null){
           JOptionPane.showMessageDialog(null, "Debe completar todos los campos");
           return;
        }else{
    
       
            Alumno alum = new Alumno();
            try{
                int dni = Integer.parseInt(jTDni.getText());  
                if(dni>0){
                    alum.setDni(dni);
                    alum.setApellido(jTApellido.getText());
                    alum.setNombre(jTNombre.getText());
                    alum.setActivo(jREstado.isSelected());
                    alum.setFecha(fecha);
                    aldat.guardarAlumno(alum);
                }else{
                    jTDni.setText(null);
                    jTApellido.setText(null);
                    jTNombre.setText(null);
                    JOptionPane.showMessageDialog(this, "Debe ingresar un documento válido");
                    return;
                }

            }catch(NumberFormatException nf){
                JOptionPane.showMessageDialog(null, "Ingrese DNI válido");
            }
        } 
    }//GEN-LAST:event_jBNuevoActionPerformed

        public void borrarCampos(){
            if(!jTApellido.getText().isEmpty() && !jTDni.getText().isEmpty() && !jTNombre.getText().isEmpty()){
            jTApellido.setText(null);
            jTDni .setText(null);
            jTNombre.setText(null);
            jREstado.setSelected(false);
            jDCFechaNac.setDate(null);
            fecha=null;
            }
        }
    
    private void jDCFechaNacPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDCFechaNacPropertyChange
        if(jDCFechaNac.getDate()!=null){
        fecha= jDCFechaNac.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        }
    }//GEN-LAST:event_jDCFechaNacPropertyChange

    private void jBEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEliminarActionPerformed
        if(jTApellido.getText().isEmpty() || jTDni.getText().isEmpty() || jTNombre.getText().isEmpty()){
            JOptionPane.showMessageDialog(this,"Debe completar todos los campos");
            return;
        }else{
            int dni  = Integer.parseInt(jTDni.getText());
            aldat.eliminarAlumno(dni);
            borrarCampos();
        }
    }//GEN-LAST:event_jBEliminarActionPerformed

    private void jBGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBGuardarActionPerformed
        if(jTApellido.getText().isEmpty() || jTDni.getText().isEmpty() || jTNombre.getText().isEmpty()){
           JOptionPane.showMessageDialog(null, "Debe completar todos los campos");
           return;
        }

        Alumno alum = new Alumno();


        int dni = Integer.parseInt(jTDni.getText());

        alum.setDni(dni);       
        alum.setApellido(jTApellido.getText());
        alum.setNombre(jTNombre.getText());
        alum.setActivo(jREstado.isSelected());
        alum.setFecha(fecha);
        aldat.modificarAlumno(alum);
        borrarCampos();
        
    }//GEN-LAST:event_jBGuardarActionPerformed

    private void jBSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBSalirMouseClicked
        int respuesta=JOptionPane.showConfirmDialog(this, "¿Desea regresar al menú principal?","confirm",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        if(respuesta==JOptionPane.NO_OPTION){
        return;
        }else{
            try {
                setClosed(true);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(FormularioAlumno.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    
       
    }//GEN-LAST:event_jBSalirMouseClicked

    private void jBEliminarMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBEliminarMouseMoved
        jBEliminar.setBackground(new Color(231,142,142));
    }//GEN-LAST:event_jBEliminarMouseMoved

    private void jBEliminarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBEliminarMouseExited
        jBEliminar.setBackground(Color.lightGray);
    }//GEN-LAST:event_jBEliminarMouseExited

    private void jBBuscarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBBuscarMouseExited
       jBBuscar.setBackground(Color.lightGray);
    }//GEN-LAST:event_jBBuscarMouseExited

    private void jBBuscarMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBBuscarMouseMoved
       jBBuscar.setBackground(Color.CYAN);
    }//GEN-LAST:event_jBBuscarMouseMoved

    private void jBNuevoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBNuevoMouseExited
       jBNuevo.setBackground(Color.lightGray);
    }//GEN-LAST:event_jBNuevoMouseExited

    private void jBNuevoMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBNuevoMouseMoved
       jBNuevo.setBackground(new Color(84,234,54));
    }//GEN-LAST:event_jBNuevoMouseMoved

    private void jBGuardarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBGuardarMouseExited
      jBGuardar.setBackground(Color.lightGray);
    }//GEN-LAST:event_jBGuardarMouseExited

    private void jBGuardarMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBGuardarMouseMoved
        jBGuardar.setBackground(new Color(221,160,239));
    }//GEN-LAST:event_jBGuardarMouseMoved

    private void jBSalirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBSalirMouseExited
        jBSalir.setBackground(Color.lightGray);
    }//GEN-LAST:event_jBSalirMouseExited

    private void jBSalirMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBSalirMouseMoved
       jBSalir.setBackground(new Color(171,181,38));
    }//GEN-LAST:event_jBSalirMouseMoved

    private void jTApellidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTApellidoKeyTyped
        if(!(Character.isLetter(evt.getKeyChar()))&&!(Character.isWhitespace(evt.getKeyChar()))){
            evt.consume();
        }
    }//GEN-LAST:event_jTApellidoKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBBuscar;
    private javax.swing.JButton jBEliminar;
    private javax.swing.JButton jBGuardar;
    private javax.swing.JButton jBNuevo;
    private javax.swing.JButton jBSalir;
    private com.toedter.calendar.JDateChooser jDCFechaNac;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JRadioButton jREstado;
    private javax.swing.JTextField jTApellido;
    private javax.swing.JTextField jTDni;
    private javax.swing.JTextField jTNombre;
    // End of variables declaration//GEN-END:variables
}


