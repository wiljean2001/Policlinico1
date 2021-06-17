package Vistas;

import java.awt.LayoutManager;


public class Menu1 extends javax.swing.JFrame {

    /**
     * Creates new form Menu
     */
    public Menu1() {
        initComponents();
        this.setLocationRelativeTo(this);
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
        jPanelARRIBA = new javax.swing.JPanel();
        jPanelIzqArriba = new javax.swing.JPanel();
        MovButt_Menu = new javax.swing.JToggleButton();
        Close_button = new javax.swing.JButton();
        jPanelIzq = new javax.swing.JPanel();
        PanelContenedor = new javax.swing.JPanel();
        bttnExtra = new javax.swing.JPanel();
        buttonReg = new RSMaterialComponent.RSButtonMaterialRipple();
        button_Bus = new RSMaterialComponent.RSButtonMaterialRipple();
        bttn_Caja = new RSMaterialComponent.RSButtonMaterialRipple();
        bttn_Extra = new RSMaterialComponent.RSButtonMaterialRipple();
        Foto = new rojerusan.RSFotoSquare();
        buttonMenu = new javax.swing.JButton();
        rSScrollPane1 = new necesario.RSScrollPane();
        jDesktopPaneMenu = new rojeru_san.rspanel.RSDesktopPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(55, 143, 205), 5, true));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelARRIBA.setBackground(new java.awt.Color(55, 143, 205));
        jPanelARRIBA.setPreferredSize(new java.awt.Dimension(230, 65));

        jPanelIzqArriba.setBackground(new java.awt.Color(55, 143, 205));
        jPanelIzqArriba.setBorder(new org.jdesktop.swingx.border.DropShadowBorder());
        jPanelIzqArriba.setDoubleBuffered(false);
        jPanelIzqArriba.setMinimumSize(new java.awt.Dimension(245, 60));
        jPanelIzqArriba.setPreferredSize(new java.awt.Dimension(245, 60));

        MovButt_Menu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos2/lista (1).png"))); // NOI18N
        MovButt_Menu.setBorder(null);
        MovButt_Menu.setContentAreaFilled(false);
        MovButt_Menu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        MovButt_Menu.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        MovButt_Menu.setPreferredSize(new java.awt.Dimension(33, 40));
        MovButt_Menu.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos2/list.png"))); // NOI18N

        javax.swing.GroupLayout jPanelIzqArribaLayout = new javax.swing.GroupLayout(jPanelIzqArriba);
        jPanelIzqArriba.setLayout(jPanelIzqArribaLayout);
        jPanelIzqArribaLayout.setHorizontalGroup(
            jPanelIzqArribaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelIzqArribaLayout.createSequentialGroup()
                .addGap(193, 193, 193)
                .addComponent(MovButt_Menu, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                .addGap(12, 12, 12))
        );
        jPanelIzqArribaLayout.setVerticalGroup(
            jPanelIzqArribaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelIzqArribaLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(MovButt_Menu, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                .addGap(15, 15, 15))
        );

        Close_button.setForeground(new java.awt.Color(255, 255, 255));
        Close_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos2/cancel.png"))); // NOI18N
        Close_button.setToolTipText("Close");
        Close_button.setBorder(null);
        Close_button.setContentAreaFilled(false);
        Close_button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Close_button.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Close_button.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos2/cancel (1).png"))); // NOI18N

        javax.swing.GroupLayout jPanelARRIBALayout = new javax.swing.GroupLayout(jPanelARRIBA);
        jPanelARRIBA.setLayout(jPanelARRIBALayout);
        jPanelARRIBALayout.setHorizontalGroup(
            jPanelARRIBALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelARRIBALayout.createSequentialGroup()
                .addComponent(jPanelIzqArriba, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1588, Short.MAX_VALUE)
                .addComponent(Close_button, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
        jPanelARRIBALayout.setVerticalGroup(
            jPanelARRIBALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelARRIBALayout.createSequentialGroup()
                .addGroup(jPanelARRIBALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(Close_button, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelIzqArriba, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel1.add(jPanelARRIBA, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 1910, 60));

        jPanelIzq.setBackground(new java.awt.Color(55, 143, 205));
        org.jdesktop.swingx.border.DropShadowBorder dropShadowBorder1 = new org.jdesktop.swingx.border.DropShadowBorder();
        dropShadowBorder1.setShowBottomShadow(false);
        jPanelIzq.setBorder(dropShadowBorder1);
        jPanelIzq.setDoubleBuffered(false);
        jPanelIzq.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanelContenedor.setBackground(new java.awt.Color(255, 255, 255));
        PanelContenedor.setName("PanelContenedor"); // NOI18N
        PanelContenedor.setOpaque(false);
        PanelContenedor.setLayout(new java.awt.CardLayout());

        bttnExtra.setBackground(new java.awt.Color(55, 143, 205));
        bttnExtra.setName("bttnExtra"); // NOI18N

        buttonReg.setBackground(new java.awt.Color(55, 143, 205));
        buttonReg.setText("REGISTRAR PACIENTE");
        buttonReg.setToolTipText("Registrar Nuevo Paciente");

        button_Bus.setBackground(new java.awt.Color(55, 143, 205));
        button_Bus.setText("BUSCAR PACIENTE");
        button_Bus.setToolTipText("Buscar, Actualizar y Eliminar Paciente");

        bttn_Caja.setBackground(new java.awt.Color(55, 143, 205));
        bttn_Caja.setText("CAJA");
        bttn_Caja.setToolTipText("Caja");

        bttn_Extra.setBackground(new java.awt.Color(55, 143, 205));
        bttn_Extra.setText("BOLETA");

        javax.swing.GroupLayout bttnExtraLayout = new javax.swing.GroupLayout(bttnExtra);
        bttnExtra.setLayout(bttnExtraLayout);
        bttnExtraLayout.setHorizontalGroup(
            bttnExtraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bttnExtraLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(bttnExtraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonReg, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
                    .addComponent(bttn_Caja, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bttn_Extra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(button_Bus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        bttnExtraLayout.setVerticalGroup(
            bttnExtraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bttnExtraLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(buttonReg, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(button_Bus, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bttn_Caja, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bttn_Extra, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
        );

        PanelContenedor.add(bttnExtra, "card2");

        jPanelIzq.add(PanelContenedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 220, 240, -1));

        Foto.setBorder(null);
        Foto.setAutoscrolls(true);
        Foto.setEnabled(false);
        Foto.setImagenDefault(new javax.swing.ImageIcon(getClass().getResource("/Recursos2/doctor_male_96px.png"))); // NOI18N
        Foto.setInheritsPopupMenu(true);
        Foto.setOpaque(false);
        jPanelIzq.add(Foto, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 170, 150));

        buttonMenu.setForeground(new java.awt.Color(255, 255, 255));
        buttonMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos2/exchange (1).png"))); // NOI18N
        buttonMenu.setToolTipText("Change");
        buttonMenu.setBorder(null);
        buttonMenu.setContentAreaFilled(false);
        buttonMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonMenu.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonMenu.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos2/change.png"))); // NOI18N
        jPanelIzq.add(buttonMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 560, 220, 42));

        jPanel1.add(jPanelIzq, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 65, 250, 1010));

        rSScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        jDesktopPaneMenu.setBackground(new java.awt.Color(255, 255, 255));
        rSScrollPane1.setViewportView(jDesktopPaneMenu);

        jPanel1.add(rSScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(255, 65, 1660, 1010));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1920, 1080));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Menu1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton Close_button;
    public rojerusan.RSFotoSquare Foto;
    public javax.swing.JToggleButton MovButt_Menu;
    public javax.swing.JPanel PanelContenedor;
    public javax.swing.JPanel bttnExtra;
    public RSMaterialComponent.RSButtonMaterialRipple bttn_Caja;
    public RSMaterialComponent.RSButtonMaterialRipple bttn_Extra;
    public javax.swing.JButton buttonMenu;
    public RSMaterialComponent.RSButtonMaterialRipple buttonReg;
    public RSMaterialComponent.RSButtonMaterialRipple button_Bus;
    public rojeru_san.rspanel.RSDesktopPane jDesktopPaneMenu;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JPanel jPanelARRIBA;
    public javax.swing.JPanel jPanelIzq;
    public javax.swing.JPanel jPanelIzqArriba;
    public necesario.RSScrollPane rSScrollPane1;
    // End of variables declaration//GEN-END:variables
}
