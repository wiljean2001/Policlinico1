package controlador;

import DAO.Paciente_DAO;
import DBO.Paciente_DBO;
import Interfaces.Mensaje;
import Interfaces.Seteo;
import RSMaterialComponent.RSCheckBoxMaterial;
import Vistas.RegistrarP;
import app.bolivia.swing.JCTextField;
import rojerusan.RSDateChooser;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.swing.JButton;
import java.nio.file.Files;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.Cursor;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import rojerusan.RSLabelImage;

public class cntrlRegistrarP implements KeyListener, MouseListener {

    private JButton button_Reg, button_Limpiar;
    private JCTextField DNI, apellidos, nombres, Direccion, telefono;
    private RSCheckBoxMaterial SexoH, SexoM, EstadoCivil_Sol, EstadoCivil_Cas, EstadoCivil_viud, EstadoCivil_Div;
    private RSDateChooser FechadeNacimiento;
    private RSLabelImage Foto;
    private JLabel button_Foto;
    private RegistrarP r;
    private File rutaImagen = null;
    private final ImageIcon imagenIcon;
    private byte[] fotoByte = null;

    public cntrlRegistrarP(RegistrarP r) {
        this.r = r;
        ListenerEventos(r);
        Foto.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button_Foto.setCursor(new Cursor(Cursor.HAND_CURSOR));
        imagenIcon = new ImageIcon(cntrlRegistrarP.class.getResource("/recursos2/descarga.png"));
        DNI.requestFocus();
    }

    private void ListenerEventos(RegistrarP r) {
        // textfield y otros : --------------------------
        DNI = r.txt_DNI;
        apellidos = r.txt_Apellidos;
        nombres = r.txt_Nombres;
        Direccion = r.txt_Direccion;
        telefono = r.txt_Telefono;
        FechadeNacimiento = r.Calendar_FechaNac;
        Foto = r.Foto;
        button_Foto = r.Button_CargarFoto;

        DNI.addKeyListener(this);
        apellidos.addKeyListener(this);
        nombres.addKeyListener(this);
        Direccion.addKeyListener(this);
        telefono.addKeyListener(this);

        //Checkbox
        SexoH = r.Check_Hombre;
        SexoM = r.Check_Mujer;
        EstadoCivil_Sol = r.Check_Soltero;
        EstadoCivil_Cas = r.Check_Casado;
        EstadoCivil_viud = r.Check_Viudo;
        EstadoCivil_Div = r.Check_Divorciado;

        SexoH.addMouseListener(this);
        SexoM.addMouseListener(this);
        EstadoCivil_Sol.addMouseListener(this);
        EstadoCivil_Cas.addMouseListener(this);
        EstadoCivil_viud.addMouseListener(this);
        EstadoCivil_Div.addMouseListener(this);

        // Botones :---------------
        button_Reg = r.ButtonRegistrarP;
        button_Limpiar = r.ButtonLimpiarTodo;

        button_Foto.addMouseListener(this);
        Foto.addMouseListener(this);
        button_Reg.addMouseListener(this);
        button_Limpiar.addMouseListener(this);
        FechadeNacimiento.addMouseListener(this);
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
            Seteo.SeteoTextField(r.jPanel1);
            Seteo.SeteoJCalendar(FechadeNacimiento);
            Seteo.SeteoCheckbox(r.jPanel2);
            Seteo.SeteoCheckbox(r.jPanel4);

            Icon icono = new ImageIcon(imagenIcon.getImage());
            Foto.setIcon(icono);
            rutaImagen = null;
            DNI.requestFocus();
        }
        primeravez = true;
    }

    private boolean validarCheck() {
        // SexoH, SexoM, EstadoCivil_Sol, EstadoCivil_Cas, EstadoCivil_viud, EstadoCivil_Div; 
        if ((SexoH.isSelected() || SexoM.isSelected())
                && (EstadoCivil_Sol.isSelected() || EstadoCivil_Cas.isSelected()
                || EstadoCivil_viud.isSelected() || EstadoCivil_Div.isSelected())) {
            return true;
        }
        return false;
    }

    private void bottonRegistrar() {
        if (validarCheck() == false || DNI.getText().isEmpty() || apellidos.getText().isEmpty()
                || nombres.getText().isEmpty() || Direccion.getText().isEmpty()
                || FechadeNacimiento.getFechaSeleccionada().isEmpty()) {

            Mensaje.MensajeError("NO PUEDES DEJAR LOS CAMPOS VACÍOS", "CAMPOS VACÍOS");

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

            Paciente_DBO pacienteDBO;
            if (rutaImagen != null) {
                // falta enviar nulos
                try {
                    fotoByte = Files.readAllBytes(rutaImagen.toPath());
                } catch (IOException e) {
                }
            }
            // validar DNI
            if (DNI.getText().length() == 8) {
                if (telefono.getText().length() < 5) {
                    Mensaje.MensajeError("TELEFONO CON DIGITOS FALTANTE", "ERROR DE REGISTRO");
                } else {
                    SimpleDateFormat formato = new SimpleDateFormat(FechadeNacimiento.getFormatoFecha());
                    Date fecha = null;
                    try {
                        fecha = formato.parse(FechadeNacimiento.getFechaSeleccionada());
                    } catch (ParseException e) {
                    }

                    pacienteDBO = new Paciente_DBO(
                            DNI.getText(), fecha,
                            telefono.getText(), apellidos.getText(), nombres.getText(),
                            Direccion.getText(), Sexo, 0, EstadoCivil, fotoByte
                    );

                    Paciente_DAO registrarDAO = new Paciente_DAO();
                    primeravez = false;
                    if (registrarDAO.RegistrarPac(pacienteDBO.retornarPac()) != false) {
                        Mensaje.MensajeConformidad("ACCIÓN COMPLETADA!", "MENSAJE");
                        //JOptionPane.OK_CANCEL_OPTION
                    }
                    limpiar();
                }
            } else {
                Mensaje.MensajeError("DNI INCORRECTO", "ERROR DE REGISTRO");

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
        jf.showOpenDialog(r);
        //agarre lo que seleciona
        File seleccion_ruta = jf.getSelectedFile();
        //si la selccion es diferente de null , pasela a txt
        if (seleccion_ruta != null && seleccion_ruta.length() <= 1024000) {
            try {
                ImageIcon imgi = null;
                BufferedImage image = ImageIO.read(seleccion_ruta);
                imgi = new ImageIcon(image);

                Foto.setIcon(imgi);
                rutaImagen = seleccion_ruta;
                return seleccion_ruta;
            } catch (IOException e) {
            }
        }else{
            Mensaje.MensajeError("EL TAMAÑO DE LA IMAGEN EXCEDE 1Mb","TAMAÑO EXCEDIDO");
        }
        return null;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

        //Solo Numeros
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
        // 
        if (e.getSource() == apellidos) {
            a = e.getKeyChar();
            if (apellidos.getText().length() < 50) {
                if (!Character.isAlphabetic(a) && !Character.isSpaceChar(a)) {
                    e.consume();
                    Toolkit.getDefaultToolkit().beep();
                }
            } else {
                e.consume();
                Toolkit.getDefaultToolkit().beep();
            }
        }
        if (e.getSource() == nombres) {
            a = e.getKeyChar();
            if (nombres.getText().length() < 50) {
                if (!Character.isAlphabetic(a) && !Character.isSpaceChar(a)) {
                    e.consume();
                    Toolkit.getDefaultToolkit().beep();
                }
            } else {
                e.consume();
                Toolkit.getDefaultToolkit().beep();
            }
        }

        e.getKeyChar();
        if (e.getKeyChar() == KeyEvent.VK_ENTER) {
            bottonRegistrar();
        }
        if (e.getSource() == telefono) {
            a = e.getKeyChar();
            if (telefono.getText().length() < 9) {
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

    /*
    if (Foto.getRutaImagen() != null) {
                Foto
                if(iseliminado == false){
                    
                }
                try {
                    File ruta = new File(Foto.getRutaImagen());
                    foto = Files.readAllBytes(ruta.toPath());
                } catch (IOException e) {
                }
            }
    */
    
    @Override
    public void keyPressed(KeyEvent e
    ) {

    }

    @Override
    public void keyReleased(KeyEvent e
    ) {

    }

    @Override
    public void mousePressed(MouseEvent e
    ) {
        if (e.getSource() == button_Limpiar) {
            limpiar();
        }
        if (e.getSource() == button_Reg) {
            bottonRegistrar();

        }

        if (e.getSource() == Foto || e.getSource() == button_Foto) {
            abrirImagen();
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

    /*
    public static boolean ValidateIdentificationDocumentPeru(String identificationDocument) {
        if (identificationDocument != null) {
            int addition = 0;
            // int[] hash = { 5, 4, 3, 2, 7, 6, 5, 4, 3, 2 };
            int[] hash = {3, 2, 7, 6, 5, 4, 3, 2};
            int identificationDocumentLength = identificationDocument.length();

            String identificationComponent = identificationDocument.substring(0, identificationDocumentLength - 1);

            int identificationComponentLength = identificationComponent.length();

            int diff = hash.length - identificationComponentLength;

            for (int i = 0; i < identificationDocument.length(); i++) {
                addition += Integer.parseInt(identificationDocument.substring(i, 1)) * hash[i];
            }

            addition = 11 - (addition % 11);
            int abc = addition;
            if (addition == 11) {
                addition = 0;
            } else if (addition == 10) {
                addition = 1;

            }

            //  char last = char.ToUpperInvariant(identificationDocument[identificationDocumentLength - 1]);
            String dcontrol = identificationDocument.substring(0, 1);

            char last = dcontrol.charAt(0);
            if (identificationDocumentLength == 11) {
                // The identification document corresponds to a RUC.
                if(last == '0' && String.valueOf(addition).charAt(0) == last){
                    return true;
                }
                return false;
                //return addition.equals(last - '0');
            }
            
                
                else if (Character.isDigit(last))
                {
                    // The identification document corresponds to a DNI with a number as verification digit.
                    //char[] hashNumbers = { '6', '7', '8', '9', '0', '1', '1', '2', '3', '4', '5' };
                    char[] hashNumbers = { '6', '7', '8', '9', '0', '1', '1', '2', '3', '4','5','6'};
                    if(hashNumbers[addition] == last){
                        return true;
                    }
                    return false;
                    //return last.Equals(hashNumbers[addition]);
                }
                else if (Character.isLetter(last))
                {
                    // The identification document corresponds to a DNI with a letter as verification digit.
                    char[] hashLetters = { 'K', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J' };
                    if(hashLetters[addition] == last){
                        return true;
                    }
                    return false;
                    //return last.Equals(hashLetters[addition]);
                }
            
        }

        return false;
    }
     */
}
