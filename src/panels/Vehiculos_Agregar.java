package panels;

import clases.Funciones;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Cybercafe
 */
public class Vehiculos_Agregar extends javax.swing.JPanel {

    /**
     * Creates new form boceto
     */
    Funciones f = new Funciones();
            
    public Vehiculos_Agregar() {
        initComponents();
        f.JtextField_SetEmpty(TxtKm);
        f.JtextField_SetEmpty(TxtPlacas);
        f.JtextField_SetEmpty(TxtColor);
        f.JtextField_SetEmpty(TxtDepartamento);
        f.JtextField_SetEmpty(TxtModelo);
        try {
            f.Combo_LoadCients(jComboBox1);
        } catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException ex) {
            f.Alert(ex.getMessage());
        }
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
        TxtModelo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        TxtKm = new javax.swing.JTextField();
        TxtPlacas = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        TxtColor = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        TxtDepartamento = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton3 = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(1218, 373));
        setMinimumSize(new java.awt.Dimension(1218, 373));
        setPreferredSize(new java.awt.Dimension(1218, 373));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "NUEVO VEHICULO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N

        TxtModelo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        TxtModelo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TxtModeloKeyReleased(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("MARCA, TIPO Y MODELO");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("KILOMETRAJE");

        TxtKm.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        TxtKm.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TxtKmKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TxtKmKeyReleased(evt);
            }
        });

        TxtPlacas.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        TxtPlacas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TxtPlacasKeyReleased(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("PLACAS");

        TxtColor.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        TxtColor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TxtColorKeyReleased(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("COLOR");

        TxtDepartamento.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        TxtDepartamento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TxtDepartamentoKeyReleased(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("DEPARTAMENTO");

        jComboBox1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(TxtKm, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(TxtPlacas, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TxtColor, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(TxtDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(TxtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(51, 51, 51))
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
                    .addComponent(TxtColor, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtPlacas, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jComboBox1)
                    .addComponent(TxtKm, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(68, Short.MAX_VALUE))
        );

        jButton3.setText("AGREGAR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 873, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void TxtPlacasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtPlacasKeyReleased
        if (evt.getKeyCode() != KeyEvent.VK_LEFT && evt.getKeyCode() != KeyEvent.VK_RIGHT && evt.getKeyCode() != KeyEvent.VK_END && evt.getKeyCode() != KeyEvent.VK_HOME && evt.getKeyCode() != KeyEvent.VK_SHIFT && evt.getKeyCode() != KeyEvent.VK_CUT && evt.getKeyCode() != KeyEvent.VK_COPY && evt.getKeyCode() != KeyEvent.VK_PASTE)
        {
            f.SetUpercase_Jtextfield(TxtPlacas);
        }
    }//GEN-LAST:event_TxtPlacasKeyReleased

    private void TxtColorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtColorKeyReleased
        if (evt.getKeyCode() != KeyEvent.VK_LEFT && evt.getKeyCode() != KeyEvent.VK_RIGHT && evt.getKeyCode() != KeyEvent.VK_END && evt.getKeyCode() != KeyEvent.VK_HOME && evt.getKeyCode() != KeyEvent.VK_SHIFT && evt.getKeyCode() != KeyEvent.VK_CUT && evt.getKeyCode() != KeyEvent.VK_COPY && evt.getKeyCode() != KeyEvent.VK_PASTE)
        {
            f.SetUpercase_Jtextfield(TxtColor);
        }
    }//GEN-LAST:event_TxtColorKeyReleased

    private void TxtDepartamentoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtDepartamentoKeyReleased
        if (evt.getKeyCode() != KeyEvent.VK_LEFT && evt.getKeyCode() != KeyEvent.VK_RIGHT && evt.getKeyCode() != KeyEvent.VK_END && evt.getKeyCode() != KeyEvent.VK_HOME && evt.getKeyCode() != KeyEvent.VK_SHIFT && evt.getKeyCode() != KeyEvent.VK_CUT && evt.getKeyCode() != KeyEvent.VK_COPY && evt.getKeyCode() != KeyEvent.VK_PASTE)
        {
            f.SetUpercase_Jtextfield(TxtDepartamento);
        }
    }//GEN-LAST:event_TxtDepartamentoKeyReleased

    private void TxtModeloKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtModeloKeyReleased
        if (evt.getKeyCode() != KeyEvent.VK_LEFT && evt.getKeyCode() != KeyEvent.VK_RIGHT && evt.getKeyCode() != KeyEvent.VK_END && evt.getKeyCode() != KeyEvent.VK_HOME && evt.getKeyCode() != KeyEvent.VK_SHIFT && evt.getKeyCode() != KeyEvent.VK_CUT && evt.getKeyCode() != KeyEvent.VK_COPY && evt.getKeyCode() != KeyEvent.VK_PASTE)
        {
            f.SetUpercase_Jtextfield(TxtModelo);
        }
    }//GEN-LAST:event_TxtModeloKeyReleased

    private void TxtKmKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtKmKeyReleased
        if (evt.getKeyCode() != KeyEvent.VK_LEFT && evt.getKeyCode() != KeyEvent.VK_RIGHT && evt.getKeyCode() != KeyEvent.VK_END && evt.getKeyCode() != KeyEvent.VK_HOME && evt.getKeyCode() != KeyEvent.VK_SHIFT && evt.getKeyCode() != KeyEvent.VK_CUT && evt.getKeyCode() != KeyEvent.VK_COPY && evt.getKeyCode() != KeyEvent.VK_PASTE)
        {
            f.SetUpercase_Jtextfield(TxtKm);
        }
    }//GEN-LAST:event_TxtKmKeyReleased

    private void TxtKmKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtKmKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
            AddVehiculo();
        }
    }//GEN-LAST:event_TxtKmKeyPressed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            if (f.Vehiculo_Agregar(TxtPlacas, TxtColor, TxtDepartamento, TxtModelo ,TxtKm, jComboBox1))
            {
                f.JtextField_SetEmpty(TxtPlacas);
                f.JtextField_SetEmpty(TxtColor);
                f.JtextField_SetEmpty(TxtDepartamento);
                f.JtextField_SetEmpty(TxtModelo);
                f.JtextField_SetEmpty(TxtKm);
                f.Combo_LoadCients(jComboBox1);
                f.Alert("Vehiculo agregado con exito");
            }
        } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            f.Alert(ex.getMessage());
        }
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField TxtColor;
    private javax.swing.JTextField TxtDepartamento;
    private javax.swing.JTextField TxtKm;
    private javax.swing.JTextField TxtModelo;
    private javax.swing.JTextField TxtPlacas;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    private void AddVehiculo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}