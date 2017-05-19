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
public class StockAdd extends javax.swing.JPanel {

    /**
     * Creates new form boceto
     */
    Funciones f = new Funciones ();
    
    public StockAdd() {
        try {
            initComponents();
            f.Combo_LoadProvedores(jComboBox1);
        } catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException ex) 
        {
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
        TxtPrecio = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        TxtExistencia = new javax.swing.JTextField();
        TxtCodeBar = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        TxtNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        TxtDescripcion = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(1218, 373));
        setMinimumSize(new java.awt.Dimension(1218, 373));
        setPreferredSize(new java.awt.Dimension(1218, 373));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "NUEVO PRODUCTO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N

        TxtPrecio.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        TxtPrecio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TxtPrecioKeyReleased(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("PRECIO");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("EXISTENCIA");

        TxtExistencia.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        TxtExistencia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TxtExistenciaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TxtExistenciaKeyReleased(evt);
            }
        });

        TxtCodeBar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        TxtCodeBar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TxtCodeBarKeyReleased(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("CODIGO DE BARRA");

        TxtNombre.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        TxtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TxtNombreKeyReleased(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("NOMBRE");

        TxtDescripcion.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        TxtDescripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TxtDescripcionKeyReleased(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("DESCRIPCION");

        jComboBox1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(TxtExistencia, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(TxtCodeBar, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))))
                        .addGap(51, 51, 51))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TxtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(TxtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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
                    .addComponent(TxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtCodeBar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtExistencia, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgBtns/BtnBigAdd.png"))); // NOI18N
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgBtns/BtnBigAddEfc.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 873, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jButton1))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void TxtPrecioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtPrecioKeyReleased
        if (evt.getKeyCode() != KeyEvent.VK_LEFT && evt.getKeyCode() != KeyEvent.VK_RIGHT && evt.getKeyCode() != KeyEvent.VK_END && evt.getKeyCode() != KeyEvent.VK_HOME && evt.getKeyCode() != KeyEvent.VK_SHIFT && evt.getKeyCode() != KeyEvent.VK_CUT && evt.getKeyCode() != KeyEvent.VK_COPY && evt.getKeyCode() != KeyEvent.VK_PASTE)
        {
            f.SetUpercase_Jtextfield(TxtPrecio);
        }
    }//GEN-LAST:event_TxtPrecioKeyReleased

    private void TxtExistenciaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtExistenciaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER)
        {

        }
    }//GEN-LAST:event_TxtExistenciaKeyPressed

    private void TxtExistenciaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtExistenciaKeyReleased
        if (evt.getKeyCode() != KeyEvent.VK_LEFT && evt.getKeyCode() != KeyEvent.VK_RIGHT && evt.getKeyCode() != KeyEvent.VK_END && evt.getKeyCode() != KeyEvent.VK_HOME && evt.getKeyCode() != KeyEvent.VK_SHIFT && evt.getKeyCode() != KeyEvent.VK_CUT && evt.getKeyCode() != KeyEvent.VK_COPY && evt.getKeyCode() != KeyEvent.VK_PASTE)
        {
            f.SetUpercase_Jtextfield(TxtExistencia);
        }
    }//GEN-LAST:event_TxtExistenciaKeyReleased

    private void TxtCodeBarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtCodeBarKeyReleased
        if (evt.getKeyCode() != KeyEvent.VK_LEFT && evt.getKeyCode() != KeyEvent.VK_RIGHT && evt.getKeyCode() != KeyEvent.VK_END && evt.getKeyCode() != KeyEvent.VK_HOME && evt.getKeyCode() != KeyEvent.VK_SHIFT && evt.getKeyCode() != KeyEvent.VK_CUT && evt.getKeyCode() != KeyEvent.VK_COPY && evt.getKeyCode() != KeyEvent.VK_PASTE)
        {
            f.SetUpercase_Jtextfield(TxtCodeBar);
        }
    }//GEN-LAST:event_TxtCodeBarKeyReleased

    private void TxtNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtNombreKeyReleased
        if (evt.getKeyCode() != KeyEvent.VK_LEFT && evt.getKeyCode() != KeyEvent.VK_RIGHT && evt.getKeyCode() != KeyEvent.VK_END && evt.getKeyCode() != KeyEvent.VK_HOME && evt.getKeyCode() != KeyEvent.VK_SHIFT && evt.getKeyCode() != KeyEvent.VK_CUT && evt.getKeyCode() != KeyEvent.VK_COPY && evt.getKeyCode() != KeyEvent.VK_PASTE)
        {
            f.SetUpercase_Jtextfield(TxtNombre);
        }
    }//GEN-LAST:event_TxtNombreKeyReleased

    private void TxtDescripcionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtDescripcionKeyReleased
        if (evt.getKeyCode() != KeyEvent.VK_LEFT && evt.getKeyCode() != KeyEvent.VK_RIGHT && evt.getKeyCode() != KeyEvent.VK_END && evt.getKeyCode() != KeyEvent.VK_HOME && evt.getKeyCode() != KeyEvent.VK_SHIFT && evt.getKeyCode() != KeyEvent.VK_CUT && evt.getKeyCode() != KeyEvent.VK_COPY && evt.getKeyCode() != KeyEvent.VK_PASTE)
        {
            f.SetUpercase_Jtextfield(TxtDescripcion);
        }
    }//GEN-LAST:event_TxtDescripcionKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            if (f.Product_Add(TxtCodeBar, TxtNombre, TxtDescripcion, TxtPrecio, TxtExistencia, jComboBox1))
            {
                f.JtextField_SetEmpty(TxtCodeBar);
                f.JtextField_SetEmpty(TxtNombre);
                f.JtextField_SetEmpty(TxtDescripcion);
                f.JtextField_SetEmpty(TxtPrecio);
                f.JtextField_SetEmpty(TxtExistencia);
                f.Combo_LoadProvedores(jComboBox1);
                f.Alert("Producto agregado con exito");
            }
        } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            f.Alert(ex.getMessage());
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField TxtCodeBar;
    private javax.swing.JTextField TxtDescripcion;
    private javax.swing.JTextField TxtExistencia;
    private javax.swing.JTextField TxtNombre;
    private javax.swing.JTextField TxtPrecio;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}