package controller.customer;

import dto.customer.CustomerDTO;
import dto.customer.PetOwnerDTO;
import dto.customer.PetSitterDTO;
import model.customer.PetSitter;
import service.customer.PetSitterService;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("api/customer/petSitter")
public class PetSitterResource {

    @Inject
    PetSitterService service;

    @GET
    public Response getAllCustomers() {
        return Response.ok(service.findAll()).build();
    }

    @GET
    @Path("/{id}")
    public Response getById(long id) {
        return Response.ok(service.findCustomerById(id)).build();
    }

    @POST
    public Response createCustomer(@Valid PetSitterDTO dto) {
        service.persistCustomer(dto);
        return Response.ok().build();
    }


    @DELETE
    @Path("/{id}")
    public Response deleteCustomer(long id) {
        service.deleteCustomer(id);
        return Response.noContent().build();
    }
}
