
package gui.contactos;

import agendita.OperacionesBaseDatos;
import java.awt.Color;
import javax.swing.JOptionPane;

public class AgregarEstado extends javax.swing.JDialog {

    private static AgregarEstado instancia = null;
    
    public AgregarEstado(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        OperacionesBaseDatos.levantarServidorXampp();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        jTextFieldEstado.setToolTipText("El nombre del estado debe tener a lo mucho"
        + LongitudesAtributosBD.LONGITUD_NOMBRE_ESTADO + "caracteres" );
        
    }

    public static AgregarEstado getInstancia (java.awt.Frame parent, boolean modal){
        synchronized (AgregarEstado.class) {
            if (instancia == null) {
                instancia = new AgregarEstado(parent, modal);
            }
        }
        return instancia;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldEstado = new javax.swing.JTextField();
        jButtonAceptar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Estado");

        jTextFieldEstado.setBackground(new java.awt.Color(255, 255, 204));
        jTextFieldEstado.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldEstadoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldEstadoFocusLost(evt);
            }
        });
        jTextFieldEstado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldEstadoKeyTyped(evt);
            }
        });

        jButtonAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/aceptar_16.png"))); // NOI18N
        jButtonAceptar.setText("Aceptar");
        jButtonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAceptarActionPerformed(evt);
            }
        });

        jButtonCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/cancelar_16.png"))); // NOI18N
        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(41, 41, 41)
                        .addComponent(jTextFieldEstado, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                        .addGap(52, 52, 52))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jButtonAceptar)
                        .addGap(36, 36, 36)
                        .addComponent(jButtonCancelar)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(145, 145, 145))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jTextFieldEstado)))
                .addGap(68, 68, 68)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAceptar)
                    .addComponent(jButtonCancelar))
                .addGap(77, 77, 77))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldEstadoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldEstadoFocusGained
        jTextFieldEstado.setBackground(Colores.COLOR_FOCO);
        jTextFieldEstado.selectAll();
    }//GEN-LAST:event_jTextFieldEstadoFocusGained

    private void jTextFieldEstadoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldEstadoFocusLost
       jTextFieldEstado.setBackground(Color.WHITE);
    }//GEN-LAST:event_jTextFieldEstadoFocusLost

    private void jTextFieldEstadoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldEstadoKeyTyped
        char c = evt.getKeyChar();
        String texto = jTextFieldEstado.getText();
        if (texto.length() + 1 > LongitudesAtributosBD.LONGITUD_NOMBRE_ESTADO){
        evt.consume();
        } 
    }//GEN-LAST:event_jTextFieldEstadoKeyTyped

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarActionPerformed
        //verifica que el estado no este registrado en la bd
        String estado = jTextFieldEstado.getText();
        if (estado.equals("")) {
            JOptionPane.showMessageDialog(null, "El campo estado no debe estar vacio",
                    "AgendITA:: Agregar estado", JOptionPane.ERROR_MESSAGE);
                    jTextFieldEstado.setText("");
                    jTextFieldEstado.requestFocus();
        }else{
            if (OperacionesBaseDatos.isEstadoRegistrado(estado)) {
                JOptionPane.showMessageDialog(null, "Estado ya registrado en la Base de datos",
                        "AgendITA: Agregar estado", JOptionPane.ERROR_MESSAGE);
                jTextFieldEstado.requestFocus();
            }else{
                int respuesta = OperacionesBaseDatos.insertarEstado(estado);
                if (respuesta == 1) {
                    JOptionPane.showMessageDialog(null, "Registro insertado exitosamente", 
                            "AgendITA: Agregar estado", JOptionPane.INFORMATION_MESSAGE);
                    jTextFieldEstado.setText("");
                    this.dispose();
                }

            }
            AgregarCiudad agregarCiudad = AgregarCiudad.getInstancia(null, true);
            agregarCiudad.recargarEstados(estado);
        }
        
        
    }//GEN-LAST:event_jButtonAceptarActionPerformed

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
            java.util.logging.Logger.getLogger(AgregarEstado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AgregarEstado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AgregarEstado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AgregarEstado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
             AgregarEstado dialog = new AgregarEstado(new javax.swing.JFrame(), true);
             dialog.addWindowListener(new java.awt.event.WindowAdapter(){
            @Override
            public void windowClosing(java.awt.event.WindowEvent e){
            System.exit(0);
            }
            }
            
        );
             dialog.setVisible(true);
    }   });
                }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAceptar;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextFieldEstado;
    // End of variables declaration//GEN-END:variables
}
