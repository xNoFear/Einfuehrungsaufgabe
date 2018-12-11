
import java.util.ArrayList;
/**
  Logik Klasse der Einfuehrungsaufgabe 3
  @author Kevin Engelhardt
 */
public class Primzahl {

    //Statische Methode, um zu erkennen, ob int-Zahl eine Primzahl ist
    private static boolean istPrimzahl(int n)
    {
        //Wenn Zahl kleiner 1 ist, wird eine Exception geworfen
        if (n <= 1 )
        {
            throw new RuntimeException("Zahl muss groesser 1 sein");
        }
        //For-Schleife durchlaeuft Zahlen von 2 -> n/2
        for(int i = 2; i <= n/2; i++)
        {
            //if-Bedingung, ob i mod n gleich 0 ist
            if(n%i == 0)
            {

                return false;

            }
        }
        return true;
    }
    //Statische Methode, um Primzahlen in Liste zu schreiben
    private static ArrayList<Integer> primzahlInListe(int n)
    {
        ArrayList<Integer> liste = new ArrayList<Integer>();
        int i = 2;
        while(liste.size() < n)
        {
            //Wenn Zahl eine Primzahl ist, wird sie der Liste hinzugefuegt
            if (istPrimzahl(i) == true)
            {
                liste.add(i);
            }
            i++;
        }
        return liste;
    }
    //Statische Methode, die die Liste in einen String umwandelt
    public static String wrapIntoString(ArrayList<Integer> liste)
    {

        String rueckgabe = "";
        //Liste wird durchlaufen und als String zurueckgegeben
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
    //Statische Methode, um die Liste in ein int Array umzuwandeln
    public static int[] wrapIntoArray(ArrayList<Integer> liste)
    {
        //Int Array wird mit der Groesse angelegt, die die ArrayList hat
        int[] intArray = new int[liste.size()];

        for(int i = 0; i < liste.size(); i++)
        {
            intArray[i] += liste.get(i);
        }
        return intArray;
    }

    //Statische Methode ruft die Methode wrapIntoString auf
    public static String getPrimzahlenAsString(int n){

        return wrapIntoString(primzahlInListe(n));
    }
    //Statische Methode ruft die Methode getPrimzahlenAsArray auf
    public static int[] getPrimzahlenAsArray(int n)
    {
        return wrapIntoArray(primzahlInListe(n));
    }

}
