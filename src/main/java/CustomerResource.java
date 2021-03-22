import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Set;

@Path("/users")
public class CustomerResource {

    private Set<Customer> customers = Collections.newSetFromMap(Collections.synchronizedMap(new LinkedHashMap<>()));

    public CustomerResource() {
        customers.add(new PetOwner("TESTE", "123"));
        customers.add(new PetSitter("login2", "1234"));
        customers.add(new PetSitter("login3", "1234"));
    }

    @GET
    public Set<Customer> list() {
        return customers;
    }

    @POST
    public Set<Customer> add(Customer c) {
        customers.add(new PetOwner("lklklklk", "7676"));
        return customers;
    }

//    @DELETE
//    public Set<Customer> delete(Customer c) {
//        customers.removeIf(existingCustomer -> existingCustomer.id == c.id);
//        return customers;
//    }
}
