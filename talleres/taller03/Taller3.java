
/**
 * @daoterog @rmateusc
 */
public class Taller3
{
    public static void torresDeHannoi (int n) {
        torresDeHannoiAux(n,1,2,3);
    }

    private static void torresDeHannoiAux (int n, int origen, int intermedio, int destino) {
        if(n==1) {
            System.out.println("Disk "+ n + " from "+ origen + " to "+ destino);
        } else{
            torresDeHannoiAux(n-1, origen, destino, intermedio);
            torresDeHannoiAux(1, origen, intermedio, destino);
            torresDeHannoiAux(n-1, intermedio, origen ,destino);
        }
    }

    public static void permutation (String str) {
        permutationAux("",str);
    }

    public static void permutationAux(String prefix, String str) {
        if (str.equals("")) {
            System.out.println(prefix);
            AdvancedEncryptionStandard.desencriptarArchivo(prefix);
        } else {
            for (int i=0;i<str.length();i++) {
                if (i==0) {
                    permutationAux(prefix+str.charAt(i),str.substring(1));
                } else if (i==str.length()-1) {
                    permutationAux(prefix+str.charAt(i),str.substring(0,i));
                } else {
                    permutationAux(prefix+str.charAt(i),str.substring(0,i)+str.substring(i+1));
                }
            }
        }
    }

    public static void permutacionConRepeticion (String str) {
        permutationConRepeticionAux("",str);
    }

    public static void permutationConRepeticionAux(String prefix, String str) {
        if (prefix.length()==str.length()) {
            System.out.println(prefix);
        } else {
            for (int i=0;i<str.length();i++) {
                permutationConRepeticionAux(prefix+str.charAt(i),str);
            }
        }
    }

    public static void combinations(String s) { 
        combinationsAux("", s); 
    }

    private static void combinationsAux(String prefix, String s) {  
        if (s.length()==0) {
            if (prefix.length()!=0) {
                System.out.println(prefix);
            } 
        } else {
            if (s.length()>1) {
                combinationsAux(prefix+s.charAt(0),s.substring(1));
                if (s.length()>1) {
                    combinationsAux(prefix,s.substring(1));
                } else {
                    combinationsAux(prefix,"");
                }
            } else {
                combinationsAux(prefix+s.charAt(0),"");
                combinationsAux(prefix,"");
            }
        }
    }

    public static void pruebaFloodfill () {
        int [][] m={{0,1,0,1,0,1},{1,0,1,0,1,0},{0,1,0,1,0,1},{1,0,1,0,1,0}};
        System.out.println("Matriz original");
        imprimirMatriz(m);
        System.out.println("Matriz Modificada");
        floodFill(m,1,5);
    }

    /**@param lienzo es la matriz que se vera modificada con cad iteracion
     * @param relleno es el numero que sera cambiado
     * @param pintar es el numero por el cual sera cambiado el relleno
     */
    public static void floodFill(int [][] lienzo,int relleno,int pintar) {
        floodFillAux(lienzo,relleno,pintar,0,0);
    }

    /**
     * @param lienzo es la matriz que se vera modificada con cad iteracion
     * @param relleno es el numero que sera cambiado
     * @param pintar es el numero por el cual sera cambiado el relleno
     * @param i sera el indice de las filas, que nos ayudara a pasar por toda la matriz
     * @param j sera el indice de las columnas, que nos ayudara a pasar por toda la matriz
     */
    public static void floodFillAux (int [][] lienzo,int relleno,int pintar,int i,int j) {
        if (i==lienzo.length-1 && j==lienzo[i].length-1) {
            imprimirMatriz(lienzo);
        } else if (lienzo[i][j]==relleno) {
            lienzo[i][j]=pintar;
            if (i<=lienzo.length-1 && j<lienzo[i].length-1) {
                floodFillAux(lienzo,relleno,pintar,i,j+1);
            } else if (i<=lienzo.length-1 && j==lienzo[i].length-1) {
                floodFillAux(lienzo,relleno,pintar,i+1,0);
            }
        } else {
            if (i<=lienzo.length-1 && j<lienzo[i].length-1) {
                floodFillAux(lienzo,relleno,pintar,i,j+1);
            } else if (i<=lienzo.length-1 && j==lienzo[i].length-1) {
                floodFillAux(lienzo,relleno,pintar,i+1,0);
            }
        }
    }

    /**
     * @param m sera la matriz que sera impresa
     */
    public static void imprimirMatriz(int [][] m) {
        for (int i=0;i<m.length;i++) {
            for (int j=0;j<m[i].length;j++) {
                System.out.print(m[i][j]);
            }
            System.out.println();
        }
    }
}
