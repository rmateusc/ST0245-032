
/**
 * Write a description of class Main here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.ArrayList;
public class Main
{
    public void main () throws IOException {
        try {
            //System.out.println("Porfavor ingrese la direccion donde se encuentran las coordenadas de las abejas");
            //Scanner dir=new Scanner(System.in);
            //String direccion=dir.nextLine();
            /*ArrayList<Long> a=new ArrayList();
            for (int i=0;i<13;++i) {
            long ab=0;
            a.add(ab);
            }
            for (int i=0;i<100;++i) {
            System.out.println(i);
            long start=System.currentTimeMillis();
            Reader r=new Reader("D:/Backup Daniel/Perfil/OneDrive/Documents/Daniel/Estructuras Datos y Algoritmos/Proyecto/4Abejas.txt");
            long tiempo=System.currentTimeMillis()-start;
            long ti=a.get(0)+tiempo;
            a.add(0,ti);
            a.remove(1);
            start=System.currentTimeMillis();
            Reader ra=new Reader("D:/Backup Daniel/Perfil/OneDrive/Documents/Daniel/Estructuras Datos y Algoritmos/Proyecto/10Abejas.txt");
            tiempo=System.currentTimeMillis()-start;
            ti=a.get(1)+tiempo;
            a.add(1,ti);
            a.remove(2);
            start=System.currentTimeMillis();
            Reader re=new Reader("D:/Backup Daniel/Perfil/OneDrive/Documents/Daniel/Estructuras Datos y Algoritmos/Proyecto/15Abejas.txt");
            tiempo=System.currentTimeMillis()-start;
            ti=a.get(2)+tiempo;
            a.add(2,ti);
            a.remove(3);
            start=System.currentTimeMillis();
            Reader ri=new Reader("D:/Backup Daniel/Perfil/OneDrive/Documents/Daniel/Estructuras Datos y Algoritmos/Proyecto/100Abejas.txt");
            tiempo=System.currentTimeMillis()-start;
            ti=a.get(3)+tiempo;
            a.add(3,ti);
            a.remove(4);
            start=System.currentTimeMillis();
            Reader ro=new Reader("D:/Backup Daniel/Perfil/OneDrive/Documents/Daniel/Estructuras Datos y Algoritmos/Proyecto/150Abejas.txt");
            tiempo=System.currentTimeMillis()-start;
            ti=a.get(4)+tiempo;
            a.add(4,ti);
            a.remove(5);
            start=System.currentTimeMillis();
            Reader ru=new Reader("D:/Backup Daniel/Perfil/OneDrive/Documents/Daniel/Estructuras Datos y Algoritmos/Proyecto/1000Abejas.txt");
            tiempo=System.currentTimeMillis()-start;
            ti=a.get(5)+tiempo;
            a.add(5,ti);
            a.remove(6);
            start=System.currentTimeMillis();
            Reader rh=new Reader("D:/Backup Daniel/Perfil/OneDrive/Documents/Daniel/Estructuras Datos y Algoritmos/Proyecto/1500Abejas.txt");
            tiempo=System.currentTimeMillis()-start;
            ti=a.get(6)+tiempo;
            a.add(6,ti);
            a.remove(7);
            start=System.currentTimeMillis();
            Reader rih=new Reader("D:/Backup Daniel/Perfil/OneDrive/Documents/Daniel/Estructuras Datos y Algoritmos/Proyecto/10000Abejas.txt");
            tiempo=System.currentTimeMillis()-start;
            ti=a.get(7)+tiempo;
            a.add(7,ti);
            a.remove(8);
            start=System.currentTimeMillis();
            Reader rp=new Reader("D:/Backup Daniel/Perfil/OneDrive/Documents/Daniel/Estructuras Datos y Algoritmos/Proyecto/15000Abejas.txt");
            tiempo=System.currentTimeMillis()-start;
            ti=a.get(8)+tiempo;
            a.add(8,ti);
            a.remove(9);
            start=System.currentTimeMillis();
            Reader rk=new Reader("D:/Backup Daniel/Perfil/OneDrive/Documents/Daniel/Estructuras Datos y Algoritmos/Proyecto/100000Abejas.txt");
            tiempo=System.currentTimeMillis()-start;
            ti=a.get(9)+tiempo;
            a.add(9,ti);
            a.remove(10);
            start=System.currentTimeMillis();
            Reader rl=new Reader("D:/Backup Daniel/Perfil/OneDrive/Documents/Daniel/Estructuras Datos y Algoritmos/Proyecto/150000Abejas.txt");
            tiempo=System.currentTimeMillis()-start;
            ti=a.get(10)+tiempo;
            a.add(10,ti);
            a.remove(11);
            start=System.currentTimeMillis();
            Reader rq=new Reader("D:/Backup Daniel/Perfil/OneDrive/Documents/Daniel/Estructuras Datos y Algoritmos/Proyecto/1000000Abejas.txt");
            tiempo=System.currentTimeMillis()-start;
            ti=a.get(11)+tiempo;
            a.add(11,ti);
            a.remove(12);
            start=System.currentTimeMillis();
            Reader rm=new Reader("D:/Backup Daniel/Perfil/OneDrive/Documents/Daniel/Estructuras Datos y Algoritmos/Proyecto/1500000Abejas.txt");
            tiempo=System.currentTimeMillis()-start;
            ti=a.get(12)+tiempo;
            a.add(12,ti);
            a.remove(13);
            }
            for (int i=0;i<13;++i) {
            long promedio=a.get(i)/100;
            System.out.println(promedio);
            }*/
            Reader rm=new Reader("D:/Backup Daniel/Perfil/OneDrive/Documents/Daniel/Estructuras Datos y Algoritmos/Proyecto/1500000Abejas.txt");
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }
}