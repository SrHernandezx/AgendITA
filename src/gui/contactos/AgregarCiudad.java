
package gui.contactos;


import java.awt.Color;
import javax.swing.JOptionPane;
import utilerias.Colores;
import utilerias.OperacionesBaseDatos;


public class AgregarCiudad extends javax.swing.JDialog {

    private static AgregarCiudad instancia = null;
    private Municipio municipios[] ;
    private Estado estados[];
    
    public AgregarCiudad(java.awt.Frame parent, boolean modal) {
        super (parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        OperacionesBaseDatos.levantarServidorXampp();
        this.setResizable(false);
        cargarDatosIniciales();
    }

        public static AgregarCiudad getInstancia(java.awt.Frame parent, boolean modal){
            synchronized (AgregarCiudad.class) {
                if(instancia == null){
                    instancia = new AgregarCiudad(parent, modal);
                }
            }
        return instancia;
        
        }
        
        private void cargarMunicipios(){
            Object [][] datos = OperacionesBaseDatos.buscarMunicipios();
            this.municipios = new Municipio [datos.length];
            for (int i = 0; i < municipios.length; i++) {
                municipios[i] = new Municipio();
                municipios[i].setId(Integer.parseInt(String.valueOf(datos[i][0])));
                municipios[i].setNombre(String.valueOf(String.valueOf(datos[i][1])));
                municipios[i].setIdEstado(Integer.parseInt(String.valueOf(datos[i][2])));
                municipios[i].setNombreEstado(String.valueOf(datos[i][3]));
                
            }
        }
    
        public void recargarEstados(String estado){
            Object [][] datos = OperacionesBaseDatos.buscarEstados();
            this.estados = new Estado [estados.length];
            jComboBoxEstado.removeAllItems();
            for (int i = 0; i < estados.length; i++) {
                estados[i]= new Estado();
                estados[i].setId(Integer.parseInt(String.valueOf(datos[i][0])));
                estados[i].setNombre(String.valueOf(datos[i][1]));
                jComboBoxEstado.addItem(estados[i].toString());
    
            }
           jComboBoxEstado.setSelectedItem(estado);
        }
        
        private void cargarEstados(){
        Object [][] datos = OperacionesBaseDatos.buscarEstados();
            this.estados = new Estado [estados.length];
            jComboBoxEstado.removeAllItems();
            for (int i = 0; i < estados.length; i++) {
                estados[i]= new Estado();
                estados[i].setId(Integer.parseInt(String.valueOf(datos[i][0])));
                estados[i].setNombre(String.valueOf(datos[i][1]));
                jComboBoxEstado.addItem(estados[i].toString());
    
            }
          // jComboBoxEstado.setSelectedItem(estado);
        }
        
        private void cargarDatosIniciales(){
            cargarMunicipios();
            cargarEstados();
        }
        
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldCiudad = new javax.swing.JTextField();
        jButtonAgregarEstado = new javax.swing.JButton();
        jButtonAceptar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jComboBoxEstado = new javax.swing.JComboBox<>();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Ciudad");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Estado");

        jTextFieldCiudad.setBackground(new java.awt.Color(255, 255, 204));
        jTextFieldCiudad.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldCiudadFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldCiudadFocusLost(evt);
            }
        });
        jTextFieldCiudad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCiudadActionPerformed(evt);
            }
        });

        jButtonAgregarEstado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/anadir_24.png"))); // NOI18N
        jButtonAgregarEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgregarEstadoActionPerformed(evt);
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

        jComboBoxEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Veracruz", "Estado 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(41, 41, 41)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldCiudad)
                            .addComponent(jComboBoxEstado, 0, 142, Short.MAX_VALUE))
                        .addGap(41, 41, 41)
                        .addComponent(jButtonAgregarEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addComponent(jButtonAceptar)
                        .addGap(44, 44, 44)
                        .addComponent(jButtonCancelar)))
                .addContainerGap(99, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jTextFieldCiudad)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jButtonAgregarEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAceptar)
                    .addComponent(jButtonCancelar))
                .addGap(79, 79, 79))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldCiudadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCiudadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCiudadActionPerformed

    private void jButtonAgregarEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregarEstadoActionPerformed
        AgregarEstado agregarEstado = AgregarEstado.getInstancia(null,true);
        agregarEstado.setVisible(true);
    }//GEN-LAST:event_jButtonAgregarEstadoActionPerformed

    private void jButtonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarActionPerformed
 
        String municipio = jTextFieldCiudad.getText();
        if(municipio.equals("")){
            JOptionPane.showMessageDialog(null, "El campo ciudad no debe estar vacio","AgendITA: Agregar ciudad", JOptionPane.ERROR_MESSAGE);
            jTextFieldCiudad.requestFocus();
        }else{
            int idEstado = buscarIdEstado(String.valueOf(jComboBoxEstado.getSelectedItem()));
            if(OperacionesBaseDatos.isMunicipioRegistrado(municipio, idEstado)){
               JOptionPane.showMessageDialog(null, "El municipio de " + municipio + " en el estado de " + buscarEstado(idEstado) + "ya esta registrado en la Base de Datos", "AgendITA: Agregar estado", JOptionPane.ERROR_MESSAGE);
               jTextFieldCiudad.setText("");
               jTextFieldCiudad.requestFocus();
           } else{
                int respuesta = OperacionesBaseDatos.insertarMunicipio(municipio, idEstado);
                if(respuesta == 1){
                 JOptionPane.showMessageDialog(null, "Registro insertado exitosamente", "AgendITA: Agregar estado", JOptionPane.INFORMATION_MESSAGE);
                 jTextFieldCiudad.setText("");
                 
                   AgregarContacto agregarContacto = AgregarContacto.getInstancia();
                   agregarContacto.cargarEstados();
                   agregarContacto.recargarMunicipios(municipio, idEstado);
                   this.dispose();
               }
           }
       }
    }//GEN-LAST:event_jButtonAceptarActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        jTextFieldCiudad.setText("");
        this.dispose();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jTextFieldCiudadFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldCiudadFocusGained
       jTextFieldCiudad.setBackground(Colores.COLOR_FOCO);
       jTextFieldCiudad.selectAll();
    }//GEN-LAST:event_jTextFieldCiudadFocusGained

    private void jTextFieldCiudadFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldCiudadFocusLost
        jTextFieldCiudad.setBackground(Color.WHITE);
    }//GEN-LAST:event_jTextFieldCiudadFocusLost
private int buscarIdMunicipio(String municipio){
        for (int i = 0; i < municipios.length; i++) {
            if(municipios[i].getNombre().equals(municipio)){
                return municipios[i].getId();
            }
        }
            return -1;
        }

        private int buscarIdEstado(String estado){
        for (int i = 0; i < estados.length; i++) {
            if(estados[i].getNombre().equals(estados)){
                return estados[i].getId();
            }
        }
            return -1;
        }
        
        private String buscarEstado(int idEstado){
            for (int i = 0; i < estados.length; i++) {
                if(estados[i].getId() == idEstado)
                    return estados[i].getNombre();
                    }
            return null;
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
            java.util.logging.Logger.getLogger(AgregarCiudad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AgregarCiudad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AgregarCiudad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AgregarCiudad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AgregarCiudad dialog = new AgregarCiudad(new javax.swing.JFrame(),true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter(){
                @Override
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
    private javax.swing.JButton jButtonAgregarEstado;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JComboBox<String> jComboBoxEstado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextFieldCiudad;
    // End of variables declaration//GEN-END:variables
}
