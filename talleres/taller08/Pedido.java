
public class Pedido
{
    String nombreTienda;
    int cantidad;
    public Pedido (String nombreTienda, int cantidad){
        this.nombreTienda=nombreTienda;
        this.cantidad=cantidad;
    }
    
    public String getNombreTienda(){
        return nombreTienda;
    }
    
    public int getCantidad(){
        return cantidad;
    }
}
