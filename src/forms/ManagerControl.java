/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import clases.Funciones;

/**
 *
 * @author lypef
 */
public class ManagerControl extends javax.swing.JFrame {

    /**
     * Creates new form ManagerControl
     */
    
    Funciones f = new Funciones();
    Manager m = new Manager();
    
    public ManagerControl() {
        initComponents();
        f.SetModelForm(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BtnClientes = new javax.swing.JButton();
        BtnClientes1 = new javax.swing.JButton();
        BtnClientes2 = new javax.swing.JButton();
        BtnClientes3 = new javax.swing.JButton();
        BtnClientes4 = new javax.swing.JButton();
        BtnClientes5 = new javax.swing.JButton();
        BtnClientes6 = new javax.swing.JButton();
        BtnClientes7 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximizedBounds(new java.awt.Rectangle(940, 380, 360, 360));
        setMinimumSize(new java.awt.Dimension(940, 380));

        BtnClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgBtns/BtnClientes.png"))); // NOI18N
        BtnClientes.setBorder(null);
        BtnClientes.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgBtns/BtnClientesEfc.png"))); // NOI18N
        BtnClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnClientesActionPerformed(evt);
            }
        });

        BtnClientes1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgBtns/BtnVehiculos.png"))); // NOI18N
        BtnClientes1.setBorder(null);
        BtnClientes1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgBtns/BtnVehiculosEfc.png"))); // NOI18N
        BtnClientes1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnClientes1ActionPerformed(evt);
            }
        });

        BtnClientes2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgBtns/BtnServicios.png"))); // NOI18N
        BtnClientes2.setBorder(null);
        BtnClientes2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgBtns/BtnServiciosEfc.png"))); // NOI18N
        BtnClientes2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnClientes2ActionPerformed(evt);
            }
        });

        BtnClientes3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgBtns/BtnStock.png"))); // NOI18N
        BtnClientes3.setBorder(null);
        BtnClientes3.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgBtns/BtnStockEfc.png"))); // NOI18N
        BtnClientes3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnClientes3ActionPerformed(evt);
            }
        });

        BtnClientes4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgBtns/BtnInventario.png"))); // NOI18N
        BtnClientes4.setBorder(null);
        BtnClientes4.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgBtns/BtnInventarioEfc.png"))); // NOI18N
        BtnClientes4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnClientes4ActionPerformed(evt);
            }
        });

        BtnClientes5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgBtns/BtnProvedores.png"))); // NOI18N
        BtnClientes5.setBorder(null);
        BtnClientes5.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgBtns/BtnProvedoresEfc.png"))); // NOI18N
        BtnClientes5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnClientes5ActionPerformed(evt);
            }
        });

        BtnClientes6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgBtns/BtnuSUARIOS.png"))); // NOI18N
        BtnClientes6.setBorder(null);
        BtnClientes6.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgBtns/BtnuSUARIOSEfc.png"))); // NOI18N
        BtnClientes6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnClientes6ActionPerformed(evt);
            }
        });

        BtnClientes7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgBtns/BtnAjustes.png"))); // NOI18N
        BtnClientes7.setBorder(null);
        BtnClientes7.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgBtns/BtnAjustesEfc.png"))); // NOI18N
        BtnClientes7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnClientes7ActionPerformed(evt);
            }
        });

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/file.png"))); // NOI18N
        jMenu1.setText("Archivo");

        jMenuItem10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/point.png"))); // NOI18N
        jMenuItem10.setText("Bloquear");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem10);

        jMenuBar1.add(jMenu1);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/clients.png"))); // NOI18N
        jMenu2.setText("Clientes");

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/point.png"))); // NOI18N
        jMenuItem1.setText("Nuevo");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/point.png"))); // NOI18N
        jMenuItem2.setText("Consultar");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);
        jMenu2.add(jSeparator2);

        jMenuBar1.add(jMenu2);

        jMenu6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/car.png"))); // NOI18N
        jMenu6.setText("Vehiculos");

        jMenuItem11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/point.png"))); // NOI18N
        jMenuItem11.setText("Agregar");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem11);

        jMenuItem12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/point.png"))); // NOI18N
        jMenuItem12.setText("Consultar");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem12);

        jMenuBar1.add(jMenu6);

        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/service.png"))); // NOI18N
        jMenu3.setText("Servicios");
        jMenu3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenu3MousePressed(evt);
            }
        });
        jMenuBar1.add(jMenu3);

        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/inventory.png"))); // NOI18N
        jMenu4.setText("Productos");

        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/point.png"))); // NOI18N
        jMenuItem5.setText("Nuevo");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem5);

        jMenuItem6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/point.png"))); // NOI18N
        jMenuItem6.setText("Consultar");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem6);
        jMenu4.add(jSeparator1);

        jMenuItem9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/point.png"))); // NOI18N
        jMenuItem9.setText("Inventario");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem9);

        jMenuBar1.add(jMenu4);

        jMenu5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/provedores.png"))); // NOI18N
        jMenu5.setText("Provedores");

        jMenuItem7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/point.png"))); // NOI18N
        jMenuItem7.setText("Nuevo");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem7);

        jMenuItem8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/point.png"))); // NOI18N
        jMenuItem8.setText("Consultar");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem8);

        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BtnClientes2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BtnClientes)
                    .addComponent(BtnClientes1))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BtnClientes3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BtnClientes5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnClientes7))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BtnClientes4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnClientes6)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BtnClientes4)
                            .addComponent(BtnClientes6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BtnClientes3)
                            .addComponent(BtnClientes5)
                            .addComponent(BtnClientes7)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(BtnClientes2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(BtnClientes)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(BtnClientes1))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        ShowClientes_Agregar();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        ShowClientes_Consultar();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        ShowVehiculos_Agregar();
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
        ShowVehiculos_Consultar();
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        ShowStock_Agregar();
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        ShowStock_Consultar();
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        ShowProvedores_Agregar();
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        ShowProvedores_Consultar();
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void BtnClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnClientesActionPerformed
        ShowClientes_Consultar();
    }//GEN-LAST:event_BtnClientesActionPerformed

    private void BtnClientes1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnClientes1ActionPerformed
        ShowVehiculos_Consultar();
    }//GEN-LAST:event_BtnClientes1ActionPerformed

    private void BtnClientes4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnClientes4ActionPerformed
        ShowStock_Consultar();
    }//GEN-LAST:event_BtnClientes4ActionPerformed

    private void BtnClientes3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnClientes3ActionPerformed
        Inventory();
    }//GEN-LAST:event_BtnClientes3ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        Inventory();
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void BtnClientes5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnClientes5ActionPerformed
        ShowProvedores_Consultar();
    }//GEN-LAST:event_BtnClientes5ActionPerformed

    private void BtnClientes6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnClientes6ActionPerformed
        ShowUsers();
    }//GEN-LAST:event_BtnClientes6ActionPerformed

    private void BtnClientes7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnClientes7ActionPerformed
        ShowAjustes();
    }//GEN-LAST:event_BtnClientes7ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        Bloquear();
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void BtnClientes2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnClientes2ActionPerformed
        this.dispose();
        Service form = new Service();
        form.show();
    }//GEN-LAST:event_BtnClientes2ActionPerformed

    private void jMenu3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu3MousePressed
        this.dispose();
        Service form = new Service();
        form.show();
    }//GEN-LAST:event_jMenu3MousePressed

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
            java.util.logging.Logger.getLogger(ManagerControl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManagerControl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManagerControl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManagerControl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManagerControl().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnClientes;
    private javax.swing.JButton BtnClientes1;
    private javax.swing.JButton BtnClientes2;
    private javax.swing.JButton BtnClientes3;
    private javax.swing.JButton BtnClientes4;
    private javax.swing.JButton BtnClientes5;
    private javax.swing.JButton BtnClientes6;
    private javax.swing.JButton BtnClientes7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    // End of variables declaration//GEN-END:variables

    private void ShowClientes_Agregar() {
        this.dispose();
        m.ShowClientes_Agregar();
        m.show();
    }

    private void ShowClientes_Consultar() {
        this.dispose();
        m.ShowClientes_Consultar();
        m.show();
    }

    private void ShowVehiculos_Agregar() {
        this.dispose();
        m.ShowVehiculos_Agregar();
        m.show();
    }

    private void ShowVehiculos_Consultar() {
        this.dispose();
        m.ShowVehiculos_Consultar();
        m.show();
    }

    private void ShowStock_Agregar() {
        this.dispose();
        m.ShowStock_Agregar();
        m.show();
    }

    private void ShowStock_Consultar() {
        this.dispose();
        m.ShowStock_Consultar();
        m.show();
    }

    private void ShowProvedores_Agregar() {
        this.dispose();
        m.ShowProvedores_Agregar();
        m.show();
    }

    private void ShowProvedores_Consultar() {
        this.dispose();
        m.ShowProvedores_Consultar();
        m.show();
    }

    private void Inventory() {
        this.dispose();
        m.Inventory();
        m.show();
    }

    private void ShowUsers() {
        this.dispose();
        m.Users();
        m.show();
    }

    private void Bloquear() {
        this.dispose();
        Login form = new Login();
        form.show();
    }

    private void ShowAjustes() {
        this.dispose();
        m.ShowAjustes();
        m.show();
    }
}
