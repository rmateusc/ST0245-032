import java.util.HashMap;
public class EmpresasPedrito
{
    HashMap <String,String> lista=new HashMap();
    public void asignar (String empresa, String pais){
        lista.put(empresa,pais);
    }
    
    public void getPais (String empresa){
        System.out.println ("El país de la empresa "+empresa+ " es "+lista.get(empresa));
    }
}
