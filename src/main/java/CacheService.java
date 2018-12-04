import java.util.concurrent.ConcurrentHashMap;

public class CacheService {

    private static ConcurrentHashMap<Integer ,String> primzahlenAsString = new ConcurrentHashMap<Integer, String>();
    private static ConcurrentHashMap<Integer, int[]> primzahlenAsIntArray = new ConcurrentHashMap<Integer, int[]>();


    public static boolean isInCacheString(int n){
        if(primzahlenAsString.containsKey(n)){
            return true;
        }else {
            return false;
        }
    }

    public static boolean isInCacheIntArray(int n){
        if(primzahlenAsIntArray.contains(n)){
            return true;
        }else {
            return false;
        }
    }



    public static String getPrimzahlenAsString(int n){
        System.out.println("From Cache:" + n);
        return primzahlenAsString.get(n);
    }

    public static int[] getPrimsAsIntArray(int n) {
        return primzahlenAsIntArray.get(n);
    }


    public static void setPrimzahlenAsString( int n, String primzahlen){
        System.out.println(n + " is add to cache");
        primzahlenAsString.put(n,primzahlen);
    }

    public static void setPrimzahlenAsIntArray(int n, int[] primsInInt){
        System.out.println(n + " is add to cache");
        primzahlenAsIntArray.put(n,primsInInt);
    }




}
