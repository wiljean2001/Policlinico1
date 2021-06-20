/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

/**
 *
 * @author HP-Litzy-Jean
 */
public class RegistrarP extends javax.swing.JInternalFrame {

    /**
     * Creates new form Registrar
     */
    public RegistrarP() {
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

        SEXO_GROUP = new javax.swing.ButtonGroup();
        EstadoCIvil = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Foto = new rojerusan.RSFotoSquare();
        jPanel2 = new javax.swing.JPanel();
        Check_Hombre = new RSMaterialComponent.RSCheckBoxMaterial();
        Check_Mujer = new RSMaterialComponent.RSCheckBoxMaterial();
        jPanel4 = new javax.swing.JPanel();
        Check_Soltero = new RSMaterialComponent.RSCheckBoxMaterial();
        Check_Casado = new RSMaterialComponent.RSCheckBoxMaterial();
        Check_Viudo = new RSMaterialComponent.RSCheckBoxMaterial();
        Check_Divorciado = new RSMaterialComponent.RSCheckBoxMaterial();
        txt_DNI = new app.bolivia.swing.JCTextField();
        txt_Nombres = new app.bolivia.swing.JCTextField();
        txt_Direccion = new app.bolivia.swing.JCTextField();
        txt_Apellidos = new app.bolivia.swing.JCTextField();
        ButtonRegistrarP = new rojeru_san.RSButtonRiple();
        ButtonLimpiarTodo = new rojeru_san.RSButtonRiple();
        ButtonBuscarPaciente = new rojeru_san.RSButtonRiple();
        txt_Telefono = new app.bolivia.swing.JCTextField();
        Calendar_FechaNac = new rojeru_san.componentes.RSDateChooser();

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setTitle("Registrar");
        setDoubleBuffered(true);
        setMaximumSize(new java.awt.Dimension(836, 479));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("REGISTRAR PACIENTE");

        Foto.setBorder(null);
        Foto.setToolTipText("Click para cargar una imagen");
        Foto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Sexo"));

        SEXO_GROUP.add(Check_Hombre);
        Check_Hombre.setSelected(true);
        Check_Hombre.setText("HOMBRE");
        Check_Hombre.setIsEffectRipple(false);
        Check_Hombre.setThemeTooltip(necesario.Global.THEMETOOLTIP.LIGHT);

        SEXO_GROUP.add(Check_Mujer);
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

        EstadoCIvil.add(Check_Soltero);
        Check_Soltero.setSelected(true);
        Check_Soltero.setText("Soltero");
        Check_Soltero.setIsEffectRipple(false);
        Check_Soltero.setThemeTooltip(necesario.Global.THEMETOOLTIP.LIGHT);

        EstadoCIvil.add(Check_Casado);
        Check_Casado.setText("Casado");
        Check_Casado.setIsEffectRipple(false);
        Check_Casado.setThemeTooltip(necesario.Global.THEMETOOLTIP.LIGHT);

        EstadoCIvil.add(Check_Viudo);
        Check_Viudo.setText("Viudo");
        Check_Viudo.setIsEffectRipple(false);
        Check_Viudo.setThemeTooltip(necesario.Global.THEMETOOLTIP.LIGHT);

        EstadoCIvil.add(Check_Divorciado);
        Check_Divorciado.setText("Divorciado");
        Check_Divorciado.setIsEffectRipple(false);
        Check_Divorciado.setThemeTooltip(necesario.Global.THEMETOOLTIP.LIGHT);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Check_Soltero, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Check_Casado, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Check_Divorciado, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(Check_Viudo, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(Check_Soltero, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Check_Casado, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(Check_Viudo, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Check_Divorciado, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txt_DNI.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_DNI.setToolTipText("DNI");
        txt_DNI.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_DNI.setPlaceholder("DNI:        Ej.  73889322");

        txt_Nombres.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_Nombres.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_Nombres.setPlaceholder("NOMBRES:        Ej.  Wilmer Jean Pierre");

        txt_Direccion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_Direccion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_Direccion.setPlaceholder("DIRECCIÓN:     Ej.  Calle Tacna 105 - La Union");

        txt_Apellidos.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_Apellidos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_Apellidos.setPlaceholder("APELLIDOS:      Ej.  Ayala García");

        ButtonRegistrarP.setBorder(null);
        ButtonRegistrarP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/add_user_male_52px.png"))); // NOI18N
        ButtonRegistrarP.setText("REGISTRAR PACIENTE");
        ButtonRegistrarP.setToolTipText("Click para registrar paciente");
        ButtonRegistrarP.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        ButtonLimpiarTodo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        ButtonLimpiarTodo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/broom_52px.png"))); // NOI18N
        ButtonLimpiarTodo.setToolTipText("Click para guardar paciente");
        ButtonLimpiarTodo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        ButtonBuscarPaciente.setBorder(null);
        ButtonBuscarPaciente.setText("REGISTRAR HISTORIAL CLÍNICO");
        ButtonBuscarPaciente.setToolTipText("Click para registrar historial clínico");
        ButtonBuscarPaciente.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        txt_Telefono.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_Telefono.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_Telefono.setPlaceholder("TELÉFONO:       Ej.  953433761");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 521, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_Apellidos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_Nombres, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(txt_DNI, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(Calendar_FechaNac, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(txt_Direccion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_Telefono, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(12, 12, 12)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(ButtonLimpiarTodo, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Foto, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ButtonBuscarPaciente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ButtonRegistrarP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(2, 2, 2)))
                .addGap(30, 30, 30))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txt_DNI, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Calendar_FechaNac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addComponent(txt_Apellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txt_Nombres, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Foto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(txt_Direccion, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(ButtonBuscarPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txt_Telefono, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(ButtonLimpiarTodo, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(ButtonRegistrarP, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public rojeru_san.RSButtonRiple ButtonBuscarPaciente;
    public rojeru_san.RSButtonRiple ButtonLimpiarTodo;
    public rojeru_san.RSButtonRiple ButtonRegistrarP;
    public rojeru_san.componentes.RSDateChooser Calendar_FechaNac;
    public RSMaterialComponent.RSCheckBoxMaterial Check_Casado;
    public RSMaterialComponent.RSCheckBoxMaterial Check_Divorciado;
    public RSMaterialComponent.RSCheckBoxMaterial Check_Hombre;
    public RSMaterialComponent.RSCheckBoxMaterial Check_Mujer;
    public RSMaterialComponent.RSCheckBoxMaterial Check_Soltero;
    public RSMaterialComponent.RSCheckBoxMaterial Check_Viudo;
    private javax.swing.ButtonGroup EstadoCIvil;
    public rojerusan.RSFotoSquare Foto;
    private javax.swing.ButtonGroup SEXO_GROUP;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    public app.bolivia.swing.JCTextField txt_Apellidos;
    public app.bolivia.swing.JCTextField txt_DNI;
    public app.bolivia.swing.JCTextField txt_Direccion;
    public app.bolivia.swing.JCTextField txt_Nombres;
    public app.bolivia.swing.JCTextField txt_Telefono;
    // End of variables declaration//GEN-END:variables
}
