import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;


@Path (PrimzahlService.webContextPath)
public class PrimzahlService {



        static final String webContextPath = "/primzahl";

        @GET @Produces(MediaType.TEXT_PLAIN)
        public String halloPlainText(@QueryParam("parameter") String parameterN) {

            if(CacheService.containsN(parameterN)){
                return "From Cache " +  CacheService.getPrimzahlenAsString(parameterN);
            }else {

                String result = Primzahl.getPrimzahlenAsString(Integer.parseInt(parameterN));
                CacheService.setPrimzahlenAsString(parameterN, result);
                return result;
            }

        }


//        @GET @Produces( MediaType.TEXT_HTML )
//        public String halloHtml( @QueryParam("name") String name )
//        {
//            return "<html><title>HelloWorld</title><body><h2>Html: Hallo " + name + "</h2></body></html>";
//        }


}



