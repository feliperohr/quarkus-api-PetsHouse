package model.customer;

import dto.customer.CustomerDTO;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import model.profile.Profile;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Customer extends PanacheEntity {

    protected String login;
    protected String password;

    @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL)
    protected Profile profile;

    public Customer(CustomerDTO dto){
        this.login = dto.getLogin();
        this.password = dto.getPassword();
    }

    public Customer() {
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

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }


}
