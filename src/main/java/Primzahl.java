
import java.util.ArrayList;

public class Primzahl {

    private static boolean istPrimzahl(int n)
    {
        if (n <= 1 )
        {
            throw new RuntimeException("Zahl muss groesser 1 sein");
        }

        for(int i = 2; i <= n/2; i++)
        {
            if(n%i == 0)
            {

                return false;

            }
        }
        return true;
    }

    private static ArrayList<Integer> primzahlInListe(int n)
    {
        ArrayList<Integer> liste = new ArrayList<Integer>();
        int i = 2;
        while(liste.size() < n)
        {
            if (istPrimzahl(i) == true)
            {
                liste.add(i);
            }
            i++;
        }
        return liste;
    }
    public static String wrapIntoString(ArrayList<Integer> liste)
    {

        String rueckgabe = "";
        for(int i = 0; i < liste.size(); i++) {
            if (i != liste.size()-1) {
                rueckgabe += liste.get(i) + ",";
            }
            else
            {
                rueckgabe += liste.get(i);
            }
        }

        return rueckgabe;
    }

    public static int[] wrapIntoArray(ArrayList<Integer> liste)
    {
        int[] intArray = new int[liste.size()];

        for(int i = 0; i < liste.size(); i++)
        {
            intArray[i] += liste.get(i);
        }
        return intArray;
    }
    

    public static String getPrimzahlenAsString(int n){

        return wrapIntoString(primzahlInListe(n));
    }
    public static int[] getPrimzahlenAsArray(int n)
    {
        return wrapIntoArray(primzahlInListe(n));
    }

}
