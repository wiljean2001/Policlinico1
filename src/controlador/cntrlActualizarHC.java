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
import Vistas.ActualizarHC;
import app.bolivia.swing.JCTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JCheckBox;
import rojeru_san.RSButtonRiple;

/**
 *
 * @author wil-laptop
 */
public class cntrlActualizarHC implements KeyListener, MouseListener, ActionListener {

    private RSButtonRiple buttonBuscarP, buttonRegistrarHC;
    //copiar
    private JCTextField Alcohol_des, Tabaco_des, Drogas_des, Infuciones_des,
            Alimentacion, Diuresis, Catarsis, Sueño, Enfermedad, DNI;
    private JCheckBox Alcohol_si, Alcohol_no, Tabaco_si, Tabaco_no, Drogras_si,
            Drogas_no, Infuciones_si, Infuciones_no;
    HistoriaClinica_DBO historialDBO;
    
    private ActualizarHC ActHC;
    
    public cntrlActualizarHC (ActualizarHC ActHC){
        this.ActHC = ActHC;
        acciones(ActHC);
    }
    private void acciones(ActualizarHC ActHC) {

        Alcohol_des = ActHC.txtalcohol;
        Tabaco_des = ActHC.txttabaco;
        Drogas_des = ActHC.txtdrogas;
        Infuciones_des = ActHC.txtinfuciones;

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

        //botones
        buttonBuscarP = ActHC.ButtonBuscarHC;
        buttonRegistrarHC = ActHC.ButtonActualizarHC;
        
        buttonBuscarP.addActionListener(this);
        buttonRegistrarHC.addActionListener(this);
    }
    private void actualizar(ActionEvent e) {
        
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
                daoHC.ActualizarHC(historialDBO, DNI.getText(), Usuario_DBO.IDMedico);

                Mensaje.MensajeConformidad("ACCIÓN COMPLETADA!", "MENSAJE");
            }
        }
        if (e.getSource() == buttonBuscarP) {
            
            Hospital_v2.FBHC.setVisible(true);
            
            
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

    @Override
    public void mouseClicked(MouseEvent e) {
       
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
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
    public void actionPerformed(ActionEvent e) {
       
    }

    
   
}
