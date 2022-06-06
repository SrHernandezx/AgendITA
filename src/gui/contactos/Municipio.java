
package gui.contactos;

/**
 *
 * @author elias
 */
public class Municipio {
    private int id;
    private String nombre;
    private Estado estado = new Estado();
    
    public String toString(){
        return this.nombre + " (" + this.getNombreEstado() +")";
    }
    public int getId(){
        return id;
    }
    public String getNombre(){
        return nombre;
        
    }
    public void setId(int id){
        this.id = id;
    }
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    public int getIdEstado(){
        return this.estado.getId();
        
    }
    public String getNombreEstado(){
        return this.estado.getNombre();
    }
    public void setIdEstado(int id){
        this.estado.setId(id);
    }
    public void setNombreEstado(String nombre){
        this.estado.setNombre(nombre);
    }
}
