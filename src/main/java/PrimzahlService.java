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
    public Response halloPlainText(@QueryParam("parameter") int parameterN , @QueryParam("returnForm") int returnForm) {
        System.out.println("Parameter: " + parameterN + " " + "ReturnForm: " + returnForm);



        switch(returnForm){ //Integer.getInteger(returnForm)
            case 1: //String
                return resultAsString(parameterN);

            case 2: //Int Array
                return resultAsIntArray(parameterN);


            case 3:
                return resultAsDatastructure(parameterN);


            default:
                return Response.status(404).build();

        }
    }



    private Response resultAsString(int numberOfPrims) {
        if (CacheService.containsN(numberOfPrims)) {
            String resultFromCache = CacheService.getPrimzahlenAsString(numberOfPrims);

            //Build JSON Response
            JSONArray result = new JSONArray();
            result.put("Result");
            JSONObject jsonObject = new JSONObject().put("String", resultFromCache);
            result.put(jsonObject);

            return Response.status(200).entity(result.toString()).build();
        } else {

            String resultAsString = Primzahl.getPrimzahlenAsString(numberOfPrims);
            CacheService.setPrimzahlenAsString(numberOfPrims, resultAsString);

            //Build JSON Response
            JSONArray result = new JSONArray();
            result.put("Result");
            JSONObject jsonObject = new JSONObject().put("String", resultAsString);
            result.put(jsonObject);

            return Response.status(200).entity(result.toString()).build();

        }
    }



    private Response resultAsIntArray(int numberOfPrims){
        int[] primsInIntArray;
        if (false) {
            //String resultFromCache = CacheService.getPrimzahlenAsString(numberOfPrims);

        } else {

            primsInIntArray = Primzahl.getPrimzahlenAsArray(numberOfPrims);
            CacheService.setPrimzahlenAsIntArray(numberOfPrims, primsInIntArray);

            //Build JSON Response
            JSONArray result = new JSONArray();
            result.put("Result");
            JSONObject jsonObject = new JSONObject().put("IntArray", primsInIntArray);
            result.put(jsonObject);

            return Response.status(200).entity(result.toString()).build();

        }

        return null;
    }

    private Response resultAsDatastructure(int numberOfPrims){


        return null;
    }

}



