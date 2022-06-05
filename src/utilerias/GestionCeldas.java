package utilerias;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;


public class GestionCeldas extends DefaultTableCellRenderer{
    
    private String tipo = "text";
    private Font normal = new Font("Verdana", Font.PLAIN, 16);
    private Font bold = new Font("Verdana", Font.BOLD, 16);
    private JLabel label = new JLabel();   
    private ImageIcon iconoBuscar = new ImageIcon("src//img/datos_contacto_1.png");

    // Constructor explicito con el tipo de dato que obtendrá la celda.
    
    public GestionCeldas(String tipo){
 
        this.tipo = tipo;
    }
    
    // Este metodo controla toda la tabla, podemos obtener el valor que contiene, definir que celda está seleccionada, la fila y columna al tenr el foco en ella. Cada evento sobre la tabla invocará a este metodo.
    
    public Component gaetCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column){
        
        Color colorFondo = null;
        Color colorTexto = null;
        Color colorFondoPorDefecto = new Color(192, 192, 192);
        Color colorFondoSeleccion = Color.RED;   
        
        String info = String.valueOf(value);
        this.setToolTipText(info);

    //Si la celda del evento es la selecionada se asigna el fondo por defecto para la selección.
    if (selected){
 
        this.setBackground(colorFondoPorDefecto);
    }
    else{
        // Para las que no estan seleccionadas se pinta el fondo de las celdas en blanco.
        this.setBackground(Color.WHITE);
    }
    // Se definen los tipos de datos que contendrán las celdas basado en la instancia que se hace en la ventana de la tabla al momento de contruirla.
    if(tipo.equals("texto")){
        // Si es tipo texto define el color de fondo del texto y de la celda así como la alineación.
        if(focused){
            colorFondo = colorFondoSeleccion;
            colorTexto = Color.WHITE;
        }
        else{
            colorFondo = colorFondoPorDefecto;
            colorTexto = Color.RED;
        }
        this.setHorizontalAlignment(JLabel.LEFT);
        this.setText((String) value);
        this.setForeground((selected) ? colorTexto : Color.BLACK);
        this.setBackground((selected) ? colorFondo : Color.WHITE);  
        this.setFont(normal);
        return this;
    }
    
    if(tipo.equals("fecha")){
        // Si es tipo texto define el color de fondo del texto y de la celda así como la alineación.
        if(focused){
            colorFondo = colorFondoSeleccion;
            colorTexto = Color.WHITE;
        }
        else{
            colorFondo = colorFondoPorDefecto;
            colorTexto = Color.BLUE;
        }
        this.setHorizontalAlignment(JLabel.LEFT);
        this.setText((String) value);
        this.setForeground((selected) ? colorTexto : Color.BLACK);
        this.setBackground((selected) ? colorFondo : Color.WHITE);  
        this.setFont(normal);
        return this;
    }
    // Define si es el tipo de dato numerico para personalizarlo.
    if (tipo.equals("numerico")){
        
        if(focused){
            colorFondo = colorFondoSeleccion;
        }
        else{
            colorFondo = colorFondoPorDefecto;
        }
        this.setHorizontalAlignment(JLabel.LEFT);
        this.setText((String) value);
        this.setForeground((selected) ? new Color(255, 255, 255) : new Color(32, 117, 32));
        this.setBackground((selected) ? colorFondo : Color.WHITE);  
        this.setFont(bold);
        return this;         
    }
    
    if (tipo.equals("icono")){
        
        label.setToolTipText("Clic para ver el registro completo");
        label.setIcon(iconoBuscar);
        label.setHorizontalAlignment(JLabel.CENTER);
        return label;
    }
    return this;
    }   
}