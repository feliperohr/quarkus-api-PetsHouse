package service.customer;

import dto.customer.CustomerDTO;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import model.customer.Customer;
import model.customer.PetSitter;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@ApplicationScoped
public class PetSitterService {

    public CustomerDTO findCustomerById(long id) {
        PanacheQuery<PanacheEntityBase> result = Customer.find("id", id);
        Customer customer = result.firstResult();

        return new CustomerDTO(customer);
    }

    public List<PetSitter> findAll() {
        return PetSitter.listAll();
    }

    @Transactional
    public void persistCustomer(@Valid CustomerDTO dto) {
        PetSitter petSitter = new PetSitter(dto);
        petSitter.persist();

    }

    @Transactional
    public void deleteCustomer(long id) {
        Customer customer = Customer.findById(id);
        customer.delete();
    }
}
