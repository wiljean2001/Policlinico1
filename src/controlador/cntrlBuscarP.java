package controlador;

import DAO.Paciente_DAO;
import DBO.Paciente_DBO;
import Interfaces.Mensaje;
import Interfaces.Seteo;
import Main.Hospital_v2;
import Vistas.ActualizarP;
import Vistas.BuscarPaciente;
import app.bolivia.swing.JCTextField;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;
import rojeru_san.complementos.RSTableMetro;

public class cntrlBuscarP implements ActionListener, KeyListener {

    private JButton button_BuscarPac, button_Aceptar;
    private JCTextField DNI;
    private RSTableMetro contenidoPac;
    private BuscarPaciente BusP;
    private final String Titulo[] = {"DNI", "FECHA NAC.", "TELF.", "NOMBRE", "DIR.", "SEXO", "EDAD", "ESTADO CIV.", "FOTO"};
    private DefaultTableModel modelo = new DefaultTableModel();
    private ArrayList<Paciente_DBO> lista = null;

    public cntrlBuscarP(BuscarPaciente BusP) {
        this.BusP = BusP;

        acciones(BusP);
        BusP.setLocationRelativeTo(null);

        modelo = new DefaultTableModel(null, Titulo);
        contenidoPac.setDefaultRenderer(Object.class, new TablaImagen());

        contenidoPac.setModel(modelo);
        contenidoPac.setEnabled(false);
    }

    private void acciones(BuscarPaciente BusP) {
        button_BuscarPac = BusP.ButtonBuscarPaciente;
        button_Aceptar = BusP.ButtonEnviarPaciente;
        DNI = BusP.txtDNI;
        contenidoPac = BusP.Table_Paciente;

        DNI.addKeyListener(this);
        button_BuscarPac.addActionListener(this);
        button_Aceptar.addActionListener(this);
    }
    
    // AGREGAR AL WORD (VALIDAR CAMPO DNI)
    @Override
    public void keyTyped(KeyEvent e) {
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
    }
    public void limpiar(){
        Seteo.SeteoTextField(BusP.jPanel1);
        Seteo.SeteoJTable(modelo);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button_Aceptar) {
            BotonAceptar();
        }
        if (e.getSource() == button_BuscarPac) {
            // DNI CON DATOS FALTANTES MODIFICAR EN EL WORD
            BuscarPaciente();
        }

    }
    
    private void BuscarPaciente(){
        if (DNI.getText().length() < 8) {
                Mensaje.MensajeError("DNI CON DIGITOS FALTANTE", "ERROR DE REGISTRO");
            } else {
                Paciente_DAO paciente_DAO = new Paciente_DAO();
                // VUELVO
                lista = paciente_DAO.BuscarPac(DNI.getText());
                if (lista.isEmpty()) {
                    Mensaje.MensajeError("PACIENTE NO EXISTENTE", "ERROR");
                }
                for (Paciente_DBO a : lista) {
                    try {
                        ImageIcon imgi = null;
                        if (a.getFoto() != null) {
                            byte[] bi = a.getFoto();
                            BufferedImage image;
                            image = ImageIO.read(new ByteArrayInputStream(bi));
                            imgi = new ImageIcon(image.getScaledInstance(120, 120, 0));
                        }
                        Object[] objNuevo = new Object[9];
                        objNuevo[0] = a.getDNI_Paciente();
                        objNuevo[1] = a.getFechadeNacimiento().toString();
                        objNuevo[2] = a.getTelefono();
                        objNuevo[3] = a.getApellidos() + " " + a.getNombres();
                        objNuevo[4] = a.getDireccion();
                        objNuevo[5] = a.getSexo();
                        objNuevo[6] = a.getEdad();
                        objNuevo[7] = a.getEstadoCivil();
                        objNuevo[8] = new JLabel(imgi);
                        modelo.addRow(objNuevo);
                        Mensaje.MensajeConformidad("PACIENTE BUSCADO EXITOSAMENTE", "MENSAJE");
                    } catch (HeadlessException | IOException ex) {
                    }

                }
               
            }
    }

    private void BotonAceptar() {
        if (lista != null) {
            Seteo.SeteoPaneles();
            Hospital_v2.FMR.jDesktopPaneMenu.add(Hospital_v2.FAP);
            Hospital_v2.FAP.setVisible(true);
            // para actualizar
            for (Paciente_DBO a : lista) {
                cntrlActualizarP.fotoByte = a.getFoto();
                Hospital_v2.FAP.txtDNI.setEnabled(true);
                Hospital_v2.FAP.txt_Apellidos.setEnabled(true);
                Hospital_v2.FAP.txt_Nombres.setEnabled(true);
                Hospital_v2.FAP.txtDireccion.setEnabled(true);
                Hospital_v2.FAP.txtTelefono.setEnabled(true);

                Hospital_v2.FAP.Check_Hombre.setEnabled(true);
                Hospital_v2.FAP.Check_Mujer.setEnabled(true);
                Hospital_v2.FAP.Check_Soltero.setEnabled(true);
                Hospital_v2.FAP.Check_Casado.setEnabled(true);
                Hospital_v2.FAP.Check_Viudo.setEnabled(true);
                Hospital_v2.FAP.Check_Divorciado.setEnabled(true);

                Hospital_v2.FAP.txtDNI.setText(a.getDNI_Paciente());
                Hospital_v2.FAP.txt_Apellidos.setText(a.getApellidos());
                Hospital_v2.FAP.txt_Nombres.setText(a.getNombres());
                Hospital_v2.FAP.txtDireccion.setText(a.getDireccion());
                Hospital_v2.FAP.Calendar_FechaNac.setDate(a.getFechadeNacimiento());
                // convertir
                try {
                    ImageIcon imgi = null;
                    if (a.getFoto() != null) {
                        byte[] bi = a.getFoto();
                        BufferedImage image;
                        image = ImageIO.read(new ByteArrayInputStream(bi));
                        imgi = new ImageIcon(image);
                    }
                    Hospital_v2.FAP.FotoPaciente.setIcon(imgi);
                    Hospital_v2.FAP.txtTelefono.setText(a.getTelefono());
                } catch (IOException ex) {
                }

                if ("H".equals(a.getSexo())) {
                    Hospital_v2.FAP.Check_Hombre.setSelected(true);
                } else if ("M".equals(a.getSexo())) {
                    Hospital_v2.FAP.Check_Mujer.setSelected(true);
                }
                else switch (a.getEstadoCivil()) {
                    case "Soltero":
                        Hospital_v2.FAP.Check_Soltero.setSelected(true);
                        break;
                    case "Casado":
                        Hospital_v2.FAP.Check_Casado.setSelected(true);
                        break;
                    case "Viudo":
                        Hospital_v2.FAP.Check_Viudo.setSelected(true);
                        break;
                    case "Divorciado":
                        Hospital_v2.FAP.Check_Divorciado.setSelected(true);
                        break;
                    default:
                        break;
                }
            }

            BusP.setVisible(false);
        } else {
            Mensaje.MensajeError("ERROR: ENVIAR DATOS A LA INTERFAZ", "ERROR");
        }
    }

    
    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}
