
/**
 * Write a description of class Buscador here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner;
import java.io.FileNotFoundException;
public class Buscador
{
    public static void main (String [] args) throws FileNotFoundException {
        try {
            boolean salir=false;
            while (salir==false) {
                System.out.println("Hola!\nBienvenido al buscador de notas finales de la Universidad Eafit\nAqui podras encontrar las notas de todos los estudiantes y materias por semestre\nPara hacer una consulta acerca de una materia pulse la tecla 1\nPara hacer una consulta acerca de un estudiante pulse la tecla 2\nPara salir del menu principal pulse la tecla 3");
                Scanner r=new Scanner(System.in);
                int res=r.nextInt();
                if (res==1) {
                    Archivo ar=new Archivo();
                    System.out.println("Has escogido busqueda por materia\nDigite el nombre de la materia: ");
                    r=new Scanner(System.in);
                    String mat=r.nextLine();
                    System.out.println("Ahora escriba el semestre y el año que desea buscar: \nIMPORTANTE: Debe escrbir el semestre de la forma año-numero de semestre\nEjemplo: 2019-2\nDe lo contrario las notas no seran encontradas");            System.out.println("IMPORTANTE: Debe escrbir el semestre de la forma año-numero de semestre");
                    r=new Scanner(System.in);
                    String sem=r.nextLine();
                    ar.principal(mat,sem,1);
                    System.out.println("Su busqueda ha terminado\n¿Desea continuar con su busqueda?\nSi asi lo desea digite un numero mayor o igual a cero\nSi no lo es presion un numero negativo");
                    r=new Scanner(System.in);
                    int s=r.nextInt();
                    if (s<0) salir=true; System.out.println("Gracias por utilizar nuestro sistema de busqueda, que tenga un buen dia!");
                } else if (res==2) {
                    Archivo ar=new Archivo();
                    System.out.println("Has escogido busqueda por estudiante\nDigite el nombre de la materia: ");
                    r=new Scanner(System.in);
                    String mat=r.nextLine();
                    System.out.println("Ahora escriba el semestre y el año que desea buscar: \nIMPORTANTE: Debe escrbir el semestre de la forma año-numero de semestre\nEjemplo: 2019-2\nDe lo contrario las notas no seran encontradas");            System.out.println("IMPORTANTE: Debe escrbir el semestre de la forma año-numero de semestre");
                    r=new Scanner(System.in);
                    String sem=r.nextLine();
                    ar.principal(mat,sem,2);
                    System.out.println("Su busqueda ha terminado\n¿Desea continuar con su busqueda?\nSi asi lo desea digite un numero mayor o igual a cero\nSi no lo es presion un numero negativo");
                    r=new Scanner(System.in);
                    int s=r.nextInt();
                    if (s<0) salir=true; System.out.println("Gracias por utilizar nuestro sistema de busqueda, que tenga un buen dia!");
                } else if (res!=3) {
                    System.out.println("El numero digitado no se encuentra entre las opciones, sera redirigido al menu principal para intentarlo de nuevo");
                } else {
                    salir=true;
                    System.out.println("Gracias por utilizar nuestro sistema de busqueda, que tenga un buen dia!");
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
