import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
/**
 * Write a description of class Archivo here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Archivo
{
    HashMap<Long,Vertice> vertices=new HashMap();
    boolean bandera=false;
    public void leer (String dir) throws IOException{
        try (BufferedReader br=new BufferedReader(new FileReader(dir))){
            String line;
            int i=0;
            while ((line=br.readLine())!=null){ //si da
                if (i!=0) splitString(line);
                else ++i;
            } 
            br.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }  

    public void splitString(String s){
        String [] str=s.split(" ");  
        try{
            if (str[0].equals("Arcos.")) {
                bandera=true;
            } else {
                if (bandera) {
                    arcos(str);
                } else {
                    vertices(str);
                }
            } 
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(s);
        }
    }

    public void arcos (String [] str) {
        try {
            long ID1=Long.parseLong(str[0]);
            long ID2=Long.parseLong(str[1]);
            double distancia=Double.parseDouble(str[2]);
            if (str.length>3) {
                String nombre="";
                for (int i=3;i<str.length;++i) {
                    if (i==str.length-1) {
                        nombre+=str[i];
                    } else {
                        nombre+=str[i]+" ";
                    }
                }
                Arco a1=new Arco(ID1,distancia,nombre);
                Arco a2=new Arco(ID2,distancia,nombre);
                vertices.get(ID1).addArco(a2);
                vertices.get(ID2).addArco(a1);
            } else {
                Arco a1=new Arco(ID1,distancia);
                Arco a2=new Arco(ID2,distancia);
                vertices.get(ID1).addArco(a2);
                vertices.get(ID2).addArco(a1);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void vertices (String [] str) {
        long ID=Long.parseLong(str[0]);
        double x=Double.parseDouble(str[1]);
        double y=Double.parseDouble(str[2]);
        if (str.length>3) {
            String nombre="";
            for (int i=3;i<str.length;++i) {
                if (i==str.length-1) {
                    nombre+=str[i];
                } else {
                    nombre+=str[i]+" ";
                }
            }
            Vertice vertex=new Vertice(ID,x,y,nombre);
            vertices.put(vertex.getID(),vertex);
        } else {
            Vertice vertex=new Vertice(ID,x,y);
            vertices.put(vertex.getID(),vertex);
        }
    }
}

