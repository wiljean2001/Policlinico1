package Interfaces;

import javax.swing.JOptionPane;

public class Mensaje {

    public static void Mensaje(String texto) {
        JOptionPane.showMessageDialog(null, texto);
    }

    public static void MensajeError(String texto, String texto_1) {
        JOptionPane.showMessageDialog(null, texto, texto_1, 0);
    }

    public static void MensajeConformidad(String texto, String texto_1) {
        JOptionPane.showMessageDialog(null, texto, texto_1, 1);
    }
    
}
