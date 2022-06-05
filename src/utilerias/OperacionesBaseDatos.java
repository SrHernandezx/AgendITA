package utilerias;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class OperacionesBaseDatos {
    
    protected static String baseDeDatos = "jdbc:mysql://127.0.0.1/agendita";
    protected static String driver = "com.mysql.jdbc.Driver";
    
    public static Connection conexion = null;
    public static PreparedStatement pstm = null;
    public static ResultSet rs = null;
    public static boolean conexionActiva = false;
    public static boolean servidorActivo = false;
    
    
    public static void levantarServidorXampp(){
        
        establecerSesion("root", "");
        conexionActiva = true;
        servidorActivo = true;
    }
    
    
    public static void detenerServidorXampp(){
        
        //PENDIENTE
    }
    
    
    public static void establecerSesion(String usuario, String contra){
        
        try {
            Class.forName(driver);
            conexion = DriverManager.getConnection(baseDeDatos, usuario, contra);
            conexionActiva = true;
            
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            conexionActiva = false;
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            conexionActiva = false;
        }
    }

    
    public static boolean conexionActiva(){
        
        return conexionActiva;
    }
    
    
    public static boolean servidorActivo(){
        
        return servidorActivo;
    }
    
    //USUARIOS
    
    public static String[] buscarUsuario(String usuario){
        
        String[] datos = new String[2];
        
        if(conexionActiva){
            
            try {
                String sql = "SELECT nombre, contra FROM usuarios WHERE nombre" + "COLLATE latin1_general_cs = \"" + usuario + "\"";
                pstm = conexion.prepareStatement(sql);
                rs = pstm.executeQuery();
                rs.last();
                int registros = rs.getRow();
                rs.first();
                
                if(registros !=1){
                    
                    return null;
                } else{
                    
                    datos[0] = rs.getString(1);
                    datos[1] = rs.getString(2);
                }
            } catch (SQLException ex) {
                Logger.getLogger(OperacionesBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return datos;
    }
    
    
    public static Object[] buscarUsuario(int id_usuario){
        
        Object[] datos = new Object[3];
        
        if(conexionActiva){
            
            try {
                
                String sql = "SELECT * FROM usuarios WHERE id_usuario = " + id_usuario;
                pstm = conexion.prepareStatement(sql);
                rs = pstm.executeQuery();
                rs.last();
                int registros = rs.getRow();
                rs.first();
            
                if(registros != 1){
                    
                    return null;
                    
                }
                else {

                    datos[0] = rs.getObject(1);
                    datos[1] = rs.getObject(2);
                    datos[2] = rs.getObject(3);   
                }
            } catch (SQLException ex) {
            Logger.getLogger(OperacionesBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return datos;
    }
    
    
    public static Object[][] buscarUsuarios(){
        
        Object[][] datos = null;

        if(conexionActiva){
            
            try {
                
                String sql = "SELECT id_usuario, nombre FROM usuarios";
               
                pstm = conexion.prepareStatement(sql);
                rs = pstm.executeQuery();
                rs.last();
                int registros = rs.getRow();
                rs.beforeFirst();
                datos = new Object[registros][2];
                int contador = 0;
 
                while(rs.next()){
                    
                    datos[contador][0] = rs.getObject(1);
                    datos[contador][1] = rs.getObject(2);     
                    contador++;
                }
            } catch (SQLException ex) {
            Logger.getLogger(OperacionesBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return datos;
    }  
    
    
    public static String[][] buscarUsuarios(String usuario){
        
        String[][] datos = null;

        if(conexionActiva){
            
            try {
                
                String sql = "SELECT id_usuario, nombre FROM usuarios WHERE nombre LIKE '%" + usuario + "%'";
               
                pstm = conexion.prepareStatement(sql);
                rs = pstm.executeQuery();
                rs.last();
                int registros = rs.getRow();
                rs.beforeFirst();
                datos = new String[registros][2];
                int contador = 0;
 
                while(rs.next()){
                    
                    datos[contador][0] = rs.getString(1);
                    datos[contador][1] = rs.getString(2);     
                    contador++;
                }
            } catch (SQLException ex) {
            Logger.getLogger(OperacionesBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return datos;
    }
    
    
    public static void eliminarUsuario(int id_usuario){
        
        if(conexionActiva){

            try {
                
                String sql = "DELETE FROM usuarios WHERE id_usuario = ?";
                
                pstm = conexion.prepareStatement(sql);
                pstm.setInt(1, id_usuario);
                
                int resultado = pstm.executeUpdate();
                
                if(resultado == 1){
                    
                    JOptionPane.showMessageDialog(null, "Registro eliminado exitosamente", "Eliminar", JOptionPane.INFORMATION_MESSAGE);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Hubo un error al elinar el registro", "Eliminar", JOptionPane.ERROR_MESSAGE);
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(OperacionesBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
    public static void insertarUsuario(String nombre, String contra){
        
        if(conexionActiva){

            try {
                
                String sql = "INSERT INTO usuarios (nombre, contra) VALUES (?,?)";
                
                pstm = conexion.prepareStatement(sql);
                pstm.setString(1, nombre);
                pstm.setString(2, contra);
                
                int resultado = pstm.executeUpdate();
                
                if(resultado == 1){
                    
                    JOptionPane.showMessageDialog(null, "Registro insertado exitosamente", "AgendITA: Agregar usuario", JOptionPane.INFORMATION_MESSAGE);
                }
                else{
                    JOptionPane.showMessageDialog(null, "El registro no se pudo insertar", "AgendITA: agregar usuario", JOptionPane.ERROR_MESSAGE);
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(OperacionesBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    } 
    
    
    public static void modificarUsuario (int id_usuario, String nombre, String contra){
        
        if(conexionActiva){

            try {
                
                String sql = "UPDATE usuarios SET" + "nombre = ?, contra = ?" + "WHERE id_usuario = ?";
                
                pstm = conexion.prepareStatement(sql);
                pstm.setString(1, nombre);
                pstm.setString(2, contra);
                pstm.setInt(3, id_usuario);

                int resultado = pstm.executeUpdate();
                
                if(resultado == 1){
                    
                    JOptionPane.showMessageDialog(null, "Registro modificado exitosamente", "AgendITA: Modificar usario", JOptionPane.INFORMATION_MESSAGE);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Hubo un error al modificar el registro", "AgendITA: Modificar usario", JOptionPane.ERROR_MESSAGE);
                }
                
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    //CONTACTOS
    
    public static Object[][] buscarContactos(){
        
        Object[][] datos = null;

        if(conexionActiva){
            
            try {
                
                String sql = "SELECT id_contacto, nombres, apellido_paterno, apellido_materno, fecha_nacimiento " + "FROM contactos";
               
                pstm = conexion.prepareStatement(sql);
                rs = pstm.executeQuery();
                rs.last();
                int registros = rs.getRow();
                rs.beforeFirst();
                datos = new Object[registros][5];
                int contador = 0;
 
                while(rs.next()){
                    
                    datos[contador][0] = rs.getObject(1);
                    datos[contador][1] = rs.getObject(2); 
                    datos[contador][2] = rs.getObject(3);
                    datos[contador][3] = rs.getObject(4);
                    datos[contador][4] = rs.getObject(5);
                    contador++;
                }
            } catch (SQLException ex) {
            Logger.getLogger(OperacionesBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return datos;
    }  
    
    
    public static Object[][] buscarContactos(String contacto){
        
        Object[][] datos = null;

        if(conexionActiva){
            
            try {
                
                String sql = "SELECT id_contacto, nombres, apellido_paterno, apellido_materno, fecha_nacimiento " + "FROM contactos WHERE nombres LIKE '%" + contacto + "%' " + "OR apellido_paterno LIKE '%"+ contacto + "%' " + "OR apellido_materno LIKE '%" + contacto + "%' ";
               
                pstm = conexion.prepareStatement(sql);
                rs = pstm.executeQuery();
                rs.last();
                int registros = rs.getRow();
                rs.beforeFirst();
                datos = new Object[registros][5];
                int contador = 0;
 
                while(rs.next()){
                    
                    datos[contador][0] = rs.getObject(1);
                    datos[contador][1] = rs.getObject(2); 
                    datos[contador][2] = rs.getObject(3);
                    datos[contador][3] = rs.getObject(4);
                    datos[contador][4] = rs.getObject(5);
                    contador++;
                }
            } catch (SQLException ex) {
            Logger.getLogger(OperacionesBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return datos;
    } 
    
    
    public static void eliminarContacto(int id_contacto){
        
        if(conexionActiva){

            try {
                
                String sql = "DELETE FROM contactos WHERE id_contacto = ?";
                
                pstm = conexion.prepareStatement(sql);
                pstm.setInt(1, id_contacto);
                
                int resultado = pstm.executeUpdate();
                
                if(resultado == 1){
                    
                    JOptionPane.showMessageDialog(null, "Registro eliminado exitosamente", "Eliminar", JOptionPane.INFORMATION_MESSAGE);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Hubo un error al eliminar el registro", "Eliminar", JOptionPane.ERROR_MESSAGE);
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(OperacionesBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
    public static int insertarContacto(String nombres, String apellido_paterno, String apellido_materno, String fecha_nacimiento, int id_genero, String ruta_foto, String calle, int numero, String colonia, int id_municipio, int id_estado){
    
        int resultado = -1;
        
        if(conexionActiva){
            
            try {
                
                String sql = "INSERT INTO contactos (nombre, apellido_paterno, apellido_materno, fecha_nacimiento," + " genero, ruta_foto, calle, numero, colonia, id_municipio, id_estado) " + "VALUES (?,?,?,?,?,?,?,?,?,?,?)";
               
                pstm = conexion.prepareStatement(sql);
                pstm.setString(1, nombres);
                pstm.setString(2, apellido_paterno);
                pstm.setString(3, apellido_materno);
                pstm.setString(4, fecha_nacimiento);
                pstm.setInt(5, id_genero);
                pstm.setString(6, ruta_foto);
                pstm.setString(7, calle);
                pstm.setInt(8, numero);
                pstm.setString(9, colonia);
                pstm.setInt(10, id_municipio);
                pstm.setInt(11, id_estado);
                
                resultado = pstm.executeUpdate();
               
            } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "El registro no se pudo insertar","AgendITA: agregar contacto", JOptionPane.ERROR_MESSAGE);
            }
        }
        return resultado;
    }
    
    
    //MUNICIPIOS
    
    
    public static int insertarMunicipio(String municipio, int id_estado){
        
        int resultado = -1;
        
        if(conexionActiva){
            
            try {
                
                String sql = "INSERT INTO municipios (nombre, id_estado) VALUES (?,?)";
               
                pstm = conexion.prepareStatement(sql);
                pstm.setString(1, municipio);
                pstm.setInt(2, id_estado);
                
                resultado = pstm.executeUpdate();
               
            } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "El registro no se pudo insertar","AgendITA: agregar municipio", JOptionPane.ERROR_MESSAGE);
            }
        }
        return resultado;
    }   
    
    
    public static Object[][] buscarMunicipios(){
        
        Object[][] datos = null;

        if(conexionActiva){
            
            try {
                
                String sql = "SELECT municipios.id_municipios, municipios.nombre, municipios.id_estado, " + "estados.nombre FROM municipios INNER JOIN estados ON estados.id_estado = municipios.id_estado " + "ORDER BY id_estado ASC, municipios.nombre ASC";
               
                pstm = conexion.prepareStatement(sql);
                rs = pstm.executeQuery();
                rs.last();
                int registros = rs.getRow();
                rs.beforeFirst();
                datos = new Object[registros][4];
                int contador = 0;
 
                while(rs.next()){
                    
                    datos[contador][0] = rs.getObject(1);
                    datos[contador][1] = rs.getObject(2); 
                    datos[contador][2] = rs.getObject(3);
                    datos[contador][3] = rs.getObject(4);
                    
                    contador++;
                }
            } catch (SQLException ex) {
            Logger.getLogger(OperacionesBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return datos;
    }   
    
    
    public static Object[][] buscarMunicipio(String municipio){
        
        Object[][] datos = null;

        if(conexionActiva){
            
            try {
                
                String sql = "SELECT municipios.id_municipios, municipios.nombre, municipios.id_estado, " + "estados.nombre FROM municipios INNER JOIN estados ON estados.id_estado = municipios.id_estado " + "WHERE municipios.nombre LIKE '" + municipio + "' " + "ORDER BY id_estado ASC, municipios.nombre ASC ";
                
               
                pstm = conexion.prepareStatement(sql);
                rs = pstm.executeQuery();
                rs.last();
                int registros = rs.getRow();
                rs.beforeFirst();
                datos = new Object[registros][4];
                int contador = 0;
 
                while(rs.next()){
                    
                    datos[contador][0] = rs.getObject(1);
                    datos[contador][1] = rs.getObject(2); 
                    datos[contador][2] = rs.getObject(3);
                    datos[contador][3] = rs.getObject(4);
                    
                    contador++;
                }
            } catch (SQLException ex) {
            Logger.getLogger(OperacionesBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return datos;
    }  
    
    
    public static Object[][] buscarMunicipio(String municipio, int idEstado){
        
        Object[][] datos = null;

        if(conexionActiva){
            
            try {
                
                String sql = "SELECT municipios.id_municipios, municipios.nombre, municipios.id_estado, " + "estados.nombre FROM municipios INNER JOIN estados ON estados.id_estado = municipios.id_estado " + "WHERE municipios.nombre LIKE '" + municipio + "' AND municipios.id_estado = " + idEstado + " " + "ORDER BY id_estado ASC, municipios.nombre ASC ";
                
                pstm = conexion.prepareStatement(sql);
                rs = pstm.executeQuery();
                rs.last();
                int registros = rs.getRow();
                rs.beforeFirst();
                datos = new Object[registros][4];
                int contador = 0;
 
                while(rs.next()){
                    
                    datos[contador][0] = rs.getObject(1);
                    datos[contador][1] = rs.getObject(2); 
                    datos[contador][2] = rs.getObject(3);
                    datos[contador][3] = rs.getObject(4);
                    
                    contador++;
                }
            } catch (SQLException ex) {
            Logger.getLogger(OperacionesBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return datos;
    } 
    
    
    public static boolean isMunicipioRegistrado(String municipio, int id_estado){
        
        if(conexionActiva){
            
            try {
                
                String sql = "SELECT nombre FROM municipio WHERE nombre LIKE '" + municipio + "' AND id_estado = " + id_estado;
               
                pstm = conexion.prepareStatement(sql);
                rs = pstm.executeQuery();
                rs.last();
                int registros = rs.getRow();
                
                if(registros > 0){
                    
                    return true;
                }
            } catch (SQLException ex) {
            Logger.getLogger(OperacionesBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }
    
    
    //ESTADOS
    
    
    public static int insertarEstado(String estado){
        
        int resultado = -1;
        
        if(conexionActiva){
            
            try {
                
                String sql = "INSERT INTO estados (nombre) VALUES (?)";
               
                pstm = conexion.prepareStatement(sql);
                pstm.setString(1, estado);
   
                resultado = pstm.executeUpdate();
               
            } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "El registro no se pudo insertar", "AgendITA: agregar contacto", JOptionPane.ERROR_MESSAGE);
            }
        }
        return resultado;
    }  
    
    
    public static Object[][] buscarEstados(){
        
        Object[][] datos = null;

        if(conexionActiva){
            
            try {
                
                String sql = "SELECT id_estado, nombre FROM estados";
                
                pstm = conexion.prepareStatement(sql);
                rs = pstm.executeQuery();
                rs.last();
                int registros = rs.getRow();
                rs.beforeFirst();
                datos = new Object[registros][2];
                int contador = 0;
 
                while(rs.next()){
                    
                    datos[contador][0] = rs.getObject(1);
                    datos[contador][1] = rs.getObject(2); 
                    
                    contador++;
                }
            } catch (SQLException ex) {
            Logger.getLogger(OperacionesBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return datos;
    } 
    
    
    public static boolean isEstadoRegistrado(String estado){
        
        if(conexionActiva){
            
            try {
                
                String sql = "SELECT nombre FROM estados WHERE nombre LIKE '" + estado + "'";
               
                pstm = conexion.prepareStatement(sql);
                rs = pstm.executeQuery();
                rs.last();
                int registros = rs.getRow();
                
                if(registros > 0){
                    
                    return true;
                }
            } catch (SQLException ex) {
            Logger.getLogger(OperacionesBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    } 
    
    //GENEROS
    
    public static int insertarGenero(String genero){
        
        int resultado = -1;
        
        if(conexionActiva){
            
            try {
                
                String sql = "INSERT INTO generos (genero) VALUES (?)";
               
                pstm = conexion.prepareStatement(sql);
                pstm.setString(1, genero);
                resultado = pstm.executeUpdate();
    
            } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "El registro no se pudo insertar", "AgendITA: agregar genero", JOptionPane.ERROR_MESSAGE);
            }
        }
        return resultado;
    } 
    
    
    public static Object[][] buscarGeneros(){
        
        Object[][] datos = null;

        if(conexionActiva){
            
            try {
                
                String sql = "SELECT * FROM generos";
                
                pstm = conexion.prepareStatement(sql);
                rs = pstm.executeQuery();
                rs.last();
                int registros = rs.getRow();
                rs.beforeFirst();
                datos = new Object[registros][2];
                int contador = 0;
 
                while(rs.next()){
                    
                    datos[contador][0] = rs.getObject(1);
                    datos[contador][1] = rs.getObject(2); 
                    
                    contador++;
                }
            } catch (SQLException ex) {
            Logger.getLogger(OperacionesBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return datos;
    } 
    
    
    public static Object[][] buscarGenero(String genero){
        
        Object[][] datos = null;

        if(conexionActiva){
            
            try {
                
                String sql = "SELECT * FROM generos WHERE genero LIKE '" + genero + "'";
                
                pstm = conexion.prepareStatement(sql);
                rs = pstm.executeQuery();
                rs.last();
                int registros = rs.getRow();
                rs.beforeFirst();
                datos = new Object[registros][2];
                int contador = 0;
 
                while(rs.next()){
                    
                    datos[contador][0] = rs.getObject(1);
                    datos[contador][1] = rs.getObject(2); 
                    
                    contador++;
                }
            } catch (SQLException ex) {
            Logger.getLogger(OperacionesBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return datos;
    } 
    
    
    public static boolean isGeneroRegistrado (String genero){
        
        if(conexionActiva){
            
            try {
                
                String sql = "SELECT nombre FROM generos WHERE genero LIKE '" + genero + "'";
               
                pstm = conexion.prepareStatement(sql);
                rs = pstm.executeQuery();
                rs.last();
                int registros = rs.getRow();
                
                if(registros > 0){
                    
                    return true;
                }
            } catch (SQLException ex) {
            Logger.getLogger(OperacionesBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    } 
    
    //OTROS
   
    public static int ultimoRegistroInsertado(){
        
        int id = -1;
        
        if(conexionActiva){
            
            try {
                
                String sql = "SELECT last_insert_id() as last_id FROM contactos";
               
                pstm = conexion.prepareStatement(sql);
                rs = pstm.executeQuery();
                rs.next();
                id = rs.getInt("last_id");
    
            } catch (SQLException ex) {
            Logger.getLogger(OperacionesBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return id;
    }
    
    
    public static int insertarTelefono(int id_contacto, String telefono){
        
        int resultado = -1;
        
        if(conexionActiva){
            
            try {
                
                String sql = "INSERT INTO telefonos (id_contacto, telefono) VALUES (?,?)";
               
                pstm = conexion.prepareStatement(sql);
                pstm.setInt(1, id_contacto);
                pstm.setString(2, telefono);
                
                resultado = pstm.executeUpdate();
    
            } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "El registro no se pudo insertar", "AgendITA: agregar teléfono", JOptionPane.ERROR_MESSAGE);
            }
        }
        return resultado;
    } 
    
    
    public static int insertarCorreoElectronico(int id_contacto, String correo){
        
        int resultado = -1;
        
        if(conexionActiva){
            
            try {
                
                String sql = "INSERT INTO emails (id_contacto, email) VALUES (?,?)";
               
                pstm = conexion.prepareStatement(sql);
                pstm.setInt(1, id_contacto);
                pstm.setString(2, correo);
                
                resultado = pstm.executeUpdate();
    
            } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "El registro no se pudo insertar", "AgendITA: agregar email", JOptionPane.ERROR_MESSAGE);
            }
        }
        return resultado;
    }           
}
