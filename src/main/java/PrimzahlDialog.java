import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PrimzahlDialog
{

    public static void main (String[] args)
    {
        PrimzahlDialog dialog = new PrimzahlDialog();
        dialog.start();

    }

    private boolean start()
    {
        System.out.println("Hallo,\ndieses Programm berechnet aufsteigend alle Primzahlen, bis zu einem gewünschten Wert");
        System.out.println("Zum Beenden des Programmes kann jederzeit -1 eingegeben werden");
        int primzahlen = -1;
        int eingabeVerarbeitung = 0;
        boolean laeuft = true;
        while(laeuft)
        {
            try
            {
                InputStreamReader isr = new InputStreamReader(System.in);
                BufferedReader br = new BufferedReader(isr);
                System.out.println("Geben Sie bitte ein, wie viele Primzahlen berechnet werden sollen");
                String eingabe = br.readLine();
                primzahlen = Integer.parseInt(eingabe);
                if (primzahlen >= 0)
                {
                    System.out.println("Die ersten " + primzahlen + " Primzahlen sollen berechnet werden.");
                }
                else if(primzahlen == -1)
                {
                    System.out.println("Das Programm wird beendet");
                    return laeuft = false;
                }
                else
                {
                    System.out.println("Bitte positive Zahl zur Berechnung eingeben");
                }

            }
            catch(Throwable e)
            {
                System.out.println("Bitte eine Zahl eingeben");
            }

            try {
                InputStreamReader isr = new InputStreamReader(System.in);
                BufferedReader br = new BufferedReader(isr);
                System.out.println("Geben Sie bitte ein, in welcher Form die Ausgabe erfolgen soll");
                System.out.println("Geben Sie 1 ein, um die Augabe in einem String zu erhalten");
                System.out.println("Geben Sie 2 ein, um die Ausgabe in einem Int Array zu erhalten");
                System.out.println("Geben Sie 3 ein, um die Ausgaben in einem ... zu erhalten");
                String eingabe_2 = br.readLine();
                eingabeVerarbeitung = Integer.parseInt(eingabe_2);
                if (eingabeVerarbeitung >= 0)
                {
                    System.out.println("Die ersten " + primzahlen + " Primzahlen werden ausgegeben.");
                }
                else if(eingabeVerarbeitung == -1)
                {
                    System.out.println("Das Programm wird beendet");
                    return laeuft = false;
                }
                else
                {
                    System.out.println("Bitte positive Zahl zur Berechnung eingeben");
                }
            }
            catch(Throwable e)
            {
                System.out.println("Bitte eine Zahl eingeben");
            }

            if(primzahlen >= 0)
            {
                switch(eingabeVerarbeitung)
                {
                    case 1://Ausgabe als String
                        Primzahl.getPrimzahlenAsString(primzahlen);
                        break;
                    case 2: //Ausgabe als Int Array
                        Primzahl.getPrimzahlenAsArray(primzahlen);
                        break;
                    case 3: //Ausgabe als ....

                    case -1 : //Beenden
                        laeuft = false;

                }

            }
            else
            {
                System.out.println("Bitte positive Zahl eingeben");
            }

        }
        return laeuft;
    }
}
