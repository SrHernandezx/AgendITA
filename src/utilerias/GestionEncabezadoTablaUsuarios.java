// Permite personalizar el encabezado de la tabla para definir el color de las columnas.


package utilerias;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;


import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.TableCellRenderer;


public class GestionEncabezadoTablaUsuarios implements TableCellRenderer {

    @Override 
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
 
        JComponent jcomponent = null;
        
        if(value instanceof String){
            
            jcomponent = new JLabel((String) value);
            ((JLabel) jcomponent).setHorizontalAlignment(SwingConstants.CENTER);
            ((JLabel) jcomponent).setSize(30, jcomponent.getWidth());
            ((JLabel) jcomponent).setPreferredSize(new Dimension(6, jcomponent.getWidth()));
        }
        
        jcomponent.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 1, new java.awt.Color(255, 255, 255)));
        jcomponent.setOpaque(true);
        jcomponent.setBackground(new Color(65, 65, 65));
        jcomponent.setForeground(Color.WHITE);
        jcomponent.setFont(new Font ("Times New Roman", Font.BOLD, 18));
        
        switch (column){
        
            case 0:
                jcomponent.setToolTipText("Número consecutivo");
                break;
                
            case 1:
                jcomponent.setToolTipText("ID del usuario");
                break;
                
            case 2:
                jcomponent.setToolTipText("Nombre de usuario");
                break;                                  
        }
        
        return jcomponent;
    }                
}             
