package service.customer;

import dto.customer.CustomerDTO;
import dto.customer.PetOwnerDTO;
import model.customer.Customer;
import model.customer.PetOwner;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.validation.Valid;

import java.util.List;


@ApplicationScoped
public class PetOwnerService{


    public PetOwner findCustomerById(long id) {
        return PetOwner.findById(id);
    }

    public List<PetOwner> findAll() {
        return PetOwner.listAll();
    }

    @Transactional
    public void persistCustomer(@Valid CustomerDTO dto) {
        PetOwner petOwner = new PetOwner(dto);
        petOwner.persist();

    }

    @Transactional
    public void deleteCustomer(long id) {
        Customer customer = Customer.findById(id);
        customer.delete();
    }

}
