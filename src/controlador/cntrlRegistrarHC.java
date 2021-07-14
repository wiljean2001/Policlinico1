package controlador;

import DAO.HistorialClinico_DAO;
import DBO.HistoriaClinica_DBO;
import Interfaces.Enable;
import Interfaces.Mensaje;
import Interfaces.Seteo;
import Main.Hospital_v2;
import Vistas.RegistrarHC;
import app.bolivia.swing.JCTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import rojeru_san.RSButtonRiple;
import rojerusan.RSLabelImage;

public class cntrlRegistrarHC implements ActionListener, KeyListener {

    private RSButtonRiple buttonBuscarHC, buttonRegistrarHC;
    private JCTextField Alcohol_des, Tabaco_des, Drogas_des, Infuciones_des,
            Alimentacion, Diuresis, Catarsis, Sueño, Enfermedad, DNI;
    private JCheckBox Alcohol_si, Alcohol_no, Tabaco_si, Tabaco_no, Drogras_si,
            Drogas_no, Infuciones_si, Infuciones_no;
    private HistoriaClinica_DBO historialDBO;
    private Date fecha = new Date();
    private String CodigoGenerado;
    private RSLabelImage Foto;
    private JLabel txtCodigoHC, lbl_fecha;
    private String DateFormato = "YYYY-MM-dd";
    private SimpleDateFormat formato = new SimpleDateFormat(DateFormato);
    private RegistrarHC rHC;
    private final ImageIcon imagenIcon;

    public cntrlRegistrarHC(RegistrarHC rHC) {
        
        eventos(rHC);
        imagenIcon = new ImageIcon(cntrlRegistrarP.class.getResource("/recursos2/descarga.png"));
        desactivartodo();

    }

    private void eventos(RegistrarHC rHC) {
        //txt
        this.rHC = rHC;
        DNI = rHC.txtDNI;
        txtCodigoHC = rHC.lbl_codigo;
        Alcohol_des = rHC.txtalcohol;
        Tabaco_des = rHC.txttabaco;
        Drogas_des = rHC.txtdrogas;
        Infuciones_des = rHC.txtinfuciones;
        Foto = rHC.Foto;
        lbl_fecha = rHC.lbl_fecha;

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

    private final int maximo = 10000;
    private final int minimo = 99999;
    private ArrayList<HistoriaClinica_DBO> h;
    private boolean codigoExiste = false;
    private int aleatorio;

    private String GenerarCodHC() {
        HistorialClinico_DAO daoHC = new HistorialClinico_DAO();

        aleatorio = (int) Math.floor(Math.random() * (maximo - minimo + 1)) + minimo;
        String cod = String.valueOf(aleatorio);
        h = daoHC.BuscarHC(cod);
        if (h.isEmpty()) {
            return cod;
        } else {
            for (HistoriaClinica_DBO object : h) {
                if (object.getCodigoHC().equals(cod)) {
                    codigoExiste = true;
                } else {
                    codigoExiste = false;
                }
            }
            if (codigoExiste) {
                return cod;
            }
        }
        daoHC = null;
        return GenerarCodHC();
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

            if (validateAll() == false || Alimentacion.getText().length() < 2 || Diuresis.getText().length() < 2
                    || Catarsis.getText().length() < 2 || Sueño.getText().length() < 2 || Enfermedad.getText().length() < 2) {

                if (validateAll() == false || Alimentacion.getText().isEmpty() || Diuresis.getText().isEmpty()
                        || Catarsis.getText().isEmpty() || Sueño.getText().isEmpty() || Enfermedad.getText().isEmpty()) {
                    Mensaje.MensajeError("NO PUEDES DEJAR LOS CAMPOS VACÍOS", "CAMPOS VACÍOS");
                } else {
                    Mensaje.MensajeError("INGRESE LOS DATOS COMPLETOS", "DATOS INCOMPLETOS");
                }
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
                CodigoGenerado = txtCodigoHC.getText();
                historialDBO = new HistoriaClinica_DBO(
                        CodigoGenerado, fecha, ConsumeAlcohol, ConsumeTabaco, ConsumeDrogas,
                        ConsumeInfusiones, Alimentacion.getText(), Diuresis.getText(), Catarsis.getText(),
                        Sueño.getText(), Enfermedad.getText());
                HistorialClinico_DAO daoHC = new HistorialClinico_DAO();
                if (daoHC.RegistrarHC(historialDBO, DNI.getText()) != false) {
                    Mensaje.MensajeConformidad("ACCIÓN COMPLETADA!", "MENSAJE");
                    //JOptionPane.OK_CANCEL_OPTION

                    desactivartodo();
                }

            }
        }
        if (e.getSource() == buttonBuscarHC) {
            Hospital_v2.FBP.ButtonEnviarPaciente.setVisible(true);
            Hospital_v2.cBP.ventanaAnterior = 1;
            Hospital_v2.FRHC.setVisible(false);
            //Hospital_v2.FBP.setSize(new Dimension());
            Hospital_v2.FBP.setVisible(true);

            txtCodigoHC.setText(GenerarCodHC());
            rHC.lbl_fecha.setText(formato.format(fecha));
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

    public void desactivartodo() {
        primeravez = false;
        limpiar();
        Enable.DesactivarRSTextField(rHC.PanelConsume);
        Enable.DesactivarRSTextField(rHC.PanelMas);
        Enable.DesactivarJCheckBox(rHC.PanelConsume);
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
            Seteo.SeteoTextField(rHC.jPanel1);
            Seteo.SeteoCheckbox(rHC.PanelMas);
            Seteo.SeteoTextField(rHC.PanelMas);
            Seteo.SeteoCheckbox(rHC.PanelConsume);
            Seteo.SeteoTextField(rHC.PanelConsume);
            txtCodigoHC.setText("");
            lbl_fecha.setText("");

            Icon icono = new ImageIcon(imagenIcon.getImage());
            Foto.setIcon(icono);
            DNI.requestFocus();
        }
        primeravez = true;
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
