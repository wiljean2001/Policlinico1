package controlador;

import DAO.Paciente_DAO;
import DBO.Paciente_DBO;
import Interfaces.Mensaje;
import Interfaces.Seteo;
import RSMaterialComponent.RSCheckBoxMaterial;
import Vistas.RegistrarP;
import app.bolivia.swing.JCTextField;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import javax.swing.JButton;
//import javax.swing.JCheckBox;
import rojerusan.RSFotoSquare;
import java.nio.file.Files;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class cntrlRegistrarP implements KeyListener, MouseListener {

    private JButton button_Reg, button_Limpiar;
    private JCTextField DNI, apellidos, nombres, Direccion, telefono;
    private RSCheckBoxMaterial SexoH, SexoM, EstadoCivil_Sol, EstadoCivil_Cas, EstadoCivil_viud, EstadoCivil_Div;
    private JDateChooser FechadeNacimiento;
    private RSFotoSquare Foto;
    private RegistrarP r;
    private ArrayList<RSCheckBoxMaterial> arrayCheck = new ArrayList();
    
    
    public cntrlRegistrarP(RegistrarP r) {
        this.r = r;
        ListenerEventos(r);
        JTextFieldDateEditor editor = (JTextFieldDateEditor) FechadeNacimiento.getDateEditor();
        editor.setEditable(false);
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
        FechadeNacimiento.addKeyListener(this);
        
        arrayCheck.add(SexoH);
        arrayCheck.add(SexoM);
        arrayCheck.add(EstadoCivil_Sol);
        arrayCheck.add(EstadoCivil_Cas);
        arrayCheck.add(EstadoCivil_viud);
        arrayCheck.add(EstadoCivil_Div);
        
        
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
        if (e.getSource() == apellidos) {
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
        if (e.getSource() == nombres) {
            a = e.getKeyChar();
            if (nombres.getText().length() < 50) {
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
    private int primeravez = 0;

    public void limpiar() {
        if (primeravez == 1) {
            int result = JOptionPane.showConfirmDialog(null, "¿DESEA LIMPIAR TODOS LOS CAMPOS?", "CONFIRMAR", JOptionPane.YES_NO_OPTION);
            if (result == 0) {
                Seteo.SeteoTextField(r.jPanel1);
                Seteo.SeteoJCalendar(FechadeNacimiento);
                Seteo.SeteoCheckbox(arrayCheck);
                Foto.setImagenDefault(null);
            }
        }
        if (primeravez == 0) {
            primeravez = 1;
        }else{
            primeravez = 0;
        }
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if (e.getSource() == button_Limpiar) {
            limpiar();
        }
        if (e.getSource() == button_Reg) {
            bottonRegistrar();
        }
    }

    private boolean validarCheck() {
        // SexoH, SexoM, EstadoCivil_Sol, EstadoCivil_Cas, EstadoCivil_viud, EstadoCivil_Div; 
        if (SexoH.isSelected() || SexoM.isSelected()) {

            return true;
        }
        return false;
    }

    private void bottonRegistrar() {
        if (DNI.getText().isEmpty() || apellidos.getText().isEmpty()
                || nombres.getText().isEmpty() || Direccion.getText().isEmpty()
                || FechadeNacimiento.getDate() == null) {

            Mensaje.MensajeError("ERROR: NO PUEDES DEJAR LOS CAMPOS VACÍOS", "CAMPOS VACÍOS");

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
                Mensaje.MensajeConformidad("DNI CON DIGITOS FALTANTE", "MENSAJE");
            } else {
                if (telefono.getText().length() < 5) {
                    Mensaje.MensajeError("TELEFONO CON DIGITOS FALTANTE", "ERROR DE REGISTRO");
                } else {

                    pacienteDBO = new Paciente_DBO(DNI.getText(), FechadeNacimiento.getDate(),
                            telefono.getText(), apellidos.getText(), nombres.getText(),
                            Direccion.getText(), Sexo, 0, EstadoCivil, foto);

                    Paciente_DAO registrarDAO = new Paciente_DAO();
                    limpiar();
                    if (registrarDAO.RegistrarPac(pacienteDBO.retornarPac()) != false) {
                        Mensaje.MensajeConformidad("ACCIÓN COMPLETADA!", "MENSAJE");
                        //JOptionPane.OK_CANCEL_OPTION
                    }

                }

            }
        }
    }

    public static boolean ValidateIdentificationDocumentPeru(String identificationDocument) {
        if (identificationDocument != null) {
            int addition = 0;
            // int[] hash = { 5, 4, 3, 2, 7, 6, 5, 4, 3, 2 };
            int[] hash = {3, 2, 7, 6, 5, 4, 3, 2};
            int identificationDocumentLength = identificationDocument.length();

            String identificationComponent = identificationDocument.substring(0, identificationDocumentLength - 1);

            int identificationComponentLength = identificationComponent.length();

            int diff = hash.length - identificationComponentLength;

            for (int i = 0; i < identificationDocument.length(); i++) {
                addition += Integer.parseInt(identificationDocument.substring(i, 1)) * hash[i];
            }

            addition = 11 - (addition % 11);
            int abc = addition;
            if (addition == 11) {
                addition = 0;
            } else if (addition == 10) {
                addition = 1;

            }

            //  char last = char.ToUpperInvariant(identificationDocument[identificationDocumentLength - 1]);
            String dcontrol = identificationDocument.substring(0, 1);

            char last = dcontrol.charAt(0);
            if (identificationDocumentLength == 11) {
                // The identification document corresponds to a RUC.
                //return addition.equals(last - '0');
            }
            /*
                
                else if (char.IsDigit(last))
                {
                    // The identification document corresponds to a DNI with a number as verification digit.
                    //char[] hashNumbers = { '6', '7', '8', '9', '0', '1', '1', '2', '3', '4', '5' };
                    char[] hashNumbers = { '6', '7', '8', '9', '0', '1', '1', '2', '3', '4','5','6'};
                    
                    return last.Equals(hashNumbers[addition]);
                }
                else if (char.IsLetter(last))
                {
                    // The identification document corresponds to a DNI with a letter as verification digit.
                    char[] hashLetters = { 'K', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J' };
                    return last.Equals(hashLetters[addition]);
                }
             */
        }

        return false;
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
