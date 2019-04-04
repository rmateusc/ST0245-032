import java.util.ArrayList;
public class NewOctree
{
    ArrayList <Bee> bees=new ArrayList <Bee>();
    public NewOctree (ArrayList<Bee>bees,double maxlat, double minlat, double maxlon, double minlon, double maxalt, double minalt){
        this.bees=bees;
        double midlat=(maxlat-minlat);
        double midlon=(maxlon-minlon);
        double midalt=(maxalt-minalt);
        
        Bee bs=bees.get(0);
        if (minlat<bs.getLat() && bs.getLat()<midlat){
            if (minlon<bs.getLongi() && bs.getLongi()<midlon){
                if (minalt<bs.getAlt() && bs.getAlt()<midalt){ //1
                    
                } else { //2

                }
            } else {
                if (minalt<bs.getAlt() && bs.getAlt()<midalt){ //3

                } else { //4

                }
            }
        } else {
            if (minlon<bs.getLongi() && bs.getLongi()<midlon){
                if (minalt<bs.getAlt() && bs.getAlt()<midalt){ //5

                } else { //6

                }
            } else {
                if (minalt<bs.getAlt() && bs.getAlt()<midalt){ //7

                } else { //8

                }
            }
        }
    }
}
