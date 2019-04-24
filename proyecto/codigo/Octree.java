/**
 * Esta es nuestra estructura de datos, Octree. Esta se encargara de posicionar 
 * cada abeja en un cuadrante en especfico, para asi poder determinar si se choca 
 * o no. Su principal funcion sera dividirse en ocho cuadrantes, de manera 3D. 
 * Si se encuentra mas de una abeja en un cuadrante, este cuadrante se dividira
 * en multiples subOctrees, encontrados en los limites de este, hasta que la 
 * abeja se encuentre sola, o dentro de un cuadrante de diagonal de menos de 
 * 100 metros de longitud. Esto se hace para asegurar que todas la abejas dentro 
 * de este cuadrante se estan en peligro de chocarse.
 * @author: Daniel Otero Gomez, Rafael Mateus Carrion. 
 * @version: 4/7/2019/A
 * @see Octree
 * @see Bee
 */
import java.util.ArrayList;
import java.util.LinkedList;
public class Octree
{
    private double midD,midW,midH;
    /**
     * Este sera el metodo que representara el Octree, sobre este metodo se realizara toda la recursion, aqui se asignara cada abeja a 
     * su respectivo sector del Octree, representado por un ArrayList de 8 espacios (cada uno representando cada sector), donde sera 
     * guardado en un LinkedList. El proceso de decidir en que sector va cada abeja lo hara el metodo hashing. Despues de que se ubique
     * cada abeja en un sector se pasara a crear las subidvisiones del Octree con el metodo nuevoOctree. Antes de pasar a crear las nuevas
     * subdivisiones del Octree se pregunta si la diagonal octual es menor a los 100 metros, si asi lo es pasara a imprimir las abejas 
     * ubicadas en los sectores donde hay mas de una abeja.
     * @param ArrayList<Bee> abejas: ArrayList con todas la abejas
     * @param ArrayList<Double> mins: son los valores minimos de coordenadas, a los que se le sumaran otros parametros para determinar 
     * la posicion de la abeja. Tomelo como si fuera uno de los vertices del octree.
     * @param double midD: sera el valor de la latitud que se encuentra en la mitad de la abeja con menor latitud y la abeja con mayor latitud
     * @param double midW: sera el valor de la longitud que se encuentra en la mitad de la abeja con menor longitid y la abeja con mayor longitud
     * @param double midD: sera el valor de la altitud que se encuentra en la mitad de la abeja con menor altitud y la abeja con mayor altitud
     * @see hashing
     * @see nuevoOct
     */
    public void octree (LinkedList<Bee> abejas,ArrayList<Double> mins,double midD,double midW,double midH) {
        this.midD=midD;
        this.midW=midW;
        this.midH=midH;
        ArrayList<LinkedList<Bee>> octree=new ArrayList(8); //Octree
        for (int i=0;i<8;++i) {
            LinkedList<Bee> ab=new LinkedList();
            octree.add(ab);
        }
        for (int i=0;i<abejas.size();++i) {
            Bee abeja=abejas.poll();
            int sector=hashing(abeja,mins);
            octree.get(sector).addFirst(abeja);
        }
        double ph=Math.sqrt(Math.pow((midD)*111325,2)+Math.pow((midW)*111325,2)); //Primera hipotenusa
        double diagonal=Math.sqrt(Math.pow(ph,2)+Math.pow((midH),2)); 
        if (diagonal>100) {
            for (int i=0;i<8;++i) {
                if (octree.get(i).size()>1) {
                    nuevoOctree(octree.get(i),mins,i);
                }
            }
        } else {
            for (int i=0;i<8;++i) {
                if (octree.get(i).size()>0) choque(octree.get(i));
            }
        }
    }

    /**
     * Este metodo se encargara de recibir cada abeja que se encuentra en el octree, y ubicarla en un determinado sector de la estructura 
     * de datos, de manera que lo ubicara en el espacio del ArrayList tabla correspondiente al sector en el que esta posicionada la abeja. 
     * Determinara el sector comparando los minimos, es decir, los vertices del Octree, mas los valores medios del Octree con el que se esta
     * trabajando.
     * @param Bee abeja: abeja que sera ubicada
     * @param ArrayList<Double> mins: este ArrayList contendra los minimos, es decir, el vertice compuesto por cada coordenada. Este parametro
     * es necesario para poder hacer una ubicacion adecuada de cada abeja, debido a que la utilizacion de este parametro nos simplificara 
     * el codigo de manera que solo se le tendra que ser sumado un valor para determinar si una abeja se encuentra en un sector o en otro.
     * @return numero del sector en el que estara ubicado.
     */
    private int hashing(Bee abeja,ArrayList<Double> mins) {
        if (abeja.getLatitude()<=mins.get(0)+midD) {
            if (abeja.getLongitude()<=mins.get(1)+midW) {
                if (abeja.getAltitude()<=mins.get(2)+midH) {
                    return 0;
                } else {
                    return 1;
                }
            } else {
                if (abeja.getAltitude()<=mins.get(2)+midH) {
                    return 2;
                } else {
                    return 3;
                }
            }
        } else {
            if (abeja.getLongitude()<=mins.get(1)+midW) {
                if (abeja.getAltitude()<=mins.get(2)+midH) {
                    return 4;
                } else {
                    return 5;
                }
            } else {
                if (abeja.getAltitude()<=mins.get(2)+midH) {
                    return 6;
                } else {
                    return 7;
                }
            }
        }
    }

    /**
     * Este metodo se encarga de hacer la recursion, con respecto al metodo principal octree. Recibe los parametro correspondientes a las 
     * abejas ubicada en el sector, y los vertices de este, que se encuentran en el ArrayLis mins. Con el paramtero sector identifican 
     * como deben ser redefinidos los vertices del siguiente suboctree, ya que estos varian por sector.
     * @param LinkedList<Bee> abejas: abejas del sector correspondiente
     * @param ArrayList<Double> mins: son los valores minimos de coordenadas, a los que se le sumaran otros parametros para redefinir los
     * vertices del siguiente Octree. Tomelo como si fuera uno de los vertices del octree.
     * @param int sector: sector en el cual esta ubicado
     */
    public void nuevoOctree(LinkedList<Bee> abejas,ArrayList<Double> mins,int sector) {
        if (sector==0) {
            octree(abejas,mins,midD/2,midW/2,midH/2);
        } else if (sector==1) {
            double nuevoH=mins.get(2)+midH;
            mins.remove(2);
            mins.add(2,nuevoH);
            octree(abejas,mins,midD/2,midW/2,midH/2);
        } else if (sector==2) {
            double nuevoW=mins.get(1)+midW;
            mins.remove(1);
            mins.add(1,nuevoW);
            octree(abejas,mins,midD/2,midW/2,midH/2);
        } else if (sector==3) {
            double nuevoH=mins.get(2)+midH;
            mins.remove(2);
            mins.add(2,nuevoH);
            double nuevoW=mins.get(1)+midW;
            mins.remove(1);
            mins.add(1,nuevoW);
            octree(abejas,mins,midD/2,midW/2,midH/2);
        } else if (sector==4) {
            double nuevoD=mins.get(0)+midD;
            mins.remove(0);
            mins.add(0,nuevoD);
            octree(abejas,mins,midD/2,midW/2,midH/2);
        } else if (sector==5) {
            double nuevoD=mins.get(0)+midD;
            mins.remove(0);
            mins.add(0,nuevoD);
            double nuevoH=mins.get(2)+midH;
            mins.remove(2);
            mins.add(2,nuevoH);
            octree(abejas,mins,midD/2,midW/2,midH/2);
        } else if (sector==6) {
            double nuevoD=mins.get(0)+midD;
            mins.remove(0);
            mins.add(0,nuevoD);
            double nuevoW=mins.get(1)+midW;
            mins.remove(1);
            mins.add(1,nuevoW);
            octree(abejas,mins,midD/2,midW/2,midH/2);
        } else {
            double nuevoD=mins.get(0)+midD;
            mins.remove(0);
            mins.add(0,nuevoD);
            double nuevoW=mins.get(1)+midW;
            mins.remove(1);
            mins.add(1,nuevoW);
            double nuevoH=mins.get(2)+midH;
            mins.remove(2);
            mins.add(2,nuevoH);
            octree(abejas,mins,midD/2,midW/2,midH/2);
        }
    }

    /**
     * Este metodo se encarga de imprimir las coordenadas de todas la abejas 
     * del sector, ya que si se llego a llamar a este metodo es 
     * porque todas estan en peligro de chocarse.
     * @param LinkedList<Bee> abejas: abejas del sector
     */
    public void choque(LinkedList<Bee> abejas) {
        //System.out.println("Las abejas en las siguientes coordenadas estan en peligro de chocarse");
        for (Bee abeja:abejas) {
            System.out.println(abejas.poll().getLatitude()+","+abejas.poll().getLongitude()+","+abejas.poll().getAltitude());
        }
    }

}
