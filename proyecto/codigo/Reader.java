import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Collections; 
/**
 * Esta clase se encarga de leer un archivo de texto que contiene un numero 
 * indeterminado de abejas, identificando sus coordenadas y almacenandolas en 
 * en un ArrayList de objetos Bee. Asi mismo, se encarga de guardar las 
 * coordenadas de cada abeja en otros ArrayList correspondientes a cada 
 * coordenada, para asi poder pasarselo a la clase Octree, la cual los necesita
 * para funcionar.
 * @author: Daniel Otero Gomez, Rafael Mateus Carrion. 
 * @version: 4/7/2019/A
 * @see Octree
 * @see Bee
 */
public class Reader
{
    //Arreglos que guardan abejas y coordenadas
    ArrayList<Double> lat = new ArrayList();
    ArrayList<Double> lon = new ArrayList();
    ArrayList<Double> alt = new ArrayList();
    ArrayList<Bee> bees=new ArrayList();
    /**
     * Este metodo se encarga de recibir una direccion de archivo guardado en 
     * el computador y leer las lineas para asi poder pasarselas a un metodo 
     * que pueda guardar su informacion en su respetiv ArrayList
     * @param String dir: direccion del archivo guardado
     * @see splitString
     */
    public void leer (String dir) throws IOException{
        try (BufferedReader br=new BufferedReader(new FileReader(dir))){
            String line;
            while ((line=br.readLine())!=null){ //si da
                createBee(line);
            } 
        } catch (IOException e){
            e.printStackTrace();
        }
        getMaxMin();
    }    

    /**
     * Este metodo se encarga de recibir cada linea de coordenadas que se le es 
     * otorgada por el metodo leer, aqui guardara las coordenadas en sus respectivos
     * ArrayList, creara la abeja con sus coordenadas y la agregara a su ArrayList.
     * @param String s: linea de coordenadas
     */
    public void createBee(String s){
        String [] str=s.split(",");  
        try{
            lat.add(Double.parseDouble(str[0]));
            lon.add(Double.parseDouble(str[1]));
            alt.add(Double.parseDouble(str[2]));
            Bee bee=new Bee(Double.parseDouble(str[0]),Double.parseDouble(str[1]),Double.parseDouble(str[2]));
            bees.add(bee);
        } catch (Exception e){
        }
    }

    /**
     * Este metodo se encarga de obtener los minimos y los maximos de cada 
     * coordenada, para asi poder estimar una la longitud de las diagonales 
     * que seran creadas en la primera dicivision del Octree, y determinar si 
     * vale la pena crear un Octree con este conjunto de datos. Asi mismo, 
     * este es el ultimo paso de esta clase antes de empezar a trabajar
     * con nuestra estructura de datos Octree. Si no vale la pena crear el 
     * Octree (debido a que la longitud de sus diagonales sera menor a 100m)
     * se pasara a imprimir todas las coordenadas de las abejas del conjunto
     * de datos
     * @see choque
     */
    public void getMaxMin(){
        double minlat=(double)Collections.min(lat);
        double maxlat=(double)Collections.max(lat);

        double minlon=(double)Collections.min(lon);
        double maxlon=(double)Collections.max(lon);

        double minalt=(double)Collections.min(alt);
        double maxalt=(double)Collections.max(alt);

        ArrayList<Double> mins=new ArrayList();
        mins.add(minlat);mins.add(minlon);mins.add(minalt);
        double midD=(minlat-maxlat)/2;
        double midW=(maxlon-minlon)/2;
        double midH=(maxalt-minalt)/2;
        double ph=Math.sqrt(Math.pow((midD)*111325,2)+Math.pow((midW)*111325,2));
        double diagonal=Math.sqrt(Math.pow(ph,2)+Math.pow((midH),2));
        if (diagonal>100) {
            Octree octree= new Octree(bees,mins,midD,midW,midH);
        } else {
            choque();
        }
    }
    
    /**
     * Este metodo se encarga de imprimir las coordenadas de todas la abejas 
     * del conjunto de datos, ya que si se llego a llamar a este metodo es 
     * porque todas estan en peligro de chocarse.
     */
    public void choque() {
        System.out.println("Las abejas en las siguientes coordenadas estan en peligro de chocarse");
        for (int i=0;i<bees.size();++i) {
            System.out.println(bees.get(i).getLatitude()+","+bees.get(i).getLongitude()+","+bees.get(i).getAltitude());
        }
    }
}
