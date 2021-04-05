package controller.customer;

import dto.customer.CustomerDTO;
import dto.customer.PetOwnerDTO;
import dto.customer.PetSitterDTO;
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

//    @GET
//    public Response getAllCustomers() {
//        return Response.ok(service.findAll()).build();
//    }

    @GET
    @Path("/{id}")
    public Response getById(@PathParam("id") long id) {
        return Response.ok(service.findCustomerById(id)).build();
    }

    @POST
    public Response createCustomer(@Valid CustomerDTO dto) {
        service.persistCustomer(dto);
        return Response.ok().build();
    }


//    @DELETE
//    @Path("/{id}")
//    public Response deleteCustomer(long id) {
//        service.deleteCustomer(id);
//        return Response.noContent().build();
//    }
}
