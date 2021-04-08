package service.customer;

import dto.customer.CustomerDTO;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import model.customer.Customer;
import model.customer.PetOwner;
import model.customer.PetSitter;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@ApplicationScoped
public class PetSitterService {

    public CustomerDTO findByLogin(String login) {
        PanacheQuery<PanacheEntityBase> result = Customer.find("login", login);
        Customer customer = result.firstResult();
        return new CustomerDTO(customer.id);
    }

    public CustomerDTO findCustomerById(long id) {
        PanacheQuery<PanacheEntityBase> result = PetSitter.find("id", id);
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

    public CustomerDTO login(CustomerDTO dto) {
        PanacheQuery<PanacheEntityBase> result = PetSitter.find("login", dto.getLogin());
        PetSitter petSitter = result.firstResult();

        if (petSitter != null && petSitter.getPassword().equals(dto.getPassword())) {
            return new CustomerDTO(petSitter);
        } else {
            return null;
        }
    }
}
