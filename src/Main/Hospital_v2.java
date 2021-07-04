package Main;

import Vistas.*;
import controlador.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author HP-Litzy-Jean
 */
public class Hospital_v2 {

    //formularios
    public static ActualizarHC FAHC;
    public static ActualizarP FAP;
    public static BuscarHC FBHC;
    public static BuscarPaciente FBP;
    public static Cargando FC = new Cargando();
    public static Login FL;
    public static MenuMedicos FMM;
    public static MenuRecep FMR;
    public static RegistrarHC FRHC;
    public static RegistrarP FRP;
    public static TablaImagen CTI;
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
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Cargando.class.getName()).log(Level.SEVERE, null, ex);
        }
        cL = new cntrlLoading(FC);
        FC.setVisible(true);
        FC = null;
        cL = null;

        FAHC = new ActualizarHC();
        FAP = new ActualizarP();
        FBHC = new BuscarHC(null, true);
        FBP = new BuscarPaciente(null, true);
        FL = new Login();
        FMM = new MenuMedicos();
        FMR = new MenuRecep();
        FRHC = new RegistrarHC();
        FRP = new RegistrarP();
        //creamos los controlodores para manipular los formularios
        cAHC = new cntrlActualizarHC(FAHC);
        cAP = new cntrlActualizarP(FAP);
        cBHC = new cntrlBuscarHC(FBHC);
        cBP = new cntrlBuscarP(FBP);
        cLO = new cntrlLogin(FL);
        cMM = new cntrlMenuMedicos(FMM);
        cMR = new cntrlMenuRecep(FMR);
        cRHC = new cntrlRegistrarHC(FRHC);
        cRP = new cntrlRegistrarP(FRP);
    }

}
