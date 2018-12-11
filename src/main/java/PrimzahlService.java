import org.json.JSONArray;
import org.json.JSONObject;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path (PrimzahlService.webContextPath)
public class PrimzahlService {

    //Endpoint der Rest-Anfrage
    static final String webContextPath = "/primzahl";
    //HTTP Verb
    @GET
    //Rueckgabe als Json Format
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPrims(@QueryParam("parameter") int parameterN , @QueryParam("returnForm") int returnForm) //Query Param liest Inhalt der Uri Anfrage aus
     {
        System.out.println("Request" +"Count prims: " + parameterN + " " + "ReturnForm: " + returnForm);


        switch(returnForm){ //Integer.getInteger(returnForm)
            case 1: //String
                return resultAsString(parameterN);

            case 2: //Int Array
                return resultAsIntArray(parameterN);


            case 3://Datenstruktur
                return resultAsDatastructure(parameterN);


            default://Falls keine der 3 cases eingegeben wird, wird im json Format eine Fehlermeldung zurueckgegeben
                JSONArray result = new JSONArray();
                result.put("Result");
                JSONObject jsonObject = new JSONObject().put("Message", "Invalid Parameter");
                result.put(jsonObject);
                return Response.status(404).entity(result.toString()).build();

        }
    }



    //Es wird eine Anfrage auf "Ergebnis als String" gestellt
    private Response resultAsString(int numberOfPrims) {
        //Methode getPrimAsString wird aufgerufen
        String resultAsString = getPrimAsString(numberOfPrims);
        JSONArray result = new JSONArray();
        result.put("Result");
        //Inhalt der oberen Methode wird in ein Json Array geschrieben
        JSONObject jsonObject = new JSONObject().put("String", resultAsString);
        result.put(jsonObject);

        return Response.status(200).entity(result.toString()).build();

    }


    //Es wird eine Anfrage auf "Ergebnis als Int-Array" gestellt
    private Response resultAsIntArray(int numberOfPrims){
        //Methode PrimAsIntArray wird aufgerufen
        int [] primsInIntArray = getPrimAsIntArray(numberOfPrims);
        JSONArray result = new JSONArray();
        result.put("Result");
        //Inhalt der oberen Methode wird in ein Json Array geschrieben
        JSONObject jsonObject = new JSONObject().put("Integer Array", primsInIntArray);
        result.put(jsonObject);

        return Response.status(200).entity(result.toString()).build();
    }

    //Es wird eine Anfrage auf "Ergebnis als Datenstruktur" gestellt
    private Response resultAsDatastructure(int numberOfPrims){
        //Beide Methoden zur Erzeugung der Datenstruktur werden aufgerufen
        String resultAsString = getPrimAsString(numberOfPrims);
        int[] resultAsArray = getPrimAsIntArray(numberOfPrims);

        JSONArray result = new JSONArray();
        result.put("Result");
        //Inhalt der oberen Methode getPrimAsString wird in ein Json Array geschrieben
        JSONObject jsonString = new JSONObject().put("String", resultAsString);
        result.put(jsonString);
        //Inhalt der Methode getPrimAsIntArray wird in ein Json Array geschrieben
        JSONObject jsonIntArray = new JSONObject().put("IntArray", resultAsArray);
        result.put(jsonIntArray);
        //Der Anfrage an den Server wird der Status 200 = "Alles in Ordnung" uebergeben, Json Object wird in einen String umgewandelt und Response wird generiert
        return Response.status(200).entity(result.toString()).build();
    }

    //Es wird geprueft, ob die eingegebene Zahl bereits abgefragt wurde, sollte dies der Fall sein, wird keine neue Berechnung durchgefuehrt
    private String getPrimAsString(int numberOfPrims) {
        if (CacheService.isInCacheString(numberOfPrims)) {
            return CacheService.getPrimzahlenAsString(numberOfPrims);

        } else {

            String resultAsString = Primzahl.getPrimzahlenAsString(numberOfPrims);
            CacheService.setPrimzahlenAsString(numberOfPrims, resultAsString);

            return resultAsString;
        }
    }
    //Es wird geprueft, ob die eingegebene Zahl bereits abgefragt wurde, sollte dies der Fall sein, wird keine neue Berechnung durchgefuehrt
    private int[] getPrimAsIntArray(int numberOfPrims){
        if (CacheService.isInCacheIntArray(numberOfPrims)) {
            return CacheService.getPrimsAsIntArray(numberOfPrims);

        } else {

            int [] primsInIntArray = Primzahl.getPrimzahlenAsArray(numberOfPrims);
            CacheService.setPrimzahlenAsIntArray(numberOfPrims, primsInIntArray);

            return primsInIntArray;

        }
    }
}



