package panels;

import clases.Funciones;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Cybercafe
 */
public class Provedores_Agregar extends javax.swing.JPanel {

    /**
     * Creates new form boceto
     */
    Funciones f = new Funciones ();
    
    public Provedores_Agregar() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        TxtResponsable = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        TxtTelResponsable = new javax.swing.JTextField();
        TxtEmpresa = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        TxtDireccion = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        TxtTelEmpresa = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(1218, 373));
        setMinimumSize(new java.awt.Dimension(1218, 373));
        setPreferredSize(new java.awt.Dimension(1218, 373));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "NUEVO PROVEDOR", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N

        TxtResponsable.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        TxtResponsable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TxtResponsableKeyReleased(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("RESPONSABLE");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("TELEFONO RESPONSABLE");

        TxtTelResponsable.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        TxtTelResponsable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TxtTelResponsableKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TxtTelResponsableKeyReleased(evt);
            }
        });

        TxtEmpresa.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        TxtEmpresa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TxtEmpresaKeyReleased(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("EMPRESA");

        TxtDireccion.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        TxtDireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TxtDireccionKeyReleased(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("DIRECCION");

        TxtTelEmpresa.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        TxtTelEmpresa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TxtTelEmpresaKeyReleased(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("TELEFONO EMPRESA");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(TxtTelResponsable, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(TxtEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TxtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))))
                .addGap(51, 51, 51))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TxtTelEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(TxtResponsable, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(TxtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtTelEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtResponsable, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TxtTelResponsable, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        jButton1.setText("AGREGAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1218, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 873, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 373, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void TxtResponsableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtResponsableKeyReleased
        if (evt.getKeyCode() != KeyEvent.VK_LEFT && evt.getKeyCode() != KeyEvent.VK_RIGHT && evt.getKeyCode() != KeyEvent.VK_END && evt.getKeyCode() != KeyEvent.VK_HOME && evt.getKeyCode() != KeyEvent.VK_SHIFT && evt.getKeyCode() != KeyEvent.VK_CUT && evt.getKeyCode() != KeyEvent.VK_COPY && evt.getKeyCode() != KeyEvent.VK_PASTE)
        {
            f.SetUpercase_Jtextfield(TxtResponsable);
        }
    }//GEN-LAST:event_TxtResponsableKeyReleased

    private void TxtTelResponsableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtTelResponsableKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER)
        {

        }
    }//GEN-LAST:event_TxtTelResponsableKeyPressed

    private void TxtTelResponsableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtTelResponsableKeyReleased
        if (evt.getKeyCode() != KeyEvent.VK_LEFT && evt.getKeyCode() != KeyEvent.VK_RIGHT && evt.getKeyCode() != KeyEvent.VK_END && evt.getKeyCode() != KeyEvent.VK_HOME && evt.getKeyCode() != KeyEvent.VK_SHIFT && evt.getKeyCode() != KeyEvent.VK_CUT && evt.getKeyCode() != KeyEvent.VK_COPY && evt.getKeyCode() != KeyEvent.VK_PASTE)
        {
            f.SetUpercase_Jtextfield(TxtTelResponsable);
        }
    }//GEN-LAST:event_TxtTelResponsableKeyReleased

    private void TxtEmpresaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtEmpresaKeyReleased
        if (evt.getKeyCode() != KeyEvent.VK_LEFT && evt.getKeyCode() != KeyEvent.VK_RIGHT && evt.getKeyCode() != KeyEvent.VK_END && evt.getKeyCode() != KeyEvent.VK_HOME && evt.getKeyCode() != KeyEvent.VK_SHIFT && evt.getKeyCode() != KeyEvent.VK_CUT && evt.getKeyCode() != KeyEvent.VK_COPY && evt.getKeyCode() != KeyEvent.VK_PASTE)
        {
            f.SetUpercase_Jtextfield(TxtEmpresa);
        }
    }//GEN-LAST:event_TxtEmpresaKeyReleased

    private void TxtDireccionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtDireccionKeyReleased
        if (evt.getKeyCode() != KeyEvent.VK_LEFT && evt.getKeyCode() != KeyEvent.VK_RIGHT && evt.getKeyCode() != KeyEvent.VK_END && evt.getKeyCode() != KeyEvent.VK_HOME && evt.getKeyCode() != KeyEvent.VK_SHIFT && evt.getKeyCode() != KeyEvent.VK_CUT && evt.getKeyCode() != KeyEvent.VK_COPY && evt.getKeyCode() != KeyEvent.VK_PASTE)
        {
            f.SetUpercase_Jtextfield(TxtDireccion);
        }
    }//GEN-LAST:event_TxtDireccionKeyReleased

    private void TxtTelEmpresaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtTelEmpresaKeyReleased
        if (evt.getKeyCode() != KeyEvent.VK_LEFT && evt.getKeyCode() != KeyEvent.VK_RIGHT && evt.getKeyCode() != KeyEvent.VK_END && evt.getKeyCode() != KeyEvent.VK_HOME && evt.getKeyCode() != KeyEvent.VK_SHIFT && evt.getKeyCode() != KeyEvent.VK_CUT && evt.getKeyCode() != KeyEvent.VK_COPY && evt.getKeyCode() != KeyEvent.VK_PASTE)
        {
            f.SetUpercase_Jtextfield(TxtTelEmpresa);
        }
    }//GEN-LAST:event_TxtTelEmpresaKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            if (f.AddProvedor(TxtEmpresa, TxtTelEmpresa, TxtTelResponsable, TxtResponsable, TxtDireccion))
            {
                f.JtextField_SetEmpty(TxtEmpresa);
                f.JtextField_SetEmpty(TxtTelEmpresa);
                f.JtextField_SetEmpty(TxtTelResponsable);
                f.JtextField_SetEmpty(TxtResponsable);
                f.JtextField_SetEmpty(TxtDireccion);
                f.Alert("Provedor agregado");
            }else
            {
                f.Alert("Provedor NO agregado");
            }
        } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            f.Alert(ex.getMessage());
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField TxtDireccion;
    private javax.swing.JTextField TxtEmpresa;
    private javax.swing.JTextField TxtResponsable;
    private javax.swing.JTextField TxtTelEmpresa;
    private javax.swing.JTextField TxtTelResponsable;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
