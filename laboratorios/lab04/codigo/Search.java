
public class Search
{
    static Directorio direc;
    public Search (Directorio direc){
        this.direc=direc;
    }
    
    public static void buscar(String name){
        boolean f=false;
        for(int i=0; i<direc.info.size();i++){
            if(direc.info.get(i).name.contains(name)){
                f=true;
                int k=Integer.parseInt(direc.info.get(i).b);
                for(int j=i+1;j<direc.info.size();j++){
                    File file=direc.info.get(j);
                    if(k<Integer.parseInt(file.b)){
                        for(int m=1; m<=Integer.parseInt(file.b);m++){
                            System.out.print(" ");
                        }
                        System.out.println("["+file.user+" "+file.size+"] "+file.name);
                    }

                    else{
                        break;
                    }
                }
            }
        }
        if(f==false){
            System.out.println("No existe.");
        }
    }
}
