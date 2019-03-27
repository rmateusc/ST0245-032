
public class Contacto
{
    String nombre;
    int numero;
    public Contacto (String nombre, int numero){
        this.numero=numero;
        this.nombre=nombre;
    }
    
    public String getNombre (){
        return nombre;
    }
    
    public int getNumero(){
        return numero;
    }
}
