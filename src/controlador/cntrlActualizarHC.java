/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import DAO.HistorialClinico_DAO;
import DBO.HistoriaClinica_DBO;
import Interfaces.Enable;
import Interfaces.Mensaje;
import Interfaces.Seteo;
import Main.Hospital_v2;
import Vistas.ActualizarHC;
import app.bolivia.swing.JCTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import rojeru_san.RSButtonRiple;
import rojerusan.RSLabelImage;

/**
 *
 * @author wil-laptop
 */
public class cntrlActualizarHC implements KeyListener, ActionListener {

    private RSButtonRiple buttonBuscarHC, buttonRegistrarHC;
    //copiar
    private JCTextField Alcohol_des, Tabaco_des, Drogas_des, Infuciones_des,
            Alimentacion, Diuresis, Catarsis, Sueño, Enfermedad, DNI;
    private JCheckBox Alcohol_si, Alcohol_no, Tabaco_si, Tabaco_no, Drogras_si,
            Drogas_no, Infuciones_si, Infuciones_no;
    private HistoriaClinica_DBO historialDBO;
    private ActualizarHC ActHC;
    private final ImageIcon imagenIcon;
    private RSLabelImage Foto;

    public cntrlActualizarHC(ActualizarHC ActHC) {
        this.ActHC = ActHC;
        acciones(ActHC);
        imagenIcon = new ImageIcon(cntrlRegistrarP.class.getResource("/recursos2/descarga.png"));
    }

    private void acciones(ActualizarHC ActHC) {

        DNI = ActHC.txtDN;
        Alcohol_des = ActHC.txtalcohol;
        Tabaco_des = ActHC.txttabaco;
        Drogas_des = ActHC.txtdrogas;
        Infuciones_des = ActHC.txtinfuciones;
        Foto = ActHC.Foto;
       

        Alimentacion = ActHC.txt_alimentacion;
        Diuresis = ActHC.txt_diuresis;
        Catarsis = ActHC.txt_catarsis;
        Sueño = ActHC.txt_sueño;
        Enfermedad = ActHC.txt_enfermedad;

        Alcohol_des.addKeyListener(this);
        Tabaco_des.addKeyListener(this);
        Drogas_des.addKeyListener(this);
        Infuciones_des.addKeyListener(this);
        Alimentacion.addKeyListener(this);
        Diuresis.addKeyListener(this);
        Catarsis.addKeyListener(this);
        Sueño.addKeyListener(this);
        Enfermedad.addKeyListener(this);

        //Chec
        Alcohol_si = ActHC.Check_Alcoholsi;
        Alcohol_no = ActHC.Check_Alcoholno;
        Tabaco_si = ActHC.Check_Tabacosi;
        Tabaco_no = ActHC.Check_Tabacono;
        Drogras_si = ActHC.Check_Drogassi;
        Drogas_no = ActHC.Check_Drogasno;
        Infuciones_si = ActHC.Check_infucionessi;
        Infuciones_no = ActHC.Check_infucionesno;

        Alcohol_si.addActionListener(this);
        Alcohol_no.addActionListener(this);
        Tabaco_si.addActionListener(this);
        Tabaco_no.addActionListener(this);
        Drogras_si.addActionListener(this);
        Drogas_no.addActionListener(this);
        Infuciones_si.addActionListener(this);
        Infuciones_no.addActionListener(this);

        //botones
        buttonBuscarHC = ActHC.ButtonBuscarHC;
        buttonRegistrarHC = ActHC.ButtonActualizarHC;

        buttonBuscarHC.addActionListener(this);
        buttonRegistrarHC.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonRegistrarHC) {
            actualizar(e);
        }
        if (e.getSource() == buttonBuscarHC) {
            Hospital_v2.cBHC.limpiar();
            Hospital_v2.FAHC.setVisible(false);
            Hospital_v2.FBHC.ButtonEnviarHC.setVisible(true);
            Hospital_v2.FBHC.setVisible(true);
        }

        if (e.getSource() == Alcohol_no) {
            if (Alcohol_des.isEditable()) {
                Alcohol_des.setEditable(false);
                Alcohol_des.setText("");
                Alcohol_si.setSelected(false);
            } else {
                Alcohol_des.setEditable(true);
            }
        }
        if (e.getSource() == Tabaco_no) {
            if (Tabaco_des.isEditable()) {
                Tabaco_des.setEditable(false);
                Tabaco_des.setText("");
                Tabaco_si.setSelected(false);
            } else {
                Tabaco_des.setEditable(true);
            }
        }
        if (e.getSource() == Drogas_no) {
            if (Drogas_des.isEditable()) {
                Drogas_des.setEditable(false);
                Drogas_des.setText("");
                Drogras_si.setSelected(false);
            } else {
                Drogas_des.setEditable(true);
            }

        }
        if (e.getSource() == Infuciones_no) {
            if (Infuciones_des.isEditable()) {
                Infuciones_des.setEditable(false);
                Infuciones_des.setText("");
                Infuciones_si.setSelected(false);
            } else {
                Infuciones_des.setEditable(true);
            }

        }
        if (e.getSource() == Alcohol_si) {
            if (!Alcohol_des.isEditable()) {
                Alcohol_des.setEditable(true);
                Alcohol_no.setSelected(false);
            } else {
                Alcohol_des.setEditable(true);
            }
        }
        if (e.getSource() == Tabaco_si) {
            if (!Tabaco_des.isEditable()) {
                Tabaco_des.setEditable(true);
                Tabaco_no.setSelected(false);
            } else {
                Tabaco_des.setEditable(true);
            }
        }
        if (e.getSource() == Drogras_si) {
            if (!Drogas_des.isEditable()) {
                Drogas_des.setEditable(true);
                Drogas_no.setSelected(false);
            } else {
                Drogas_des.setEditable(true);
            }
        }
        if (e.getSource() == Infuciones_si) {
            if (!Infuciones_des.isEditable()) {
                Infuciones_des.setEditable(true);
                Infuciones_no.setSelected(false);
            } else {
                Infuciones_des.setEditable(true);
            }
        }
    }

    private boolean validateAll() {
        if (Alcohol_no.isSelected() || Alcohol_si.isSelected()) {
            if (Tabaco_si.isSelected() || Tabaco_no.isSelected()) {
                if (Drogras_si.isSelected() || Drogas_no.isSelected()) {
                    if (Infuciones_si.isSelected() || Infuciones_no.isSelected()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private void actualizar(ActionEvent e) {
        if (validateAll() == false || Alimentacion.getText().isEmpty() || Diuresis.getText().isEmpty()
                || Catarsis.getText().isEmpty() || Sueño.getText().isEmpty() || Enfermedad.getText().isEmpty()) {
            Mensaje.MensajeError("ERROR: NO PUEDES DEJAR LOS CAMPOS VACÍOS", "CAMPOS VACÍOS");

        } else {
            String ConsumeAlcohol = "";
            if (Alcohol_si.isSelected()) {
                ConsumeAlcohol = Alcohol_si.getText() + " " + Alcohol_des.getText();
            } else {
                ConsumeAlcohol = Alcohol_no.getText() + " " + Alcohol_des.getText();
            }
            String ConsumeTabaco = "";
            if (Tabaco_si.isSelected()) {
                ConsumeTabaco = Tabaco_si.getText() + " " + Tabaco_des.getText();
            } else {
                ConsumeTabaco = Tabaco_no.getText() + " " + Tabaco_des.getText();
            }
            String ConsumeDrogas = "";
            if (Drogras_si.isSelected()) {
                ConsumeDrogas = Drogras_si.getText() + " " + Drogas_des.getText();
            } else {
                ConsumeDrogas = Drogas_no.getText() + " " + Drogas_des.getText();
            }
            String ConsumeInfusiones = "";
            if (Infuciones_si.isSelected()) {
                ConsumeInfusiones = Infuciones_si.getText() + " " + Infuciones_des.getText();
            } else {
                ConsumeInfusiones = Infuciones_no.getText() + " " + Infuciones_des.getText();
            }

            historialDBO = new HistoriaClinica_DBO( ActHC.lbl_codigo.getText(),
                    ConsumeAlcohol, ConsumeTabaco, ConsumeDrogas,
                    ConsumeInfusiones, Alimentacion.getText(), Diuresis.getText(), Catarsis.getText(),
                    Sueño.getText(), Enfermedad.getText());

            HistorialClinico_DAO daoHC = new HistorialClinico_DAO();
            if (daoHC.ActualizarPac(historialDBO, DNI.getText()) != false) {
                Mensaje.MensajeConformidad("ACCIÓN COMPLETADA!", "MENSAJE");

                desactivartodo();
            }
        }
    }

    public boolean primeravez = true;

    public void limpiar() {
        int result = 0;
        if (primeravez) {
            result = JOptionPane.showConfirmDialog(
                    null, "¿DESEA LIMPIAR TODOS LOS CAMPOS?", "CONFIRMAR", JOptionPane.YES_NO_OPTION
            );
        }
        if (result == 0) {
            Seteo.SeteoTextField(ActHC.jPanel1);
            Seteo.SeteoCheckbox(ActHC.PanelMas);
            Seteo.SeteoTextField(ActHC.PanelMas);
            Seteo.SeteoCheckbox(ActHC.PanelConsume);
            Seteo.SeteoTextField(ActHC.PanelConsume);

            Icon icono = new ImageIcon(imagenIcon.getImage());
            Foto.setIcon(icono);
            DNI.requestFocus();
        }
        primeravez = true;
    }

    public void desactivartodo() {
        primeravez = false;
        limpiar();
        Enable.DesactivarRSTextField(ActHC.PanelConsume);
        Enable.DesactivarRSTextField(ActHC.PanelMas);
        Enable.DesactivarJCheckBox(ActHC.PanelConsume);
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
