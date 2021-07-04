package controlador;

import DAO.Usuario_DAO;
import Interfaces.Mensaje;
import Main.Hospital_v2;
import Vistas.Login;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class cntrlLogin implements ActionListener, KeyListener {

    private Login l;
    private JLabel iconoLog;
    private JButton ingresarButton, closeAll;
    private Usuario_DAO DAO_login = new Usuario_DAO();

    public cntrlLogin(Login l) {
        this.l = l;
        l.setLocationRelativeTo(null);
        
        
        iconoLog = l.jLaberIcon;
        ImageIcon imagenicon = new ImageIcon(
                cntrlLogin.class.getResource("/recursos/hospital-login.gif")
        );
        Icon icono = new ImageIcon(imagenicon.getImage().getScaledInstance(
                iconoLog.getWidth(), iconoLog.getHeight(), Image.SCALE_DEFAULT)
        );
        
        iconoLog.setIcon(icono);
        l.txtContr.addKeyListener(this);
        l.txtUSER.addKeyListener(this);
        ingresarButton = l.jButtonIngresar;
        ingresarButton.addActionListener(this);
        closeAll = l.botton_Close;
        closeAll.addActionListener(this);
    }

    private void BotonIngresar() {

        String usuario = l.txtUSER.getText();
        char[] contraseña = l.txtContr.getPassword();
        String contraseñaString = String.valueOf(contraseña);

        if (l.txtContr.getPassword().length < 4 || usuario.isEmpty()) {
            Mensaje.MensajeError("Error: ¡Campos vacios!", "Error");
        } else {
            try {
                if (DAO_login.BuscarUsuario(usuario, contraseñaString).isPerfil()) {
                    Hospital_v2.FMM.setVisible(true);
                    Hospital_v2.FL.dispose();

                } else if (DAO_login.BuscarUsuario(usuario, contraseñaString).isPerfil() == false) {
                    Hospital_v2.FMR.setVisible(true);
                    Hospital_v2.FL.dispose();
                } else {
                    Mensaje.MensajeError("USUARIO O CONTRASEÑA NO ENCONTRADO", "ERROR");

                }
            } catch (Exception e) {
                Mensaje.MensajeError("USUARIO O CONTRASEÑA NO ENCONTRADO", "ERROR");
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ingresarButton) {
            BotonIngresar();
        }
        if (e.getSource() == closeAll) {
            System.exit(1);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        e.getKeyChar();
        if (KeyEvent.VK_ENTER == e.getKeyChar()) {
            BotonIngresar();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
