package controlador;

import DBO.HistoriaClinica_DBO;
import DBO.Paciente_DBO;
import Interfaces.Seteo;
import Main.Hospital_v2;
import Vistas.BuscarHC;
import app.bolivia.swing.JCTextField;
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
import rojeru_san.RSButtonRiple;

public class cntrlBuscarHC implements ActionListener, KeyListener {

    private RSButtonRiple buttonBuscarHC, buttonAceptar;
    private JCTextField BuscarDNI_IDHC;

    public cntrlBuscarHC(BuscarHC bhc) {
        BuscarDNI_IDHC = bhc.txt_CodigoHC;
        buttonBuscarHC = bhc.ButtonBuscarHC;
        buttonAceptar = bhc.ButtonEnviarHC;
        BuscarDNI_IDHC.addActionListener(this);
        buttonBuscarHC.addActionListener(this);
        buttonAceptar.addActionListener(this);

    }

    private enum tipoClase {HistoriaClinica_DBO, Paciente_DBO}

    private ArrayList<tipoClase> lista = null;

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonBuscarHC) {

        }/*
        
        if (e.getSource() == buttonAceptar) {
            if (Hospital_v2.FRHC.isVisible()) {
                Seteo.SeteoPaneles();
                Hospital_v2.FMM.jDesktopPaneMenu.add(Hospital_v2.FAP);
                Hospital_v2.FRHC.setVisible(true);
                tipoClase tipoclase = new tipoClase;
                // para actualizar
                switch (tipoclase) {
                    case HistoriaClinica_DBO:

                        break;
                    default:
                        break;
                }
                for (Paciente_DBO a : lista) {
                    cntrlActualizarP.fotoByte = a.getFoto();
                    Hospital_v2.FRHC.txtDNI.setEnabled(true);
                    Hospital_v2.FRHC.txt_NombreApll.setEnabled(true);
                    Hospital_v2.FRHC.txt_Direccion.setEnabled(true);

                    Hospital_v2.FAP.Check_Hombre.setEnabled(true);
                    Hospital_v2.FAP.Check_Mujer.setEnabled(true);
                    Hospital_v2.FAP.Check_Soltero.setEnabled(true);
                    Hospital_v2.FAP.Check_Casado.setEnabled(true);
                    Hospital_v2.FAP.Check_Viudo.setEnabled(true);
                    Hospital_v2.FAP.Check_Divorciado.setEnabled(true);
                    Hospital_v2.FAP.Calendar_FechaNac.setEnabled(true);

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
                    } else {
                        switch (a.getEstadoCivil()) {
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
                }
                BusP.setVisible(false);
            }
        }
        */
    }

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
