
package gui.contactos;

public class Estado {
    
    private int id;
    private String nombre;
    
    @Override
    public String toString(){
    return this.nombre;
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
   
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
}
