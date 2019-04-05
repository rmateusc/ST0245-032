/**
 * @rmateusc @daoterog
 */
import java.util.ArrayList;
import java.util.LinkedList;
public class Octree
{
    private ArrayList<ArrayList> tabla=new ArrayList(8);
    private double midD,midW,midH,diagonal;
    public Octree(ArrayList<Bee> abejas,ArrayList<Double> mins,double midD,double midW,double midH) {
        for (int i=0;i<8;++i) {
            ArrayList<Bee> ab=new ArrayList();
            tabla.add(ab);
        }
        this.midD=midD;
        this.midW=midW;
        this.midH=midH;
        double ph=Math.sqrt(Math.pow(midD*111325,2)+Math.pow(midW*111325,2));
        diagonal=Math.sqrt(Math.pow(ph,2)+Math.pow(midH,2));
        if (diagonal>100) {
            for (int i=0;i<abejas.size();++i) {
                hashing(abejas.get(i),mins);
            }
            nuevoOct(mins);
        } else {
            if (abejas.size()>1) choque(abejas);
            else System.out.println("ABEJA SOLAA");
        }
    }

    public void choque(ArrayList<Bee> abejas) {
        System.out.println("Las abejas en las siguientes coordenadas estan en peligro de chocarse");
        for (int i=0;i<abejas.size();++i) {
            System.out.println(abejas.get(i).getLatitude()+","+abejas.get(i).getLongitude()+","+abejas.get(i).getAltitude());
        }
    }

    private void hashing(Bee abeja,ArrayList<Double> mins) {
        if (abeja.getLatitude()<=mins.get(0)+midW) {
            if (abeja.getLongitude()<=mins.get(1)+midD) {
                if (abeja.getAltitude()<=mins.get(2)+midH) {
                    tabla.get(0).add(abeja);
                } else {
                    tabla.get(1).add(abeja);
                }
            } else {
                if (abeja.getAltitude()<=mins.get(2)+midH) {
                    tabla.get(2).add(abeja);
                } else {
                    tabla.get(3).add(abeja);
                }
            }
        } else {
            if (abeja.getLongitude()<=mins.get(1)+midD) {
                if (abeja.getAltitude()<=mins.get(2)+midH) {
                    tabla.get(4).add(abeja);
                } else {
                    tabla.get(5).add(abeja);
                }
            } else {
                if (abeja.getAltitude()<=mins.get(2)+midH) {
                    tabla.get(6).add(abeja);
                } else {
                    tabla.get(7).add(abeja);
                }
            }
        }
    }

    public void nuevoOct(ArrayList<Double> mins) {
        for (int i=0;i<8;++i) {
            if (tabla.get(i).size()!=0) {
                if (i==0) {
                    Octree oct=new Octree(tabla.get(i),mins,midD/2,midW/2,midH/2);
                } else if (i==1) {
                    Octree oct=new Octree(tabla.get(i),mins,midD/2,midW/2,3*midH/2);
                } else if (i==2) {
                    Octree oct=new Octree(tabla.get(i),mins,midD/2,3*midW/2,midH/2);
                } else if (i==3) {
                    Octree oct=new Octree(tabla.get(i),mins,midD/2,3*midW/2,3*midH/2);
                } else if (i==4) {
                    Octree oct=new Octree(tabla.get(i),mins,3*midD/2,midW/2,midH/2);
                } else if (i==5) {
                    Octree oct=new Octree(tabla.get(i),mins,3*midD/2,midW/2,3*midH/2);
                } else if (i==6) {
                    Octree oct=new Octree(tabla.get(i),mins,3*midD/2,3*midW/2,midH/2);
                } else {
                    Octree oct=new Octree(tabla.get(i),mins,3*midD/2,3*midW/2,3*midH/2);
                }
            } 
        }
    }
}
