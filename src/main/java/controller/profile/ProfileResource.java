package controller.profile;

import model.profile.Profile;
import service.profile.ProfileService;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/api/profile")
public class ProfileResource {

    @Inject
    ProfileService service;

    @GET
    public Response getAll() {
        return Response.ok(service.findAll()).build();
    }

    @POST
    @Transactional
    public Response create(
            @Valid Profile p) {
        service.persist(p);
        return Response.ok().build();
    }

}
