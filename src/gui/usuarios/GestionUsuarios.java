package gui.usuarios;

import com.sun.glass.events.KeyEvent;
import gui.principal.MenuPrincipal;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.JTableHeader;
import utilerias.Colores;
import utilerias.GestionCeldas;
import utilerias.GestionEncabezadoTablaUsuarios;
import utilerias.LongitudesAtributosBD;
import utilerias.ModeloTablaUsuarios;
import utilerias.OperacionesBaseDatos;

public class GestionUsuarios extends javax.swing.JFrame {
    
    private static GestionUsuarios instancia = null;
    ModeloTablaUsuarios modeloConsultas;
    
    //public static GestionUsuarios getInstancia() {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    //}

    /**
     * Creates new form Gestion_Usuario
     */
    public GestionUsuarios() {
        initComponents();
        this.setTitle("AgendITA: Gestion de Usuario");
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        
        this.setIconImage(Toolkit.getDefaultToolkit().getImage("src//img//Gestion_usuarios.png"));
        jPanelUsuarios.setBackground(Colores.COLOR_FONDO_GESTION_USUARIOS);
        OperacionesBaseDatos.levantarServidorXampp();
        Object[][] datos = OperacionesBaseDatos.buscarUsuarios();
        construirTabla (datos);
        
    }
    
    public static GestionUsuarios getInstancia() {
        synchronized (GestionUsuarios.class){
            if (instancia == null) {
                instancia = new GestionUsuarios();
                
                
            }
    }
        return instancia;
    }
    public void construirTabla(Object[][] data){
        String titulos[] = {"No." , "id.Usuario", "Nombre"};
        Object[][] datos = new Object[data.length][3];
        for (int i = 0; i < datos.length; i++){
            datos[i][0] = i + 1;
            datos[i][1] = data[i][0];
            datos[i][2] = data [1][1];
        }
        
        modeloConsultas = new ModeloTablaUsuarios(datos, titulos);
        jTableUsuarios.setModel(modeloConsultas);
        
        jTableUsuarios.getColumnModel().getColumn(0).setCellRenderer(new GestionCeldas("numerico"));
        jTableUsuarios.getColumnModel().getColumn(1).setCellRenderer(new GestionCeldas("numerico"));
        jTableUsuarios.getColumnModel().getColumn(2).setCellRenderer(new GestionCeldas("texto"));
        
        jTableUsuarios.getColumnModel().getColumn(0).setMinWidth(100);
        jTableUsuarios.getColumnModel().getColumn(0).setMaxWidth(100);
        
        jTableUsuarios.getColumnModel().getColumn(1).setMinWidth(100);
        jTableUsuarios.getColumnModel().getColumn(1).setMaxWidth(100);
        
        jTableUsuarios.getColumnModel().getColumn(2).setMinWidth(400);
        jTableUsuarios.getColumnModel().getColumn(2).setMaxWidth(400);
        
        jTableUsuarios.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        jTableUsuarios.setShowGrid(true);
        jTableUsuarios.getTableHeader().setReorderingAllowed(false);
        jTableUsuarios.setGridColor(Color.BLACK);
        jTableUsuarios.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        
        JTableHeader jtableHeader = jTableUsuarios.getTableHeader();
        jtableHeader.setDefaultRenderer(new GestionEncabezadoTablaUsuarios());
        jTableUsuarios.setTableHeader(jtableHeader);
        jTableUsuarios.setRowHeight(30);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelUsuarios = new javax.swing.JPanel();
        jScrollPaneUsuarios = new javax.swing.JScrollPane();
        jTableUsuarios = new javax.swing.JTable();
        jTextFieldBuscar = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButtonAgregar = new javax.swing.JButton();
        jButtonEliminar = new javax.swing.JButton();
        jButtonEditar = new javax.swing.JButton();
        jButtonBuscarTodos = new javax.swing.JButton();

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

        jPanelUsuarios.setBackground(new java.awt.Color(0, 0, 0));

        jTableUsuarios.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jTableUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "No.", "id. Usuario", "Nombre"
            }
        ));
        jScrollPaneUsuarios.setViewportView(jTableUsuarios);

        jTextFieldBuscar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
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

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 0, 0));
        jLabel1.setText("Buscar:");

        jButtonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgregarActionPerformed(evt);
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

        jButtonBuscarTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarTodosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelUsuariosLayout = new javax.swing.GroupLayout(jPanelUsuarios);
        jPanelUsuarios.setLayout(jPanelUsuariosLayout);
        jPanelUsuariosLayout.setHorizontalGroup(
            jPanelUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelUsuariosLayout.createSequentialGroup()
                .addGroup(jPanelUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelUsuariosLayout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jLabel1)
                        .addGap(37, 37, 37)
                        .addComponent(jTextFieldBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelUsuariosLayout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jScrollPaneUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 551, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanelUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButtonAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                            .addComponent(jButtonEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonBuscarTodos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanelUsuariosLayout.setVerticalGroup(
            jPanelUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelUsuariosLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanelUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(48, 48, 48)
                .addGroup(jPanelUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelUsuariosLayout.createSequentialGroup()
                        .addComponent(jScrollPaneUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanelUsuariosLayout.createSequentialGroup()
                        .addComponent(jButtonAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonBuscarTodos, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanelUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregarActionPerformed
     // AgregarUsuarios newframe = new AgregarUsuarios();

       // newframe.setVisible(true);
       
       this.setVisible(false);
       AgregarUsuario nuevoUsuario = AgregarUsuario.getInstancia(this, true);
       nuevoUsuario.setVisible(true);
    }//GEN-LAST:event_jButtonAgregarActionPerformed

    private void jButtonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarActionPerformed
        int fila = jTableUsuarios.getSelectedRow();
        if (fila< 0) {
            
            JOptionPane.showMessageDialog(null, "Debe selecionar un registro",
                    "Agenda: Eliminar usuario", JOptionPane.ERROR_MESSAGE);
            
        }else{
            int id_usuario= Integer.valueOf(jTableUsuarios.getValueAt(fila, 1).toString());
            String nombre = jTableUsuarios.getValueAt(fila, 2).toString();
            
            Object[]opciones ={"Aceptar","Cancelar"};
            int respuesta = JOptionPane.showOptionDialog(null,
                        "<html>¿Desea eliminar al usuario <b><i><font color = \"red\">" + nombre + "</font></b>?</html>", 
                        "Agenda: Eliminar usuario",JOptionPane.YES_OPTION, JOptionPane.QUESTION_MESSAGE,
                        null, opciones,"Cancelar");
            if (respuesta == JOptionPane.YES_OPTION) {
                OperacionesBaseDatos.eliminarUsuario(id_usuario);
                
            }
        }
    }//GEN-LAST:event_jButtonEliminarActionPerformed

    private void jButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarActionPerformed
        //Modificar_Usuario newframe = new Modificar_Usuario();

        //newframe.setVisible(true);
        
        int fila = jTableUsuarios.getSelectedRow();
        if (fila < 0 ) {
            
            JOptionPane.showMessageDialog(null, "Debe seleccionar un registro",
                    "Agenda: Modificar usuario", JOptionPane.ERROR_MESSAGE);
            
        }else{
            int id_usuario = Integer.valueOf(jTableUsuarios.getValueAt(fila, 1).toString());
            String nombre = jTableUsuarios.getValueAt(fila, 2).toString();
            
            this.setVisible(false);
            ModificarUsuario modificarUsuario = ModificarUsuario.getInstancia(this, true);
            modificarUsuario.datosUsuario = OperacionesBaseDatos.buscarUsuario(id_usuario);
            modificarUsuario.jTextFieldNombre.setText(modificarUsuario.datosUsuario[1].toString());
            modificarUsuario.jPasswordFieldPassword.setText(modificarUsuario.datosUsuario[2].toString());
            modificarUsuario.setVisible(true);
        }
        
        
    }//GEN-LAST:event_jButtonEditarActionPerformed

    private void jButtonBuscarTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarTodosActionPerformed
        // TODO add your handling code here:
        buscarTodosUsuarios();
    }//GEN-LAST:event_jButtonBuscarTodosActionPerformed

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
        int posCursor = jTextFieldBuscar.getCaretPosition();
        String texto = jTextFieldBuscar.getText();
        if (texto.length()+ 1 > LongitudesAtributosBD.LONGITUD_NOMBRE_USUARIO) {
            evt.consume();
            
        }else{
            if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z') && (c < 'O' || c > '9') && (c != 'ñ') && (c != 'Ñ') && (c != 'á') && (c != 'é') && (c != 'í') && (c != 'ó') && (c != 'ú') && (c != 'Á') && (c != 'É') && (c != 'Í') && (c != 'Ó') && (c != 'Ú')){
            
                evt.consume();
        }else {
               if (c != KeyEvent.VK_BACKSPACE) {
                texto = colocaCaracter(texto, posCursor, c);
              }else{
                texto = jTextFieldBuscar.getText();
                }
                }
        String usuarios[][] = OperacionesBaseDatos.buscarUsuarios(texto);
        construirTabla(usuarios);
        }
    }//GEN-LAST:event_jTextFieldBuscarKeyTyped

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        // TODO add your handling code here:
        buscarTodosUsuarios();
    }//GEN-LAST:event_formWindowGainedFocus

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        cerrar();
    }//GEN-LAST:event_formWindowClosing

    private void buscarTodosUsuarios(){
        Object[][] datos = OperacionesBaseDatos.buscarUsuarios();
        construirTabla(datos);
        jTextFieldBuscar.setText("");
        jTextFieldBuscar.requestFocus();
    }
    private String colocaCaracter(String texto, int posCursor, char c){
        String texto1 = texto.substring(0, posCursor) + c;
        String texto2 = "";
        if (texto.length() >0) {
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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GestionUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestionUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestionUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestionUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        

        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GestionUsuarios().setVisible(true);
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
    private javax.swing.JScrollPane jScrollPaneUsuarios;
    private javax.swing.JTable jTableUsuarios;
    private javax.swing.JTextField jTextFieldBuscar;
    // End of variables declaration//GEN-END:variables
}
