package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import entities.Trip;
import facades.TripFacade;
import utils.EMF_Creator;

import javax.persistence.EntityManagerFactory;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

@Path("Trip")
public class TripResource {

    private final TripFacade tripFacade = TripFacade.getTripFacade(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();

    @Context
    private UriInfo context;

    @Context
    SecurityContext securityContext;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getInfoForAll() {
        return "{\"msg\":\"Trip info\"}";
    }

    @POST
    @Path("createTrip")
    @Produces("application/json")
    @Consumes("application/json")
    public Response createTrip(String jsonString){
         String tripName;
         String date;
         String time;
         String location;
         String duration;
         String packingList;

        JsonObject json = JsonParser.parseString(jsonString).getAsJsonObject();

        tripName = json.get("tripname").getAsString();
        date = json.get("date").getAsString();
        time = json.get("time").getAsString();
        location = json.get("location").getAsString();
        duration = json.get("duration").getAsString();
        packingList = json.get("packingList").getAsString();

        Trip trip = new Trip(tripName,date,time,location,duration,packingList);
        JsonObject responseJson = new JsonObject();
        responseJson.addProperty("tripname",tripName);

        return Response.ok(new Gson().toJson(responseJson)).build();

    }


}
