import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Collections; 
public class Reader
{
    String [] str;
    ArrayList<Double> lat = new ArrayList();
    ArrayList<Double> lon = new ArrayList();
    ArrayList<Double> alt = new ArrayList();
    ArrayList<Bee> bees=new ArrayList();
    public Reader (String dir) throws IOException{
        try (BufferedReader br=new BufferedReader(new FileReader(dir))){
            String line;
            while ((line=br.readLine())!=null){ //si da
                splitString(line);
            } 
        } catch (IOException e){
            e.printStackTrace();
        }
        getMaxMin(lat,lon,alt);
    }    

    public void splitString(String s){
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

    public void getMaxMin(ArrayList lat, ArrayList lon, ArrayList alt){
        double minlat=(double)Collections.min(lat);
        double maxlat=(double)Collections.max(lat);

        double minlon=(double)Collections.min(lon);
        double maxlon=(double)Collections.max(lon);

        double minalt=(double)Collections.min(alt);
        double maxalt=(double)Collections.max(alt);

        ArrayList<Double> mins=new ArrayList();
        mins.add(minlat);mins.add(minlon);mins.add(minalt);
        Octree octree= new Octree(bees,mins,(maxlat-minlat)/2,(maxlon-minlon)/2,(maxalt-minalt)/2);
    }
}
