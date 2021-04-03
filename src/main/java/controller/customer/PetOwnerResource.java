package controller.customer;

import dto.customer.CustomerDTO;
import dto.customer.PetOwnerDTO;
import model.customer.Customer;
import model.customer.PetOwner;
import service.customer.PetOwnerService;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;


@Path("api/customer")
public class PetOwnerResource {

    @Inject
    PetOwnerService service;

    @GET
    public Response getAllCustomers() {
        return Response.ok(service.findAll()).build();
    }

    @GET
    @Path("/{id}")
    public Response getById(@PathParam("id") long id){
        return Response.ok(service.findCustomerById(id)).build();
    }

    @POST
    public Response createCustomer(@Valid PetOwnerDTO dto) {
        service.persistCustomer(dto);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteHero(
            @PathParam("id") long id) {
        service.deleteCustomer(id);
        return Response.noContent().build();
    }
}
