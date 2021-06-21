package controlador;

import DAO.Paciente_DAO;
import DBO.Paciente_DBO;
import Vistas.ActualizarP;
import Vistas.BuscarPaciente;
import app.bolivia.swing.JCTextField;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import rojeru_san.complementos.RSTableMetro;

public class cntrlBuscarP implements ActionListener, KeyListener {

    private JButton button_BuscarPac, button_Aceptar;
    private JCTextField DNI;
    private RSTableMetro contenidoPac;
    private BuscarPaciente BusP;
    private String Titulo[] = {"DNI", "FECHA NAC.", "TELF.", "NOMBRE", "DIR.", "SEXO", "EDAD", "ESTADO CIV.", "FOTO"};
    DefaultTableModel modelo = new DefaultTableModel();

    public cntrlBuscarP(BuscarPaciente BusP) {
        this.BusP = BusP;
        acciones(BusP);
        BusP.setLocationRelativeTo(null);
        modelo = new DefaultTableModel(null, Titulo);
        TablaImagen tablaImagen = new TablaImagen();
        contenidoPac.setDefaultRenderer(Object.class, tablaImagen);
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
    private ArrayList<Paciente_DBO> lista = null;

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button_Aceptar) {
            if (lista != null) {

                ActualizarP actualizarP = new ActualizarP();
                cntrlActualizarP cntrlActualizarP = new cntrlActualizarP(actualizarP);
                cntrlMenuRecep.DesktopPaneMenu.add(actualizarP);
                actualizarP.setVisible(true);
                if (actualizarP.isVisible()) {
                    // para actualizar
                    for (Paciente_DBO a : lista) {
                        cntrlActualizarP.fotoByte = a.getFoto();
                        actualizarP.txtDNI.setEnabled(true);
                        actualizarP.txt_Apellidos.setEnabled(true);
                        actualizarP.txt_Nombres.setEnabled(true);
                        actualizarP.txtDireccion.setEnabled(true);
                        actualizarP.Calendar_FechaNac.setEnabled(true);
                        actualizarP.txtTelefono.setEnabled(true);

                        actualizarP.Check_Hombre.setEnabled(true);
                        actualizarP.Check_Mujer.setEnabled(true);
                        actualizarP.Check_Soltero.setEnabled(true);
                        actualizarP.Check_Casado.setEnabled(true);
                        actualizarP.Check_Viudo.setEnabled(true);
                        actualizarP.Check_Divorciado.setEnabled(true);

                        actualizarP.txtDNI.setText(a.getDNI_Paciente());
                        actualizarP.txt_Apellidos.setText(a.getApellidos());
                        actualizarP.txt_Nombres.setText(a.getNombres());
                        actualizarP.txtDireccion.setText(a.getDireccion());
                        actualizarP.Calendar_FechaNac.setDatoFecha(a.getFechadeNacimiento());
                        // convertir
                        try {
                            ImageIcon imgi = null;
                            if (a.getFoto() != null) {
                                byte[] bi = a.getFoto();
                                BufferedImage image = null;
                                image = ImageIO.read(new ByteArrayInputStream(bi));
                                imgi = new ImageIcon(image);
                            }
                            actualizarP.FotoPaciente.setIcon(imgi);
                            actualizarP.txtTelefono.setText(a.getTelefono());
                        } catch (Exception ex) {
                        }

                        if ("H".equals(a.getSexo())) {
                            actualizarP.Check_Hombre.setSelected(true);
                        } else if ("M".equals(a.getSexo())) {
                            actualizarP.Check_Mujer.setSelected(true);
                        }
                        if ("Soltero".equals(a.getEstadoCivil())) {
                            actualizarP.Check_Soltero.setSelected(true);
                        } else if ("Casado".equals(a.getEstadoCivil())) {
                            actualizarP.Check_Casado.setSelected(true);
                        } else if ("Viudo".equals(a.getEstadoCivil())) {
                            actualizarP.Check_Viudo.setSelected(true);
                        } else if ("Divorciado".equals(a.getEstadoCivil())) {
                            actualizarP.Check_Divorciado.setSelected(true);
                        }
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "ERROR: ENVIAR DATOS A LA INTERFAZ", "MENSAJE", 0);
            }
        }

        // DNI CON DATOS FALTANTES MODIFICAR EN EL WORD
        if (DNI.getText().length() < 8) {
            JOptionPane.showMessageDialog(null, "DNI CON DIGITOS FALTANTE", "ERROR DE REGISTRO", 0);
        } else {
            if (e.getSource() == button_BuscarPac) {

                Paciente_DAO paciente_DAO = new Paciente_DAO();
                int valor = modelo.getRowCount() - 1;
                for (int i = valor; i >= 0; i--) {
                    modelo.removeRow(i);
                }
                // VUELVO

                lista = paciente_DAO.BuscarPac(DNI.getText());
                if (lista.isEmpty()) {
                    JOptionPane.showMessageDialog(BusP, "PACIENTE NO EXISTENTE", "ERROR", 0);
                }
                for (Paciente_DBO a : lista) {
                    try {
                        ImageIcon imgi = null;
                        if (a.getFoto() != null) {
                            byte[] bi = a.getFoto();
                            BufferedImage image = null;
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
                        JOptionPane.showMessageDialog(null, "PACIENTE BUSCADO EXITOSAMENTE", "MENSAJE", 1);
                    } catch (Exception ex) {
                    }

                }

            }
        }

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

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}
