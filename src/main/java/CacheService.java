import java.util.HashMap;

public class CacheService {

    private static HashMap<Integer ,String> primzahlenAsString = new HashMap<Integer, String>();
    private static HashMap<Integer, int[]> primzahlenAsIntArray = new HashMap<Integer, int[]>();
    private static HashMap<Integer ,String> primzahlenAsDatastructure = new HashMap<Integer, String>();


    public static boolean containsN(int n){
        if(primzahlenAsString.containsKey(n)){
            return true;
        }else {
            return false;
        }
    }

    public static String getPrimzahlenAsString(int n){
        return primzahlenAsString.get(n);
    }

    public static void setPrimzahlenAsString( int n, String primzahlen){
        primzahlenAsString.put(n,primzahlen);
    }

    public static void setPrimzahlenAsIntArray(int n, int[] primsInInt){
        primzahlenAsIntArray.put(n,primsInInt);
    }


}
