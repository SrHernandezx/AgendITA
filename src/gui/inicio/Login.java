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

        jPanelPrincipal = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPasswordFieldPassword = new javax.swing.JTextField();
        jTextFieldUsuario = new javax.swing.JTextField();
        jButtonAceptar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanelPrincipal.setBackground(java.awt.Color);

        jLabel1.setText("Nombre:");

        jLabel2.setText("Contraseña:");

        jLabel3.setText("jLabel3");

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

        jTextFieldUsuario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldUsuarioFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldUsuarioFocusLost(evt);
            }
        });

        jButtonAceptar.setText("Aceptar");
        jButtonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAceptarActionPerformed(evt);
            }
        });

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelPrincipalLayout = new javax.swing.GroupLayout(jPanelPrincipal);
        jPanelPrincipal.setLayout(jPanelPrincipalLayout);
        jPanelPrincipalLayout.setHorizontalGroup(
            jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldUsuario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPasswordFieldPassword, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(118, 118, 118))
            .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                .addGap(158, 158, 158)
                .addComponent(jButtonAceptar)
                .addGap(54, 54, 54)
                .addComponent(jButtonCancelar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelPrincipalLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addContainerGap())
        );
        jPanelPrincipalLayout.setVerticalGroup(
            jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(45, 45, 45)
                .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jPasswordFieldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(63, 63, 63)
                .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAceptar)
                    .addComponent(jButtonCancelar))
                .addContainerGap(111, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelPrincipal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
    private javax.swing.JButton jButtonAceptar;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanelPrincipal;
    private javax.swing.JTextField jPasswordFieldPassword;
    private javax.swing.JTextField jTextFieldUsuario;
    // End of variables declaration//GEN-END:variables
}
