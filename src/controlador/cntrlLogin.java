package controlador;

import DAO.Usuario_DAO;
import Interfaces.Mensaje;
import Main.Hospital_v2;
import Vistas.Login;
import java.awt.Desktop;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class cntrlLogin implements ActionListener, KeyListener {

    private Login l;
    private JLabel iconoLog;
    private JButton ingresarButton, closeAll, BuscNav, BuscIns, BuscFacebook;
    private Usuario_DAO DAO_login = null;

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

        BuscNav = l.BuscarNav;
        BuscIns = l.BuscarInstag;
        BuscFacebook = l.BuscarFacebook;

        l.txtUSER.addKeyListener(this);
        BuscNav.addActionListener(this);
        BuscIns.addActionListener(this);
        BuscFacebook.addActionListener(this);

    }

    private void BotonIngresar() {

        String usuario = l.txtUSER.getText();
        char[] contraseña = l.txtContr.getPassword();
        String contraseñaString = String.valueOf(contraseña);

        if (l.txtContr.getPassword().length < 5 && l.txtContr.getPassword().length > 10
                && usuario.length() < 5 && usuario.length() > 10) {

            if (usuario.isEmpty()) {
                Mensaje.MensajeError("Error: ¡Campos vacios!", "Error");
            } else {
                Mensaje.MensajeError("USUARIO O CONTRASEÑA NO ENCONTRADO", "ERROR");
            }
        } else {
            try {
                DAO_login = new Usuario_DAO();
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
            DAO_login = null;
        }
        if (e.getSource() == closeAll) {
            System.exit(1);
        }
        try {
            if (e.getSource() == BuscNav) {

                Abrir_URL("https://www.google.com");
            }
            if (e.getSource() == BuscIns) {

                Abrir_URL("https://www.instagram.com");
            }
            if (e.getSource() == BuscFacebook) {

                Abrir_URL("https://www.facebook.com");
            }
        } catch (URISyntaxException ex) {
            Logger.getLogger(cntrlLogin.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {
        e.getKeyChar();
        if (KeyEvent.VK_ENTER == e.getKeyChar()) {
            BotonIngresar();
            DAO_login = null;
        }
        char a = 0;
        a = e.getKeyChar();
        if (e.getSource() == l.txtUSER) {
            if (Character.isAlphabetic(a) || (a < '0' || a > '9')) {

            } else {
                e.consume();
                Toolkit.getDefaultToolkit().beep();
            }

        } 

    }

    private void Abrir_URL(String url) throws URISyntaxException {
        if (Desktop.isDesktopSupported()) {
            Desktop desktop = Desktop.getDesktop();
            try {
                URI uri = new URI(url);
                desktop.browse(uri);
            } catch (IOException e) {
                System.err.println("Error: No se pudo abrir el enlace" + e.getMessage());
            }
        } else {
            System.err.println("Error: No se puede abrir enlaces web.");
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
