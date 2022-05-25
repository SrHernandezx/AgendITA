package gui.contactos;

import java.awt.Color;
import javax.swing.JOptionPane;
import utilerias.Colores;
import utilerias.OperacionesBaseDatos;


public class AgregarCiudad extends javax.swing.JDialog {
    
    private static AgregarCiudad instancia = null;
    private Municipo municipios[];
    private Estado estados[];
    
    
    public AgregarCiudad(java.awt.Frame parent, boolean modal) {
        
        super(parent, modal);
        initComponents();
        OperacionesBaseDatos.levantarServidorXampp();
        this.setResizable(false);
        this.setTitle("AgendITA: Agregar ciudad.");   
        this.setLocationRelativeTo(null);   
        cargarDatosIniciales();
    }
    
    public static AgregarCiudad getInstancia(java.awt.Frame parent, boolean modal){
        
        synchronized (AgregarCiudad.class){
            
            if (instancia == null){
                
                instancia = new AgregarCiudad(parent, modal);
            }
        }
        return instancia;
    }
    
    
    private void cargarMunicipios(){
        
        Object[][] datos = OperacionesBaseDatos.buscarMunicipios();
        this.municipios = new Municipio[datos.length];
        
        for(int i = 0; i < municipios.length; i ++){
            
            municipios[i] = new Municipio();
            municipios[i].setId(Integer.parseInt(String.valueOf(datos[i][2])));
            municipios[i].setNombre(String.valueOf(datos[i][1]));
            municipios[i].setIdEstado(Integer.parseInt(String.valueOf(datos[i][2])));
            municipios[i].setNombreEstado(String.valueOf(datos[i][3]));
        }
    }
    
    
    public void recargarEstados(String estado){
        
        Object[][] datos = OperacionesBaseDatos.buscarEstados();
        this.estados = new Estado[datos.length];
        jComboBoxEstado.removeAllItems();
        
        for(int i = 0; i < estados.length; i++){
            estados[i] = new Estado();
            estados[i] = setId(Integer.parseInt(String.valueOf(datos[i][0])));
            estados[i].setNombre(String.valueOf(datos[i][1]));
            jComboBoxEstado.addItem(estados[i].toString());
        }
        jComboBoxEstado.setSelectedItem(estado);
    }
    
    
    private void cargarEstados(){
        
        Object [][] datos = OperacionesBaseDatos.buscarEstados();
        this.estados = new Estado[datos.length];
        jComboBoxEstado.removeAllItems();
        
        for(int i = 0; i < estados.length; i++){
            
            estados[i] = new Estado();
            estados[i] = setId(Integer.parseInt(String.valueOf(datos[i][0])));
            estados[i] = setNombre(String.valueOf(datos[i][1]));
            jComboBoxEstado.addItem(estados[i].toString());
        }
    }
    
    
    private void cargarDatosIniciales(){
        
        cargarMunicipios();
        cargarEstados();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTextFieldCiudad = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButtonAceptar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jButtonAgregarEstado = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(187, 225, 225));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        jTextFieldCiudad.setBackground(new java.awt.Color(187, 225, 225));
        jTextFieldCiudad.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "Ciudad:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N
        jTextFieldCiudad.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldCiudadFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldCiudadFocusLost(evt);
            }
        });

        jComboBox1.setBackground(new java.awt.Color(187, 225, 225));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tamaulipas" }));
        jComboBox1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "Estado:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
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

        jButtonAgregarEstado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/mas3.png"))); // NOI18N
        jButtonAgregarEstado.setBorder(null);
        jButtonAgregarEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgregarEstadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jTextFieldCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonAgregarEstado))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(148, 148, 148)
                        .addComponent(jButtonAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonCancelar)))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextFieldCiudad)
                    .addComponent(jComboBox1)
                    .addComponent(jButtonAgregarEstado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCancelar)
                    .addComponent(jButtonAceptar))
                .addContainerGap(46, Short.MAX_VALUE))
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

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    
    private void jButtonAgregarEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregarEstadoActionPerformed

        AgregarEstado agregarEstado = AgregarEstado.getInstancia(null, true);
        agregarEstado.setVisible(true);
    }//GEN-LAST:event_jButtonAgregarEstadoActionPerformed

    
    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed

        jTextFieldCiudad.setText("");
        this.dispose();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    
    private void jButtonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarActionPerformed

        String municipio = jTextFieldCiudad.getText();
        
        if(municipio.equals("")){
            
            JOptionPane.showMessageDialog(null, "El campo ciudad no debe estar vacío", "AgendITA: Agregar ciudad", JOptionPane.ERROR_MESSAGE);
            jTextFieldCiudad.requestFocus();
        }
        else{
            int idEstado = buscarIdEstado(String.valueOf(jComboBoxEstado.getSelectedItem()));
            
            if(OperacionesBaseDatos.isMunicipioRegistrado(municipio, idEstado)){
                
                JOptionPane.showMessageDialog(null, " El municipio de " + municipio + " en el estado de " + buscarEstado(idEstado) + " ya está registrado en la Base de Datos", "AgendITA: Agregar estados", JOptionPane.ERROR_MESSAGE);
                jTextFieldCiudad.setText("");
                jTextFieldCiudad.requestFocus();
            }
            else{
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

    
    private void jTextFieldCiudadFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldCiudadFocusGained

        jTextFieldCiudad.setBackground(Colores.COLOR_FOCO);
        jTextFieldCiudad.selectAll(); 
    }//GEN-LAST:event_jTextFieldCiudadFocusGained

    
    private void jTextFieldCiudadFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldCiudadFocusLost

        jTextFieldCiudad.setBackground(Color.WHITE); 
    }//GEN-LAST:event_jTextFieldCiudadFocusLost

    
    private int buscarIdMunicipio(String municipio){
        
        for(int i = 0; i < municipios.length; i++){
            
            if(municipios[i].getNombre().equals(municipios)){
                
                return municipios[i].getId();
            }
        } 
        return -1;
    }
    
    
    private int buscarIdEstado(String estado){
        
        for(int i = 0; i < estados.length; i++){
            
            if(estados[i].getNombre().equals(estado)){
                
                return estados[i].getId();
            }
        }
        return -1;
    }

    
    private String buscarEstado(int idEstado){
        
        for (int i = 0; 1 < estados.length; i++){
            
            if(estados[i].getId() == idEstado){
                
                return estados[i].getNombre();
            }
        }
        return null;
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
            java.util.logging.Logger.getLogger(AgregarCiudad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AgregarCiudad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AgregarCiudad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AgregarCiudad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                AgregarCiudad dialog = new AgregarCiudad(new javax.swing.JFrame(), true);
                dialog.addWindowFocusListener(new java.awt.event.WindowAdapter(){
                    
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
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextFieldCiudad;
    // End of variables declaration//GEN-END:variables
}
