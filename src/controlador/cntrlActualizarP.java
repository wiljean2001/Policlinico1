package controlador;

import DAO.Paciente_DAO;
import DBO.Paciente_DBO;
import Interfaces.Enable;
import Interfaces.Mensaje;
import Interfaces.Seteo;
import Main.Hospital_v2;
import Vistas.ActualizarPac;
import app.bolivia.swing.JCTextField;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import rojerusan.RSLabelImage;

public class cntrlActualizarP
        implements KeyListener, MouseListener {

    private JButton button_ActP, button_Limpiar, button_BuscarPaciente;
    private JCTextField DNI, apellidos, nombres, Direccion, telefono;
    private JCheckBox SexoH, SexoM, EstadoCivil_Sol, EstadoCivil_Cas, EstadoCivil_viud, EstadoCivil_Div;
    private JDateChooser FechadeNacimiento;
    private RSLabelImage Foto;
    private JLabel button_Foto;
    private ActualizarPac ActP;
    private final int altoActp = Hospital_v2.FBP.getHeight();
    private final int anchoActp = Hospital_v2.FBP.getWidth();

    private File rutaImagen = null;
    private final ImageIcon imagenIcon;
    private byte[] fotoByte = null;

    public cntrlActualizarP(ActualizarPac ActP) {
        this.ActP = ActP;
        acciones(ActP);
        Foto.setCursor(new Cursor(Cursor.HAND_CURSOR));
        imagenIcon = new ImageIcon(cntrlRegistrarP.class.getResource("/recursos2/descarga.png"));
        JTextFieldDateEditor editor = (JTextFieldDateEditor) FechadeNacimiento.getDateEditor();
        editor.setEditable(false);
        FechadeNacimiento.setMaxSelectableDate(new Date());
        FechadeNacimiento.setEnabled(false);
        Enable.DesactivarRSTextField(ActP.jPanel1);
        Enable.DesactivarJCheckBox(ActP.jPanel2);
        Enable.DesactivarJCheckBox(ActP.jPanel4);
    }

    private void acciones(ActualizarPac ActP) {
        DNI = ActP.txt_DNI;
        apellidos = ActP.txt_Apellidos;
        nombres = ActP.txt_Nombres;
        Direccion = ActP.txt_Direccion;
        telefono = ActP.txt_Telefono;
        FechadeNacimiento = ActP.Calendar_FechaNac;
        Foto = ActP.Foto;
        button_Foto = ActP.Button_CargarFoto;

        button_Foto.addMouseListener(this);
        DNI.addKeyListener(this);
        apellidos.addKeyListener(this);
        nombres.addKeyListener(this);
        Direccion.addKeyListener(this);
        telefono.addKeyListener(this);

        //Checkbox
        SexoH = ActP.Check_Hombre;
        SexoM = ActP.Check_Mujer;
        EstadoCivil_Sol = ActP.Check_Soltero;
        EstadoCivil_Cas = ActP.Check_Casado;
        EstadoCivil_viud = ActP.Check_Viudo;
        EstadoCivil_Div = ActP.Check_Divorciado;

        SexoH.addMouseListener(this);
        SexoM.addMouseListener(this);
        EstadoCivil_Sol.addMouseListener(this);
        EstadoCivil_Cas.addMouseListener(this);
        EstadoCivil_viud.addMouseListener(this);
        EstadoCivil_Div.addMouseListener(this);
        // Botones :---------------
        button_ActP = ActP.ButtonActualizarPac;
        button_Limpiar = ActP.ButtonLimpiarTodo;
        button_BuscarPaciente = ActP.ButtonBuscarP;
        Foto.addMouseListener(this);

        button_ActP.addMouseListener(this);
        button_Limpiar.addMouseListener(this);
        button_BuscarPaciente.addMouseListener(this);
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
            Seteo.SeteoTextField(ActP.jPanel1);
            Seteo.SeteoJCalendar(FechadeNacimiento);
            Seteo.SeteoCheckbox(ActP.jPanel2);
            Seteo.SeteoCheckbox(ActP.jPanel4);

            Icon icono = new ImageIcon(imagenIcon.getImage());
            Foto.setIcon(icono);
            rutaImagen = null;
        }
        primeravez = true;
    }

    private void actualizar() {
        SimpleDateFormat formato = new SimpleDateFormat(
                FechadeNacimiento.getDateFormatString()
        );

        if (DNI.getText().isEmpty() || apellidos.getText().isEmpty()
                || nombres.getText().isEmpty() || Direccion.getText().isEmpty()
                || formato.format(FechadeNacimiento.getDate()).isEmpty()) {

            Mensaje.MensajeError("ERROR: NO PUEDES DEJAR LOS CAMPOS VACÍOS", "CAMPOS VACÍOS");
        } else {
            char Sexo = 0;
            if (SexoH.isSelected()) {
                Sexo = SexoH.getText().charAt(0);
            } else {
                Sexo = SexoM.getText().charAt(0);
            }
            String EstadoCivil = "";
            if (EstadoCivil_Cas.isSelected()) {
                EstadoCivil = EstadoCivil_Cas.getText();
            } else if (EstadoCivil_Sol.isSelected()) {
                EstadoCivil = EstadoCivil_Sol.getText();
            } else if (EstadoCivil_Div.isSelected()) {
                EstadoCivil = EstadoCivil_Div.getText();
            } else if (EstadoCivil_viud.isSelected()) {
                EstadoCivil = EstadoCivil_viud.getText();
            }
            if (rutaImagen != null) {
                // falta enviar nulos
                try {
                    JOptionPane.showMessageDialog(null, "" + rutaImagen);
                    fotoByte = Files.readAllBytes(rutaImagen.toPath());
                } catch (IOException e) {
                }
            }

            Paciente_DBO pacienteDBO;
            Paciente_DAO pacientedao = new Paciente_DAO();

            if (DNI.getText().length() < 8) {
                Mensaje.MensajeError("DNI CON DIGITOS FALTANTE", "ERROR DE ACTUALIZACIÓN");
            } else {
                if (telefono.getText().length() < 5) {
                    Mensaje.MensajeError("TELEFONO CON DIGITOS FALTANTE", "ERROR DE ACTUALIZACIÓN");
                } else {
                    pacienteDBO = new Paciente_DBO(
                            DNI.getText(), FechadeNacimiento.getDate(),
                            telefono.getText(), apellidos.getText(), nombres.getText(),
                            Direccion.getText(), Sexo, 0, EstadoCivil, fotoByte);

                    if (pacientedao.ActualizarPac(pacienteDBO.retornarPac()) != false) {
                        Mensaje.MensajeConformidad("ACCIÓN COMPLETADA!", "MENSAJE");

                        primeravez = false;
                        limpiar();
                        Enable.DesactivarRSTextField(ActP.jPanel1);
                        //JOptionPane.OK_CANCEL_OPTION
                    }
                }
            }
        }
    }

    private File abrirImagen() {
        JFileChooser jf = new JFileChooser();
        jf.setDialogTitle("BUSCAR FOTO");
        //solo puedo selecionar archivos(txt o musica o imagen pero no carpetas: no directorios
        jf.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        //solo puedo seleccionar un archivo a la vez no varios a la vez
        jf.setMultiSelectionEnabled(false);
        //aqui filtro lo que quiero que se cargue
        //si solo permito mp3 lo pongo o si solo admito jpj, primero pongo la descripcion del archivo y luego el tipo de archivo
        //FileNameExtensionFilter filtro=new FileNameExtensionFilter("Descripcion de archivo","wav","Archivo Audio MP3","mp3","archivo imagen JPG","jpg");
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivo imagen JPG, PNG, GIF", "jpg", "png", "gif");
        jf.setFileFilter(filter);
        //mostrar el gestor de archivos y no deja hacer nada hasta que se selcione el archivo o me salga con cancelar
        jf.showOpenDialog(ActP);
        //agarre lo que seleciona
        File seleccion_ruta = jf.getSelectedFile();
        //si la selccion es diferente de null , pasela a txt
        if (seleccion_ruta != null && seleccion_ruta.length() <= 1024000) {
            try {
                ImageIcon imgi;
                imgi = null;
                BufferedImage image = ImageIO.read(seleccion_ruta);
                imgi = new ImageIcon(image);

                Foto.setIcon(imgi);
                rutaImagen = seleccion_ruta;
                return seleccion_ruta;
            } catch (IOException e) {

            }
        }
        return null;
    }
    

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource() == button_ActP) {
            actualizar();
        }
//
        if (e.getSource() == button_Limpiar) {
            limpiar();
        }
        if (e.getSource() == button_BuscarPaciente) {
            primeravez = false;
            limpiar();
            Hospital_v2.cBP.limpiar();
            button_BuscarPaciente.setEnabled(true);
            ActP.dispose();
            Hospital_v2.FBP.ButtonEnviarPaciente.setVisible(true);
            // redimensioar para restar la altura del botón aceptar (por estética)
            Hospital_v2.FBP.setSize(new Dimension(
                    anchoActp,  altoActp));
            Hospital_v2.FBP.setVisible(true);

        }
        if (e.getSource() == SexoH) {
            SexoM.setSelected(false);

        }
        if (e.getSource() == SexoM) {
            SexoH.setSelected(false);

        }
        if (e.getSource() == EstadoCivil_Sol) {
            EstadoCivil_Cas.setSelected(false);
            EstadoCivil_viud.setSelected(false);
            EstadoCivil_Div.setSelected(false);

        }
        if (e.getSource() == EstadoCivil_Cas) {
            EstadoCivil_Sol.setSelected(false);
            EstadoCivil_viud.setSelected(false);
            EstadoCivil_Div.setSelected(false);

        }
        if (e.getSource() == EstadoCivil_viud) {
            EstadoCivil_Sol.setSelected(false);
            EstadoCivil_Cas.setSelected(false);
            EstadoCivil_Div.setSelected(false);

        }
        if (e.getSource() == EstadoCivil_Div) {
            EstadoCivil_Cas.setSelected(false);
            EstadoCivil_viud.setSelected(false);
            EstadoCivil_Sol.setSelected(false);
        }

        if (e.getSource() == Foto || e.getSource() == button_Foto) {
            if (!Foto.isEnabled()) {
                abrirImagen();
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e
    ) {

    }

    @Override
    public void mouseEntered(MouseEvent e
    ) {

    }

    @Override
    public void mouseExited(MouseEvent e
    ) {

    }

    @Override
    public void keyReleased(KeyEvent e
    ) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e
    ) {

    }

}
