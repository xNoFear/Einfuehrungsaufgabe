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
    public Response halloPlainText(@QueryParam("parameter") String parameterN) {


        if (CacheService.containsN(parameterN)) {
            String resultFromCache = CacheService.getPrimzahlenAsString(parameterN);

            //Build JSON Response
            JSONArray result = new JSONArray();
            result.put("Result");
            JSONObject jsonObject = new JSONObject().put("String", resultFromCache);
            result.put(jsonObject);

            return Response.status(200).entity(result.toString()).build();
        } else {

            String resultAsString = Primzahl.getPrimzahlenAsString(Integer.parseInt(parameterN));
            CacheService.setPrimzahlenAsString(parameterN, resultAsString);

            //Build JSON Response
            JSONArray result = new JSONArray();
            result.put("Result");
            JSONObject jsonObject = new JSONObject().put("String", resultAsString);
            result.put(jsonObject);

            return Response.status(200).entity(result.toString()).build();
        }
    }

}



