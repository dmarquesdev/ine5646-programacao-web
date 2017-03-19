package ine5646.exemplorest;

import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("divisores/{numero}")
public class DivisorREST {

    @GET
    @Produces("application/json")
    public String divisores(@PathParam("numero") int numero) {
        List<Integer> listaDivisores = null;

        listaDivisores = new ArrayList<>();
        
        for (int i = 1; i <= numero / 2; i++) {
            if (numero % i == 0) {
                listaDivisores.add(i);
            }
        }
        
        if(!listaDivisores.contains(numero)) {
            listaDivisores.add(numero);
        }

        return new Gson().toJson(listaDivisores);
    }
}
