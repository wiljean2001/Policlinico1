/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

/**
 *
 * @author wil-laptop
 */
public class ActualizarP extends javax.swing.JInternalFrame {

    /**
     * Creates new form ActualizarP
     */
    public ActualizarP() {
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
        jLabel1 = new javax.swing.JLabel();
        rSFotoSquare1 = new rojerusan.RSFotoSquare();
        jPanel2 = new javax.swing.JPanel();
        Check_Hombre = new RSMaterialComponent.RSCheckBoxMaterial();
        Check_Mujer = new RSMaterialComponent.RSCheckBoxMaterial();
        jPanel4 = new javax.swing.JPanel();
        Check_TarjetaActivar = new RSMaterialComponent.RSCheckBoxMaterial();
        Check_TarjetaActivar1 = new RSMaterialComponent.RSCheckBoxMaterial();
        Check_TarjetaActivar2 = new RSMaterialComponent.RSCheckBoxMaterial();
        Check_TarjetaActivar3 = new RSMaterialComponent.RSCheckBoxMaterial();
        txtDNI = new app.bolivia.swing.JCTextField();
        txtNombre_Apellidos = new app.bolivia.swing.JCTextField();
        txtDireccion = new app.bolivia.swing.JCTextField();
        txt_tarjetaCP = new app.bolivia.swing.JCTextField();
        ButtonIngresar = new rojeru_san.RSButtonRiple();
        ButtonLimpiarTodo = new rojeru_san.RSButtonRiple();
        ButtonHIstorialCLinico = new rojeru_san.RSButtonRiple();
        rSDateChooser1 = new rojeru_san.componentes.RSDateChooser();

        setTitle("Actualizar Paciente");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ACTUALIZAR PACIENTE");

        rSFotoSquare1.setBorder(null);
        rSFotoSquare1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Sexo"));

        Check_Hombre.setSelected(true);
        Check_Hombre.setText("HOMBRE");
        Check_Hombre.setIsEffectRipple(false);
        Check_Hombre.setThemeTooltip(necesario.Global.THEMETOOLTIP.LIGHT);

        Check_Mujer.setText("MUJER");
        Check_Mujer.setIsEffectRipple(false);
        Check_Mujer.setThemeTooltip(necesario.Global.THEMETOOLTIP.LIGHT);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Check_Hombre, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(Check_Mujer, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(Check_Hombre, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Check_Mujer, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Estado Civil"));

        Check_TarjetaActivar.setSelected(true);
        Check_TarjetaActivar.setText("Soltero");
        Check_TarjetaActivar.setIsEffectRipple(false);
        Check_TarjetaActivar.setThemeTooltip(necesario.Global.THEMETOOLTIP.LIGHT);

        Check_TarjetaActivar1.setText("Casado");
        Check_TarjetaActivar1.setIsEffectRipple(false);
        Check_TarjetaActivar1.setThemeTooltip(necesario.Global.THEMETOOLTIP.LIGHT);

        Check_TarjetaActivar2.setText("Viudo");
        Check_TarjetaActivar2.setIsEffectRipple(false);
        Check_TarjetaActivar2.setThemeTooltip(necesario.Global.THEMETOOLTIP.LIGHT);

        Check_TarjetaActivar3.setText("Divorciado");
        Check_TarjetaActivar3.setIsEffectRipple(false);
        Check_TarjetaActivar3.setThemeTooltip(necesario.Global.THEMETOOLTIP.LIGHT);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Check_TarjetaActivar, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Check_TarjetaActivar1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Check_TarjetaActivar3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(Check_TarjetaActivar2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(Check_TarjetaActivar, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Check_TarjetaActivar1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(Check_TarjetaActivar2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Check_TarjetaActivar3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtDNI.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDNI.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtDNI.setPlaceholder("DNI:        Ej.  73889322");

        txtNombre_Apellidos.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNombre_Apellidos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtNombre_Apellidos.setPlaceholder("NOMBRES:        Ej.  Wilmer Jean Pierre");

        txtDireccion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDireccion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtDireccion.setPlaceholder("DIRECCIÓN:        Ej.  Calle Tacna 105 - La Union");

        txt_tarjetaCP.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_tarjetaCP.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_tarjetaCP.setPlaceholder("APELLIDOS:      Ej.  Ayala García");

        ButtonIngresar.setBorder(null);
        ButtonIngresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/add_user_male_52px.png"))); // NOI18N
        ButtonIngresar.setText("ACTUALIZAR");
        ButtonIngresar.setToolTipText("Click para guardar paciente");
        ButtonIngresar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        ButtonLimpiarTodo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        ButtonLimpiarTodo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/broom_52px.png"))); // NOI18N
        ButtonLimpiarTodo.setToolTipText("Click para guardar paciente");
        ButtonLimpiarTodo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        ButtonHIstorialCLinico.setBorder(null);
        ButtonHIstorialCLinico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/list_view_52px.png"))); // NOI18N
        ButtonHIstorialCLinico.setText("HISTORIAL CLÍNICO");
        ButtonHIstorialCLinico.setToolTipText("Cama de hospitalización");
        ButtonHIstorialCLinico.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        rSDateChooser1.setPlaceholder("FECHA DE NAC.");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtNombre_Apellidos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_tarjetaCP, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(ButtonLimpiarTodo, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(txtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(rSDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(rSFotoSquare1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ButtonIngresar, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                            .addComponent(ButtonHIstorialCLinico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(rSFotoSquare1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(rSDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(txt_tarjetaCP, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtNombre_Apellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(ButtonLimpiarTodo, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(ButtonHIstorialCLinico, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(ButtonIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)))
                        .addGap(85, 85, 85))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public rojeru_san.RSButtonRiple ButtonHIstorialCLinico;
    public rojeru_san.RSButtonRiple ButtonIngresar;
    public rojeru_san.RSButtonRiple ButtonLimpiarTodo;
    public RSMaterialComponent.RSCheckBoxMaterial Check_Hombre;
    public RSMaterialComponent.RSCheckBoxMaterial Check_Mujer;
    public RSMaterialComponent.RSCheckBoxMaterial Check_TarjetaActivar;
    public RSMaterialComponent.RSCheckBoxMaterial Check_TarjetaActivar1;
    public RSMaterialComponent.RSCheckBoxMaterial Check_TarjetaActivar2;
    public RSMaterialComponent.RSCheckBoxMaterial Check_TarjetaActivar3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private rojeru_san.componentes.RSDateChooser rSDateChooser1;
    public rojerusan.RSFotoSquare rSFotoSquare1;
    public app.bolivia.swing.JCTextField txtDNI;
    public app.bolivia.swing.JCTextField txtDireccion;
    public app.bolivia.swing.JCTextField txtNombre_Apellidos;
    public app.bolivia.swing.JCTextField txt_tarjetaCP;
    // End of variables declaration//GEN-END:variables
}
