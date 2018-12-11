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


    static final String webContextPath = "/primzahl";

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPrims(@QueryParam("parameter") int parameterN , @QueryParam("returnForm") int returnForm) {
        System.out.println("Request" +"Count prims: " + parameterN + " " + "ReturnForm: " + returnForm);


        switch(returnForm){ //Integer.getInteger(returnForm)
            case 1: //String
                return resultAsString(parameterN);

            case 2: //Int Array
                return resultAsIntArray(parameterN);


            case 3:
                return resultAsDatastructure(parameterN);


            default:
                JSONArray result = new JSONArray();
                result.put("Result");
                JSONObject jsonObject = new JSONObject().put("Message", "Invalid Parameter");
                result.put(jsonObject);
                return Response.status(404).entity(result.toString()).build();

        }
    }



    private Response resultAsString(int numberOfPrims) {
        String resultAsString = getPrimAsString(numberOfPrims);
        JSONArray result = new JSONArray();
        result.put("Result");
        JSONObject jsonObject = new JSONObject().put("String", resultAsString);
        result.put(jsonObject);

        return Response.status(200).entity(result.toString()).build();

    }



    private Response resultAsIntArray(int numberOfPrims){
        int [] primsInIntArray = getPrimAsIntArray(numberOfPrims);
        JSONArray result = new JSONArray();
        result.put("Result");
        JSONObject jsonObject = new JSONObject().put("Integer Array", primsInIntArray);
        result.put(jsonObject);

        return Response.status(200).entity(result.toString()).build();
    }

    private Response resultAsDatastructure(int numberOfPrims){
        String resultAsString = getPrimAsString(numberOfPrims);
        int[] resultAsArray = getPrimAsIntArray(numberOfPrims);


        JSONArray result = new JSONArray();
        result.put("Result");

        JSONObject jsonString = new JSONObject().put("String", resultAsString);
        result.put(jsonString);

        JSONObject jsonIntArray = new JSONObject().put("IntArray", resultAsArray);
        result.put(jsonIntArray);


        return Response.status(200).entity(result.toString()).build();
    }


    private String getPrimAsString(int numberOfPrims) {
        if (CacheService.isInCacheString(numberOfPrims)) {
            return CacheService.getPrimzahlenAsString(numberOfPrims);

        } else {

            String resultAsString = Primzahl.getPrimzahlenAsString(numberOfPrims);
            CacheService.setPrimzahlenAsString(numberOfPrims, resultAsString);

            return resultAsString;
        }
    }

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



