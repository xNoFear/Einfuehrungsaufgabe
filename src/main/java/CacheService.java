import java.util.concurrent.ConcurrentHashMap;

public class CacheService {

    //Es werden zwei HashMaps erstellt, die die ausgerechneten Primzahlen als Value speichern.
    //Key ist bei beiden Maps Integer n; n entspricht Anzahl Primzahlen die zurückgeben werden

    private static ConcurrentHashMap<Integer ,String> primzahlenAsString = new ConcurrentHashMap<Integer, String>();
    private static ConcurrentHashMap<Integer, int[]> primzahlenAsIntArray = new ConcurrentHashMap<Integer, int[]>();


    //Prüft ob der String schon in der HashMap ist
    public static boolean isInCacheString(int n){
        if(primzahlenAsString.containsKey(n)){
            return true;
        }else {
            return false;
        }
    }

    //Püft, ob das int[] Array in der HashMap ist
    public static boolean isInCacheIntArray(int n){
        if(primzahlenAsIntArray.contains(n)){
            return true;
        }else {
            return false;
        }
    }


    //Gibt den String aus der HashMap zurueck
    public static String getPrimzahlenAsString(int n){
        System.out.println("From Cache:" + n);
        return primzahlenAsString.get(n);
    }

    //Gibt das int[] Array zurueck
    public static int[] getPrimsAsIntArray(int n) {
        return primzahlenAsIntArray.get(n);
    }



    //Schreibt den String in die HashMap
    public static void setPrimzahlenAsString( int n, String primzahlen){
        System.out.println(n + " is added to cache");
        primzahlenAsString.put(n,primzahlen);
    }

    //Schreibt das int Array in die HashMap
    public static void setPrimzahlenAsIntArray(int n, int[] primsInInt){
        System.out.println(n + " is added to cache");
        primzahlenAsIntArray.put(n,primsInInt);
    }




}
