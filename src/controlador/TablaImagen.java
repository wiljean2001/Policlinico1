package controlador;

import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

public class TablaImagen extends DefaultTableCellRenderer {

    DefaultTableCellRenderer alinear = new DefaultTableCellRenderer();
    JScrollPane jScrollPane = new JScrollPane();
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, 
            boolean isSelected, boolean hasFocus, int row, int column) {
        setHorizontalAlignment(SwingConstants.CENTER);
        setVerticalAlignment(SwingConstants.CENTER);
        setPreferredSize(new Dimension(675, 88));
        table.setRowHeight(88);
        table.setPreferredSize(new Dimension(675, 88));
        if(value instanceof JLabel){
            JLabel lbl = (JLabel)value;
            return lbl;
        }
        return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
    }
   //super.getTableCellRenderComponen //TRUCO  
}
