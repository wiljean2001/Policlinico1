package controlador;
//hola

import DAO.Usuario_DAO;
import DBO.Usuario;

import javax.swing.JOptionPane;
import static Interfaces.Mensaje.Mensaje;
import Vistas.Login;
import Vistas.MenuMedicos;
import Vistas.MenuRecep;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class cntrlLogin implements ActionListener, KeyListener {

    private Login l = new Login();
    private JLabel iconoLog;
    private JButton ingresarButton, closeAll;
    private MenuMedicos m1 = null;
    private MenuRecep m2 = null;
    private cntrlMenuMedicos cntrlMM = null;
    private cntrlMenuRecep cntrlMR = null;
    private Usuario_DAO DAO_login = new Usuario_DAO();

    public cntrlLogin(Login l) {
        this.l = l;
        m1 = new MenuMedicos();
        m2 = new MenuRecep();
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
        String usuario = l.txtUSER.getText();

        if (l.txtContr.getPassword().length < 4 || usuario.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error: ¡Campos vacios!", "Error", 1);
        } else {
            char[] contraseña = l.txtContr.getPassword();
            String contraseñaString = String.valueOf(contraseña);
            try {
                if (DAO_login.BuscarUsuario(usuario, contraseñaString).isPerfil()) {
                    cntrlMM = new cntrlMenuMedicos(m1);
                    m1.setVisible(true);
                    l.setVisible(false);
                } else if (DAO_login.BuscarUsuario(usuario, contraseñaString).isPerfil() == false) {
                    cntrlMR = new cntrlMenuRecep(m2);
                    m2.setVisible(true);
                    l.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "USUARIO O CONTRASEÑA NO ENCONTRADO");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "USUARIO O CONTRASEÑA NO ENCONTRADO");
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
