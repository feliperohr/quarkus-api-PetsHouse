package controller.customer;

import dto.customer.CustomerDTO;
import dto.customer.PetOwnerDTO;
import dto.customer.PetSitterDTO;
import io.netty.handler.codec.http.HttpResponseStatus;
import model.customer.PetSitter;
import service.customer.PetSitterService;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("api/customer/petSitter")
public class PetSitterResource {

    @Inject
    PetSitterService service;

    @GET
    @Path("{id}")
    public Response getById(@PathParam("id") long id){
        return Response.ok(service.findCustomerById(id)).build();
    }

    @GET
    @Path("/username/{filter}")
    public Response getAllTaskByFilter(@PathParam("filter") String filter){
        return Response.ok(service.findByLogin(filter)).build();
    }

    @POST
    @Path("new")
    public Response createCustomer(@Valid PetSitterDTO dto) {
        service.persistCustomer(dto);
        return Response.ok().build();
    }

    @POST
    @Path("login")
    public Response login(@Valid CustomerDTO dto) {
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
//    public Response deleteCustomer(long id) {
//        service.deleteCustomer(id);
//        return Response.noContent().build();
//    }
}
