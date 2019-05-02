/**
 * Write a description of class Main here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Main
{
    public void main (){
        try {
            Archivo lea=new Archivo();
            lea.leer("D:/Backup Daniel/Perfil/OneDrive/Documents/Daniel/Estructuras Datos y Algoritmos/Lab5/datasetmedallo.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
