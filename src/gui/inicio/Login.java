package gui.inicio;

import gui.principal.MenuPrincipal;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import utilerias.Colores;
import utilerias.OperacionesBaseDatos;

public class Login extends javax.swing.JFrame {

    private static int intentos;
    private static Login instancia =  null;
    
    public Login() {
        initComponents();
        cambiarFuente();
        this.setTitle("Agendita: Loging");
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setIconImage(Toolkit.getDefaultToolkit().getImage("src//img//agenda.png"));
        jPanelPrincipal.setBackground(Colores.COLOR_FONDO_LOGIN);
        OperacionesBaseDatos.levantarServidorXampp();
        intentos = 0;
        
    }
public static Login getInstancia(){
        synchronized (Login.class) {
            if (instancia == null) {
                instancia = new Login();
            }
            }
        return instancia;
    }



private void cambiarFuente(){
    InputStream myStream=null;
    try{
        myStream = new BufferedInputStream(
        new FileInputStream("src//fuentes//Lato-Bold.ttf"));
        Font fuente = Font.createFont(Font.TRUETYPE_FONT, myStream);
        fuente = fuente.deriveFont(Font.BOLD, 22);
        
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(fuente);
        jLabel2.setFont(fuente);
        jLabel3.setFont(fuente);
        jTextFieldUsuario.setFont(fuente);
        //jPasswordFieldPasseord.setFont(fuente);
        jButtonAceptar.setFont(fuente);
        jButtonCancelar.setFont(fuente);
    }catch (FileNotFoundException ex){
        Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
    }catch (FontFormatException ex){
        Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        
    }catch (IOException ex){
        Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
    }finally{
        try{
            myStream.close();
        }catch (IOException ex){
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
private void cerrar(){
    Object[] opciones = {"Aceptar", "Cancelar"};
    int eleccion = JOptionPane.showOptionDialog(null,"¿Salir del sistema?",
            "Agenda: Salir", JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE, null, opciones, "Cancelar");
    if (eleccion == JOptionPane.YES_OPTION) {
        OperacionesBaseDatos.detenerServidorXampp();
        System.exit(0);
        
    }
}
private void borrarFormulario(){
    jTextFieldUsuario.setText("");
    jPasswordFieldPassword.setText("");
    jTextFieldUsuario.requestFocus();
    
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(210, 255, 250));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/login_256.png"))); // NOI18N
        jLabel1.setMaximumSize(new java.awt.Dimension(256, 256));
        jLabel1.setPreferredSize(new java.awt.Dimension(256, 256));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Usuario");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Password");

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/entrar_16.png"))); // NOI18N
        jButton1.setText("Aceptar");

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/cancelar_16.png"))); // NOI18N
        jButton2.setText("Cancelar");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(43, 43, 43)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField1)
                            .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(170, 170, 170)
                        .addComponent(jButton1)
                        .addGap(32, 32, 32)
                        .addComponent(jButton2)))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(146, 146, 146)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(45, 45, 45)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton2))))
                .addContainerGap(137, Short.MAX_VALUE))
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

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        // TODO add your handling code here:
        cerrar();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jTextFieldUsuarioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldUsuarioFocusGained
        // TODO add your handling code here:
        jTextFieldUsuario.setBackground(Colores.COLOR_FOCO);
        jTextFieldUsuario.selectAll();
    }//GEN-LAST:event_jTextFieldUsuarioFocusGained

    private void jTextFieldUsuarioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldUsuarioFocusLost
        // TODO add your handling code here:
        jTextFieldUsuario.setBackground(Color.WHITE);
    }//GEN-LAST:event_jTextFieldUsuarioFocusLost

    private void jPasswordFieldPasswordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPasswordFieldPasswordFocusGained
        // TODO add your handling code here:
        jPasswordFieldPassword.setBackground(Colores.COLOR_FOCO);
        jPasswordFieldPassword.selectAll();
    }//GEN-LAST:event_jPasswordFieldPasswordFocusGained

    private void jPasswordFieldPasswordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPasswordFieldPasswordFocusLost
        // TODO add your handling code here:
        jPasswordFieldPassword.setBackground(Color.WHITE);
    }//GEN-LAST:event_jPasswordFieldPasswordFocusLost

    private void jButtonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarActionPerformed
        // TODO add your handling code here:
        ingresar();
    }//GEN-LAST:event_jButtonAceptarActionPerformed

    private void jPasswordFieldPasswordKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordFieldPasswordKeyTyped
        // TODO add your handling code here:
        char car = evt.getKeyChar();
        if (car == KeyEvent.VK_ENTER){
            ingresar();
        }
    }//GEN-LAST:event_jPasswordFieldPasswordKeyTyped

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        cerrar();
    }//GEN-LAST:event_formWindowClosing

    private void ingresar(){
        String usuario = jTextFieldUsuario.getText();
        String contra = String.valueOf(jPasswordFieldPassword.getPassword());
       String info[] = OperacionesBaseDatos.buscarUsuario(usuario);
        if (info[0].endsWith(usuario)) {
            if (info[1].equals(contra)) {
                JOptionPane.showMessageDialog(null, "Bienvenido" + usuario,
                        "Agenda: Login", JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
                MenuPrincipal menu = MenuPrincipal.getInstancia();
                menu.setVisible(true);
                
            }else{
                intentos++;
                if (intentos == 3) {
                    JOptionPane.showMessageDialog(null, "Numero Maximo de intentos excedido",
                    "Agenda: Login", JOptionPane.INFORMATION_MESSAGE);
                    System.exit(0);
                    
                }
                JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrecta",
                    "Agenda: Login", JOptionPane.ERROR_MESSAGE);
                    borrarFormulario();
            }
            
        }else{
            intentos++;
            if (intentos ==3) {
                JOptionPane.showMessageDialog(null, "Numero Maximo de intentos excedido",
                    "Agenda: Login", JOptionPane.INFORMATION_MESSAGE);
                    System.exit(0);
                
            }
            JOptionPane.showMessageDialog(null, "Usuario No encontrado",
                    "Agenda: Login", JOptionPane.ERROR_MESSAGE);
                    borrarFormulario();
            
        }
        
}        else {
    
            intentos++;
            if (intentos == 3) {
                JOptionPane.showMessageDialog(null, "Numero Maximo de intentos excedido",
                    "Agenda: Login", JOptionPane.INFORMATION_MESSAGE);
                    System.exit(0);
                
            }
            JOptionPane.showMessageDialog(null, "Usuario nNo encontrado",
                   "Agenda: Login", JOptionPane.ERROR_MESSAGE );
            borrarFormulario();

}
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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
