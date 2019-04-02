import java.util.LinkedList;
public class Bee
{
    double latitude;
    double longitude;
    double altitude;
    public Bee (double latitude, double longitude, double altitude){
        this.latitude=latitude;
        this.longitude=longitude;
        this.altitude=altitude;
    }
    
    public double getLat(){
        return latitude;
    }
    
    public double getLongi(){
        return longitude;
    }
    
    public double getAlt(){
        return altitude;
    }
}
