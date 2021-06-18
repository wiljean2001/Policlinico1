package controlador;

import Vistas.BuscarHC;
import Vistas.MenuMedicos;
import Vistas.RegistrarP;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import rojeru_san.complementos.RSMoveWindow;
import rojerusan.RSAnimation;

/**
 *
 * @author HP-Litzy-Jean
 */
public class cntrlMenuMedicos implements MouseListener {

    MenuMedicos m = new MenuMedicos();
    RSMoveWindow a = new RSMoveWindow();

    private JPanel Panel_cont, Panel_Bott, Panel_Inf, PanelArriba, PanelIzq, PanelIzqArriba;
    private JButton button_Reg;
    private JToggleButton bttn_MenuDespl;
    private JDesktopPane DesktopPaneMenu;
    private JLabel DNI, Nombres, Prof, CELL, TipoCuenta;
    RegistrarP r = null;
    cntrlRegistrarP cntrlR = null;
    // otros
    boolean estado;

    public cntrlMenuMedicos(MenuMedicos m) {
        this.m = m;
        Acciones(m);
        Panel_cont.add(Panel_Bott);
        estado = false;
        a.setMoveWindow(this.m);
        //
        DesplazarMenu();
        //m.setExtendedState(JFrame.NORMAL);
    }

    private void Acciones(MenuMedicos m) {
        //Panelenes--------------------
        Panel_cont = m.PanelContenedor;
        Panel_Bott = m.bttnExtra;
        DesktopPaneMenu = m.jDesktopPaneMenu;

        //Menus
        PanelArriba = m.jPanelARRIBA;
        PanelIzq = m.jPanelIzq;
        PanelIzqArriba = m.jPanelIzqArriba;

        // Botones----------------- jDesktopPaneMenu
        button_Reg = m.Button_BuscarHC;
        bttn_MenuDespl = m.MovButt_Menu;

        button_Reg.addMouseListener(this);
        bttn_MenuDespl.addMouseListener(this);

        // Labels
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        PanelDesktop(e);
        if (e.getSource() == bttn_MenuDespl) {
            DesplazarMenu();
        }
    }


// botón registrar
    private void PanelDesktop(MouseEvent e) {
        if (e.getSource() == button_Reg) {
            if (r == null) {
                r = new RegistrarP();
                cntrlR = new cntrlRegistrarP(r);
            }
            DesktopPaneMenu.add(r);
            r.setVisible(true);
        }
        
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    private void DesplazarMenu() {
        bttn_MenuDespl.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {

                int estado = e.getStateChange();
                if (PanelIzq.getX() == 5) {
                    //PanelIzq
                    RSAnimation.setMoverIzquierda(5, -250, 5, 5, PanelIzq);
                    RSAnimation.setMoverIzquierda(5, -(245 - 60), 4, 4, PanelIzqArriba);
                    RSAnimation.setMoverIzquierda(255, 5, 4, 4, m.rSScrollPane1);
                    m.rSScrollPane1.setBounds(5, 65, m.getWidth() + (255 - 20), m.getHeight());

                } else {
                    RSAnimation.setMoverDerecha(-250, 5, 5, 5, PanelIzq);
                    RSAnimation.setMoverDerecha(-(245 - 60), 0, 4, 4, PanelIzqArriba);
                    RSAnimation.setMoverDerecha(5, 255, 4, 4, m.rSScrollPane1);
                    m.rSScrollPane1.setBounds(255, 65, m.getWidth() - 15, m.getHeight());
                }

            }

        });
    }

}
