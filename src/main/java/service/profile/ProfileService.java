package service.profile;

import model.profile.Profile;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;


@ApplicationScoped
@Transactional
public class ProfileService {

    public List<Profile> findAll() {
        return Profile.listAll();
    }

    public Profile findProfileById(Long id) {
        return Profile.findById(id);
    }

    public Profile updateProfile(@Valid Profile profile) {
        return null;
    }

    public void persist(@Valid Profile profile) {
        Profile.persist(profile);
    }


}
