import java.util.LinkedList;
public class Distance
{
    static LinkedList <Bee> collisionBees=new LinkedList();
    
    public static void bees (LinkedList bees){        
        distanceBees((Bee)bees.pop(),(Bee)bees.pop());
    }
    
    public static void distanceBees (Bee a,Bee b){
        double lat=Math.pow((a.getLat()-b.getLat()),2);
        double longi=Math.pow((a.getLongi()-b.getLongi()),2);
        double alt=Math.pow((a.getAlt()-b.getLongi()),2);
        double dist=Math.sqrt(lat+longi+alt);
        if (dist<100){
            collisionBees.add(a);
            collisionBees.add(b);
        }
    } 
    
    
}
