package dto.customer;

import dto.profile.ProfileDTO;
import model.customer.Customer;

public abstract class CustomerDTO {

    private long id;
    private String login;
    private String password;
//    private ProfileDTO profileDTO;

    public CustomerDTO() {
    }

    public CustomerDTO(String login, String password) {
        this.login = login;
        this.password = password;
//        this.profileDTO = profileDTO;
    }

//    public CustomerDTO(long id, String login, String password) {
//        this.id = id;
//        this.login = login;
//        this.password = password;
////        this.profileDTO = profileDTO;
//    }

//    public CustomerDTO(Customer customer) {
//        this.id = customer.id;
//        this.login = customer.getLogin();
//        this.password = customer.getPassword();
//
////        this.profileDTO = new ProfileDTO(customer.getProfile());
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

//    public ProfileDTO getProfileDTO() {
//        return profileDTO;
//    }
//
//    public void setProfileDTO(ProfileDTO profileDTO) {
//        this.profileDTO = profileDTO;
//    }
}
