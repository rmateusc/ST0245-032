import java.util.LinkedList;
public class Punto2
{
    LinkedList <Nevera> neveras= new LinkedList<>();
    LinkedList <Pedido> pedidos= new LinkedList<>();

    public void aggNevera(Nevera x){
        neveras.add(x);
    }

    public void aggPedido (Pedido x){
        pedidos.add(x);
    }

    public void entregas (){
        for(int i=0;i<pedidos.size();i++){
            Pedido p=pedidos.remove();
            int cantidadPedido = p.getCantidad();
            System.out.println("Tienda: "+p.getNombreTienda()+" ");
            while(neveras.size()!=0 && cantidadPedido!=0){
                System.out.println(" "+neveras.pop().getNumero()+"-"+neveras.pop().getDescripcion());
                cantidadPedido--;
            }
            System.out.println();
        }
    }
}
