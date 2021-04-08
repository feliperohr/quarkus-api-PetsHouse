package service.customer;


import dto.customer.CustomerDTO;

import dto.customer.PetOwnerDTO;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import model.customer.Customer;
import model.customer.PetOwner;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.validation.Valid;



@ApplicationScoped
public class PetOwnerService{


    public CustomerDTO findByLogin(String login) {
        PanacheQuery<PanacheEntityBase> result = Customer.find("login", login);
        Customer customer = result.firstResult();
        return new CustomerDTO(customer.id);
    }

    public CustomerDTO findCustomerById(long id) {
        PanacheQuery<PanacheEntityBase> result = PetOwner.find("id", id);
        PetOwner customer = result.firstResult();
        return new CustomerDTO(customer);
    }

    @Transactional
    public void persistCustomer(@Valid PetOwnerDTO dto) {
        PetOwner petOwner = new PetOwner(dto);
        petOwner.persist();
    }

    public CustomerDTO login(CustomerDTO dto) {
        PanacheQuery<PanacheEntityBase> result = PetOwner.find("login", dto.getLogin());
        PetOwner petOwner = result.firstResult();

        if (petOwner != null && petOwner.getPassword().equals(dto.getPassword())) {
            return new CustomerDTO(petOwner);
//            return new PetOwnerDTO(petOwner.id, petOwner.getLogin());
        } else {
            return null;
        }
    }


}
