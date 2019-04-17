import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class Read
{
    static ArrayList<ArrayList<String>> arr=new ArrayList<ArrayList<String>>();
    static Directorio direc;
    public static void leer (String dir){
        try {
            FileReader f=new FileReader(dir);
            BufferedReader b=new BufferedReader(f);
            direc=new Directorio (b.readLine());
            String cadena=b.readLine();
            while (cadena!=null) {
                ArrayList<String> arrNuevo=new ArrayList<String>();
                String[]cad=cadena.split(" ");
                for (int i=0;i<cadena.length();i++){
                    arrNuevo.add(cad[i]);
                }
                arr.add(arrNuevo);
            }
            b.close();
            f.close();
            hierarchy();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void hierarchy(){
        for(int i=0; i<arr.size(); i++){
            ArrayList<String>str=arr.get(i);
            int cont=0;
            for(int j=0; j<str.size();j++){
                String info=str.get(j);
                if(info.length()==0){
                    str.remove(j);
                    j--;
                }
                if(info.contains("├")||info.contains("└")||info.contains("│")){
                    cont++;
                    str.remove(info);
                    j--;
                }

            }
            str.add(""+cont);
            str.trimToSize();
        }
        arr.trimToSize();
        save(arr);
    }

    public static void save(ArrayList<ArrayList<String>> newarr){
        for(int i=0;i<newarr.size();i++){
            ArrayList <String>s=newarr.get(i);
            String user=s.get(0).substring(1);
            String size=s.get(1).substring(0,s.get(1).length()-1);
            String name="";
            String b=s.get(s.size()-1);
            for(int j=2;j<s.size()-1;j++){
                name=name+" "+s.get(j); 
            }
            File q= new File(user,size,name,b);
            direc.fl.add(q);
        }
        Search s= new Search(direc);
    }
}
