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
public class Octree
{
    private ArrayList<ArrayList> tabla=new ArrayList(8);
    private double midD,midW,midH;
    /**
     * Este es el constructor de nuestra estructura de datos, este se encargara de llenar el ArrayList tabla, con sus respetivos ArrayList
     * de Bee, asi como de relacionar cada los parametros midD, midW y midH con su respectivo atributo. Desde este metodo se llamara el metodo
     * hashing para cada abeja, para asi poder ubicar a cada abeja en su respectivo sector. Despues llamara el metodo nuevoOct, poder 
     * determinar si se puede realizar otro Octree o no.
     * @param ArrayList<Bee> abejas: ArrayList con todas la abejas
     * @param ArrayList<Double> mins: son los valores minimos de coordenadas, a los que se le sumaran otros parametros para determinar 
     * la posicion de la abeja. Tomelo como si fuera uno de los vertices del octree.
     * @param double midD: sera el valor de la latitud que se encuentra en la mitad de la abeja con menor latitud y la abeja con mayor latitud
     * @param double midW: sera el valor de la longitud que se encuentra en la mitad de la abeja con menor longitid y la abeja con mayor longitud
     * @param double midD: sera el valor de la altitud que se encuentra en la mitad de la abeja con menor altitud y la abeja con mayor altitud
     * @see hashing
     * @see nuevoOct
     */
    public Octree(ArrayList<Bee> abejas,ArrayList<Double> mins,double midD,double midW,double midH) {
        for (int i=0;i<8;++i) {
            ArrayList<Bee> ab=new ArrayList();
            tabla.add(ab);
        }
        this.midD=midD;
        this.midW=midW;
        this.midH=midH;
        for (int i=0;i<abejas.size();++i) {
            hashing(abejas.get(i),mins);
        }
        nuevoOct(mins);
    }

    /**
     * Este metodo se encarga de imprimir las coordenadas de todas la abejas 
     * del conjunto de datos, ya que si se llego a llamar a este metodo es 
     * porque todas estan en peligro de chocarse.
     */
    public void choque(ArrayList<Bee> abejas) {
        System.out.println("Las abejas en las siguientes coordenadas estan en peligro de chocarse");
        for (int i=0;i<abejas.size();++i) {
            System.out.println(abejas.get(i).getLatitude()+","+abejas.get(i).getLongitude()+","+abejas.get(i).getAltitude());
        }
    }

    /**
     * Este metodo se encargara de recibir cada abeja que se encuentra en el octree, y ubicarla en un determinado sector de la estructura 
     * de datos, de manera que lo ubicara en el espacio del ArrayList tabla correspondiente al sector en el que esta posicionada la abeja
     * @param Bee abeja: abeja que sera ubicada
     * @param ArrayList<Double> mins: este ArrayList contendra los minimos, es decir, el vertice compuesto por cada coordenada. Este parametro
     * es necesario para poder hacer una ubicacion adecuada de cada abeja, debido a que la utilizacion de este parametro nos simplificara 
     * el codigo de manera que solo se le tendra que ser sumado un valor para determinar si una abeja se encuentra en un sector o en otro.
     */
    private void hashing(Bee abeja,ArrayList<Double> mins) {
        if (abeja.getLatitude()<=mins.get(0)+midD) {
            if (abeja.getLongitude()<=mins.get(1)+midW) {
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
            if (abeja.getLongitude()<=mins.get(1)+midW) {
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

    /**
     * Este metodo se encargara de decidir si la diagonal de los sectores del siguiente Octree seran menores o mayores a 100metros de longitud.
     * Esto se hace ya que si la diagonal es menor a 100 metros esto significa que todas las abejas ubicadas en ese sector estan en peligro de
     * chocarse la una con la otra. Si la diagonal no es menor a 100 metros procede a crear un nuevo Octree con todas las abejas ubicadas
     * en cada sector. Antes de hacer eso, identifica que sector es donde sera creado un nuevo Octree para asi poder redefinir los vertices 
     * de cada nueva estructura. 
     * @param ArrayList<Double> mins: son los valores minimos de coordenadas, a los que se le sumaran otros parametros para redefinir los
     * vertices del siguiente Octree. Tomelo como si fuera uno de los vertices del octree.
     */
    public void nuevoOct(ArrayList<Double> mins) {
        double ph=Math.sqrt(Math.pow((midD/2)*111325,2)+Math.pow((midW/2)*111325,2));
        double diagonal=Math.sqrt(Math.pow(ph,2)+Math.pow((midH/2),2));
        if (diagonal>100) {
            for (int i=0;i<8;++i) {
                if (tabla.get(i).size()>0) {
                    if (i==0) {
                        Octree oct=new Octree(tabla.get(i),mins,midD/2,midW/2,midH/2);
                    } else if (i==1) {
                        double nuevoH=mins.get(2)+midH;
                        mins.remove(2);
                        mins.add(2,nuevoH);
                        Octree oct=new Octree(tabla.get(i),mins,midD/2,midW/2,midH/2);
                    } else if (i==2) {
                        double nuevoW=mins.get(1)+midW;
                        mins.remove(1);
                        mins.add(1,nuevoW);
                        Octree oct=new Octree(tabla.get(i),mins,midD/2,midW/2,midH/2);
                    } else if (i==3) {
                        double nuevoH=mins.get(2)+midH;
                        mins.remove(2);
                        mins.add(2,nuevoH);
                        double nuevoW=mins.get(1)+midW;
                        mins.remove(1);
                        mins.add(1,nuevoW);
                        Octree oct=new Octree(tabla.get(i),mins,midD/2,midW/2,midH/2);
                    } else if (i==4) {
                        double nuevoD=mins.get(0)+midD;
                        mins.remove(0);
                        mins.add(0,nuevoD);
                        Octree oct=new Octree(tabla.get(i),mins,midD/2,midW/2,midH/2);
                    } else if (i==5) {
                        double nuevoD=mins.get(0)+midD;
                        mins.remove(0);
                        mins.add(0,nuevoD);
                        double nuevoH=mins.get(2)+midH;
                        mins.remove(2);
                        mins.add(2,nuevoH);
                        Octree oct=new Octree(tabla.get(i),mins,midD/2,midW/2,midH/2);
                    } else if (i==6) {
                        double nuevoD=mins.get(0)+midD;
                        mins.remove(0);
                        mins.add(0,nuevoD);
                        double nuevoW=mins.get(1)+midW;
                        mins.remove(1);
                        mins.add(1,nuevoW);
                        Octree oct=new Octree(tabla.get(i),mins,midD/2,midW/2,midH/2);
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
                        Octree oct=new Octree(tabla.get(i),mins,midD/2,midW/2,midH/2);
                    }
                } 
            }
        } else {
            for (int i=0;i<8;++i) {
                choque(tabla.get(i));
            }
        }
    }
}

