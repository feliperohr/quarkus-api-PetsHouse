package controller.profile;

import dto.profile.ProfileDTO;
import service.profile.ProfileService;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/api/profile")
public class ProfileResource {

    @Inject
    ProfileService service;

    @GET
    @Path("/{id}")
    public Response getProfileById(@PathParam("id") long id) {
        return Response.ok(service.findProfileById(id)).build();
    }

    @POST
    public Response create(@Valid ProfileDTO dto) {
        service.persist(dto);
        return Response.ok().build();
    }

}
