package controlador;

import DAO.Paciente_DAO;
import DBO.Paciente_DBO;
import Vistas.ActualizarP;
import app.bolivia.swing.JCTextField;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import rojeru_san.componentes.RSDateChooser;
import rojerusan.RSFotoSquare;

public class cntrlActualizarP implements KeyListener, MouseListener {

    private JButton button_ActP, button_Limpiar, button_BuscarPaciente;
    private JCTextField DNI, apellidos, nombres, Direccion, telefono;
    private JCheckBox SexoH, SexoM, EstadoCivil_Sol, EstadoCivil_Cas, EstadoCivil_viud, EstadoCivil_Div;
    private RSDateChooser FechadeNacimiento;
    private RSFotoSquare Foto;
    private ActualizarP ActP;

    public cntrlActualizarP(ActualizarP ActP) {
        this.ActP = ActP;
        acciones(ActP);
    }

    private void acciones(ActualizarP ActP) {
        DNI = ActP.txtDNI;
        apellidos = ActP.txt_Apellidos;
        nombres = ActP.txt_Nombres;
        Direccion = ActP.txtDireccion;
        telefono = ActP.txtTelefono;
        FechadeNacimiento = ActP.Calendar_FechaNac;

        DNI.addKeyListener(this);
        apellidos.addKeyListener(this);
        nombres.addKeyListener(this);
        Direccion.addKeyListener(this);
        telefono.addKeyListener(this);

        //Checkbox
        SexoH = ActP.Check_Hombre;
        SexoM = ActP.Check_Mujer;
        EstadoCivil_Sol = ActP.Check_Soltero;
        EstadoCivil_Cas = ActP.Check_Casado;
        EstadoCivil_viud = ActP.Check_Viudo;
        EstadoCivil_Div = ActP.Check_Divorciado;

        // Botones :---------------
        button_ActP = ActP.ButtonActualizarPac;
        button_Limpiar = ActP.ButtonLimpiarTodo;
        button_BuscarPaciente = ActP.ButtonBuscarP;

        button_ActP.addMouseListener(this);
        button_Limpiar.addMouseListener(this);
        button_BuscarPaciente.addMouseListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource() == button_ActP) {
            actualizar();
        }
    }

    private void actualizar() {
        if (DNI.getText().isEmpty() || apellidos.getText().isEmpty() || nombres.getText().isEmpty() || Direccion.getText().isEmpty()
                || FechadeNacimiento.getDatoFecha() == null) {
            JOptionPane.showMessageDialog(null, "CAMPOS VACÍOS", "ERROR: NO PUEDES DEJAR LOS CAMPOS VACÍOS", JOptionPane.OK_OPTION);
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
            // falta enviar nulos
            try {
                File ruta = new File(Foto.getRutaImagen());
                byte[] foto = Files.readAllBytes(ruta.toPath());
                Paciente_DBO pacienteDBO;
                pacienteDBO = new Paciente_DBO(DNI.getText(), FechadeNacimiento.getDatoFecha(), telefono.getText(), apellidos.getText(), nombres.getText(),
                        Direccion.getText(), Sexo, 0, EstadoCivil, foto);
                Paciente_DAO registrarDAO = new Paciente_DAO();
                //
                if (registrarDAO.create(pacienteDBO.retornarPac()) != false) {
                    JOptionPane.showMessageDialog(null, "MENSAJE", "REGISTRO EXITOSO", JOptionPane.OK_OPTION);
                }

            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Eror: ", "Eror: " + e, 1);
            }
        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}
