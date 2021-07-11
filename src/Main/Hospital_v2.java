package Main;

import Vistas.*;
import controlador.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author HP-Litzy-Jean
 */
public class Hospital_v2 {

    //formularios
    public static ActualizarHC FAHC;
    //public static ActualizarP FAP;
    public static BuscarHC FBHC;
    public static BuscarPaciente FBP;
    public static Cargando FC = new Cargando();
    public static Login FL;
    public static MenuMedicos FMM;
    public static MenuRecep FMR;
    public static RegistrarHC FRHC;
    public static RegistrarP FRP;
    public static TablaImagen CTI;
    public static ActualizarPac FAP;
    
    //controladores
    public static cntrlActualizarHC cAHC;
    public static cntrlActualizarP cAP;
    public static cntrlBuscarHC cBHC;
    public static cntrlBuscarP cBP;
    public static cntrlLoading cL;
    public static cntrlLogin cLO;
    public static cntrlMenuMedicos cMM;
    public static cntrlMenuRecep cMR;
    public static cntrlRegistrarHC cRHC;
    public static cntrlRegistrarP cRP;

    public static void main(String[] args) {
        // "com.sun.java.swing.plaf.windows.WindowsLookAndFeel"  org.jdesktop.swingx.plaf.windows.WindowsClassicLookAndFeelAddons();
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Cargando.class.getName()).log(Level.SEVERE, null, ex);
        }
        //
        cL = new cntrlLoading(FC);
        FC.setVisible(true);
        FC = null;
        cL = null;

        FL = new Login();
        FRHC = new RegistrarHC();
        FAHC = new ActualizarHC();
        FAP = new ActualizarPac();
        FBHC = new BuscarHC(null, true);
        FBP = new BuscarPaciente(null, true);
        FMM = new MenuMedicos();
        FMR = new MenuRecep();
        FRP = new RegistrarP();
        //
        ImageIcon IconoFRHC = new ImageIcon(Hospital_v2.class.getResource("/recursos2/Button Add.png"));
        ImageIcon IconoFRP = new ImageIcon(Hospital_v2.class.getResource("/recursos2/Button Add.png")); // 
        ImageIcon IconoFAHC = new ImageIcon(Hospital_v2.class.getResource("/recursos2/btnEditar.png"));
        ImageIcon IconoFAP = new ImageIcon(Hospital_v2.class.getResource("/recursos2/btnEditar.png"));
        ImageIcon IconoFMM = new ImageIcon(Hospital_v2.class.getResource("/recursos2/btnHome.png"));
        ImageIcon IconoFMR = new ImageIcon(Hospital_v2.class.getResource("/recursos2/btnHome.png"));
        ImageIcon IconoFBP = new ImageIcon(Hospital_v2.class.getResource("/recursos2/btnVer.png"));
        ImageIcon IconoFBHC = new ImageIcon(Hospital_v2.class.getResource("/recursos2/btnVer.png"));
        //ImageIcon IconoFL = new ImageIcon(Hospital_v2.class.getResource("/recursos/hospital-cargando.gif"));
        //ImageIcon IconocL = new ImageIcon(Hospital_v2.class.getResource("/recursos/hospital-cargando.gif"));
        FRHC.setFrameIcon(IconoFRHC);
        FAHC.setFrameIcon(IconoFAHC);

        FAP.setFrameIcon(IconoFAP);
        FBP.setIconImage(IconoFBP.getImage());

        FRP.setFrameIcon(IconoFRP);
        FBHC.setIconImage(IconoFBHC.getImage());

        FMM.setIconImage(IconoFMM.getImage());
        FMR.setIconImage(IconoFMR.getImage());
        //FL.setIconImage(IconoFL.getImage());
        //FMR.setIconImage(IconocL.getImage());
        cLO = new cntrlLogin(FL);
        cRHC = new cntrlRegistrarHC(FRHC);
        cAHC = new cntrlActualizarHC(FAHC);
        cAP = new cntrlActualizarP(FAP);
        cBHC = new cntrlBuscarHC(FBHC);
        cBP = new cntrlBuscarP(FBP);
        cMM = new cntrlMenuMedicos(FMM);
        cMR = new cntrlMenuRecep(FMR);
        cRP = new cntrlRegistrarP(FRP);
    }
}
