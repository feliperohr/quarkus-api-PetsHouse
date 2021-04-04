package service.profile;

import dto.profile.ProfileDTO;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import model.customer.Customer;
import model.profile.Profile;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;


@ApplicationScoped
public class ProfileService {

    public List<Profile> findAll() {
        return Profile.listAll();
    }

    public Profile findProfileById(long id) {
        return Profile.findById(id);
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
