package gui.usuarios;

import java.awt.Color;
import utilerias.Colores;
import utilerias.LongitudesAtributosBD;
import utilerias.OperacionesBaseDatos;


public class ModificarUsuario extends javax.swing.JDialog {
    
    private static ModificarUsuario instancia = null;
    public static Object[] datosUsuario;
    

    public ModificarUsuario(java.awt.Frame parent, boolean modal) {
        
        super(parent, modal);
        initComponents();
        OperacionesBaseDatos.levantarServidorXampp();
        this.setResizable(false);
        this.setTitle("AgendITA: Modificar usuario.");   
        this.setLocationRelativeTo(null);
        jLabelUsuarioDuplicado.setText("<html<font color = \"red\"><b>>Nota:</b></font> " + "El nombre y la contraseña  puden tener un máximo de 15 caracteres, " + "pueden incluir vocales acentuadas, mayúsculas y minúsculas, " + "números y las letras \"ñ\" y \"Ñ\". </html>");
    }
    
    
    public static ModificarUsuario getInstancia(java.awt.Frame parent, boolean modal){
        
        synchronized (ModificarUsuario.class){
            
            if(instancia == null){
                instancia = new ModificarUsuario(parent, modal);
            }
        }
        return instancia;
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTextFieldNombre = new javax.swing.JTextField();
        jButtonAceptar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jPasswordFieldPassword = new javax.swing.JPasswordField();
        jLabelUsuarioDuplicado = new javax.swing.JLabel();
        jLabelNotas = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(187, 225, 225));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        jTextFieldNombre.setBackground(new java.awt.Color(187, 225, 225));
        jTextFieldNombre.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "Nombre:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N
        jTextFieldNombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldNombreFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldNombreFocusLost(evt);
            }
        });
        jTextFieldNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldNombreKeyTyped(evt);
            }
        });

        jButtonAceptar.setBackground(new java.awt.Color(187, 225, 225));
        jButtonAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/aceptar.png"))); // NOI18N
        jButtonAceptar.setText("Aceptar");
        jButtonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAceptarActionPerformed(evt);
            }
        });

        jButtonCancelar.setBackground(new java.awt.Color(187, 225, 225));
        jButtonCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/cancelar.png"))); // NOI18N
        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jPasswordFieldPassword.setBackground(new java.awt.Color(187, 225, 225));
        jPasswordFieldPassword.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "Contraseña:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N
        jPasswordFieldPassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jPasswordFieldPasswordFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jPasswordFieldPasswordFocusLost(evt);
            }
        });
        jPasswordFieldPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jPasswordFieldPasswordKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(jButtonCancelar))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jPasswordFieldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabelUsuarioDuplicado, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58)))
                .addGap(0, 60, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelNotas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextFieldNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                    .addComponent(jPasswordFieldPassword))
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAceptar)
                    .addComponent(jButtonCancelar))
                .addGap(33, 33, 33)
                .addComponent(jLabelUsuarioDuplicado, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabelNotas, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldNombreFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldNombreFocusGained

        jTextFieldNombre.setBackground(Colores.COLOR_FOCO);
        jTextFieldNombre.selectAll();
        
    }//GEN-LAST:event_jTextFieldNombreFocusGained

    private void jTextFieldNombreFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldNombreFocusLost

        jTextFieldNombre.setBackground(Color.WHITE);   
    }//GEN-LAST:event_jTextFieldNombreFocusLost

    private void jTextFieldNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldNombreKeyTyped

        char c = evt.getKeyChar();
        int posCursor = jTextFieldNombre.getCaretPosition();
        String texto = jTextFieldNombre.getText();
        
        if(texto.length() + 1 > LongitudesAtributosBD.LONGITUD_NOMBRE_USUARIO){
            
            evt.consume();

        }
        else{
            
            if((c < 'a' || c > 'z' ) && (c < 'A' || c > 'Z') && (c < '0' || c > '9') && (c != 'ñ') && (c != 'Ñ') && (c != 'á') && (c != 'é') && (c != 'í') && (c != 'ó') && (c != 'ú') && (c != 'Á') && (c != 'É') && (c != 'Í') && (c != 'Ó') && (c != 'Ú')){
            
                evt.consume();
            }
            else{
                texto = jTextFieldNombre.getText();
            }
        }
        
        //Busqueda SQL
        String usuarios[] = OperacionesBaseDatos.buscarUsuario(texto);
       
        if (usuarios != null && datosUsuario[1].equals(usuarios[0])){
            
            String mensaje = "<html<font color = \"red\"><b>" + "Usuario ya registrado en la Base de datos</b></font></html>";
            jLabelUsuarioDuplicado.setText(mensaje);
            jButtonAceptar.setEnabled(false);
            jPasswordFieldPassword.setEnabled(false);
        }
    }//GEN-LAST:event_jTextFieldNombreKeyTyped

    
    private String colocarCaracter(String texto, int posCursor, char c){
        
        String texto1 = texto.substring(0, posCursor) + c;
        String texto2 = "";
        
        if(texto.length() > 0){
            texto2 = texto.substring(posCursor, texto.length());
        }
        return texto1 + texto2;
    }
    
 
    private void jPasswordFieldPasswordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPasswordFieldPasswordFocusGained
   
        jPasswordFieldPassword.setBackground(Colores.COLOR_FOCO);
        jPasswordFieldPassword.selectAll();
    }//GEN-LAST:event_jPasswordFieldPasswordFocusGained

    private void jPasswordFieldPasswordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPasswordFieldPasswordFocusLost

        jPasswordFieldPassword.setBackground(Color.WHITE);  
    }//GEN-LAST:event_jPasswordFieldPasswordFocusLost

    private void jPasswordFieldPasswordKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordFieldPasswordKeyTyped

        char c = evt.getKeyChar();
        int totalCaracteres = jPasswordFieldPassword.getPassword().length + 1;
        
        
        if((totalCaracteres > LongitudesAtributosBD.LONGITUD_PASSWORD_USUARIO) || (c < 'a' || c > 'z' ) && (c < 'A' || c > 'Z') && (c < '0' || c > '9') && (c != 'ñ') && (c != 'Ñ') && (c != 'á') && (c != 'é') && (c != 'í') && (c != 'ó') && (c != 'ú') && (c != 'Á') && (c != 'É') && (c != 'Í') && (c != 'Ó') && (c != 'Ú')){
            
            evt.consume();
        }           
    }//GEN-LAST:event_jPasswordFieldPasswordKeyTyped

    private void jButtonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarActionPerformed

        String nombre = jTextFieldNombre.getText();
        String contra = String.valueOf(jPasswordFieldPassword.getPassword());
        OperacionesBaseDatos.modificarUsuario((int) datosUsuario[0], nombre, contra);
        borrarFormulario();
        this.setVisible(false);
        GestionUsuarios gestionUsuarios = GestionUsuarios.getInstancia();
        gestionUsuarios.setVisible(true); 
    }//GEN-LAST:event_jButtonAceptarActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed

        this.dispose();
        GestionUsuarios usuarios = new GestionUsuarios();
        usuarios.setVisible(true);  
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    
    private void borrarFormulario(){
        
        jTextFieldNombre.setText("");
        jPasswordFieldPassword.setText("");
        jTextFieldNombre.requestFocus();
    }
    
   
    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ModificarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModificarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModificarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModificarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ModificarUsuario dialog = new ModificarUsuario(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter(){
                    
                    public void windowClosing(java.awt.event.WindowEvent e){
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAceptar;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JLabel jLabelNotas;
    private javax.swing.JLabel jLabelUsuarioDuplicado;
    private javax.swing.JPanel jPanel1;
    public static javax.swing.JPasswordField jPasswordFieldPassword;
    public static javax.swing.JTextField jTextFieldNombre;
    // End of variables declaration//GEN-END:variables
}
                
