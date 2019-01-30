
/**
 * @daoterog @rmateusc
 */
public class Taller2
{
    public static int gcd (int p, int q) {
        if (p>q) {
            int restante=p%q;
            if (restante==0) {
                return q;
            } else {
                return gcd(restante,q);
            }
        } else if (q>p){
            int restante=q%p;
            if (restante==0) {
                return p;
            } else {
                return gcd(p,restante);
            }
        } else {
            return p;
        }
    }

    public static boolean SumaGrupo (int start, int [] nums, int targets) {
        if (start>=nums.length) {
            if (targets==0) return true;
            else return false;
        } else if (nums[start]>targets) {
            return SumaGrupo(start+1,nums,targets);
        } else if (targets-nums[start]==0) {
            return true;
        } else {
            return SumaGrupo(start,nums,targets-nums[start]) || SumaGrupo(start+1,nums,targets);
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
}
