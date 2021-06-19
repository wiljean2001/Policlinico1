package controlador;

import DAO.RegistrarPac_DAO;
import DBO.Paciente_DBO;
import Vistas.MenuMedicos;
import Vistas.RegistrarP;
import app.bolivia.swing.JCTextField;
import java.awt.Checkbox;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import rojeru_san.componentes.RSDateChooser;
import rojerusan.RSFotoSquare;

public class cntrlRegistrarP implements ActionListener, KeyListener {

    private JButton button_Reg, button_Limpiar, button_Historial;
    private JCTextField DNI, apellidos, nombres, Direccion, telefono;
    private JCheckBox SexoH, SexoM, EstadoCivil_Sol, EstadoCivil_Cas, EstadoCivil_viud, EstadoCivil_Div;
    private RSDateChooser FechadeNacimiento;
    private RSFotoSquare Foto;

    private RegistrarP r = new RegistrarP();
    private MenuMedicos m = new MenuMedicos();

    public cntrlRegistrarP(RegistrarP r) {
        this.r = r;
        ListenerEventos(r);
    }

    private void ListenerEventos(RegistrarP r) {
        // textfield y otros : --------------------------
        DNI = r.txt_DNI;
        apellidos = r.txt_Apellidos;
        nombres = r.txt_Nombres;
        Direccion = r.txt_Direccion;
        telefono = r.txt_Telefono;
        FechadeNacimiento = r.Calendar_FechaNac;

        //Checkbox
        SexoH = r.Check_Hombre;
        SexoM = r.Check_Mujer;
        EstadoCivil_Sol = r.Check_Soltero;
        EstadoCivil_Cas = r.Check_Casado;
        EstadoCivil_viud = r.Check_Viudo;
        EstadoCivil_Div = r.Check_Divorciado;

        // Botones :---------------
        button_Reg = r.ButtonRegistrarP;
        button_Limpiar = r.ButtonLimpiarTodo;
        button_Historial = r.ButtonBuscarPaciente;

        button_Reg.addActionListener(this);
        button_Limpiar.addActionListener(this);
        button_Historial.addActionListener(this);
        // Foto Image
        Foto = r.Foto;
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
            apellidos.setText("");
            nombres.setText("");
            Direccion.setText("");
            telefono.setText("");
            FechadeNacimiento.setTextMayusculas(true);
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
        if (e.getSource() == apellidos) {
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
        }*/
    @Override
    public void keyPressed(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
