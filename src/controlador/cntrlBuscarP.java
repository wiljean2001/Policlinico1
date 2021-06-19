package controlador;

import DAO.Paciente_DAO;
import Vistas.BuscarP;
import app.bolivia.swing.JCTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import rojeru_san.complementos.RSTableMetro;

public class cntrlBuscarP implements ActionListener {

    private JButton button_BuscarPac, button_Aceptar;
    private JCTextField DNI;
    private RSTableMetro contenidoPac;
    private BuscarP BusP;
    private 

    public cntrlBuscarP(BuscarP BusP) {
        this.BusP = BusP;
        acciones(BusP);
    }

    private void acciones(BuscarP BusP) {
        button_BuscarPac = BusP.ButtonBuscarPaciente;
        button_Aceptar = BusP.ButtonEnviarPaciente;
        DNI = BusP.txtDNI;
        contenidoPac = BusP.Table_Paciente;

        button_BuscarPac.addActionListener(this);
        button_Aceptar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button_BuscarPac) {
            Paciente_DAO paciente_DAO = new Paciente_DAO();
            /*
            private void mostrarTabla() {
            //limpiar la tabla
            int valor =modelo.getRowCount()-1;           
            for(int i=valor; i>=0; i--){
            modelo.removeRow(i);}
        
            //cargar la tabla
            ArrayList<Persona> lista = l.verListado();
            for (Persona a: lista) {
            Object[] objNuevo = {a.getNombres(), a.getApellidos(), a.getEdad()};
            modelo.addRow(objNuevo);
        }
    }
             */
            int valor =modelo.getRowCount()-1;           
            for(int i=valor; i>=0; i--){
            modelo.removeRow(i);}
            contenidoPac.append(paciente_DAO.BuscarPac(DNI.getText()).toString());

        }
    }

}
