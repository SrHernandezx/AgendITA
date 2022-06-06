
package gui.contactos;
import com.sun.glass.events.KeyEvent;
import gui.principal.MenuPrincipal;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Toolkit;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.JTableHeader;
import utilerias.Colores;
import utilerias.GestionCeldas;
import utilerias.GestionEncabezadoTablaContactos;
import utilerias.LongitudesAtributosBD;
import utilerias.ModeloTablaUsuarios;
import utilerias.OperacionesBaseDatos;


public class GestionContactos extends javax.swing.JFrame {

   private static GestionContactos instancia = null;
   ModeloTablaUsuarios modeloConsultas;
    
  
    public GestionContactos() {
        initComponents();
        
        this.setTitle("AgendITA: Gestion de contactos");
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        //this.setExtendedState(MAXIMIXED_BOTH);
        this.setIconImage(Toolkit.getDefaultToolkit().getImage("src//img//Gestion_contactos.png"));
        jPanelUsuarios.setBackground(Colores.COLOR_FONDO_GESTION_CONTACTOS);
        //jTableContactos.addMouseListener(this);
        OperacionesBaseDatos.levantarServidorXampp();
        Object[][] datos = OperacionesBaseDatos.buscarContactos();
        construirTabla(datos);
        
     
        //this.setLocationRelativeTo(null);
        //this.setTitle("Agenda: Gestion de contactos");
    }
    
    public static GestionContactos getInstancia(){
        synchronized (GestionContactos.class){
            if (instancia == null){
                instancia = new GestionContactos();
            }
        }
        return instancia;
    }
    public void construirTabla(Object[][] data){
        String titulos[]= {"No.", "Id.Usuario","Nombre", "Fecha de nacimiento", ""};
        Object[][] datos = new Object[data.length][titulos.length];
        for (int i = 0; i < datos.length; i++){
            datos[i][0] = i + 1;
            datos[i][1] = data [i][0];
            datos[i][2] = data[i][1] + " " + data [i][2] + " " + data[i][3];
            datos[i][3] = data[i][4];
        }
        modeloConsultas= new ModeloTablaUsuarios(datos, titulos);
        // se asigna el modeloConsultas a la tabla;
        jTableContactos.setModel(modeloConsultas);
        /* se asigna el tipo de datos que tendran las celdas de cada columna
        *definida respectivamente para validar su personalizacion
        */
        jTableContactos.getColumnModel().getColumn(0).setCellRenderer(new GestionCeldas("numerico"));
        jTableContactos.getColumnModel().getColumn(1).setCellRenderer(new GestionCeldas("numerico"));
        jTableContactos.getColumnModel().getColumn(2).setCellRenderer(new GestionCeldas("texto"));
        jTableContactos.getColumnModel().getColumn(3).setCellRenderer(new GestionCeldas("fecha"));
        jTableContactos.getColumnModel().getColumn(4).setCellRenderer(new GestionCeldas("icono"));
        
        jTableContactos.getColumnModel().getColumn(0).setMinWidth(100);
        jTableContactos.getColumnModel().getColumn(0).setMaxWidth(100);
        
        jTableContactos.getColumnModel().getColumn(1).setMinWidth(100);
        jTableContactos.getColumnModel().getColumn(1).setMaxWidth(100);
        
        jTableContactos.getColumnModel().getColumn(2).setMinWidth(300);
        jTableContactos.getColumnModel().getColumn(2).setMaxWidth(300);
        
        jTableContactos.getColumnModel().getColumn(3).setMinWidth(200);
        jTableContactos.getColumnModel().getColumn(3).setMaxWidth(200);
        
        jTableContactos.getColumnModel().getColumn(4).setMinWidth(50);
        jTableContactos.getColumnModel().getColumn(4).setMaxWidth(50);
        
        jTableContactos.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        jTableContactos.setShowGrid(true);
        jTableContactos.getTableHeader().setReorderingAllowed(false);
        jTableContactos.setGridColor(Color.BLACK);
        jTableContactos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        
        
        //personaliza el encabezado
        JTableHeader jtableHeader = jTableContactos.getTableHeader();
        jtableHeader.setDefaultRenderer(new GestionEncabezadoTablaContactos());
        jTableContactos.setTableHeader(jtableHeader);
        jTableContactos.setRowHeight(30);
    }
    
    @SuppressWarnings("unchecked")
     
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelUsuarios = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldBuscar = new javax.swing.JTextField();
        jScrollPaneContactos = new javax.swing.JScrollPane();
        jTableContactos = new javax.swing.JTable();
        jButtonBuscarTodos = new javax.swing.JButton();
        jButtonEliminar = new javax.swing.JButton();
        jButtonEditar = new javax.swing.JButton();
        jButtonAgregar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanelUsuarios.setBackground(new java.awt.Color(51, 0, 51));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 102));
        jLabel1.setText("Buscar:");

        jTextFieldBuscar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldBuscarFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldBuscarFocusLost(evt);
            }
        });
        jTextFieldBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldBuscarKeyTyped(evt);
            }
        });

        jTableContactos.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jTableContactos.setForeground(new java.awt.Color(255, 51, 102));
        jTableContactos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "No.", "Id.Usuario", "Nombre", "Fecha  Nacimiento", ""
            }
        ));
        jTableContactos.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jTableContactosMouseMoved(evt);
            }
        });
        jTableContactos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableContactosMouseClicked(evt);
            }
        });
        jScrollPaneContactos.setViewportView(jTableContactos);

        jButtonBuscarTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarTodosActionPerformed(evt);
            }
        });

        jButtonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarActionPerformed(evt);
            }
        });

        jButtonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarActionPerformed(evt);
            }
        });

        jButtonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgregarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelUsuariosLayout = new javax.swing.GroupLayout(jPanelUsuarios);
        jPanelUsuarios.setLayout(jPanelUsuariosLayout);
        jPanelUsuariosLayout.setHorizontalGroup(
            jPanelUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelUsuariosLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jTextFieldBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 569, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(150, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelUsuariosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButtonAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonBuscarTodos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(19, 19, 19))
            .addGroup(jPanelUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelUsuariosLayout.createSequentialGroup()
                    .addGap(20, 20, 20)
                    .addComponent(jScrollPaneContactos, javax.swing.GroupLayout.PREFERRED_SIZE, 701, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(91, Short.MAX_VALUE)))
        );
        jPanelUsuariosLayout.setVerticalGroup(
            jPanelUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelUsuariosLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanelUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addComponent(jButtonBuscarTodos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
            .addGroup(jPanelUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelUsuariosLayout.createSequentialGroup()
                    .addGap(98, 98, 98)
                    .addComponent(jScrollPaneContactos, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(37, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonBuscarTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarTodosActionPerformed
     
       buscarTodosContactos();
      
    }//GEN-LAST:event_jButtonBuscarTodosActionPerformed

    private void jButtonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarActionPerformed
        
        int fila = jTableContactos.getSelectedRow();
        if (fila < 0) {
            JOptionPane.showMessageDialog(null, "Debe selecionar un registro",
            
            "AgenITA: Eliminar contacto", JOptionPane.ERROR_MESSAGE);
        }else{
             /* si el usuario he selecionado un registro requerido se le preguntara si ese registro es el que 
            desea eliminar*/
             int id_contacto = Integer.valueOf(jTableContactos.getValueAt(fila, 1).toString());
             String nombre = jTableContactos.getValueAt(fila, 2).toString();
             
             Object[] opciones = {"Aceptar", "Cancelar"};
             int respuesta = JOptionPane.showOptionDialog(null, "<html>¿Desea eliminar al contacto <b><i><font color = \"red\">" + nombre + "</font></i></b>?</html>", "AgendITA: Eliminar al contacto", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, "Cancelar");
             if (respuesta == JOptionPane.YES_OPTION) {
                 OperacionesBaseDatos.eliminarContacto(id_contacto);
                 Object datos[][]= OperacionesBaseDatos.buscarContactos();
                 construirTabla(datos);
                
            }
        }
    
    }//GEN-LAST:event_jButtonEliminarActionPerformed

    private void jButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarActionPerformed
        // TODO add your handling code here:
        /*PENDIENTE DE PROGRAMACION*/
    }//GEN-LAST:event_jButtonEditarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        cerrar();
    }//GEN-LAST:event_formWindowClosing

    private void jTextFieldBuscarFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldBuscarFocusGained
        // TODO add your handling code here:
          jTextFieldBuscar.setBackground(Colores.COLOR_FOCO);
        jTextFieldBuscar.selectAll();
    }//GEN-LAST:event_jTextFieldBuscarFocusGained

    private void jTextFieldBuscarFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldBuscarFocusLost
        // TODO add your handling code here:
        jTextFieldBuscar.setBackground(Color.WHITE);
    }//GEN-LAST:event_jTextFieldBuscarFocusLost

    private void jTextFieldBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldBuscarKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        int posCursor= jTextFieldBuscar.getCaretPosition();
        String texto = jTextFieldBuscar.getText();
        
        if (texto.length()+1 > LongitudesAtributosBD.LONGITUD_NOMBRE_USUARIO){
            evt.consume();
        }else{
            
            if ((c < 'a' || c > 'z') && (c < 'A'|| c > 'Z') && (c < '0' || c > '9') && ( c != 'ñ') && ( c != 'Ñ') && (c != 'á') && (c !='é') && (c != 'í') && (c != 'ó') &&(c != 'ú') && (c != 'Á') && (c !='É') && (c !='Í') && (c != 'Ó') &&(c != 'Ú')){
            
            evt.consume();
                
            }else {
                    if (c != KeyEvent.VK_BACKSPACE) {
                    texto = colocaCaracter(texto, posCursor, c);
                     }else{
                    texto = jTextFieldBuscar.getText();
                    }
                    }
            /* Realizar la busquedad SQL*/
            Object usuarios [][] = OperacionesBaseDatos.buscarContactos(texto);
            construirTabla(usuarios);
        
        
        }
    }
     private void buscarTodosContactos(){
        Object[][] datos = OperacionesBaseDatos.buscarContactos();
        construirTabla(datos);
        jTextFieldBuscar.setText("");
        jTextFieldBuscar.requestFocus();
    
    }//GEN-LAST:event_jTextFieldBuscarKeyTyped

    private void jButtonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregarActionPerformed
        // TODO add your handling code here:
         this.setVisible(false);
       AgregarContacto nuevoContacto= AgregarContacto.getInstancia();
       nuevoContacto.setVisible(true);
    }//GEN-LAST:event_jButtonAgregarActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        // TODO add your handling code here:
        buscarTodosContactos();
    }//GEN-LAST:event_formWindowGainedFocus

    private void jTableContactosMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableContactosMouseMoved
        // TODO add your handling code here:int fila = jTableContactos.rowAtPoint(evt.getPoint());
        int fila = jTableContactos.rowAtPoint(evt.getPoint());
    int columna= jTableContactos.columnAtPoint(evt.getPoint());
    
    if (columna ==4) {
        jTableContactos.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
    }else{
        jTableContactos.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }
    }//GEN-LAST:event_jTableContactosMouseMoved

    
    private void jTableContactosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableContactosMouseClicked
        // TODO add your handling code here:
        int fila = jTableContactos.rowAtPoint(evt.getPoint());
        int columna = jTableContactos.columnAtPoint(evt.getPoint());
        if (columna == 4) {
            JOptionPane.showConfirmDialog(null, "Enlazar con el formulario donde se muestran todos los datos de contacto");
            
        }
    }//GEN-LAST:event_jTableContactosMouseClicked
private String colocaCaracter(String texto, int posCursor, char c){
    String texto1 = texto.substring(0, posCursor) + c;
    String texto2 = "";
    if (texto.length()> 0) {
        texto2 = texto.substring(posCursor, texto.length());
        
    }
    return texto1 + texto2;
    
}

private void cerrar(){
    this.setVisible(false);
    MenuPrincipal menuPrincipal = new MenuPrincipal();
    menuPrincipal.setVisible(true);
    
 
}
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GestionContactos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestionContactos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestionContactos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestionContactos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        

        /* Create and display the form */
        
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GestionContactos().setVisible(true);
            }
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAgregar;
    private javax.swing.JButton jButtonBuscarTodos;
    private javax.swing.JButton jButtonEditar;
    private javax.swing.JButton jButtonEliminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanelUsuarios;
    private javax.swing.JScrollPane jScrollPaneContactos;
    private javax.swing.JTable jTableContactos;
    private javax.swing.JTextField jTextFieldBuscar;
    // End of variables declaration//GEN-END:variables
}
