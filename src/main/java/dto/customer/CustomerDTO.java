package dto.customer;

import dto.profile.ProfileDTO;
import model.customer.Customer;

public class CustomerDTO {

    protected long id;
    protected String login;
    protected String password;
    protected ProfileDTO profile;

    public CustomerDTO() {
    }

    public CustomerDTO(long id) {
        this.id = id;
    }

    public CustomerDTO(Customer customer){
        this.id = customer.id;
        this.login = customer.getLogin();
        this.password = customer.getPassword();
        this.profile = new ProfileDTO(
                                new CustomerDTO(id),
                                customer.getProfile().getName(),
                                customer.getProfile().getCpf(),
                                customer.getProfile().getPhone(),
                                customer.getProfile().getAnimalType());
    }

    public CustomerDTO(String login, String password) {
        this.login = login;
        this.password = password;
    }

//    public CustomerDTO(long id, String login, String password) {
//        this.id = id;
//        this.login = login;
//        this.password = password;
//    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ProfileDTO getProfile() {
        return profile;
    }

    public void setProfile(ProfileDTO profile) {
        this.profile = profile;
    }
}
