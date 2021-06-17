package controlador;

import DAO.Login_DAO;
import Vistas.Login;
import Vistas.Menu2;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author HP-Litzy-Jean
 */
public class cntrlLogin implements ActionListener, KeyListener {

    private Login l = new Login();
    private JLabel iconoLog;
    private JButton ingresarButton, closeAll;
    public static String USUARIO;
    private Menu2 m = null;
    private cntrlMenu2 cntrlM = null;

    public cntrlLogin(Login l) {
        this.l = l;
        m = new Menu2();
        l.setLocationRelativeTo(null);
        iconoLog = l.jLaberIcon;
        ImageIcon imagenicon = new ImageIcon(cntrlLogin.class.getResource("/recursos/hospital-login.gif"));
        Icon icono = new ImageIcon(imagenicon.getImage().getScaledInstance(iconoLog.getWidth(), iconoLog.getHeight(), Image.SCALE_DEFAULT));
        iconoLog.setIcon(icono);

        l.txtContr.addKeyListener(this);
        l.txtUSER.addKeyListener(this);
        ingresarButton = l.jButtonIngresar;
        ingresarButton.addActionListener(this);
        closeAll = l.botton_Close;
        closeAll.addActionListener(this);
    }

    private void BotonIngresar() {
        Login_DAO l_DAO;
        l.dispose();
        cntrlM = new cntrlMenu2(m);
        m.setVisible(true);
        /*
        cntrlM = new cntrlMenu(m);
        m.setVisible(true);
        l_DAO = null;
        l = null;
        
        /*char[] contraseña = l.txtContr.getPassword();
        String contraseñaString = String.valueOf(contraseña);
        if (l.txtContr.getPassword().length < 5 || l.txtUSER.getText().isEmpty()) {
            l.txtUSER.setBackground(java.awt.Color.red);
            l.txtUSER.setForeground(java.awt.Color.white);
            l.txtContr.setBackground(java.awt.Color.red);
            l.txtContr.setForeground(java.awt.Color.white);
        } else {
            l_DAO = new Login_DAO();
            Login_DBO login_DBO = new Login_DBO(l.txtUSER.getText(), contraseñaString);

            if (login_DBO.getContraseña().equals(l_DAO.Read(login_DBO.getUsuario()).getContraseña())) {
                USUARIO = l.txtUSER.getText();
                l.dispose();
                cntrlM = new cntrlMenu(m);
                m.setVisible(true);
                l_DAO = null;
                l = null;
            } else {
                l.txtUSER.setBackground(java.awt.Color.red);
                l.txtUSER.setForeground(java.awt.Color.white);
                l.txtContr.setBackground(java.awt.Color.red);
                l.txtContr.setForeground(java.awt.Color.white);
            }
        }
         */
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
        } else {
            if (l.txtUSER.getForeground() == java.awt.Color.white) {
                l.txtUSER.setBackground(new java.awt.Color(244, 244, 244));
                l.txtContr.setBackground(new java.awt.Color(244, 244, 244));
                l.txtUSER.setForeground(java.awt.Color.black);
                l.txtContr.setForeground(java.awt.Color.black);
            }
        }

    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
