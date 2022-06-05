package utilerias;

import javax.swing.table.DefaultTableModel;


public class ModeloTablaUsuarios extends DefaultTableModel{
    
    String [] titulos;
    Object [][] datos;
    
    
    public ModeloTablaUsuarios(Object[][] datos, String[] titulos){
        
        super();
        this.titulos = titulos;
        this.datos = datos;
        setDataVector(datos, titulos);
    }
    
    
    public boolean isCellEditable(int row, int colum){
        
        // Dedinimos si una celda pude ser o no editable.
        return false;
    }        
}
