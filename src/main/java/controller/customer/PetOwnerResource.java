package controller.customer;


import dto.customer.PetOwnerDTO;

import io.netty.handler.codec.http.HttpResponseStatus;
import service.customer.PetOwnerService;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;


@Path("api/customer/petOwner")
public class PetOwnerResource {

    @Inject
    PetOwnerService service;

    @GET
    @Path("{id}")
    public Response getById(@PathParam("id") long id){
        return Response.ok(service.findCustomerById(id)).build();
    }

    @POST
    @Path("new")
    public Response createCustomer(@Valid PetOwnerDTO dto) {
        service.persistCustomer(dto);
        return Response.ok().build();
    }

    @POST
    @Path("login")
    public Response login(@Valid PetOwnerDTO dto) {
        dto = service.login(dto);
        if(dto == null){
            return Response
                    .status(HttpResponseStatus.BAD_REQUEST.code())
                    .entity("Dados de login inválidos.")
                    .build();
        }else {
            return Response.ok(dto).build();
        }

    }

//    @DELETE
//    @Path("/{id}")
//    public Response deleteHero(
//            @PathParam("id") long id) {
//        service.deleteCustomer(id);
//        return Response.noContent().build();
//    }
}
