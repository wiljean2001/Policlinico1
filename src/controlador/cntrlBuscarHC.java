package controlador;

import DAO.HistorialClinico_DAO;
import DBO.HistoriaClinica_DBO;
import DBO.Paciente_DBO;
import Interfaces.Mensaje;
import Interfaces.Seteo;
import Main.Hospital_v2;
import Vistas.BuscarHC;
import app.bolivia.swing.JCTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JTextArea;
import rojeru_san.RSButtonRiple;

public class cntrlBuscarHC implements ActionListener, KeyListener {

    private RSButtonRiple buttonBuscarHC, buttonAceptar;
    private JCTextField BuscarDNI_IDHC;
    private JTextArea txtArea;
    public int ventanaAnterior = 0;

    private String DateFormato = "dd-MMM-aaaa";
    private SimpleDateFormat formato = new SimpleDateFormat(DateFormato);

    public cntrlBuscarHC(BuscarHC bhc) {
        bhc.TextArea_HistorialClinico.setEditable(false);
        BuscarDNI_IDHC = bhc.txt_CodigoHC;
        buttonBuscarHC = bhc.ButtonBuscarHC;
        buttonAceptar = bhc.ButtonEnviarHC;
        txtArea = bhc.TextArea_HistorialClinico;

        BuscarDNI_IDHC.addKeyListener(this);
        buttonBuscarHC.addActionListener(this);
        buttonAceptar.addActionListener(this);

    }

    private ArrayList<HistoriaClinica_DBO> a = null;
    private ArrayList<Paciente_DBO> b = null;

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonBuscarHC) {
            txtArea.setText("");

            HistorialClinico_DAO hcDAO = new HistorialClinico_DAO();

            a = hcDAO.BuscarHC(BuscarDNI_IDHC.getText(), ventanaAnterior);
            b = hcDAO.BuscarPaciente();
            if (!b.isEmpty()) {
                for (Paciente_DBO pac : this.b) {

                    txtArea.append("PACIENTE \n"
                            + "DNI.: " + pac.getDNI_Paciente() + "\n"
                            + "APELLIDOS: " + pac.getApellidos() + "\n"
                            + "NOMBRE: " + pac.getNombres() + "\n"
                            + "FECHA DE NAC.: " + formato.format(pac.getFechadeNacimiento()) + "\n"
                            + "EDAD: " + String.valueOf(pac.getEdad())+ "\n");

                    Mensaje.MensajeConformidad("PACIENTE BUSCADO EXITOSAMENTE: " + pac.getDNI_Paciente(), "MENSAJE");
                }
                for (HistoriaClinica_DBO a : this.a) {
                    txtArea.append("HISTORIAL CLÍNICO \n"
                            + "CÓDIGO H.C.: " + a.getCodigoHC() + "\n"
                            + "FECHA CREACIÓN: " + formato.format(a.getFechaCreacion()) + "\n"
                            + "CONSUME ALCOHOL: " + a.getConsumeAlcohol() + "\n"
                            + "CONSUME TABACO: " + a.getConsumeTabaco() + "\n"
                            + "CONSUME DROGAS: " + a.getConsumeDrogas()+ "\n"
                            + "CONSUME INFUSIONES: " + a.getConsumeInfusiones()+ "\n"
                            + "ALIMENTACIÓN: " + a.getAlimentacion()+ "\n"
                            + "DIURESIS: " + a.getDiuresis()+ "\n"
                            + "CATARSIS: " + a.getCatarsis()+ "\n"
                            + "SUEÑOS: " + a.getSueño()+ "\n"
                            + "ENFERMEDAD ACTUAL: " + a.getEnfermedadActual()+ "\n");

                }
            } else {

            }

        }

        if (e.getSource()
                == buttonAceptar) {
            if (Hospital_v2.FRHC.isVisible()) {
                Seteo.SeteoPaneles();
                Hospital_v2.FMM.jDesktopPaneMenu.add(Hospital_v2.FAP);
                Hospital_v2.FRHC.setVisible(true);

            }

        }

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
