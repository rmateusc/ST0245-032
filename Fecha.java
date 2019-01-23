public class Fecha {
    private int dia;
    private int mes;
    private int anyo;
    public Fecha (int d, int m, int a){
        if(d>0 && m>0 && m<=12){
            if (((m==1 || m==3 || m==5 || m==7 || m==8 || m==10 || m==12) && d<=31) || ((m==4 || m==6 || m==9 || m==11) && d<=30) || (m==2 && d<=28)) {
                dia=d;
                mes=m;
                anyo=a;
            } else {
                System.out.println ("La fecha no es valida");
            }
        } else {
            System.out.println ("La fecha no es valida");
        }
    }

    public int getDia () {
        return dia;
    }

    public int getMes () {
        return mes;
    }

    public int getAnyo () {
        return anyo;
    }

    public String toString (){
        return dia+"/"+mes+"/"+anyo;
    }

    public int compararFecha (Fecha otra) {
        if (anyo>otra.getAnyo()) {
            return 1;
        } else if (otra.getAnyo()>anyo) {
            return -1;
        } else {
            if (mes>otra.getMes()) {
                return 1;
            } else if (otra.getMes()>mes) {
                return -1;
            } else {
                if (dia>otra.getDia()) {
                    return 1;
                } else if (otra.getDia()>dia) {
                    return -1;
                } else {
                    return 0;
                }
            }
        }
    }
}