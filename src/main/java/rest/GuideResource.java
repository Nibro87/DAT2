package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import entities.Guide;
import facades.GuideFacade;
import utils.EMF_Creator;

import javax.persistence.EntityManagerFactory;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

@Path("guide")
public class GuideResource {
    private final GuideFacade guideFacade = GuideFacade.getGuideFacade(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();

    @Context
    private UriInfo context;

    @Context
    SecurityContext securityContext;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getInfoForAll() {
        return "{\"msg\":\"Guide info\"}";
    }

    @POST
    @Path("createguide")
    @Produces("application/json")
    @Consumes("application/json")
    public Response createGuide(String jsonString) {

        String guidename;
        String gender;
        String birthyear;
        String profile;
        String image;

        JsonObject json = JsonParser.parseString(jsonString).getAsJsonObject();

        guidename = json.get("guidename").getAsString();
        gender = json.get("gender").getAsString();
        birthyear = json.get("birthyear").getAsString();
        profile = json.get("profile").getAsString();
        image = json.get("image").getAsString();

        Guide guide1 = new Guide(guidename,gender,birthyear,profile,image);
        Guide guide = GuideFacade.createGuide(guide1);

         JsonObject responseJson = new JsonObject();

        responseJson.addProperty("guidename",guidename);

        return Response.ok(new Gson().toJson(responseJson)).build();

    }






}
