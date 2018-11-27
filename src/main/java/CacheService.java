import java.util.HashMap;

public class CacheService {

    private static HashMap<String ,String> primzahlenAsString = new HashMap<String, String>();
    private static HashMap<Integer[] ,String> primzahlenAsIntArray = new HashMap<Integer[], String>();
    private static HashMap<Integer[] ,String> primzahlenAsDatastructure = new HashMap<Integer[], String>();


    public static boolean containsN(String n){
        if(primzahlenAsString.containsKey(n)){
            return true;
        }else {
            return false;
        }
    }

    public static String getPrimzahlenAsString(String n){
        return primzahlenAsString.get(n);
    }

    public static void setPrimzahlenAsString( String n, String primzahlen){
        primzahlenAsString.put(n,primzahlen);
    }
}
