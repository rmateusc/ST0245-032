import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Collections;
public class DataExtraction
{
    static LinkedList <Bee>bees=new LinkedList();
    static ArrayList<Double>lat,longi,alt;
    public DataExtraction (String dir) throws IOException{
        FileReader fr=new FileReader(dir);
        BufferedReader br=new BufferedReader(fr);
        String cadena;
        while ((cadena=br.readLine())!=null){
            splitString(cadena);
        }
    }

    public void splitString(String s){
        String [] str=s.split(",");
        Queue <Double> dob=new LinkedList<Double>();      
        for (int i=0;i<str.length;i++){
            try{
                Double.parseDouble(str[i]);
                dob.add(Double.parseDouble(str[i]));
            }catch(Exception e){                
            }
        }
        double a=(double)dob.poll();
        double b=(double)dob.poll();
        double c=(double)dob.poll();
        lat.add(a);
        longi.add(b);
        alt.add(c);
        Bee bee=new Bee(a,b,c);
        bees.add(bee);
    }

    public void sendBees(){
        Distance.bees(bees);
    }

    public static void getMaxMin(){
        double lata=(double)Collections.max(lat);
        double latb=(double)Collections.min(lat);
        double longia=(double)Collections.max(longi);
        double longib=(double)Collections.min(longi);
        double alta=(double)Collections.max(alt);
        double altb=(double)Collections.min(alt);

        double midLat=(lata+latb)/2;
        double midLongi=(longia+longib)/2;
        double midAlt=(alta+altb)/2;

        for (int i=0;i<bees.size();i++){
            Bee bs=bees.pop();
            if (latb<bs.getLat() && bs.getLat()<midLat){
                if (longib<bs.getLongi() && bs.getLongi()<midLongi){
                    if (altb<bs.getAlt() && bs.getAlt()<midAlt){ //1
                        
                    } else { //2
                        
                    }
                } else {
                    if (altb<bs.getAlt() && bs.getAlt()<midAlt){ //3
                        
                    } else { //4
                        
                    }
                }
            } else {
                if (longib<bs.getLongi() && bs.getLongi()<midLongi){
                    if (altb<bs.getAlt() && bs.getAlt()<midAlt){ //5
                        
                    } else { //6
                        
                    }
                } else {
                    if (altb<bs.getAlt() && bs.getAlt()<midAlt){ //7
                        
                    } else { //8
                        
                    }
                }
            }
        }
    }
}


