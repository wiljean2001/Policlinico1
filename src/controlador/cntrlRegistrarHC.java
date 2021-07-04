package controlador;

import DAO.HistorialClinico_DAO;
import DBO.HistoriaClinica_DBO;
import Interfaces.Mensaje;
import Main.Hospital_v2;
import Vistas.RegistrarHC;
import app.bolivia.swing.JCTextField;
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

    private RSButtonRiple buttonBuscarHC, buttonRegistrarHC;
    //copiar
    private JCTextField Alcohol_des, Tabaco_des, Drogas_des, Infuciones_des,
            Alimentacion, Diuresis, Catarsis, Sueño, Enfermedad, DNI;
    private JCheckBox Alcohol_si, Alcohol_no, Tabaco_si, Tabaco_no, Drogras_si,
            Drogas_no, Infuciones_si, Infuciones_no;
    HistoriaClinica_DBO historialDBO;
    Date fecha = new Date();
    String CodigoGenerado;

    private JLabel txtCodigoHC;
    String DateFormato = "hh//mm//ss a dd//MMM//YYYY";
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

        Alcohol_si.addActionListener(this);
        Alcohol_no.addActionListener(this);
        Tabaco_si.addActionListener(this);
        Tabaco_no.addActionListener(this);
        Drogras_si.addActionListener(this);
        Drogas_no.addActionListener(this);
        Infuciones_si.addActionListener(this);
        Infuciones_no.addActionListener(this);

        //botones
        buttonBuscarHC = rHC.ButtonBuscarP;
        buttonRegistrarHC = rHC.ButtonRegistrarHC;

        buttonBuscarHC.addActionListener(this);
        buttonRegistrarHC.addActionListener(this);
    }

    private void bottonRegistrarHC() {

    }
    private int codigo=0;
    private String GenerarCodHC() {
        String ceros = "00";
        codigo+=1;
        if(codigo==10){
            if(codigo==100){
                return "WA"+ codigo;
            }else{
                
                return "WA" + ceros.substring(0) + "" + codigo;
            }
        }else{
            return "WA"+ceros+""+codigo;
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
    ///                 VUELVO EN 30 MINUTS

    @Override
    public void actionPerformed(ActionEvent e) {
        // Registrar HC
        if (e.getSource() == buttonRegistrarHC) {

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
                daoHC.RegistrarHC(historialDBO, DNI.getText());
            }
        }
        if (e.getSource() == buttonBuscarHC) {
            Hospital_v2.FBP.ButtonEnviarPaciente.setVisible(true);
            
            Hospital_v2.cBP.ventanaAnterior = 1;
            Hospital_v2.FRHC.setVisible(false);
            Hospital_v2.FBP.setVisible(true);

            CodigoGenerado = GenerarCodHC();
            txtCodigoHC.setText(CodigoGenerado);
        }

        if (e.getSource() == Alcohol_no) {
            if (Alcohol_des.isEditable()) {
                Alcohol_des.setEditable(false);
                Alcohol_des.setText("");
            }
        }
        if (e.getSource() == Tabaco_no) {
            if (Tabaco_des.isEditable()) {
                Tabaco_des.setEditable(false);
                Tabaco_des.setText("");
            }
        }
        if (e.getSource() == Drogas_no) {
            if (Drogas_des.isEditable()) {
                Drogas_des.setEditable(false);
                Drogas_des.setText("");
            }
        }
        if (e.getSource() == Infuciones_no) {
            if (Infuciones_des.isEditable()) {
                Infuciones_des.setEditable(false);
                Infuciones_des.setText("");
            }
        }
        if (e.getSource() == Alcohol_si) {
            if (!Alcohol_des.isEditable()) {
                Alcohol_des.setEditable(true);
                Alcohol_des.setText("");
            }
        }
        if (e.getSource() == Tabaco_si) {
            if (!Tabaco_des.isEditable()) {
                Tabaco_des.setEditable(true);
            }
        }
        if (e.getSource() == Drogras_si) {
            if (!Drogas_des.isEditable()) {
                Drogas_des.setEditable(true);
            }
        }
        if (e.getSource() == Infuciones_si) {
            if (!Infuciones_des.isEditable()) {
                Infuciones_des.setEditable(true);
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
