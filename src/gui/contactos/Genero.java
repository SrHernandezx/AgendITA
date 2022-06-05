package gui.contactos;


public class Genero {
   private int id;
    private String genero;
    
    @Override
    public String toString(){
    return this.genero;
    }
    
    public int getId(){
        return id;
    }
    
    public String getGenero(){
        return genero;
    }
    
    public void setId(int id){
    this.id = id;
    }
   
    public void setNombre(String genero) {
        this.genero = genero;
    } 
}
