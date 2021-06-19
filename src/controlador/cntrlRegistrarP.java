package controlador;

import DAO.RegistrarPac_DAO;
import DBO.Paciente_DBO;
import Vistas.MenuMedicos;
import Vistas.RegistrarP;
import app.bolivia.swing.JCTextField;
import java.awt.Checkbox;
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
import rojeru_san.rsdate.RSDateChooser;

/**
 *
 * @author HP-Litzy-Jean
 */
public class cntrlRegistrarP implements ActionListener, KeyListener {

 //errorrrrrrrrrrrrrrr
    
    
    private JButton button_Reg, button_Limpiar, button_Historial;
    //        String DNI_Paciente, Date FechadeNacimiento, String telefono, String Apellidos, String nombres, String Direccion,
    //        char Sexo, int edad, String EstadoCivil, Image Foto
    private JCTextField DNI, apellidos, nombres, Direccion, telefono;
    private Checkbox SexoH, SexoM, EstadoCivil_Sol, EstadoCivil_Cas, EstadoCivil_viud, EstadoCivil_Div;
    private RSDateChooser FechadeNacimiento;
    
    private RegistrarP r = new RegistrarP();
    private MenuMedicos m = new MenuMedicos();

    public cntrlRegistrarP(RegistrarP r) {
        this.r = r;
        ListenerEventos(r);
    }
//sasasa
    private void ListenerEventos(RegistrarP r) {
        // textfield y otros : --------------------------
        DNI = r.txt_DNI;
        apellidos = r.txt_Apellidos;
        nombres = r.txt_Nombres;
        Direccion = r.txt_Direccion;
        telefono = r.txt_Telefono;
        FechadeNacimiento.getDatoFecha()
        
        DNI.addActionListener(this);
        apellidos.addActionListener(this);
        nombres.addActionListener(this);
        Direccion.addActionListener(this);
        telefono.addActionListener(this);

        // Botones :---------------
        button_Reg = r.ButtonRegistrarP;
        button_Limpiar = r.ButtonLimpiarTodo;
        button_Historial = r.ButtonBuscarPaciente;

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
            apellidos.setText("");
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
