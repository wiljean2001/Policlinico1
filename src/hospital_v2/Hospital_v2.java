package hospital_v2;

import Vistas.Cargando;
import controlador.cntrlLoading;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
/**
 *
 * @author HP-Litzy-Jean
 */
public class Hospital_v2 {
    
    public static void main(String[] args) {
        
        // "com.sun.java.swing.plaf.windows.WindowsLookAndFeel"  org.jdesktop.swingx.plaf.windows.WindowsClassicLookAndFeelAddons();
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel"); 
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Cargando.class.getName()).log(Level.SEVERE, null, ex);
        }
        Cargando c = new Cargando();
        cntrlLoading cntrlL = new cntrlLoading(c);
        c.setVisible(true);
        c = null;
        cntrlL = null;
    }
    
}
