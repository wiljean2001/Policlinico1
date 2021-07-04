/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import DAO.HistorialClinico_DAO;
import DBO.HistoriaClinica_DBO;
import DBO.Usuario_DBO;
import Interfaces.Mensaje;
import Main.Hospital_v2;
import Vistas.RegistrarHC;
import app.bolivia.swing.JCTextField;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import rojeru_san.RSButtonRiple;

public class cntrlRegistrarHC implements ActionListener, KeyListener {

    private RSButtonRiple buttonBuscarP, buttonRegistrarHC;
    //copiar
    private JCTextField Alcohol_des, Tabaco_des, Drogas_des, Infuciones_des,
            Alimentacion, Diuresis, Catarsis, Sueño, Enfermedad, DNI;
    private JCheckBox Alcohol_si, Alcohol_no, Tabaco_si, Tabaco_no, Drogras_si,
            Drogas_no, Infuciones_si, Infuciones_no;
    HistoriaClinica_DBO historialDBO;
    Date fecha = new Date();
    String CodigoGenerado;

    private JLabel txtCodigoHC;
    String DateFormato = "hh//mm//ss a dd//MMM//aaaa";
    SimpleDateFormat formato = new SimpleDateFormat(DateFormato);

    public cntrlRegistrarHC(RegistrarHC rHC) {

        rHC.lbl_fecha.setText(formato.format(fecha));
        eventos(rHC);
    }

    private void eventos(RegistrarHC rHC) {

        //txt
        DNI = rHC.txtDNI;
        txtCodigoHC = rHC.lbl_codigo;
        Alcohol_des = rHC.txtalcohol;
        Tabaco_des = rHC.txttabaco;
        Drogas_des = rHC.txtdrogas;
        Infuciones_des = rHC.txtinfuciones;

        Alimentacion = rHC.txt_alimentacion;
        Diuresis = rHC.txt_diuresis;
        Catarsis = rHC.txt_catarsis;
        Sueño = rHC.txt_sueño;
        Enfermedad = rHC.txt_enfermedad;

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
        Alcohol_si = rHC.Check_Alcoholsi;
        Alcohol_no = rHC.Check_Alcoholno;
        Tabaco_si = rHC.Check_Tabacosi;
        Tabaco_no = rHC.Check_Tabacono;
        Drogras_si = rHC.Check_Drogassi;
        Drogas_no = rHC.Check_Drogasno;
        Infuciones_si = rHC.Check_infucionessi;
        Infuciones_no = rHC.Check_infucionesno;

        //botones
        buttonBuscarP = rHC.ButtonBuscarP;
        buttonRegistrarHC = rHC.ButtonRegistrarHC;

        buttonBuscarP.addActionListener(this);
        buttonRegistrarHC.addActionListener(this);
    }

    private void bottonRegistrarHC() {

    }

    private String GenerarCodHC() {

        return "CodigoGenerado";
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Registrar HC
        if (e.getSource() == buttonRegistrarHC) {
            if (Alcohol_des.getText().isEmpty() || Tabaco_des.getText().isEmpty()
                    || Drogas_des.getText().isEmpty() || Infuciones_des.getText().isEmpty()
                    || Alimentacion.getText().isEmpty() || Diuresis.getText().isEmpty()
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
                if (Alcohol_si.isSelected()) {
                    ConsumeTabaco = Tabaco_si.getText() + " " + Tabaco_des.getText();
                } else {
                    ConsumeTabaco = Tabaco_no.getText() + " " + Tabaco_des.getText();
                }
                String ConsumeDrogas = "";
                if (Drogras_si.isSelected()) {
                    ConsumeTabaco = Drogras_si.getText() + " " + Drogas_des.getText();
                } else {
                    ConsumeTabaco = Drogas_no.getText() + " " + Drogas_des.getText();
                }
                String ConsumeInfusiones = "";
                if (Infuciones_si.isSelected()) {
                    ConsumeTabaco = Infuciones_si.getText() + " " + Infuciones_des.getText();
                } else {
                    ConsumeTabaco = Infuciones_no.getText() + " " + Infuciones_des.getText();
                }

                historialDBO = new HistoriaClinica_DBO(
                        CodigoGenerado, fecha, ConsumeAlcohol, ConsumeTabaco, ConsumeDrogas,
                        ConsumeInfusiones, Alimentacion.getText(), Diuresis.getText(), Catarsis.getText(),
                        Sueño.getText(), Enfermedad.getText());

                HistorialClinico_DAO daoHC = new HistorialClinico_DAO();
                daoHC.RegistrarPac(historialDBO, DNI.getText(), Usuario_DBO.IDMedico);

                Mensaje.MensajeConformidad("ACCIÓN COMPLETADA!", "MENSAJE");
            }
        }
        if (e.getSource() == buttonBuscarP) {
            Hospital_v2.cBP.ventanaAnterior = 1;
            Hospital_v2.FRHC.setVisible(false);
            Hospital_v2.FBP.setVisible(true);


            CodigoGenerado = GenerarCodHC();
            txtCodigoHC.setText(CodigoGenerado);
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
