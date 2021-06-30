/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Vistas.BuscarHC;
import Vistas.RegistrarHC;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import rojeru_san.RSButtonRiple;

public class cntrlRegistrarHC implements ActionListener{
    
    RegistrarHC rHC = new RegistrarHC();
    RSButtonRiple buttonBuscarP, buttonRegistrarHC;
    
    public cntrlRegistrarHC(RegistrarHC rHC){
        this.rHC = rHC;
        eventos(rHC);
    }
    private void eventos(RegistrarHC rHC){
        buttonBuscarP = rHC.ButtonBuscarP;
        buttonRegistrarHC = rHC.ButtonRegistrarHC;
        
        buttonBuscarP.addActionListener(this);
        buttonRegistrarHC.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==buttonBuscarP){
            BuscarHC bhc = new BuscarHC(null, true);
            cntrlBuscarHC bhc1 = new cntrlBuscarHC(bhc);
            bhc.setVisible(true);
        }
        if(e.getSource()==buttonRegistrarHC){
            
        }
    }
    
}
