package Interfaces;

import app.bolivia.swing.JCTextField;
import javax.swing.JPanel;

public class Enable {
    public static void DesactivarRSTextField(JPanel formulario) {
        JCTextField clear;
        for (int i = 0; i < formulario.getComponentCount(); i++) {
            if (formulario.getComponent(i).getClass().getName().equals("app.bolivia.swing.JCTextField")) {
                clear = (JCTextField) formulario.getComponent(i);
                clear.setEnabled(false);
            }
        }
    }
    public static void ActivarRSTextField(JPanel formulario) {
        JCTextField clear;
        for (int i = 0; i < formulario.getComponentCount(); i++) {
            if (formulario.getComponent(i).getClass().getName().equals("app.bolivia.swing.JCTextField")) {
                clear = (JCTextField) formulario.getComponent(i);
                clear.setEnabled(true);
            }
        }
    }
    public static void ActivarJ(JPanel formulario) {
        JCTextField clear;
        for (int i = 0; i < formulario.getComponentCount(); i++) {
            if (formulario.getComponent(i).getClass().getName().equals("app.bolivia.swing.JCTextField")) {
                clear = (JCTextField) formulario.getComponent(i);
                clear.setEnabled(true);
            }
        }
    }
}
