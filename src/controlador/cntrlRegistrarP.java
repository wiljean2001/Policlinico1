package controlador;

import DAO.Paciente_DAO;
import DBO.Paciente_DBO;
import Vistas.MenuMedicos;
import Vistas.RegistrarP;
import app.bolivia.swing.JCTextField;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import rojeru_san.componentes.RSDateChooser;
import rojerusan.RSFotoSquare;
import java.nio.file.Files;
import java.io.File;

public class cntrlRegistrarP implements KeyListener, MouseListener {

    private JButton button_Reg, button_Limpiar;
    private JCTextField DNI, apellidos, nombres, Direccion, telefono;
    private JCheckBox SexoH, SexoM, EstadoCivil_Sol, EstadoCivil_Cas, EstadoCivil_viud, EstadoCivil_Div;
    private RSDateChooser FechadeNacimiento;
    private RSFotoSquare Foto;

    private RegistrarP r = new RegistrarP();
    private MenuMedicos m = new MenuMedicos();

    public cntrlRegistrarP(RegistrarP r) {
        this.r = r;
        ListenerEventos(r);
        r.ButtonBuscarPaciente.setVisible(false);
        limpiar();
    }

    private void ListenerEventos(RegistrarP r) {
        // textfield y otros : --------------------------
        DNI = r.txt_DNI;
        apellidos = r.txt_Apellidos;
        nombres = r.txt_Nombres;
        Direccion = r.txt_Direccion;
        telefono = r.txt_Telefono;
        FechadeNacimiento = r.Calendar_FechaNac;
        Foto = r.Foto;

        DNI.addKeyListener(this);
        apellidos.addKeyListener(this);
        nombres.addKeyListener(this);
        Direccion.addKeyListener(this);
        telefono.addKeyListener(this);

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

        button_Reg.addMouseListener(this);
        button_Limpiar.addMouseListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //Solo Numeros
        char a = 0;
        if (e.getSource() == DNI) {
            a = e.getKeyChar();
            if (DNI.getText().length() < 8) {
                if (a < '0' || a > '9') {
                    e.consume();
                    Toolkit.getDefaultToolkit().beep();
                }
            } else {
                e.consume();
                Toolkit.getDefaultToolkit().beep();
            }
        }
        // 
        if (e.getSource() == apellidos || e.getSource() == nombres) {
            a = e.getKeyChar();
            if (apellidos.getText().length() < 50) {
                if (!Character.isAlphabetic(a) && !Character.isSpaceChar(a)) {
                    e.consume();
                    Toolkit.getDefaultToolkit().beep();
                }
            } else {
                e.consume();
                Toolkit.getDefaultToolkit().beep();
            }
        }

        e.getKeyChar();
        if (e.getKeyChar() == KeyEvent.VK_ENTER) {
            bottonRegistrar();
        }
        if (e.getSource() == telefono) {
            a = e.getKeyChar();
            if (telefono.getText().length() < 9) {
                if (a < '0' || a > '9') {
                    e.consume();
                    Toolkit.getDefaultToolkit().beep();
                }
            } else {
                e.consume();
                Toolkit.getDefaultToolkit().beep();
            }
        }

    }

    private void limpiar() {
        DNI.setText("");
        apellidos.setText("");
        nombres.setText("");
        Direccion.setText("");
        telefono.setText("");
        FechadeNacimiento.setDatoFecha(new java.util.Date(""));
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == button_Reg) {
            bottonRegistrar();

        }
        if (e.getSource() == button_Limpiar) {
            limpiar();
        }
    }

    private void bottonRegistrar() {
        if (DNI.getText().isEmpty() || apellidos.getText().isEmpty() || nombres.getText().isEmpty() || Direccion.getText().isEmpty()
                || FechadeNacimiento.getDatoFecha() == null) {
            JOptionPane.showMessageDialog(null, "ERROR: NO PUEDES DEJAR LOS CAMPOS VACÍOS", "CAMPOS VACÍOS", JOptionPane.OK_OPTION);
        } else {
            char Sexo = 0;
            if (SexoH.isSelected()) {
                Sexo = SexoH.getText().charAt(0);
            } else {
                Sexo = SexoM.getText().charAt(0);
            }
            String EstadoCivil = "";
            if (EstadoCivil_Cas.isSelected()) {
                EstadoCivil = EstadoCivil_Cas.getText();
            } else if (EstadoCivil_Sol.isSelected()) {
                EstadoCivil = EstadoCivil_Sol.getText();
            } else if (EstadoCivil_Div.isSelected()) {
                EstadoCivil = EstadoCivil_Div.getText();
            } else if (EstadoCivil_viud.isSelected()) {
                EstadoCivil = EstadoCivil_viud.getText();
            }
            Paciente_DBO pacienteDBO;
            byte[] foto = null;
            if (Foto.getRutaImagen() != null) {
                // falta enviar nulos
                try {
                    File ruta = new File(Foto.getRutaImagen());
                    foto = Files.readAllBytes(ruta.toPath());
                } catch (IOException e) {
                }
            }
            if (Foto.getRutaImagen() == null) {
                foto = null;
            }
            if (DNI.getText().length() < 8) {
                JOptionPane.showMessageDialog(null, "DNI CON DIGITOS FALTANTE", "ERROR DE REGISTRO", 0);
            } else {
                if (telefono.getText().length() < 5) {
                    JOptionPane.showMessageDialog(null, "TELEFONO CON DIGITOS FALTANTE", "ERROR DE REGISTRO", 0);
                } else {
                    pacienteDBO = new Paciente_DBO(DNI.getText(), FechadeNacimiento.getDatoFecha(), telefono.getText(), apellidos.getText(), nombres.getText(),
                            Direccion.getText(), Sexo, 0, EstadoCivil, foto);
                    Paciente_DAO registrarDAO = new Paciente_DAO();
                    if (registrarDAO.RegistrarPac(pacienteDBO.retornarPac()) != false) {
                        JOptionPane.showMessageDialog(null, "ACCIÓN COMPLETADA!", "MENSAJE", 1);
                        //JOptionPane.OK_CANCEL_OPTION
                    }

                }

            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e
    ) {

    }

    @Override
    public void keyReleased(KeyEvent e
    ) {

    }

    @Override
    public void mousePressed(MouseEvent e
    ) {

    }

    @Override
    public void mouseReleased(MouseEvent e
    ) {

    }

    @Override
    public void mouseEntered(MouseEvent e
    ) {

    }

    @Override
    public void mouseExited(MouseEvent e
    ) {

    }
}
