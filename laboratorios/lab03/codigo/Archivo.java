
/**
 * Write a description of class Archivo here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.BufferedWriter;
public class Archivo
{
    public static ArrayList<String> nombres=new ArrayList();
    public static ArrayList<Double> notas=new ArrayList();
    public static String titulo;
    public static void principal (String nombre,String semestre,int consulta) throws FileNotFoundException {
        try {
            String direccion="D:/Backup Daniel/Perfil/OneDrive/Documents/Daniel/Estructuras Datos y Algoritmos/Lab3/"+nombre+"-"+semestre;
            leerArchivo(direccion);
            if (consulta==1) {
                boolean salir=false;
                while (salir==false) {
                    System.out.println("¿Desea cambiar la nota de algun estudiante? Si es asi presiona 1\n¿Desea eliminar a algun estudiante? Si es asi presione 2\nSi no desea hacer ninguna de estas dos operaciones presione cualquier otro numero");
                    Scanner r=new Scanner(System.in);
                    int res=r.nextInt();
                    if (res==1) {
                        boolean encontrado=false;
                        while (encontrado==false) {
                            System.out.println("Digite el nombre del estudiante de manera que sea exactamente igual al anteriormente impreso, de lo contrario el estudiante no sera encontrado");
                            r=new Scanner(System.in);
                            String nom=r.nextLine();
                            int index=nombres.indexOf(nom);
                            if (index!=-1) {
                                System.out.println("Digite que quiere ponerle al estudiante "+nom);
                                r=new Scanner(System.in);
                                double nota=r.nextDouble();
                                notas.remove(index);
                                notas.add(index,nota);
                                encontrado=true;
                            } else {
                                System.out.println("El estudiante no fue encontrado, sera redirigido a la opcion de ingresar el nombre del estudiante");
                            }
                        }
                        System.out.println("Su accion ha terminado!\nSi desea hacer otra accion digite un numero mayor o igual a cero\nDe lo contrario digite un numero negativo");
                        r=new Scanner(System.in);
                        int s=r.nextInt();
                        if (s<0) salir=true; System.out.println("Gracias por utilizar nuestro sistema de busqueda, que tenga un buen dia!");
                    }else if (res==2) {
                        boolean encontrado=false;
                        while (encontrado==false) {
                            System.out.println("Digite el nombre del estudiante de manera que sea exactamente igual al anteriormente impreso, de lo contrario el estudiante no sera encontrado");
                            r=new Scanner(System.in);
                            String nom=r.nextLine();
                            int index=nombres.indexOf(nom);
                            if (index!=-1) {
                                nombres.remove(index);
                                notas.remove(index);
                            } else {
                                System.out.println("El estudiante no fue encontrado, sera redirigido a la opcion de ingresar el nombre del estudiante");
                            }
                        }
                        System.out.println("Su accion ha terminado!\nSi desea hacer otra accion digite un numero mayor o igual a cero\nDe lo contrario digite un numero negativo");
                        r=new Scanner(System.in);
                        int s=r.nextInt();
                        if (s<0) salir=true; System.out.println("Gracias por utilizar nuestro sistema de busqueda, que tenga un buen dia!");
                    } else salir=true; System.out.println("Gracias por utilizar nuestro sistema de busqueda, que tenga un buen dia!");
                }
            }
            sobreescribirArchivo(direccion);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void leerArchivo (String direccion) throws FileNotFoundException, IOException {
        try {
            String cadena;
            FileReader f=new FileReader(direccion);
            BufferedReader b=new BufferedReader(f);
            String [] s=new String [0];
            System.out.println("Aqui esta el archivo encontrado");
            int cont=0;
            while ((cadena=b.readLine())!=null) {
                System.out.println(cadena);
                if (cont>0) {
                    String [] cad=cadena.split(":");
                    nombres.add(cad[0]);
                    notas.add(Double.parseDouble(cad[1]));
                } else {
                    titulo=cadena;
                }
                cont++;
            }
            b.close();
            f.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void sobreescribirArchivo (String direccion) throws IOException, FileNotFoundException {
        try {
            FileWriter f=new FileWriter(direccion);
            BufferedWriter b=new BufferedWriter(f);
            b.write(titulo);
            for (int i=0;i<nombres.size();i++) {
                b.write(nombres.get(i)+":"+notas.get(i));
            }
            b.close();
            f.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
