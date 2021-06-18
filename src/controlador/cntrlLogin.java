package controlador;
//hola
import DAO.Login_DAO;
import DBO.Medicos;
import DBO.Recepcionista;
import Vistas.Login;
import Vistas.MenuMedicos;
import Vistas.MenuRecep;
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
    private Login_DAO DAO_login = new Login_DAO();

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

        if (l.txtContr.getPassword().length < 2 || l.txtUSER.getText().isEmpty()) {
            JOptionPane.showConfirmDialog(null, "Error", "Error: ¡Campos vacios!", 1);
        } else {
            char[] contraseña = l.txtContr.getPassword();
            String contraseñaString = String.valueOf(contraseña);

            Medicos medicos;
            medicos = DAO_login.ReadMedicos(l.txtUSER.getText());

            if (medicos != null) {
                if (medicos.getComtraseña().equals(contraseñaString)) {
                    cntrlMM = new cntrlMenuMedicos(m1);
                    m1.setVisible(true);
                    l.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Contraseña Incorrecta");
                }
            } else {
                Recepcionista recepcionista;
                recepcionista = DAO_login.ReadRecepcionista(l.txtUSER.getText());
                if (recepcionista.getComtraseña().equals(contraseñaString)) {
                    cntrlMR = new cntrlMenuRecep(m2);
                    m2.setVisible(true);
                    l.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Contraseña Incorrecta");
                }
            }
        }

        /*
        Login_DAO l_DAO;
        l.dispose();
        cntrlM = new cntrlMenuRecep(m);
        m.setVisible(true);
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
        }

    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
