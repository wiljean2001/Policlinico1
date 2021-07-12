package controlador;

import DAO.HistorialClinico_DAO;
import DBO.HistoriaClinica_DBO;
import DBO.Paciente_DBO;
import Interfaces.Mensaje;
import Interfaces.Seteo;
import Main.Hospital_v2;
import Vistas.BuscarHC;
import app.bolivia.swing.JCTextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import rojeru_san.RSButtonRiple;

public class cntrlBuscarHC implements ActionListener, KeyListener {

    private RSButtonRiple buttonBuscarHC, buttonAceptar;
    private JCTextField BuscarDNI_IDHC;
    private JTextArea txtArea;
    private JPanel PanelFondo;

    private String DateFormato = "dd-MMM-YYYY";
    private SimpleDateFormat formato = new SimpleDateFormat(DateFormato);

    public cntrlBuscarHC(BuscarHC bhc) {
        bhc.setLocationRelativeTo(null);
        bhc.TextArea_HistorialClinico.setEditable(false);

        BuscarDNI_IDHC = bhc.txt_CodigoHC;
        buttonBuscarHC = bhc.ButtonBuscarHC;
        buttonAceptar = bhc.ButtonEnviarHC;
        txtArea = bhc.TextArea_HistorialClinico;
        PanelFondo = bhc.PanelFondo;

        BuscarDNI_IDHC.addKeyListener(this);
        buttonBuscarHC.addActionListener(this);
        buttonAceptar.addActionListener(this);

    }

    private ArrayList<HistoriaClinica_DBO> a = null;
    private ArrayList<Paciente_DBO> b = null;

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonBuscarHC) {
            BuscarHC();
        }

        if (e.getSource() == buttonAceptar) {
            Seteo.SeteoPaneles();
            if (!b.isEmpty()) {
                for (Paciente_DBO pac : this.b) {
                    Hospital_v2.FAHC.txtDN.setText(pac.getDNI_Paciente());
                    Hospital_v2.FAHC.txt_Nomb_Apll.setText(pac.getApellidos() + " " + pac.getNombres());
                    Hospital_v2.FAHC.txtDireccion.setText(pac.getDireccion());
                    try {
                        ImageIcon imgi = null;
                        if (pac.getFoto() != null) {
                            byte[] bi = pac.getFoto();
                            BufferedImage image;
                            image = ImageIO.read(new ByteArrayInputStream(bi));
                            imgi = new ImageIcon(image);
                            Hospital_v2.FAHC.Foto.setIcon(imgi);
                        }
                    } catch (IOException ex) {
                    }

                    if ("M".equals(String.valueOf(pac.getSexo()))) {
                        Hospital_v2.FRHC.Check_Masculino.setSelected(true);
                        Hospital_v2.FRHC.Check_Femenino.setSelected(false);
                    } else {
                        Hospital_v2.FRHC.Check_Femenino.setSelected(true);
                        Hospital_v2.FRHC.Check_Masculino.setSelected(false);
                    }
                }
                for (HistoriaClinica_DBO a : this.a) {
                    Hospital_v2.FAHC.lbl_codigo.setText(a.getCodigoHC());
                    Hospital_v2.FAHC.lbl_fecha.setText(formato.format(a.getFechaCreacion()));
                    Hospital_v2.FAHC.ButtonActualizarHC.setEnabled(true);

                    Hospital_v2.FAHC.txt_alimentacion.setText(a.getAlimentacion());
                    Hospital_v2.FAHC.txt_catarsis.setText(a.getCatarsis());
                    Hospital_v2.FAHC.txt_diuresis.setText(a.getDiuresis());
                    Hospital_v2.FAHC.txt_enfermedad.setText(a.getEnfermedadActual());
                    Hospital_v2.FAHC.txt_sueño.setText(a.getSueño());

                    if (!a.getConsumeAlcohol().isEmpty()) {
                        if ("SÍ".equals(a.getConsumeAlcohol().substring(0, 2))) {
                            Hospital_v2.FAHC.Check_Alcoholsi.setSelected(true);
                            Hospital_v2.FAHC.Check_Alcoholno.setSelected(false);
                            Hospital_v2.FAHC.txtalcohol.setText(a.getConsumeAlcohol().substring(2));
                        } else {
                            Hospital_v2.FAHC.Check_Alcoholno.setSelected(true);
                            Hospital_v2.FAHC.Check_Alcoholsi.setSelected(false);
                        }
                    }

                    if (!a.getConsumeDrogas().isEmpty()) {
                        if ("SÍ".equals(a.getConsumeDrogas().substring(0, 2))) {
                            Hospital_v2.FAHC.Check_Drogassi.setSelected(true);
                            Hospital_v2.FAHC.Check_Drogasno.setSelected(false);

                            Hospital_v2.FAHC.txtdrogas.setText(a.getConsumeDrogas().substring(2));
                        } else {
                            Hospital_v2.FAHC.Check_Drogasno.setSelected(true);
                            Hospital_v2.FAHC.Check_Drogassi.setSelected(false);
                        }
                    }

                    if (!a.getConsumeTabaco().isEmpty()) {
                        if ("SÍ".equals(a.getConsumeTabaco().substring(0, 2))) {
                            Hospital_v2.FAHC.Check_Tabacosi.setSelected(true);
                            Hospital_v2.FAHC.Check_Tabacono.setSelected(false);

                            Hospital_v2.FAHC.txttabaco.setText(a.getConsumeTabaco().substring(2));
                        } else {
                            Hospital_v2.FAHC.Check_Tabacono.setSelected(true);
                            Hospital_v2.FAHC.Check_Tabacosi.setSelected(false);
                        }
                    }
                    if (!a.getConsumeInfusiones().isEmpty()) {
                        if ("SÍ".equals(a.getConsumeInfusiones().substring(0, 2))) {
                            Hospital_v2.FAHC.Check_infucionessi.setSelected(true);
                            Hospital_v2.FAHC.Check_infucionesno.setSelected(false);
                            Hospital_v2.FAHC.txtinfuciones.setText(a.getConsumeInfusiones().substring(2));

                        } else {
                            Hospital_v2.FAHC.Check_infucionesno.setSelected(true);
                            Hospital_v2.FAHC.Check_infucionessi.setSelected(false);
                        }
                    }
                }
                limpiar();
            } else {
                Mensaje.MensajeError("ERROR: ENVIAR DATOS A LA INTERFAZ", "ERROR");
            }
            Hospital_v2.FMM.jDesktopPaneMenu.add(Hospital_v2.FAHC);
            Hospital_v2.FAHC.setVisible(true);
            Hospital_v2.FBHC.setVisible(false);

        }

    }

    public void limpiar() {
        Seteo.SeteoTextField(PanelFondo);
        Seteo.SeteoJTextArea(txtArea);
    }

    private void BuscarHC() {
        if (BuscarDNI_IDHC.getText().length() < 5 || (BuscarDNI_IDHC.getText().length() > 6
                && BuscarDNI_IDHC.getText().length() < 8)) {
            Mensaje.MensajeError("DNI CON DIGITOS FALTANTE", "ERROR DE REGISTRO");
        } else {
            HistorialClinico_DAO hcDAO = new HistorialClinico_DAO();

            a = hcDAO.BuscarHC(BuscarDNI_IDHC.getText());
            b = hcDAO.BuscarPaciente();
            limpiar();
            if (a.isEmpty()) {
                Mensaje.MensajeError("PACIENTE NO EXISTENTE", "ERROR");
            } else {
                for (Paciente_DBO pac : this.b) {

                    txtArea.append("            PACIENTE \n"
                            + "DNI:                             " + pac.getDNI_Paciente() + "\n"
                            + "APELLIDOS:                   " + pac.getApellidos() + "\n"
                            + "NOMBRE:                       " + pac.getNombres() + "\n"
                            + "FECHA DE NAC.:            " + formato.format(pac.getFechadeNacimiento()) + "\n"
                            + "EDAD:                           " + String.valueOf(pac.getEdad()) + "\n\n");

                }
                for (HistoriaClinica_DBO a : this.a) {
                    txtArea.append("            HISTORIAL CLÍNICO \n"
                            + "CÓDIGO H.C.:                 " + a.getCodigoHC() + "\n"
                            + "FECHA CREACIÓN:           " + formato.format(a.getFechaCreacion()) + "\n"
                            + "CONSUME ALCOHOL:       " + a.getConsumeAlcohol() + "\n"
                            + "CONSUME TABACO:         " + a.getConsumeTabaco() + "\n"
                            + "CONSUME DROGAS:         " + a.getConsumeDrogas() + "\n"
                            + "CONSUME INFUSIONES:  " + a.getConsumeInfusiones() + "\n"
                            + "ALIMENTACIÓN:               " + a.getAlimentacion() + "\n"
                            + "DIURESIS:                        " + a.getDiuresis() + "\n"
                            + "CATARSIS:                       " + a.getCatarsis() + "\n"
                            + "SUEÑOS:                         " + a.getSueño() + "\n"
                            + "ENFERMEDAD ACTUAL:    " + a.getEnfermedadActual() + "\n");

                }
                Mensaje.MensajeConformidad("PACIENTE BUSCADO EXITOSAMENTE", "MENSAJE");
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        char a = 0;
        if (e.getSource() == BuscarDNI_IDHC) {
            a = e.getKeyChar();
            if (BuscarDNI_IDHC.getText().length() < 8) {
                if (a < '0' || a > '9') {
                    e.consume();
                    Toolkit.getDefaultToolkit().beep();
                }
            } else {
                e.consume();
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
