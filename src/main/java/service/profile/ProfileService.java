package service.profile;

import dto.profile.ProfileDTO;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import model.customer.Customer;
import model.customer.PetOwner;
import model.profile.Profile;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.validation.Valid;


@ApplicationScoped
public class ProfileService {

    @Transactional
    public ProfileDTO findProfileById(long id) {
        PanacheQuery<PanacheEntityBase> result = Profile.find("customer_id", id);
        Profile profile = result.firstResult();

        return new ProfileDTO(profile);
    }

//    public Profile updateProfile(@Valid Profile profile) {
//        return null;
//    }

    @Transactional
    public void persist(@Valid ProfileDTO dto) {
        Profile profile = new Profile(dto);

        PanacheQuery<PanacheEntityBase> result = Customer.find("id", dto.getCustomer().getId());
        Customer customer = result.firstResult();

        profile.setCustomer(customer);
        profile.persist();

    }


}
