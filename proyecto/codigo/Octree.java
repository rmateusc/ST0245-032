
/**
 * Write a description of class Quadtree here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.ArrayList;
import java.util.LinkedList;
public class Octree
{
    private ArrayList<LinkedList> tabla=new ArrayList(8);
    private int midD,midW,midH;
    public Octree(Area area,LinkedList<Abeja> abejas) {
        midD=area.getDepth()/2;
        midW=area.getWidth()/2;
        midH=area.getHeight()/2;
        for (int i=0;i<abejas.size();++i) {
            hashing(abejas.getFirst());
            abejas.removeFirst();
        }
        nuevoOct();
    }

    private void hashing(Abeja abeja) {
        if (abeja.getPunto().getX()<=midW) {
            if (abeja.getPunto().getZ()<=midD) {
                if (abeja.getPunto().getY()<=midH) {
                    if (tabla.get(0)==null) {
                        LinkedList<Abeja> bees=new LinkedList();
                        bees.add(abeja);
                        tabla.add(0,bees);
                    } else {
                        tabla.get(0).add(abeja);
                    }
                } else {
                    if (tabla.get(1)==null) {
                        LinkedList<Abeja> bees=new LinkedList();
                        bees.add(abeja);
                        tabla.add(1,bees);
                    } else {
                        tabla.get(1).add(abeja);
                    }
                }
            } else {
                if (abeja.getPunto().getY()<=midH) {
                    if (tabla.get(2)==null) {
                        LinkedList<Abeja> bees=new LinkedList();
                        bees.add(abeja);
                        tabla.add(2,bees);
                    } else {
                        tabla.get(2).add(abeja);
                    }
                } else {
                    if (tabla.get(3)==null) {
                        LinkedList<Abeja> bees=new LinkedList();
                        bees.add(abeja);
                        tabla.add(3,bees);
                    } else {
                        tabla.get(3).add(abeja);
                    }
                }
            }
        } else {
            if (abeja.getPunto().getZ()<=midD) {
                if (abeja.getPunto().getY()<=midH) {
                    if (tabla.get(4)==null) {
                        LinkedList<Abeja> bees=new LinkedList();
                        bees.add(abeja);
                        tabla.add(4,bees);
                    } else {
                        tabla.get(4).add(abeja);
                    }
                } else {
                    if (tabla.get(5)==null) {
                        LinkedList<Abeja> bees=new LinkedList();
                        bees.add(abeja);
                        tabla.add(5,bees);
                    } else {
                        tabla.get(5).add(abeja);
                    }
                }
            } else {
                if (abeja.getPunto().getY()<=midH) {
                    if (tabla.get(6)==null) {
                        LinkedList<Abeja> bees=new LinkedList();
                        bees.add(abeja);
                        tabla.add(6,bees);
                    } else {
                        tabla.get(6).add(abeja);
                    }
                } else {
                    if (tabla.get(7)==null) {
                        LinkedList<Abeja> bees=new LinkedList();
                        bees.add(abeja);
                        tabla.add(7,bees);
                    } else {
                        tabla.get(7).add(abeja);
                    }
                }
            }
        }
    }

    public void nuevoOct() {
        int cont=0;
        for (int i=0;i<8;++i) {
            if (tabla.get(i).size()>9) {
                Area are=new Area(midD,midW,midH);
                Octree oct=new Octree(are,tabla.get(i));
            } else {
                
            }
        }
    }
}
