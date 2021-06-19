
package Interfaces;
import javax.swing.JOptionPane;
    /*
    Programador: @jvilchezar
    fecha: 30/05/21
    hora de inicio: 23:30
    */
public class Mensaje {
     public static void MD(String texto){
     JOptionPane.showMessageDialog(null,texto);
  
     }
     public static void MD_YES_NO(String texto, String texto_1){
     int respuesta= JOptionPane.showConfirmDialog(null, texto_1, texto, JOptionPane.YES_NO_OPTION);
     if(respuesta==JOptionPane.YES_OPTION) {
         System.exit(1);
     }
    }
}