package controlador;

import Interfaces.Seteo;
import Main.Hospital_v2;
import Vistas.MenuMedicos;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import rojeru_san.complementos.RSMoveWindow;
import rojerusan.RSAnimation;

public class cntrlMenuMedicos implements MouseListener {

    private MenuMedicos m;
    private RSMoveWindow a = new RSMoveWindow();

    private JPanel Panel_cont, Panel_Bott, Panel_Inf, PanelArriba, PanelIzq, PanelIzqArriba;
    private JButton button_RegHC, buttonBuscarHC, buttonActHC, buttonBuscarPaciente , cerrarSesion;
    private JToggleButton bttn_MenuDespl;
    private JDesktopPane DesktopPaneMenu;
    private JLabel DNI, Nombres, Prof, CELL, TipoCuenta;

    private final int altoAct = Hospital_v2.FBP.getHeight() - Hospital_v2.FBP.ButtonEnviarPaciente.getHeight();
    private final int anchoAct = Hospital_v2.FBP.getWidth();
    private final int anchoPanel;
    private final int altoPanel;
    // otros

    public cntrlMenuMedicos(MenuMedicos m) {
        this.m = m;
        m.setLocationRelativeTo(null);
        Acciones(m);
        Panel_cont.add(Panel_Bott);
        a.setMoveWindow(this.m);
        
        anchoPanel = DesktopPaneMenu.getWidth();
        altoPanel = DesktopPaneMenu.getHeight();
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

        cerrarSesion = m.buttonCerrarSesion;

        cerrarSesion.addMouseListener(this);
        // Botones----------------- jDesktopPaneMenu
        
        button_RegHC = m.button_RegistrarHC;
        buttonBuscarHC = m.Button_BuscarHC;
        buttonActHC = m.button_ActHC;
        buttonBuscarPaciente = m.button_BuscarPaciente;
        bttn_MenuDespl = m.MovButt_Menu;
        
        
        bttn_MenuDespl.addMouseListener(this);
        button_RegHC.addMouseListener(this);
        buttonBuscarHC.addMouseListener(this);
        buttonActHC.addMouseListener(this);
        buttonBuscarPaciente.addMouseListener(this);

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Seteo.SeteoPaneles();
        if (e.getSource() == buttonBuscarHC) {
            Hospital_v2.FBHC.ButtonEnviarHC.setVisible(false);
            Hospital_v2.FBHC.setVisible(true);
        }
        if (e.getSource() == button_RegHC) {
            DesktopPaneMenu.add(Hospital_v2.FRHC);
            Hospital_v2.FRHC.setVisible(true);
        }
        if (e.getSource() == buttonActHC) {
            DesktopPaneMenu.add(Hospital_v2.FAHC);
            Hospital_v2.FAHC.setVisible(true);
        }
        if (e.getSource() == buttonBuscarPaciente) {
            Hospital_v2.FBP.ButtonEnviarPaciente.setVisible(false);
            Hospital_v2.FBP.setVisible(true);
        }
        
        if (e.getSource() == cerrarSesion) {
            m.dispose();
            Hospital_v2.FL.setVisible(true);
        }
        if (e.getSource() == bttn_MenuDespl) {
            //Desplazar
            //DesplazarMenu();
        }
    }


    private void DesplazarMenu() {

        if (PanelIzq.getX() == 5) {
            //PanelIzq
            RSAnimation.setMoverIzquierda(5, -250, 5, 5, PanelIzq);
            RSAnimation.setMoverIzquierda(5, -(245 - 60), 4, 4, PanelIzqArriba);
            RSAnimation.setMoverIzquierda(255, 5, 4, 4, m.rSScrollPane1);
            //m.rSScrollPane1.setBounds(5, 65, m.getWidth() + (255 - 15), 830);
            m.rSScrollPane1.setSize(new Dimension(m.getWidth() + (255 - 15), altoPanel));

        } else {
            RSAnimation.setMoverDerecha(-250, 5, 5, 5, PanelIzq);
            RSAnimation.setMoverDerecha(-(245 - 60), 0, 4, 4, PanelIzqArriba);
            RSAnimation.setMoverDerecha(5, 255, 4, 4, m.rSScrollPane1);
            //m.rSScrollPane1.setBounds(255, 65, m.getWidth() - 10, 830);
            m.rSScrollPane1.setSize(new Dimension(anchoPanel, altoPanel));
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

}
