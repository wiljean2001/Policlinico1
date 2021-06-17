package controlador;

import DAO.RegistrarPac_DAO;
import DBO.Paciente_DBO;
import Vistas.Menu1;
import Vistas.RegistrarP;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author HP-Litzy-Jean
 */
public class cntrlRegP implements ActionListener, KeyListener {

    private JButton button_Reg, button_Limpiar, button_Historial;
    private JTextField DNI, Nom_Apll, Dir;

    private RegistrarP r = new RegistrarP();
    private Menu1 m = new Menu1();

    public cntrlRegP(RegistrarP r) {
        this.r = r;
        ListenerEventos(r);
    }

    private void ListenerEventos(RegistrarP r) {
        // TextField : --------------------------
        DNI = r.txtDNI;
        Nom_Apll = r.txtNombre_Apellidos;
        Dir = r.txtDireccion;

        DNI.addKeyListener(this);
        Nom_Apll.addKeyListener(this);
        Dir.addKeyListener(this);

        // Botones :---------------
        button_Reg = r.ButtonIngresar;
        button_Limpiar = r.ButtonLimpiarTodo;
        button_Historial = r.ButtonHIstorialCLinico;

        button_Reg.addActionListener(this);
        button_Limpiar.addActionListener(this);
        button_Historial.addActionListener(this);
        // CheckBox
    }

    private void bottonRegistrar() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button_Reg) {
            bottonRegistrar();
        }
        if (e.getSource() == button_Limpiar) {
            DNI.setText("");
            Nom_Apll.setText("");
            Dir.setText("");
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //Solo Numeros
        char a = 0;

        if (e.getSource() == DNI) {
            if (DNI.getText().length() < 8) {
                a = e.getKeyChar();
                if (!Character.isDigit(a)) {
                    e.consume();
                }
            } else {
                e.consume();
            }
        }
        // Solo Letras
        if (e.getSource() == Nom_Apll) {
            a = e.getKeyChar();
            if (!Character.isAlphabetic(a) && !Character.isSpaceChar(a)) {
                e.consume();

            }
        }

        e.getKeyChar();
        if (e.getKeyChar() == KeyEvent.VK_ENTER) {
            bottonRegistrar();
        }

    }

    /*
    private boolean CasillasVacias() {
        if (Validar_CheckTarjeta() == false) {
            // todos los textfield  DNI, Nom_Apll, Dir, CP, NumTarj, CodSeguridad;

            if (DNI.getText().isEmpty() || Nom_Apll.getText().isEmpty() || Dir.getText().isEmpty()
                    || CP.getText().isEmpty() || NumTarj.getText().isEmpty() || CodSeguridad.getText().isEmpty()) {
                Check_CasillasVac.setSelected(true);
                return false;
            } else {
                Check_CasillasVac.setSelected(false);
            }
            return true;
        } else {
            // solo editables
            if (DNI.getText().isEmpty() || Nom_Apll.getText().isEmpty() || Dir.getText().isEmpty()) {
                Check_CasillasVac.setSelected(true);
                return false;
            }
            Check_CasillasVac.setSelected(false);
            return true;
        }
    }
     */
    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

}
