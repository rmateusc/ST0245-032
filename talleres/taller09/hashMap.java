
public class hashMap
{
    Contacto [] tabla=new Contacto [10];
    public Contacto hashMap(Contacto s){
        int n=(s.getNombre().codePointAt(0)%10);
        return tabla[n]=s;
    }
    
    public void add(int index, Contacto c){
        tabla[index]=c;
    }
    
    public String buscarPorNumero(int index){
        String c=null;
        for (int i=0;i<tabla.length;i++){
            if (index==(tabla[i].getNumero())){
                c=tabla[i].getNombre();
            }
        }
        return c;
    }
    
    public int buscarPorNombre(String nombre){
        int n=0;
        for (int i=0;i<tabla.length;i++){
            if (nombre.equals(tabla[i].getNombre())){
                n=tabla[i].getNumero();
            }
        }
        return n;
    }
}
